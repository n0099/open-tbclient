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
    private static volatile a blJ;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> blI;

    private void RD() {
        this.blI = new ConcurrentHashMap<>();
        this.blI.put(g.class, new e());
        this.blI.put(i.class, new f());
        this.blI.put(com.baidu.swan.pms.model.a.class, new com.baidu.swan.pms.database.b.b());
        this.blI.put(com.baidu.swan.pms.model.e.class, new d());
        this.blI.put(c.class, new com.baidu.swan.pms.database.b.c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        RD();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a RE() {
        if (blJ == null) {
            synchronized (a.class) {
                if (blJ == null) {
                    blJ = new a();
                }
            }
        }
        return blJ;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blI.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.blI.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
