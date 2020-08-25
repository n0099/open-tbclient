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
/* loaded from: classes14.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 10;
    private static volatile a dEY;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> dEX;

    private void aTz() {
        this.dEX = new ConcurrentHashMap<>();
        this.dEX.put(f.class, new e());
        this.dEX.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.dEX.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.dEX.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.dEX.put(com.baidu.swan.pms.model.b.class, new c());
        this.dEX.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.dEX.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.dEX.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        aTz();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a aTA() {
        if (dEY == null) {
            synchronized (a.class) {
                if (dEY == null) {
                    dEY = new a();
                }
            }
        }
        return dEY;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dEX.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.dEX.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        dEY = null;
    }
}
