package com.baidu.android.systemmonitor.devicestatistic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import com.baidu.android.systemmonitor.d.a.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d {
    private static d b = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f813a = false;
    private Context c;
    private com.baidu.android.systemmonitor.a.c d;

    public d(Context context) {
        this.c = null;
        this.c = context.getApplicationContext();
        this.d = new com.baidu.android.systemmonitor.a.c(this.c);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(context);
            }
            dVar = b;
        }
        return dVar;
    }

    public static synchronized void b() {
        synchronized (d.class) {
            if (b != null) {
                b.a();
                b = null;
            }
        }
    }

    public static long d() {
        long e = com.baidu.android.systemmonitor.d.d.e() * Util.MILLSECONDS_OF_MINUTE;
        return e == 0 ? Util.MILLSECONDS_OF_DAY : e;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList a(int i, long j) {
        String[] strArr;
        String str;
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        if (j != 0) {
            str = "startstamp >? and startstamp <?";
            strArr = new String[]{String.valueOf(j - k.a(this.c).d()), String.valueOf(j)};
        } else {
            strArr = null;
            str = null;
        }
        switch (i) {
            case 1:
                try {
                    cursor = this.d.b().query("power", c.f812a, str, strArr, null, null, "startstamp ASC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                do {
                                    arrayList.add(new com.baidu.android.systemmonitor.devicestatistic.a.e(cursor));
                                } while (cursor.moveToNext());
                            }
                        } catch (Exception e) {
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                }
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            cursor2 = cursor;
                            th = th;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e3) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Exception e5) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            case 2:
                try {
                    cursor2 = this.d.b().query("charge", c.b, str, strArr, null, null, "startstamp ASC");
                    if (cursor2 != null && cursor2.moveToFirst()) {
                        do {
                            arrayList.add(new com.baidu.android.systemmonitor.devicestatistic.a.b(cursor2));
                        } while (cursor2.moveToNext());
                        if (cursor2 != null) {
                        }
                    } else if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    }
                } catch (Exception e7) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    }
                } catch (Throwable th3) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e9) {
                        }
                    }
                    throw th3;
                }
                break;
            case 3:
                try {
                    cursor2 = this.d.b().query("network", c.c, str, strArr, null, null, "startstamp ASC");
                    if (cursor2 != null && cursor2.moveToFirst()) {
                        do {
                            arrayList.add(new com.baidu.android.systemmonitor.devicestatistic.a.d(cursor2));
                        } while (cursor2.moveToNext());
                        if (cursor2 != null) {
                        }
                    } else if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e10) {
                            break;
                        }
                    }
                } catch (Exception e11) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e12) {
                            break;
                        }
                    }
                } catch (Throwable th4) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e13) {
                        }
                    }
                    throw th4;
                }
                break;
            case 4:
                try {
                    cursor2 = this.d.b().query("stinfo", c.d, str, strArr, null, null, "startstamp ASC");
                    if (cursor2 != null && cursor2.moveToFirst()) {
                        do {
                            arrayList.add(new com.baidu.android.systemmonitor.devicestatistic.a.f(cursor2));
                        } while (cursor2.moveToNext());
                        if (cursor2 != null) {
                        }
                    } else if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e14) {
                            break;
                        }
                    }
                } catch (Exception e15) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e16) {
                            break;
                        }
                    }
                } catch (Throwable th5) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e17) {
                        }
                    }
                    throw th5;
                }
                break;
            case 5:
                try {
                    cursor2 = this.d.b().query("apkdn", c.e, str, strArr, null, null, "startstamp ASC");
                    if (cursor2 != null && cursor2.moveToFirst()) {
                        do {
                            arrayList.add(new com.baidu.android.systemmonitor.devicestatistic.a.a(cursor2));
                        } while (cursor2.moveToNext());
                        if (cursor2 != null) {
                        }
                    } else if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e18) {
                            break;
                        }
                    }
                } catch (Exception e19) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                            break;
                        } catch (Exception e20) {
                            break;
                        }
                    }
                } catch (Throwable th6) {
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e21) {
                        }
                    }
                    throw th6;
                }
                break;
        }
        return arrayList;
    }

    public void a() {
        if (this.d == null || this.f813a) {
            return;
        }
        this.f813a = true;
        this.d.c();
        this.d = null;
    }

    public void a(Context context, long j) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("com.baidu.systemmonitor.getstoreinfo"), 268435456);
        long d = d();
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, j + d, d, broadcast);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|(3:35|36|(10:38|39|(1:7)|8|9|10|(6:14|(1:15)|17|18|(1:20)|21)|(1:24)|25|26))|5|(0)|8|9|10|(7:12|14|(1:15)|17|18|(0)|21)|(0)|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
        if (r6 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d2, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
        if (r6 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dc, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[Catch: SQLiteException -> 0x00cf, all -> 0x00d6, TryCatch #4 {SQLiteException -> 0x00cf, all -> 0x00d6, blocks: (B:12:0x003d, B:14:0x0051, B:16:0x0057, B:17:0x0068, B:19:0x009c, B:21:0x00a2, B:22:0x00ab), top: B:52:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a2 A[Catch: SQLiteException -> 0x00cf, all -> 0x00d6, TryCatch #4 {SQLiteException -> 0x00cf, all -> 0x00d6, blocks: (B:12:0x003d, B:14:0x0051, B:16:0x0057, B:17:0x0068, B:19:0x009c, B:21:0x00a2, B:22:0x00ab), top: B:52:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, long j, com.baidu.android.systemmonitor.devicestatistic.a.f fVar) {
        Cursor cursor;
        int columnIndex;
        int columnIndex2;
        int count;
        int i = 0;
        Cursor cursor2 = null;
        StringBuilder sb = new StringBuilder();
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {"_id", "date", "type"};
        Uri parse = Uri.parse("content://sms/");
        try {
            cursor = contentResolver.query(parse, strArr, null, null, "date desc");
        } catch (Exception e) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
            } catch (Exception e2) {
                if (cursor != null) {
                    cursor.close();
                }
                cursor2 = contentResolver.query(parse, strArr, "date>?", new String[]{String.valueOf(j)}, "date desc");
                if (cursor2 != null) {
                }
                if (cursor2 != null) {
                }
                fVar.c = i;
                fVar.d = sb.toString();
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (cursor.moveToFirst()) {
                count = cursor.getCount();
                if (cursor != null) {
                    cursor.close();
                }
                i = count;
                cursor2 = contentResolver.query(parse, strArr, "date>?", new String[]{String.valueOf(j)}, "date desc");
                if (cursor2 != null && cursor2.moveToFirst()) {
                    columnIndex = cursor2.getColumnIndex("date");
                    columnIndex2 = cursor2.getColumnIndex("type");
                    sb.append("[");
                    do {
                        sb.append(cursor2.getInt(columnIndex2) + "@" + (Long.parseLong(cursor2.getString(columnIndex)) / 1000));
                        sb.append(",");
                    } while (cursor2.moveToNext());
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append("]");
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                fVar.c = i;
                fVar.d = sb.toString();
            }
        }
        count = 0;
        if (cursor != null) {
        }
        i = count;
        cursor2 = contentResolver.query(parse, strArr, "date>?", new String[]{String.valueOf(j)}, "date desc");
        if (cursor2 != null) {
            columnIndex = cursor2.getColumnIndex("date");
            columnIndex2 = cursor2.getColumnIndex("type");
            sb.append("[");
            do {
                sb.append(cursor2.getInt(columnIndex2) + "@" + (Long.parseLong(cursor2.getString(columnIndex)) / 1000));
                sb.append(",");
            } while (cursor2.moveToNext());
            if (sb.length() > 1) {
            }
            sb.append("]");
        }
        if (cursor2 != null) {
        }
        fVar.c = i;
        fVar.d = sb.toString();
    }

    public boolean a(com.baidu.android.systemmonitor.devicestatistic.a.c cVar) {
        long insert;
        if (cVar == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("startstamp", Long.valueOf(cVar.g));
            switch (cVar.h) {
                case 1:
                    contentValues.put("stopstamp", Long.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.e) cVar).f809a));
                    insert = this.d.a().insert("power", null, contentValues);
                    break;
                case 2:
                    contentValues.put("stopstamp", Long.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).e));
                    contentValues.put("chargetype", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).f));
                    contentValues.put("startlevel", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).b));
                    contentValues.put("stoplevel", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).c));
                    contentValues.put("netype", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).d));
                    contentValues.put("loc", ((com.baidu.android.systemmonitor.devicestatistic.a.b) cVar).f807a);
                    insert = this.d.a().insert("charge", null, contentValues);
                    break;
                case 3:
                    contentValues.put("stopstamp", Long.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).f808a));
                    contentValues.put("netype", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).b));
                    contentValues.put("flow", Long.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.d) cVar).c));
                    insert = this.d.a().insert("network", null, contentValues);
                    break;
                case 4:
                    contentValues.put("pconum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).f810a));
                    contentValues.put("sconum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).b));
                    contentValues.put("msnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).c));
                    contentValues.put("msinfo", ((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).d);
                    contentValues.put("calognum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).e));
                    contentValues.put("caloginfo", ((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).f);
                    contentValues.put("sdfall", ((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).i);
                    contentValues.put("pfall", ((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).j);
                    contentValues.put("pphnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).k));
                    contentValues.put("sphnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).l));
                    contentValues.put("pmpnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).m));
                    contentValues.put("smpnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).n));
                    contentValues.put("stvnum", Integer.valueOf(((com.baidu.android.systemmonitor.devicestatistic.a.f) cVar).o));
                    insert = this.d.a().insert("stinfo", null, contentValues);
                    break;
                case 5:
                    contentValues.put("dnpath", ((com.baidu.android.systemmonitor.devicestatistic.a.a) cVar).f806a);
                    contentValues.put("downame", ((com.baidu.android.systemmonitor.devicestatistic.a.a) cVar).b);
                    insert = this.d.a().insert("apkdn", null, contentValues);
                    break;
                default:
                    insert = 0;
                    break;
            }
            return insert > 0;
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public void b(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.baidu.systemmonitor.getstoreinfo"), 268435456));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:2|3)|(3:41|42|(10:44|45|(1:7)|8|9|10|(3:17|18|(6:20|(1:21)|23|24|(1:26)|27))|(1:13)|14|15))|5|(0)|8|9|10|(0)|(0)|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e9, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, long j, com.baidu.android.systemmonitor.devicestatistic.a.f fVar) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        int count;
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {"_id", "type", "date", "duration"};
        String[] strArr2 = {String.valueOf(j)};
        Cursor cursor4 = null;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        try {
            cursor = contentResolver.query(CallLog.Calls.CONTENT_URI, strArr, null, null, "date DESC");
        } catch (Exception e) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursor != null) {
            try {
            } catch (Exception e2) {
                if (cursor != null) {
                    cursor.close();
                }
                cursor2 = null;
                cursor3 = contentResolver.query(CallLog.Calls.CONTENT_URI, strArr, "date>?", strArr2, "date DESC");
                if (cursor3 != null) {
                }
                if (cursor3 != null) {
                }
                fVar.e = i;
                fVar.f = sb.toString();
            } catch (Throwable th2) {
                th = th2;
                cursor4 = cursor;
                if (cursor4 != null) {
                    cursor4.close();
                }
                throw th;
            }
            if (cursor.moveToFirst()) {
                count = cursor.getCount();
                if (cursor != null) {
                    cursor.close();
                }
                cursor2 = null;
                i = count;
                cursor3 = contentResolver.query(CallLog.Calls.CONTENT_URI, strArr, "date>?", strArr2, "date DESC");
                if (cursor3 != null) {
                    try {
                        if (cursor3.moveToFirst()) {
                            sb.append("[");
                            do {
                                sb.append(cursor3.getInt(cursor3.getColumnIndex("type")) + "@" + (cursor3.getLong(cursor3.getColumnIndex("date")) / 1000) + "@" + cursor3.getLong(cursor3.getColumnIndex("duration")) + ",");
                            } while (cursor3.moveToNext());
                            if (sb.length() > 1) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            sb.append("]");
                        }
                    } catch (Exception e3) {
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        fVar.e = i;
                        fVar.f = sb.toString();
                    } catch (Throwable th3) {
                        cursor2 = cursor3;
                        th = th3;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                if (cursor3 != null) {
                    cursor3.close();
                }
                fVar.e = i;
                fVar.f = sb.toString();
            }
        }
        count = 0;
        if (cursor != null) {
        }
        cursor2 = null;
        i = count;
        cursor3 = contentResolver.query(CallLog.Calls.CONTENT_URI, strArr, "date>?", strArr2, "date DESC");
        if (cursor3 != null) {
        }
        if (cursor3 != null) {
        }
        fVar.e = i;
        fVar.f = sb.toString();
    }

    public boolean b(int i, long j) {
        String str;
        String[] strArr = null;
        if (j != 0) {
            str = "startstamp <?";
            strArr = new String[]{String.valueOf(j)};
        } else {
            str = null;
        }
        switch (i) {
            case 1:
                try {
                    this.d.a().delete("power", str, strArr);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            case 2:
                try {
                    this.d.a().delete("charge", str, strArr);
                    return true;
                } catch (Exception e2) {
                    return false;
                }
            case 3:
                try {
                    this.d.a().delete("network", str, strArr);
                    return true;
                } catch (Exception e3) {
                    return false;
                }
            case 4:
                try {
                    this.d.a().delete("stinfo", str, strArr);
                    return true;
                } catch (Exception e4) {
                    return false;
                }
            case 5:
                try {
                    this.d.a().delete("apkdn", str, strArr);
                    return true;
                } catch (Exception e5) {
                    return false;
                }
            default:
                return true;
        }
    }

    public void c() {
        new Thread(new e(this)).start();
    }
}
