package com.baidu.searchbox.process.ipc.delegate;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DelegateResult implements DelegateDef.ResultCode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<? extends Delegation> mDelegation;
    public StringBuilder mDesc;
    public final Bundle mParams;
    public final Bundle mResult;
    public final int mResultCode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DelegateResult(int i, Class<? extends ActivityDelegation> cls) {
        this(i, cls, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], (Bundle) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle) {
        this(i, cls, bundle, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), cls, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Class) objArr2[1], (Bundle) objArr2[2], (Bundle) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DelegateResult(int i, Class<? extends Delegation> cls, @Nullable Bundle bundle, @Nullable Bundle bundle2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), cls, bundle, bundle2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDesc = new StringBuilder();
        this.mParams = new Bundle();
        this.mResult = new Bundle();
        this.mResultCode = i;
        this.mDelegation = cls;
        putParams(bundle);
        putResult(bundle2);
    }

    private String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.mDesc.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean isOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mResultCode == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void putAll(@Nullable Bundle bundle, @NonNull Bundle bundle2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, bundle2) == null) && bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public DelegateResult addDesc(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb = this.mDesc;
                sb.append("[desc]:: ");
                sb.append(str);
                sb.append("\n");
            }
            return this;
        }
        return (DelegateResult) invokeL.objValue;
    }

    public DelegateResult putParams(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            putAll(bundle, this.mParams);
            return this;
        }
        return (DelegateResult) invokeL.objValue;
    }

    public DelegateResult putResult(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            putAll(bundle, this.mResult);
            return this;
        }
        return (DelegateResult) invokeL.objValue;
    }
}
