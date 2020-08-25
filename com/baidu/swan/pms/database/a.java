package com.baidu.swan.pms.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes14.dex */
public abstract class a {
    private static volatile a dET;

    public abstract boolean W(String str, String str2, String str3);

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, f> aTu();

    public abstract Map<String, PMSAppInfo> aTv();

    public abstract boolean ab(String str, int i);

    @WorkerThread
    @NonNull
    public abstract List<g> ac(@NonNull String str, int i);

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void de(String str, String str2);

    public abstract h df(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    public abstract boolean wA(String str);

    @WorkerThread
    public abstract int wB(@NonNull String str);

    public abstract void wC(String str);

    @Nullable
    public abstract i wy(String str);

    public abstract PMSAppInfo wz(String str);

    public static a aTt() {
        if (dET == null) {
            synchronized (a.class) {
                if (dET == null) {
                    dET = new b();
                }
            }
        }
        return dET;
    }
}
