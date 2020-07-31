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
/* loaded from: classes19.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 8;
    private static volatile a dvP;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> dvO;

    private void aKY() {
        this.dvO = new ConcurrentHashMap<>();
        this.dvO.put(f.class, new e());
        this.dvO.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.dvO.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.dvO.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.dvO.put(com.baidu.swan.pms.model.b.class, new c());
        this.dvO.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.dvO.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        aKY();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a aKZ() {
        if (dvP == null) {
            synchronized (a.class) {
                if (dvP == null) {
                    dvP = new a();
                }
            }
        }
        return dvP;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dvO.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dvO.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        dvP = null;
    }
}
