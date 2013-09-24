package com.baidu.android.pushservice.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.baidu.android.common.logging.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static g f661a;

    public static int a(SQLiteDatabase sQLiteDatabase, String str, i iVar) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        String[] strArr = {str};
        ContentValues contentValues = new ContentValues();
        contentValues.put(h.belongTo.name(), iVar.f663a);
        contentValues.put(h.downloadUrl.name(), iVar.b);
        contentValues.put(h.title.name(), iVar.c);
        contentValues.put(h.description.name(), iVar.d);
        contentValues.put(h.savePath.name(), iVar.e);
        contentValues.put(h.fileName.name(), iVar.f);
        contentValues.put(h.downloadBytes.name(), Integer.valueOf(iVar.g));
        contentValues.put(h.totalBytes.name(), Integer.valueOf(iVar.h));
        contentValues.put(h.downloadStatus.name(), Integer.valueOf(iVar.i));
        contentValues.put(h.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
        return sQLiteDatabase.update("FileDownloadingInfo", contentValues, h.downloadUrl.name() + "=?", strArr);
    }

    public static long a(SQLiteDatabase sQLiteDatabase, i iVar) {
        if (sQLiteDatabase == null) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(h.belongTo.name(), iVar.f663a);
        contentValues.put(h.downloadUrl.name(), iVar.b);
        contentValues.put(h.title.name(), iVar.c);
        contentValues.put(h.description.name(), iVar.d);
        contentValues.put(h.savePath.name(), iVar.e);
        contentValues.put(h.fileName.name(), iVar.f);
        contentValues.put(h.downloadBytes.name(), Integer.valueOf(iVar.g));
        contentValues.put(h.totalBytes.name(), Integer.valueOf(iVar.h));
        contentValues.put(h.downloadStatus.name(), Integer.valueOf(iVar.i));
        contentValues.put(h.timeStamp.name(), Long.valueOf(System.currentTimeMillis()));
        return sQLiteDatabase.insert("FileDownloadingInfo", null, contentValues);
    }

    public static long a(SQLiteDatabase sQLiteDatabase, j jVar) {
        if (sQLiteDatabase == null) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(k.msg_id.name(), jVar.b);
        contentValues.put(k.app_id.name(), jVar.c);
        contentValues.put(k.result_code.name(), Integer.valueOf(jVar.d));
        return sQLiteDatabase.insert("MsgResultInfo", null, contentValues);
    }

    public static long a(SQLiteDatabase sQLiteDatabase, l lVar) {
        if (sQLiteDatabase == null) {
            return -1L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(m.packageName.name(), lVar.b);
        contentValues.put(m.msgid.name(), lVar.d);
        contentValues.put(m.open_type.name(), lVar.c);
        contentValues.put(m.app_open_time.name(), lVar.e);
        contentValues.put(m.app_close_time.name(), lVar.f);
        contentValues.put(m.use_duration.name(), lVar.g);
        if (lVar.h != null) {
            contentValues.put(m.extra.name(), lVar.h.toString());
        }
        return sQLiteDatabase.insert("StatisticsInfo", null, contentValues);
    }

    public static SQLiteDatabase a(Context context) {
        g b = b(context);
        if (b == null) {
            return null;
        }
        try {
            return b.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static i a(SQLiteDatabase sQLiteDatabase, String str) {
        i iVar = null;
        Cursor query = sQLiteDatabase.query("FileDownloadingInfo", null, "(" + h.downloadUrl.name() + "==?)", new String[]{str}, null, null, null);
        if (query.moveToFirst()) {
            iVar = new i();
            iVar.f663a = query.getString(query.getColumnIndex(h.belongTo.name()));
            iVar.b = query.getString(query.getColumnIndex(h.downloadUrl.name()));
            iVar.c = query.getString(query.getColumnIndex(h.title.name()));
            iVar.d = query.getString(query.getColumnIndex(h.description.name()));
            iVar.e = query.getString(query.getColumnIndex(h.savePath.name()));
            iVar.f = query.getString(query.getColumnIndex(h.fileName.name()));
            iVar.g = query.getInt(query.getColumnIndex(h.downloadBytes.name()));
            iVar.h = query.getInt(query.getColumnIndex(h.totalBytes.name()));
            iVar.i = query.getInt(query.getColumnIndex(h.downloadStatus.name()));
            iVar.j = query.getLong(query.getColumnIndex(h.timeStamp.name()));
        }
        query.close();
        return iVar;
    }

    public static List a(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query("MsgResultInfo", null, null, null, null, null, null);
        while (query.moveToNext()) {
            j jVar = new j();
            jVar.f664a = query.getInt(query.getColumnIndex(k.info_id.name()));
            jVar.b = query.getString(query.getColumnIndex(k.msg_id.name()));
            jVar.c = query.getString(query.getColumnIndex(k.app_id.name()));
            jVar.d = query.getInt(query.getColumnIndex(k.result_code.name()));
            arrayList.add(jVar);
        }
        query.close();
        return arrayList;
    }

    public static List a(SQLiteDatabase sQLiteDatabase, int i) {
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query("StatisticsInfo", null, null, null, null, null, null, "" + i);
        while (query.moveToNext()) {
            l lVar = new l();
            lVar.f666a = query.getInt(query.getColumnIndex(m.info_id.name()));
            lVar.b = query.getString(query.getColumnIndex(m.packageName.name()));
            lVar.c = query.getString(query.getColumnIndex(m.open_type.name()));
            lVar.d = query.getString(query.getColumnIndex(m.msgid.name()));
            lVar.e = query.getString(query.getColumnIndex(m.app_open_time.name()));
            lVar.f = query.getString(query.getColumnIndex(m.app_close_time.name()));
            lVar.g = query.getString(query.getColumnIndex(m.use_duration.name()));
            String string = query.getString(query.getColumnIndex(m.extra.name()));
            if (string != null) {
                try {
                    lVar.h = new JSONObject(string);
                } catch (JSONException e) {
                    Log.w("PushDatabase", "new json object error !");
                }
            }
            arrayList.add(lVar);
        }
        query.close();
        return arrayList;
    }

    public static void a() {
        if (f661a == null || f661a.getWritableDatabase() == null || !f661a.getWritableDatabase().isOpen()) {
            return;
        }
        f661a.close();
        f661a = null;
    }

    public static int b(SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        return sQLiteDatabase.delete("StatisticsInfo", m.info_id.name() + "=?", new String[]{"" + i});
    }

    public static int b(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        return sQLiteDatabase.delete("FileDownloadingInfo", h.downloadUrl.name() + "=?", new String[]{str});
    }

    private static g b(Context context) {
        if (f661a == null) {
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                return null;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "baidu/pushservice/database");
            if (!file.exists()) {
                file.mkdirs();
            }
            f661a = new g(context, file.getAbsolutePath() + File.separator + "push.db", 1);
        }
        return f661a;
    }

    public static List b(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor query = sQLiteDatabase.query("FileDownloadingInfo", null, null, null, null, null, h.timeStamp.name() + " DESC");
        while (query.moveToNext()) {
            i iVar = new i();
            iVar.f663a = query.getString(query.getColumnIndex(h.belongTo.name()));
            iVar.b = query.getString(query.getColumnIndex(h.downloadUrl.name()));
            iVar.c = query.getString(query.getColumnIndex(h.title.name()));
            iVar.d = query.getString(query.getColumnIndex(h.description.name()));
            iVar.e = query.getString(query.getColumnIndex(h.savePath.name()));
            iVar.f = query.getString(query.getColumnIndex(h.fileName.name()));
            iVar.g = query.getInt(query.getColumnIndex(h.downloadBytes.name()));
            iVar.h = query.getInt(query.getColumnIndex(h.totalBytes.name()));
            iVar.i = query.getInt(query.getColumnIndex(h.downloadStatus.name()));
            iVar.j = query.getLong(query.getColumnIndex(h.timeStamp.name()));
            arrayList.add(iVar);
        }
        query.close();
        return arrayList;
    }

    public static int c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return 0;
        }
        Cursor query = sQLiteDatabase.query("StatisticsInfo", null, null, null, null, null, null);
        int count = query.getCount();
        query.close();
        return count;
    }

    public static long d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return 0L;
        }
        return sQLiteDatabase.delete("MsgResultInfo", null, null);
    }
}
