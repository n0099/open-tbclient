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
    private static volatile a ehv;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> ehu;

    private void bbn() {
        this.ehu = new ConcurrentHashMap<>();
        this.ehu.put(f.class, new e());
        this.ehu.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.ehu.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.ehu.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.ehu.put(com.baidu.swan.pms.model.b.class, new c());
        this.ehu.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.ehu.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.ehu.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        bbn();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a bbo() {
        if (ehv == null) {
            synchronized (a.class) {
                if (ehv == null) {
                    ehv = new a();
                }
            }
        }
        return ehv;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.ehu.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.ehu.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        ehv = null;
    }
}
