package com.baidu.pass.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class SharedPreferencesUtil implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferencesUtil f9256a = null;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences f9257b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9258c = "sapi_system";

    /* renamed from: d  reason: collision with root package name */
    public static String f9259d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f9260e;

    public SharedPreferencesUtil(Context context, String str) {
        f9257b = context.getSharedPreferences(str, 0);
        f9260e = context.getApplicationContext();
    }

    public static String a() {
        if (TextUtils.isEmpty(f9259d)) {
            try {
                f9259d = SecurityUtil.md5((f9260e.getPackageName() + PassUtil.getPackageSign(f9260e, f9260e.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        return f9259d;
    }

    public static <T> T get(String str, T t) {
        char c2;
        String simpleName = t.getClass().getSimpleName();
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode == -672261858) {
                if (simpleName.equals("Integer")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode == 2374300) {
                if (simpleName.equals("Long")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 67973692) {
                if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (simpleName.equals("Float")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return (T) f9257b.getString(str, (String) t);
                        }
                        return (T) Integer.valueOf(f9257b.getInt(str, ((Integer) t).intValue()));
                    }
                    return (T) Float.valueOf(f9257b.getFloat(str, ((Float) t).floatValue()));
                }
                return (T) Long.valueOf(f9257b.getLong(str, ((Long) t).longValue()));
            }
            return (T) Boolean.valueOf(f9257b.getBoolean(str, ((Boolean) t).booleanValue()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getEncryptStr(String str, String str2) {
        String a2 = a();
        String stringBuffer = new StringBuffer(a2).reverse().toString();
        String str3 = (String) get(str, str2);
        try {
            return new String(SecurityUtil.aesDecrypt(SecurityUtil.base64Decode(str3.getBytes()), stringBuffer, a2)).trim();
        } catch (Exception e2) {
            Log.e(e2);
            return str3;
        }
    }

    public static synchronized void getInstance(Context context) {
        synchronized (SharedPreferencesUtil.class) {
            if (f9256a == null) {
                f9256a = new SharedPreferencesUtil(context, f9258c);
            }
        }
    }

    public static boolean put(String str, Object obj) {
        char c2;
        SharedPreferences.Editor edit = f9257b.edit();
        String simpleName = obj.getClass().getSimpleName();
        boolean z = false;
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode == -672261858) {
                if (simpleName.equals("Integer")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode == 2374300) {
                if (simpleName.equals("Long")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 67973692) {
                if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (simpleName.equals("Float")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (c2 == 1) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (c2 == 2) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (c2 != 3) {
                edit.putString(str, (String) obj);
            } else {
                edit.putInt(str, ((Integer) obj).intValue());
            }
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        edit.apply();
        return z;
    }

    public static void putEncryptStr(String str, String str2) {
        String a2 = a();
        try {
            str2 = SecurityUtil.base64Encode(SecurityUtil.aesEncrypt(str2, new StringBuffer(a2).reverse().toString(), a2));
        } catch (Exception e2) {
            Log.e(e2);
        }
        put(str, str2);
    }

    public static void remove(String str) {
        f9257b.edit().remove(str).apply();
    }
}
