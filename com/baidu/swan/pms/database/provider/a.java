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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 6;
    private static volatile a cBa;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> cAZ;

    private void atE() {
        this.cAZ = new ConcurrentHashMap<>();
        this.cAZ.put(f.class, new e());
        this.cAZ.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.cAZ.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.cAZ.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.cAZ.put(com.baidu.swan.pms.model.b.class, new c());
        this.cAZ.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.cAZ.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        atE();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a atF() {
        if (cBa == null) {
            synchronized (a.class) {
                if (cBa == null) {
                    cBa = new a();
                }
            }
        }
        return cBa;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cAZ.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cAZ.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        cBa = null;
    }
}
