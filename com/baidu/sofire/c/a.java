package com.baidu.sofire.c;

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
import com.baidu.sofire.a.b;
import com.baidu.sofire.b.k;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.i1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a d;
    public transient /* synthetic */ FieldHolder $fh;
    public C0176a a;
    public SQLiteDatabase b;
    public Context c;

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0176a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0176a(a aVar, Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, aVar.getClass());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    this.a.getClass();
                    sQLiteDatabase.execSQL("create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)");
                } catch (Throwable unused) {
                    int i = b.a;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                if (i < 3 && i2 >= 3) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                            sQLiteDatabase.setTransactionSuccessful();
                        } catch (Throwable unused) {
                            int i3 = b.a;
                        }
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused2) {
                        int i4 = b.a;
                        return;
                    }
                }
                if (i < 5 && i2 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused3) {
                        int i5 = b.a;
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i < 4 && i2 >= 4) {
                    sQLiteDatabase.execSQL("drop table if exists tbch");
                }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context.getApplicationContext();
        C0176a c0176a = new C0176a(this, context.getApplicationContext());
        this.a = c0176a;
        try {
            this.b = c0176a.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.sofire.k.a.a(th);
        }
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
                aVar = d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8 A[Catch: all -> 0x0114, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0114, blocks: (B:42:0x00e8, B:45:0x0105), top: B:54:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(ApkInfo apkInfo) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apkInfo)) == null) {
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
            contentValues.put("cl", apkInfo.className);
            contentValues.put("st", Long.valueOf(apkInfo.startTime));
            contentValues.put("du", Integer.valueOf(apkInfo.duration));
            contentValues.put("m5", apkInfo.apkMD5);
            contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(apkInfo.priority));
            ActivityInfo[] activityInfoArr = apkInfo.activities;
            ObjectOutputStream objectOutputStream2 = null;
            if (activityInfoArr != null) {
                com.baidu.sofire.b.a aVar = new com.baidu.sofire.b.a(activityInfoArr);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    } catch (IOException unused) {
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException unused2) {
                    byteArrayOutputStream = null;
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
                try {
                    objectOutputStream.writeObject(aVar.a);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                        int i = b.a;
                        contentValues.put("ac", bArr);
                        if (!g(apkInfo.key)) {
                        }
                        return j;
                    }
                } catch (IOException unused4) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused5) {
                            bArr = null;
                            int i2 = b.a;
                            contentValues.put("ac", bArr);
                            if (!g(apkInfo.key)) {
                            }
                            return j;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    bArr = null;
                    contentValues.put("ac", bArr);
                    if (!g(apkInfo.key)) {
                    }
                    return j;
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream2 = objectOutputStream;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException unused6) {
                            int i3 = b.a;
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
                contentValues.put("ac", bArr);
            }
            try {
                if (!g(apkInfo.key)) {
                    j = this.b.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put("k", Integer.valueOf(apkInfo.key));
                    j = this.b.insert("pgn", null, contentValues);
                }
            } catch (Throwable unused7) {
            }
            return j;
        }
        return invokeL.longValue;
    }

    public void a() {
        List<Integer> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) b()).iterator();
                while (it.hasNext()) {
                    ApkInfo apkInfo = (ApkInfo) it.next();
                    if (!com.baidu.sofire.k.a.d(apkInfo.pkgPath) && (list = k.i) != null && !list.contains(Integer.valueOf(apkInfo.key))) {
                        arrayList.add(apkInfo);
                    }
                }
                k kVar = k.f;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ApkInfo apkInfo2 = (ApkInfo) it2.next();
                    if (kVar != null) {
                        kVar.d(apkInfo2.packageName);
                    }
                    SQLiteDatabase sQLiteDatabase = this.b;
                    sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, null);
                    com.baidu.sofire.k.a.c(this.c.getFilesDir().getCanonicalPath() + i1.j + apkInfo2.key);
                    Context context = this.c;
                    if (context != null) {
                        com.baidu.sofire.k.a.c(context.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    public List<ApkInfo> b() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    cursor = this.b.query("pgn", null, null, null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                ApkInfo apkInfo = new ApkInfo();
                                apkInfo.key = cursor.getInt(cursor.getColumnIndex("k"));
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
                                    int i = b.a;
                                    if (cursor != null) {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    }
                                    return arrayList;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            int i2 = b.a;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i3 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.delete("pgn", "k=" + i, null);
        } catch (Throwable unused) {
            int i2 = b.a;
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i2));
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i + " and n=1", null);
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) && i > 0 && !TextUtils.isEmpty(str)) {
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.delete("pgn", "k=" + i + " and v=?", new String[]{str});
            } catch (Throwable unused) {
                int i2 = b.a;
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.b.delete("pgn", "p=?", new String[]{str});
        } catch (Throwable unused) {
            int i = b.a;
        }
    }

    public int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.b;
                return sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pdld", Integer.valueOf(i2));
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(Config.PRINCIPAL_PART, Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }

    public ApkInfo b(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        ArrayList<com.baidu.sofire.b.b> a;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            ApkInfo apkInfo = null;
            try {
                try {
                    cursor = this.b.query("pgn", null, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                ApkInfo apkInfo2 = new ApkInfo();
                                try {
                                    apkInfo2.key = i;
                                    apkInfo2.initStatus = cursor.getInt(cursor.getColumnIndex("n"));
                                    apkInfo2.packageName = cursor.getString(cursor.getColumnIndex("p"));
                                    apkInfo2.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                                    apkInfo2.libPath = cursor.getString(cursor.getColumnIndex("l"));
                                    apkInfo2.versionName = cursor.getString(cursor.getColumnIndex("v"));
                                    apkInfo2.dexPath = cursor.getString(cursor.getColumnIndex("apk"));
                                    apkInfo2.apkParseSuc = cursor.getInt(cursor.getColumnIndex("ap"));
                                    apkInfo2.className = cursor.getString(cursor.getColumnIndex("cl"));
                                    apkInfo2.applicationTheme = cursor.getInt(cursor.getColumnIndex("th"));
                                    apkInfo2.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                                    apkInfo2.duration = cursor.getInt(cursor.getColumnIndex("du"));
                                    apkInfo2.apkMD5 = cursor.getString(cursor.getColumnIndex("m5"));
                                    apkInfo2.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                                    byte[] blob = cursor.getBlob(cursor.getColumnIndex("ac"));
                                    if (blob != null && (a = com.baidu.sofire.b.a.a(blob)) != null && (size = a.size()) > 0) {
                                        apkInfo2.activities = new ActivityInfo[size];
                                        for (int i2 = 0; i2 < size; i2++) {
                                            ActivityInfo activityInfo = new ActivityInfo();
                                            activityInfo.theme = a.get(i2).a;
                                            activityInfo.name = a.get(i2).j;
                                            activityInfo.configChanges = a.get(i2).h;
                                            activityInfo.flags = a.get(i2).f;
                                            activityInfo.labelRes = a.get(i2).l;
                                            activityInfo.launchMode = a.get(i2).b;
                                            activityInfo.nonLocalizedLabel = a.get(i2).m;
                                            activityInfo.packageName = a.get(i2).k;
                                            activityInfo.permission = a.get(i2).c;
                                            activityInfo.screenOrientation = a.get(i2).g;
                                            activityInfo.softInputMode = a.get(i2).i;
                                            activityInfo.targetActivity = a.get(i2).e;
                                            activityInfo.taskAffinity = a.get(i2).d;
                                            apkInfo2.activities[i2] = activityInfo;
                                        }
                                    }
                                    apkInfo = apkInfo2;
                                } catch (Throwable unused) {
                                    apkInfo = apkInfo2;
                                    try {
                                        int i3 = b.a;
                                        if (cursor != null) {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        }
                                        return apkInfo;
                                    } catch (Throwable th) {
                                        if (cursor != null) {
                                            try {
                                                if (!cursor.isClosed()) {
                                                    cursor.close();
                                                }
                                            } catch (Throwable unused2) {
                                                int i4 = b.a;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    int i5 = b.a;
                }
            } catch (Throwable unused5) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return apkInfo;
        }
        return (ApkInfo) invokeI.objValue;
    }

    public ApkInfo b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        ArrayList<com.baidu.sofire.b.b> a;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ApkInfo apkInfo = null;
            try {
            } catch (Throwable unused) {
                int i = b.a;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                cursor = this.b.query("pgn", null, "p=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ApkInfo apkInfo2 = new ApkInfo();
                            try {
                                apkInfo2.key = cursor.getInt(cursor.getColumnIndex("k"));
                                apkInfo2.initStatus = cursor.getInt(cursor.getColumnIndex("n"));
                                apkInfo2.packageName = cursor.getString(cursor.getColumnIndex("p"));
                                apkInfo2.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                                apkInfo2.libPath = cursor.getString(cursor.getColumnIndex("l"));
                                apkInfo2.versionName = cursor.getString(cursor.getColumnIndex("v"));
                                apkInfo2.dexPath = cursor.getString(cursor.getColumnIndex("apk"));
                                apkInfo2.apkParseSuc = cursor.getInt(cursor.getColumnIndex("ap"));
                                apkInfo2.className = cursor.getString(cursor.getColumnIndex("cl"));
                                apkInfo2.applicationTheme = cursor.getInt(cursor.getColumnIndex("th"));
                                apkInfo2.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                                apkInfo2.duration = cursor.getInt(cursor.getColumnIndex("du"));
                                apkInfo2.apkMD5 = cursor.getString(cursor.getColumnIndex("m5"));
                                apkInfo2.priority = cursor.getInt(cursor.getColumnIndex(Config.PRINCIPAL_PART));
                                byte[] blob = cursor.getBlob(cursor.getColumnIndex("ac"));
                                if (blob != null && (a = com.baidu.sofire.b.a.a(blob)) != null && (size = a.size()) > 0) {
                                    apkInfo2.activities = new ActivityInfo[size];
                                    for (int i2 = 0; i2 < size; i2++) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        activityInfo.theme = a.get(i2).a;
                                        activityInfo.name = a.get(i2).j;
                                        activityInfo.configChanges = a.get(i2).h;
                                        activityInfo.flags = a.get(i2).f;
                                        activityInfo.labelRes = a.get(i2).l;
                                        activityInfo.launchMode = a.get(i2).b;
                                        activityInfo.nonLocalizedLabel = a.get(i2).m;
                                        activityInfo.packageName = a.get(i2).k;
                                        activityInfo.permission = a.get(i2).c;
                                        activityInfo.screenOrientation = a.get(i2).g;
                                        activityInfo.softInputMode = a.get(i2).i;
                                        activityInfo.targetActivity = a.get(i2).e;
                                        activityInfo.taskAffinity = a.get(i2).d;
                                        apkInfo2.activities[i2] = activityInfo;
                                    }
                                }
                                apkInfo = apkInfo2;
                            } catch (Throwable unused2) {
                                apkInfo = apkInfo2;
                                try {
                                    int i3 = b.a;
                                    if (cursor != null) {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    }
                                    return apkInfo;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused3) {
                                            int i4 = b.a;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable unused4) {
                    }
                }
            } catch (Throwable unused5) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return apkInfo;
        }
        return (ApkInfo) invokeL.objValue;
    }

    public int c(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    cursor = sQLiteDatabase.query("pgn", new String[]{"pdld"}, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                i2 = cursor.getInt(cursor.getColumnIndex("pdld"));
                            }
                        } catch (Throwable unused) {
                            try {
                                int i3 = b.a;
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                return i2;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        int i4 = b.a;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i5 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public int d(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    cursor = sQLiteDatabase.query("pgn", new String[]{"n"}, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                i2 = cursor.getInt(cursor.getColumnIndex("n"));
                            }
                        } catch (Throwable unused) {
                            try {
                                int i3 = b.a;
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                return i2;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        int i4 = b.a;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i5 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            boolean z = false;
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    cursor = sQLiteDatabase.query("pgn", new String[]{"u"}, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(cursor.getColumnIndex("u")) == 1) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused) {
                            try {
                                int i2 = b.a;
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        int i3 = b.a;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i4 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            boolean z = false;
            try {
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    cursor = sQLiteDatabase.query("pgn", new String[]{"s"}, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused) {
                            try {
                                int i2 = b.a;
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        int i3 = b.a;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i4 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public boolean g(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            boolean z = false;
            try {
                try {
                    cursor = this.b.query("pgn", new String[]{"p"}, "k=" + i, null, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.getCount() > 0) {
                                z = true;
                            }
                        } catch (Throwable unused) {
                            try {
                                int i2 = b.a;
                                if (cursor != null) {
                                    if (!cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        int i3 = b.a;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i4 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public Map<Integer, String> c() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                try {
                    cursor = this.b.query("pgn", null, "n=1", null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                int i = cursor.getInt(cursor.getColumnIndex("k"));
                                String string = cursor.getString(cursor.getColumnIndex("v"));
                                Integer valueOf = Integer.valueOf(i);
                                hashMap.put(valueOf, "'" + string + "'");
                            } catch (Throwable unused) {
                                try {
                                    int i2 = b.a;
                                    if (cursor != null) {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    }
                                    return hashMap;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            int i3 = b.a;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i4 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<Integer, String> d() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                try {
                    cursor = this.b.query("pgn", null, "n=1", null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), cursor.getString(cursor.getColumnIndex("p")));
                            } catch (Throwable unused) {
                                try {
                                    int i = b.a;
                                    if (cursor != null) {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    }
                                    return hashMap;
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        try {
                                            if (!cursor.isClosed()) {
                                                cursor.close();
                                            }
                                        } catch (Throwable unused2) {
                                            int i2 = b.a;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    int i3 = b.a;
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            if (cursor != null) {
                if (!cursor.isClosed()) {
                    cursor.close();
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
