package com.baidu.tbadk.core.a;

import android.content.Intent;
import android.database.Cursor;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    public static boolean AC(String str) {
        return TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from account_data where id=?", new String[]{str});
    }

    private static boolean a(AccountData accountData, com.baidu.adp.base.a.b bVar) {
        return bVar.execSQLNoException("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait,gender,member_iconurl,stoken,name_show) values(?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait(), Integer.valueOf(accountData.getSex()), accountData.getMemberIconUrl(), accountData.getStoken(), accountData.getAccountNameShow()});
    }

    public static void b(AccountData accountData) {
        if (accountData != null && accountData.getID() != null) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.tieba.action.accountChange");
            intent.putExtra(TbadkCoreApplication.ACCOUNT_DATA, TbadkCoreApplication.getCurrentAccountObj());
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            TbadkCoreApplication.getInst().sendBroadcast(intent);
            String str = "set_basedata_account:";
            if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_basedata_account:valid_logined";
            } else if (!StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_basedata_account:" + CloudControlUBCUtils.KEY_VALID;
            } else if (!StringUtils.isNull(accountData.getID())) {
                str = "set_basedata_account:logined";
            }
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, str, 0, "", new Object[0]);
            if (accountData.getIsActive() == 1) {
                bow();
            }
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (!AC(accountData.getID()) || !a(accountData, mainDBDatabaseManager)) {
                if (!mainDBDatabaseManager.execSQLNoException("DROP TABLE IF EXISTS account_data")) {
                    mainDBDatabaseManager.deleteDatabase();
                }
                mainDBDatabaseManager.execSQLNoException("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255),name_show varchar(255))");
                a(accountData, mainDBDatabaseManager);
            }
        }
    }

    public static void bow() {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("update account_data set isactive=0 where isactive=1");
    }

    public static int box() {
        Cursor cursor = null;
        int i = 0;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            if (mainDBDatabaseManager != null) {
                cursor = mainDBDatabaseManager.rawQuery("select count(*) from account_data", null);
                if (cursor != null && cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                }
            }
        } catch (Exception e) {
            mainDBDatabaseManager.notifySQLException(e, "getAccountNum");
        } finally {
            com.baidu.adp.lib.f.a.close(cursor);
        }
        return i;
    }

    public static AccountData boy() {
        Throwable th;
        Cursor cursor;
        Exception e;
        AccountData accountData;
        Cursor rawQuery;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            try {
                rawQuery = mainDBDatabaseManager.rawQuery("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.moveToFirst()) {
                                accountData = new AccountData();
                                try {
                                    accountData.setID(rawQuery.getString(0));
                                    accountData.setAccount(rawQuery.getString(1));
                                    accountData.setPassword(rawQuery.getString(2));
                                    accountData.setBDUSS(rawQuery.getString(3));
                                    accountData.setIsActive(rawQuery.getInt(4));
                                    accountData.setTbs(rawQuery.getString(5));
                                    accountData.setTime(rawQuery.getLong(6));
                                    accountData.setPortrait(rawQuery.getString(7));
                                    accountData.setSex(rawQuery.getInt(9));
                                    accountData.setMemberIconUrl(rawQuery.getString(10));
                                    accountData.setStoken(rawQuery.getString(rawQuery.getColumnIndex("stoken")));
                                    accountData.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("name_show")));
                                } catch (Exception e2) {
                                    e = e2;
                                    cursor = rawQuery;
                                    try {
                                        mainDBDatabaseManager.notifySQLException(e, "getActiveAccountData");
                                        com.baidu.adp.lib.f.a.close(cursor);
                                        return accountData;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        com.baidu.adp.lib.f.a.close(cursor);
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = rawQuery;
                            com.baidu.adp.lib.f.a.close(cursor);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = rawQuery;
                        accountData = null;
                    }
                }
                accountData = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
                accountData = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        } else {
            rawQuery = null;
            accountData = null;
        }
        com.baidu.adp.lib.f.a.close(rawQuery);
        return accountData;
    }

    public static AccountData AD(String str) {
        Throwable th;
        Cursor cursor;
        Exception e;
        AccountData accountData;
        Cursor rawQuery;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            try {
                rawQuery = mainDBDatabaseManager.rawQuery("select * from account_data where account=?", new String[]{str});
                try {
                    try {
                        if (rawQuery.moveToFirst()) {
                            accountData = new AccountData();
                            try {
                                accountData.setID(rawQuery.getString(0));
                                accountData.setAccount(rawQuery.getString(1));
                                accountData.setPassword(rawQuery.getString(2));
                                accountData.setBDUSS(rawQuery.getString(3));
                                accountData.setIsActive(rawQuery.getInt(4));
                                accountData.setTbs(rawQuery.getString(5));
                                accountData.setTime(rawQuery.getLong(6));
                                accountData.setPortrait(rawQuery.getString(7));
                                accountData.setSex(rawQuery.getInt(9));
                                accountData.setMemberIconUrl(rawQuery.getString(10));
                                accountData.setStoken(rawQuery.getString(rawQuery.getColumnIndex("stoken")));
                                accountData.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("name_show")));
                            } catch (Exception e2) {
                                e = e2;
                                cursor = rawQuery;
                                try {
                                    mainDBDatabaseManager.notifySQLException(e, "getAccountData");
                                    com.baidu.adp.lib.f.a.close(cursor);
                                    return accountData;
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.baidu.adp.lib.f.a.close(cursor);
                                    throw th;
                                }
                            }
                        } else {
                            accountData = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = rawQuery;
                        com.baidu.adp.lib.f.a.close(cursor);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = rawQuery;
                    accountData = null;
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
                accountData = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        } else {
            rawQuery = null;
            accountData = null;
        }
        com.baidu.adp.lib.f.a.close(rawQuery);
        return accountData;
    }

    public static ArrayList<AccountData> boz() {
        Cursor cursor = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        try {
            if (mainDBDatabaseManager != null) {
                cursor = mainDBDatabaseManager.rawQuery("select * from account_data order by time desc", null);
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
            }
        } catch (Exception e) {
            mainDBDatabaseManager.notifySQLException(e, "getAllAccountData");
        } finally {
            com.baidu.adp.lib.f.a.close(cursor);
        }
        return arrayList;
    }
}
