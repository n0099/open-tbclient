package com.baidu.swan.pms.database.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.database.b.c;
import com.baidu.swan.pms.database.b.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.d;
import com.baidu.swan.pms.model.f;
import com.baidu.swan.pms.model.h;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
class a extends SQLiteOpenHelper {
    private static volatile a brM;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> brL;

    private void Vq() {
        this.brL = new ConcurrentHashMap<>();
        this.brL.put(f.class, new e());
        this.brL.put(h.class, new com.baidu.swan.pms.database.b.f());
        this.brL.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.brL.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.brL.put(com.baidu.swan.pms.model.b.class, new c());
    }

    private a() {
        this("ai_apps_pms.db", 1);
        Vq();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a Vr() {
        if (brM == null) {
            synchronized (a.class) {
                if (brM == null) {
                    brM = new a();
                }
            }
        }
        return brM;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.brL.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.brL.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
