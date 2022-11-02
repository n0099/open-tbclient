package com.baidu.searchbox.v8engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes2.dex */
public class JsSerializeValue extends JsReleaser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "JsSerializeValue";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAutoRelease;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsSerializeValue(long j, long j2, long j3) {
        super(j, j2, j3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r9;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAutoRelease = true;
    }

    @Override // com.baidu.searchbox.v8engine.JsReleaser
    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finalize();
        }
    }

    public boolean isAutoRelease() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAutoRelease;
        }
        return invokeV.booleanValue;
    }

    public void setAutoRelease(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mAutoRelease = z;
        }
    }
}
