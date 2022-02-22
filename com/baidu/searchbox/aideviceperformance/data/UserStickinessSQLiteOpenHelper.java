package com.baidu.searchbox.aideviceperformance.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.data.DBItemModel;
import com.baidu.searchbox.aideviceperformance.data.DBTableConfig;
import com.baidu.searchbox.aideviceperformance.stickiness.IUserStickinessBusinessDataProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class UserStickinessSQLiteOpenHelper extends DataBaseOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COLUMN_SPACER = "_";
    public static final String COUNT_PREFIX = "count_";
    public static final boolean DEBUG = false;
    public static final String FIRST_TIME_PREFIX = "first_time_";
    public static String TAG = "UserStickinessSQLiteOpenHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isChecked;
    public ArrayList<String> mBusinessIdListInDB;
    public List<String> mRegisterIds;
    public IUserStickinessBusinessDataProvider mUserStickinessHandler;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-96588338, "Lcom/baidu/searchbox/aideviceperformance/data/UserStickinessSQLiteOpenHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-96588338, "Lcom/baidu/searchbox/aideviceperformance/data/UserStickinessSQLiteOpenHelper;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStickinessSQLiteOpenHelper(Context context, IUserStickinessBusinessDataProvider iUserStickinessBusinessDataProvider) {
        super(context, DBTableConfig.UserStickinessDBTable.DB_NAME, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iUserStickinessBusinessDataProvider};
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
        this.mBusinessIdListInDB = new ArrayList<>();
        this.isChecked = false;
        this.mUserStickinessHandler = iUserStickinessBusinessDataProvider;
        List<String> registeredBusinessIdsList = iUserStickinessBusinessDataProvider.getRegisteredBusinessIdsList();
        this.mRegisterIds = registeredBusinessIdsList;
        DBTableConfig.UserStickinessDBTable.setRegisterIds(registeredBusinessIdsList);
    }

    private void checkDB(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) || this.mUserStickinessHandler == null || this.mRegisterIds == null || this.mBusinessIdListInDB == null) {
            return;
        }
        synchronized (this) {
            if (this.mBusinessIdListInDB.size() == 0) {
                getBusinessIdListInDB(sQLiteDatabase);
            }
            for (int i2 = 0; i2 < this.mRegisterIds.size(); i2++) {
                String str = this.mRegisterIds.get(i2);
                if (!this.mBusinessIdListInDB.contains(str)) {
                    sQLiteDatabase.execSQL("alter table user_stickiness add count_" + str + " long default 0");
                    sQLiteDatabase.execSQL("alter table user_stickiness add first_time_" + str + " long default 0");
                }
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.mBusinessIdListInDB.size()) {
                    break;
                }
                if (this.mRegisterIds.contains(this.mBusinessIdListInDB.get(i3))) {
                    i3++;
                } else {
                    sQLiteDatabase.execSQL("alter table user_stickiness rename to user_stickiness_tmp");
                    String str2 = "";
                    for (int i4 = 0; i4 < this.mRegisterIds.size(); i4++) {
                        String str3 = this.mRegisterIds.get(i4);
                        str2 = i4 == this.mRegisterIds.size() - 1 ? str2 + COUNT_PREFIX + str3 + "," + FIRST_TIME_PREFIX + str3 : str2 + COUNT_PREFIX + str3 + "," + FIRST_TIME_PREFIX + str3 + ",";
                    }
                    sQLiteDatabase.execSQL("create table user_stickiness as select event_time," + str2 + " from " + DBTableConfig.UserStickinessDBTable.TABLE_NAME + "_tmp");
                    sQLiteDatabase.execSQL("drop table user_stickiness_tmp");
                }
            }
            this.isChecked = true;
            getBusinessIdListInDB(sQLiteDatabase);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[Catch: Exception -> 0x0051, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0051, blocks: (B:23:0x004d, B:35:0x0064, B:5:0x000d, B:7:0x0013, B:9:0x001a, B:12:0x0021, B:15:0x002a, B:17:0x0030, B:19:0x0040, B:20:0x0045), top: B:42:0x000d, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getBusinessIdListInDB(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65539, this, sQLiteDatabase) != null) {
            return;
        }
        Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA table_info(user_stickiness)", null);
        try {
            try {
                if (rawQuery.moveToFirst()) {
                    do {
                        String string = rawQuery.getString(1);
                        if (string != null && !string.isEmpty() && !"event_time".equals(string) && string.contains("_")) {
                            String[] split = string.split("_");
                            String str = split[split.length - 1];
                            if (!this.mBusinessIdListInDB.contains(str)) {
                                this.mBusinessIdListInDB.add(str);
                            }
                        }
                    } while (rawQuery.moveToNext());
                    if (rawQuery == null) {
                        rawQuery.close();
                    }
                } else if (rawQuery == null) {
                }
            } catch (Exception unused) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    try {
                        rawQuery.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void insert(ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, contentValues) == null) {
            insert(DBTableConfig.UserStickinessDBTable.TABLE_NAME, contentValues);
        }
    }

    public void delete(DBItemModel.UserStickinessItemModel userStickinessItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, userStickinessItemModel) == null) {
            String[] strArr = new String[(this.mRegisterIds.size() * 2) + 1];
            HashMap<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> idToItemDetailMap = userStickinessItemModel.getIdToItemDetailMap();
            String str = "";
            for (int i2 = 0; i2 < this.mRegisterIds.size(); i2++) {
                String str2 = this.mRegisterIds.get(i2);
                str = str + COUNT_PREFIX + str2 + "=? AND " + FIRST_TIME_PREFIX + str2 + "=? AND ";
                DBItemModel.UserStickinessItemModel.ItemDetailModel itemDetailModel = idToItemDetailMap.get(str2);
                int i3 = i2 * 2;
                strArr[i3] = String.valueOf(itemDetailModel.count);
                strArr[i3 + 1] = String.valueOf(itemDetailModel.firstTime);
            }
            strArr[this.mRegisterIds.size() * 2] = String.valueOf(userStickinessItemModel.timeStamp);
            delete(DBTableConfig.UserStickinessDBTable.TABLE_NAME, str + "event_time=?", strArr);
        }
    }

    public void deleteAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            deleteAll(DBTableConfig.UserStickinessDBTable.TABLE_NAME);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public String getBatchDeleteSqlStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "delete from user_stickiness where event_time in ( select event_time from user_stickiness order by event_time limit 50)" : (String) invokeV.objValue;
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

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper
    public Boolean isEnableCountRestriction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Boolean.TRUE : (Boolean) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sQLiteDatabase) == null) || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.execSQL(DBTableConfig.UserStickinessDBTable.getCreateTableSql());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, sQLiteDatabase, i2, i3) == null) {
            checkDB(sQLiteDatabase);
        }
    }

    @Override // com.baidu.searchbox.aideviceperformance.data.DataBaseOpenHelper, android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, i2, i3) == null) {
            super.onUpgrade(sQLiteDatabase, i2, i3);
            checkDB(sQLiteDatabase);
        }
    }

    public DBItemModel.UserStickinessItemModel queryLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            List<DBItemModel.UserStickinessItemModel> queryLast = queryLast(1);
            if (queryLast == null || queryLast.size() <= 0) {
                return null;
            }
            return queryLast.get(0);
        }
        return (DBItemModel.UserStickinessItemModel) invokeV.objValue;
    }

    public void updateLast(DBItemModel.UserStickinessItemModel userStickinessItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, userStickinessItemModel) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("event_time", Long.valueOf(userStickinessItemModel.timeStamp));
            HashMap<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> idToItemDetailMap = userStickinessItemModel.getIdToItemDetailMap();
            for (int i2 = 0; i2 < this.mRegisterIds.size(); i2++) {
                String str = this.mRegisterIds.get(i2);
                if (idToItemDetailMap.containsKey(str)) {
                    DBItemModel.UserStickinessItemModel.ItemDetailModel itemDetailModel = idToItemDetailMap.get(str);
                    contentValues.put(COUNT_PREFIX + str, Integer.valueOf(itemDetailModel.count));
                    contentValues.put(FIRST_TIME_PREFIX + str, Long.valueOf(itemDetailModel.firstTime));
                } else {
                    contentValues.put(COUNT_PREFIX + this.mBusinessIdListInDB.get(i2), (Integer) 0);
                    contentValues.put(FIRST_TIME_PREFIX + this.mBusinessIdListInDB.get(i2), (Long) 0L);
                }
            }
            DBItemModel.UserStickinessItemModel queryLast = queryLast();
            if (queryLast != null) {
                String[] strArr = new String[(this.mRegisterIds.size() * 2) + 1];
                HashMap<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> idToItemDetailMap2 = queryLast.getIdToItemDetailMap();
                String str2 = "";
                for (int i3 = 0; i3 < this.mRegisterIds.size(); i3++) {
                    String str3 = this.mRegisterIds.get(i3);
                    str2 = str2 + COUNT_PREFIX + str3 + "=? AND " + FIRST_TIME_PREFIX + str3 + "=? AND ";
                    DBItemModel.UserStickinessItemModel.ItemDetailModel itemDetailModel2 = idToItemDetailMap2.get(str3);
                    int i4 = i3 * 2;
                    strArr[i4] = String.valueOf(itemDetailModel2.count);
                    strArr[i4 + 1] = String.valueOf(itemDetailModel2.firstTime);
                }
                strArr[this.mRegisterIds.size() * 2] = String.valueOf(userStickinessItemModel.timeStamp);
                update(DBTableConfig.UserStickinessDBTable.TABLE_NAME, contentValues, str2 + "event_time=?", strArr);
            }
        }
    }

    public void insert(DBItemModel.UserStickinessItemModel userStickinessItemModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, userStickinessItemModel) == null) || this.mUserStickinessHandler == null || this.mRegisterIds == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        HashMap<String, DBItemModel.UserStickinessItemModel.ItemDetailModel> idToItemDetailMap = userStickinessItemModel.getIdToItemDetailMap();
        if (this.mRegisterIds != null && idToItemDetailMap != null) {
            for (int i2 = 0; i2 < this.mRegisterIds.size(); i2++) {
                String str = this.mRegisterIds.get(i2);
                if (idToItemDetailMap.containsKey(str)) {
                    DBItemModel.UserStickinessItemModel.ItemDetailModel itemDetailModel = idToItemDetailMap.get(str);
                    contentValues.put(COUNT_PREFIX + str, Integer.valueOf(itemDetailModel.count));
                    contentValues.put(FIRST_TIME_PREFIX + str, Long.valueOf(itemDetailModel.firstTime));
                } else {
                    contentValues.put(COUNT_PREFIX + str, (Integer) 0);
                    contentValues.put(FIRST_TIME_PREFIX + str, (Long) 0L);
                }
            }
        }
        contentValues.put("event_time", Long.valueOf(userStickinessItemModel.timeStamp));
        insert(contentValues);
    }

    public List<DBItemModel.UserStickinessItemModel> queryLast(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (this.mUserStickinessHandler != null && this.mRegisterIds != null) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = query(DBTableConfig.UserStickinessDBTable.TABLE_NAME, null, null, null, null, null, "ROWID DESC", String.valueOf(i2));
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                DBItemModel.UserStickinessItemModel userStickinessItemModel = new DBItemModel.UserStickinessItemModel(cursor.getLong(cursor.getColumnIndex("event_time")));
                                for (int i3 = 0; i3 < this.mRegisterIds.size(); i3++) {
                                    String str = this.mRegisterIds.get(i3);
                                    int i4 = cursor.getInt(cursor.getColumnIndex(COUNT_PREFIX + str));
                                    userStickinessItemModel.putIdToItemDetailMap(str, new DBItemModel.UserStickinessItemModel.ItemDetailModel(i4, cursor.getInt(cursor.getColumnIndex(FIRST_TIME_PREFIX + str))));
                                }
                                arrayList.add(userStickinessItemModel);
                            }
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return arrayList;
                        } else if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
