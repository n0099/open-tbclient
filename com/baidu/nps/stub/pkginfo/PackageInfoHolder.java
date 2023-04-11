package com.baidu.nps.stub.pkginfo;

import android.app.Application;
import android.content.pm.PackageInfo;
import com.baidu.nps.stub.context.ContextHolderImpl;
import com.baidu.nps.utils.Constant;
import com.baidu.tieba.be1;
import com.baidu.tieba.de1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PackageInfoHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PackageInfoHolder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static PackageInfo getPackageInfo(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            Application applicationContext = ContextHolderImpl.getApplicationContext();
            return de1.a(be1.d(applicationContext, str + Constant.FILE.SUFFIX.BUNDLE_SUFFIX).getAbsolutePath(), i);
        }
        return (PackageInfo) invokeLI.objValue;
    }
}
