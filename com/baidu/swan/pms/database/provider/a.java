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
    private static volatile a bLJ;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> bLI;

    private void abc() {
        this.bLI = new ConcurrentHashMap<>();
        this.bLI.put(f.class, new e());
        this.bLI.put(h.class, new com.baidu.swan.pms.database.b.f());
        this.bLI.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.bLI.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.bLI.put(com.baidu.swan.pms.model.b.class, new c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        abc();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a abd() {
        if (bLJ == null) {
            synchronized (a.class) {
                if (bLJ == null) {
                    bLJ = new a();
                }
            }
        }
        return bLJ;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bLI.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.bLI.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
