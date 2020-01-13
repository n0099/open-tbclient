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
/* loaded from: classes10.dex */
public class a extends SQLiteOpenHelper {
    private static final int DB_VERSION = 6;
    private static volatile a cwP;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> cwO;

    private void arl() {
        this.cwO = new ConcurrentHashMap<>();
        this.cwO.put(f.class, new e());
        this.cwO.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.cwO.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.cwO.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.cwO.put(com.baidu.swan.pms.model.b.class, new c());
        this.cwO.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.cwO.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        arl();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a arm() {
        if (cwP == null) {
            synchronized (a.class) {
                if (cwP == null) {
                    cwP = new a();
                }
            }
        }
        return cwP;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cwO.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.cwO.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        cwP = null;
    }
}
