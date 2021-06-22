package com.baidu.sofire.ac;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.f;
import com.baidu.sofire.h.a;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.utility.c;
import com.baidu.sofire.utility.g;
import com.baidu.sofire.utility.t;
import com.baidu.sofire.utility.x;
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
                    byte[] a2 = g.a(bArr2, bArr);
                    if (a2 != null && a2.length != 0) {
                        return a2;
                    }
                    return new byte[0];
                }
            } catch (Throwable unused) {
                c.a();
                return new byte[0];
            }
        }
        return new byte[0];
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a2 = g.a(bArr2, bArr, true);
                    if (a2 != null && a2.length != 0) {
                        return a2;
                    }
                    return new byte[0];
                }
            } catch (Throwable unused) {
                c.a();
                return new byte[0];
            }
        }
        return new byte[0];
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean chh(Context context, String str) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        r8.onEnd(new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
        return;
     */
    @Override // com.baidu.sofire.ac.FI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
        try {
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
                Object a4 = c.a(a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, null), str3, clsArr, objArr);
                if (callback != null) {
                    callback.onEnd(a4);
                }
            }
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public Pair<Integer, Object> cmsi(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            com.baidu.sofire.core.c a2 = com.baidu.sofire.core.c.a();
            if (a2 == null) {
                return new Pair<>(4, null);
            }
            return a2.a(i2, str, clsArr, objArr);
        } catch (Throwable unused) {
            c.a();
            return new Pair<>(3, null);
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public boolean cp(Context context) {
        if (context == null) {
            return false;
        }
        return t.a(context);
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        if (context == null) {
            return null;
        }
        return a.a(context).a(str);
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return a.a(context).f10321a;
    }

    @Override // com.baidu.sofire.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return a.a(context).f10323c;
    }

    @Override // com.baidu.sofire.ac.FI
    public Map<Integer, String> gpd() {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f10167d;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (Throwable unused) {
            c.a();
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
            c.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public String gta(Context context) {
        return "";
    }

    @Override // com.baidu.sofire.ac.FI
    public String gzd(Context context) {
        return context == null ? "" : com.baidu.sofire.utility.e.b(context);
    }

    @Override // com.baidu.sofire.ac.FI
    public String p(String str) {
        try {
            ApkInfo apkInfo = f.a().f10279a.get(str);
            if (apkInfo == null) {
                return null;
            }
            return apkInfo.pkgPath;
        } catch (Throwable unused) {
            c.a();
            return "";
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        try {
            if (TextUtils.isEmpty(str) || intentFilter == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a2 = f.a()) == null) {
                return;
            }
            a2.a(new com.baidu.sofire.core.g(str, intentFilter, str2, str3));
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] c2 = g.c(bArr, bArr2);
                    if (c2 != null && c2.length != 0) {
                        return c2;
                    }
                    return new byte[0];
                }
            } catch (Throwable unused) {
                c.a();
                return new byte[0];
            }
        }
        return new byte[0];
    }

    @Override // com.baidu.sofire.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] b2 = g.b(bArr, bArr2);
                    if (b2 != null && b2.length != 0) {
                        return b2;
                    }
                    return new byte[0];
                }
            } catch (Throwable unused) {
                c.a();
                return new byte[0];
            }
        }
        return new byte[0];
    }

    @Override // com.baidu.sofire.ac.FI
    public void rf(Context context) {
        if (context == null) {
            return;
        }
        try {
            x.a(context).b(new U(context.getApplicationContext(), 5, true));
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void s(int i2, boolean z) {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f10167d;
            if (aVar != null) {
                int i3 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = aVar.f10170c;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i2 + " and n=1", null);
            }
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void sp(String str, boolean z) {
        try {
            com.baidu.sofire.a.a aVar = com.baidu.sofire.a.a.f10167d;
            if (aVar != null) {
                int i2 = z ? 1 : 0;
                ContentValues contentValues = new ContentValues();
                contentValues.put("s", Integer.valueOf(i2));
                aVar.f10170c.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            }
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void u(String str) {
        try {
            com.baidu.sofire.core.c.a().a(str);
        } catch (Throwable unused) {
            c.a();
        }
    }

    @Override // com.baidu.sofire.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
        f a2;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || (a2 = f.a()) == null) {
                return;
            }
            a2.b(new com.baidu.sofire.core.g(str, intentFilter, str2, str3));
        } catch (Throwable unused) {
            c.a();
        }
    }
}
