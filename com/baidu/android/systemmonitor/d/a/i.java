package com.baidu.android.systemmonitor.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f783a = i.class.getSimpleName();
    private static volatile i c = null;
    private final h b;
    private boolean d = false;
    private boolean e = false;

    private i(Context context) {
        this.b = new h(context);
    }

    public static synchronized i a(Context context) {
        i iVar;
        synchronized (i.class) {
            if (c == null) {
                c = new i(context);
            }
            iVar = c;
        }
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
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
        b bVar = null;
        do {
            switch (i) {
                case 0:
                    bVar = new o();
                    bVar.a(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    bVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(bVar);
                    break;
                case 1:
                    bVar = new n();
                    bVar.a(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    bVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(bVar);
                    break;
                case 2:
                    bVar = new a();
                    bVar.a(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    bVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(bVar);
                    break;
                default:
                    bVar.a(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    bVar.b(cursor.getString(cursor.getColumnIndex("value")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("type")));
                    arrayList.add(bVar);
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
        j jVar = new j(this, arrayList, i);
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            if (writableDatabase != null) {
                jVar.b(writableDatabase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = false;
        return true;
    }
}
