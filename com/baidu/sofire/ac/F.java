package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.appsearchlib.Info;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.jni.Asc;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
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
            ApkInfo apkInfo = e.uS().a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        try {
            new StringBuilder().append(str).append(", ").append(intentFilter).append(", ").append(str2).append(", ").append(str3);
            if (!TextUtils.isEmpty(str) && intentFilter != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                e uS = e.uS();
                new StringBuilder("h=").append(uS);
                if (uS != null) {
                    uS.a(new f(str, intentFilter, str2, str3));
                    new StringBuilder().append(intentFilter.hasAction("android.intent.action.BOOT_COMPLETED"));
                    if (intentFilter.hasAction("android.intent.action.BOOT_COMPLETED")) {
                        a aVar = a.aES;
                        new StringBuilder("d=").append(aVar);
                        if (aVar != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("r", (Integer) 1);
                            contentValues.put("b", str2);
                            contentValues.put(Info.kBaiduTimeKey, str3);
                            aVar.aER.update("pgn", contentValues, "p=?", new String[]{str});
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        e uS;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (uS = e.uS()) != null) {
                uS.b(new f(str, intentFilter, str2, str3));
            }
        } catch (Throwable th) {
            d.a(th);
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
                e uS = e.uS();
                if (uS == null) {
                    if (callback != null) {
                        callback.onEnd(new Object[0]);
                    }
                } else {
                    ApkInfo cf = uS.cf(str2);
                    if (uS.cf(str) == null || cf == null) {
                        if (callback != null) {
                            callback.onEnd(new Object[0]);
                        }
                    } else {
                        Class<?> ce = ((com.baidu.sofire.core.d) cf.classLoader).ce("com.baidu.sofire.engine.EngineImpl");
                        Object a = d.a(ce.getDeclaredMethod("getInstance", Context.class).invoke(ce, null), str3, clsArr, objArr);
                        new StringBuilder().append(a);
                        if (callback != null) {
                            callback.onEnd(a);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            c uR = c.uR();
            new StringBuilder().append(str);
            new c.AnonymousClass4(str).start();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        return sAsc.ac(bArr, bArr2);
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a(th);
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
                    byte[] a = com.baidu.sofire.b.a.a(bArr2, bArr, true);
                    if (a == null || a.length <= 0) {
                        if (sAsc == null) {
                            sAsc = new Asc();
                        }
                        return sAsc.dc(bArr, bArr2);
                    }
                    return a;
                }
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        try {
            if (sAsc == null) {
                sAsc = new Asc();
            }
            return sAsc.ar(bArr, bArr2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        try {
            if (sAsc == null) {
                sAsc = new Asc();
            }
            return sAsc.dr(bArr, bArr2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        try {
            new U(context.getApplicationContext(), 5, true).start();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gs(String str) {
        ApkInfo cf;
        try {
            e uS = e.uS();
            if (uS != null && (cf = uS.cf(str)) != null) {
                return cf.libPath;
            }
            return "";
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        try {
            return d.a(context, str);
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return FH.callSync(i, str, clsArr, objArr);
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i, boolean z) {
        try {
            a aVar = a.aES;
            if (aVar != null) {
                int i2 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put(NotifyType.SOUND, Integer.valueOf(i2));
                aVar.aER.update("pgn", contentValues, "k=" + i + " and n=1", null);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            a aVar = a.aES;
            if (aVar != null) {
                int i = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put(NotifyType.SOUND, Integer.valueOf(i));
                aVar.aER.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
