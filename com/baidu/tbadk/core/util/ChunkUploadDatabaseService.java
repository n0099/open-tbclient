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
import d.a.c.a.k.b;
import d.a.c.e.m.a;
import d.a.o0.s.c.q;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str == null || mainDBDatabaseManager == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
    }

    public static void delOverdueChunkUploadData() {
        b mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", new String[]{TbadkCoreApplication.getCurrentAccount()});
    }

    public static q getChunkUploadDataByMd5(String str) {
        InterceptResult invokeL;
        q qVar;
        Cursor j;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return (q) invokeL.objValue;
        }
        Cursor cursor = null;
        q qVar2 = null;
        cursor = null;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return null;
        }
        b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            try {
                j = mainDBDatabaseManager.j("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    if (j.moveToFirst()) {
                        qVar = new q();
                        try {
                            qVar.e(str);
                            qVar.d(j.getInt(3));
                            qVar.f(j.getLong(2));
                            qVar2 = qVar;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = j;
                            mainDBDatabaseManager.i(e, "getChunkUploadDataByMd5");
                            a.a(cursor);
                            return qVar;
                        }
                    }
                    a.a(j);
                    return qVar2;
                } catch (Exception e3) {
                    e = e3;
                    qVar = null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = j;
                a.a(cursor);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            qVar = null;
        }
    }

    public static boolean saveChunkUploadData(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, qVar)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Date date = new Date();
            if (qVar == null || mainDBDatabaseManager == null) {
                return false;
            }
            mainDBDatabaseManager.e("delete from chunk_upload_data where md5=? and account=?", new String[]{qVar.b(), TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{qVar.b(), Long.valueOf(qVar.c()), Integer.valueOf(qVar.a()), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeL.booleanValue;
    }
}
