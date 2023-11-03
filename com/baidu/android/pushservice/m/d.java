package com.baidu.android.pushservice.m;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.pushservice.database.PushConfigData;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.message.LocalPushMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.w.m.l;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static volatile e a;
    public static final Object b = new Object();

    /* loaded from: classes.dex */
    public enum b {
        actionId,
        actionName,
        timeStamp,
        pkgName,
        versionCode,
        versionName,
        status
    }

    /* loaded from: classes.dex */
    public enum c {
        timeStamps,
        clickData
    }

    /* renamed from: com.baidu.android.pushservice.m.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031d implements DatabaseErrorHandler {
        public C0031d() {
        }

        @TargetApi(16)
        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    if (Build.VERSION.SDK_INT > 18) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        new File(str).delete();
                    }
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.database.DatabaseErrorHandler
        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
            if (!sQLiteDatabase.isOpen()) {
                a(sQLiteDatabase.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = sQLiteDatabase.getAttachedDbs();
                } finally {
                    if (list != null) {
                        for (Pair<String, String> next : list) {
                            a((String) next.second);
                        }
                    } else {
                        a(sQLiteDatabase.getPath());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                sQLiteDatabase.close();
            } catch (SQLiteException unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends SQLiteOpenHelper {
        public static final String a = "CREATE TABLE PushShareInfo (" + j.PushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + j.PushPriority.name() + " LONG NOT NULL DEFAULT ((0)), " + j.PushVersion.name() + " INTEGER DEFAULT ((0)), " + j.PushChannelID.name() + " TEXT, " + j.PushNewChannelID.name() + " TEXT, " + j.PushChannelToken.name() + " TEXT, " + j.PushCurPkgName.name() + " TEXT, " + j.PushWebAppBindInfo.name() + " TEXT, " + j.PushLightAppBindInfo.name() + " TEXT, " + j.PushSDKClientBindInfo.name() + " TEXT, " + j.PushClientsBindInfo.name() + " TEXT, " + j.PushSelfBindInfo.name() + " TEXT);";
        public static final String b;
        public static final String c;
        public static final String d;
        public static final String e;
        public static final String f;
        public static final String g;
        public static final String h;
        public static final String i;
        public static final String j;
        public static final String k;
        public static final String l;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE PushVerifInfo (");
            sb.append(k.verifId.name());
            sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb.append(k.msgId.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(k.md5Infos.name());
            sb.append(" TEXT NOT NULL, ");
            sb.append(k.appId.name());
            sb.append(" TEXT, ");
            sb.append(k.time.name());
            sb.append(" TEXT);");
            b = sb.toString();
            c = "CREATE TABLE PushMsgInfos (" + g.MsgInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + g.appId.name() + "  TEXT, " + g.msgType.name() + "  INTEGER NOT NULL, " + g.msgId.name() + " LONG NOT NULL, " + g.secureInfo.name() + " TEXT, " + g.msgBody.name() + "  TEXT, " + g.expireTime.name() + "  LONG, " + g.ackRet.name() + "  INTEGER, " + g.arriveTime.name() + " LONG NOT NULL, " + g.notifyId.name() + "  INTEGER);";
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE PushDataInfo (");
            sb2.append(i.dataKey.name());
            sb2.append(" TEXT NOT NULL, ");
            sb2.append(i.dataSensitive.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(i.canUpload.name());
            sb2.append(" INTEGER NOT NULL DEFAULT ((0)), ");
            sb2.append(i.timeInterval.name());
            sb2.append("  LONG NOT NULL, ");
            sb2.append(i.dataValue.name());
            sb2.append(" TEXT,");
            sb2.append(i.lastUpdateStamp.name());
            sb2.append(" LONG,");
            sb2.append(i.bindCanUpload.name());
            sb2.append(" INTEGER DEFAULT ((0)));");
            d = sb2.toString();
            e = "CREATE TABLE ClickMsgUploadInfo (" + c.timeStamps.name() + " LONG NOT NULL," + c.clickData.name() + " TEXT NOT NULL);";
            f = "CREATE TABLE PushAppStatus (" + b.actionId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + b.actionName.name() + " TEXT NOT NULL, " + b.timeStamp.name() + " LONG NOT NULL, " + b.pkgName.name() + " TEXT, " + b.versionCode.name() + " INTEGER, " + b.versionName.name() + " TEXT, " + b.status.name() + " INTEGER);";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb3.append(j.PushNewChannelID.name());
            sb3.append(" TEXT");
            g = sb3.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE PushShareInfo ADD COLUMN ");
            sb4.append(j.PushChannelToken.name());
            sb4.append(" TEXT");
            h = sb4.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE PushMsgInfos ADD COLUMN ");
            sb5.append(g.notifyId.name());
            sb5.append(" INTEGER");
            i = sb5.toString();
            j = "CREATE TABLE LocalPushInfo (" + f.pushInfoId.name() + " INTEGER PRIMARY KEY AUTOINCREMENT, " + f.msgId.name() + " TEXT NOT NULL, " + f.appId.name() + " TEXT NOT NULL, " + f.notifyId.name() + " LONG NOT NULL DEFAULT ((0)), " + f.msgType.name() + " INTEGER, " + f.intervalTime.name() + " LONG NOT NULL DEFAULT ((0)), " + f.startTime.name() + " TEXT NOT NULL, " + f.endTime.name() + " TEXT NOT NULL, " + f.expireTime.name() + " LONG NOT NULL DEFAULT ((0)), " + f.msgBody.name() + " TEXT NOT NULL, " + f.signInfo.name() + " BLOB);";
            StringBuilder sb6 = new StringBuilder();
            sb6.append("CREATE TABLE PushConfig (");
            sb6.append(h.configId.name());
            sb6.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
            sb6.append(h.action.name());
            sb6.append(" TEXT NOT NULL, ");
            sb6.append(h.status.name());
            sb6.append(" INTEGER DEFAULT ((1)), ");
            sb6.append(h.interval.name());
            sb6.append(" INTEGER DEFAULT ((1800)), ");
            sb6.append(h.powerLimit.name());
            sb6.append(" INTEGER DEFAULT ((20)), ");
            sb6.append(h.foregroundStart.name());
            sb6.append(" INTEGER DEFAULT ((0)), ");
            sb6.append(h.lastFetchTime.name());
            sb6.append(" LONG );");
            k = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ALTER TABLE PushConfig ADD COLUMN ");
            sb7.append(h.lastFetchTime.name());
            sb7.append(" LONG ");
            l = sb7.toString();
        }

        public e(Context context, String str, int i2, DatabaseErrorHandler databaseErrorHandler) {
            super(context, str, null, i2, databaseErrorHandler);
        }

        public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
            super(context, str, cursorFactory, i2);
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushShareInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushVerifyInfo");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS PushMsgInfo");
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a);
                sQLiteDatabase.execSQL(b);
                sQLiteDatabase.execSQL(c);
                sQLiteDatabase.execSQL(f);
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(j);
                sQLiteDatabase.execSQL(k);
            } catch (Exception unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            String str;
            String str2;
            String str3;
            String str4;
            if (i2 <= 1) {
                a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                return;
            }
            if (i2 == 2) {
                sQLiteDatabase.execSQL(c);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        sQLiteDatabase.execSQL(d);
                        str4 = e;
                        sQLiteDatabase.execSQL(str4);
                        str3 = h;
                        sQLiteDatabase.execSQL(str3);
                        str2 = i;
                        sQLiteDatabase.execSQL(str2);
                        sQLiteDatabase.execSQL(j);
                        str = k;
                        sQLiteDatabase.execSQL(str);
                    } else if (i2 == 6) {
                        sQLiteDatabase.execSQL(d);
                        str3 = e;
                        sQLiteDatabase.execSQL(str3);
                        str2 = i;
                        sQLiteDatabase.execSQL(str2);
                        sQLiteDatabase.execSQL(j);
                        str = k;
                        sQLiteDatabase.execSQL(str);
                    } else {
                        if (i2 != 7) {
                            if (i2 != 8) {
                                if (i2 != 9) {
                                    if (i2 != 10) {
                                        if (i2 == 11) {
                                            str = l;
                                            sQLiteDatabase.execSQL(str);
                                        }
                                        return;
                                    }
                                    str = k;
                                    sQLiteDatabase.execSQL(str);
                                }
                                str2 = "DROP TABLE IF EXISTS LocalPushInfo";
                            }
                            sQLiteDatabase.execSQL(j);
                            str = k;
                            sQLiteDatabase.execSQL(str);
                        }
                        sQLiteDatabase.execSQL(d);
                        str2 = e;
                        sQLiteDatabase.execSQL(str2);
                        sQLiteDatabase.execSQL(j);
                        str = k;
                        sQLiteDatabase.execSQL(str);
                    }
                }
                sQLiteDatabase.execSQL(d);
                sQLiteDatabase.execSQL(e);
                str4 = g;
                sQLiteDatabase.execSQL(str4);
                str3 = h;
                sQLiteDatabase.execSQL(str3);
                str2 = i;
                sQLiteDatabase.execSQL(str2);
                sQLiteDatabase.execSQL(j);
                str = k;
                sQLiteDatabase.execSQL(str);
            }
            sQLiteDatabase.execSQL(f);
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
            str4 = g;
            sQLiteDatabase.execSQL(str4);
            str3 = h;
            sQLiteDatabase.execSQL(str3);
            str2 = i;
            sQLiteDatabase.execSQL(str2);
            sQLiteDatabase.execSQL(j);
            str = k;
            sQLiteDatabase.execSQL(str);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        pushInfoId,
        appId,
        msgId,
        notifyId,
        msgType,
        intervalTime,
        startTime,
        endTime,
        expireTime,
        msgBody,
        signInfo
    }

    /* loaded from: classes.dex */
    public enum g {
        MsgInfoId,
        appId,
        msgType,
        msgId,
        arriveTime,
        secureInfo,
        msgBody,
        expireTime,
        ackRet,
        notifyId
    }

    /* loaded from: classes.dex */
    public enum h {
        configId,
        action,
        status,
        interval,
        powerLimit,
        foregroundStart,
        lastFetchTime
    }

    /* loaded from: classes.dex */
    public enum i {
        dataKey,
        dataSensitive,
        canUpload,
        timeInterval,
        dataValue,
        lastUpdateStamp,
        bindCanUpload
    }

    /* loaded from: classes.dex */
    public enum j {
        PushInfoId,
        PushPriority,
        PushVersion,
        PushChannelID,
        PushNewChannelID,
        PushChannelToken,
        PushCurPkgName,
        PushWebAppBindInfo,
        PushLightAppBindInfo,
        PushSDKClientBindInfo,
        PushClientsBindInfo,
        PushSelfBindInfo
    }

    /* loaded from: classes.dex */
    public enum k {
        verifId,
        msgId,
        md5Infos,
        appId,
        time
    }

    public static int a(Context context, com.baidu.android.pushservice.m.a aVar, long j2) {
        int i2 = 0;
        if (aVar == null) {
            return 0;
        }
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return 0;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(h.lastFetchTime.name(), Long.valueOf(j2));
                i2 = d.update("PushConfig", contentValues, h.action.name() + " = ?", new String[]{String.valueOf(aVar.a())});
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
            return i2;
        }
    }

    public static synchronized long a(Context context, com.baidu.android.pushservice.m.c cVar) {
        Cursor cursor;
        Throwable th;
        long update;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                long j2 = -1;
                if (d == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(j.PushPriority.name(), Long.valueOf(cVar.a));
                contentValues.put(j.PushVersion.name(), Long.valueOf(cVar.b));
                contentValues.put(j.PushChannelID.name(), cVar.c);
                contentValues.put(j.PushNewChannelID.name(), cVar.d);
                contentValues.put(j.PushCurPkgName.name(), cVar.e);
                contentValues.put(j.PushLightAppBindInfo.name(), cVar.g);
                contentValues.put(j.PushWebAppBindInfo.name(), cVar.f);
                contentValues.put(j.PushSDKClientBindInfo.name(), cVar.h);
                contentValues.put(j.PushClientsBindInfo.name(), cVar.i);
                contentValues.put(j.PushSelfBindInfo.name(), cVar.j);
                Cursor cursor2 = null;
                try {
                    cursor = d.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    cursor = null;
                    th = th2;
                }
                if (cursor != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        d.close();
                        return j2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                    if (cursor.getCount() != 0) {
                        update = d.update("PushShareInfo", contentValues, j.PushInfoId.name() + "=1", null);
                        j2 = update;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return j2;
                    }
                }
                update = d.insert("PushShareInfo", null, contentValues);
                j2 = update;
                if (cursor != null) {
                    cursor.close();
                }
                d.close();
                return j2;
            }
        }
    }

    public static String a() {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        return valueOf + " >= " + f.expireTime.name();
    }

    public static String a(Context context) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
        String str = " time(\"" + format + "\") >= time(" + f.startTime.name() + SmallTailInfo.EMOTION_SUFFIX;
        String str2 = " time(\"" + format + "\") <= time(" + f.endTime.name() + SmallTailInfo.EMOTION_SUFFIX;
        return "(" + ("(" + str + " and " + str2 + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.startTime.name() + ") = ''  and " + str2 + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.endTime.name() + ") = ''  and " + str + SmallTailInfo.EMOTION_SUFFIX) + " or " + ("( trim(" + f.startTime.name() + ") = ''  and  trim(" + f.endTime.name() + ") = '' )") + ") and " + ("(" + f.intervalTime.name() + " = 0 or " + f.intervalTime.name() + "<=" + e(context) + SmallTailInfo.EMOTION_SUFFIX) + " and " + (f.expireTime.name() + " >= " + valueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r12.isClosed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str2 = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushDataInfo", null, i.dataKey.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && cursor.getInt(cursor.getColumnIndex(i.bindCanUpload.name())) == 1) {
                            str2 = cursor.getString(cursor.getColumnIndex(i.dataValue.name()));
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        d.close();
                        throw th;
                    }
                }
                if (cursor != null) {
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, boolean z) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushShareInfo", new String[]{j.PushChannelID.name(), j.PushNewChannelID.name()}, null, null, null, null, null);
                try {
                    if (cursor.moveToFirst()) {
                        str = cursor.getString(cursor.getColumnIndex((z ? j.PushNewChannelID : j.PushChannelID).name()));
                    }
                    if (cursor != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str;
        }
    }

    public static void a(Context context, LocalPushMsg localPushMsg) {
        if (localPushMsg == null) {
            return;
        }
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(f.appId.name(), localPushMsg.a());
                contentValues.put(f.msgId.name(), localPushMsg.f());
                contentValues.put(f.notifyId.name(), Integer.valueOf(localPushMsg.h()));
                contentValues.put(f.msgType.name(), Integer.valueOf(localPushMsg.g()));
                contentValues.put(f.intervalTime.name(), Long.valueOf(localPushMsg.d()));
                contentValues.put(f.startTime.name(), localPushMsg.j());
                contentValues.put(f.endTime.name(), localPushMsg.b());
                contentValues.put(f.expireTime.name(), Long.valueOf(localPushMsg.c()));
                String b2 = BaiduAppSSOJni.b(context, localPushMsg.a(), localPushMsg.e());
                contentValues.put(f.signInfo.name(), localPushMsg.i());
                contentValues.put(f.msgBody.name(), b2);
                d.insert("LocalPushInfo", null, contentValues);
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    public static void a(Context context, String str, int i2, long j2) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(i.dataKey.name(), str);
                contentValues.put(i.dataSensitive.name(), Integer.valueOf(i2));
                contentValues.put(i.timeInterval.name(), Long.valueOf(j2));
                contentValues.put(i.canUpload.name(), (Integer) 1);
                if (d.update("PushDataInfo", contentValues, i.dataKey.name() + " =? ", new String[]{String.valueOf(str)}) == 0) {
                    d.insertWithOnConflict("PushDataInfo", null, contentValues, 5);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    public static void a(Context context, String str, int i2, long j2, byte[] bArr, byte[] bArr2, long j3, int i3, int i4) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(g.appId.name(), str);
                contentValues.put(g.msgId.name(), Long.valueOf(j2));
                contentValues.put(g.msgType.name(), Integer.valueOf(i2));
                if (bArr != null && bArr.length > 0) {
                    contentValues.put(g.msgBody.name(), BaiduAppSSOJni.b(context, str, bArr));
                    contentValues.put(g.secureInfo.name(), bArr2);
                    contentValues.put(g.expireTime.name(), Long.valueOf(j3));
                }
                contentValues.put(g.arriveTime.name(), Long.valueOf(System.currentTimeMillis()));
                contentValues.put(g.ackRet.name(), Integer.valueOf(i3));
                contentValues.put(g.notifyId.name(), Integer.valueOf(i4));
                d.insert("PushMsgInfos", null, contentValues);
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    public static void a(Context context, String str, String str2, Long l) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(i.dataValue.name(), str2);
                if (l != null) {
                    contentValues.put(i.lastUpdateStamp.name(), l);
                }
                d.update("PushDataInfo", contentValues, i.dataKey.name() + " =? ", new String[]{String.valueOf(str)});
            } catch (Exception unused) {
            }
            d.close();
        }
    }

    public static void a(Context context, ArrayList<String> arrayList) {
        synchronized (b) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append("'");
                sb.append(arrayList.get(i2));
                sb.append("'");
                if (i2 < arrayList.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                d.execSQL("UPDATE PushDataInfo SET " + i.canUpload.name() + "=0 WHERE " + i.dataKey.name() + " NOT IN " + sb.toString());
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    public static void a(Context context, List<com.baidu.android.pushservice.m.a> list) {
        Cursor cursor;
        Cursor cursor2;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            d.beginTransaction();
            try {
                Cursor cursor3 = null;
                for (com.baidu.android.pushservice.m.a aVar : list) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(h.action.name(), aVar.a());
                        contentValues.put(h.status.name(), Integer.valueOf(aVar.f()));
                        contentValues.put(h.interval.name(), Integer.valueOf(aVar.c()));
                        contentValues.put(h.powerLimit.name(), Integer.valueOf(aVar.e()));
                        contentValues.put(h.foregroundStart.name(), Integer.valueOf(aVar.b()));
                        if (aVar.f() != 2) {
                            cursor3 = d.query("PushConfig", null, h.action.name() + " = ?", new String[]{String.valueOf(aVar.a())}, null, null, null);
                            if (cursor3 == null || cursor3.getCount() == 0) {
                                d.insert("PushConfig", null, contentValues);
                            } else {
                                d.update("PushConfig", contentValues, h.action.name() + " = ?", new String[]{String.valueOf(aVar.a())});
                            }
                        } else {
                            d.delete("PushConfig", h.action.name() + " = ?", new String[]{aVar.a()});
                        }
                    } catch (Exception unused) {
                        cursor2 = cursor3;
                        d.endTransaction();
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        d.close();
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor3;
                        d.endTransaction();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                }
                d.setTransactionSuccessful();
                d.endTransaction();
                if (cursor3 != null && !cursor3.isClosed()) {
                    cursor3.close();
                }
            } catch (Exception unused2) {
                cursor2 = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
            d.close();
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            if (jSONArray != null) {
                try {
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ContentValues contentValues = new ContentValues();
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            long j2 = jSONObject.getLong("event_time");
                            contentValues.put(c.clickData.name(), jSONObject.toString());
                            contentValues.put(c.timeStamps.name(), Long.valueOf(j2));
                            d.insert("ClickMsgUploadInfo", null, contentValues);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            d.close();
        }
    }

    public static void a(Context context, String[] strArr) {
        if (strArr == null) {
            return;
        }
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                for (String str : strArr) {
                    d.delete("LocalPushInfo", f.msgId.name() + " = ?", new String[]{str});
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, int i2) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor = null;
            if (d == null) {
                return false;
            }
            try {
                cursor = d.query("PushMsgInfos", new String[]{g.notifyId.name()}, g.notifyId.name() + RFC1522Codec.PREFIX, new String[]{String.valueOf(i2)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return true;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean a(Context context, long j2) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor = null;
            if (d == null) {
                return false;
            }
            try {
                cursor = d.query("PushMsgInfos", new String[]{g.msgId.name()}, g.msgId.name() + " =? ", new String[]{String.valueOf(j2)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return true;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
        if (r7.isClosed() == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, com.baidu.android.pushservice.m.e eVar) {
        long j2;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(k.msgId.name(), eVar.a);
                contentValues.put(k.md5Infos.name(), eVar.b);
                contentValues.put(k.appId.name(), eVar.c);
                contentValues.put(k.time.name(), System.currentTimeMillis() + "");
                Cursor cursor = null;
                try {
                    j2 = d.insert("PushVerifInfo", null, contentValues);
                    try {
                        cursor = d.rawQuery("SELECT COUNT(*) FROM PushVerifInfo;", null);
                        if (cursor.moveToFirst() && cursor.getInt(0) > 200) {
                            d.delete("PushVerifInfo", " msgId IS NOT ?", new String[]{eVar.a});
                        }
                        if (cursor != null) {
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        if (j2 != -1) {
                        }
                        return r2;
                    }
                } catch (Exception unused2) {
                    j2 = -1;
                }
                d.close();
                boolean z = j2 != -1;
                return z;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
        if (r10.isClosed() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e3, code lost:
        if (r10.isClosed() != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return false;
            }
            Cursor cursor = null;
            try {
                cursor = d.query("PushDataInfo", null, i.dataKey.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
            if (cursor != null && cursor.moveToFirst()) {
                int i2 = cursor.getInt(cursor.getColumnIndex(i.dataSensitive.name()));
                String string = cursor.getString(cursor.getColumnIndex(i.dataValue.name()));
                if (cursor.getInt(cursor.getColumnIndex(i.canUpload.name())) != 1) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } else if (i2 == 1 && str2.equals(string)) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return false;
                } else if (System.currentTimeMillis() - cursor.getLong(cursor.getColumnIndex(i.lastUpdateStamp.name())) <= cursor.getLong(cursor.getColumnIndex(i.timeInterval.name())) * 1000) {
                    if (cursor != null) {
                    }
                    d.close();
                    return false;
                } else {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return true;
                }
            }
            d.close();
            return false;
        }
    }

    public static Object b() {
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (r0 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Cursor cursor2 = null;
        try {
            if (Utility.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str + ".bdpush/verif");
                String[] strArr = {k.md5Infos.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(k.md5Infos.name());
                sb.append(RFC1522Codec.PREFIX);
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor == null) {
                            return null;
                        }
                        str3 = null;
                        cursor2 = cursor;
                        try {
                            cursor2.close();
                        } catch (Exception unused2) {
                            return str3;
                        }
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public static void b(Context context) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                d.delete("ClickMsgUploadInfo", null, null);
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    public static void b(Context context, JSONArray jSONArray) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                sb.append("'");
                String str = "";
                try {
                    str = jSONArray.get(i2).toString();
                } catch (JSONException unused) {
                }
                sb.append(str);
                sb.append("'");
                if (i2 < jSONArray.length() - 1) {
                    sb.append(",");
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(i.bindCanUpload.name(), (Integer) 0);
                d.update("PushDataInfo", contentValues, null, null);
                d.execSQL("UPDATE PushDataInfo SET " + i.bindCanUpload.name() + "=1 WHERE " + i.dataKey.name() + " IN " + sb.toString());
            } catch (Exception unused2) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, int i2) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor = null;
            if (d == null) {
                return false;
            }
            int i3 = -1;
            try {
                cursor = d.query("PushMsgInfos", null, g.notifyId.name() + RFC1522Codec.PREFIX, new String[]{String.valueOf(i2)}, null, null, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    i3 = cursor.getInt(cursor.getColumnIndex(g.msgType.name()));
                }
                if (i3 != l.MSG_TYPE_PRIVATE_MESSAGE.a() && i3 != l.MSG_TYPE_MULTI_PRIVATE.a() && i3 != l.MSG_TYPE_SINGLE_PRIVATE.a() && i3 != l.MSG_TYPE_APP_PRIORITY.a()) {
                    if (i3 != l.MSG_TYPE_LOCAL_PUSH_MESSAGE.a()) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return false;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return true;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, INVOKE] complete} */
    public static boolean b(Context context, String str) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor = null;
            if (d == null) {
                return false;
            }
            try {
                cursor = d.query("LocalPushInfo", new String[]{f.msgId.name()}, f.msgId.name() + " =? ", new String[]{String.valueOf(str)}, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return true;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                return false;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
        if (r11.isClosed() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b3, code lost:
        if (r11.isClosed() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.android.pushservice.m.a c(Context context, String str) {
        com.baidu.android.pushservice.m.a aVar = new com.baidu.android.pushservice.m.a();
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return aVar;
            }
            Cursor cursor = null;
            try {
                cursor = d.query("PushConfig", null, h.action.name() + " = ?", new String[]{String.valueOf(str)}, null, null, null, null);
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                d.close();
                throw th;
            }
            if (cursor != null && cursor.moveToFirst()) {
                aVar.a(str);
                aVar.d(cursor.getInt(cursor.getColumnIndex(h.status.name())));
                aVar.b(cursor.getInt(cursor.getColumnIndex(h.interval.name())));
                aVar.c(cursor.getInt(cursor.getColumnIndex(h.powerLimit.name())));
                aVar.a(cursor.getInt(cursor.getColumnIndex(h.foregroundStart.name())));
                aVar.a(cursor.getLong(cursor.getColumnIndex(h.lastFetchTime.name())));
                if (cursor != null) {
                }
                d.close();
                return aVar;
            }
            d.close();
            return aVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (r0 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, String str, String str2) {
        Cursor cursor;
        String str3;
        ContentResolver contentResolver;
        Cursor cursor2 = null;
        try {
            if (Utility.g(context, str) < 52 || (contentResolver = context.getContentResolver()) == null) {
                str3 = null;
            } else {
                Uri parse = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str + ".bdpush/verif");
                String[] strArr = {k.md5Infos.name()};
                StringBuilder sb = new StringBuilder();
                sb.append(k.msgId.name());
                sb.append(RFC1522Codec.PREFIX);
                cursor = contentResolver.query(parse, strArr, sb.toString(), new String[]{str2}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str3 = cursor.getString(0);
                            cursor2 = cursor;
                        }
                    } catch (Throwable unused) {
                        if (cursor == null) {
                            return null;
                        }
                        str3 = null;
                        cursor2 = cursor;
                        try {
                            cursor2.close();
                        } catch (Exception unused2) {
                            return str3;
                        }
                    }
                }
                str3 = null;
                cursor2 = cursor;
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
    }

    public static JSONArray c(Context context) {
        int a2;
        long j2;
        JSONArray jSONArray = new JSONArray();
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return jSONArray;
            }
            Cursor cursor = null;
            try {
                a2 = com.baidu.android.pushservice.a0.i.a(context, "click_data_size", 10) - 1;
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            if (a2 <= 0) {
                d.close();
                return jSONArray;
            }
            Cursor query = d.query(false, "ClickMsgUploadInfo", null, null, null, null, null, c.timeStamps.name() + " DESC ", String.valueOf(a2));
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        do {
                            String string = query.getString(query.getColumnIndex(c.clickData.name()));
                            j2 = query.getLong(query.getColumnIndex(c.timeStamps.name()));
                            jSONArray.put(new JSONObject(string));
                        } while (query.moveToNext());
                        if (d.delete("ClickMsgUploadInfo", c.timeStamps.name() + " >= " + String.valueOf(j2), null) == 0) {
                            jSONArray = new JSONArray();
                        }
                    }
                } catch (Exception unused2) {
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return jSONArray;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            d.close();
            return jSONArray;
        }
    }

    public static SQLiteDatabase d(Context context) {
        e f2 = f(context);
        if (f2 == null) {
            return null;
        }
        try {
            return f2.getWritableDatabase();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static PushConfigData d(Context context, String str) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            PushConfigData pushConfigData = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushDataInfo", null, i.dataKey.name() + " =? ", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            pushConfigData = new PushConfigData(cursor.getString(cursor.getColumnIndex(i.dataValue.name())), cursor.getLong(cursor.getColumnIndex(i.timeInterval.name())));
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return pushConfigData;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        d.close();
                        throw th;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return pushConfigData;
        }
    }

    public static synchronized void d(Context context, String str, String str2) {
        Cursor query;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = d.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(j.PushChannelID.name(), str);
                        if (!TextUtils.isEmpty(str2)) {
                            contentValues.put(j.PushNewChannelID.name(), str2);
                        }
                        d.update("PushShareInfo", contentValues, j.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        d.close();
                    }
                }
                com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                cVar.a = 0L;
                cVar.b = 0L;
                cVar.c = str;
                cVar.d = str2;
                cVar.e = null;
                cVar.g = null;
                cVar.f = null;
                cVar.h = null;
                cVar.i = null;
                cVar.j = null;
                a(context, cVar);
                if (query != null) {
                    query.close();
                }
                d.close();
            }
        }
    }

    public static long e(Context context) {
        return (System.currentTimeMillis() / 1000) - com.baidu.android.pushservice.a0.i.a(context, "local_notify_msg_handle_last_time", 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r11.isClosed() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context, String str) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            r9 = null;
            String str2 = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushDataInfo", null, i.dataKey.name() + " =? ", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            str2 = cursor.getString(cursor.getColumnIndex(i.dataValue.name()));
                        }
                    } catch (Exception unused) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        return str2;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        d.close();
                        throw th;
                    }
                }
                if (cursor != null) {
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ae, code lost:
        if (r8 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e f(Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    File file = new File(Environment.getDataDirectory().getAbsolutePath() + "/data" + File.separator + context.getPackageName() + "/database");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String str = file.getAbsolutePath() + File.separator + "pushinfo.db";
                    SQLiteDatabase sQLiteDatabase = null;
                    a = Build.VERSION.SDK_INT >= 11 ? new e(context, str, 12, new C0031d()) : new e(context, str, (SQLiteDatabase.CursorFactory) null, 12);
                    try {
                        SQLiteDatabase sQLiteDatabase2 = a.getWritableDatabase();
                        try {
                            sQLiteDatabase2.delete("PushMsgInfos", g.arriveTime.name() + " < " + (System.currentTimeMillis() - 259200000), null);
                            sQLiteDatabase2.delete("LocalPushInfo", a(), null);
                        } catch (Throwable unused) {
                            sQLiteDatabase = sQLiteDatabase2;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase2 = sQLiteDatabase;
                                sQLiteDatabase2.close();
                            }
                            return a;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return a;
    }

    public static synchronized void f(Context context, String str) {
        Cursor query;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = d.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(j.PushChannelToken.name(), str);
                        d.update("PushShareInfo", contentValues, j.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        d.close();
                    }
                }
                com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                cVar.a = 0L;
                cVar.b = 0L;
                cVar.c = null;
                cVar.d = null;
                cVar.e = null;
                cVar.g = null;
                cVar.f = null;
                cVar.h = null;
                cVar.i = null;
                cVar.j = null;
                a(context, cVar);
                if (query != null) {
                    query.close();
                }
                d.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1.isClosed() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushShareInfo", new String[]{j.PushChannelToken.name()}, null, null, null, null, null);
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.PushChannelToken.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str;
        }
    }

    public static synchronized void g(Context context, String str) {
        Cursor query;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null || str == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = d.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(j.PushClientsBindInfo.name(), str);
                        d.update("PushShareInfo", contentValues, j.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        d.close();
                    }
                }
                com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                cVar.a = 0L;
                cVar.b = 0L;
                cVar.c = null;
                cVar.d = null;
                cVar.e = null;
                cVar.g = null;
                cVar.f = null;
                cVar.h = null;
                cVar.i = str;
                cVar.j = null;
                a(context, cVar);
                if (query != null) {
                    query.close();
                }
                d.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1.isClosed() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushShareInfo", new String[]{j.PushClientsBindInfo.name()}, null, null, null, null, null);
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.PushClientsBindInfo.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str;
        }
    }

    public static synchronized void h(Context context, String str) {
        Cursor query;
        synchronized (d.class) {
            synchronized (b) {
                SQLiteDatabase d = d(context);
                if (d == null || str == null) {
                    return;
                }
                Cursor cursor = null;
                try {
                    query = d.query("PushShareInfo", null, null, null, null, null, null);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                if (query != null) {
                    try {
                    } catch (Exception unused2) {
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        d.close();
                        throw th;
                    }
                    if (query.getCount() != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(j.PushSelfBindInfo.name(), str);
                        d.update("PushShareInfo", contentValues, j.PushInfoId.name() + "=1", null);
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        d.close();
                    }
                }
                com.baidu.android.pushservice.m.c cVar = new com.baidu.android.pushservice.m.c();
                cVar.a = 0L;
                cVar.b = 0L;
                cVar.c = null;
                cVar.d = null;
                cVar.e = null;
                cVar.g = null;
                cVar.f = null;
                cVar.h = null;
                cVar.i = null;
                cVar.j = str;
                a(context, cVar);
                if (query != null) {
                    query.close();
                }
                d.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1.isClosed() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(Context context) {
        Cursor cursor;
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor2 = null;
            r9 = null;
            r9 = null;
            String str = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("PushShareInfo", new String[]{j.PushSelfBindInfo.name()}, null, null, null, null, null);
                try {
                    str = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex(j.PushSelfBindInfo.name())) : null;
                    if (cursor != null) {
                    }
                } catch (Exception unused) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    d.close();
                    return str;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    d.close();
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
            }
            d.close();
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d0, code lost:
        if (r11.isClosed() == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<LocalPushMsg> j(Context context) {
        ArrayList arrayList = new ArrayList();
        synchronized (b) {
            SQLiteDatabase d = d(context);
            Cursor cursor = null;
            if (d == null) {
                return null;
            }
            try {
                cursor = d.query("LocalPushInfo", new String[0], a(context), null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    String string = cursor.getString(cursor.getColumnIndex(f.appId.name()));
                    String string2 = cursor.getString(cursor.getColumnIndex(f.msgId.name()));
                    int i2 = cursor.getInt(cursor.getColumnIndex(f.notifyId.name()));
                    int i3 = cursor.getInt(cursor.getColumnIndex(f.msgType.name()));
                    long j2 = cursor.getLong(cursor.getColumnIndex(f.intervalTime.name()));
                    String string3 = cursor.getString(cursor.getColumnIndex(f.startTime.name()));
                    String string4 = cursor.getString(cursor.getColumnIndex(f.endTime.name()));
                    long j3 = cursor.getLong(cursor.getColumnIndex(f.expireTime.name()));
                    String string5 = cursor.getString(cursor.getColumnIndex(f.msgBody.name()));
                    arrayList.add(new LocalPushMsg(string, string2, i2, i3, j2, string3, string4, j3, BaiduAppSSOJni.a(context, string, string5), cursor.getBlob(cursor.getColumnIndex(f.signInfo.name()))));
                }
                if (cursor != null) {
                }
            } catch (Exception unused) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
            d.close();
            return arrayList;
        }
    }

    public static void k(Context context) {
        synchronized (b) {
            SQLiteDatabase d = d(context);
            if (d == null) {
                return;
            }
            try {
                d.delete("LocalPushInfo", null, null);
            } catch (Exception unused) {
            } catch (Throwable th) {
                d.close();
                throw th;
            }
            d.close();
        }
    }
}
