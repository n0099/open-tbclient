package com.baidu.searchbox.anr.impl;

import android.content.Context;
import b.h.a.a;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.File;
@Singleton
@Service
/* loaded from: classes7.dex */
public class ANRMonitor implements IANRMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_WATCHDOG_ANR_TIMEOUT = 5000;
    public static String sANRTimeStamp;
    public transient /* synthetic */ FieldHolder $fh;
    public a mANRWatchDog;
    public int mAnrWatchTimeOut;
    public boolean mMonitorStarted;

    /* renamed from: com.baidu.searchbox.anr.impl.ANRMonitor$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class ANRListenerImpl implements a.f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEFAULT_ALL_STACK_TRACES_NAME = "all_stack_traces.txt";
        public static final int DEFAULT_LOGCAT_MAX_LEN = 2000;
        public static final String DEFAULT_LOGCAT_NAME = "anr_logcat.txt";
        public static final String DEFAULT_TRACES_PATH = "/data/anr/traces.txt";
        public transient /* synthetic */ FieldHolder $fh;

        public ANRListenerImpl() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.h.a.a.f
        public void onAppNotResponding(ANRError aNRError) {
            Context appContext;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aNRError) == null) || (appContext = AppRuntime.getAppContext()) == null) {
                return;
            }
            String str2 = appContext.getFilesDir() + "/" + DEFAULT_LOGCAT_NAME;
            if (Utils.storeIfRealANR(str2, 2000)) {
                ANRMonitor.sANRTimeStamp = String.valueOf(System.currentTimeMillis());
                String mainThreadStackTrace = ANRCollector.getMainThreadStackTrace();
                if (new File("/data/anr/traces.txt").canRead()) {
                    str = "";
                } else {
                    str = appContext.getFilesDir() + "/" + DEFAULT_ALL_STACK_TRACES_NAME;
                    Utils.storeAllTraces2File(str);
                }
                ANRContext.getANRContext().onAppNotResponding(AppRuntime.getAppContext(), new ANRInfo(ANRMonitor.sANRTimeStamp, mainThreadStackTrace, str2, "/data/anr/traces.txt", str));
            }
        }

        public /* synthetic */ ANRListenerImpl(AnonymousClass1 anonymousClass1) {
            this();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAnrWatchTimeOut = 5000;
        this.mANRWatchDog = null;
        this.mMonitorStarted = false;
    }

    private void retryUpload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            for (IANRRegister iANRRegister : ANRRuntime.getInstance().getIANRUploadList().getList()) {
                if (iANRRegister instanceof ANRBOSRegister) {
                    ((ANRBOSRegister) iANRRegister).retryUpload();
                }
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
    public void startANRMonitor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.mMonitorStarted) {
            return;
        }
        retryUpload();
        this.mMonitorStarted = true;
        if (i2 < 5000) {
            this.mAnrWatchTimeOut = 5000;
        } else {
            this.mAnrWatchTimeOut = i2;
        }
        a aVar = new a(this.mAnrWatchTimeOut);
        this.mANRWatchDog = aVar;
        aVar.d();
        this.mANRWatchDog.c(new ANRListenerImpl(null));
        if (AppConfig.isDebug()) {
            String str = "mANRWatchDog = " + this.mANRWatchDog.getName();
        }
        this.mANRWatchDog.start();
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void stopANRMonitor() {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mMonitorStarted && (aVar = this.mANRWatchDog) != null) {
            aVar.interrupt();
            this.mMonitorStarted = false;
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.IANRMonitor
    public void startANRMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            startANRMonitor(5000);
        }
    }
}
