package com.baidu.tbadk.core.account;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class a {
    public static boolean a(String str) {
        try {
            return new DatabaseManager().a("delete from account_data where account=?", (Object[]) new String[]{str}).booleanValue();
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "DatabaseService.delAccountData", new Object[0]);
            return false;
        }
    }

    private static boolean a(AccountData accountData, DatabaseManager databaseManager) {
        try {
            return databaseManager.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait) values(?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait()}).booleanValue();
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "DatabaseService.addAccountData", new Object[0]);
            return false;
        }
    }

    public static void a(AccountData accountData) {
        if (accountData != null && accountData.getAccount() != null) {
            if (accountData.getIsActive() == 1) {
                a();
            }
            DatabaseManager databaseManager = new DatabaseManager();
            if (databaseManager != null) {
                try {
                    if (!a(accountData.getAccount()) || !a(accountData, databaseManager)) {
                        if (!databaseManager.a("DROP TABLE IF EXISTS account_data")) {
                            databaseManager.a(TbadkApplication.m252getInst().getApp());
                            databaseManager = new DatabaseManager();
                        }
                        databaseManager.a("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255))");
                        a(accountData, databaseManager);
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.printDBExceptionLog(e, "DatabaseService.saveAccountData", new Object[0]);
                }
            }
        }
    }

    public static void a() {
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                databaseManager.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseService.clearActiveAccount", new Object[0]);
            }
        }
    }

    public static void b(AccountData accountData) {
        a();
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                databaseManager.a("update account_data set isactive=1 where account=?", (Object[]) new String[]{accountData.getAccount()});
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseService.setActiveAccount", new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b() {
        int i;
        Cursor cursor = null;
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            if (databaseManager != null) {
                try {
                    cursor = databaseManager.a("select count(*) from account_data", (String[]) null);
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return i;
                            } catch (Exception e) {
                                TiebaStatic.printDBExceptionLog(e, "DatabaseService.getAccountNum close cursor", new Object[0]);
                            }
                        }
                        return i;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.printDBExceptionLog(e2, "DatabaseService.getAccountNum", new Object[0]);
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return 0;
                        } catch (Exception e3) {
                            TiebaStatic.printDBExceptionLog(e3, "DatabaseService.getAccountNum close cursor", new Object[0]);
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            i = 0;
            if (cursor != null) {
            }
            return i;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    TiebaStatic.printDBExceptionLog(e4, "DatabaseService.getAccountNum close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData c() {
        Cursor cursor;
        Exception exc;
        AccountData accountData;
        Cursor cursor2 = null;
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                cursor = databaseManager.a("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                AccountData accountData2 = new AccountData();
                                try {
                                    accountData2.setID(cursor.getString(0));
                                    accountData2.setAccount(cursor.getString(1));
                                    accountData2.setPassword(cursor.getString(2));
                                    accountData2.setBDUSS(cursor.getString(3));
                                    accountData2.setIsActive(cursor.getInt(4));
                                    accountData2.setTbs(cursor.getString(5));
                                    accountData2.setTime(cursor.getLong(6));
                                    accountData2.setPortrait(cursor.getString(7));
                                    accountData = accountData2;
                                } catch (Exception e) {
                                    cursor2 = cursor;
                                    exc = e;
                                    accountData = accountData2;
                                    try {
                                        BdLog.e(exc.getMessage());
                                        TiebaStatic.printDBExceptionLog(exc, "DatabaseService.getActiveAccountData", new Object[0]);
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e2) {
                                                TiebaStatic.printDBExceptionLog(e2, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                            }
                                        }
                                        return accountData;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception e3) {
                                                TiebaStatic.printDBExceptionLog(e3, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Exception e4) {
                            accountData = null;
                            cursor2 = cursor;
                            exc = e4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                }
                accountData = null;
            } catch (Exception e5) {
                exc = e5;
                accountData = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            cursor = null;
            accountData = null;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e6) {
                TiebaStatic.printDBExceptionLog(e6, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
            }
        }
        return accountData;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData b(String str) {
        Cursor cursor;
        AccountData accountData;
        Exception e;
        Cursor cursor2;
        DatabaseManager databaseManager = new DatabaseManager();
        if (databaseManager != null) {
            try {
                cursor = databaseManager.a("select * from account_data where account=?", new String[]{str});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                AccountData accountData2 = new AccountData();
                                try {
                                    accountData2.setID(cursor.getString(0));
                                    accountData2.setAccount(cursor.getString(1));
                                    accountData2.setPassword(cursor.getString(2));
                                    accountData2.setBDUSS(cursor.getString(3));
                                    accountData2.setIsActive(cursor.getInt(4));
                                    accountData2.setTbs(cursor.getString(5));
                                    accountData2.setTime(cursor.getLong(6));
                                    accountData2.setPortrait(cursor.getString(7));
                                    accountData = accountData2;
                                } catch (Exception e2) {
                                    e = e2;
                                    accountData = accountData2;
                                    BdLog.e(e.getMessage());
                                    TiebaStatic.printDBExceptionLog(e, "DatabaseService.getAccountData", new Object[0]);
                                    if (cursor != null) {
                                    }
                                    return accountData;
                                }
                            } else {
                                accountData = null;
                            }
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                e = e3;
                                BdLog.e(e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseService.getAccountData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                        TiebaStatic.printDBExceptionLog(e4, "DatabaseService.getAccountData close cursor", new Object[0]);
                                    }
                                }
                                return accountData;
                            }
                        } catch (Exception e5) {
                            accountData = null;
                            e = e5;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e6) {
                                TiebaStatic.printDBExceptionLog(e6, "DatabaseService.getAccountData close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    accountData = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                accountData = null;
                e = e7;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
            accountData = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
                TiebaStatic.printDBExceptionLog(e8, "DatabaseService.getAccountData close cursor", new Object[0]);
            }
        }
        return accountData;
    }

    public static void a(String str, String str2) {
        DatabaseManager databaseManager;
        if (str != null && str2 != null && (databaseManager = new DatabaseManager()) != null) {
            try {
                databaseManager.a("update account_data set portrait=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.updateAccountPortrait", new Object[0]);
            }
        }
    }

    public static ArrayList<AccountData> d() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        try {
            if (databaseManager != null) {
                try {
                    cursor = databaseManager.a("select * from account_data order by time desc", (String[]) null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                AccountData accountData = new AccountData();
                                accountData.setID(cursor.getString(0));
                                accountData.setAccount(cursor.getString(1));
                                accountData.setPassword(cursor.getString(2));
                                accountData.setBDUSS(cursor.getString(3));
                                accountData.setIsActive(cursor.getInt(4));
                                accountData.setTbs(cursor.getString(5));
                                accountData.setTime(cursor.getLong(6));
                                accountData.setPortrait(cursor.getString(7));
                                arrayList.add(accountData);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                TiebaStatic.printDBExceptionLog(e, "DatabaseManager.getAllAccountData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        TiebaStatic.printDBExceptionLog(e2, "DatabaseManager.getAllAccountData close cursor", new Object[0]);
                                    }
                                }
                                return arrayList;
                            }
                        }
                        cursor.close();
                    }
                    cursor2 = null;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e4) {
                            TiebaStatic.printDBExceptionLog(e4, "DatabaseManager.getAllAccountData close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e5) {
                    TiebaStatic.printDBExceptionLog(e5, "DatabaseManager.getAllAccountData close cursor", new Object[0]);
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
