package com.baidu.swan.pms.database;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import java.util.List;
import java.util.Map;
/* loaded from: classes19.dex */
public abstract class a {
    private static volatile a dvK;

    public abstract boolean W(String str, String str2, String str3);

    public abstract boolean Z(String str, int i);

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, f> aKT();

    public abstract Map<String, PMSAppInfo> aKU();

    @WorkerThread
    @NonNull
    public abstract List<g> aa(@NonNull String str, int i);

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void cO(String str, String str2);

    public abstract h cP(String str, String str2);

    public abstract com.baidu.swan.pms.b.a cQ(@NonNull String str, @NonNull String str2);

    public abstract boolean d(@NonNull com.baidu.swan.pms.b.a aVar);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    public abstract PMSAppInfo uq(String str);

    public abstract boolean ur(String str);

    @WorkerThread
    public abstract int us(@NonNull String str);

    public abstract void ut(String str);

    public static a aKS() {
        if (dvK == null) {
            synchronized (a.class) {
                if (dvK == null) {
                    dvK = new b();
                }
            }
        }
        return dvK;
    }
}
