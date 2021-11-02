package com.baidu.nps.stub.pkginfo;

import android.app.Application;
import android.content.pm.PackageInfo;
import b.a.b0.i.c;
import b.a.b0.i.e;
import com.baidu.nps.stub.context.ContextHolderImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PackageInfoHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PackageInfoHolder() {
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

    public static PackageInfo getPackageInfo(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            Application applicationContext = ContextHolderImpl.getApplicationContext();
            return e.a(c.d(applicationContext, str + ".apk").getAbsolutePath(), i2);
        }
        return (PackageInfo) invokeLI.objValue;
    }
}
