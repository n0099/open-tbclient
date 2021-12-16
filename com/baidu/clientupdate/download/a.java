package com.baidu.clientupdate.download;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
/* loaded from: classes10.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f34317b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1016817332, "Lcom/baidu/clientupdate/download/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1016817332, "Lcom/baidu/clientupdate/download/a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, "lcupdatedown.db", (SQLiteDatabase.CursorFactory) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34317b = context;
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
                aVar = a;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, _data TEXT, saved_path_for_user TEXT, mimetype TEXT, etag TEXT, visibility INTEGER, status INTEGER, total_bytes INTEGER, current_bytes INTEGER, notificationneeded INTEGER, notificationshowed BOOLEAN NOT NULL DEFAULT 0, saved_source_key_user TEXT, failreason TEXT);");
            } catch (SQLException unused) {
                LogUtil.logE("DownloadDBHelper", "couldn't create table in downloads database");
            }
        }
    }

    public static String b(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i2 = 0; i2 < jArr.length; i2++) {
                if (i2 > 0) {
                    sb.append("OR ");
                }
                sb.append("_id");
                sb.append(" = ? ");
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logs");
                sQLiteDatabase.execSQL("CREATE TABLE logs(ug TEXT,nm TEXT, sessioninfo TEXT, stm TEXT, sc TEXT, etm TEXT, mg TEXT, ex TEXT,flag TEXT  DEFAULT '0',PRIMARY KEY(nm));");
            } catch (SQLException unused) {
                LogUtil.logE("DownloadDBHelper", "couldn't create table in logs database");
            }
        }
    }

    private ContentValues c(com.baidu.clientupdate.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ug", aVar.f34275b);
            contentValues.put("sessioninfo", aVar.a + "\"tm\":\"" + (System.currentTimeMillis() / 1000) + "\"}");
            contentValues.put(SearchView.IME_OPTION_NO_MICROPHONE, aVar.f34276c);
            contentValues.put(ConstantHelper.LOG_STM, aVar.f34278e.toString());
            contentValues.put("sc", aVar.f34279f.toString());
            contentValues.put(ConstantHelper.LOG_ETM, aVar.f34280g.toString());
            contentValues.put("mg", aVar.f34281h.toString());
            contentValues.put("ex", aVar.f34282i.toString());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    private ContentValues c(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, download)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", download.mFileName);
            contentValues.put("saved_path_for_user", download.mSavedPath);
            contentValues.put("uri", download.mUrl);
            contentValues.put(DownloadDataConstants.Columns.COLUMN_MIME_TYPE, download.mMimeType);
            contentValues.put("etag", download.mETag);
            contentValues.put("status", Integer.valueOf(download.mState.ordinal()));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, Long.valueOf(download.mFileLength));
            contentValues.put(DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES, Long.valueOf(download.mCurrentLength));
            contentValues.put("notificationneeded", Integer.valueOf(download.mNeedNotification ? 1 : 0));
            contentValues.put("notificationshowed", Boolean.valueOf(download.mNotificationShowed));
            contentValues.put("saved_source_key_user", download.mSourceKey);
            contentValues.put("failreason", download.mFailReason);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public static String[] c(long[] jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jArr)) == null) {
            String[] strArr = new String[jArr.length];
            for (int i2 = 0; i2 < jArr.length; i2++) {
                strArr[i2] = Long.toString(jArr[i2]);
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    public int a(long... jArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jArr)) == null) {
            int i2 = 0;
            if (jArr == null || jArr.length == 0) {
                return 0;
            }
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                i2 = writableDatabase.delete("downloads", b(jArr), c(jArr));
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return i2;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                return i2;
            }
        }
        return invokeL.intValue;
    }

    public long a(com.baidu.clientupdate.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            long j2 = -1;
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                ContentValues c2 = c(aVar);
                writableDatabase.beginTransaction();
                j2 = writableDatabase.insert("logs", null, c2);
                com.baidu.util.a.a(this.f34317b).b("lcsdk_xml", "time", System.currentTimeMillis());
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return j2;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                return j2;
            }
        }
        return invokeL.longValue;
    }

    public long a(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, download)) == null) {
            long j2 = -1;
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                ContentValues c2 = c(download);
                writableDatabase.beginTransaction();
                j2 = writableDatabase.insert("downloads", null, c2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                download.mId = j2;
                return j2;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                return j2;
            }
        }
        return invokeL.longValue;
    }

    public Cursor a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase readableDatabase = a(this.f34317b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("downloads", null, null, null, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                return cursor;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                if (cursor != null) {
                    cursor.close();
                    return cursor;
                }
                return cursor;
            }
        }
        return (Cursor) invokeV.objValue;
    }

    public Cursor a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase readableDatabase = a(this.f34317b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, "nm=?", new String[]{str}, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                return cursor;
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                if (cursor != null) {
                    cursor.close();
                }
                b();
                return cursor;
            } catch (Exception e3) {
                if (cursor != null) {
                    cursor.close();
                }
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                return cursor;
            }
        }
        return (Cursor) invokeL.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = 0;
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                i2 = writableDatabase.delete("logs", null, null);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return i2;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                return i2;
            }
        }
        return invokeV.intValue;
    }

    public void b(com.baidu.clientupdate.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                writableDatabase.update("logs", c(aVar), "nm = ?", new String[]{aVar.f34276c});
                com.baidu.util.a.a(this.f34317b).b("lcsdk_xml", "time", System.currentTimeMillis());
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
            }
        }
    }

    public void b(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, download) == null) {
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                writableDatabase.update("downloads", c(download), "_id = ?", new String[]{Long.toString(download.mId)});
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = 0;
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                i2 = writableDatabase.delete("logs", "flag=?", new String[]{"1"});
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return i2;
            } catch (Exception e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                return i2;
            }
        }
        return invokeV.intValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("flag", "1");
                writableDatabase.update("logs", contentValues, null, null);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            try {
                SQLiteDatabase writableDatabase = a(this.f34317b).getWritableDatabase();
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("flag", "0");
                writableDatabase.update("logs", contentValues, null, null);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
            }
        }
    }

    public Cursor f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Cursor cursor = null;
            try {
                SQLiteDatabase readableDatabase = a(this.f34317b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, null, null, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                return cursor;
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                if (cursor != null) {
                    cursor.close();
                }
                b();
                return cursor;
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                if (cursor != null) {
                    cursor.close();
                    return cursor;
                }
                return cursor;
            }
        }
        return (Cursor) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return invokeV.booleanValue;
        }
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase readableDatabase = a(this.f34317b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, "nm=?", new String[]{"a6"}, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                if (cursor != null) {
                    if (cursor.getCount() != 0) {
                        z = true;
                    }
                }
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                if (cursor != null) {
                }
                return z;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048589, this)) != null) {
            return invokeV.booleanValue;
        }
        boolean z = false;
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase readableDatabase = a(this.f34317b).getReadableDatabase();
                readableDatabase.beginTransaction();
                cursor = readableDatabase.query("logs", null, "nm=?", new String[]{"a9"}, null, null, null);
                readableDatabase.setTransactionSuccessful();
                readableDatabase.endTransaction();
                if (cursor != null) {
                    if (cursor.getCount() != 0) {
                        z = true;
                    }
                }
            } catch (IllegalStateException e2) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e2));
                b();
            } catch (Exception e3) {
                LogUtil.logE("DownloadDBHelper", Log.getStackTraceString(e3));
                if (cursor != null) {
                }
                return z;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sQLiteDatabase) == null) {
            LogUtil.logD("DownloadDBHelper", "populating new database");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048591, this, sQLiteDatabase, i2, i3) == null) {
            LogUtil.logD("DownloadDBHelper", i2 + " to " + i3 + ", which will destroy all old data");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            onCreate(sQLiteDatabase);
        }
    }
}
