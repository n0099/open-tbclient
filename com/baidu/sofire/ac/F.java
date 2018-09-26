package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.r;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.d;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.jni.Asc;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
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
            ApkInfo apkInfo = e.a().a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            new StringBuilder().append(str).append(", ").append(intentFilter).append(", ").append(str2).append(", ").append(str3);
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                e a = e.a();
                new StringBuilder("h=").append(a);
                if (a != null) {
                    a.a(new f(str, intentFilter, str2, str3));
                    new StringBuilder().append(intentFilter.hasAction("android.intent.action.BOOT_COMPLETED"));
                    if (intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")) {
                        a aVar = a.d;
                        new StringBuilder("d=").append(aVar);
                        if (aVar != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("r", (Integer) 1);
                            contentValues.put("b", str2);
                            contentValues.put("t", str3);
                            aVar.c.update("pgn", contentValues, "p=?", new String[]{str});
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        e a;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (a = e.a()) != null) {
                a.b(new f(str, intentFilter, str2, str3));
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            new StringBuilder().append(str).append(", ").append(str2).append(", ").append(str3).append(", ").append(callback);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                if (callback != null) {
                    callback.onEnd(new Object[0]);
                }
            } else {
                e a = e.a();
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
                        Class<?> a2 = ((d) d.classLoader).a("com.baidu.sofire.engine.EngineImpl");
                        Object a3 = com.baidu.sofire.b.e.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, null), str3, clsArr, objArr);
                        new StringBuilder().append(a3);
                        if (callback != null) {
                            callback.onEnd(a3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            c a = c.a();
            new StringBuilder().append(str);
            new c.AnonymousClass4(str).start();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    com.baidu.sofire.b.e.d("0");
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        com.baidu.sofire.b.e.d("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            com.baidu.sofire.b.e.d("2");
                            return ac;
                        }
                        return ac;
                    }
                    return a;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
                    com.baidu.sofire.b.e.d("3");
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr, true);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        com.baidu.sofire.b.e.d("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            com.baidu.sofire.b.e.d("5");
                            return dc;
                        }
                        return dc;
                    }
                    return a;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
                    com.baidu.sofire.b.e.d(Constants.VIA_SHARE_TYPE_INFO);
                    byte[] a = (bArr == null || bArr2 == null) ? null : r.a(bArr, bArr2);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        com.baidu.sofire.b.e.d("7");
                        byte[] ar = sAsc.ar(bArr, bArr2);
                        if (ar == null || ar.length == 0) {
                            com.baidu.sofire.b.e.d(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                            return ar;
                        }
                        return ar;
                    }
                    return a;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
                    com.baidu.sofire.b.e.d("9");
                    byte[] a = (bArr == null || bArr2 == null) ? null : r.a(bArr, bArr2);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        com.baidu.sofire.b.e.d(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                        byte[] dr = sAsc.dr(bArr, bArr2);
                        if (dr == null || dr.length == 0) {
                            com.baidu.sofire.b.e.d(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                            return dr;
                        }
                        return dr;
                    }
                    return a;
                }
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
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
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo d;
        try {
            e a = e.a();
            if (a != null && (d = a.d(str)) != null) {
                return d.libPath;
            }
            return "";
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        try {
            return com.baidu.sofire.b.e.a(context, str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return false;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a;
        try {
            c a2 = c.a();
            if (a2 == null) {
                a = new Pair<>(3, null);
            } else {
                a = a2.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        try {
            a aVar = a.d;
            if (aVar != null) {
                int i2 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i2));
                aVar.c.update("pgn", contentValues, "k=" + i + " and n=1", null);
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            a aVar = a.d;
            if (aVar != null) {
                int i = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i));
                aVar.c.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
