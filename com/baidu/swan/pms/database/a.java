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
    private static volatile a dli;

    public abstract boolean V(String str, String str2, String str3);

    public abstract boolean Z(String str, int i);

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, f> aFW();

    public abstract Map<String, PMSAppInfo> aFX();

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract void cJ(String str, String str2);

    public abstract h cK(String str, String str2);

    public abstract com.baidu.swan.pms.b.a cL(@NonNull String str, @NonNull String str2);

    public abstract boolean d(@NonNull com.baidu.swan.pms.b.a aVar);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean o(PMSAppInfo pMSAppInfo);

    public abstract PMSAppInfo tf(String str);

    public abstract boolean tg(String str);

    public abstract void th(String str);

    public static a aFV() {
        if (dli == null) {
            synchronized (a.class) {
                if (dli == null) {
                    dli = new b();
                }
            }
        }
        return dli;
    }
}
