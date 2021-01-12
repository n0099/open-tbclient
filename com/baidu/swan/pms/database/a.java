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
/* loaded from: classes6.dex */
public abstract class a {
    private static volatile a erF;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean ah(String str, int i);

    @NonNull
    @WorkerThread
    public abstract List<g> ai(@NonNull String str, int i);

    public abstract boolean aj(String str, String str2, String str3);

    public abstract Map<String, f> bcj();

    public abstract Map<String, PMSAppInfo> bck();

    public abstract <T extends e> boolean c(T t);

    public abstract <T extends e> boolean c(Class<T> cls, String str);

    public abstract <T extends e> T d(Class<T> cls, String str);

    public abstract void du(String str, String str2);

    public abstract h dv(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i xB(String str);

    public abstract PMSAppInfo xC(String str);

    public abstract boolean xD(String str);

    @WorkerThread
    public abstract int xE(@NonNull String str);

    public abstract void xF(String str);

    public static a bci() {
        if (erF == null) {
            synchronized (a.class) {
                if (erF == null) {
                    erF = new b();
                }
            }
        }
        return erF;
    }
}
