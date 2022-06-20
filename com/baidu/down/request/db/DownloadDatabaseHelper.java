package com.baidu.down.request.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.down.request.taskmanager.DatabaseMng;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DownloadDatabaseHelper extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDatabaseHelper(Context context) {
        super(context, DatabaseMng.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    }

    private void addColumn(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, this, sQLiteDatabase, str, str2, str3) == null) {
            sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
        }
    }

    private void createDownloadsTable(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
                sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, name TEXT, path TEXT, data TEXT, mimetype TEXT, etag TEXT, tasktype INTEGER, status INTEGER DEFAULT 0, lastmodification BIGINT DEFAULT " + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR + DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_CURRENT_BYTES + " BIGINT DEFAULT 0, " + DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP + " TEXT, retry_count INTEGER DEFAULT 0);");
            } catch (SQLException e) {
                throw e;
            }
        }
    }

    private void upgradeTo(SQLiteDatabase sQLiteDatabase, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, sQLiteDatabase, i) == null) {
            if (i == 2) {
                addColumn(sQLiteDatabase, "downloads", DownloadDataConstants.Columns.COLUMN_PROGRESS_MAP, "TEXT");
                return;
            }
            throw new IllegalStateException("Don't know how to upgrade to " + i);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            createDownloadsTable(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            createDownloadsTable(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i, i2) != null) {
            return;
        }
        while (true) {
            i++;
            if (i > i2) {
                return;
            }
            upgradeTo(sQLiteDatabase, i);
        }
    }
}
