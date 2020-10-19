package com.baidu.swan.pms.database.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.b.c;
import com.baidu.swan.pms.database.b.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes15.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 10;
    private static volatile a dTh;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> dTg;

    private void aWU() {
        this.dTg = new ConcurrentHashMap<>();
        this.dTg.put(f.class, new e());
        this.dTg.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.dTg.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.dTg.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.dTg.put(com.baidu.swan.pms.model.b.class, new c());
        this.dTg.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.dTg.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.dTg.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        aWU();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a aWV() {
        if (dTh == null) {
            synchronized (a.class) {
                if (dTh == null) {
                    dTh = new a();
                }
            }
        }
        return dTh;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dTg.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dTg.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        dTh = null;
    }
}
