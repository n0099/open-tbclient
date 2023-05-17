package com.baidu.pass.common;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public class SharedPreferencesUtil implements com.baidu.pass.a {
    public static SharedPreferencesUtil a = null;
    public static SharedPreferences b = null;
    public static final String c = "sapi_system";
    public static String d;
    public static Context e;

    public SharedPreferencesUtil(Context context, String str) {
        b = context.getSharedPreferences(str, 0);
        e = context.getApplicationContext();
    }

    public static <T> T get(String str, T t) {
        char c2;
        String simpleName = t.getClass().getSimpleName();
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode != -672261858) {
                if (hashCode != 2374300) {
                    if (hashCode != 67973692) {
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
                } else {
                    if (simpleName.equals("Long")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
            } else {
                if (simpleName.equals("Integer")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            return (T) b.getString(str, (String) t);
                        }
                        return (T) Integer.valueOf(b.getInt(str, ((Integer) t).intValue()));
                    }
                    return (T) Float.valueOf(b.getFloat(str, ((Float) t).floatValue()));
                }
                return (T) Long.valueOf(b.getLong(str, ((Long) t).longValue()));
            }
            return (T) Boolean.valueOf(b.getBoolean(str, ((Boolean) t).booleanValue()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized void getInstance(Context context) {
        synchronized (SharedPreferencesUtil.class) {
            if (a == null) {
                a = new SharedPreferencesUtil(context, c);
            }
        }
    }

    public static boolean put(String str, Object obj) {
        char c2;
        SharedPreferences.Editor edit = b.edit();
        String simpleName = obj.getClass().getSimpleName();
        boolean z = false;
        try {
            int hashCode = simpleName.hashCode();
            if (hashCode != -672261858) {
                if (hashCode != 2374300) {
                    if (hashCode != 67973692) {
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
                } else {
                    if (simpleName.equals("Long")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
            } else {
                if (simpleName.equals("Integer")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            edit.putString(str, (String) obj);
                        } else {
                            edit.putInt(str, ((Integer) obj).intValue());
                        }
                    } else {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } else {
                    edit.putLong(str, ((Long) obj).longValue());
                }
            } else {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            }
            z = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        edit.apply();
        return z;
    }
}
