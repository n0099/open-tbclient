package com.baidu.sofire.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.b;
import com.baidu.sofire.core.f;
import com.baidu.sofire.utility.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f10282d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10283a;

    /* renamed from: b  reason: collision with root package name */
    public String f10284b;

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f10285c;

    /* renamed from: e  reason: collision with root package name */
    public C0158a f10286e;

    /* renamed from: f  reason: collision with root package name */
    public Context f10287f;

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0158a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f10288a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0158a(a aVar, Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, aVar.f10283a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10288a = aVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.f10288a.f10284b);
                } catch (Throwable unused) {
                    c.a();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                if (i2 < 3 && i3 >= 3) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable unused) {
                            c.a();
                        }
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused2) {
                        c.a();
                        return;
                    }
                }
                if (i2 < 5 && i3 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused3) {
                        c.a();
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i2 >= 4 || i3 < 4) {
                    return;
                }
                sQLiteDatabase.execSQL("drop table if exists tbch");
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10283a = 5;
        this.f10284b = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
        this.f10287f = context.getApplicationContext();
        C0158a c0158a = new C0158a(this, context.getApplicationContext());
        this.f10286e = c0158a;
        try {
            this.f10285c = c0158a.getWritableDatabase();
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (f10282d == null) {
                    f10282d = new a(context);
                }
                aVar = f10282d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
        if (r2.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r2.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, String> b() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                try {
                    cursor = this.f10285c.query("pgn", null, "n=1", null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                int i2 = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                                String string = cursor.getString(cursor.getColumnIndex("v"));
                                Integer valueOf = Integer.valueOf(i2);
                                hashMap.put(valueOf, "'" + string + "'");
                            } catch (Throwable unused) {
                                try {
                                    c.a();
                                    if (cursor != null) {
                                    }
                                    return hashMap;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            c.a();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, String> c() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                try {
                    cursor = this.f10285c.query("pgn", null, "n=1", null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex(Config.APP_KEY))), cursor.getString(cursor.getColumnIndex("p")));
                            } catch (Throwable unused) {
                                try {
                                    c.a();
                                    if (cursor != null) {
                                    }
                                    return hashMap;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            c.a();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                ArrayList<ApkInfo> arrayList = new ArrayList();
                for (ApkInfo apkInfo : a()) {
                    if (!c.c(apkInfo.pkgPath) && f.f10390b != null && !f.f10390b.contains(Integer.valueOf(apkInfo.key))) {
                        arrayList.add(apkInfo);
                    }
                }
                f a2 = f.a();
                for (ApkInfo apkInfo2 : arrayList) {
                    if (a2 != null) {
                        a2.b(apkInfo2.packageName);
                    }
                    SQLiteDatabase sQLiteDatabase = this.f10285c;
                    sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, null);
                    c.d(this.f10287f.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                    if (this.f10287f != null) {
                        c.d(this.f10287f.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean e(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            boolean z = false;
            try {
                try {
                    cursor = this.f10285c.query("pgn", new String[]{"s"}, "k=" + i2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused) {
                            try {
                                c.a();
                                if (cursor != null) {
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public final void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", (Integer) (-1));
                SQLiteDatabase sQLiteDatabase = this.f10285c;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            int i3 = 0;
            try {
                try {
                    cursor = this.f10285c.query("pgn", new String[]{"pdld"}, "k=" + i2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                i3 = cursor.getInt(cursor.getColumnIndex("pdld"));
                            }
                        } catch (Throwable unused) {
                            try {
                                c.a();
                                if (cursor != null) {
                                }
                                return i3;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.f10285c;
            sQLiteDatabase.delete("pgn", "k=" + i2, null);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public final long a(ApkInfo apkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, apkInfo)) == null) {
            long j = 0;
            if (apkInfo == null) {
                return 0L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(apkInfo.initStatus));
            contentValues.put("p", apkInfo.packageName);
            contentValues.put("a", apkInfo.pkgPath);
            contentValues.put("l", apkInfo.libPath);
            contentValues.put("v", apkInfo.versionName);
            contentValues.put("apk", apkInfo.dexPath);
            contentValues.put("ap", Integer.valueOf(apkInfo.apkParseSuc));
            contentValues.put(Config.CELL_LOCATION, apkInfo.className);
            contentValues.put("st", Long.valueOf(apkInfo.startTime));
            contentValues.put("du", Integer.valueOf(apkInfo.duration));
            contentValues.put("m5", apkInfo.apkMD5);
            contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(apkInfo.priority));
            ActivityInfo[] activityInfoArr = apkInfo.activities;
            if (activityInfoArr != null) {
                contentValues.put("ac", new com.baidu.sofire.core.a(activityInfoArr).a());
            }
            try {
                if (b(apkInfo.key)) {
                    j = this.f10285c.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put(Config.APP_KEY, Integer.valueOf(apkInfo.key));
                    j = this.f10285c.insert("pgn", null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j;
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            boolean z = false;
            try {
                try {
                    cursor = this.f10285c.query("pgn", new String[]{"p"}, "k=" + i2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                z = true;
                            }
                        } catch (Throwable unused) {
                            try {
                                c.a();
                                if (cursor != null) {
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            int i3 = 0;
            try {
                try {
                    cursor = this.f10285c.query("pgn", new String[]{"n"}, "k=" + i2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                i3 = cursor.getInt(cursor.getColumnIndex("n"));
                            }
                        } catch (Throwable unused) {
                            try {
                                c.a();
                                if (cursor != null) {
                                }
                                return i3;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            boolean z = false;
            try {
                try {
                    cursor = this.f10285c.query("pgn", new String[]{"u"}, "k=" + i2, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(cursor.getColumnIndex("u")) == 1) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused) {
                            try {
                                c.a();
                                if (cursor != null) {
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0090, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009d, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ApkInfo> a() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    cursor = this.f10285c.query("pgn", null, null, null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                ApkInfo apkInfo = new ApkInfo();
                                apkInfo.key = cursor.getInt(cursor.getColumnIndex(Config.APP_KEY));
                                apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                                apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                                apkInfo.libPath = cursor.getString(cursor.getColumnIndex("l"));
                                apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                                apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                                apkInfo.duration = cursor.getInt(cursor.getColumnIndex("du"));
                                apkInfo.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                                arrayList.add(apkInfo);
                            } catch (Throwable unused) {
                                try {
                                    c.a();
                                    if (cursor != null) {
                                    }
                                    return arrayList;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            c.a();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    if (cursor != null) {
                    }
                } catch (Throwable unused3) {
                    c.a();
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pdld", Integer.valueOf(i3));
            try {
                SQLiteDatabase sQLiteDatabase = this.f10285c;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.f10285c;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public final ApkInfo b(String str) {
        InterceptResult invokeL;
        ApkInfo apkInfo;
        ArrayList<b> a2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, str)) != null) {
            return (ApkInfo) invokeL.objValue;
        }
        Cursor cursor = null;
        r1 = null;
        ApkInfo apkInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.f10285c.query("pgn", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = query.getInt(query.getColumnIndex(Config.APP_KEY));
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex(Config.CELL_LOCATION));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex(Config.PRINCIPAL_PART));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a2.get(i2).f10340a;
                                    activityInfo.name = a2.get(i2).j;
                                    activityInfo.configChanges = a2.get(i2).f10347h;
                                    activityInfo.flags = a2.get(i2).f10345f;
                                    activityInfo.labelRes = a2.get(i2).l;
                                    activityInfo.launchMode = a2.get(i2).f10341b;
                                    activityInfo.nonLocalizedLabel = a2.get(i2).m;
                                    activityInfo.packageName = a2.get(i2).k;
                                    activityInfo.permission = a2.get(i2).f10342c;
                                    activityInfo.screenOrientation = a2.get(i2).f10346g;
                                    activityInfo.softInputMode = a2.get(i2).f10348i;
                                    activityInfo.targetActivity = a2.get(i2).f10344e;
                                    activityInfo.taskAffinity = a2.get(i2).f10343d;
                                    apkInfo.activities[i2] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                c.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    c.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final ApkInfo a(int i2) {
        InterceptResult invokeI;
        ApkInfo apkInfo;
        ArrayList<b> a2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) != null) {
            return (ApkInfo) invokeI.objValue;
        }
        Cursor cursor = null;
        r0 = null;
        ApkInfo apkInfo2 = null;
        try {
            Cursor query = this.f10285c.query("pgn", null, "k=" + i2, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = i2;
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex(Config.CELL_LOCATION));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex(Config.PRINCIPAL_PART));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a2 = com.baidu.sofire.core.a.a(blob)) != null && (size = a2.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i3 = 0; i3 < size; i3++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a2.get(i3).f10340a;
                                    activityInfo.name = a2.get(i3).j;
                                    activityInfo.configChanges = a2.get(i3).f10347h;
                                    activityInfo.flags = a2.get(i3).f10345f;
                                    activityInfo.labelRes = a2.get(i3).l;
                                    activityInfo.launchMode = a2.get(i3).f10341b;
                                    activityInfo.nonLocalizedLabel = a2.get(i3).m;
                                    activityInfo.packageName = a2.get(i3).k;
                                    activityInfo.permission = a2.get(i3).f10342c;
                                    activityInfo.screenOrientation = a2.get(i3).f10346g;
                                    activityInfo.softInputMode = a2.get(i3).f10348i;
                                    activityInfo.targetActivity = a2.get(i3).f10344e;
                                    activityInfo.taskAffinity = a2.get(i3).f10343d;
                                    apkInfo.activities[i3] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                c.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        c.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    c.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f10285c.delete("pgn", "p=?", new String[]{str});
        } catch (Throwable unused) {
            c.a();
        }
    }

    public final int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.f10285c;
                return sQLiteDatabase.update("pgn", contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    public final void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || i2 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.f10285c;
            sQLiteDatabase.delete("pgn", "k=" + i2 + " and v=?", new String[]{str});
        } catch (Throwable unused) {
            c.a();
        }
    }
}
