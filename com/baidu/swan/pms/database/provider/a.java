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
    private static volatile a efN;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> efM;

    private void baG() {
        this.efM = new ConcurrentHashMap<>();
        this.efM.put(f.class, new e());
        this.efM.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.efM.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.efM.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.efM.put(com.baidu.swan.pms.model.b.class, new c());
        this.efM.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.efM.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.efM.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        baG();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a baH() {
        if (efN == null) {
            synchronized (a.class) {
                if (efN == null) {
                    efN = new a();
                }
            }
        }
        return efN;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.efM.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.efM.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        efN = null;
    }
}
