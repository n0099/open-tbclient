package com.baidu.tbadk.core.account;

import android.content.Intent;
import android.database.Cursor;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tieba.d5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class AccountStorage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_STOKEN = "stoken";
    public static final String NAME_SHOW = "name_show";
    public transient /* synthetic */ FieldHolder $fh;

    public AccountStorage() {
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

    public static void clearActiveAccount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            TiebaDatabase.getInstance().getMainDBDatabaseManager().d("update account_data set isactive=0 where isactive=1");
        }
    }

    public static boolean addAccountData(AccountData accountData, d5 d5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, accountData, d5Var)) == null) {
            return d5Var.e("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait,gender,member_iconurl,stoken,name_show) values(?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait(), Integer.valueOf(accountData.getSex()), accountData.getMemberIconUrl(), accountData.getStoken(), accountData.getAccountNameShow()});
        }
        return invokeLL.booleanValue;
    }

    public static boolean delAccountData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return TiebaDatabase.getInstance().getMainDBDatabaseManager().e("delete from account_data where id=?", new String[]{str});
        }
        return invokeL.booleanValue;
    }

    public static int getAccountNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            d5 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            int i = 0;
            Cursor cursor = null;
            try {
                if (mainDBDatabaseManager != null) {
                    try {
                        cursor = mainDBDatabaseManager.i("select count(*) from account_data", null);
                        if (cursor != null && cursor.moveToFirst()) {
                            i = cursor.getInt(0);
                        }
                    } catch (Exception e) {
                        mainDBDatabaseManager.h(e, "getAccountNum");
                    }
                }
                return i;
            } finally {
                BdCloseHelper.close(cursor);
            }
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00b2: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:26:0x00b2 */
    public static AccountData getActiveAccountData() {
        InterceptResult invokeV;
        Cursor cursor;
        AccountData accountData;
        Exception e;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            d5 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            Cursor cursor3 = null;
            try {
                if (mainDBDatabaseManager != null) {
                    try {
                        cursor2 = mainDBDatabaseManager.i("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                        if (cursor2 != null) {
                            try {
                                if (cursor2.moveToFirst()) {
                                    accountData = new AccountData();
                                    try {
                                        accountData.setID(cursor2.getString(0));
                                        accountData.setAccount(cursor2.getString(1));
                                        accountData.setPassword(cursor2.getString(2));
                                        accountData.setBDUSS(cursor2.getString(3));
                                        accountData.setIsActive(cursor2.getInt(4));
                                        accountData.setTbs(cursor2.getString(5));
                                        accountData.setTime(cursor2.getLong(6));
                                        accountData.setPortrait(cursor2.getString(7));
                                        accountData.setSex(cursor2.getInt(9));
                                        accountData.setMemberIconUrl(cursor2.getString(10));
                                        accountData.setStoken(cursor2.getString(cursor2.getColumnIndex("stoken")));
                                        accountData.setNameShow(cursor2.getString(cursor2.getColumnIndex("name_show")));
                                        cursor3 = cursor2;
                                    } catch (Exception e2) {
                                        e = e2;
                                        mainDBDatabaseManager.h(e, "getActiveAccountData");
                                        BdCloseHelper.close(cursor2);
                                        return accountData;
                                    }
                                }
                            } catch (Exception e3) {
                                accountData = null;
                                e = e3;
                            }
                        }
                        accountData = null;
                        cursor3 = cursor2;
                    } catch (Exception e4) {
                        accountData = null;
                        e = e4;
                        cursor2 = null;
                    } catch (Throwable th) {
                        th = th;
                        BdCloseHelper.close(cursor3);
                        throw th;
                    }
                } else {
                    accountData = null;
                }
                BdCloseHelper.close(cursor3);
                return accountData;
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor;
            }
        } else {
            return (AccountData) invokeV.objValue;
        }
    }

    public static ArrayList<AccountData> getAllAccountData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            d5 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            ArrayList<AccountData> arrayList = new ArrayList<>();
            Cursor cursor = null;
            if (mainDBDatabaseManager != null) {
                try {
                    try {
                        cursor = mainDBDatabaseManager.i("select * from account_data order by time desc", null);
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
                    } catch (Exception e) {
                        mainDBDatabaseManager.h(e, "getAllAccountData");
                    }
                } finally {
                    BdCloseHelper.close(cursor);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static void saveAccountData(AccountData accountData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, accountData) == null) && accountData != null && accountData.getID() != null) {
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
            Logger.addLog("account", -1L, 0, str, 0, "", new Object[0]);
            if (accountData.getIsActive() == 1) {
                clearActiveAccount();
            }
            d5 mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (!delAccountData(accountData.getID()) || !addAccountData(accountData, mainDBDatabaseManager)) {
                if (!mainDBDatabaseManager.d("DROP TABLE IF EXISTS account_data")) {
                    mainDBDatabaseManager.b();
                }
                mainDBDatabaseManager.d("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255),name_show varchar(255))");
                addAccountData(accountData, mainDBDatabaseManager);
            }
        }
    }
}
