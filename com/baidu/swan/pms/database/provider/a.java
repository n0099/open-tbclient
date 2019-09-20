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
    private static volatile a bsY;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> bsX;

    private void Wn() {
        this.bsX = new ConcurrentHashMap<>();
        this.bsX.put(f.class, new e());
        this.bsX.put(h.class, new com.baidu.swan.pms.database.b.f());
        this.bsX.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.bsX.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.bsX.put(com.baidu.swan.pms.model.b.class, new c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        Wn();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a Wo() {
        if (bsY == null) {
            synchronized (a.class) {
                if (bsY == null) {
                    bsY = new a();
                }
            }
        }
        return bsY;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bsX.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bsX.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
