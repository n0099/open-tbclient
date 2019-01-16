package com.baidu.b.a.c.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.b.a.h.d;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {
    private static volatile a ZI;
    private static C0059a ZJ;
    private static Executor sExecutor;

    private a() {
    }

    public static a rG() {
        if (ZI == null) {
            synchronized (a.class) {
                if (ZI == null) {
                    sExecutor = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                    ZJ = new C0059a(AppRuntime.getAppContext(), "dynamic_file.db", 1);
                    ZI = new a();
                }
            }
        }
        return ZI;
    }

    public long d(final com.baidu.b.a.c.a.a aVar) {
        aVar.updateTime = System.currentTimeMillis();
        if (aVar.ZH <= 0) {
            aVar.createTime = aVar.updateTime;
        }
        final long[] jArr = {aVar.ZH};
        a(new com.baidu.b.a.d.a() { // from class: com.baidu.b.a.c.b.a.4
            @Override // com.baidu.b.a.d.a
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                ContentValues e = a.this.e(aVar);
                if (aVar.ZH <= 0) {
                    long insert = sQLiteDatabase.insert("file", null, e);
                    jArr[0] = insert;
                    return insert > 0;
                }
                try {
                    if (sQLiteDatabase.update("file", e, "_id =? ", new String[]{String.valueOf(aVar.ZH)}) > 0) {
                        return true;
                    }
                } catch (Exception e2) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
        });
        return jArr[0];
    }

    private Cursor a(List<Pair<String, String>> list, boolean z, String str, String str2, String str3) {
        Pair<String, String> pair;
        String str4;
        try {
            int size = list.size();
            String str5 = "SELECT * FROM file";
            String[] strArr = new String[size];
            if (list.size() > 0 || !TextUtils.isEmpty(str)) {
                String str6 = "SELECT * FROM file WHERE ";
                int i = 0;
                while (i < size) {
                    String str7 = str6 + ((String) pair.first) + " = ? ";
                    strArr[i] = (String) list.get(i).second;
                    if (i + 1 < size) {
                        str4 = str7 + (z ? "AND " : "OR ");
                    } else {
                        str4 = str7;
                    }
                    i++;
                    str6 = str4;
                }
                if (TextUtils.isEmpty(str)) {
                    str5 = str6;
                } else {
                    str5 = str6 + "ORDER BY " + str;
                    if (str3 != null) {
                        str5 = str5 + " " + str3;
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                str5 = "SELECT * FROM (" + str5 + " ) AS a GROUP BY a." + str2;
            }
            return ZJ.getReadableDatabase().rawQuery(str5, strArr);
        } catch (SQLException e) {
            if (com.baidu.b.a.h.b.isDebug()) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public List<com.baidu.b.a.c.a.a> f(Cursor cursor) {
        List<com.baidu.b.a.c.a.a> arrayList = new ArrayList<>(0);
        if (cursor != null) {
            try {
                arrayList = g(cursor);
            } catch (Exception e) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    e.printStackTrace();
                }
            } finally {
                d.h(cursor);
            }
        }
        return arrayList;
    }

    public boolean a(final List<Pair<String, String>> list, final boolean z, boolean z2) {
        com.baidu.b.a.d.a aVar = new com.baidu.b.a.d.a() { // from class: com.baidu.b.a.c.b.a.1
            @Override // com.baidu.b.a.d.a
            protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                String[] strArr = new String[list.size()];
                int i = 0;
                for (Pair pair : list) {
                    if (i == 0) {
                        sb.append(pair.first + " =? ");
                    } else {
                        sb.append(z ? " AND " : " OR ");
                        sb.append(pair.first + " =? ");
                    }
                    strArr[i] = "" + pair.second;
                    i++;
                }
                try {
                    return sQLiteDatabase.delete("file", sb.toString(), strArr) > 0;
                } catch (Exception e) {
                    if (com.baidu.b.a.h.b.isDebug()) {
                        e.printStackTrace();
                        return false;
                    }
                    return false;
                }
            }
        };
        if (z2) {
            return a(aVar);
        }
        b(aVar);
        return true;
    }

    public boolean j(String str, String str2, String str3) {
        final ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new Pair("channel_id", str));
        }
        if (str2 != null) {
            arrayList.add(new Pair(ETAG.KEY_PACKAGE_NAME, str2));
        }
        if (str3 != null) {
            arrayList.add(new Pair("update_version", str3));
        }
        final ArrayList arrayList2 = new ArrayList(5);
        arrayList2.add(4);
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(0);
        arrayList2.add(3);
        if (arrayList.size() > 0) {
            return a(new com.baidu.b.a.d.a() { // from class: com.baidu.b.a.c.b.a.2
                @Override // com.baidu.b.a.d.a
                protected boolean performTransaction(SQLiteDatabase sQLiteDatabase) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = new String[arrayList.size() + arrayList2.size()];
                    int i = 0;
                    for (Pair pair : arrayList) {
                        if (i == 0) {
                            sb.append(pair.first + " =? ");
                        } else {
                            sb.append(" AND ");
                            sb.append(pair.first + " =? ");
                        }
                        strArr[i] = "" + pair.second;
                        i++;
                    }
                    if (arrayList2.size() > 0) {
                        sb.append(" AND type IN (");
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            if (i2 == 0) {
                                sb.append("?");
                            } else {
                                sb.append(",?");
                            }
                            strArr[i] = "" + arrayList2.get(i2);
                            i++;
                        }
                        sb.append(")");
                    }
                    try {
                        return sQLiteDatabase.delete("file", sb.toString(), strArr) > 0;
                    } catch (Exception e) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            e.printStackTrace();
                            return false;
                        }
                        return false;
                    }
                }
            });
        }
        return false;
    }

    public List<com.baidu.b.a.c.a.a> aa(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair<>("channel_id", str));
        if (str2 != null) {
            arrayList.add(new Pair<>(ETAG.KEY_PACKAGE_NAME, str2));
        }
        arrayList.add(new Pair<>("type", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        return f(a(arrayList, true, "update_version", ETAG.KEY_PACKAGE_NAME, null));
    }

    public boolean k(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair<>("channel_id", str));
        if (str2 != null) {
            arrayList.add(new Pair<>(ETAG.KEY_PACKAGE_NAME, str2));
        }
        if (str3 != null) {
            arrayList.add(new Pair<>("update_version", str3));
        }
        arrayList.add(new Pair<>("type", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
        return a(arrayList, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentValues e(com.baidu.b.a.c.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        if (!TextUtils.isEmpty(aVar.packageName)) {
            contentValues.put(ETAG.KEY_PACKAGE_NAME, aVar.packageName);
        }
        if (!TextUtils.isEmpty(aVar.name)) {
            contentValues.put("name", aVar.name);
        }
        contentValues.put("version", Long.valueOf(aVar.Zw));
        contentValues.put("update_version", Long.valueOf(aVar.Zx));
        if (!TextUtils.isEmpty(aVar.downloadUrl)) {
            contentValues.put("download_url", aVar.downloadUrl);
        }
        if (!TextUtils.isEmpty(aVar.channelId)) {
            contentValues.put("channel_id", aVar.channelId);
        }
        if (!TextUtils.isEmpty(aVar.channelName)) {
            contentValues.put("channel_name", aVar.channelName);
        }
        if (!TextUtils.isEmpty(aVar.md5)) {
            contentValues.put(ARResourceKey.HTTP_AR_MD5, aVar.md5);
        }
        contentValues.put("min_host_version", aVar.Zy);
        contentValues.put("max_host_version", aVar.Zz);
        if (!TextUtils.isEmpty(aVar.size)) {
            contentValues.put(ChooseVideoAction.CB_KEY_SIZE, aVar.size);
        }
        contentValues.put("wifi", Integer.valueOf(aVar.ZB));
        contentValues.put("rollback", Integer.valueOf(aVar.rollback));
        contentValues.put("download_option", Integer.valueOf(aVar.ZC));
        if (!TextUtils.isEmpty(aVar.ZA)) {
            contentValues.put("extra_server", aVar.ZA);
        }
        contentValues.put("type", Integer.valueOf(aVar.type));
        if (!TextUtils.isEmpty(aVar.ZD)) {
            contentValues.put("extra_local", aVar.ZD);
        }
        contentValues.put("file_path", aVar.filePath);
        contentValues.put("total_size", Long.valueOf(aVar.ZF));
        contentValues.put("current_size", Long.valueOf(aVar.ZG));
        contentValues.put("create_time", Long.valueOf(aVar.createTime));
        contentValues.put("update_time", Long.valueOf(aVar.updateTime));
        return contentValues;
    }

    private List<com.baidu.b.a.c.a.a> g(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null && cursor.getCount() > 0) {
            int columnIndex = cursor.getColumnIndex(ETAG.KEY_PACKAGE_NAME);
            int columnIndex2 = cursor.getColumnIndex("update_version");
            int columnIndex3 = cursor.getColumnIndex("download_url");
            int columnIndex4 = cursor.getColumnIndex("version");
            int columnIndex5 = cursor.getColumnIndex("name");
            int columnIndex6 = cursor.getColumnIndex(ARResourceKey.HTTP_AR_MD5);
            int columnIndex7 = cursor.getColumnIndex(ChooseVideoAction.CB_KEY_SIZE);
            int columnIndex8 = cursor.getColumnIndex("extra_server");
            int columnIndex9 = cursor.getColumnIndex("min_host_version");
            int columnIndex10 = cursor.getColumnIndex("max_host_version");
            int columnIndex11 = cursor.getColumnIndex("download_option");
            int columnIndex12 = cursor.getColumnIndex("channel_id");
            int columnIndex13 = cursor.getColumnIndex("channel_name");
            int columnIndex14 = cursor.getColumnIndex("wifi");
            int columnIndex15 = cursor.getColumnIndex("rollback");
            int columnIndex16 = cursor.getColumnIndex("type");
            int columnIndex17 = cursor.getColumnIndex("extra_local");
            int columnIndex18 = cursor.getColumnIndex("file_path");
            int columnIndex19 = cursor.getColumnIndex("total_size");
            int columnIndex20 = cursor.getColumnIndex("current_size");
            int columnIndex21 = cursor.getColumnIndex("create_time");
            int columnIndex22 = cursor.getColumnIndex("update_time");
            int columnIndex23 = cursor.getColumnIndex("_id");
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(columnIndex);
                    if (!TextUtils.isEmpty(string)) {
                        com.baidu.b.a.c.a.a aVar = new com.baidu.b.a.c.a.a();
                        aVar.packageName = string;
                        aVar.Zx = cursor.getLong(columnIndex2);
                        aVar.downloadUrl = cursor.getString(columnIndex3);
                        aVar.Zw = cursor.getLong(columnIndex4);
                        aVar.name = cursor.getString(columnIndex5);
                        aVar.Zz = cursor.getString(columnIndex10);
                        aVar.Zy = cursor.getString(columnIndex9);
                        aVar.md5 = cursor.getString(columnIndex6);
                        aVar.size = cursor.getString(columnIndex7);
                        aVar.ZC = cursor.getInt(columnIndex11);
                        aVar.ZA = cursor.getString(columnIndex8);
                        aVar.channelId = cursor.getString(columnIndex12);
                        aVar.channelName = cursor.getString(columnIndex13);
                        aVar.ZB = cursor.getInt(columnIndex14);
                        aVar.rollback = cursor.getInt(columnIndex15);
                        aVar.type = cursor.getInt(columnIndex16);
                        aVar.ZD = cursor.getString(columnIndex17);
                        aVar.filePath = cursor.getString(columnIndex18);
                        aVar.ZF = cursor.getLong(columnIndex19);
                        aVar.ZG = cursor.getLong(columnIndex20);
                        aVar.createTime = cursor.getLong(columnIndex21);
                        aVar.updateTime = cursor.getLong(columnIndex22);
                        aVar.ZH = cursor.getInt(columnIndex23);
                        arrayList.add(aVar);
                    }
                } while (cursor.moveToNext());
            }
        }
        return arrayList;
    }

    private boolean a(com.baidu.b.a.d.a aVar) {
        aVar.run(ZJ.getWritableDatabase());
        return aVar.isTransactionSuccess();
    }

    private void b(final com.baidu.b.a.d.a aVar) {
        sExecutor.execute(new Runnable() { // from class: com.baidu.b.a.c.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                aVar.run(a.ZJ.getWritableDatabase());
            }
        });
    }

    /* renamed from: com.baidu.b.a.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0059a extends SQLiteOpenHelper {
        public C0059a(Context context, String str, int i) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public String getDatabaseName() {
            return super.getDatabaseName();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(rI());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        private String rI() {
            return "CREATE TABLE file(_id INTEGER PRIMARY KEY,channel_id TEXT NOT NULL,channel_name TEXT NOT NULL," + ETAG.KEY_PACKAGE_NAME + " TEXT NOT NULL,name TEXT NOT NULL,version LONG,update_version LONG,min_host_version TEXT,max_host_version TEXT,download_url TEXT,type INTEGER DEFAULT 0," + ARResourceKey.HTTP_AR_MD5 + " TEXT," + ChooseVideoAction.CB_KEY_SIZE + " TEXT,download_option INTEGER DEFAULT 0,wifi INTEGER DEFAULT 0,rollback INTEGER DEFAULT 0,extra_server TEXT,extra_local TEXT,file_path TEXT,total_size LONG,current_size LONG,create_time LONG,update_time LONG);";
        }
    }
}
