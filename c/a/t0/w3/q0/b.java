package c.a.t0.w3.q0;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        c.a.d.a.k.b mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return;
        }
        mainDBDatabaseManager.d("CREATE TABLE IF NOT EXISTS video_block_upload_data('md5' text,'last_upload_id' text ,'last_upload_success_index' integer,'account' text,'time' long)");
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            BdLog.e("deleteVieoChunkUploadData Called");
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                return;
            }
            c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (str == null || mainDBDatabaseManager == null) {
                return;
            }
            mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        }
    }

    public static c c(String str) {
        InterceptResult invokeL;
        c cVar;
        Exception e2;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, str)) != null) {
            return (c) invokeL.objValue;
        }
        Cursor cursor2 = null;
        c cVar2 = null;
        if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
            return null;
        }
        c.a.d.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.j("select * from video_block_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        cVar = new c();
                        try {
                            cVar.a = cursor.getString(cursor.getColumnIndex("last_upload_id"));
                            cVar.f24962b = cursor.getInt(cursor.getColumnIndex("last_upload_success_index"));
                            cVar2 = cVar;
                        } catch (Exception e3) {
                            e2 = e3;
                            mainDBDatabaseManager.i(e2, "getChunkUploadDataByMd5");
                            c.a.d.f.m.a.a(cursor);
                            return cVar;
                        }
                    }
                    c.a.d.f.m.a.a(cursor);
                    return cVar2;
                } catch (Exception e4) {
                    cVar = null;
                    e2 = e4;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                c.a.d.f.m.a.a(cursor2);
                throw th;
            }
        } catch (Exception e5) {
            cVar = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            c.a.d.f.m.a.a(cursor2);
            throw th;
        }
    }

    public static boolean d(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        c.a.d.a.k.b mainDBDatabaseManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, str, str2, i2)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
                return false;
            }
            Date date = new Date();
            mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            return mainDBDatabaseManager.e("Insert into video_block_upload_data(md5,last_upload_id,last_upload_success_index,account,time) values(?,?,?,?,?)", new Object[]{str, str2, Integer.valueOf(i2), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
        }
        return invokeLLI.booleanValue;
    }
}
