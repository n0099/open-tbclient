package com.baidu.searchbox.logsystem.basic.track;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.pyramid.runtime.multiprocess.a;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class LokiTrackUISaver {
    public static final char SEPERATOR_ENTER = '\n';
    private static final String TAG = "LokiTrackUISaver";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private static final String TRACE_DIR = "tracedir";
    private static File mTempTraceFile;
    private static boolean mFirstSaveTempFile = true;
    private static ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.MINUTES, new LinkedBlockingQueue());
    private static Track.OnTrackUIListener mTrackUiListener = new Track.OnTrackUIListener() { // from class: com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver.1
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

    public static void saveToFile(TrackUI trackUI) {
        LinkedList<TrackUI> allTrackUIs;
        int i = 0;
        File tempTraceFile = getTempTraceFile();
        if (mFirstSaveTempFile) {
            mFirstSaveTempFile = false;
            if (Utility.createNewEmptyFile(tempTraceFile) && (allTrackUIs = Track.getInstance().getAllTrackUIs()) != null && allTrackUIs.size() > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 >= allTrackUIs.size()) {
                        break;
                    }
                    TrackUI trackUI2 = allTrackUIs.get(i2);
                    if (trackUI2 != trackUI) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "perTrack = " + trackUI2.toString());
                        }
                        FileUtils.saveToFile(trackUI2.toString() + '\n', tempTraceFile, true);
                    }
                    i = i2 + 1;
                }
            }
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "uitrackStr = " + trackUI.toString());
        }
        FileUtils.saveToFile(trackUI.toString() + '\n', tempTraceFile, true);
    }

    private static File getTempTraceFile() {
        File file = new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), TRACE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (mTempTraceFile == null) {
            mTempTraceFile = new File(file, a.getProcessName() + TEMP_FILE_SUFFIX);
        }
        return mTempTraceFile;
    }

    public static boolean saveFinalTraceFile(@NonNull File file) {
        File tempTraceFile = getTempTraceFile();
        return tempTraceFile != null && tempTraceFile.exists() && FileUtils.copyFile(tempTraceFile, file) > 0;
    }
}
