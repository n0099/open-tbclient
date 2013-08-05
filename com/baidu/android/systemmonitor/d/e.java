package com.baidu.android.systemmonitor.d;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.android.systemmonitor.a.a.o;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class e {
    private static volatile e d = null;
    private ExecutorService b;
    private com.baidu.android.systemmonitor.c.c c;
    private Context e = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f669a = false;

    private e(Context context) {
        this.b = null;
        try {
            this.c = new com.baidu.android.systemmonitor.c.c(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b = Executors.newSingleThreadExecutor();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            Context applicationContext = context.getApplicationContext();
            if (d == null) {
                d = new e(applicationContext);
            }
            d.e = applicationContext;
            eVar = d;
        }
        return eVar;
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
        synchronized (e.class) {
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
        if (com.baidu.android.systemmonitor.a.a.h() != -1) {
            return com.baidu.android.systemmonitor.a.a.h();
        }
        int c = com.baidu.android.systemmonitor.a.b.c(context);
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
        } else if (com.baidu.android.systemmonitor.a.d.a(context, "android.permission.SET_ACTIVITY_WATCHER") == 0) {
            com.baidu.android.systemmonitor.a.b.a(context, 2);
            return 2;
        } else {
            Method[] declaredMethods2 = b("android.app.IProcessObserver").getDeclaredMethods();
            if (declaredMethods2.length != 3) {
                com.baidu.android.systemmonitor.a.b.a(context, 2);
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
                                com.baidu.android.systemmonitor.a.b.a(context, 2);
                                return 2;
                            }
                            for (int i5 = 0; i5 < length2; i5++) {
                                if (!parameterTypes2[i5].toString().equals(strArr[i3][i5 + 1])) {
                                    com.baidu.android.systemmonitor.a.b.a(context, 2);
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
                com.baidu.android.systemmonitor.a.b.a(context, 1);
                return 1;
            }
            i = c;
        }
        com.baidu.android.systemmonitor.a.b.a(context, i);
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
        this.f669a = true;
        this.c.c();
        this.c = null;
    }

    private static int i() {
        int i = com.baidu.android.systemmonitor.a.a.i();
        if (i == 0) {
            return 30;
        }
        return i;
    }

    public m a(String str) {
        Cursor cursor;
        Cursor cursor2;
        m mVar;
        Cursor cursor3 = null;
        if (str == null) {
            return null;
        }
        try {
            cursor = this.c.b().query("astatus", b.f666a, "pn=?", new String[]{str}, null, null, "lautimes ASC");
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
                        this.c = new com.baidu.android.systemmonitor.c.c(this.e);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.deactivate();
                            cursor2.close();
                            mVar = null;
                            return mVar;
                        }
                        mVar = null;
                        return mVar;
                    }
                    if (cursor2 != null) {
                        cursor2.deactivate();
                        cursor2.close();
                        mVar = null;
                        return mVar;
                    }
                    mVar = null;
                    return mVar;
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
                    mVar = null;
                    return mVar;
                }
                mVar = null;
                return mVar;
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
                mVar = new m(cursor);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.deactivate();
                    cursor.close();
                }
                return mVar;
            }
        }
        mVar = null;
        if (cursor != null) {
            cursor.deactivate();
            cursor.close();
        }
        return mVar;
    }

    public void a(ContentResolver contentResolver, d dVar) {
        String str;
        String str2 = null;
        try {
            str = com.baidu.android.systemmonitor.security.a.a(dVar.f668a);
            try {
                str2 = com.baidu.android.systemmonitor.security.a.a(dVar.h);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            str = null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pn", str);
        contentValues.put("an", str2);
        contentValues.put("event", Integer.valueOf(dVar.c));
        contentValues.put("time", Long.valueOf(dVar.b));
        contentValues.put("vcode", Integer.valueOf(dVar.e));
        contentValues.put("vcodeaft", Integer.valueOf(dVar.g));
        contentValues.put("vn", dVar.d);
        contentValues.put("vnaft", dVar.f);
        try {
            this.c.a().insert("achange", null, contentValues);
        } catch (NullPointerException e3) {
            try {
                this.c = new com.baidu.android.systemmonitor.c.c(this.e);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
        }
    }

    public void a(ContentResolver contentResolver, m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pn", mVar.d);
        contentValues.put("lautimes", Integer.valueOf(mVar.h));
        contentValues.put("totaltime", Long.valueOf(mVar.k));
        contentValues.put("lauper", mVar.j);
        contentValues.put("laucur", Integer.valueOf(mVar.i));
        contentValues.put("timeper", mVar.l);
        contentValues.put("timecur", Long.valueOf(mVar.m));
        try {
            this.c.a().insert("astatus", null, contentValues);
        } catch (NullPointerException e) {
            try {
                this.c = new com.baidu.android.systemmonitor.c.c(this.e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
        }
    }

    public void a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lautimes", Integer.valueOf(mVar.h));
        contentValues.put("totaltime", Long.valueOf(mVar.k));
        contentValues.put("laucur", Integer.valueOf(mVar.i));
        contentValues.put("lauper", mVar.j);
        contentValues.put("timecur", Long.valueOf(mVar.m));
        contentValues.put("timeper", mVar.l);
        try {
            this.c.a().update("astatus", contentValues, "pn=?", new String[]{mVar.d});
        } catch (Exception e) {
        }
    }

    public void a(boolean z) {
        if (z) {
            d();
        }
        this.e.sendBroadcast(new Intent("com.baidu.freqstatistic.summaryresults"));
    }

    public boolean a(String str, n nVar) {
        long j;
        if (str == null) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pn", str);
            contentValues.put("startstamp", Long.valueOf(nVar.b));
            contentValues.put("stopstamp", Long.valueOf(nVar.c));
            contentValues.put("loc", nVar.d);
            contentValues.put("startlevel", Integer.valueOf(nVar.e));
            contentValues.put("stoplevel", Integer.valueOf(nVar.f));
            contentValues.put("netype", Integer.valueOf(nVar.g));
            contentValues.put("flow", Long.valueOf(nVar.h));
            try {
                j = this.c.a().insert("atrace", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                j = -1;
            }
            return j > 0;
        } catch (NullPointerException e2) {
            try {
                this.c = new com.baidu.android.systemmonitor.c.c(this.e);
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
                        this.c = new com.baidu.android.systemmonitor.c.c(this.e);
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
                    m mVar = new m(rawQuery);
                    hashMap.put(mVar.c, mVar);
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
                                m mVar = new m(stringBuffer);
                                String a2 = a(mVar.j, String.valueOf(mVar.i), i);
                                String a3 = a(mVar.l, String.valueOf(mVar.m), i);
                                mVar.i = 0;
                                mVar.j = a2;
                                mVar.h = d(a2);
                                mVar.m = 0L;
                                mVar.l = a3;
                                mVar.k = c(a3);
                                arrayList.add(mVar);
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
                            this.c = new com.baidu.android.systemmonitor.c.c(this.e);
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
                        a((m) it.next());
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
    public void b(m mVar) {
        Throwable th;
        Cursor cursor = null;
        if (mVar == null) {
            return;
        }
        ?? r0 = mVar.d;
        try {
            if (r0 == 0) {
                return;
            }
            try {
                r0 = this.c.b().query("atrace", b.b, "pn=?", new String[]{mVar.d}, null, null, "startstamp DESC");
                try {
                    r0.moveToFirst();
                    while (!r0.isAfterLast()) {
                        n nVar = new n((Cursor) r0);
                        if (System.currentTimeMillis() - nVar.b > o.a(this.e).d()) {
                            break;
                        }
                        nVar.b /= 1000;
                        nVar.c /= 1000;
                        mVar.n.add(new long[]{nVar.b, nVar.c});
                        mVar.r.add(new int[]{nVar.e, nVar.f});
                        mVar.q.add(nVar.d);
                        mVar.s.add(Integer.valueOf(nVar.g));
                        mVar.p.add(Long.valueOf(nVar.h));
                        r0.moveToNext();
                    }
                    if (r0 == 0 || r0.isClosed()) {
                        return;
                    }
                    r0.deactivate();
                    r0.close();
                } catch (NullPointerException e) {
                    try {
                        this.c = new com.baidu.android.systemmonitor.c.c(this.e);
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
        return System.currentTimeMillis() - j > o.a(this.e).e();
    }

    public HashMap c() {
        System.currentTimeMillis();
        HashMap b = b();
        if (b == null) {
            return b;
        }
        for (m mVar : b.values()) {
            b(mVar);
        }
        for (com.baidu.android.systemmonitor.localapp.a aVar : com.baidu.android.systemmonitor.a.c.b(this.e)) {
            m mVar2 = (m) b.get(aVar.a());
            if (mVar2 == null) {
                mVar2 = new m(aVar.a(), false);
                b.put(aVar.a(), mVar2);
            }
            mVar2.b = aVar.a(this.e);
            mVar2.e = aVar.g ? 1 : 0;
            mVar2.f = aVar.b;
            mVar2.g = aVar.f;
            mVar2.o = aVar.i;
            mVar2.t = aVar.b(this.e);
            mVar2.u = aVar.c(this.e);
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
        return this.f669a;
    }

    public ArrayList f() {
        Cursor cursor;
        Cursor cursor2 = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = this.c.b().query("achange", b.c, null, null, null, null, "time ASC");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                arrayList.add(new d(cursor));
                            } while (cursor.moveToNext());
                        }
                    } catch (NullPointerException e) {
                        try {
                            this.c = new com.baidu.android.systemmonitor.c.c(this.e);
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
