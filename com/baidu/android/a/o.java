package com.baidu.android.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class o {
    private static final String a = o.class.getSimpleName();
    private static volatile o c = null;
    private final a b;
    private boolean d = false;
    private boolean e = false;

    private o(Context context) {
        this.b = new a(context);
    }

    public static synchronized o a(Context context) {
        o oVar;
        synchronized (o.class) {
            if (c == null) {
                c = new o(context);
            }
            oVar = c;
        }
        return oVar;
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
        k kVar = null;
        do {
            switch (i) {
                case 0:
                    kVar = new h();
                    kVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    kVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(kVar);
                    break;
                case 1:
                    kVar = new b();
                    kVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    kVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(kVar);
                    break;
                case 2:
                    kVar = new g();
                    kVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    kVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(kVar);
                    break;
                default:
                    kVar.a(cursor.getString(cursor.getColumnIndex("name")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    kVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(kVar);
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
        d dVar = new d(this, arrayList, i);
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase != null) {
                dVar.b(writableDatabase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = false;
        return true;
    }
}
