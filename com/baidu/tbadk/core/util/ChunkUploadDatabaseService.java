package com.baidu.tbadk.core.util;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dh;
import com.baidu.tieba.e15;
import com.baidu.tieba.y9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes3.dex */
public class ChunkUploadDatabaseService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChunkUploadDatabaseService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void delOverdueChunkUploadData() {
        y9 mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && TbadkCoreApplication.getCurrentAccount() != null && (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) != null) {
            mainDBDatabaseManager.e("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static void delChunkUploadData(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, str) != null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        y9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null && mainDBDatabaseManager != null) {
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static e15 getChunkUploadDataByMd5(String str) {
        InterceptResult invokeL;
        e15 e15Var;
        Cursor j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Cursor cursor = null;
            e15 e15Var2 = null;
            cursor = null;
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return null;
            }
            y9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    j = mainDBDatabaseManager.j("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        if (j.moveToFirst()) {
                            e15Var = new e15();
                            try {
                                e15Var.e(str);
                                e15Var.d(j.getInt(3));
                                e15Var.f(j.getLong(2));
                                e15Var2 = e15Var;
                            } catch (Exception e) {
                                e = e;
                                cursor = j;
                                mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                                dh.a(cursor);
                                return e15Var;
                            }
                        }
                        dh.a(j);
                        return e15Var2;
                    } catch (Exception e2) {
                        e = e2;
                        e15Var = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = j;
                    dh.a(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e15Var = null;
            }
        } else {
            return (e15) invokeL.objValue;
        }
    }

    public static boolean saveChunkUploadData(e15 e15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e15Var)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            y9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Date date = new Date();
            if (e15Var == null || mainDBDatabaseManager == null) {
                return false;
            }
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{e15Var.b(), TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{e15Var.b(), Long.valueOf(e15Var.c()), Integer.valueOf(e15Var.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeL.booleanValue;
    }
}
