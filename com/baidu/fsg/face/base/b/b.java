package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.fsg.face.base.d.h;
import com.baidu.fsg.face.base.d.i;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1570a = 100;
    private static final String c = ".BD_SAPI_CACHE";
    private static final String d = "so_zips";
    private static final String e = "1.0.1";
    private static final String f = "1.0.3";
    private static final String g = "FaceSDKLibs";
    private static final String[] h = {"idl_license", "FaceSDK"};
    private static b i;
    private String b;
    private SharedPreferences j;

    /* loaded from: classes17.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f1571a;
        public String b;
        public String c;
        public String[] d;
    }

    public static b a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (i == null) {
            i = new b(applicationContext);
        }
        return i;
    }

    private b(Context context) {
        this.j = context.getApplicationContext().getSharedPreferences("rim_liveness_base_system_v1", 0);
    }

    public static String a(Context context, a aVar) {
        return context.getDir(aVar.c, 0).getAbsolutePath();
    }

    public static String b(Context context, a aVar) {
        return new File(a(context, aVar) + File.separator).getAbsolutePath();
    }

    public static String c(Context context, a aVar) {
        return new File(a(context, aVar) + File.separator + aVar.f1571a + File.separator + aVar.f1571a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aVar.b + ".zip").getAbsolutePath();
    }

    public static String a(a aVar) {
        return ".BD_SAPI_CACHE/" + aVar.f1571a + "/" + aVar.f1571a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aVar.b + ".zip";
    }

    private String a(String str) {
        return this.j.getString(str, "");
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.j.edit().putString(str, str2).apply();
        } else {
            this.j.edit().putString(str, str2).commit();
        }
    }

    public void a(Context context, String str, c cVar) {
        if (cVar != null) {
            a(str, i.c(cVar.a().toString(), b(context)));
        }
    }

    public c a(Context context, String str) {
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2)) {
            String b = i.b(a2, b(context));
            if (!TextUtils.isEmpty(b)) {
                try {
                    return c.a(new JSONObject(b));
                } catch (JSONException e2) {
                    com.baidu.fsg.face.base.d.d.a(e2);
                }
            }
        }
        return new c();
    }

    private String b(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = MD5Util.toMd5((context.getPackageName() + h.a(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
            }
        }
        return this.b;
    }

    public static a a(int i2) {
        a aVar = new a();
        switch (i2) {
            case 4:
                aVar.f1571a = d;
                aVar.b = "1.0.3";
                aVar.c = g;
                aVar.d = h;
                return aVar;
            default:
                throw new IllegalArgumentException("the so modle type = " + i2 + " is not support");
        }
    }
}
