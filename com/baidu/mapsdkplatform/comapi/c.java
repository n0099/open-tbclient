package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.EnvironmentUtilities;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3019a;

    public static void a(Context context, boolean z, String str, String str2) {
        if (f3019a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("context must be an ApplicationContext");
        }
        NativeLoader.setContext(context);
        NativeLoader.a(z, str);
        a.a().a(context);
        a.a().c();
        JNIInitializer.setContext((Application) context);
        if (a(str2)) {
            EnvironmentUtilities.setSDCardPath(str2);
        }
        f3019a = true;
    }

    private static boolean a(String str) {
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
            }
            return true;
        } catch (IOException e) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e);
            throw new IllegalArgumentException("Provided sdcard cache path invalid can not used.");
        }
    }
}
