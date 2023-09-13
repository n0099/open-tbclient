package com.baidu.tbadk.core.util;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.o9;
import com.baidu.tieba.yc5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes4.dex */
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
        o9 mainDBDatabaseManager;
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
        o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str != null && mainDBDatabaseManager != null) {
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static yc5 getChunkUploadDataByMd5(String str) {
        InterceptResult invokeL;
        yc5 yc5Var;
        Cursor i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Cursor cursor = null;
            yc5 yc5Var2 = null;
            cursor = null;
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return null;
            }
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            try {
                try {
                    i = mainDBDatabaseManager.i("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        if (i.moveToFirst()) {
                            yc5Var = new yc5();
                            try {
                                yc5Var.e(str);
                                yc5Var.d(i.getInt(3));
                                yc5Var.f(i.getLong(2));
                                yc5Var2 = yc5Var;
                            } catch (Exception e) {
                                e = e;
                                cursor = i;
                                mainDBDatabaseManager.h(e, "getChunkUploadDataByMd5");
                                BdCloseHelper.close(cursor);
                                return yc5Var;
                            }
                        }
                        BdCloseHelper.close(i);
                        return yc5Var2;
                    } catch (Exception e2) {
                        e = e2;
                        yc5Var = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = i;
                    BdCloseHelper.close(cursor);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                yc5Var = null;
            }
        } else {
            return (yc5) invokeL.objValue;
        }
    }

    public static boolean saveChunkUploadData(yc5 yc5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yc5Var)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            o9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Date date = new Date();
            if (yc5Var == null || mainDBDatabaseManager == null) {
                return false;
            }
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{yc5Var.b(), TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{yc5Var.b(), Long.valueOf(yc5Var.c()), Integer.valueOf(yc5Var.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeL.booleanValue;
    }
}
