package com.baidu.fsg.face.base.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.fsg.face.base.d.h;
import com.baidu.fsg.face.base.d.i;
import com.baidu.idl.license.License;
import com.baidu.sapi2.share.ShareStorage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5578a = 100;

    /* renamed from: c  reason: collision with root package name */
    public static final String f5579c = ".BD_SAPI_CACHE";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5580d = "so_zips";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5581e = "1.0.1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5582f = "1.0.3";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5583g = "FaceSDKLibs";

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f5584h = {License.LICENSE_DEFAULT_FILE_NAME, "FaceSDK"};

    /* renamed from: i  reason: collision with root package name */
    public static b f5585i;

    /* renamed from: b  reason: collision with root package name */
    public String f5586b;
    public SharedPreferences j;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5587a;

        /* renamed from: b  reason: collision with root package name */
        public String f5588b;

        /* renamed from: c  reason: collision with root package name */
        public String f5589c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f5590d;
    }

    public b(Context context) {
        this.j = context.getApplicationContext().getSharedPreferences("rim_liveness_base_system_v1", 0);
    }

    public static b a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (f5585i == null) {
            f5585i = new b(applicationContext);
        }
        return f5585i;
    }

    public static String b(Context context, a aVar) {
        String a2 = a(context, aVar);
        return new File(a2 + File.separator).getAbsolutePath();
    }

    public static String c(Context context, a aVar) {
        String a2 = a(context, aVar);
        return new File(a2 + File.separator + aVar.f5587a + File.separator + aVar.f5587a + "-" + aVar.f5588b + ".zip").getAbsolutePath();
    }

    private String b(Context context) {
        if (TextUtils.isEmpty(this.f5586b)) {
            try {
                this.f5586b = MD5Util.toMd5((context.getPackageName() + h.a(context, context.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (UnsupportedEncodingException e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
            }
        }
        return this.f5586b;
    }

    public static String a(Context context, a aVar) {
        return context.getDir(aVar.f5589c, 0).getAbsolutePath();
    }

    public static String a(a aVar) {
        return ShareStorage.SP_FILE_PATH + aVar.f5587a + "/" + aVar.f5587a + "-" + aVar.f5588b + ".zip";
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
            String b2 = i.b(a2, b(context));
            if (!TextUtils.isEmpty(b2)) {
                try {
                    return c.a(new JSONObject(b2));
                } catch (JSONException e2) {
                    com.baidu.fsg.face.base.d.d.a(e2);
                }
            }
        }
        return new c();
    }

    public static a a(int i2) {
        a aVar = new a();
        if (i2 == 4) {
            aVar.f5587a = f5580d;
            aVar.f5588b = "1.0.3";
            aVar.f5589c = f5583g;
            aVar.f5590d = f5584h;
            return aVar;
        }
        throw new IllegalArgumentException("the so modle type = " + i2 + " is not support");
    }
}
