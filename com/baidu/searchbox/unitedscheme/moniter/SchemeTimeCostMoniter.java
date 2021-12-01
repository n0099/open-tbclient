package com.baidu.searchbox.unitedscheme.moniter;

import android.preference.PreferenceManager;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class SchemeTimeCostMoniter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int DEFAULT_THRESHOLD = 100;
    public static final String SP_KEY_OPEN_MONITER = "sp_key_open_moniter";
    public static final String SP_KEY_TIME_COST_THRESHOLD = "sp_key_time_cost_threshold";
    public static final String TAG = "SchemeTimeCostMoniter";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mOpenMoniter;
    public TimeCostMonitor mTimeCostMoniter;

    /* loaded from: classes9.dex */
    public static class SchemeTimeCostMoniterHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final SchemeTimeCostMoniter sInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1869562369, "Lcom/baidu/searchbox/unitedscheme/moniter/SchemeTimeCostMoniter$SchemeTimeCostMoniterHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1869562369, "Lcom/baidu/searchbox/unitedscheme/moniter/SchemeTimeCostMoniter$SchemeTimeCostMoniterHolder;");
                    return;
                }
            }
            sInstance = new SchemeTimeCostMoniter();
        }

        public SchemeTimeCostMoniterHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1551797170, "Lcom/baidu/searchbox/unitedscheme/moniter/SchemeTimeCostMoniter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1551797170, "Lcom/baidu/searchbox/unitedscheme/moniter/SchemeTimeCostMoniter;");
                return;
            }
        }
        DEBUG = SchemeConfig.DEBUG;
    }

    public static SchemeTimeCostMoniter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? SchemeTimeCostMoniterHolder.sInstance : (SchemeTimeCostMoniter) invokeV.objValue;
    }

    public void schemeEnd(String str) {
        TimeCostMonitor timeCostMonitor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && DEBUG && this.mOpenMoniter && (timeCostMonitor = this.mTimeCostMoniter) != null) {
            timeCostMonitor.recordEnd(str);
        }
    }

    public void schemeStart(String str) {
        TimeCostMonitor timeCostMonitor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && DEBUG && this.mOpenMoniter && (timeCostMonitor = this.mTimeCostMoniter) != null) {
            timeCostMonitor.recordStart(str);
        }
    }

    public SchemeTimeCostMoniter() {
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
        long j2 = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getLong(SP_KEY_TIME_COST_THRESHOLD, 100L);
        this.mOpenMoniter = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(SP_KEY_OPEN_MONITER, false);
        this.mTimeCostMoniter = new TimeCostMonitor(new TimeCostHandler(this) { // from class: com.baidu.searchbox.unitedscheme.moniter.SchemeTimeCostMoniter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SchemeTimeCostMoniter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.unitedscheme.moniter.TimeCostHandler
            public void handle(long j3, long j4, long j5, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), str}) == null) {
                    Toast.makeText(AppRuntime.getAppContext(), "端能力执行时间超出阈值（" + j5 + "），耗时：" + (j4 - j3) + "，开始时间：" + j3 + "，结束时间：" + j4 + "，端能力：" + str, 1).show();
                }
            }
        }, j2);
    }
}
