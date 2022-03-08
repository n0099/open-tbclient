package com.baidu.searchbox.aideviceperformance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.data.DBTableConfig;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LaunchTimeSQLiteOpenHelper extends DataBaseOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static String TAG = "LaunchTimeSQLiteOpenHelper";
    public static LaunchTimeSQLiteOpenHelper instance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(168369705, "Lcom/baidu/searchbox/aideviceperformance/data/LaunchTimeSQLiteOpenHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(168369705, "Lcom/baidu/searchbox/aideviceperformance/data/LaunchTimeSQLiteOpenHelper;");
                return;
            }
        }
        DEBUG = Config.isDebug();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchTimeSQLiteOpenHelper(Context context) {
        super(context, DBTableConfig.LaunchTimeDBTable.DB_NAME, 1);
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
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static LaunchTimeSQLiteOpenHelper getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (instance == null) {
                instance = new LaunchTimeSQLiteOpenHelper(context);
            }
            return instance;
        }
        return (LaunchTimeSQLiteOpenHelper) invokeL.objValue;
    }

    public void delete(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, launchTimeItemModel) == null) {
            if (DEBUG) {
                String str = "delete item: " + launchTimeItemModel.launchTime + " " + launchTimeItemModel.timeStamp;
            }
            delete("app_launch_time", "app_launch_time=? AND event_time=?", new String[]{String.valueOf(launchTimeItemModel.launchTime), String.valueOf(launchTimeItemModel.timeStamp)});
        }
    }

    public void deleteAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            deleteAll("app_launch_time");
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public String getBatchDeleteSqlStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "delete from app_launch_time where event_time in ( select event_time from app_launch_time order by event_time limit 50)" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public int getRestrictionNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 150;
        }
        return invokeV.intValue;
    }

    public void insert(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, contentValues) == null) {
            insert("app_launch_time", contentValues);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public Boolean isEnableCountRestriction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Boolean.TRUE : (Boolean) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL(DBTableConfig.LaunchTimeDBTable.CREATE_TABLE_SQL);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<DBItemModel.LaunchTimeItemModel> query(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        InterceptResult invokeL;
        Cursor cursor;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, launchTimeItemModel)) == null) {
            Cursor cursor2 = null;
            try {
                try {
                    if (launchTimeItemModel == null) {
                        cursor = query("app_launch_time", null, null, null, null, null, null);
                    } else {
                        cursor = query("app_launch_time", "app_launch_time=" + launchTimeItemModel.launchTime + " AND event_time=" + launchTimeItemModel.timeStamp);
                    }
                    try {
                        try {
                            arrayList = new ArrayList();
                        } catch (Exception unused) {
                            boolean z = DEBUG;
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            while (cursor.moveToNext()) {
                arrayList.add(new DBItemModel.LaunchTimeItemModel(cursor.getLong(cursor.getColumnIndex("app_launch_time")), cursor.getLong(cursor.getColumnIndex("event_time"))));
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<DBItemModel.LaunchTimeItemModel> queryAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? query(null) : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public List<DBItemModel.LaunchTimeItemModel> queryLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = query("app_launch_time", null, null, null, null, null, "ROWID DESC", String.valueOf(i2));
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (Exception unused) {
                    boolean z = DEBUG;
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(new DBItemModel.LaunchTimeItemModel(cursor.getLong(cursor.getColumnIndex("app_launch_time")), cursor.getLong(cursor.getColumnIndex("event_time"))));
                }
                return arrayList;
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public void update(DBItemModel.LaunchTimeItemModel launchTimeItemModel, DBItemModel.LaunchTimeItemModel launchTimeItemModel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, launchTimeItemModel, launchTimeItemModel2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_launch_time", Long.valueOf(launchTimeItemModel2.launchTime));
            contentValues.put("event_time", Long.valueOf(launchTimeItemModel2.timeStamp));
            if (DEBUG) {
                String str = "update origin item: " + launchTimeItemModel.launchTime + " " + launchTimeItemModel.timeStamp + " change item : " + launchTimeItemModel2.launchTime + " " + launchTimeItemModel2.timeStamp;
            }
            update("app_launch_time", contentValues, "app_launch_time=? AND event_time=?", new String[]{String.valueOf(launchTimeItemModel.launchTime), String.valueOf(launchTimeItemModel.timeStamp)});
        }
    }

    public void insert(DBItemModel.LaunchTimeItemModel launchTimeItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, launchTimeItemModel) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_launch_time", Long.valueOf(launchTimeItemModel.launchTime));
            contentValues.put("event_time", Long.valueOf(launchTimeItemModel.timeStamp));
            if (DEBUG) {
                String str = "insert item launchTime: " + launchTimeItemModel.launchTime + " timeStamp: " + launchTimeItemModel.timeStamp;
            }
            insert(contentValues);
        }
    }
}
