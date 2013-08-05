package com.baidu.android.systemmonitor.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f652a = n.class.getSimpleName();
    private static volatile n c = null;
    private final f b;
    private boolean d = false;
    private boolean e = false;

    private n(Context context) {
        this.b = new f(context);
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n(context);
            }
            nVar = c;
        }
        return nVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList a(int i) {
        l lVar = null;
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
        Cursor rawQuery = this.b.getReadableDatabase().rawQuery(stringBuffer.toString(), null);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            this.e = false;
            return arrayList;
        }
        do {
            switch (i) {
                case 0:
                    lVar = new j();
                    lVar.a(rawQuery.getString(rawQuery.getColumnIndex("name")));
                    lVar.b(rawQuery.getString(rawQuery.getColumnIndex("value")));
                    lVar.a(rawQuery.getInt(rawQuery.getColumnIndex("type")));
                    arrayList.add(lVar);
                    break;
                case 1:
                    lVar = new c();
                    lVar.a(rawQuery.getString(rawQuery.getColumnIndex("name")));
                    lVar.b(rawQuery.getString(rawQuery.getColumnIndex("value")));
                    lVar.a(rawQuery.getInt(rawQuery.getColumnIndex("type")));
                    arrayList.add(lVar);
                    break;
                case 2:
                    lVar = new d();
                    lVar.a(rawQuery.getString(rawQuery.getColumnIndex("name")));
                    lVar.b(rawQuery.getString(rawQuery.getColumnIndex("value")));
                    lVar.a(rawQuery.getInt(rawQuery.getColumnIndex("type")));
                    arrayList.add(lVar);
                    break;
                default:
                    lVar.a(rawQuery.getString(rawQuery.getColumnIndex("name")));
                    lVar.b(rawQuery.getString(rawQuery.getColumnIndex("value")));
                    lVar.a(rawQuery.getInt(rawQuery.getColumnIndex("type")));
                    arrayList.add(lVar);
                    break;
            }
        } while (rawQuery.moveToNext());
        if (rawQuery != null) {
        }
        this.e = false;
        return arrayList;
    }

    public void a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", str2);
        this.b.getWritableDatabase().update("server_config_table", contentValues, "name=?", new String[]{str});
    }

    public boolean a(ArrayList arrayList, int i) {
        if (this.e) {
            return false;
        }
        this.d = true;
        new a(this, arrayList, i).b(this.b.getWritableDatabase());
        this.d = false;
        return true;
    }
}
