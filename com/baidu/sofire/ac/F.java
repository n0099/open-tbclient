package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.b;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.core.h;
import com.baidu.sofire.i.a;
import com.baidu.sofire.i.d;
import com.baidu.sofire.i.s;
import com.baidu.sofire.jni.Asc;
import java.util.Map;
/* loaded from: classes5.dex */
public class F implements FI {
    private static F instance;
    private static Asc sAsc;

    private F() {
    }

    public static synchronized F getInstance() {
        F f;
        synchronized (F.class) {
            if (instance == null) {
                instance = new F();
            }
            f = instance;
        }
        return f;
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        try {
            ApkInfo apkInfo = g.a().a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable th) {
            d.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            new StringBuilder().append(str).append(", ").append(intentFilter).append(", ").append(str2).append(", ").append(str3);
            b.a();
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                g a = g.a();
                new StringBuilder("h=").append(a);
                b.a();
                if (a != null) {
                    a.a(new h(str, intentFilter, str2, str3));
                }
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        g a;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (a = g.a()) != null) {
                a.b(new h(str, intentFilter, str2, str3));
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            new StringBuilder().append(str).append(", ").append(str2).append(", ").append(str3).append(", ").append(callback);
            b.a();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (callback != null) {
                    callback.onEnd(new Object[0]);
                }
            } else {
                g a = g.a();
                if (a == null) {
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                    }
                } else {
                    ApkInfo d = a.d(str2);
                    if (a.d(str) == null || d == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } else {
                        Class<?> a2 = ((f) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object a3 = d.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, null), str3, clsArr, objArr);
                        new StringBuilder().append(a3);
                        b.a();
                        if (callback != null) {
                            callback.onEnd(a3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            com.baidu.sofire.core.d.a().a(str);
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("0");
                    byte[] a = a.a(bArr2, bArr);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        d.e("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            d.e("2");
                            return ac;
                        }
                        return ac;
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a();
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("3");
                    byte[] a = a.a(bArr2, bArr, true);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        d.e("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            d.e("5");
                            return dc;
                        }
                        return dc;
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a();
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("6");
                    byte[] a = (bArr == null || bArr2 == null) ? null : com.baidu.sofire.i.h.a(bArr, bArr2);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        d.e("7");
                        byte[] ar = sAsc.ar(bArr, bArr2);
                        if (ar == null || ar.length == 0) {
                            d.e("8");
                            return ar;
                        }
                        return ar;
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a();
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a = (bArr == null || bArr2 == null) ? null : com.baidu.sofire.i.h.a(bArr, bArr2);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        return sAsc.dr(bArr, bArr2);
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a();
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        try {
            new U(context.getApplicationContext(), 5, true).start();
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo d;
        try {
            g a = g.a();
            if (a != null && (d = a.d(str)) != null) {
                return d.libPath;
            }
            return "";
        } catch (Throwable th) {
            d.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        return true;
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a;
        try {
            com.baidu.sofire.core.d a2 = com.baidu.sofire.core.d.a();
            if (a2 == null) {
                a = new Pair<>(4, null);
            } else {
                a = a2.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            d.a();
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        try {
            s.a(context);
            return s.a();
        } catch (Throwable th) {
            d.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        return com.baidu.sofire.i.g.b(context);
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar != null) {
                int i2 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i2));
                aVar.c.update("pgn", contentValues, "k=" + i + " and n=1", null);
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar != null) {
                int i = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i));
                aVar.c.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable th) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        try {
            com.baidu.sofire.c.a aVar = com.baidu.sofire.c.a.d;
            if (aVar != null) {
                return aVar.b();
            }
        } catch (Throwable th) {
            d.a();
        }
        return null;
    }
}
