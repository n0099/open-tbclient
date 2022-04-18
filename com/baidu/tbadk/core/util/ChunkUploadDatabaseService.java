package com.baidu.tbadk.core.util;

import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h9;
import com.repackage.lg;
import com.repackage.uw4;
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

    public static void delChunkUploadData(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str == null || mainDBDatabaseManager == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
    }

    public static void delOverdueChunkUploadData() {
        h9 mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
    }

    public static uw4 getChunkUploadDataByMd5(String str) {
        InterceptResult invokeL;
        uw4 uw4Var;
        Cursor j;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (uw4) invokeL.objValue;
        }
        Cursor cursor = null;
        uw4 uw4Var2 = null;
        cursor = null;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            try {
                j = mainDBDatabaseManager.j("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    if (j.moveToFirst()) {
                        uw4Var = new uw4();
                        try {
                            uw4Var.e(str);
                            uw4Var.d(j.getInt(3));
                            uw4Var.f(j.getLong(2));
                            uw4Var2 = uw4Var;
                        } catch (Exception e) {
                            e = e;
                            cursor = j;
                            mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                            lg.a(cursor);
                            return uw4Var;
                        }
                    }
                    lg.a(j);
                    return uw4Var2;
                } catch (Exception e2) {
                    e = e2;
                    uw4Var = null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = j;
                lg.a(cursor);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            uw4Var = null;
        }
    }

    public static boolean saveChunkUploadData(uw4 uw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uw4Var)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            h9 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Date date = new Date();
            if (uw4Var == null || mainDBDatabaseManager == null) {
                return false;
            }
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{uw4Var.b(), TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{uw4Var.b(), Long.valueOf(uw4Var.c()), Integer.valueOf(uw4Var.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeL.booleanValue;
    }
}
