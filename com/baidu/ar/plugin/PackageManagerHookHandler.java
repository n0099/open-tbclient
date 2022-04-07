package com.baidu.ar.plugin;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.baidu.ar.session.XRSessionAnchor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
/* loaded from: classes.dex */
public class PackageManagerHookHandler implements InvocationHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mBase;
    public PluginPackageParser mPPP;

    public PackageManagerHookHandler(Object obj, PluginPackageParser pluginPackageParser) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj, pluginPackageParser};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = obj;
        this.mPPP = pluginPackageParser;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
            if (method.getName().equals("getPackageInfo") && objArr[0] == XRSessionAnchor.apkinfo) {
                PackageInfo packageInfo = new PackageInfo();
                packageInfo.packageName = XRSessionAnchor.apkinfo;
                packageInfo.versionCode = 190128146;
                packageInfo.versionName = "1.7.190120000";
                if (this.mPPP != null) {
                    Log.i("andrew", "get Package info flag:" + objArr[1]);
                    packageInfo = this.mPPP.getPackageInfo(((Integer) objArr[1]).intValue());
                }
                Log.d("andrew", "method:" + method.getName() + " called with args:" + Arrays.toString(objArr) + ";package info:" + packageInfo);
                return packageInfo;
            }
            return method.invoke(this.mBase, objArr);
        }
        return invokeLLL.objValue;
    }
}
