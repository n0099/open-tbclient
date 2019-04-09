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
    private static volatile a blK;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> blJ;

    private void RD() {
        this.blJ = new ConcurrentHashMap<>();
        this.blJ.put(g.class, new e());
        this.blJ.put(i.class, new f());
        this.blJ.put(com.baidu.swan.pms.model.a.class, new com.baidu.swan.pms.database.b.b());
        this.blJ.put(com.baidu.swan.pms.model.e.class, new d());
        this.blJ.put(c.class, new com.baidu.swan.pms.database.b.c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        RD();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a RE() {
        if (blK == null) {
            synchronized (a.class) {
                if (blK == null) {
                    blK = new a();
                }
            }
        }
        return blK;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blJ.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blJ.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
