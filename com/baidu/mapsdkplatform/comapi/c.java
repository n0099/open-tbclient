package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.EnvironmentUtilities;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7569a;

    public static void a(Context context, boolean z, String str, String str2, String str3) {
        if (f7569a) {
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
        f7569a = true;
    }

    public static boolean a(String str) {
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
        } catch (IOException e2) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e2);
            throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
        }
    }
}
