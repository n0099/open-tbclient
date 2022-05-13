package com.baidu.searchbox.anr.impl;

import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.anr.collector.ANRCollector;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import com.baidu.searchbox.anr.utils.Utils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.github.anrwatchdog.ANRError;
import com.repackage.b81;
import com.repackage.ik9;
import com.repackage.z71;
import java.io.File;
@Singleton
@Service
/* loaded from: classes2.dex */
public class ANRMonitor implements IANRMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANR_HAPPENT_TIME_LIMIT = 20000;
    public static final long ANR_TIMEOUT_MS = 25000;
    public static final String DEFAULT_ALL_STACK_TRACES_NAME = "all_stack_traces.txt";
    public static final int DEFAULT_LOGCAT_MAX_LEN = 2000;
    public static final String DEFAULT_LOGCAT_NAME = "anr_logcat.txt";
    public static final String DEFAULT_TRACES_PATH = "/data/anr/traces.txt";
    public static final int DEFAULT_WATCHDOG_ANR_TIMEOUT = 5000;
    public static final String SEPARATOR = "\r\n";
    public static String TAG = "Ruka";
    public static String sANRTimeStamp;
    public static long sLastTimes;
    public transient /* synthetic */ FieldHolder $fh;
    public ik9 mANRWatchDog;
    public int mAnrWatchTimeOut;
    public FileObserver mFileObserver;
    public boolean mMonitorStarted;
    public z71 nativeANRListener;

    /* loaded from: classes2.dex */
    public static class ANRListenerImpl implements ik9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ANRListenerImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ik9.f
        public void onAppNotResponding(ANRError aNRError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) {
                Log.d(ANRMonitor.TAG, "ANRWatchDog catch ANR", aNRError);
                ANRMonitor.filiterANR(aNRError.getSTStackTrace());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-10858885, "Lcom/baidu/searchbox/anr/impl/ANRMonitor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-10858885, "Lcom/baidu/searchbox/anr/impl/ANRMonitor;");
        }
    }

    public ANRMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAnrWatchTimeOut = 5000;
        this.mANRWatchDog = null;
        this.mMonitorStarted = false;
    }

    public static void collectData(StackTraceElement[] stackTraceElementArr) {
        Context appContext;
        String mainThreadStackTrace;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, stackTraceElementArr) == null) || (appContext = AppRuntime.getAppContext()) == null) {
            return;
        }
        sANRTimeStamp = String.valueOf(System.currentTimeMillis());
        if (Utils.checkProcessAnrState(appContext, ANR_TIMEOUT_MS)) {
            String str2 = appContext.getFilesDir() + "/" + DEFAULT_LOGCAT_NAME;
            Utils.storeLogcat(str2, 2000);
            if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                mainThreadStackTrace = stack2String(stackTraceElementArr);
            } else {
                mainThreadStackTrace = ANRCollector.getMainThreadStackTrace();
            }
            String str3 = mainThreadStackTrace;
            if (new File("/data/anr/traces.txt").canRead()) {
                str = "";
            } else {
                str = appContext.getFilesDir() + "/" + DEFAULT_ALL_STACK_TRACES_NAME;
                Utils.storeAllTraces2File(str);
            }
            ANRContext.getANRContext().onAppNotResponding(AppRuntime.getAppContext(), new ANRInfo(sANRTimeStamp, str3, str2, "/data/anr/traces.txt", str));
        }
    }

    public static void filiterANR(StackTraceElement[] stackTraceElementArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, stackTraceElementArr) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - sLastTimes < 20000) {
                    Log.d(TAG, "should not process ANR too more in 20000");
                    return;
                }
                sLastTimes = currentTimeMillis;
                collectData(stackTraceElementArr);
            } catch (Throwable th) {
                String str = TAG;
                Log.d(str, "handle anr error  " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerANRSignal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (AppConfig.isDebug()) {
                Log.w(TAG, "start ANR Signal Monitor");
            }
            if (this.nativeANRListener == null) {
                z71 z71Var = new z71(this) { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ANRMonitor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.repackage.z71
                    public void onNativeANR(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            if (AppConfig.isDebug()) {
                                String str = ANRMonitor.TAG;
                                Log.w(str, "Java signal receiver ，sig = " + i);
                            }
                            ANRMonitor.filiterANR(null);
                        }
                    }
                };
                this.nativeANRListener = z71Var;
                b81.a(z71Var);
            }
            b81.b(Build.VERSION.SDK_INT);
        }
    }

    private void retryUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            for (IANRRegister iANRRegister : ANRRuntime.getInstance().getIANRUploadList().getList()) {
                if (iANRRegister instanceof ANRBOSRegister) {
                    ((ANRBOSRegister) iANRRegister).retryUpload();
                }
            }
        }
    }

    public static String stack2String(StackTraceElement[] stackTraceElementArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, stackTraceElementArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (stackTraceElementArr != null) {
                try {
                    if (stackTraceElementArr.length >= 1) {
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            sb.append(stackTraceElement.toString() + "\r\n");
                        }
                    }
                } catch (Exception e) {
                    Log.e("ThreadCollector", "ThreadInfo Collector Interrupted!!", e);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void startANRListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            FileObserver fileObserver = new FileObserver(this, "/data/anr/", 8) { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ANRMonitor this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.FileObserver
                public void onEvent(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                        if (AppConfig.isDebug()) {
                            Log.d(ANRMonitor.TAG, "onEvent: " + str);
                        }
                        if (str != null) {
                            String str2 = "/data/anr/" + str;
                            if (str2.contains(Config.TRACE_PART)) {
                                ANRMonitor.filiterANR(null);
                                return;
                            }
                            Log.d(ANRMonitor.TAG, "not anr file " + str2);
                        }
                    }
                }
            };
            this.mFileObserver = fileObserver;
            try {
                fileObserver.startWatching();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "start ANR FileObserver Listener");
                }
            } catch (Throwable unused) {
                this.mFileObserver = null;
                Log.d(TAG, "start anr monitor failed!");
            }
        }
    }

    private void startANRSignalMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                registerANRSignal();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: com.baidu.searchbox.anr.impl.ANRMonitor.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ANRMonitor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.registerANRSignal();
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public boolean enableMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ANRRuntime.getInstance().enableANR() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i < 5000) {
                this.mAnrWatchTimeOut = 5000;
            } else {
                this.mAnrWatchTimeOut = i;
            }
            ik9 ik9Var = new ik9(this.mAnrWatchTimeOut);
            this.mANRWatchDog = ik9Var;
            ik9Var.e();
            this.mANRWatchDog.c(new ANRListenerImpl());
            if (AppConfig.isDebug()) {
                String str = TAG;
                Log.d(str, "start mANRWatchDog = " + this.mANRWatchDog.getName() + " Monitor");
            }
            this.mANRWatchDog.start();
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void stopANRMonitor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mMonitorStarted) {
            ik9 ik9Var = this.mANRWatchDog;
            if (ik9Var != null) {
                ik9Var.interrupt();
                this.mMonitorStarted = false;
            }
            FileObserver fileObserver = this.mFileObserver;
            if (fileObserver != null) {
                fileObserver.stopWatching();
                this.mMonitorStarted = false;
            }
            if (this.nativeANRListener != null) {
                b81.c();
            }
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mMonitorStarted) {
            return;
        }
        retryUpload();
        this.mMonitorStarted = true;
        if (Build.VERSION.SDK_INT < 21) {
            startANRListener();
        } else {
            startANRMonitor(5000);
        }
        startANRSignalMonitor();
    }
}
