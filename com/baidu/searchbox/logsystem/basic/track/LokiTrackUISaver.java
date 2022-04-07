package com.baidu.searchbox.logsystem.basic.track;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.logsys.LogPipelineSingleton;
import com.baidu.searchbox.logsystem.util.Utility;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ub1;
import java.io.File;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class LokiTrackUISaver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SEPERATOR = "\t";
    public static final String SEPERATOR_ARROR = "->";
    public static final char SEPERATOR_ENTER = '\n';
    public static final String TAG = "LokiTrackUISaver";
    public static final String TEMP_FILE_SUFFIX = ".tmp";
    public static final String TRACE_DIR = "tracedir";
    public static ThreadPoolExecutor mExecutor = null;
    public static boolean mFirstSaveTempFile = true;
    public static File mTempTraceFile;
    public static Track.OnTrackUIListener mTrackUiListener;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1818829833, "Lcom/baidu/searchbox/logsystem/basic/track/LokiTrackUISaver;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1818829833, "Lcom/baidu/searchbox/logsystem/basic/track/LokiTrackUISaver;");
                return;
            }
        }
        mExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        mTrackUiListener = new Track.OnTrackUIListener() { // from class: com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.track.Track.OnTrackUIListener
            public void onAddTrackUI(TrackUI trackUI) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, trackUI) == null) {
                    LokiTrackUISaver.mExecutor.execute(new Runnable(this, trackUI) { // from class: com.baidu.searchbox.logsystem.basic.track.LokiTrackUISaver.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$0;
                        public final /* synthetic */ TrackUI val$trackUI;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, trackUI};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$trackUI = trackUI;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                LokiTrackUISaver.saveToFile(this.val$trackUI);
                            }
                        }
                    });
                }
            }
        };
    }

    public LokiTrackUISaver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static File getTempTraceFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            File file = new File(LogPipelineSingleton.getInstance().getLogStoreDirSupplier().get(), TRACE_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (mTempTraceFile == null) {
                mTempTraceFile = new File(file, ub1.b() + ".tmp");
            }
            return mTempTraceFile;
        }
        return (File) invokeV.objValue;
    }

    public static Track.OnTrackUIListener getTrackUiListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? mTrackUiListener : (Track.OnTrackUIListener) invokeV.objValue;
    }

    public static boolean saveFinalTraceFile(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            File tempTraceFile = getTempTraceFile();
            return tempTraceFile != null && tempTraceFile.exists() && FileUtils.copyFile(tempTraceFile, file) > 0;
        }
        return invokeL.booleanValue;
    }

    public static void saveToFile(TrackUI trackUI) {
        LinkedList<TrackUI> allTrackUIs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, trackUI) == null) {
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
    }

    @NonNull
    public static String trackUI2String(@NonNull TrackUI trackUI) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, trackUI)) == null) {
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
        return (String) invokeL.objValue;
    }
}
