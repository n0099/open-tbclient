package com.baidu.searchbox.unitedscheme.moniter;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Hashtable;
/* loaded from: classes2.dex */
public class TimeCostMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "TimeCostMonitor";
    public transient /* synthetic */ FieldHolder $fh;
    public Hashtable<String, Long> mEventRecorder;
    public long mThresholdValue;
    public TimeCostHandler mTimeoutHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500753389, "Lcom/baidu/searchbox/unitedscheme/moniter/TimeCostMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-500753389, "Lcom/baidu/searchbox/unitedscheme/moniter/TimeCostMonitor;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public TimeCostMonitor(TimeCostHandler timeCostHandler, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {timeCostHandler, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTimeoutHandler = timeCostHandler;
        this.mThresholdValue = j;
        this.mEventRecorder = new Hashtable<>();
    }

    public void recordEnd(String str) {
        Hashtable<String, Long> hashtable;
        Long l;
        TimeCostHandler timeCostHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str) || (hashtable = this.mEventRecorder) == null || (l = hashtable.get(str)) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = currentTimeMillis - l.longValue();
        if (longValue > this.mThresholdValue && (timeCostHandler = this.mTimeoutHandler) != null) {
            timeCostHandler.handle(l.longValue(), currentTimeMillis, this.mThresholdValue, str);
        }
        if (DEBUG) {
            Log.i(TAG, "执行耗时：" + longValue + "，开始时间：" + l + "，结束时间：" + currentTimeMillis + "，event：" + str);
        }
        this.mEventRecorder.remove(str);
    }

    public void recordStart(String str) {
        Hashtable<String, Long> hashtable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str) || (hashtable = this.mEventRecorder) == null) {
            return;
        }
        hashtable.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
