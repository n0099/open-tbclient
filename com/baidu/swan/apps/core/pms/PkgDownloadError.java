package com.baidu.swan.apps.core.pms;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bc3;
import com.repackage.e94;
/* loaded from: classes2.dex */
public class PkgDownloadError extends Throwable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bc3 mErrCode;
    public e94 mPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PkgDownloadError(e94 e94Var, bc3 bc3Var) {
        super(bc3Var.e());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e94Var, bc3Var};
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
        this.mPackage = e94Var;
        this.mErrCode = bc3Var;
    }

    public bc3 getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mErrCode : (bc3) invokeV.objValue;
    }

    public e94 getPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPackage : (e94) invokeV.objValue;
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
