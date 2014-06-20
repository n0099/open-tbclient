package com.baidu.android.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class h {
    private static final String a = h.class.getSimpleName();
    private static volatile h c = null;
    private final i b;
    private boolean d = false;
    private boolean e = false;

    private h(Context context) {
        this.b = new i(context);
    }

    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (c == null) {
                c = new h(context);
            }
            hVar = c;
        }
        return hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList a(int i) {
        Cursor cursor;
        if (this.d) {
            return new ArrayList();
        }
        this.e = true;
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer("select * from server_config_table");
        switch (i) {
            case 0:
                stringBuffer.append(" where type=0");
                break;
            case 1:
                stringBuffer.append(" where type=1");
                break;
            case 2:
                stringBuffer.append(" where type=2");
                break;
            case 4:
                stringBuffer.append(" where type=4");
                break;
            case 5:
                stringBuffer.append(" where type=5");
                break;
            case 6:
                stringBuffer.append(" where type=6");
                break;
        }
        try {
            cursor = this.b.getReadableDatabase().rawQuery(stringBuffer.toString(), null);
        } catch (Exception e) {
            e.printStackTrace();
            cursor = null;
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            this.e = false;
            return arrayList;
        }
        e eVar = null;
        do {
            switch (i) {
                case 0:
                    eVar = new q();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 1:
                    eVar = new j();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 2:
                    eVar = new p();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 3:
                default:
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 4:
                    eVar = new c();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 5:
                    eVar = new f();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
                case 6:
                    eVar = new u();
                    eVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    eVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    eVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(eVar);
                    break;
            }
        } while (cursor.moveToNext());
        if (cursor != null) {
        }
        this.e = false;
        return arrayList;
    }

    public void a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", str2);
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.update("server_config_table", contentValues, "name=?", new String[]{str});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(ArrayList arrayList, int i) {
        if (this.e) {
            return false;
        }
        this.d = true;
        n nVar = new n(this, arrayList, i);
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase != null) {
                nVar.b(writableDatabase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = false;
        return true;
    }
}
