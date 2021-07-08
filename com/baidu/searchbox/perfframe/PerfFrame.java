package com.baidu.searchbox.perfframe;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.impl.PerfExpInfo;
import com.baidu.searchbox.perfframe.impl.PerfFrameContext;
import com.baidu.searchbox.perfframe.ioc.IPerfFrame;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PerfFrame implements IPerfFrame {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "PerfFrame";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsNeedDynamicperf;
    public boolean mIsNeedMainStackTrace;
    public boolean mIsNeedPageTrace;
    public boolean mIsNeedStaticperf;

    /* renamed from: com.baidu.searchbox.perfframe.PerfFrame$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsNeedDynamicperf;
        public boolean mIsNeedMainStackTrace;
        public boolean mIsNeedPageTrace;
        public boolean mIsNeedStaticperf;

        public Builder() {
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

        public PerfFrame create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new PerfFrame(this, null) : (PerfFrame) invokeV.objValue;
        }

        public Builder setNeedDynamicperf(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mIsNeedDynamicperf = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedMainStackTrace(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.mIsNeedMainStackTrace = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedPageTrace(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mIsNeedPageTrace = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setNeedStaticperf(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mIsNeedStaticperf = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1864496540, "Lcom/baidu/searchbox/perfframe/PerfFrame;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1864496540, "Lcom/baidu/searchbox/perfframe/PerfFrame;");
        }
    }

    public /* synthetic */ PerfFrame(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrame
    public void submitPerformanceData(String str, String str2, long j, long j2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2), str3, str4, str5}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        PerfExpInfo perfExpInfo = new PerfExpInfo(str, str2, j, j2, str3, str4, str5);
        perfExpInfo.setNeedDynamicperf(this.mIsNeedDynamicperf);
        perfExpInfo.setNeedStaticperf(this.mIsNeedStaticperf);
        perfExpInfo.setNeedPageTrace(this.mIsNeedPageTrace);
        perfExpInfo.setNeedMainStackTrace(this.mIsNeedMainStackTrace);
        if (AppConfig.isDebug()) {
            String str6 = TAG;
            Log.d(str6, "perfExpInfo：" + perfExpInfo.toString());
        }
        PerfFrameContext.getPerfFrameContext().onPerfFrameCallBack(AppRuntime.getAppContext(), perfExpInfo);
    }

    public PerfFrame() {
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

    public PerfFrame(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIsNeedPageTrace = builder.mIsNeedPageTrace;
        this.mIsNeedDynamicperf = builder.mIsNeedDynamicperf;
        this.mIsNeedStaticperf = builder.mIsNeedStaticperf;
        this.mIsNeedMainStackTrace = builder.mIsNeedMainStackTrace;
    }
}
