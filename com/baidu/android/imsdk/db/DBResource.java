package com.baidu.android.imsdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DBResource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBManager";
    public static Context mContext;
    public static final DBResource sInstanceDbResource;
    public transient /* synthetic */ FieldHolder $fh;
    public long appid;
    public SQLiteDatabase mDatabase;
    public String mUid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-518471867, "Lcom/baidu/android/imsdk/db/DBResource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-518471867, "Lcom/baidu/android/imsdk/db/DBResource;");
                return;
            }
        }
        sInstanceDbResource = new DBResource();
    }

    public DBResource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appid = -1L;
        this.mUid = null;
    }

    private void closeDatabase() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (sQLiteDatabase = this.mDatabase) == null) {
            return;
        }
        sQLiteDatabase.close();
        this.mDatabase = null;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? mContext : (Context) invokeV.objValue;
    }

    public static DBResource getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (mContext == null) {
                mContext = context.getApplicationContext();
            }
            return sInstanceDbResource;
        }
        return (DBResource) invokeL.objValue;
    }

    public SQLiteDatabase openDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context context = mContext;
            if (context == null) {
                LogUtils.d("DBManager", "pls call init method first!");
                return null;
            }
            if (AccountManagerImpl.getInstance(context).getLoginType() == 6) {
                this.mUid = AccountManager.getUK(mContext) + "";
            } else {
                this.mUid = AccountManager.getUid(mContext);
            }
            this.appid = AccountManager.getAppid(mContext);
            if (!TextUtils.isEmpty(this.mUid) && -1 != this.appid) {
                Context context2 = mContext;
                String path = context2.getDatabasePath(TableDefine.DB_NAME_PREFIX + this.mUid + "_" + this.appid + ".db").getPath();
                if (this.mDatabase == null) {
                    try {
                        this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
                    } catch (SQLiteDatabaseCorruptException e2) {
                        if (this.mDatabase != null) {
                            closeDatabase();
                            this.mDatabase = null;
                            LogUtils.e("DBManager", "getWritableDb  DatabaseCorruptException");
                        }
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e2)).build();
                    }
                } else if (!TextUtils.isEmpty(path) && !this.mDatabase.getPath().equals(path)) {
                    closeDatabase();
                    try {
                        this.mDatabase = IMDatabase.getWritableDb(mContext, this.mUid, this.appid);
                    } catch (SQLiteDatabaseCorruptException e3) {
                        if (this.mDatabase != null) {
                            closeDatabase();
                            this.mDatabase = null;
                            LogUtils.e("DBManager", "getWritableDb  DatabaseCorruptException");
                        }
                        new IMTrack.CrashBuilder(mContext).exception(Log.getStackTraceString(e3)).build();
                    }
                }
                return this.mDatabase;
            }
            LogUtils.d("DBManager", "UK OR appid Not initialize!");
            if (TextUtils.isEmpty(this.mUid)) {
                LogUtils.d("DBManager", "mUid Not initialize!");
            }
            if (-1 == this.appid) {
                LogUtils.d("DBManager", "appid Not initialize!");
            }
            return null;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
