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
/* loaded from: classes6.dex */
public abstract class a {
    private static volatile a efI;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean ae(String str, int i);

    public abstract boolean ae(String str, String str2, String str3);

    @WorkerThread
    @NonNull
    public abstract List<g> af(@NonNull String str, int i);

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract Map<String, f> baB();

    public abstract Map<String, PMSAppInfo> baC();

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void dp(String str, String str2);

    public abstract h dq(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i yg(String str);

    public abstract PMSAppInfo yh(String str);

    public abstract boolean yi(String str);

    @WorkerThread
    public abstract int yj(@NonNull String str);

    public abstract void yk(String str);

    public static a baA() {
        if (efI == null) {
            synchronized (a.class) {
                if (efI == null) {
                    efI = new b();
                }
            }
        }
        return efI;
    }
}
