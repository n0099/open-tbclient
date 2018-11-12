package cn.jiguang.g.b;

import android.content.SharedPreferences;
import android.os.Build;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class a {
    private HashMap<String, Serializable> a = new HashMap<>(5);

    public static HashSet<String> a(SharedPreferences sharedPreferences, String str) {
        Set<String> stringSet;
        if (Build.VERSION.SDK_INT < 11 || (stringSet = sharedPreferences.getStringSet(str, null)) == null) {
            return null;
        }
        if (stringSet instanceof HashSet) {
            return (HashSet) stringSet;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (String str2 : stringSet) {
            hashSet.add(str2);
        }
        return hashSet;
    }

    public static int b(Serializable serializable) {
        if (serializable == null) {
            return 0;
        }
        if (serializable instanceof String) {
            return 1;
        }
        if (serializable instanceof Integer) {
            return 2;
        }
        if (serializable instanceof Long) {
            return 4;
        }
        if (serializable instanceof Boolean) {
            return 3;
        }
        if (serializable instanceof Float) {
            return 5;
        }
        return serializable instanceof HashSet ? 6 : 0;
    }

    public final a a(String str, Serializable serializable) {
        this.a.put(str, serializable);
        return this;
    }

    public final Set<Map.Entry<String, Serializable>> a() {
        return this.a.entrySet();
    }

    public final int b() {
        return this.a.size();
    }

    public final <T extends Serializable> T b(String str, T t) {
        try {
            T t2 = (T) this.a.get(str);
            return t2 == null ? t : t2;
        } catch (Throwable th) {
            return t;
        }
    }

    public final a c(String str, long j) {
        this.a.put(str, Long.valueOf(j));
        return this;
    }

    public final a f(String str, int i) {
        this.a.put(str, Integer.valueOf(i));
        return this;
    }

    public final a l(String str, String str2) {
        this.a.put(str, str2);
        return this;
    }

    public final String toString() {
        return "values=" + this.a;
    }
}
