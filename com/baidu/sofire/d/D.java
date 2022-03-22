package com.baidu.sofire.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ActivityInfoArray;
import com.baidu.sofire.core.ActivityInfoData;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class D {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COLUMN_PLUGIN_ACTIVITY_INFO_LIST = "ac";
    public static final String COLUMN_PLUGIN_APK_PARSE = "ap";
    public static final String COLUMN_PLUGIN_APK_PATH = "a";
    public static final String COLUMN_PLUGIN_BOOT_COMPLETE_HANDLE_CLS = "b";
    public static final String COLUMN_PLUGIN_BOOT_COMPLETE_HANDLE_METHOD = "t";
    public static final String COLUMN_PLUGIN_INIT_STATUS = "n";
    public static final String COLUMN_PLUGIN_IS_BUSY = "s";
    public static final String COLUMN_PLUGIN_IS_REGISTER_BOOT_COMPLETE = "r";
    public static final String COLUMN_PLUGIN_IS_UPDATING = "u";
    public static final String COLUMN_PLUGIN_KEY = "k";
    public static final String COLUMN_PLUGIN_LIB_ID = "i";
    public static final String COLUMN_PLUGIN_LIB_PATH = "l";
    public static final String COLUMN_PLUGIN_LOCAL_APK_COPYED = "o";
    public static final String COLUMN_PLUGIN_PACKAGE = "p";
    public static final String COLUMN_PLUGIN_PLUGIN_NOT_EXIST_LAST_POINT = "la";
    public static final String COLUMN_PLUGIN_VERSION = "v";
    public static final String COLUMU_PLUGIN_APPLICATION_THEME = "th";
    public static final String COLUMU_PLUGIN_CLASS_NAME = "cl";
    public static final String COLUMU_PLUGIN_DELETED = "pdld";
    public static final String COLUMU_PLUGIN_DEX_PATH = "apk";
    public static final String COLUMU_PLUGIN_DOWNLOAD_MD5 = "m5";
    public static final String COLUMU_PLUGIN_DURATION = "du";
    public static final String COLUMU_PLUGIN_PRIORITY = "pr";
    public static final String COLUMU_PLUGIN_RUN_STATUS = "rs";
    public static final String COLUMU_PLUGIN_START_TIME = "st";
    public static D instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String createPluginTable;
    public Context mContext;
    public DatabaseHelper mDatabaseHelper;
    public SQLiteDatabase mDb;
    public int version;

    /* loaded from: classes4.dex */
    public class DatabaseHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ D this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DatabaseHelper(D d2, Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, d2.version);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2, context};
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
            this.this$0 = d2;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.this$0.createPluginTable);
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
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
                        sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable th) {
                        CommonMethods.handleNuLException(th);
                        return;
                    }
                }
                if (i < 5 && i2 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                }
                if (i >= 4 || i2 < 4) {
                    return;
                }
                sQLiteDatabase.execSQL("drop table if exists tbch");
            }
        }
    }

    public D(Context context) {
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
        this.version = 5;
        this.createPluginTable = "create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";
        this.mContext = context.getApplicationContext();
        DatabaseHelper databaseHelper = new DatabaseHelper(this, context.getApplicationContext());
        this.mDatabaseHelper = databaseHelper;
        try {
            this.mDb = databaseHelper.getWritableDatabase();
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public static synchronized D getInstance(Context context) {
        InterceptResult invokeL;
        D d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (D.class) {
                if (instance == null) {
                    instance = new D(context);
                }
                d2 = instance;
            }
            return d2;
        }
        return (D) invokeL.objValue;
    }

    public static D peekInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? instance : (D) invokeV.objValue;
    }

    public void changePluginBusyStatus(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i2));
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i + " and n=1", null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void changePluginBusyStatusByPkg(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i));
            try {
                this.mDb.update("pgn", contentValues, "p=? and n=1", new String[]{str});
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public int changePluginUpdatingStatus(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.mDb;
                return sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    public void deleteLoadedPluginByPackage(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.mDb.delete("pgn", "p=?", new String[]{str});
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void deletePluginById(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || i <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            sQLiteDatabase.delete("pgn", "k=" + i, null);
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void deletePluginByIdVersion(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) || i <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            sQLiteDatabase.delete("pgn", "k=" + i + " and v=?", new String[]{str});
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public void deletePluginIfAPKNotExist() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                ArrayList<ApkInfo> arrayList = new ArrayList();
                for (ApkInfo apkInfo : getAllPlugins()) {
                    if (!CommonMethods.isFileExist(apkInfo.pkgPath) && PluginloaderHub.sMemRunning != null && !PluginloaderHub.sMemRunning.contains(Integer.valueOf(apkInfo.key))) {
                        arrayList.add(apkInfo);
                    }
                }
                PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                for (ApkInfo apkInfo2 : arrayList) {
                    if (peekInstance != null) {
                        peekInstance.unloadApkByPack(apkInfo2.packageName);
                    }
                    SQLiteDatabase sQLiteDatabase = this.mDb;
                    sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, null);
                    CommonMethods.deleteDir(this.mContext.getFilesDir().getCanonicalPath() + "/." + apkInfo2.key);
                    if (this.mContext != null) {
                        CommonMethods.deleteDir(this.mContext.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public List<ApkInfo> getAllPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = this.mDb.query("pgn", null, null, null, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.key = query.getInt(query.getColumnIndex("k"));
                        apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                        apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                        apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                        apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                        apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                        apkInfo.duration = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_DURATION));
                        apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                        arrayList.add(apkInfo);
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public Map<Integer, String> getInitSuceedPluginKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                Cursor query = this.mDb.query("pgn", null, "n=1", null, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        int i = query.getInt(query.getColumnIndex("k"));
                        String string = query.getString(query.getColumnIndex("v"));
                        Integer valueOf = Integer.valueOf(i);
                        hashMap.put(valueOf, "'" + string + "'");
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<Integer, String> getInitSuceedPluginPkgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HashMap hashMap = new HashMap();
            try {
                Cursor query = this.mDb.query("pgn", null, "n=1", null, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        hashMap.put(Integer.valueOf(query.getInt(query.getColumnIndex("k"))), query.getString(query.getColumnIndex("p")));
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public List<ApkInfo> getInitSuceedPlugins() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = this.mDb.query("pgn", null, "n=1", null, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        ApkInfo apkInfo = new ApkInfo();
                        apkInfo.key = query.getInt(query.getColumnIndex("k"));
                        apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                        apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                        apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                        apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                        arrayList.add(apkInfo);
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public ApkInfo getPluginByID(int i) {
        InterceptResult invokeI;
        ApkInfo apkInfo;
        ArrayList<ActivityInfoData> deserialize;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048587, this, i)) != null) {
            return (ApkInfo) invokeI.objValue;
        }
        Cursor cursor = null;
        r0 = null;
        ApkInfo apkInfo2 = null;
        try {
            Cursor query = this.mDb.query("pgn", null, "k=" + i, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = i;
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex(COLUMU_PLUGIN_DEX_PATH));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex(COLUMN_PLUGIN_APK_PARSE));
                            apkInfo.className = query.getString(query.getColumnIndex("cl"));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_APPLICATION_THEME));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_DURATION));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex(COLUMU_PLUGIN_DOWNLOAD_MD5));
                            apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                            byte[] blob = query.getBlob(query.getColumnIndex(COLUMN_PLUGIN_ACTIVITY_INFO_LIST));
                            if (blob != null && (deserialize = ActivityInfoArray.deserialize(blob)) != null && (size = deserialize.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = deserialize.get(i2).theme;
                                    activityInfo.name = deserialize.get(i2).name;
                                    activityInfo.configChanges = deserialize.get(i2).configChanges;
                                    activityInfo.flags = deserialize.get(i2).flags;
                                    activityInfo.labelRes = deserialize.get(i2).labelRes;
                                    activityInfo.launchMode = deserialize.get(i2).launchMode;
                                    activityInfo.nonLocalizedLabel = deserialize.get(i2).nonLocalizedLabel;
                                    activityInfo.packageName = deserialize.get(i2).packageName;
                                    activityInfo.permission = deserialize.get(i2).permission;
                                    activityInfo.screenOrientation = deserialize.get(i2).screenOrientation;
                                    activityInfo.softInputMode = deserialize.get(i2).softInputMode;
                                    activityInfo.targetActivity = deserialize.get(i2).targetActivity;
                                    activityInfo.taskAffinity = deserialize.get(i2).taskAffinity;
                                    apkInfo.activities[i2] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            try {
                                CommonMethods.handleNuLException(th);
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable th2) {
                                        CommonMethods.handleNuLException(th2);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
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
                } catch (Throwable th4) {
                    CommonMethods.handleNuLException(th4);
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable th5) {
            th = th5;
            apkInfo = null;
        }
    }

    public ApkInfo getPluginByPkg(String str) {
        InterceptResult invokeL;
        ApkInfo apkInfo;
        ArrayList<ActivityInfoData> deserialize;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048588, this, str)) != null) {
            return (ApkInfo) invokeL.objValue;
        }
        Cursor cursor = null;
        r1 = null;
        ApkInfo apkInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.mDb.query("pgn", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = query.getInt(query.getColumnIndex("k"));
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex(COLUMU_PLUGIN_DEX_PATH));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex(COLUMN_PLUGIN_APK_PARSE));
                            apkInfo.className = query.getString(query.getColumnIndex("cl"));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_APPLICATION_THEME));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_DURATION));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex(COLUMU_PLUGIN_DOWNLOAD_MD5));
                            apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                            byte[] blob = query.getBlob(query.getColumnIndex(COLUMN_PLUGIN_ACTIVITY_INFO_LIST));
                            if (blob != null && (deserialize = ActivityInfoArray.deserialize(blob)) != null && (size = deserialize.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i = 0; i < size; i++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = deserialize.get(i).theme;
                                    activityInfo.name = deserialize.get(i).name;
                                    activityInfo.configChanges = deserialize.get(i).configChanges;
                                    activityInfo.flags = deserialize.get(i).flags;
                                    activityInfo.labelRes = deserialize.get(i).labelRes;
                                    activityInfo.launchMode = deserialize.get(i).launchMode;
                                    activityInfo.nonLocalizedLabel = deserialize.get(i).nonLocalizedLabel;
                                    activityInfo.packageName = deserialize.get(i).packageName;
                                    activityInfo.permission = deserialize.get(i).permission;
                                    activityInfo.screenOrientation = deserialize.get(i).screenOrientation;
                                    activityInfo.softInputMode = deserialize.get(i).softInputMode;
                                    activityInfo.targetActivity = deserialize.get(i).targetActivity;
                                    activityInfo.taskAffinity = deserialize.get(i).taskAffinity;
                                    apkInfo.activities[i] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            try {
                                CommonMethods.handleNuLException(th);
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable th2) {
                                        CommonMethods.handleNuLException(th2);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
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
                } catch (Throwable th4) {
                    CommonMethods.handleNuLException(th4);
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable th5) {
            th = th5;
            apkInfo = null;
        }
    }

    public int getPluginDeleteStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            int i2 = 0;
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                String[] strArr = {COLUMU_PLUGIN_DELETED};
                Cursor query = sQLiteDatabase.query("pgn", strArr, "k=" + i, null, null, null, null);
                if (query != null && query.moveToFirst()) {
                    i2 = query.getInt(query.getColumnIndex(COLUMU_PLUGIN_DELETED));
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public int getPluginInitStatusByPluginKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = 0;
            try {
                Cursor query = this.mDb.query("pgn", new String[]{"n"}, "k=" + i, null, null, null, null);
                if (query != null && query.moveToFirst()) {
                    i2 = query.getInt(query.getColumnIndex("n"));
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public String[] getPluinBootReceiverHandle(String str) {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048591, this, str)) != null) {
            return (String[]) invokeL.objValue;
        }
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        String[] strArr2 = null;
        try {
            Cursor query = this.mDb.query("pgn", new String[]{"r", "b", "t"}, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        boolean z = query.getInt(query.getColumnIndex("r")) == 1;
                        String string = query.getString(query.getColumnIndex("b"));
                        String string2 = query.getString(query.getColumnIndex("t"));
                        if (z && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            strArr2 = new String[]{string, string2};
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    strArr = strArr2;
                    cursor = query;
                    try {
                        CommonMethods.handleNuLException(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                CommonMethods.handleNuLException(th2);
                            }
                        }
                        return strArr;
                    } catch (Throwable th3) {
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th4) {
                                CommonMethods.handleNuLException(th4);
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return strArr2;
                    }
                    query.close();
                    return strArr2;
                } catch (Throwable th5) {
                    CommonMethods.handleNuLException(th5);
                    return strArr2;
                }
            }
            return strArr2;
        } catch (Throwable th6) {
            th = th6;
            strArr = null;
        }
    }

    public SQLiteDatabase getTransactionDb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mDb : (SQLiteDatabase) invokeV.objValue;
    }

    public long insertOrUpdatePluginRecord(ApkInfo apkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, apkInfo)) == null) {
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
            contentValues.put(COLUMU_PLUGIN_DEX_PATH, apkInfo.dexPath);
            contentValues.put(COLUMN_PLUGIN_APK_PARSE, Integer.valueOf(apkInfo.apkParseSuc));
            contentValues.put("cl", apkInfo.className);
            contentValues.put("st", Long.valueOf(apkInfo.startTime));
            contentValues.put(COLUMU_PLUGIN_DURATION, Integer.valueOf(apkInfo.duration));
            contentValues.put(COLUMU_PLUGIN_DOWNLOAD_MD5, apkInfo.apkMD5);
            contentValues.put(COLUMU_PLUGIN_APPLICATION_THEME, Integer.valueOf(apkInfo.applicationTheme));
            contentValues.put("pr", Integer.valueOf(apkInfo.priority));
            ActivityInfo[] activityInfoArr = apkInfo.activities;
            if (activityInfoArr != null) {
                contentValues.put(COLUMN_PLUGIN_ACTIVITY_INFO_LIST, new ActivityInfoArray(activityInfoArr).serialize());
            }
            try {
                if (isRecordExit(apkInfo.key)) {
                    j = this.mDb.update("pgn", contentValues, "k=" + apkInfo.key, null);
                } else {
                    contentValues.put("k", Integer.valueOf(apkInfo.key));
                    j = this.mDb.insert("pgn", null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j;
        }
        return invokeL.longValue;
    }

    public boolean isPluinUpdating(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            boolean z = false;
            try {
                Cursor query = this.mDb.query("pgn", new String[]{"u"}, "k=" + i, null, null, null, null);
                if (query != null && query.moveToFirst() && query.getInt(query.getColumnIndex("u")) == 1) {
                    z = true;
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public boolean isPluinWorking(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            boolean z = false;
            try {
                Cursor query = this.mDb.query("pgn", new String[]{"s"}, "k=" + i, null, null, null, null);
                if (query != null && query.moveToFirst() && query.getInt(query.getColumnIndex("s")) == 1) {
                    z = true;
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public boolean isRecordExit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            boolean z = false;
            try {
                Cursor query = this.mDb.query("pgn", new String[]{"p"}, "k=" + i, null, null, null, null);
                if (query != null && query.getCount() > 0) {
                    z = true;
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void registerBootReceiver(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, str, str2, str3) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("r", (Integer) 1);
            contentValues.put("b", str2);
            contentValues.put("t", str3);
            try {
                this.mDb.update("pgn", contentValues, "p=?", new String[]{str});
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setLoadStatusFromFailToInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) 0);
            try {
                this.mDb.update("pgn", contentValues, "n=-1", null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void updateAPKParseStatus(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, packageInfo) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_PLUGIN_APK_PARSE, (Integer) 1);
            contentValues.put("cl", packageInfo.applicationInfo.className);
            ActivityInfo[] activityInfoArr = packageInfo.activities;
            if (activityInfoArr != null) {
                contentValues.put(COLUMN_PLUGIN_ACTIVITY_INFO_LIST, new ActivityInfoArray(activityInfoArr).serialize());
            }
            this.mDb.update("pgn", contentValues, "p=?", new String[]{packageInfo.packageName});
        }
    }

    public void updatePluginDeleteStatus(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMU_PLUGIN_DELETED, Integer.valueOf(i2));
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void updatePluginInitStatus(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.mDb;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void updatePriorityById(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pr", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.mDb;
                sQLiteDatabase.update("pgn", contentValues, "k=" + i, null);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }
}
