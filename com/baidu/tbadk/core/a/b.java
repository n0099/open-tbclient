package com.baidu.tbadk.core.a;

import android.database.Cursor;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class b {
    public static boolean mK(String str) {
        return TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("delete from account_data where id=?", new String[]{str});
    }

    private static boolean a(AccountData accountData, com.baidu.adp.base.a.b bVar) {
        return bVar.execSQLNoException("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait,gender,member_iconurl,stoken,name_show) values(?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait(), Integer.valueOf(accountData.getSex()), accountData.getMemberIconUrl(), accountData.getStoken(), accountData.getAccountNameShow()});
    }

    public static void b(AccountData accountData) {
        if (accountData != null && accountData.getID() != null) {
            String str = "set_basedata_account:";
            if (!StringUtils.isNull(accountData.getID()) && !StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_basedata_account:valid_logined";
            } else if (!StringUtils.isNull(accountData.getBDUSS())) {
                str = "set_basedata_account:valid";
            } else if (!StringUtils.isNull(accountData.getID())) {
                str = "set_basedata_account:logined";
            }
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, str, 0, "", new Object[0]);
            if (accountData.getIsActive() == 1) {
                agq();
            }
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            if (!mK(accountData.getID()) || !a(accountData, mainDBDatabaseManager)) {
                if (!mainDBDatabaseManager.execSQLNoException("DROP TABLE IF EXISTS account_data")) {
                    mainDBDatabaseManager.deleteDatabase();
                }
                mainDBDatabaseManager.execSQLNoException("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255), personal_gid int, gender int, member_iconurl varchar(255),stoken varchar(255),name_show varchar(255))");
                a(accountData, mainDBDatabaseManager);
            }
        }
    }

    public static void agq() {
        TiebaDatabase.getInstance().getMainDBDatabaseManager().execSQLNoException("update account_data set isactive=0 where isactive=1");
    }

    public static int agr() {
        Cursor cursor;
        Exception exc;
        Cursor cursor2 = null;
        int i = 0;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            try {
                try {
                    cursor2 = mainDBDatabaseManager.rawQuery("select count(*) from account_data", null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToFirst()) {
                                i = cursor2.getInt(0);
                            }
                        } catch (Exception e) {
                            cursor = cursor2;
                            exc = e;
                            try {
                                mainDBDatabaseManager.notifySQLException(exc, "getAccountNum");
                                com.baidu.adp.lib.g.a.close(cursor);
                                return i;
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                com.baidu.adp.lib.g.a.close(cursor2);
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.g.a.close(cursor2);
                    throw th;
                }
            } catch (Exception e2) {
                cursor = null;
                exc = e2;
            }
        }
        com.baidu.adp.lib.g.a.close(cursor2);
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v34, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r1v36, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r1v37, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX WARN: Multi-variable type inference failed */
    public static AccountData ags() {
        Cursor cursor;
        Cursor rawQuery;
        AccountData accountData;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            try {
                rawQuery = mainDBDatabaseManager.rawQuery("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.moveToFirst()) {
                                AccountData accountData2 = new AccountData();
                                try {
                                    accountData2.setID(rawQuery.getString(0));
                                    accountData2.setAccount(rawQuery.getString(1));
                                    accountData2.setPassword(rawQuery.getString(2));
                                    accountData2.setBDUSS(rawQuery.getString(3));
                                    accountData2.setIsActive(rawQuery.getInt(4));
                                    accountData2.setTbs(rawQuery.getString(5));
                                    accountData2.setTime(rawQuery.getLong(6));
                                    accountData2.setPortrait(rawQuery.getString(7));
                                    accountData2.setSex(rawQuery.getInt(9));
                                    accountData2.setMemberIconUrl(rawQuery.getString(10));
                                    accountData2.setStoken(rawQuery.getString(rawQuery.getColumnIndex("stoken")));
                                    accountData2.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("name_show")));
                                    cursor2 = accountData2;
                                } catch (Exception e) {
                                    cursor2 = accountData2;
                                    cursor = rawQuery;
                                    e = e;
                                    try {
                                        mainDBDatabaseManager.notifySQLException(e, "getActiveAccountData");
                                        com.baidu.adp.lib.g.a.close(cursor);
                                        accountData = cursor2;
                                        return accountData;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = cursor;
                                        com.baidu.adp.lib.g.a.close(cursor2);
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            cursor = rawQuery;
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        cursor2 = rawQuery;
                        th = th2;
                        com.baidu.adp.lib.g.a.close(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            rawQuery = null;
        }
        com.baidu.adp.lib.g.a.close(rawQuery);
        accountData = cursor2;
        return accountData;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v34, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r1v36, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r1v37, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tbadk.core.data.AccountData */
    /* JADX WARN: Multi-variable type inference failed */
    public static AccountData mL(String str) {
        Cursor cursor;
        Cursor rawQuery;
        AccountData accountData;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            try {
                rawQuery = mainDBDatabaseManager.rawQuery("select * from account_data where account=?", new String[]{str});
                try {
                    try {
                        if (rawQuery.moveToFirst()) {
                            AccountData accountData2 = new AccountData();
                            try {
                                accountData2.setID(rawQuery.getString(0));
                                accountData2.setAccount(rawQuery.getString(1));
                                accountData2.setPassword(rawQuery.getString(2));
                                accountData2.setBDUSS(rawQuery.getString(3));
                                accountData2.setIsActive(rawQuery.getInt(4));
                                accountData2.setTbs(rawQuery.getString(5));
                                accountData2.setTime(rawQuery.getLong(6));
                                accountData2.setPortrait(rawQuery.getString(7));
                                accountData2.setSex(rawQuery.getInt(9));
                                accountData2.setMemberIconUrl(rawQuery.getString(10));
                                accountData2.setStoken(rawQuery.getString(rawQuery.getColumnIndex("stoken")));
                                accountData2.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("name_show")));
                                cursor2 = accountData2;
                            } catch (Exception e) {
                                cursor2 = accountData2;
                                cursor = rawQuery;
                                e = e;
                                try {
                                    mainDBDatabaseManager.notifySQLException(e, "getAccountData");
                                    com.baidu.adp.lib.g.a.close(cursor);
                                    accountData = cursor2;
                                    return accountData;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    com.baidu.adp.lib.g.a.close(cursor2);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        cursor = rawQuery;
                        e = e2;
                    }
                } catch (Throwable th2) {
                    cursor2 = rawQuery;
                    th = th2;
                    com.baidu.adp.lib.g.a.close(cursor2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            rawQuery = null;
        }
        com.baidu.adp.lib.g.a.close(rawQuery);
        accountData = cursor2;
        return accountData;
    }

    public static ArrayList<AccountData> agt() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        if (mainDBDatabaseManager != null) {
            try {
                cursor2 = mainDBDatabaseManager.rawQuery("select * from account_data order by time desc", null);
                while (cursor2.moveToNext()) {
                    try {
                        AccountData accountData = new AccountData();
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
                        arrayList.add(accountData);
                    } catch (Exception e) {
                        cursor = cursor2;
                        exc = e;
                        try {
                            mainDBDatabaseManager.notifySQLException(exc, "getAllAccountData");
                            com.baidu.adp.lib.g.a.close(cursor);
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.g.a.close(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.g.a.close(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                cursor = null;
                exc = e2;
            } catch (Throwable th4) {
                cursor = null;
                th = th4;
            }
        }
        com.baidu.adp.lib.g.a.close(cursor2);
        return arrayList;
    }
}
