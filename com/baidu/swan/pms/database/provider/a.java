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
    private static volatile a cAO;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> cAN;

    private void atB() {
        this.cAN = new ConcurrentHashMap<>();
        this.cAN.put(f.class, new e());
        this.cAN.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.cAN.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.cAN.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.cAN.put(com.baidu.swan.pms.model.b.class, new c());
        this.cAN.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.cAN.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        atB();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a atC() {
        if (cAO == null) {
            synchronized (a.class) {
                if (cAO == null) {
                    cAO = new a();
                }
            }
        }
        return cAO;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cAN.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cAN.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        cAO = null;
    }
}
