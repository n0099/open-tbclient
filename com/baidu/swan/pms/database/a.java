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
    private static volatile a evn;

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract boolean ak(String str, int i);

    public abstract boolean ak(String str, String str2, String str3);

    @NonNull
    @WorkerThread
    public abstract List<g> al(@NonNull String str, int i);

    public abstract Map<String, f> bcy();

    public abstract Map<String, PMSAppInfo> bcz();

    public abstract <T extends e> boolean c(T t);

    public abstract <T extends e> boolean c(Class<T> cls, String str);

    public abstract <T extends e> T d(Class<T> cls, String str);

    /* renamed from: do  reason: not valid java name */
    public abstract void mo31do(String str, String str2);

    public abstract h dp(String str, String str2);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean r(PMSAppInfo pMSAppInfo);

    public abstract boolean s(PMSAppInfo pMSAppInfo);

    @Nullable
    public abstract i yb(String str);

    public abstract PMSAppInfo yc(String str);

    public abstract boolean yd(String str);

    @WorkerThread
    public abstract int ye(@NonNull String str);

    public abstract void yf(String str);

    public static a bcx() {
        if (evn == null) {
            synchronized (a.class) {
                if (evn == null) {
                    evn = new b();
                }
            }
        }
        return evn;
    }
}
