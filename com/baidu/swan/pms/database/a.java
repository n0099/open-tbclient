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
    private static volatile a emJ;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean af(String str, int i);

    @WorkerThread
    @NonNull
    public abstract List<g> ag(@NonNull String str, int i);

    public abstract boolean ah(String str, String str2, String str3);

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract Map<String, f> bdG();

    public abstract Map<String, PMSAppInfo> bdH();

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void dw(String str, String str2);

    public abstract h dx(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i yN(String str);

    public abstract PMSAppInfo yO(String str);

    public abstract boolean yP(String str);

    @WorkerThread
    public abstract int yQ(@NonNull String str);

    public abstract void yR(String str);

    public static a bdF() {
        if (emJ == null) {
            synchronized (a.class) {
                if (emJ == null) {
                    emJ = new b();
                }
            }
        }
        return emJ;
    }
}
