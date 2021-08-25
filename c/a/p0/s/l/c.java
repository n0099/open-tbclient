package c.a.p0.s.l;

import android.content.Intent;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(AccountData accountData, c.a.e.a.k.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, accountData, bVar)) == null) ? bVar.e("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait,gender,member_iconurl,stoken,name_show) values(?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait(), Integer.valueOf(accountData.getSex()), accountData.getMemberIconUrl(), accountData.getStoken(), accountData.getAccountNameShow()}) : invokeLL.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().d("update account_data set isactive=0 where isactive=1");
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from account_data where id=?", new String[]{str}) : invokeL.booleanValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            int i2 = 0;
            Cursor cursor = null;
            try {
                if (mainDBDatabaseManager != null) {
                    try {
                        cursor = mainDBDatabaseManager.j("select count(*) from account_data", null);
                        if (cursor != null && cursor.moveToFirst()) {
                            i2 = cursor.getInt(0);
                        }
                    } catch (Exception e2) {
                        mainDBDatabaseManager.i(e2, "getAccountNum");
                    }
                }
                return i2;
            } finally {
                c.a.e.e.m.a.a(cursor);
            }
        }
        return invokeV.intValue;
    }

    public static AccountData e() {
        InterceptResult invokeV;
        AccountData accountData;
        Exception e2;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor2 = null;
            if (mainDBDatabaseManager != null) {
                try {
                    cursor = mainDBDatabaseManager.j("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    accountData = new AccountData();
                                    try {
                                        accountData.setID(cursor.getString(0));
                                        accountData.setAccount(cursor.getString(1));
                                        accountData.setPassword(cursor.getString(2));
                                        accountData.setBDUSS(cursor.getString(3));
                                        accountData.setIsActive(cursor.getInt(4));
                                        accountData.setTbs(cursor.getString(5));
                                        accountData.setTime(cursor.getLong(6));
                                        accountData.setPortrait(cursor.getString(7));
                                        accountData.setSex(cursor.getInt(9));
                                        accountData.setMemberIconUrl(cursor.getString(10));
                                        accountData.setStoken(cursor.getString(cursor.getColumnIndex("stoken")));
                                        accountData.setNameShow(cursor.getString(cursor.getColumnIndex("name_show")));
                                        cursor2 = cursor;
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        mainDBDatabaseManager.i(e2, "getActiveAccountData");
                                        c.a.e.e.m.a.a(cursor);
                                        return accountData;
                                    }
                                }
                            } catch (Exception e4) {
                                accountData = null;
                                e2 = e4;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            c.a.e.e.m.a.a(cursor2);
                            throw th;
                        }
                    }
                    accountData = null;
                    cursor2 = cursor;
                } catch (Exception e5) {
                    accountData = null;
                    e2 = e5;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.e.e.m.a.a(cursor2);
                    throw th;
                }
            } else {
                accountData = null;
            }
            c.a.e.e.m.a.a(cursor2);
            return accountData;
        }
        return (AccountData) invokeV.objValue;
    }

    public static ArrayList<AccountData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            ArrayList<AccountData> arrayList = new ArrayList<>();
            Cursor cursor = null;
            try {
                if (mainDBDatabaseManager != null) {
                    try {
                        cursor = mainDBDatabaseManager.j("select * from account_data order by time desc", null);
                        while (cursor.moveToNext()) {
                            AccountData accountData = new AccountData();
                            accountData.setID(cursor.getString(0));
                            accountData.setAccount(cursor.getString(1));
                            accountData.setPassword(cursor.getString(2));
                            accountData.setBDUSS(cursor.getString(3));
                            accountData.setIsActive(cursor.getInt(4));
                            accountData.setTbs(cursor.getString(5));
                            accountData.setTime(cursor.getLong(6));
                            accountData.setPortrait(cursor.getString(7));
                            accountData.setSex(cursor.getInt(9));
                            accountData.setMemberIconUrl(cursor.getString(10));
                            accountData.setStoken(cursor.getString(cursor.getColumnIndex("stoken")));
                            accountData.setNameShow(cursor.getString(cursor.getColumnIndex("name_show")));
                            arrayList.add(accountData);
                        }
                    } catch (Exception e2) {
                        mainDBDatabaseManager.i(e2, "getAllAccountData");
                    }
                }
                return arrayList;
            } finally {
                c.a.e.e.m.a.a(cursor);
            }
        }
        return (ArrayList) invokeV.objValue;
    }

    public static void g(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, accountData) == null) || accountData == null || accountData.getID() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.action.accountChange");
        intent.putExtra("intent_data_accountData", TbadkCoreApplication.getCurrentAccountObj());
        intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
        TbadkCoreApplication.getInst().sendBroadcast(intent);
        String str = "set_basedata_account:";
        if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_basedata_account:valid_logined";
        } else if (!StringUtils.isNull(accountData.getBDUSS())) {
            str = "set_basedata_account:valid";
        } else if (!StringUtils.isNull(accountData.getID())) {
            str = "set_basedata_account:logined";
        }
        c.a.p0.s.z.a.a("account", -1L, 0, str, 0, "", new Object[0]);
        if (accountData.getIsActive() == 1) {
            b();
        }
        c.a.e.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (c(accountData.getID()) && a(accountData, mainDBDatabaseManager)) {
            return;
        }
        if (!mainDBDatabaseManager.d("DROP TABLE IF EXISTS account_data")) {
            mainDBDatabaseManager.b();
        }
        mainDBDatabaseManager.d("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255),name_show varchar(255))");
        a(accountData, mainDBDatabaseManager);
    }
}
