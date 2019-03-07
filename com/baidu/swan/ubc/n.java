package com.baidu.swan.ubc;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class n extends SQLiteOpenHelper {
    private static final boolean DEBUG = g.DEBUG;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        super(context.getApplicationContext(), "OpenStat.db", (SQLiteDatabase.CursorFactory) null, 5);
        this.mContext = context.getApplicationContext();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (DEBUG) {
            Log.d("OpenStatDbHelper", "Creating a new DB");
        }
        sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
        sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        t.Tt().putString("ubc_version_md5", "0");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (DEBUG) {
            Log.d("OpenStatDbHelper", "Upgrading app, replacing DB from " + i + " to " + i2);
        }
        while (i < i2) {
            switch (i) {
                case 1:
                    G(sQLiteDatabase);
                    break;
                case 2:
                    J(sQLiteDatabase);
                    break;
                case 3:
                    H(sQLiteDatabase);
                    break;
                case 4:
                    I(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void H(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void I(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        try {
            sQLiteDatabase = super.getReadableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            if (new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).delete()) {
                sQLiteDatabase = super.getReadableDatabase();
                t.Tt().putString("ubc_version_md5", "0");
                if (!DEBUG) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "delDB");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
            } else if (DEBUG) {
                Log.d("OpenStatDbHelper", "DbOpenHelper.getReadableDatabase() throw Exception, but failed to delete it.");
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        Exception e;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (Exception e2) {
            sQLiteDatabase = null;
            e = e2;
        }
        try {
            sQLiteDatabase.enableWriteAheadLogging();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (DEBUG) {
                throw new RuntimeException(e);
            }
            if (new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).delete()) {
                sQLiteDatabase = super.getWritableDatabase();
                sQLiteDatabase.enableWriteAheadLogging();
                t.Tt().putString("ubc_version_md5", "0");
                r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delDB");
            } else if (DEBUG) {
                Log.d("OpenStatDbHelper", "DbOpenHelper.getWritableDatabase() throw Exception, but failed to delete it.");
            }
            return sQLiteDatabase;
        }
        return sQLiteDatabase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long SK() {
        return new File(this.mContext.getDatabasePath("OpenStat.db").getPath()).length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long SL() {
        return new File(this.mContext.getDatabasePath("OpenStat.db").getPath() + "-journal").length();
    }
}
