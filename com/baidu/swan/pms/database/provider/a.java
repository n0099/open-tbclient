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
    private static volatile a emO;
    private ConcurrentHashMap<Class<?>, com.baidu.swan.pms.database.b.a> emN;

    private void bdL() {
        this.emN = new ConcurrentHashMap<>();
        this.emN.put(f.class, new e());
        this.emN.put(g.class, new com.baidu.swan.pms.database.b.f());
        this.emN.put(PMSAppInfo.class, new com.baidu.swan.pms.database.b.b());
        this.emN.put(d.class, new com.baidu.swan.pms.database.b.d());
        this.emN.put(com.baidu.swan.pms.model.b.class, new c());
        this.emN.put(h.class, new com.baidu.swan.pms.database.b.g());
        this.emN.put(com.baidu.swan.pms.b.a.class, new com.baidu.swan.pms.b.a.a());
        this.emN.put(i.class, new com.baidu.swan.pms.database.b.h());
    }

    private a() {
        this("ai_apps_pms.db", DB_VERSION);
        bdL();
    }

    private a(String str, int i) {
        super(AppRuntime.getAppContext(), str, null, i, null);
    }

    public static a bdM() {
        if (emO == null) {
            synchronized (a.class) {
                if (emO == null) {
                    emO = new a();
                }
            }
        }
        return emO;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (com.baidu.swan.pms.database.b.a aVar : this.emN.values()) {
            aVar.onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (com.baidu.swan.pms.database.b.a aVar : this.emN.values()) {
            aVar.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public void release() {
        emO = null;
    }
}
