package com.baidu.sofire.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.d;
import com.baidu.sofire.core.f;
import com.baidu.sofire.core.g;
import com.baidu.sofire.core.h;
import com.baidu.sofire.jni.Asc;
import com.tencent.connect.common.Constants;
import java.util.Map;
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
            return g.a().e(str);
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            b.a(str + ", " + intentFilter + ", " + str2 + ", " + str3);
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                g a = g.a();
                b.a("h=" + a);
                if (a != null) {
                    a.a(new h(str, intentFilter, str2, str3));
                    b.a("intentFilter.hasAction(Intent.ACTION_BOOT_COMPLETED)" + intentFilter.hasAction("android.intent.action.BOOT_COMPLETED"));
                    if (intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")) {
                        a a2 = a.a();
                        b.a("d=" + a2);
                        if (a2 != null) {
                            a2.a(str, str2, str3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            e.a(th);
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
            e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
            b.a(str + ", " + str2 + ", " + str3 + ", " + callback);
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
                        Object a3 = e.a(a2.getDeclaredMethod("getInstance", Context.class).invoke(a2, null), str3, clsArr, objArr);
                        b.a("result object=" + a3);
                        if (callback != null) {
                            callback.onEnd(a3);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            d.a().b(str);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        try {
            a a = a.a();
            if (a != null) {
                a.a(i, z ? 1 : 0);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    e.g("0");
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.g("1");
                        byte[] ac = sAsc.ac(bArr, bArr2);
                        if (ac == null || ac.length == 0) {
                            e.g("2");
                            return ac;
                        }
                        return ac;
                    }
                    return a;
                }
            } catch (Throwable th) {
                e.a(th);
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
                    e.g("3");
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr, true);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.g("4");
                        byte[] dc = sAsc.dc(bArr, bArr2);
                        if (dc == null || dc.length == 0) {
                            e.g("5");
                            return dc;
                        }
                        return dc;
                    }
                    return a;
                }
            } catch (Throwable th) {
                e.a(th);
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
                    e.g(Constants.VIA_SHARE_TYPE_INFO);
                    byte[] b = com.baidu.sofire.b.h.b(bArr, bArr2);
                    if (b == null || b.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        e.g("7");
                        byte[] ar = sAsc.ar(bArr, bArr2);
                        if (ar == null || ar.length == 0) {
                            e.g(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
                            return ar;
                        }
                        return ar;
                    }
                    return b;
                }
            } catch (Throwable th) {
                e.a(th);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        ?? r1 = 0;
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a = com.baidu.sofire.b.h.a(bArr, bArr2);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        byte[] dr = sAsc.dr(bArr, bArr2);
                        if (dr != null) {
                            r1 = dr.length;
                            return r1 == 0 ? dr : dr;
                        }
                        return dr;
                    }
                    return a;
                }
            } catch (Throwable th) {
                e.a(th);
                return r1;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            a a = a.a();
            if (a != null) {
                a.a(str, z ? 1 : 0);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        try {
            new U(context.getApplicationContext(), 5, true).start();
        } catch (Throwable th) {
            e.a(th);
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
            e.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        try {
            return e.a(context, str);
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        try {
            a a = a.a();
            if (a != null) {
                return a.c();
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Pair<Integer, Object> a;
        try {
            d a2 = d.a();
            if (a2 == null) {
                a = new Pair<>(4, null);
            } else {
                a = a2.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            e.a(th);
            return new Pair<>(3, null);
        }
    }
}
