package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2541e = a(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});

    /* renamed from: f  reason: collision with root package name */
    public static final String f2542f = a(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});

    /* renamed from: a  reason: collision with root package name */
    public String f2543a;

    /* renamed from: b  reason: collision with root package name */
    public String f2544b;

    /* renamed from: c  reason: collision with root package name */
    public int f2545c = 3;

    /* renamed from: d  reason: collision with root package name */
    public int f2546d;

    public static b a(Context context, String str) {
        return b(context, str);
    }

    public static b a(a aVar) {
        if (aVar != null) {
            b bVar = new b();
            bVar.a(aVar.a());
            bVar.b(aVar.b());
            return bVar;
        }
        throw new IllegalArgumentException("arg non-nullable is expected");
    }

    public static String a(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(com.baidu.android.bbalbs.common.a.b.a(bArr2)));
        }
        return sb.toString();
    }

    public static b b(Context context) {
        File d2 = d(context);
        if (d2.exists()) {
            return d(d.a(d2));
        }
        return null;
    }

    public static b b(Context context, String str) {
        StringBuilder sb;
        b bVar = new b();
        boolean z = Build.VERSION.SDK_INT < 23;
        String a2 = d.a(context);
        if (z) {
            String e2 = e(context);
            if (TextUtils.isEmpty(e2)) {
                e2 = UUID.randomUUID().toString();
                c(context, e2);
            }
            sb = new StringBuilder();
            sb.append(a2);
            sb.append(e2);
        } else {
            sb = new StringBuilder();
            sb.append("com.baidu");
            sb.append(a2);
        }
        bVar.a(com.baidu.android.bbalbs.common.a.c.a(sb.toString().getBytes(), true));
        bVar.b(str);
        bVar.a(Build.VERSION.SDK_INT);
        return bVar;
    }

    private String b() {
        try {
            return new JSONObject().put(i("ZGV2aWNlaWQ="), this.f2543a).put(i("ZmxhZw=="), this.f2544b == null ? "0" : this.f2544b).put(i("dmVy"), this.f2545c).put(i("c2Rr"), this.f2546d).toString();
        } catch (JSONException e2) {
            d.a(e2);
            return null;
        }
    }

    public static b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(i("ZmxhZw=="), "0");
            String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
            int optInt = jSONObject.optInt(i("c2Rr"), 0);
            if (!TextUtils.isEmpty(string)) {
                b bVar = new b();
                bVar.a(string);
                bVar.b(optString);
                bVar.a(optInt);
                return bVar;
            }
        } catch (JSONException e2) {
            d.a(e2);
        }
        return null;
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k")) && d.b(context)) {
            d.a(context, "XL5g0WZAHpIaKspIHIHYg5k", g(str));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean c(Context context) {
        String e2 = e(b());
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput("libcuid_v3.so", 0);
                fileOutputStream.write(e2.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (Exception e3) {
                        d.a(e3);
                        return true;
                    }
                }
                return true;
            } catch (Exception e4) {
                d.a(e4);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        d.a(e5);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                    d.a(e6);
                }
            }
            throw th;
        }
    }

    public static b d(String str) {
        return c(f(str));
    }

    public static File d(Context context) {
        return new File(context.getFilesDir(), "libcuid_v3.so");
    }

    public static String e(Context context) {
        return h(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k"));
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2541e, f2542f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.a.a.b(f2541e, f2542f, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2542f, f2541e, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.a.a.b(f2542f, f2541e, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    public static String i(String str) {
        return new String(com.baidu.android.bbalbs.common.a.b.a(str.getBytes()));
    }

    public String a() {
        if (TextUtils.isEmpty(this.f2544b)) {
            this.f2544b = "0";
        }
        return this.f2543a + FieldBuilder.SE + this.f2544b;
    }

    public void a(int i2) {
        this.f2546d = i2;
    }

    public void a(String str) {
        this.f2543a = str;
    }

    public boolean a(Context context) {
        return c(context);
    }

    public void b(String str) {
        this.f2544b = str;
    }
}
