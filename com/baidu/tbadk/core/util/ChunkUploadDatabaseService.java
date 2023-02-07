package com.baidu.tbadk.core.util;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ch;
import com.baidu.tieba.fa;
import com.baidu.tieba.z65;
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
        fa mainDBDatabaseManager;
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
        fa mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null && mainDBDatabaseManager != null) {
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static z65 getChunkUploadDataByMd5(String str) {
        InterceptResult invokeL;
        z65 z65Var;
        Cursor j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Cursor cursor = null;
            z65 z65Var2 = null;
            cursor = null;
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return null;
            }
            fa mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    j = mainDBDatabaseManager.j("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        if (j.moveToFirst()) {
                            z65Var = new z65();
                            try {
                                z65Var.e(str);
                                z65Var.d(j.getInt(3));
                                z65Var.f(j.getLong(2));
                                z65Var2 = z65Var;
                            } catch (Exception e) {
                                e = e;
                                cursor = j;
                                mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                                ch.a(cursor);
                                return z65Var;
                            }
                        }
                        ch.a(j);
                        return z65Var2;
                    } catch (Exception e2) {
                        e = e2;
                        z65Var = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = j;
                    ch.a(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                z65Var = null;
            }
        } else {
            return (z65) invokeL.objValue;
        }
    }

    public static boolean saveChunkUploadData(z65 z65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, z65Var)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            fa mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Date date = new Date();
            if (z65Var == null || mainDBDatabaseManager == null) {
                return false;
            }
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{z65Var.b(), TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{z65Var.b(), Long.valueOf(z65Var.c()), Integer.valueOf(z65Var.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeL.booleanValue;
    }
}
