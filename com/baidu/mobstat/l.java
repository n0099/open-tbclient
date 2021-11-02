package com.baidu.mobstat;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class l extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if ("mounted".equals(bo.a())) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/system";
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str2 + File.separator + str);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e2) {
                        bb.c().b(e2);
                    }
                }
                if (file2.exists()) {
                    return file2;
                }
                return null;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, cursorFactory)) == null) {
            File databasePath = getDatabasePath(str);
            if (databasePath != null && databasePath.canWrite()) {
                return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
            }
            throw new RuntimeException("db path is null or path can not be write");
        }
        return (SQLiteDatabase) invokeLIL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, str, i2, cursorFactory, databaseErrorHandler)) == null) {
            File databasePath = getDatabasePath(str);
            if (databasePath != null && databasePath.canWrite()) {
                return SQLiteDatabase.openOrCreateDatabase(databasePath, (SQLiteDatabase.CursorFactory) null);
            }
            throw new RuntimeException("db path is null or path can not be write");
        }
        return (SQLiteDatabase) invokeLILL.objValue;
    }
}
