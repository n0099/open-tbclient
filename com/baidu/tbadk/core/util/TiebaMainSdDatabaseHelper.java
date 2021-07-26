package com.baidu.tbadk.core.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.k.d;
/* loaded from: classes3.dex */
public class TiebaMainSdDatabaseHelper extends d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATABASE_VERSION = 11;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaMainSdDatabaseHelper() {
        super(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_DATABASE_NAME, 11);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void createUserIcon(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
        }
    }

    @Override // d.a.d.a.k.d
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS pb_photo");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS friend_photo");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "DROP TABLE IF EXISTS user_icon");
        }
    }

    @Override // d.a.d.a.k.d
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
            createUserIcon(sQLiteDatabase);
        }
    }

    @Override // d.a.d.a.k.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) {
            if (i2 <= 9) {
                createUserIcon(sQLiteDatabase);
            }
            if (i2 < 11) {
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
                executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
                if (i2 > 9) {
                    executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
                }
            }
        }
    }
}
