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
/* loaded from: classes10.dex */
public abstract class a {
    private static volatile a cwK;

    public abstract boolean P(String str, String str2, String str3);

    public abstract boolean S(String str, int i);

    public abstract boolean a(f fVar, PMSAppInfo pMSAppInfo);

    public abstract boolean a(f fVar, List<g> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, f> arg();

    public abstract Map<String, PMSAppInfo> arh();

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract void bT(String str, String str2);

    public abstract h bU(String str, String str2);

    public abstract com.baidu.swan.pms.b.a bV(@NonNull String str, @NonNull String str2);

    public abstract <T extends e> T c(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract boolean d(@NonNull com.baidu.swan.pms.b.a aVar);

    public abstract boolean f(h hVar);

    public abstract boolean g(h hVar);

    public abstract boolean m(PMSAppInfo pMSAppInfo);

    public abstract PMSAppInfo pZ(String str);

    public abstract boolean qa(String str);

    public abstract void qb(String str);

    public static a arf() {
        if (cwK == null) {
            synchronized (a.class) {
                if (cwK == null) {
                    cwK = new b();
                }
            }
        }
        return cwK;
    }
}
