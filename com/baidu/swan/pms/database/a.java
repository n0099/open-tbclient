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
/* loaded from: classes15.dex */
public abstract class a {
    private static volatile a ehq;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean ae(String str, int i);

    public abstract boolean ae(String str, String str2, String str3);

    @WorkerThread
    @NonNull
    public abstract List<g> af(@NonNull String str, int i);

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract Map<String, f> bbi();

    public abstract Map<String, PMSAppInfo> bbj();

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void dq(String str, String str2);

    public abstract h dr(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i yl(String str);

    public abstract PMSAppInfo ym(String str);

    public abstract boolean yn(String str);

    @WorkerThread
    public abstract int yo(@NonNull String str);

    public abstract void yp(String str);

    public static a bbh() {
        if (ehq == null) {
            synchronized (a.class) {
                if (ehq == null) {
                    ehq = new b();
                }
            }
        }
        return ehq;
    }
}
