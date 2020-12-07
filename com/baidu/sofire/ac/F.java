package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.b;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.i.a;
import com.baidu.sofire.i.e;
import com.baidu.sofire.i.h;
import com.baidu.sofire.i.i;
import com.baidu.sofire.i.u;
import com.baidu.sofire.jni.Asc;
import java.util.Map;
/* loaded from: classes8.dex */
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
            ApkInfo apkInfo = f.a().f3618a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            new StringBuilder().append(str).append(", ").append(intentFilter).append(", ").append(str2).append(", ").append(str3);
            b.a();
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                f a2 = f.a();
                new StringBuilder("h=").append(a2);
                b.a();
                if (a2 != null) {
                    a2.a(new g(str, intentFilter, str2, str3));
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (a2 = f.a()) != null) {
                a2.b(new g(str, intentFilter, str2, str3));
            }
        } catch (Throwable th) {
            e.a();
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
                f a2 = f.a();
                if (a2 == null) {
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                    }
                } else {
                    ApkInfo d = a2.d(str2);
                    if (a2.d(str) == null || d == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } else {
                        Class<?> a3 = ((com.baidu.sofire.core.e) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object a4 = e.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, null), str3, clsArr, objArr);
                        new StringBuilder().append(a4);
                        b.a();
                        if (callback != null) {
                            callback.onEnd(a4);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            e.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            c.a().a(str);
        } catch (Throwable th) {
            e.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    e.e("0");
                    byte[] a2 = a.a(bArr2, bArr);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.e("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            e.e("2");
                            return ac;
                        }
                        return ac;
                    }
                    return a2;
                }
            } catch (Throwable th) {
                e.a();
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
                    e.e("3");
                    byte[] a2 = a.a(bArr2, bArr, true);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.e("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            e.e("5");
                            return dc;
                        }
                        return dc;
                    }
                    return a2;
                }
            } catch (Throwable th) {
                e.a();
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
                    e.e("6");
                    byte[] a2 = (bArr == null || bArr2 == null) ? null : i.a(bArr, bArr2);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.e("7");
                        byte[] ar = sAsc.ar(bArr, bArr2);
                        if (ar == null || ar.length == 0) {
                            e.e("8");
                            return ar;
                        }
                        return ar;
                    }
                    return a2;
                }
            } catch (Throwable th) {
                e.a();
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
                    byte[] a2 = (bArr == null || bArr2 == null) ? null : i.a(bArr, bArr2);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        return sAsc.dr(bArr, bArr2);
                    }
                    return a2;
                }
            } catch (Throwable th) {
                e.a();
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
            e.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo d;
        try {
            f a2 = f.a();
            if (a2 != null && (d = a2.d(str)) != null) {
                return d.libPath;
            }
            return "";
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        return true;
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a2;
        try {
            c a3 = c.a();
            if (a3 == null) {
                a2 = new Pair<>(4, null);
            } else {
                a2 = a3.a(i, str, clsArr, objArr);
            }
            return a2;
        } catch (Throwable th) {
            e.a();
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        try {
            u.a(context);
            return u.a();
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        return h.b(context);
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
            e.a();
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
            e.a();
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
            e.a();
        }
        return null;
    }
}
