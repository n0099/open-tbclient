package com.baidu.sofire.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.a.b;
import com.baidu.sofire.b.i;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.baidu.sofire.k.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.bi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@SuppressLint({"Range"})
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a d;
    public transient /* synthetic */ FieldHolder $fh;
    public C0177a a;
    public SQLiteDatabase b;
    public Context c;

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0177a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0177a(a aVar, Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.a(aVar));
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
                    sQLiteDatabase.execSQL("create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,pe TEXT,a TEXT)");
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
                if (i < 4 && i2 >= 4) {
                    sQLiteDatabase.execSQL("drop table if exists tbch");
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
                if (i < 6 && i2 >= 6) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pe TEXT");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused4) {
                        int i6 = b.a;
                    }
                    sQLiteDatabase.endTransaction();
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
        C0177a c0177a = new C0177a(this, context.getApplicationContext());
        this.a = c0177a;
        try {
            this.b = c0177a.getWritableDatabase();
        } catch (Throwable th) {
            com.baidu.sofire.k.b.a(th);
        }
    }

    public static /* synthetic */ int a(a aVar) {
        aVar.getClass();
        return 6;
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

    public long a(ApkInfo apkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, apkInfo)) == null) {
            String str = "";
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
            contentValues.put("pr", Integer.valueOf(apkInfo.priority));
            String str2 = apkInfo.es;
            Asc asc = f.a;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    str = Base64.encodeToString(f.b(f.a(24), str2.getBytes("UTF-8"), true), 10);
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
            contentValues.put("pe", str);
            try {
                if (f(apkInfo.key)) {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    return sQLiteDatabase.update("pgn", contentValues, "k=" + apkInfo.key, null);
                }
                contentValues.put("k", Integer.valueOf(apkInfo.key));
                return this.b.insert("pgn", null, contentValues);
            } catch (Throwable unused2) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public ApkInfo b(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
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
                                    apkInfo2.priority = cursor.getInt(cursor.getColumnIndex("pr"));
                                    apkInfo2.es = f.a(cursor.getString(cursor.getColumnIndex("pe")), 24);
                                    apkInfo = apkInfo2;
                                } catch (Throwable unused) {
                                    apkInfo = apkInfo2;
                                    try {
                                        int i2 = b.a;
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
                                                int i3 = b.a;
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
                    int i4 = b.a;
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

    public void a() {
        List<Integer> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) b()).iterator();
                while (it.hasNext()) {
                    ApkInfo apkInfo = (ApkInfo) it.next();
                    if (!com.baidu.sofire.k.b.e(apkInfo.pkgPath) && (list = i.j) != null && !list.contains(Integer.valueOf(apkInfo.key))) {
                        arrayList.add(apkInfo);
                    }
                }
                i iVar = i.g;
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ApkInfo apkInfo2 = (ApkInfo) it2.next();
                    if (iVar != null) {
                        iVar.d(apkInfo2.packageName);
                    }
                    File parentFile = new File(apkInfo2.pkgPath).getParentFile();
                    if (parentFile.exists()) {
                        com.baidu.sofire.k.b.d(parentFile.getAbsolutePath());
                    }
                    SQLiteDatabase sQLiteDatabase = this.b;
                    sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, null);
                    String canonicalPath = new File(this.c.getFilesDir(), "sofire_tmp").getCanonicalPath();
                    com.baidu.sofire.k.b.d(canonicalPath + bi.j + apkInfo2.key);
                    Context context = this.c;
                    if (context != null) {
                        com.baidu.sofire.k.b.d(context.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                try {
                    cursor = this.b.query("pgn", null, null, null, null, null, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                ApkInfo apkInfo = new ApkInfo();
                                apkInfo.key = cursor.getInt(cursor.getColumnIndex("k"));
                                apkInfo.initStatus = cursor.getInt(cursor.getColumnIndex("n"));
                                apkInfo.packageName = cursor.getString(cursor.getColumnIndex("p"));
                                apkInfo.pkgPath = cursor.getString(cursor.getColumnIndex("a"));
                                apkInfo.libPath = cursor.getString(cursor.getColumnIndex("l"));
                                apkInfo.versionName = cursor.getString(cursor.getColumnIndex("v"));
                                apkInfo.dexPath = cursor.getString(cursor.getColumnIndex("apk"));
                                apkInfo.apkParseSuc = cursor.getInt(cursor.getColumnIndex("ap"));
                                apkInfo.className = cursor.getString(cursor.getColumnIndex("cl"));
                                apkInfo.applicationTheme = cursor.getInt(cursor.getColumnIndex("th"));
                                apkInfo.startTime = cursor.getLong(cursor.getColumnIndex("st"));
                                apkInfo.duration = cursor.getInt(cursor.getColumnIndex("du"));
                                apkInfo.apkMD5 = cursor.getString(cursor.getColumnIndex("m5"));
                                apkInfo.priority = cursor.getInt(cursor.getColumnIndex("pr"));
                                apkInfo.es = f.a(cursor.getString(cursor.getColumnIndex("pe")), 24);
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.b.delete("pgn", "p=?", new String[]{str});
        } catch (Throwable unused) {
            int i = b.a;
        }
    }

    public ApkInfo b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
                                apkInfo2.priority = cursor.getInt(cursor.getColumnIndex("pr"));
                                apkInfo2.es = f.a(cursor.getString(cursor.getColumnIndex("pe")), 24);
                                apkInfo = apkInfo2;
                            } catch (Throwable unused2) {
                                apkInfo = apkInfo2;
                                try {
                                    int i2 = b.a;
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
                                            int i3 = b.a;
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

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
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

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
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

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pr", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                int i3 = b.a;
            }
        }
    }

    public int c(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
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

    public boolean f(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
