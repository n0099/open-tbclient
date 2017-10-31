package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.jni.Asc;
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
        return e.nn().e(str);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: boolean : 0x006e: INVOKE  (r1v7 boolean A[REMOVE]) = (r8v0 android.content.IntentFilter), ("android.intent.action.BOOT_COMPLETED") type: VIRTUAL call: android.content.IntentFilter.hasAction(java.lang.String):boolean)] */
    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        String str4 = str + ", " + intentFilter + ", " + str2 + ", " + str3;
        b.a();
        if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            e nn = e.nn();
            String str5 = "h=" + nn;
            b.a();
            if (nn != null) {
                nn.a(new f(str, intentFilter, str2, str3));
                new StringBuilder().append(intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")).toString();
                b.a();
                if (intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")) {
                    a aVar = a.PM;
                    String str6 = "d=" + aVar;
                    b.a();
                    if (aVar != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("r", (Integer) 1);
                        contentValues.put("b", str2);
                        contentValues.put(Info.kBaiduTimeKey, str3);
                        try {
                            aVar.PL.update("pgn", contentValues, "p=?", new String[]{str});
                        } catch (Throwable th) {
                            d.a(th);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        e nn;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (nn = e.nn()) != null) {
            nn.b(new f(str, intentFilter, str2, str3));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v21 java.lang.Object)] */
    @Override // com.baidu.sofire.ac.FI
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        String str4 = str + ", " + str2 + ", " + str3 + ", " + callback;
        b.a();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
                return;
            }
            return;
        }
        e nn = e.nn();
        if (nn == null) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
                return;
            }
            return;
        }
        ApkInfo bX = nn.bX(str2);
        if (nn.bX(str) == null || bX == null) {
            if (callback != null) {
                callback.onEnd(new Object[0]);
                return;
            }
            return;
        }
        try {
            Class<?> bW = ((com.baidu.sofire.core.d) bX.classLoader).bW("com.baidu.sofire.engine.EngineImpl");
            Object a = d.a(bW.getDeclaredMethod("getInstance", Context.class).invoke(bW, null), str3, clsArr, objArr);
            new StringBuilder().append(a).toString();
            b.a();
            if (callback != null) {
                callback.onEnd(a);
            }
        } catch (Throwable th) {
            th.getMessage();
            b.b();
            if (callback != null) {
                callback.onEnd(new Object[0]);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        c.nm().a(str);
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        a aVar = a.PM;
        if (aVar != null) {
            int i2 = z ? 1 : 0;
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i2));
            try {
                aVar.PL.update("pgn", contentValues, "k=" + i + " and n=1", null);
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length <= 0 || bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr);
        if (a == null || a.length <= 0) {
            if (sAsc == null) {
                sAsc = new Asc();
            }
            try {
                return sAsc.ac(bArr, bArr2);
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }
        return a;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr2.length <= 0 || bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr, true);
        if (a == null || a.length <= 0) {
            if (sAsc == null) {
                sAsc = new Asc();
            }
            try {
                return sAsc.dc(bArr, bArr2);
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }
        return a;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        if (sAsc == null) {
            sAsc = new Asc();
        }
        try {
            return sAsc.ar(bArr, bArr2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        if (sAsc == null) {
            sAsc = new Asc();
        }
        try {
            return sAsc.dr(bArr, bArr2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        a aVar = a.PM;
        if (aVar != null) {
            int i = z ? 1 : 0;
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i));
            try {
                aVar.PL.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        new U(context.getApplicationContext(), 5, true).start();
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo bX;
        e nn = e.nn();
        if (nn != null && (bX = nn.bX(str)) != null) {
            return bX.libPath;
        }
        return "";
    }
}
