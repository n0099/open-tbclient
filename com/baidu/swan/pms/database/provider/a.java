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
/* loaded from: classes6.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 10;
    private static volatile a ewx;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> eww;

    private void bgi() {
        this.eww = new ConcurrentHashMap<>();
        this.eww.put(f.class, new e());
        this.eww.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.eww.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.eww.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.eww.put(com.baidu.swan.pms.model.b.class, new c());
        this.eww.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.eww.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.eww.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        bgi();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a bgj() {
        if (ewx == null) {
            synchronized (a.class) {
                if (ewx == null) {
                    ewx = new a();
                }
            }
        }
        return ewx;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.eww.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.eww.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        ewx = null;
    }
}
