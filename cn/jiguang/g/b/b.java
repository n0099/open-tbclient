package cn.jiguang.g.b;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Build;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes3.dex */
public final class b {
    public static a a(SharedPreferences sharedPreferences, a aVar) {
        a aVar2 = new a();
        if (aVar == null) {
            return aVar2;
        }
        for (Map.Entry<String, Serializable> entry : aVar.a()) {
            String key = entry.getKey();
            Serializable a = a(sharedPreferences, key, a.a(entry.getValue()));
            if (a != null) {
                aVar2.a(key, a);
            }
        }
        return aVar2;
    }

    public static Serializable a(SharedPreferences sharedPreferences, String str, int i) {
        if (sharedPreferences.contains(str)) {
            try {
                switch (i) {
                    case 0:
                        try {
                            return sharedPreferences.getString(str, null);
                        } catch (ClassCastException e) {
                            return a.a(sharedPreferences, str);
                        }
                    case 1:
                        return sharedPreferences.getString(str, null);
                    case 2:
                        try {
                            return Integer.valueOf(sharedPreferences.getInt(str, 0));
                        } catch (ClassCastException e2) {
                            long j = sharedPreferences.getLong(str, 0L);
                            int i2 = (int) j;
                            if (i2 == j) {
                                return Integer.valueOf(i2);
                            }
                            throw e2;
                        }
                    case 3:
                        return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                    case 4:
                        try {
                            return Long.valueOf(sharedPreferences.getLong(str, 0L));
                        } catch (ClassCastException e3) {
                            return Long.valueOf(sharedPreferences.getInt(str, 0));
                        }
                    case 5:
                        return Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                    case 6:
                        return a.a(sharedPreferences, str);
                    default:
                        throw new IllegalArgumentException("[SpHelper], action - readInternal , unsupport type");
                }
            } catch (Throwable th) {
                cn.jiguang.e.c.c("SpHelper", "exception when get [" + str + "]" + th.getMessage(), th);
                return null;
            }
            cn.jiguang.e.c.c("SpHelper", "exception when get [" + str + "]" + th.getMessage(), th);
            return null;
        }
        return null;
    }

    public static <T extends Serializable> T a(SharedPreferences sharedPreferences, String str, T t) {
        try {
            T t2 = (T) a(sharedPreferences, str, a.a(t));
            return t2 == null ? t : t2;
        } catch (Throwable th) {
            cn.jiguang.e.c.c("SpHelper", th.getMessage(), th);
            return t;
        }
    }

    private static <T extends Serializable> void a(SharedPreferences.Editor editor, String str, T t) {
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else if (!(t instanceof HashSet) || Build.VERSION.SDK_INT < 11) {
        } else {
            try {
                editor.putStringSet(str, (HashSet) t);
            } catch (ClassCastException e) {
            }
        }
    }

    public static boolean a(SharedPreferences sharedPreferences, ContentValues contentValues) {
        if (contentValues == null) {
            return true;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            a(edit, entry.getKey(), (Serializable) entry.getValue());
        }
        return edit.commit();
    }

    public static boolean b(SharedPreferences sharedPreferences, a aVar) {
        if (aVar == null) {
            return true;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (Map.Entry<String, Serializable> entry : aVar.a()) {
            a(edit, entry.getKey(), entry.getValue());
        }
        return edit.commit();
    }

    public static <T extends Serializable> boolean b(SharedPreferences sharedPreferences, String str, T t) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        a(edit, str, t);
        return edit.commit();
    }
}
