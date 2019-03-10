package com.baidu.swan.ubc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = g.DEBUG;
    private final n boA;
    private final C0183a boz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.boz = new C0183a(context, "bdbehavior.db");
        this.boA = new n(context);
    }

    /* renamed from: com.baidu.swan.ubc.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0183a {
        private String boM;
        private Context mContext;

        C0183a(Context context, String str) {
            this.boM = str;
            this.mContext = context.getApplicationContext();
        }

        public synchronized SQLiteDatabase getReadableDatabase() {
            k Ts;
            Ts = r.Ts();
            return Ts != null ? Ts.getReadableDatabase() : null;
        }

        public synchronized SQLiteDatabase getWritableDatabase() {
            k Ts;
            Ts = r.Ts();
            return Ts != null ? Ts.getWritableDatabase() : null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        if (iVar == null || TextUtils.isEmpty(iVar.getId())) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "saveEvent#event id must not be null");
                return;
            }
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(iVar.Td()));
        contentValues.put("eventid", iVar.getId());
        contentValues.put("begintime", Long.valueOf(iVar.getTime()));
        if (iVar.Tf() != null) {
            contentValues.put("content", iVar.Tf().toString());
        } else {
            contentValues.put("content", iVar.getContent());
        }
        contentValues.put("reserve1", iVar.Te());
        if (!TextUtils.isEmpty(iVar.getCategory())) {
            contentValues.put("reserve2", iVar.getCategory());
        }
        if (iVar.Ta()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        final String Tc = iVar.Tc();
        final String id = iVar.getId();
        final int Td = iVar.Td();
        new b() { // from class: com.baidu.swan.ubc.a.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                if (!a.this.a(Tc, id, Td, sQLiteDatabase)) {
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "saveEvent#can not add event to ended flow!");
                        return false;
                    }
                    return false;
                }
                long insert = sQLiteDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, contentValues);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "saveEvent#performTransaction: rowId=" + insert);
                }
                return insert != -1;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(final List<i> list) {
        if (list == null || list.size() == 0) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "saveEvents#data must not be null");
                return;
            }
            return;
        }
        new b() { // from class: com.baidu.swan.ubc.a.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                boolean z = true;
                for (i iVar : list) {
                    if (TextUtils.isEmpty(iVar.getId())) {
                        if (a.DEBUG) {
                            Log.d("UBCBehaviorDbAdapter", "saveEvents#event id must not be null");
                        }
                    } else if (!a.this.a(iVar.Tc(), iVar.getId(), iVar.Td(), sQLiteDatabase)) {
                        if (a.DEBUG) {
                            Log.d("UBCBehaviorDbAdapter", "saveEvents#can not add event to ended flow!");
                        }
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flowhandle", Integer.valueOf(iVar.Td()));
                        contentValues.put("eventid", iVar.getId());
                        contentValues.put("begintime", Long.valueOf(iVar.getTime()));
                        if (!TextUtils.isEmpty(iVar.getContent())) {
                            contentValues.put("content", iVar.getContent());
                        } else if (iVar.Tf() != null && !TextUtils.isEmpty(iVar.Tf().toString())) {
                            contentValues.put("content", iVar.Tf().toString());
                        }
                        contentValues.put("reserve1", iVar.Te());
                        if (!TextUtils.isEmpty(iVar.getCategory())) {
                            contentValues.put("reserve2", iVar.getCategory());
                        }
                        if (iVar.Ta()) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ctr", "1");
                                contentValues.put("extend", jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        long insert = sQLiteDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, contentValues);
                        boolean z2 = insert < 0 ? false : z;
                        if (a.DEBUG) {
                            Log.d("UBCBehaviorDbAdapter", "saveEvents#performTransaction: rowId=" + insert);
                        }
                        z = z2;
                    }
                }
                return z;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [388=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
        if ("1".equals(r3) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = true;
        if (str.equals(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append(WXLoginActivity.KEY_BASE_RESP_STATE).append(" FROM ").append("flow").append(" WHERE ").append("flowhandle").append(" = ").append(i);
        try {
            cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                String string = cursor.getString(0);
                if (!TextUtils.isEmpty(string)) {
                }
            }
            z = false;
            return z;
        } catch (SQLiteFullException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        } catch (RuntimeException e2) {
            if (DEBUG) {
                throw e2;
            }
            e2.printStackTrace();
            return false;
        } finally {
            com.baidu.swan.c.b.c(cursor);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [432=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        Cursor cursor = null;
        if (jVar == null || TextUtils.isEmpty(jVar.getId())) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "saveFlow#event id must not be null");
                return;
            }
            return;
        }
        SQLiteDatabase writableDatabase = this.boz.getWritableDatabase();
        if (writableDatabase != null && DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append("flow").append(" WHERE ").append("flowhandle").append(" = ").append(jVar.Td());
            try {
                cursor = writableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null && cursor.getCount() > 0) {
                    Log.e("UBCBehaviorDbAdapter", "invalid flow handle!!!");
                }
            } catch (SQLiteFullException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } catch (SQLException e2) {
                if (DEBUG) {
                    throw e2;
                }
                e2.printStackTrace();
            } finally {
                com.baidu.swan.c.b.c(cursor);
            }
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("flowid", jVar.getId());
        contentValues.put("flowhandle", Integer.valueOf(jVar.Td()));
        contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, jVar.getState());
        contentValues.put("begintime", Long.valueOf(jVar.Ti()));
        if (jVar.Tf() != null) {
            contentValues.put("content", jVar.Tf().toString());
        } else {
            contentValues.put("content", jVar.getContent());
        }
        contentValues.put("option", Integer.valueOf(jVar.getOption()));
        contentValues.put("reserve1", jVar.Te());
        if (!TextUtils.isEmpty(jVar.getCategory())) {
            contentValues.put("reserve2", jVar.getCategory());
        }
        if (jVar.Ta()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        b bVar = new b() { // from class: com.baidu.swan.ubc.a.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                long insert = sQLiteDatabase.insert("flow", null, contentValues);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "saveFlow#performTransaction: rowId=" + insert);
                }
                return insert != -1;
            }
        };
        if (writableDatabase != null) {
            bVar.k(writableDatabase);
        }
        bVar.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, int i, String str2) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "updateFlowValue#flowHandle invalid");
                return;
            }
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("content", str2);
        StringBuilder sb = new StringBuilder();
        sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
        final String sb2 = sb.toString();
        new b() { // from class: com.baidu.swan.ubc.a.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                int update = sQLiteDatabase.update("flow", contentValues, sb2, null);
                if (a.DEBUG && update != 1) {
                    Log.d("UBCBehaviorDbAdapter", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
                }
                return update == 1;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "endFlow#flowHandle invalid");
                return;
            }
            return;
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, "2");
        contentValues.put(LogBuilder.KEY_END_TIME, Long.valueOf(j));
        if (jSONArray != null && jSONArray.length() > 0) {
            contentValues.put("slot", jSONArray.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
        final String sb2 = sb.toString();
        new b() { // from class: com.baidu.swan.ubc.a.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                int update = sQLiteDatabase.update("flow", contentValues, sb2, null);
                if (a.DEBUG && update != 1) {
                    Log.d("UBCBehaviorDbAdapter", "endFlow#performTransaction: endFlow count:" + update);
                }
                return update == 1;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(String str, final int i) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "cancelFlow#flowHandle invalid");
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
        final String sb2 = sb.toString();
        new b() { // from class: com.baidu.swan.ubc.a.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                int delete = sQLiteDatabase.delete("flow", sb2, null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "cancelFlow#performTransaction: cancelFlow flow count:" + delete);
                }
                int delete2 = sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, "flowhandle = " + i, null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "cancelFlow#performTransaction: cancelFlow event count:" + delete2);
                    return true;
                }
                return true;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SI() {
        new b() { // from class: com.baidu.swan.ubc.a.11
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [675=4] */
            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:0x0220 */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:50:0x01c3  */
            /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v16 */
            /* JADX WARN: Type inference failed for: r1v19, types: [java.io.Closeable] */
            @Override // com.baidu.swan.ubc.a.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                Cursor cursor;
                long currentTimeMillis = System.currentTimeMillis() - d.SW().SY();
                int delete = sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "clearInvalidData: delete flow count:" + delete);
                }
                if (delete > 0 && !a.DEBUG) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "expire");
                        jSONObject.put("ubc_type", "flow");
                        jSONObject.put("expire_time", currentTimeMillis);
                        jSONObject.put("count", delete);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
                int delete2 = sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, "begintime < " + currentTimeMillis, null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "clearInvalidData: delete event count:" + delete2);
                }
                if (delete2 > 0 && !a.DEBUG) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("type", "expire");
                        jSONObject2.put("ubc_type", NotificationCompat.CATEGORY_EVENT);
                        jSONObject2.put("expire_time", currentTimeMillis);
                        jSONObject2.put("count", delete2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                }
                StringBuilder sb = new StringBuilder(256);
                ?? r1 = " = 0";
                sb.append("SELECT ").append("flowhandle").append(" FROM ").append("flow").append(" WHERE ").append("begintime").append(" < ").append(System.currentTimeMillis() - 86400000).append(" AND ").append(LogBuilder.KEY_END_TIME).append(" is NULL ").append(" AND ").append("option").append(" = 0");
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    do {
                                        arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("flowhandle"))));
                                    } while (cursor.moveToNext());
                                }
                            } catch (SQLiteFullException e3) {
                                e = e3;
                                if (a.DEBUG) {
                                    e.printStackTrace();
                                }
                                com.baidu.swan.c.b.c(cursor);
                                if (arrayList.size() != 0) {
                                }
                                return true;
                            } catch (RuntimeException e4) {
                                e = e4;
                                e.printStackTrace();
                                com.baidu.swan.c.b.c(cursor);
                                if (arrayList.size() != 0) {
                                }
                                return true;
                            }
                        }
                        com.baidu.swan.c.b.c(cursor);
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.c.b.c(r1);
                        throw th;
                    }
                } catch (SQLiteFullException e5) {
                    e = e5;
                    cursor = null;
                } catch (RuntimeException e6) {
                    e = e6;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    r1 = 0;
                    com.baidu.swan.c.b.c(r1);
                    throw th;
                }
                if (arrayList.size() != 0) {
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "clearInvalidData: delete flow count2:" + arrayList.size());
                    }
                    String h = a.this.h(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("flowhandle").append(" in (").append(h).append(")");
                    sQLiteDatabase.delete("flow", sb2.toString(), null);
                    sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                }
                return true;
            }
        }.k(this.boA.getWritableDatabase());
        jC("flow");
        jC(NotificationCompat.CATEGORY_EVENT);
    }

    private void jC(final String str) {
        Cursor cursor = null;
        final int i = 0;
        SQLiteDatabase writableDatabase = this.boA.getWritableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*), MIN(").append("_id").append("), MAX(").append("_id").append(") FROM ").append(str);
        try {
            cursor = writableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (cursor.getInt(0) > d.SW().SZ()) {
                    i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                }
            }
        } catch (SQLiteFullException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.swan.c.b.c(cursor);
        }
        if (i > 0) {
            new b() { // from class: com.baidu.swan.ubc.a.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.b
                protected boolean j(SQLiteDatabase sQLiteDatabase) {
                    int delete = sQLiteDatabase.delete(str, "_id < " + i, null);
                    if (!a.DEBUG) {
                        r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
                    }
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "ensureDataBaseLimit#performTransaction: delete count:" + delete);
                    }
                    return delete > 0;
                }
            }.k(writableDatabase);
        }
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, h> hashMap3, HashSet<String> hashSet5) {
        SQLiteDatabase readableDatabase = this.boz.getReadableDatabase();
        if (readableDatabase == null) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "EventRunnable#OpenStat init not finish");
                return;
            }
            return;
        }
        Cursor cursor = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("config");
        try {
            cursor = readableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                    String string2 = cursor.getString(cursor.getColumnIndex("switch"));
                    int i = cursor.getInt(cursor.getColumnIndex("sample"));
                    String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                    String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                    String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                    if (TextUtils.equals(string2, "0")) {
                        hashSet.add(string);
                    } else if (TextUtils.equals(string2, "1")) {
                        hashSet2.add(string);
                    }
                    if (i2 == 0) {
                        hashSet3.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        hashSet4.add(string);
                    }
                    if (i > 0) {
                        hashMap.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        hashMap2.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        hashMap3.put(string, new h(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            if (new JSONObject(string5).has("idtype")) {
                                hashSet5.add(string);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLiteFullException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (RuntimeException e3) {
            e3.printStackTrace();
        } finally {
            com.baidu.swan.c.b.c(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5 A[Catch: SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, all -> 0x00db, Merged into TryCatch #2 {all -> 0x00db, SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, blocks: (B:3:0x0069, B:5:0x0074, B:7:0x007a, B:8:0x0092, B:13:0x00a5, B:15:0x00ad, B:16:0x00b5, B:17:0x00bd, B:24:0x00cc, B:27:0x00d4), top: B:33:0x0069 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        SQLiteDatabase readableDatabase = this.boA.getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("eventid").append(" , ").append("type").append(" , ").append("cycle").append(" FROM ").append("config").append(" WHERE ").append("switch").append("=\"").append("1").append("\"");
        try {
            cursor = readableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("eventid");
                int columnIndex2 = cursor.getColumnIndex("type");
                int columnIndex3 = cursor.getColumnIndex("cycle");
                do {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    int i2 = cursor.getInt(columnIndex3);
                    if (i2 != 0) {
                        if (i2 < 6) {
                            i = 6;
                        } else if (i2 > 720) {
                            i = 720;
                        }
                        if (string != null) {
                            ArrayList arrayList = sparseArray.get(i);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                sparseArray.put(i, arrayList);
                            }
                            arrayList.add(new f(string, string2));
                        }
                    }
                    i = i2;
                    if (string != null) {
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLiteFullException e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.swan.c.b.c(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ArrayList<f> arrayList, u uVar) {
        int i;
        String c = c(arrayList, true);
        if (TextUtils.isEmpty(c)) {
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ").append(" FROM ").append("flow").append(" WHERE ").append("flowid").append(" in (").append(c).append(")");
            i = a(sb.toString(), uVar);
        }
        String c2 = c(arrayList, false);
        if (!TextUtils.isEmpty(c2)) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("eventid").append(" in (").append(c2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
            return i | b(sb2.toString(), uVar);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(u uVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append(" SELECT * FROM ").append("flow");
        int a = a(sb.toString(), uVar);
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT * FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(-1);
        return a | b(sb2.toString(), uVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1042=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x0077 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0180  */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str, u uVar) {
        Cursor cursor;
        Cursor cursor2;
        int i = 0;
        ArrayList<j> arrayList = new ArrayList<>();
        Cursor cursor3 = null;
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            try {
                cursor2 = this.boA.getReadableDatabase().rawQuery(str, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.getCount() > 0) {
                            cursor2.moveToFirst();
                            int columnIndex = cursor2.getColumnIndex("flowid");
                            int columnIndex2 = cursor2.getColumnIndex("flowhandle");
                            int columnIndex3 = cursor2.getColumnIndex(WXLoginActivity.KEY_BASE_RESP_STATE);
                            int columnIndex4 = cursor2.getColumnIndex("begintime");
                            int columnIndex5 = cursor2.getColumnIndex(LogBuilder.KEY_END_TIME);
                            int columnIndex6 = cursor2.getColumnIndex("content");
                            int columnIndex7 = cursor2.getColumnIndex("option");
                            int columnIndex8 = cursor2.getColumnIndex("reserve1");
                            int columnIndex9 = cursor2.getColumnIndex("reserve2");
                            int columnIndex10 = cursor2.getColumnIndex("slot");
                            int columnIndex11 = cursor2.getColumnIndex("extend");
                            long j3 = "extend";
                            while (true) {
                                try {
                                    j3 = j;
                                    j = j2;
                                    if ("2".equals(cursor2.getString(columnIndex3)) || (Math.abs(cursor2.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor2.getInt(columnIndex7) & 4) != 0)) {
                                        j jVar = new j();
                                        jVar.setId(cursor2.getString(columnIndex));
                                        jVar.fq(cursor2.getInt(columnIndex2));
                                        jVar.X(cursor2.getLong(columnIndex4));
                                        jVar.setEndTime(cursor2.getLong(columnIndex5));
                                        if (jVar.getEndTime() > 0 && jVar.getEndTime() > j) {
                                            j = jVar.getEndTime();
                                        }
                                        if (jVar.Ti() > 0 && jVar.Ti() < j3) {
                                            j3 = jVar.Ti();
                                        }
                                        jVar.setContent(cursor2.getString(columnIndex6));
                                        jVar.jP(cursor2.getString(columnIndex8));
                                        if (!TextUtils.isEmpty(cursor2.getString(columnIndex9))) {
                                            jVar.setCategory(cursor2.getString(columnIndex9));
                                        }
                                        if (columnIndex10 >= 0 && !TextUtils.isEmpty(cursor2.getString(columnIndex10))) {
                                            jVar.jQ(cursor2.getString(columnIndex10));
                                        }
                                        if (!TextUtils.isEmpty(cursor2.getString(columnIndex11))) {
                                            try {
                                                if (new JSONObject(cursor2.getString(columnIndex11)).has("ctr")) {
                                                    jVar.cV(true);
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        arrayList.add(jVar);
                                        uVar.P(jVar.Td(), Integer.parseInt(jVar.getId()));
                                    }
                                    j2 = j;
                                    j = j3;
                                    boolean moveToNext = cursor2.moveToNext();
                                    if (!moveToNext) {
                                        break;
                                    }
                                    j3 = moveToNext;
                                } catch (SQLiteFullException e2) {
                                    e = e2;
                                    j2 = j;
                                    j = j3;
                                    cursor3 = cursor2;
                                    try {
                                        if (DEBUG) {
                                            e.printStackTrace();
                                        }
                                        com.baidu.swan.c.b.c(cursor3);
                                        if (arrayList.size() > 0) {
                                        }
                                        uVar.g(j, j2);
                                        return i;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor3;
                                        com.baidu.swan.c.b.c(cursor);
                                        throw th;
                                    }
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    j2 = j;
                                    j = j3;
                                    e.printStackTrace();
                                    com.baidu.swan.c.b.c(cursor2);
                                    if (arrayList.size() > 0) {
                                    }
                                    uVar.g(j, j2);
                                    return i;
                                }
                            }
                            i = 1;
                        }
                    } catch (SQLiteFullException e4) {
                        e = e4;
                        cursor3 = cursor2;
                    } catch (RuntimeException e5) {
                        e = e5;
                    }
                }
                com.baidu.swan.c.b.c(cursor2);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.c.b.c(cursor);
                throw th;
            }
        } catch (SQLiteFullException e6) {
            e = e6;
        } catch (RuntimeException e7) {
            e = e7;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            com.baidu.swan.c.b.c(cursor);
            throw th;
        }
        if (arrayList.size() > 0) {
            b(arrayList, uVar);
        }
        uVar.g(j, j2);
        return i;
    }

    private void b(ArrayList<j> arrayList, u uVar) {
        Cursor cursor;
        JSONObject jSONObject = new JSONObject();
        SQLiteDatabase readableDatabase = this.boA.getReadableDatabase();
        Cursor cursor2 = null;
        try {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next.Td() >= 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bizId", next.getId());
                    jSONObject2.put(LogBuilder.KEY_START_TIME, Long.toString(next.Ti()));
                    jSONObject2.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                    jSONObject2.put("eventType", "1");
                    if (!TextUtils.isEmpty(next.getContent())) {
                        jSONObject = new JSONObject(next.getContent());
                    }
                    if (!TextUtils.isEmpty(next.Te())) {
                        jSONObject2.put(ImageViewerConfig.ABTEST, next.Te());
                        uVar.jV("1");
                    }
                    if (!TextUtils.isEmpty(next.getCategory())) {
                        jSONObject2.put("c", next.getCategory());
                    }
                    if (next.Tj() != null) {
                        jSONObject2.put("part", next.Tj());
                    }
                    if (next.Ta()) {
                        jSONObject2.put("of", "1");
                    }
                    jSONObject2.put("idtype", d.SW().jN(next.getId()));
                    JSONArray jSONArray = new JSONArray();
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(next.Td());
                    try {
                        cursor2 = readableDatabase.rawQuery(sb.toString(), null);
                        if (cursor2 != null && cursor2.getCount() > 0) {
                            cursor2.moveToFirst();
                            int columnIndex = cursor2.getColumnIndex("eventid");
                            int columnIndex2 = cursor2.getColumnIndex("begintime");
                            int columnIndex3 = cursor2.getColumnIndex("content");
                            do {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("id", cursor2.getString(columnIndex));
                                jSONObject3.put("timestamp", Long.toString(cursor2.getLong(columnIndex2)));
                                jSONObject3.put("content", cursor2.getString(columnIndex3));
                                jSONArray.put(jSONObject3);
                            } while (cursor2.moveToNext());
                            jSONObject.put("eventlist", jSONArray);
                        }
                        com.baidu.swan.c.b.c(cursor2);
                        cursor = cursor2;
                    } catch (SQLiteFullException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.b.c(cursor2);
                        cursor = cursor2;
                    }
                    jSONObject2.put("content", jSONObject);
                    q.aG(jSONObject2);
                    uVar.aI(jSONObject2);
                } else {
                    cursor = cursor2;
                }
                jSONObject = jSONObject;
                cursor2 = cursor;
            }
        } catch (RuntimeException e2) {
            if (DEBUG) {
                throw e2;
            }
            e2.printStackTrace();
        } catch (JSONException e3) {
            if (DEBUG) {
                Log.d("UBCBehaviorDbAdapter", "json exception:");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1229=5] */
    private int b(String str, u uVar) {
        Cursor cursor;
        RuntimeException runtimeException;
        Cursor cursor2;
        SQLiteFullException sQLiteFullException;
        int i = 0;
        SQLiteDatabase sQLiteDatabase = null;
        SQLiteDatabase readableDatabase = this.boA.getReadableDatabase();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            try {
                try {
                    try {
                        Cursor rawQuery = readableDatabase.rawQuery(str, null);
                        if (rawQuery != null) {
                            try {
                                if (rawQuery.getCount() > 0) {
                                    rawQuery.moveToFirst();
                                    int columnIndex = rawQuery.getColumnIndex("eventid");
                                    int columnIndex2 = rawQuery.getColumnIndex("begintime");
                                    int columnIndex3 = rawQuery.getColumnIndex("content");
                                    int columnIndex4 = rawQuery.getColumnIndex("reserve1");
                                    int columnIndex5 = rawQuery.getColumnIndex("reserve2");
                                    int columnIndex6 = rawQuery.getColumnIndex("extend");
                                    do {
                                        JSONObject jSONObject = new JSONObject();
                                        String string = rawQuery.getString(columnIndex);
                                        jSONObject.put("bizId", string);
                                        long j3 = rawQuery.getLong(columnIndex2);
                                        jSONObject.put("timestamp", Long.toString(j3));
                                        if (j3 > 0) {
                                            if (j3 < j) {
                                                j = j3;
                                            }
                                            if (j3 > j2) {
                                                j2 = j3;
                                            }
                                        }
                                        jSONObject.put("eventType", "0");
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex3))) {
                                            jSONObject.put("content", rawQuery.getString(columnIndex3));
                                        }
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex4))) {
                                            jSONObject.put(ImageViewerConfig.ABTEST, rawQuery.getString(columnIndex4));
                                            uVar.jV("1");
                                        }
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex5))) {
                                            jSONObject.put("c", rawQuery.getString(columnIndex5));
                                        }
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex6)) && new JSONObject(rawQuery.getString(columnIndex6)).has("ctr")) {
                                            jSONObject.put("of", "1");
                                        }
                                        jSONObject.put("idtype", d.SW().jN(string));
                                        q.aG(jSONObject);
                                        uVar.aI(jSONObject);
                                        uVar.jU(rawQuery.getString(columnIndex));
                                    } while (rawQuery.moveToNext());
                                    i = 1;
                                }
                            } catch (SQLiteFullException e) {
                                cursor2 = rawQuery;
                                sQLiteFullException = e;
                                if (DEBUG) {
                                    sQLiteFullException.printStackTrace();
                                }
                                com.baidu.swan.c.b.c(cursor2);
                                uVar.g(j, j2);
                                return i;
                            } catch (RuntimeException e2) {
                                cursor = rawQuery;
                                runtimeException = e2;
                                if (DEBUG) {
                                    throw runtimeException;
                                }
                                runtimeException.printStackTrace();
                                com.baidu.swan.c.b.c(cursor);
                                uVar.g(j, j2);
                                return i;
                            }
                        }
                        com.baidu.swan.c.b.c(rawQuery);
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.swan.c.b.c(sQLiteDatabase);
                        throw th;
                    }
                } catch (JSONException e3) {
                    if (DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "json exception:");
                    }
                    com.baidu.swan.c.b.c(null);
                }
            } catch (SQLiteFullException e4) {
                cursor2 = null;
                sQLiteFullException = e4;
            } catch (RuntimeException e5) {
                cursor = null;
                runtimeException = e5;
            }
            uVar.g(j, j2);
            return i;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = readableDatabase;
        }
    }

    private String c(ArrayList<f> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f fVar = arrayList.get(i2);
            if (z && !"0".equals(fVar.getType())) {
                if (i > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(fVar.getId());
            } else if (!z && "0".equals(fVar.getType())) {
                if (i > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(fVar.getId());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SparseArray<Integer> sparseArray, final ArrayList<String> arrayList, final boolean z, final String str) {
        b bVar = new b() { // from class: com.baidu.swan.ubc.a.2
            long beginTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.beginTime = System.currentTimeMillis();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                if (sparseArray != null && sparseArray.size() > 0) {
                    int size = sparseArray.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(Integer.valueOf(sparseArray.keyAt(i)));
                    }
                    String h = a.this.h(arrayList2);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "save file name " + str + " delete flow handle ids = " + h);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("flowhandle").append(" in (").append(h).append(")");
                    int delete = sQLiteDatabase.delete("flow", sb.toString(), null);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "clearUploadedData#performTransaction: flow table delete count:" + delete);
                    }
                    s.jT("delete flow table flow count:" + delete);
                    int delete2 = sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb.toString(), null);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete2);
                    }
                    s.jT("delete flow table event count:" + delete2);
                }
                if (arrayList != null && arrayList.size() > 0) {
                    String h2 = a.this.h(arrayList);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "delete event ids = " + h2);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eventid").append(" in (").append(h2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
                    int delete3 = sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                    s.jT("delete event table event count:" + delete3);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "clearUploadedData#performTransaction: event table count2:" + delete3);
                    }
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", str);
                    contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    long insert = sQLiteDatabase.insert("file", null, contentValues);
                    if (a.DEBUG) {
                        Log.d("UBCBehaviorDbAdapter", "clearUploadedData#save file: rowId=" + insert);
                    }
                }
                s.jT("delete total time:" + (System.currentTimeMillis() - this.beginTime));
                return true;
            }
        };
        bVar.k(this.boA.getWritableDatabase());
        return bVar.AE();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jD(final String str) {
        new b() { // from class: com.baidu.swan.ubc.a.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                int delete = sQLiteDatabase.delete("file", sb.toString(), null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "deleteSendedFile#performTransaction: delete file table:" + delete);
                    return true;
                }
                return true;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jE(final String str) {
        new b() { // from class: com.baidu.swan.ubc.a.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, "1");
                int update = sQLiteDatabase.update("file", contentValues, sb.toString(), null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "updateSendedFileFail#performTransaction: update file table:" + update);
                    return true;
                }
                return true;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SJ() {
        new b() { // from class: com.baidu.swan.ubc.a.5
            @Override // com.baidu.swan.ubc.a.b
            protected boolean j(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(WXLoginActivity.KEY_BASE_RESP_STATE, "1");
                int update = sQLiteDatabase.update("file", contentValues, null, null);
                if (a.DEBUG) {
                    Log.d("UBCBehaviorDbAdapter", "updateAllSentFileFail#performTransaction: update file table:" + update);
                    return true;
                }
                return true;
            }
        }.k(this.boA.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }

    final long SK() {
        return this.boA.SK();
    }

    final long SL() {
        return this.boA.SL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class b {
        private boolean boN;

        protected abstract boolean j(SQLiteDatabase sQLiteDatabase);

        private b() {
            this.boN = false;
        }

        public void k(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                this.boN = false;
                sQLiteDatabase.beginTransaction();
                try {
                    try {
                        if (j(sQLiteDatabase)) {
                            sQLiteDatabase.setTransactionSuccessful();
                            this.boN = true;
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e) {
                            if (a.DEBUG) {
                                Log.e("UBCBehaviorDbAdapter", e.getMessage(), e);
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e2) {
                            if (a.DEBUG) {
                                Log.e("UBCBehaviorDbAdapter", e2.getMessage(), e2);
                            }
                        }
                        throw th;
                    }
                } catch (RuntimeException e3) {
                    if (a.DEBUG) {
                        throw e3;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "DBError");
                        jSONObject.put("db_size", a.this.SK());
                        jSONObject.put("db_log_size", a.this.SL());
                        jSONObject.put("exception", Log.getStackTraceString(e3));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    r.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (RuntimeException e5) {
                        if (a.DEBUG) {
                            Log.e("UBCBehaviorDbAdapter", e5.getMessage(), e5);
                        }
                    }
                }
            }
        }

        protected boolean AE() {
            return this.boN;
        }
    }
}
