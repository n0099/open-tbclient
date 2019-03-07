package com.baidu.swan.pms.database.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.b.d;
import com.baidu.swan.pms.database.b.e;
import com.baidu.swan.pms.database.b.f;
import com.baidu.swan.pms.model.c;
import com.baidu.swan.pms.model.g;
import com.baidu.swan.pms.model.i;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
class a extends SQLiteOpenHelper {
    private static volatile a blF;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> blE;

    private void RF() {
        this.blE = new ConcurrentHashMap<>();
        this.blE.put(g.class, new e());
        this.blE.put(i.class, new f());
        this.blE.put(com.baidu.swan.pms.model.a.class, new com.baidu.swan.pms.database.b.b());
        this.blE.put(com.baidu.swan.pms.model.e.class, new d());
        this.blE.put(c.class, new com.baidu.swan.pms.database.b.c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        RF();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a RG() {
        if (blF == null) {
            synchronized (a.class) {
                if (blF == null) {
                    blF = new a();
                }
            }
        }
        return blF;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blE.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blE.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
