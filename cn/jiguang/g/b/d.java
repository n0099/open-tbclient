package cn.jiguang.g.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes3.dex */
public final class d {
    private static Boolean e;
    private static Map<String, d> f = new HashMap();
    private static final Object g = new Object();
    private final String a;
    private String b;
    private SharedPreferences c;
    private ContentResolver mN;

    private d(Context context, String str) {
        this.a = str;
        a(context);
    }

    public static d O(Context context, String str) {
        d dVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar2 = f.get(str);
        if (dVar2 == null) {
            synchronized (g) {
                dVar = f.get(str);
                if (dVar == null) {
                    dVar = new d(context, str);
                    f.put(str, dVar);
                }
            }
            return dVar;
        }
        return dVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Context context) {
        boolean z;
        boolean z2;
        if (e == null) {
            Context X = cn.jiguang.d.a.X(context);
            if (X == null) {
                z = false;
                if (z) {
                    return false;
                }
                if (this.c != null) {
                    return true;
                }
                Context X2 = cn.jiguang.d.a.X(context);
                if (X2 != null) {
                    this.c = X2.getSharedPreferences(this.a, 0);
                    if (e.booleanValue()) {
                        this.b = "content://" + X2.getPackageName() + ".DataProvider/" + this.a;
                        this.mN = X2.getContentResolver();
                    }
                    return true;
                }
                return false;
            }
            ProviderInfo ao = cn.jiguang.g.a.ao(X);
            if (ao != null) {
                String c = cn.jiguang.d.b.a.c(X);
                if (TextUtils.isEmpty(c) || TextUtils.isEmpty(ao.processName) || !c.equals(ao.processName)) {
                    z2 = true;
                    e = Boolean.valueOf(z2);
                }
            }
            z2 = false;
            e = Boolean.valueOf(z2);
        }
        z = true;
        if (z) {
        }
    }

    public final a a(a aVar) {
        if (aVar == null || aVar.b() == 0) {
            return new a();
        }
        if (a((Context) null)) {
            if (e.booleanValue()) {
                try {
                    return c.a(this.mN, this.b, aVar);
                } catch (Throwable th) {
                    return b.a(this.c, aVar);
                }
            }
            return b.a(this.c, aVar);
        }
        return aVar;
    }

    public final boolean a() {
        if (a((Context) null)) {
            return this.c.edit().clear().commit();
        }
        return false;
    }

    public final boolean b(ContentValues contentValues) {
        if (a((Context) null)) {
            return b.a(this.c, contentValues);
        }
        return false;
    }

    public final boolean b(a aVar) {
        if (a((Context) null)) {
            if (e.booleanValue()) {
                try {
                    return c.b(this.mN, this.b, aVar);
                } catch (Throwable th) {
                    return b.b(this.c, aVar);
                }
            }
            return b.b(this.c, aVar);
        }
        return false;
    }

    public final <T extends Serializable> T c(String str, T t) {
        if (a((Context) null)) {
            if (e.booleanValue()) {
                try {
                    String type = this.mN.getType(Uri.parse(this.b).buildUpon().appendQueryParameter(RimArmor.KEY, str).appendQueryParameter("type", String.valueOf(a.b(t))).build());
                    if (type != null) {
                        t = t == null ? type : t instanceof Integer ? Integer.valueOf(type) : t instanceof Boolean ? Boolean.valueOf(type) : t instanceof Long ? Long.valueOf(type) : t instanceof Float ? Float.valueOf(type) : t instanceof String ? type : t instanceof HashSet ? null : null;
                    }
                    return t;
                } catch (Throwable th) {
                    return (T) b.a(this.c, str, t);
                }
            }
            return (T) b.a(this.c, str, t);
        }
        return t;
    }

    public final <T extends Serializable> boolean d(String str, T t) {
        if (a((Context) null)) {
            if (e.booleanValue()) {
                try {
                    return c.a(this.mN, this.b, str, t);
                } catch (Throwable th) {
                    return b.b(this.c, str, t);
                }
            }
            return b.b(this.c, str, t);
        }
        return false;
    }

    public final Serializable g(String str, int i) {
        if (a((Context) null)) {
            return b.a(this.c, str, i);
        }
        return null;
    }
}
