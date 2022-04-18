package com.baidu.swan.apps.core.pms;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cc3;
import com.repackage.f94;
/* loaded from: classes2.dex */
public class PkgDownloadError extends Throwable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cc3 mErrCode;
    public f94 mPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PkgDownloadError(f94 f94Var, cc3 cc3Var) {
        super(cc3Var.e());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f94Var, cc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPackage = f94Var;
        this.mErrCode = cc3Var;
    }

    public cc3 getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mErrCode : (cc3) invokeV.objValue;
    }

    public f94 getPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPackage : (f94) invokeV.objValue;
    }

    @Override // java.lang.Throwable
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.mPackage != null) {
                sb.append(" -> package: ");
                sb.append(this.mPackage.toString());
            }
            if (this.mErrCode != null) {
                sb.append(" -> ErrCode: ");
                sb.append(this.mErrCode.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
