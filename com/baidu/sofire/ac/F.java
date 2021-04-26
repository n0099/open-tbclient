package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sofire.b;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.g.a;
import com.baidu.sofire.g.d;
import com.baidu.sofire.g.s;
import com.baidu.sofire.jni.Asc;
import java.util.Map;
/* loaded from: classes2.dex */
public class F implements FI {
    public static F instance;
    public static Asc sAsc;

    public static synchronized F getInstance() {
        F f2;
        synchronized (F.class) {
            if (instance == null) {
                instance = new F();
            }
            f2 = instance;
        }
        return f2;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("3");
                    byte[] a2 = a.a(bArr2, bArr, true);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        d.e("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            d.e("5");
                        }
                        return dc;
                    }
                    return a2;
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("0");
                    byte[] a2 = a.a(bArr2, bArr);
                    if (a2 == null || a2.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        d.e("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            d.e("2");
                        }
                        return ac;
                    }
                    return a2;
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a5, code lost:
        return;
     */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(str2);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(str3);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(callback);
            b.a();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                f a2 = f.a();
                if (a2 == null) {
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                        return;
                    }
                    return;
                }
                ApkInfo d2 = a2.d(str2);
                if (a2.d(str) == null || d2 == null) {
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                        return;
                    }
                    return;
                }
                Class<?> a3 = ((e) d2.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                Object a4 = d.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, null), str3, clsArr, objArr);
                new StringBuilder().append(a4);
                b.a();
                if (callback != null) {
                    callback.onEnd(a4);
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            c a2 = c.a();
            if (a2 == null) {
                return new Pair<>(4, null);
            }
            return a2.a(i2, str, clsArr, objArr);
        } catch (Throwable unused) {
            d.a();
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean cp(Context context) {
        return s.a(context);
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f11111d;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo d2;
        try {
            f a2 = f.a();
            return (a2 == null || (d2 = a2.d(str)) == null) ? "" : d2.libPath;
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        return "";
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        return com.baidu.sofire.g.f.b(context);
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        try {
            ApkInfo apkInfo = f.a().f11194a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(intentFilter);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(str2);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(str3);
            b.a();
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                f a2 = f.a();
                new StringBuilder("h=").append(a2);
                b.a();
                if (a2 != null) {
                    a2.a(new g(str, intentFilter, str2, str3));
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0021 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #2 {all -> 0x0033, blocks: (B:4:0x0003, B:7:0x0008, B:13:0x0011, B:16:0x0019, B:19:0x001d, B:21:0x0021, B:22:0x0028), top: B:28:0x0003 }] */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr != null && bArr2 != null) {
                        bArr3 = com.baidu.sofire.g.g.a(bArr, bArr2);
                        if (bArr3 != null || bArr3.length <= 0) {
                            if (sAsc == null) {
                                sAsc = new Asc();
                            }
                            return sAsc.dr(bArr, bArr2);
                        }
                        return bArr3;
                    }
                    bArr3 = null;
                    if (bArr3 != null) {
                    }
                    if (sAsc == null) {
                    }
                    return sAsc.dr(bArr, bArr2);
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0028 A[Catch: all -> 0x004a, TryCatch #1 {all -> 0x004a, blocks: (B:4:0x0005, B:7:0x000a, B:10:0x000e, B:14:0x0018, B:17:0x0020, B:20:0x0024, B:22:0x0028, B:23:0x002f, B:26:0x003c, B:28:0x003f, B:24:0x0034), top: B:34:0x0005 }] */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] re(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        byte[] ar;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    d.e("6");
                    if (bArr != null && bArr2 != null) {
                        bArr3 = com.baidu.sofire.g.g.a(bArr, bArr2);
                        if (bArr3 != null || bArr3.length <= 0) {
                            if (sAsc == null) {
                                sAsc = new Asc();
                            }
                            d.e("7");
                            ar = sAsc.ar(bArr, bArr2);
                            if (ar != null || ar.length == 0) {
                                d.e("8");
                            }
                            return ar;
                        }
                        return bArr3;
                    }
                    bArr3 = null;
                    if (bArr3 != null) {
                    }
                    if (sAsc == null) {
                    }
                    d.e("7");
                    ar = sAsc.ar(bArr, bArr2);
                    if (ar != null) {
                    }
                    d.e("8");
                    return ar;
                }
            } catch (Throwable unused) {
                d.a();
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        try {
            new U(context.getApplicationContext(), 5, true).start();
        } catch (Throwable unused) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i2, boolean z) {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f11111d;
            if (aVar != null) {
                int i3 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = aVar.f11114c;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i2 + " and n=1", null);
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f11111d;
            if (aVar != null) {
                int i2 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i2));
                aVar.f11114c.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable unused) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            c.a().a(str);
        } catch (Throwable unused) {
            d.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a2 = f.a()) == null) {
                return;
            }
            a2.b(new g(str, intentFilter, str2, str3));
        } catch (Throwable unused) {
            d.a();
        }
    }
}
