package com.baidu.swan.pms.database;

import android.support.annotation.NonNull;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public abstract class a {
    private static volatile a cAV;

    public abstract boolean Q(String str, int i);

    public abstract boolean Q(String str, String str2, String str3);

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, PMSAppInfo> atA();

    public abstract Map<String, f> atz();

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void cb(String str, String str2);

    public abstract h cc(String str, String str2);

    public abstract com.baidu.swan.pms.b.a cd(@NonNull String str, @NonNull String str2);

    public abstract boolean d(@NonNull com.baidu.swan.pms.b.a aVar);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean m(PMSAppInfo pMSAppInfo);

    public abstract PMSAppInfo qn(String str);

    public abstract boolean qo(String str);

    public abstract void qp(String str);

    public static a aty() {
        if (cAV == null) {
            synchronized (a.class) {
                if (cAV == null) {
                    cAV = new b();
                }
            }
        }
        return cAV;
    }
}
