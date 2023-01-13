package com.baidu.swan.apps.core.pms;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cg3;
import com.baidu.tieba.hd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cg3 mErrCode;
    public hd4 mPackage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PkgDownloadError(hd4 hd4Var, cg3 cg3Var) {
        super(cg3Var.e());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hd4Var, cg3Var};
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
        this.mPackage = hd4Var;
        this.mErrCode = cg3Var;
    }

    public cg3 getErrCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mErrCode;
        }
        return (cg3) invokeV.objValue;
    }

    public hd4 getPackage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mPackage;
        }
        return (hd4) invokeV.objValue;
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
