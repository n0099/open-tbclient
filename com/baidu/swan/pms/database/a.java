package com.baidu.swan.pms.database;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.e;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.h;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a {
    private static volatile a bKN;

    public abstract boolean I(String str, int i);

    public abstract boolean a(f fVar, List<h> list, d dVar, com.baidu.swan.pms.model.b bVar, PMSAppInfo pMSAppInfo);

    public abstract Map<String, PMSAppInfo> aaW();

    public abstract <T extends e> boolean b(Class<T> cls, String str);

    public abstract <T extends e> boolean c(T t);

    public abstract <T extends e> boolean d(T t);

    public abstract boolean f(PMSAppInfo pMSAppInfo);

    public abstract PMSAppInfo kT(String str);

    public abstract boolean kU(String str);

    public static a aaV() {
        if (bKN == null) {
            synchronized (a.class) {
                if (bKN == null) {
                    bKN = new b();
                }
            }
        }
        return bKN;
    }
}
