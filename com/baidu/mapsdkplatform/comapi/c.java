package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3}) == null) || a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        NativeLoader.setContext(context);
        NativeLoader.a(z, str);
        a.a().a(context);
        a.a().c();
        a.a().a(str3);
        JNIInitializer.setContext((Application) context);
        if (a(str2)) {
            EnvironmentUtilities.setSDCardPath(str2);
        }
        EnvironmentUtilities.initAppDirectory(context);
        com.baidu.mapsdkplatform.comapi.b.a.c.a().a(context);
        a = true;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || str.isEmpty()) {
                return false;
            }
            try {
                File file = new File(str + "/check.0");
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                if (file.exists()) {
                    file.delete();
                    return true;
                }
                return true;
            } catch (IOException unused) {
                throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
            }
        }
        return invokeL.booleanValue;
    }
}
