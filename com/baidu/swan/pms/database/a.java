package com.baidu.swan.pms.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a {
    private static volatile a etM;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean aj(String str, int i);

    @NonNull
    @WorkerThread
    public abstract List<g> ak(@NonNull String str, int i);

    public abstract boolean ak(String str, String str2, String str3);

    public abstract Map<String, f> bcw();

    public abstract Map<String, PMSAppInfo> bcx();

    public abstract <T extends e> boolean c(T t);

    public abstract <T extends e> boolean c(Class<T> cls, String str);

    public abstract <T extends e> T d(Class<T> cls, String str);

    /* renamed from: do  reason: not valid java name */
    public abstract void mo30do(String str, String str2);

    public abstract h dp(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i xU(String str);

    public abstract PMSAppInfo xV(String str);

    public abstract boolean xW(String str);

    @WorkerThread
    public abstract int xX(@NonNull String str);

    public abstract void xY(String str);

    public static a bcv() {
        if (etM == null) {
            synchronized (a.class) {
                if (etM == null) {
                    etM = new b();
                }
            }
        }
        return etM;
    }
}
