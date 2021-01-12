package com.baidu.swan.ubc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a {
    private final o evw;
    private long mTotalLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.evw = new o(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        if (iVar != null && !TextUtils.isEmpty(iVar.getId())) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(iVar.beG()));
            contentValues.put("eventid", iVar.getId());
            contentValues.put("begintime", Long.valueOf(iVar.getTime()));
            if (iVar.beI() != null) {
                contentValues.put("content", iVar.beI().toString());
            } else {
                contentValues.put("content", iVar.getContent());
            }
            contentValues.put("reserve1", iVar.beH());
            if (!TextUtils.isEmpty(iVar.getCategory())) {
                contentValues.put("reserve2", iVar.getCategory());
            }
            if (iVar.beD()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ctr", "1");
                    contentValues.put("extend", jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            final String beF = iVar.beF();
            final String id = iVar.getId();
            final int beG = iVar.beG();
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    return a.this.a(beF, id, beG, sQLiteDatabase) && sQLiteDatabase.insert("event", null, contentValues) != -1;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bh(final List<i> list) {
        if (list != null && list.size() != 0) {
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    boolean z = true;
                    for (i iVar : list) {
                        if (!TextUtils.isEmpty(iVar.getId()) && a.this.a(iVar.beF(), iVar.getId(), iVar.beG(), sQLiteDatabase)) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("flowhandle", Integer.valueOf(iVar.beG()));
                            contentValues.put("eventid", iVar.getId());
                            contentValues.put("begintime", Long.valueOf(iVar.getTime()));
                            if (!TextUtils.isEmpty(iVar.getContent())) {
                                contentValues.put("content", iVar.getContent());
                            } else if (iVar.beI() != null && !TextUtils.isEmpty(iVar.beI().toString())) {
                                contentValues.put("content", iVar.beI().toString());
                            }
                            contentValues.put("reserve1", iVar.beH());
                            if (!TextUtils.isEmpty(iVar.getCategory())) {
                                contentValues.put("reserve2", iVar.getCategory());
                            }
                            if (iVar.beD()) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("ctr", "1");
                                    contentValues.put("extend", jSONObject.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            z = sQLiteDatabase.insert("event", null, contentValues) < 0 ? false : z;
                        }
                    }
                    return z;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [336=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
        if ("1".equals(r3) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        boolean z = true;
        if (str.equals(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("state").append(" FROM ").append("flow").append(" WHERE ").append("flowhandle").append(" = ").append(i);
        try {
            try {
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.getCount() > 0) {
                                rawQuery.moveToFirst();
                                String string = rawQuery.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                }
                            }
                        } catch (SQLiteFullException e) {
                            cursor = rawQuery;
                            com.baidu.swan.c.d.closeSafely(cursor);
                            return false;
                        }
                    }
                    z = false;
                    com.baidu.swan.c.d.closeSafely(rawQuery);
                    return z;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    com.baidu.swan.c.d.closeSafely(null);
                    return false;
                }
            } catch (SQLiteFullException e3) {
                cursor = null;
            }
        } catch (Throwable th) {
            com.baidu.swan.c.d.closeSafely(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        if (kVar != null && !TextUtils.isEmpty(kVar.getId())) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("flowid", kVar.getId());
            contentValues.put("flowhandle", Integer.valueOf(kVar.beG()));
            contentValues.put("state", kVar.beO());
            contentValues.put("begintime", Long.valueOf(kVar.beN()));
            if (kVar.beI() != null) {
                contentValues.put("content", kVar.beI().toString());
            } else {
                contentValues.put("content", kVar.getContent());
            }
            contentValues.put("option", Integer.valueOf(kVar.getOption()));
            contentValues.put("reserve1", kVar.beH());
            if (!TextUtils.isEmpty(kVar.getCategory())) {
                contentValues.put("reserve2", kVar.getCategory());
            }
            if (kVar.beD()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ctr", "1");
                    contentValues.put("extend", jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.insert("flow", null, contentValues) != -1;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("content", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.11
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.update("flow", contentValues, sb2, null) == 1;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("state", "2");
            contentValues.put(LogBuilder.KEY_END_TIME, Long.valueOf(j));
            if (jSONArray != null && jSONArray.length() > 0) {
                contentValues.put("slot", jSONArray.toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.update("flow", contentValues, sb2, null) == 1;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(String str, final int i) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    sQLiteDatabase.delete("flow", sb2, null);
                    sQLiteDatabase.delete("event", "flowhandle = " + i, null);
                    return true;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bdZ() {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.14
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [590=4] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x016f  */
            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                Throwable th;
                Cursor cursor;
                RuntimeException e;
                Cursor cursor2;
                long currentTimeMillis = System.currentTimeMillis() - d.beq().bes();
                int delete = sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                if (delete > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "expire");
                        jSONObject.put("ubc_type", "flow");
                        jSONObject.put("expire_time", currentTimeMillis);
                        jSONObject.put("count", delete);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
                int delete2 = sQLiteDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                if (delete2 > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("type", "expire");
                        jSONObject2.put("ubc_type", "event");
                        jSONObject2.put("expire_time", currentTimeMillis);
                        jSONObject2.put("count", delete2);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                }
                StringBuilder sb = new StringBuilder(256);
                sb.append("SELECT ").append("flowhandle").append(" FROM ").append("flow").append(" WHERE ").append("begintime").append(" < ").append(System.currentTimeMillis() - 86400000).append(" AND ").append(LogBuilder.KEY_END_TIME).append(" is NULL ").append(" AND ").append("option").append(" = 0");
                ArrayList arrayList = new ArrayList();
                try {
                    cursor2 = sQLiteDatabase.rawQuery(sb.toString(), null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.getCount() > 0) {
                                cursor2.moveToFirst();
                                do {
                                    arrayList.add(Integer.valueOf(cursor2.getInt(cursor2.getColumnIndex("flowhandle"))));
                                } while (cursor2.moveToNext());
                            }
                        } catch (SQLiteFullException e4) {
                            com.baidu.swan.c.d.closeSafely(cursor2);
                            if (arrayList.size() != 0) {
                            }
                            return true;
                        } catch (RuntimeException e5) {
                            e = e5;
                            cursor = cursor2;
                            try {
                                e.printStackTrace();
                                com.baidu.swan.c.d.closeSafely(cursor);
                                if (arrayList.size() != 0) {
                                }
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                com.baidu.swan.c.d.closeSafely(cursor);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursor2;
                            com.baidu.swan.c.d.closeSafely(cursor);
                            throw th;
                        }
                    }
                    com.baidu.swan.c.d.closeSafely(cursor2);
                } catch (SQLiteFullException e6) {
                    cursor2 = null;
                } catch (RuntimeException e7) {
                    e = e7;
                    cursor = null;
                } catch (Throwable th4) {
                    th = th4;
                    cursor = null;
                }
                if (arrayList.size() != 0) {
                    String r = a.this.r(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("flowhandle").append(" in (").append(r).append(")");
                    sQLiteDatabase.delete("flow", sb2.toString(), null);
                    sQLiteDatabase.delete("event", sb2.toString(), null);
                }
                return true;
            }
        }.I(this.evw.getWritableDatabase());
        xW("flow");
        xW("event");
    }

    private void xW(final String str) {
        Cursor cursor = null;
        final int i = 0;
        SQLiteDatabase writableDatabase = this.evw.getWritableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*), MIN(").append(IMConstants.MSG_ROW_ID).append("), MAX(").append(IMConstants.MSG_ROW_ID).append(") FROM ").append(str);
        try {
            cursor = writableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (cursor.getInt(0) > d.beq().bet()) {
                    i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                }
            }
        } catch (SQLiteFullException e) {
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.swan.c.d.closeSafely(cursor);
        }
        if (i > 0) {
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.15
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    int delete = sQLiteDatabase.delete(str, "_id < " + i, null);
                    e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
                    return delete > 0;
                }
            }.I(writableDatabase);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [755=4] */
    public void a(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, h> hashMap3, HashSet<String> hashSet5) {
        Throwable th;
        Cursor cursor;
        RuntimeException runtimeException;
        SQLiteDatabase readableDatabase = this.evw.getReadableDatabase();
        if (readableDatabase == null) {
            return;
        }
        Cursor cursor2 = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("config");
        try {
            Cursor rawQuery = readableDatabase.rawQuery(sb.toString(), null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        do {
                            String string = rawQuery.getString(rawQuery.getColumnIndex("eventid"));
                            String string2 = rawQuery.getString(rawQuery.getColumnIndex("switch"));
                            int i = rawQuery.getInt(rawQuery.getColumnIndex("sample"));
                            String string3 = rawQuery.getString(rawQuery.getColumnIndex("reserve1"));
                            String string4 = rawQuery.getString(rawQuery.getColumnIndex("reserve2"));
                            int i2 = rawQuery.getInt(rawQuery.getColumnIndex("cycle"));
                            int i3 = rawQuery.getInt(rawQuery.getColumnIndex("uploadrule"));
                            int i4 = rawQuery.getInt(rawQuery.getColumnIndex("recordrule"));
                            String string5 = rawQuery.getString(rawQuery.getColumnIndex("extend"));
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
                        } while (rawQuery.moveToNext());
                    }
                } catch (SQLiteFullException e2) {
                    cursor2 = rawQuery;
                    com.baidu.swan.c.d.closeSafely(cursor2);
                    return;
                } catch (RuntimeException e3) {
                    runtimeException = e3;
                    cursor = rawQuery;
                    try {
                        runtimeException.printStackTrace();
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.swan.c.d.closeSafely(cursor);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    com.baidu.swan.c.d.closeSafely(cursor);
                    throw th;
                }
            }
            com.baidu.swan.c.d.closeSafely(rawQuery);
        } catch (SQLiteFullException e4) {
        } catch (RuntimeException e5) {
            runtimeException = e5;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5 A[Catch: SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, all -> 0x00db, Merged into TryCatch #2 {all -> 0x00db, SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, blocks: (B:3:0x0069, B:5:0x0074, B:7:0x007a, B:8:0x0092, B:13:0x00a5, B:15:0x00ad, B:16:0x00b5, B:17:0x00bd, B:24:0x00cc, B:27:0x00d4), top: B:33:0x0069 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        SQLiteDatabase readableDatabase = this.evw.getReadableDatabase();
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
            com.baidu.swan.c.d.closeSafely(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ArrayList<f> arrayList, v vVar) {
        int i;
        this.mTotalLength = 0L;
        String d = d(arrayList, true);
        if (TextUtils.isEmpty(d)) {
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ").append(" FROM ").append("flow").append(" WHERE ").append("flowid").append(" in (").append(d).append(")");
            i = a(sb.toString(), vVar);
        }
        String d2 = d(arrayList, false);
        if (!TextUtils.isEmpty(d2)) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ").append("event").append(" WHERE ").append("eventid").append(" in (").append(d2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
            return i | b(sb2.toString(), vVar);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(v vVar) {
        this.mTotalLength = 0L;
        StringBuilder sb = new StringBuilder(256);
        sb.append(" SELECT * FROM ").append("flow");
        int a2 = a(sb.toString(), vVar);
        if (this.mTotalLength >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT * FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(-1);
        return a2 | b(sb2.toString(), vVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [990=5] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str, v vVar) {
        Cursor cursor;
        RuntimeException runtimeException;
        Cursor cursor2;
        String string;
        int i = 0;
        ArrayList<k> arrayList = new ArrayList<>();
        Cursor cursor3 = null;
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            cursor = this.evw.getReadableDatabase().rawQuery(str, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex("flowid");
                        int columnIndex2 = cursor.getColumnIndex("flowhandle");
                        int columnIndex3 = cursor.getColumnIndex("state");
                        int columnIndex4 = cursor.getColumnIndex("begintime");
                        int columnIndex5 = cursor.getColumnIndex(LogBuilder.KEY_END_TIME);
                        int columnIndex6 = cursor.getColumnIndex("content");
                        int columnIndex7 = cursor.getColumnIndex("option");
                        int columnIndex8 = cursor.getColumnIndex("reserve1");
                        int columnIndex9 = cursor.getColumnIndex("reserve2");
                        int columnIndex10 = cursor.getColumnIndex("slot");
                        int columnIndex11 = cursor.getColumnIndex("extend");
                        do {
                            if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                                k kVar = new k();
                                kVar.setId(cursor.getString(columnIndex));
                                kVar.mk(cursor.getInt(columnIndex2));
                                kVar.dw(cursor.getLong(columnIndex4));
                                kVar.setEndTime(cursor.getLong(columnIndex5));
                                if (kVar.getEndTime() > 0 && kVar.getEndTime() > j2) {
                                    j2 = kVar.getEndTime();
                                }
                                if (kVar.beN() > 0 && kVar.beN() < j) {
                                    j = kVar.beN();
                                }
                                String string2 = cursor.getString(columnIndex6);
                                if (!TextUtils.isEmpty(string2)) {
                                    kVar.setContent(string2);
                                    this.mTotalLength = string2.getBytes("UTF-8").length;
                                }
                                String string3 = cursor.getString(columnIndex8);
                                if (!TextUtils.isEmpty(string3)) {
                                    kVar.yp(string3);
                                    this.mTotalLength += string3.getBytes("UTF-8").length;
                                }
                                if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                    kVar.setCategory(cursor.getString(columnIndex9));
                                }
                                String string4 = cursor.getString(columnIndex10);
                                if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                    kVar.yq(string4);
                                    this.mTotalLength += string4.getBytes("UTF-8").length;
                                }
                                if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                    this.mTotalLength += string.getBytes("UTF-8").length;
                                    try {
                                        if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                            kVar.iH(true);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                arrayList.add(kVar);
                                vVar.aE(kVar.beG(), Integer.parseInt(kVar.getId()));
                                if (this.mTotalLength >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                                    break;
                                }
                            }
                        } while (cursor.moveToNext());
                        i = 1;
                    }
                } catch (SQLiteFullException e2) {
                    cursor3 = cursor;
                    com.baidu.swan.c.d.closeSafely(cursor3);
                    if (arrayList.size() > 0) {
                    }
                    vVar.u(j, j2);
                    return i;
                } catch (UnsupportedEncodingException e3) {
                    com.baidu.swan.c.d.closeSafely(cursor);
                    if (arrayList.size() > 0) {
                    }
                    vVar.u(j, j2);
                    return i;
                } catch (RuntimeException e4) {
                    runtimeException = e4;
                    cursor2 = cursor;
                    try {
                        runtimeException.printStackTrace();
                        com.baidu.swan.c.d.closeSafely(cursor2);
                        if (arrayList.size() > 0) {
                        }
                        vVar.u(j, j2);
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        com.baidu.swan.c.d.closeSafely(cursor);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.swan.c.d.closeSafely(cursor);
                    throw th;
                }
            }
            com.baidu.swan.c.d.closeSafely(cursor);
        } catch (SQLiteFullException e5) {
        } catch (UnsupportedEncodingException e6) {
            cursor = null;
        } catch (RuntimeException e7) {
            runtimeException = e7;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (arrayList.size() > 0) {
            b(arrayList, vVar);
        }
        vVar.u(j, j2);
        return i;
    }

    private void b(ArrayList<k> arrayList, v vVar) {
        Cursor cursor;
        JSONObject jSONObject = new JSONObject();
        SQLiteDatabase readableDatabase = this.evw.getReadableDatabase();
        Cursor cursor2 = null;
        try {
            Iterator<k> it = arrayList.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next.beG() >= 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bizId", next.getId());
                    jSONObject2.put(LogBuilder.KEY_START_TIME, Long.toString(next.beN()));
                    jSONObject2.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                    jSONObject2.put("eventType", "1");
                    if (!TextUtils.isEmpty(next.getContent())) {
                        jSONObject = new JSONObject(next.getContent());
                    }
                    if (!TextUtils.isEmpty(next.beH())) {
                        jSONObject2.put("abtest", next.beH());
                        vVar.yu("1");
                    }
                    if (!TextUtils.isEmpty(next.getCategory())) {
                        jSONObject2.put("c", next.getCategory());
                    }
                    if (next.beP() != null) {
                        jSONObject2.put("part", next.beP());
                    }
                    if (next.beD()) {
                        jSONObject2.put("of", "1");
                    }
                    jSONObject2.put("idtype", d.beq().yj(next.getId()));
                    JSONArray jSONArray = new JSONArray();
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(next.beG());
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
                        com.baidu.swan.c.d.closeSafely(cursor2);
                        cursor = cursor2;
                    } catch (SQLiteFullException e) {
                        com.baidu.swan.c.d.closeSafely(cursor2);
                        cursor = cursor2;
                    } catch (Throwable th) {
                        com.baidu.swan.c.d.closeSafely(cursor2);
                        throw th;
                    }
                    jSONObject2.put("content", jSONObject);
                    s.dl(jSONObject2);
                    vVar.dn(jSONObject2);
                } else {
                    cursor = cursor2;
                }
                cursor2 = cursor;
            }
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1190=5] */
    private int b(String str, v vVar) {
        int i = 0;
        Cursor cursor = null;
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            try {
                cursor = this.evw.getReadableDatabase().rawQuery(str, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("eventid");
                    int columnIndex2 = cursor.getColumnIndex("begintime");
                    int columnIndex3 = cursor.getColumnIndex("content");
                    int columnIndex4 = cursor.getColumnIndex("reserve1");
                    int columnIndex5 = cursor.getColumnIndex("reserve2");
                    int columnIndex6 = cursor.getColumnIndex("extend");
                    do {
                        JSONObject jSONObject = new JSONObject();
                        String string = cursor.getString(columnIndex);
                        jSONObject.put("bizId", string);
                        long j3 = cursor.getLong(columnIndex2);
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
                        String string2 = cursor.getString(columnIndex3);
                        if (!TextUtils.isEmpty(string2)) {
                            jSONObject.put("content", string2);
                            this.mTotalLength = string2.getBytes("UTF-8").length + this.mTotalLength;
                        }
                        String string3 = cursor.getString(columnIndex4);
                        if (!TextUtils.isEmpty(string3)) {
                            jSONObject.put("abtest", string3);
                            vVar.yu("1");
                            this.mTotalLength = string3.getBytes("UTF-8").length + this.mTotalLength;
                        }
                        if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                            jSONObject.put("c", cursor.getString(columnIndex5));
                        }
                        String string4 = cursor.getString(columnIndex6);
                        if (!TextUtils.isEmpty(string4)) {
                            if (new JSONObject(cursor.getString(columnIndex6)).has("ctr")) {
                                jSONObject.put("of", "1");
                            }
                            this.mTotalLength = string4.getBytes("UTF-8").length + this.mTotalLength;
                        }
                        jSONObject.put("idtype", d.beq().yj(string));
                        s.dl(jSONObject);
                        vVar.dn(jSONObject);
                        vVar.yt(cursor.getString(columnIndex));
                        if (this.mTotalLength >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
                            break;
                        }
                    } while (cursor.moveToNext());
                    i = 1;
                }
                com.baidu.swan.c.d.closeSafely(cursor);
            } catch (SQLiteFullException e) {
                com.baidu.swan.c.d.closeSafely(cursor);
            } catch (UnsupportedEncodingException e2) {
                com.baidu.swan.c.d.closeSafely(cursor);
            } catch (RuntimeException e3) {
                e3.printStackTrace();
                com.baidu.swan.c.d.closeSafely(cursor);
            } catch (JSONException e4) {
                com.baidu.swan.c.d.closeSafely(cursor);
            }
            vVar.u(j, j2);
            return i;
        } catch (Throwable th) {
            com.baidu.swan.c.d.closeSafely(cursor);
            throw th;
        }
    }

    private String d(ArrayList<f> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f fVar = arrayList.get(i2);
            if (z && !"0".equals(fVar.getType())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(fVar.getId());
            } else if (!z && "0".equals(fVar.getType())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(fVar.getId());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bi(final List<g> list) {
        if (list != null && list.size() != 0) {
            new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.16
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.swan.ubc.a.AbstractC0547a
                protected boolean H(SQLiteDatabase sQLiteDatabase) {
                    for (g gVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("eventid", gVar.getId());
                        contentValues.put("type", gVar.getType());
                        if ("1".equals(gVar.bex())) {
                            contentValues.put("cycle", (Integer) 0);
                        } else {
                            contentValues.put("cycle", Integer.valueOf(gVar.getTimeout()));
                        }
                        contentValues.put("switch", gVar.bew());
                        contentValues.put("reserve1", gVar.bey());
                        if (!TextUtils.isEmpty(gVar.getCategory())) {
                            contentValues.put("reserve2", gVar.getCategory());
                        }
                        contentValues.put("sample", Integer.valueOf(gVar.bez()));
                        if (gVar.beA() != 0 && gVar.beB() != 0) {
                            contentValues.put("recordrule", Integer.valueOf(gVar.beA()));
                            contentValues.put("uploadrule", Integer.valueOf(gVar.beB()));
                        }
                        if (TextUtils.equals(gVar.beC(), "1")) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("idtype", "1");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            contentValues.put("extend", jSONObject.toString());
                        }
                        sQLiteDatabase.replace("config", null, contentValues);
                    }
                    return true;
                }
            }.I(this.evw.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SparseArray<Integer> sparseArray, final ArrayList<String> arrayList, final boolean z, final String str) {
        AbstractC0547a abstractC0547a = new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.2
            long beginTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.beginTime = System.currentTimeMillis();
            }

            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                if (sparseArray != null && sparseArray.size() > 0) {
                    int size = sparseArray.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(Integer.valueOf(sparseArray.keyAt(i)));
                    }
                    String r = a.this.r(arrayList2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("flowhandle").append(" in (").append(r).append(")");
                    t.ys("delete flow table flow count:" + sQLiteDatabase.delete("flow", sb.toString(), null));
                    t.ys("delete flow table event count:" + sQLiteDatabase.delete("event", sb.toString(), null));
                }
                if (arrayList != null && arrayList.size() > 0) {
                    String r2 = a.this.r(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eventid").append(" in (").append(r2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
                    t.ys("delete event table event count:" + sQLiteDatabase.delete("event", sb2.toString(), null));
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", str);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    sQLiteDatabase.replace("file", null, contentValues);
                }
                t.ys("delete total time:" + (System.currentTimeMillis() - this.beginTime));
                return true;
            }
        };
        abstractC0547a.I(this.evw.getWritableDatabase());
        return abstractC0547a.bee();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1536=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public j xX(String str) {
        Cursor cursor;
        j jVar;
        StringBuilder sb = new StringBuilder();
        SQLiteDatabase readableDatabase = this.evw.getReadableDatabase();
        sb.append("SELECT ").append("state").append(" , ").append("reserve1").append(" FROM ").append("file").append(" WHERE ").append("filename").append("=\"").append(str).append("\"");
        try {
            cursor = readableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            jVar = new j(str, cursor.getString(cursor.getColumnIndex("state")), !cursor.isNull(cursor.getColumnIndex("reserve1")) ? cursor.getString(cursor.getColumnIndex("reserve1")) : "");
                            com.baidu.swan.c.d.closeSafely(cursor);
                            return jVar;
                        }
                    } catch (Exception e) {
                        e = e;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "DBError");
                            jSONObject.put("exception", Log.getStackTraceString(e));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(cursor);
                    throw th;
                }
            }
            jVar = null;
            com.baidu.swan.c.d.closeSafely(cursor);
            return jVar;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.d.closeSafely(cursor);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(final String str, final boolean z) {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                contentValues.put("filename", str);
                contentValues.put("reserve1", z ? "1" : "0");
                sQLiteDatabase.replace("file", null, contentValues);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xY(final String str) {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                sQLiteDatabase.delete("file", sb.toString(), null);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bea() {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.5
            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.delete("file", null, null);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xZ(final String str) {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, sb.toString(), null);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dz(final String str, final String str2) {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", str2);
                sQLiteDatabase.update("file", contentValues, sb.toString(), null);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beb() {
        new AbstractC0547a() { // from class: com.baidu.swan.ubc.a.8
            @Override // com.baidu.swan.ubc.a.AbstractC0547a
            protected boolean H(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, null, null);
                return true;
            }
        }.I(this.evw.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String r(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }

    final long bec() {
        return this.evw.bec();
    }

    final long bed() {
        return this.evw.bed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.ubc.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public abstract class AbstractC0547a {
        private boolean evJ;

        protected abstract boolean H(SQLiteDatabase sQLiteDatabase);

        private AbstractC0547a() {
            this.evJ = false;
        }

        public void I(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                this.evJ = false;
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (H(sQLiteDatabase)) {
                            sQLiteDatabase.setTransactionSuccessful();
                            this.evJ = true;
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e) {
                        }
                    } catch (RuntimeException e2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "DBError");
                            jSONObject.put("db_size", a.this.bec());
                            jSONObject.put("db_log_size", a.this.bed());
                            jSONObject.put("exception", Log.getStackTraceString(e2));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        e.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e4) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (RuntimeException e5) {
                    }
                    throw th;
                }
            }
        }

        protected boolean bee() {
            return this.evJ;
        }
    }
}
