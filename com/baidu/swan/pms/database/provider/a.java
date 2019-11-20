package com.baidu.swan.pms.database.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.b.c;
import com.baidu.swan.pms.database.b.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
class a extends SQLiteOpenHelper {
    private static volatile a bKS;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> bKR;

    private void aba() {
        this.bKR = new ConcurrentHashMap<>();
        this.bKR.put(f.class, new e());
        this.bKR.put(h.class, new com.baidu.swan.pms.database.b.f());
        this.bKR.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.bKR.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.bKR.put(com.baidu.swan.pms.model.b.class, new c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        aba();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a abb() {
        if (bKS == null) {
            synchronized (a.class) {
                if (bKS == null) {
                    bKS = new a();
                }
            }
        }
        return bKS;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bKR.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bKR.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
