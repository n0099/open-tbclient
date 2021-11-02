package com.baidu.nps.hook.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Process;
import b.a.b0.i.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(28)
/* loaded from: classes7.dex */
public class NPSComponentFactory extends AppComponentFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public NPSComponentFactory() {
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

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, classLoader, str, intent)) == null) {
            if (b.a()) {
                String str2 = "instantiateActivity,classLoader=" + classLoader + " className=" + str;
                String str3 = "NPSComponentFactory.instantiateActivity|process=" + Process.myPid();
            }
            try {
                return super.instantiateActivity(classLoader, str, intent);
            } catch (ClassNotFoundException unused) {
                return NPSManager.getInstance().instantiateActivity(str);
            }
        }
        return (Activity) invokeLLL.objValue;
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, classLoader, str)) == null) {
            if (b.a()) {
                String str2 = "instantiateApplication,classLoader=" + classLoader + " className=" + str;
            }
            return super.instantiateApplication(classLoader, str);
        }
        return (Application) invokeLL.objValue;
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, classLoader, str, intent)) == null) {
            if (b.a()) {
                String str2 = "instantiateReceiver,classLoader=" + classLoader + " className=" + str;
            }
            try {
                return super.instantiateReceiver(classLoader, str, intent);
            } catch (ClassNotFoundException unused) {
                return NPSManager.getInstance().instantiateReceiver(str);
            }
        }
        return (BroadcastReceiver) invokeLLL.objValue;
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, classLoader, str, intent)) == null) {
            if (b.a()) {
                String str2 = "instantiateService,classLoader=" + classLoader + " className=" + str;
            }
            try {
                return super.instantiateService(classLoader, str, intent);
            } catch (ClassNotFoundException unused) {
                return NPSManager.getInstance().instantiateService(str);
            }
        }
        return (Service) invokeLLL.objValue;
    }
}
