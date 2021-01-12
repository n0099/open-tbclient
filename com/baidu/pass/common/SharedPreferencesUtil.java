package com.baidu.pass.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class SharedPreferencesUtil implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferencesUtil f4055a = null;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f4056b = null;
    private static final String c = "sapi_system";
    private static String d;
    private static Context e;

    private SharedPreferencesUtil(Context context, String str) {
        f4056b = context.getSharedPreferences(str, 0);
        e = context.getApplicationContext();
    }

    private static String a() {
        if (TextUtils.isEmpty(d)) {
            try {
                d = SecurityUtil.md5((e.getPackageName() + PassUtil.getPackageSign(e, e.getPackageName())).getBytes("UTF-8"), false).substring(0, 16);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
        return d;
    }

    public static <T> T get(String str, T t) {
        String simpleName = t.getClass().getSimpleName();
        char c2 = 65535;
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode != -672261858) {
                if (hashCode != 2374300) {
                    if (hashCode != 67973692) {
                        if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                            c2 = 0;
                        }
                    } else if (simpleName.equals("Float")) {
                        c2 = 2;
                    }
                } else if (simpleName.equals("Long")) {
                    c2 = 1;
                }
            } else if (simpleName.equals("Integer")) {
                c2 = 3;
            }
            switch (c2) {
                case 0:
                    return (T) Boolean.valueOf(f4056b.getBoolean(str, ((Boolean) t).booleanValue()));
                case 1:
                    return (T) Long.valueOf(f4056b.getLong(str, ((Long) t).longValue()));
                case 2:
                    return (T) Float.valueOf(f4056b.getFloat(str, ((Float) t).floatValue()));
                case 3:
                    return (T) Integer.valueOf(f4056b.getInt(str, ((Integer) t).intValue()));
                default:
                    return (T) f4056b.getString(str, (String) t);
            }
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
            if (f4055a == null) {
                f4055a = new SharedPreferencesUtil(context, c);
            }
        }
    }

    public static boolean put(String str, Object obj) {
        boolean z = true;
        SharedPreferences.Editor edit = f4056b.edit();
        String simpleName = obj.getClass().getSimpleName();
        char c2 = 65535;
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode != -672261858) {
                if (hashCode != 2374300) {
                    if (hashCode != 67973692) {
                        if (hashCode == 1729365000 && simpleName.equals("Boolean")) {
                            c2 = 0;
                        }
                    } else if (simpleName.equals("Float")) {
                        c2 = 2;
                    }
                } else if (simpleName.equals("Long")) {
                    c2 = 1;
                }
            } else if (simpleName.equals("Integer")) {
                c2 = 3;
            }
            switch (c2) {
                case 0:
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    break;
                case 1:
                    edit.putLong(str, ((Long) obj).longValue());
                    break;
                case 2:
                    edit.putFloat(str, ((Float) obj).floatValue());
                    break;
                case 3:
                    edit.putInt(str, ((Integer) obj).intValue());
                    break;
                default:
                    edit.putString(str, (String) obj);
                    break;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            z = false;
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
        f4056b.edit().remove(str).apply();
    }
}
