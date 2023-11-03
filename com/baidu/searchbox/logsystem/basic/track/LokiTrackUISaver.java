package com.baidu.searchbox.logsystem.basic.track;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.qf1;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class LokiTrackUISaver {
    public static final String SEPERATOR = "\t";
    public static final String SEPERATOR_ARROR = "->";
    public static final char SEPERATOR_ENTER = '\n';
    public static final String TAG = "LokiTrackUISaver";
    public static final String TEMP_FILE_SUFFIX = ".tmp";
    public static final String TRACE_DIR = "tracedir";
    public static boolean mFirstSaveTempFile = true;
    public static File mTempTraceFile;
    public static ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.MINUTES, new LinkedBlockingQueue());
    public static Track.OnTrackUIListener mTrackUiListener = new Track.OnTrackUIListener() { // from class: com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver.1
        @Override // com.baidu.searchbox.track.Track.OnTrackUIListener
        public void onAddTrackUI(final TrackUI trackUI) {
            LokiTrackUISaver.mExecutor.execute(new Runnable() { // from class: com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver.1.1
                @Override // java.lang.Runnable
                public void run() {
                    LokiTrackUISaver.saveToFile(trackUI);
                }
            });
        }
    };

    public static Track.OnTrackUIListener getTrackUiListener() {
        return mTrackUiListener;
    }

    public static File getTempTraceFile() {
        File file = new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), TRACE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (mTempTraceFile == null) {
            mTempTraceFile = new File(file, qf1.b() + ".tmp");
        }
        return mTempTraceFile;
    }

    public static boolean saveFinalTraceFile(@NonNull File file) {
        File tempTraceFile = getTempTraceFile();
        if (tempTraceFile == null || !tempTraceFile.exists() || FileUtils.copyFile(tempTraceFile, file) <= 0) {
            return false;
        }
        return true;
    }

    public static void saveToFile(TrackUI trackUI) {
        LinkedList<TrackUI> allTrackUIs;
        File tempTraceFile = getTempTraceFile();
        if (mFirstSaveTempFile) {
            mFirstSaveTempFile = false;
            if (Utility.createNewEmptyFile(tempTraceFile) && (allTrackUIs = Track.getInstance().getAllTrackUIs()) != null && allTrackUIs.size() > 0) {
                for (int i = 0; i < allTrackUIs.size(); i++) {
                    TrackUI trackUI2 = allTrackUIs.get(i);
                    if (trackUI2 != trackUI) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "perTrack = " + trackUI2String(trackUI2));
                        }
                        FileUtils.saveToFile(trackUI2String(trackUI2) + '\n', tempTraceFile, true);
                    }
                }
            }
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "uitrackStr = " + trackUI2String(trackUI));
        }
        FileUtils.saveToFile(trackUI2String(trackUI) + '\n', tempTraceFile, true);
    }

    @NonNull
    public static String trackUI2String(@NonNull TrackUI trackUI) {
        StringBuilder sb = new StringBuilder(TrackUI.getTime(trackUI.getTimeStamp()));
        sb.append("\t");
        sb.append(trackUI.getTimeStamp());
        sb.append("\t");
        sb.append(trackUI.getActivityPage());
        sb.append(trackUI.getActivityPageTag());
        if (!TextUtils.isEmpty(trackUI.getFragmentPage())) {
            sb.append("->");
            sb.append(trackUI.getFragmentPage());
            if (!TextUtils.isEmpty(trackUI.getFragmentPageTag())) {
                sb.append(trackUI.getFragmentPageTag());
            }
        }
        sb.append("\t");
        sb.append(trackUI.getEvent());
        return sb.toString();
    }
}
