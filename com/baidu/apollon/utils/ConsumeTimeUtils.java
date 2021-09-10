package com.baidu.apollon.utils;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ConsumeTimeUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TimeResult f38221a;

    /* renamed from: b  reason: collision with root package name */
    public String f38222b;

    /* renamed from: c  reason: collision with root package name */
    public String f38223c;

    /* loaded from: classes5.dex */
    public final class TimeResult {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f38224a;

        /* renamed from: b  reason: collision with root package name */
        public long f38225b;

        /* renamed from: c  reason: collision with root package name */
        public long f38226c;

        /* renamed from: d  reason: collision with root package name */
        public int f38227d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ConsumeTimeUtils f38228e;

        public TimeResult(ConsumeTimeUtils consumeTimeUtils) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumeTimeUtils};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38228e = consumeTimeUtils;
            this.f38224a = 0L;
            this.f38225b = 0L;
            this.f38226c = 0L;
            this.f38227d = 0;
        }

        public String buildLog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.f38228e.f38223c != null) {
                    sb.append(this.f38228e.f38223c + ":");
                }
                sb.append(" task last " + getDurationMesc() + " millisecond about " + getDurationSecond() + " second");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public long getDurationMesc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38225b - this.f38224a : invokeV.longValue;
        }

        public int getDurationSecond() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) (getDurationMesc() / 1000) : invokeV.intValue;
        }

        public long getEndTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38225b : invokeV.longValue;
        }

        public long getStartTime() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38224a : invokeV.longValue;
        }

        public void logd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogUtil.d(this.f38228e.f38222b, buildLog());
            }
        }

        public void loge() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                LogUtil.e(this.f38228e.f38222b, buildLog(), new Throwable());
            }
        }

        public void logi() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                LogUtil.i(this.f38228e.f38222b, buildLog());
            }
        }

        public void logv() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                LogUtil.v(this.f38228e.f38222b, buildLog());
            }
        }

        public void logw() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogUtil.w(this.f38228e.f38222b, buildLog());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                String buildLog = buildLog();
                LogUtil.v(this.f38228e.f38222b, buildLog);
                return buildLog;
            }
            return (String) invokeV.objValue;
        }
    }

    public ConsumeTimeUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38222b = "ConsumeTime";
    }

    public TimeResult finish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f38221a.f38225b = SystemClock.uptimeMillis();
            return this.f38221a;
        }
        return (TimeResult) invokeV.objValue;
    }

    public void setPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f38223c = str;
        }
    }

    public void setTAGString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f38222b = str;
        }
    }

    public ConsumeTimeUtils start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TimeResult timeResult = new TimeResult(this);
            this.f38221a = timeResult;
            timeResult.f38224a = SystemClock.uptimeMillis();
            return this;
        }
        return (ConsumeTimeUtils) invokeV.objValue;
    }
}
