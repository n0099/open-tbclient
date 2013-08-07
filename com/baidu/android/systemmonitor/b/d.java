package com.baidu.android.systemmonitor.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class d {
    private static volatile d d = null;
    private ExecutorService b;
    private com.baidu.android.systemmonitor.a.a c;
    private Context e = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f644a = false;

    private d(Context context) {
        this.b = null;
        try {
            this.c = new com.baidu.android.systemmonitor.a.a(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = Executors.newSingleThreadExecutor();
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            Context applicationContext = context.getApplicationContext();
            if (d == null) {
                d = new d(applicationContext);
            }
            d.e = applicationContext;
            dVar = d;
        }
        return dVar;
    }

    public static String a(String str, String str2, int i) {
        int countTokens = new StringTokenizer(str, ",").countTokens();
        if (countTokens < i) {
            return countTokens != 0 ? str + "," + str2 : str2;
        }
        StringBuilder sb = new StringBuilder(str);
        return sb.substring(sb.indexOf(",") + 1) + "," + str2;
    }

    public static synchronized void a() {
        synchronized (d.class) {
            if (d != null) {
                d.h();
            }
            d = null;
        }
    }

    public static boolean a(long j) {
        return j < 0;
    }

    public static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static int c(Context context) {
        int i;
        if (com.baidu.android.systemmonitor.d.d.h() != -1) {
            return com.baidu.android.systemmonitor.d.d.h();
        }
        int c = com.baidu.android.systemmonitor.d.b.c(context);
        if (c != -1) {
            return c;
        }
        if (Build.VERSION.SDK_INT <= 15) {
            Class b = b("android.app.IActivityWatcher");
            HashMap hashMap = new HashMap();
            hashMap.put("activityResuming", Integer.TYPE.toString());
            hashMap.put("closingSystemDialogs", String.class.toString());
            Method[] declaredMethods = b.getDeclaredMethods();
            for (Method method : declaredMethods) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (hashMap.containsKey(name) && parameterTypes.length == 1 && parameterTypes[0].toString().equals(hashMap.get(name))) {
                    hashMap.remove(name);
                }
            }
            i = hashMap.size() > 0 ? 2 : 0;
        } else if (com.baidu.android.systemmonitor.d.c.a(context, "android.permission.SET_ACTIVITY_WATCHER") == 0) {
            com.baidu.android.systemmonitor.d.b.a(context, 2);
            return 2;
        } else {
            Method[] declaredMethods2 = b("android.app.IProcessObserver").getDeclaredMethods();
            if (declaredMethods2.length != 3) {
                com.baidu.android.systemmonitor.d.b.a(context, 2);
                return 2;
            }
            String[][] strArr = {new String[]{"onForegroundActivitiesChanged", Integer.TYPE.toString(), Integer.TYPE.toString(), Boolean.TYPE.toString()}, new String[]{"onImportanceChanged", Integer.TYPE.toString(), Integer.TYPE.toString(), Integer.TYPE.toString()}, new String[]{"onProcessDied", Integer.TYPE.toString(), Integer.TYPE.toString()}};
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int length = declaredMethods2.length;
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        Method method2 = declaredMethods2[i4];
                        if (strArr[i3][0].equals(method2.getName())) {
                            int length2 = strArr[i3].length - 1;
                            Class<?>[] parameterTypes2 = method2.getParameterTypes();
                            if (length2 != parameterTypes2.length) {
                                com.baidu.android.systemmonitor.d.b.a(context, 2);
                                return 2;
                            }
                            for (int i5 = 0; i5 < length2; i5++) {
                                if (!parameterTypes2[i5].toString().equals(strArr[i3][i5 + 1])) {
                                    com.baidu.android.systemmonitor.d.b.a(context, 2);
                                    return 2;
                                }
                            }
                            i2++;
                        } else {
                            i4++;
                        }
                    }
                }
            }
            if (i2 == 3) {
                com.baidu.android.systemmonitor.d.b.a(context, 1);
                return 1;
            }
            i = c;
        }
        com.baidu.android.systemmonitor.d.b.a(context, i);
        return i;
    }

    private static long c(String str) {
        long j = 0;
        if (str != null && !str.equals("")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken != null) {
                    j += Long.parseLong(nextToken);
                }
            }
        }
        return j;
    }

    private static int d(String str) {
        int i = 0;
        if (str != null && !str.equals("")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken != null) {
                    i += Integer.parseInt(nextToken);
                }
            }
        }
        return i;
    }

    private void h() {
        if (this.c == null || e()) {
            return;
        }
        this.f644a = true;
        this.c.c();
        this.c = null;
    }

    private static int i() {
        int i = com.baidu.android.systemmonitor.d.d.i();
        if (i == 0) {
            return 30;
        }
        return i;
    }

    public b a(String str) {
        Cursor cursor;
        Cursor cursor2;
        b bVar;
        Cursor cursor3 = null;
        if (str == null) {
            return null;
        }
        try {
            cursor = this.c.b().query("astatus", c.f643a, "pn=?", new String[]{str}, null, null, "lautimes ASC");
        } catch (NullPointerException e) {
            cursor2 = null;
        } catch (Exception e2) {
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        if (cursor != null) {
            try {
            } catch (NullPointerException e3) {
                cursor2 = cursor;
                try {
                    try {
                        this.c = new com.baidu.android.systemmonitor.a.a(this.e);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.deactivate();
                            cursor2.close();
                            bVar = null;
                            return bVar;
                        }
                        bVar = null;
                        return bVar;
                    }
                    if (cursor2 != null) {
                        cursor2.deactivate();
                        cursor2.close();
                        bVar = null;
                        return bVar;
                    }
                    bVar = null;
                    return bVar;
                } catch (Throwable th2) {
                    cursor3 = cursor2;
                    th = th2;
                    if (cursor3 != null && !cursor3.isClosed()) {
                        cursor3.deactivate();
                        cursor3.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                    bVar = null;
                    return bVar;
                }
                bVar = null;
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
                if (cursor3 != null) {
                    cursor3.deactivate();
                    cursor3.close();
                }
                throw th;
            }
            if (cursor.moveToFirst()) {
                bVar = new b(cursor);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                }
                return bVar;
            }
        }
        bVar = null;
        if (cursor != null) {
            cursor.deactivate();
            cursor.close();
        }
        return bVar;
    }

    public void a(ContentResolver contentResolver, a aVar) {
        String str;
        String str2 = null;
        try {
            str = com.baidu.android.systemmonitor.security.a.a(aVar.f641a);
            try {
                str2 = com.baidu.android.systemmonitor.security.a.a(aVar.h);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str = null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pn", str);
        contentValues.put("an", str2);
        contentValues.put("event", Integer.valueOf(aVar.c));
        contentValues.put("time", Long.valueOf(aVar.b));
        contentValues.put("vcode", Integer.valueOf(aVar.e));
        contentValues.put("vcodeaft", Integer.valueOf(aVar.g));
        contentValues.put("vn", aVar.d);
        contentValues.put("vnaft", aVar.f);
        try {
            this.c.a().insert("achange", null, contentValues);
        } catch (NullPointerException e3) {
            try {
                this.c = new com.baidu.android.systemmonitor.a.a(this.e);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
        }
    }

    public void a(ContentResolver contentResolver, b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pn", bVar.d);
        contentValues.put("lautimes", Integer.valueOf(bVar.h));
        contentValues.put("totaltime", Long.valueOf(bVar.k));
        contentValues.put("lauper", bVar.j);
        contentValues.put("laucur", Integer.valueOf(bVar.i));
        contentValues.put("timeper", bVar.l);
        contentValues.put("timecur", Long.valueOf(bVar.m));
        try {
            this.c.a().insert("astatus", null, contentValues);
        } catch (NullPointerException e) {
            try {
                this.c = new com.baidu.android.systemmonitor.a.a(this.e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
        }
    }

    public void a(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lautimes", Integer.valueOf(bVar.h));
        contentValues.put("totaltime", Long.valueOf(bVar.k));
        contentValues.put("laucur", Integer.valueOf(bVar.i));
        contentValues.put("lauper", bVar.j);
        contentValues.put("timecur", Long.valueOf(bVar.m));
        contentValues.put("timeper", bVar.l);
        try {
            this.c.a().update("astatus", contentValues, "pn=?", new String[]{bVar.d});
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        if (z) {
            d();
        }
        this.e.sendBroadcast(new Intent("com.baidu.freqstatistic.summaryresults"));
    }

    public boolean a(String str, e eVar) {
        long j;
        if (str == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pn", str);
            contentValues.put("startstamp", Long.valueOf(eVar.b));
            contentValues.put("stopstamp", Long.valueOf(eVar.c));
            contentValues.put("loc", eVar.d);
            contentValues.put("startlevel", Integer.valueOf(eVar.e));
            contentValues.put("stoplevel", Integer.valueOf(eVar.f));
            contentValues.put("netype", Integer.valueOf(eVar.g));
            contentValues.put("flow", Long.valueOf(eVar.h));
            try {
                j = this.c.a().insert("atrace", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                j = -1;
            }
            return j > 0;
        } catch (NullPointerException e2) {
            try {
                this.c = new com.baidu.android.systemmonitor.a.a(this.e);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return true;
        } catch (Exception e4) {
            return false;
        }
    }

    public HashMap b() {
        Cursor cursor;
        Throwable th;
        Cursor rawQuery;
        Cursor cursor2 = null;
        HashMap hashMap = new HashMap();
        try {
            try {
                try {
                    rawQuery = this.c.b().rawQuery(new StringBuffer("select * from astatus").toString(), null);
                } catch (NullPointerException e) {
                    try {
                        this.c = new com.baidu.android.systemmonitor.a.a(this.e);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.deactivate();
                        cursor2.close();
                    }
                } catch (Exception e3) {
                    if (0 != 0 && !cursor2.isClosed()) {
                        cursor2.deactivate();
                        cursor2.close();
                    }
                }
                if (rawQuery == null || !rawQuery.moveToFirst()) {
                    if (rawQuery != null && !rawQuery.isClosed()) {
                        rawQuery.deactivate();
                        rawQuery.close();
                    }
                    return hashMap;
                }
                do {
                    b bVar = new b(rawQuery);
                    hashMap.put(bVar.c, bVar);
                } while (rawQuery.moveToNext());
                if (rawQuery != null) {
                    rawQuery.deactivate();
                    rawQuery.close();
                }
                return hashMap;
            } catch (Throwable th2) {
                cursor = null;
                th = th2;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
                cursor.deactivate();
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0107 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x0150 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0152 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0014 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v17, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context) {
        Throwable th;
        Exception e;
        NullPointerException e2;
        Cursor cursor = null;
        SystemClock.elapsedRealtime();
        int i = i();
        ArrayList arrayList = new ArrayList();
        ?? stringBuffer = new StringBuffer("select * from astatus");
        try {
            try {
                stringBuffer = this.c.a().rawQuery(stringBuffer.toString(), null);
                if (stringBuffer != 0) {
                    try {
                        if (stringBuffer.moveToFirst()) {
                            do {
                                b bVar = new b(stringBuffer);
                                String a2 = a(bVar.j, String.valueOf(bVar.i), i);
                                String a3 = a(bVar.l, String.valueOf(bVar.m), i);
                                bVar.i = 0;
                                bVar.j = a2;
                                bVar.h = d(a2);
                                bVar.m = 0L;
                                bVar.l = a3;
                                bVar.k = c(a3);
                                arrayList.add(bVar);
                            } while (stringBuffer.moveToNext());
                            stringBuffer.close();
                        }
                    } catch (SQLException e3) {
                        cursor = stringBuffer;
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.deactivate();
                                    cursor.close();
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        this.c.a().endTransaction();
                        return;
                    } catch (NullPointerException e5) {
                        e2 = e5;
                        try {
                            this.c = new com.baidu.android.systemmonitor.a.a(this.e);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        e2.printStackTrace();
                        if (stringBuffer != 0) {
                            try {
                                if (!stringBuffer.isClosed()) {
                                    stringBuffer.deactivate();
                                    stringBuffer.close();
                                }
                            } catch (Exception e7) {
                                e7.printStackTrace();
                                return;
                            }
                        }
                        this.c.a().endTransaction();
                        return;
                    } catch (Exception e8) {
                        e = e8;
                        e.printStackTrace();
                        if (stringBuffer != 0) {
                            try {
                                if (!stringBuffer.isClosed()) {
                                    stringBuffer.deactivate();
                                    stringBuffer.close();
                                }
                            } catch (Exception e9) {
                                e9.printStackTrace();
                                return;
                            }
                        }
                        this.c.a().endTransaction();
                        return;
                    }
                }
                SystemClock.elapsedRealtime();
                Iterator it = arrayList.iterator();
                try {
                    this.c.a().beginTransaction();
                    while (it.hasNext()) {
                        a((b) it.next());
                    }
                    this.c.a().setTransactionSuccessful();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (stringBuffer != 0) {
                    try {
                        if (!stringBuffer.isClosed()) {
                            stringBuffer.deactivate();
                            stringBuffer.close();
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        return;
                    }
                }
                this.c.a().endTransaction();
            } catch (Throwable th2) {
                th = th2;
                if (stringBuffer != 0) {
                    try {
                        if (!stringBuffer.isClosed()) {
                            stringBuffer.deactivate();
                            stringBuffer.close();
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
                this.c.a().endTransaction();
                throw th;
            }
        } catch (SQLException e13) {
        } catch (NullPointerException e14) {
            stringBuffer = 0;
            e2 = e14;
        } catch (Exception e15) {
            stringBuffer = 0;
            e = e15;
        } catch (Throwable th3) {
            stringBuffer = 0;
            th = th3;
            if (stringBuffer != 0) {
            }
            this.c.a().endTransaction();
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00aa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00ef */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.database.Cursor] */
    public void b(b bVar) {
        Throwable th;
        Cursor cursor = null;
        if (bVar == null) {
            return;
        }
        ?? r0 = bVar.d;
        try {
            if (r0 == 0) {
                return;
            }
            try {
                r0 = this.c.b().query("atrace", c.b, "pn=?", new String[]{bVar.d}, null, null, "startstamp DESC");
                try {
                    r0.moveToFirst();
                    while (!r0.isAfterLast()) {
                        e eVar = new e((Cursor) r0);
                        if (System.currentTimeMillis() - eVar.b > com.baidu.android.systemmonitor.d.a.k.a(this.e).d()) {
                            break;
                        }
                        eVar.b /= 1000;
                        eVar.c /= 1000;
                        bVar.n.add(new long[]{eVar.b, eVar.c});
                        bVar.r.add(new int[]{eVar.e, eVar.f});
                        bVar.q.add(eVar.d);
                        bVar.s.add(Integer.valueOf(eVar.g));
                        bVar.p.add(Long.valueOf(eVar.h));
                        r0.moveToNext();
                    }
                    if (r0 == 0 || r0.isClosed()) {
                        return;
                    }
                    r0.deactivate();
                    r0.close();
                } catch (NullPointerException e) {
                    try {
                        this.c = new com.baidu.android.systemmonitor.a.a(this.e);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (r0 == 0 || r0.isClosed()) {
                        return;
                    }
                    r0.deactivate();
                    r0.close();
                } catch (Exception e3) {
                    if (r0 == 0 || r0.isClosed()) {
                        return;
                    }
                    r0.deactivate();
                    r0.close();
                }
            } catch (NullPointerException e4) {
                r0 = 0;
            } catch (Exception e5) {
                r0 = 0;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            cursor = r0;
            th = th3;
        }
    }

    public boolean b(long j) {
        return System.currentTimeMillis() - j > com.baidu.android.systemmonitor.d.a.k.a(this.e).e();
    }

    public HashMap c() {
        System.currentTimeMillis();
        HashMap b = b();
        if (b == null) {
            return b;
        }
        for (b bVar : b.values()) {
            b(bVar);
        }
        for (com.baidu.android.systemmonitor.localapp.a aVar : com.baidu.android.systemmonitor.d.a.b(this.e)) {
            b bVar2 = (b) b.get(aVar.a());
            if (bVar2 == null) {
                bVar2 = new b(aVar.a(), false);
                b.put(aVar.a(), bVar2);
            }
            bVar2.b = aVar.a(this.e);
            bVar2.e = aVar.g ? 1 : 0;
            bVar2.f = aVar.b;
            bVar2.g = aVar.f;
            bVar2.o = aVar.i;
            bVar2.t = aVar.b(this.e);
            bVar2.u = aVar.c(this.e);
        }
        return b;
    }

    public boolean d() {
        try {
            this.c.a().delete("atrace", null, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean e() {
        return this.f644a;
    }

    public ArrayList f() {
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.c.b().query("achange", c.c, null, null, null, null, "time ASC");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                arrayList.add(new a(cursor));
                            } while (cursor.moveToNext());
                        }
                    } catch (NullPointerException e) {
                        try {
                            this.c = new com.baidu.android.systemmonitor.a.a(this.e);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.deactivate();
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Exception e3) {
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.deactivate();
                            cursor2.close();
                        }
                        return arrayList;
                    }
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                }
            } catch (Throwable th) {
                cursor2 = cursor;
                th = th;
                if (cursor2 != null && !cursor2.isClosed()) {
                    cursor2.deactivate();
                    cursor2.close();
                }
                throw th;
            }
        } catch (NullPointerException e4) {
            cursor = null;
        } catch (Exception e5) {
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.deactivate();
                cursor2.close();
            }
            throw th;
        }
        return arrayList;
    }

    public void g() {
        try {
            this.c.a().delete("achange", null, null);
        } catch (Exception e) {
        }
    }
}
