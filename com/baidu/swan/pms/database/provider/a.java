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
    private static final int DB_VERSION = 7;
    private static volatile a dln;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> dlm;

    private void aGb() {
        this.dlm = new ConcurrentHashMap<>();
        this.dlm.put(f.class, new e());
        this.dlm.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.dlm.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.dlm.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.dlm.put(com.baidu.swan.pms.model.b.class, new c());
        this.dlm.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.dlm.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        aGb();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a aGc() {
        if (dln == null) {
            synchronized (a.class) {
                if (dln == null) {
                    dln = new a();
                }
            }
        }
        return dln;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dlm.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dlm.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        dln = null;
    }
}
