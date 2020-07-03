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
    private static volatile a dpY;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> dpX;

    private void aHh() {
        this.dpX = new ConcurrentHashMap<>();
        this.dpX.put(f.class, new e());
        this.dpX.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.dpX.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.dpX.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.dpX.put(com.baidu.swan.pms.model.b.class, new c());
        this.dpX.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.dpX.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        aHh();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a aHi() {
        if (dpY == null) {
            synchronized (a.class) {
                if (dpY == null) {
                    dpY = new a();
                }
            }
        }
        return dpY;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dpX.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dpX.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        dpY = null;
    }
}
