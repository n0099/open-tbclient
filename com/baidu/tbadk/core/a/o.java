package com.baidu.tbadk.core.a;

import android.database.Cursor;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class o {
    private static boolean b(String str) {
        try {
            return new DatabaseManager().a("delete from account_data where account=?", (Object[]) new String[]{str}).booleanValue();
        } catch (Exception e) {
            TiebaStatic.a(e, "DatabaseService.delAccountData", new Object[0]);
            return false;
        }
    }

    private static boolean a(AccountData accountData, DatabaseManager databaseManager) {
        try {
            return databaseManager.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait) values(?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait()}).booleanValue();
        } catch (Exception e) {
            TiebaStatic.a(e, "DatabaseService.addAccountData", new Object[0]);
            return false;
        }
    }

    public static void a(AccountData accountData) {
        if (accountData != null && accountData.getAccount() != null) {
            if (accountData.getIsActive() == 1) {
                a();
            }
            DatabaseManager databaseManager = new DatabaseManager();
            try {
                if (!b(accountData.getAccount()) || !a(accountData, databaseManager)) {
                    databaseManager.a("DROP TABLE IF EXISTS account_data");
                    databaseManager.a("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255))");
                    a(accountData, databaseManager);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseService.saveAccountData", new Object[0]);
            }
        }
    }

    public static void a() {
        try {
            new DatabaseManager().a("update account_data set isactive=0 where isactive=1");
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            TiebaStatic.a(e, "DatabaseService.clearActiveAccount", new Object[0]);
        }
    }

    public static void b(AccountData accountData) {
        a();
        try {
            new DatabaseManager().a("update account_data set isactive=1 where account=?", (Object[]) new String[]{accountData.getAccount()});
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            TiebaStatic.a(e, "DatabaseService.setActiveAccount", new Object[0]);
        }
    }

    public static int b() {
        Cursor cursor = null;
        try {
            try {
                cursor = new DatabaseManager().a("select count(*) from account_data", (String[]) null);
                int i = (cursor == null || !cursor.moveToFirst()) ? 0 : cursor.getInt(0);
                if (cursor != null) {
                    try {
                        cursor.close();
                        return i;
                    } catch (Exception e) {
                        TiebaStatic.a(e, "DatabaseService.getAccountNum close cursor", new Object[0]);
                        return i;
                    }
                }
                return i;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        TiebaStatic.a(e2, "DatabaseService.getAccountNum close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "getAccountNum", e3.getMessage());
            TiebaStatic.a(e3, "DatabaseService.getAccountNum", new Object[0]);
            if (cursor != null) {
                try {
                    cursor.close();
                    return 0;
                } catch (Exception e4) {
                    TiebaStatic.a(e4, "DatabaseService.getAccountNum close cursor", new Object[0]);
                    return 0;
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData c() {
        Cursor cursor;
        Exception exc;
        AccountData accountData;
        Cursor cursor2 = null;
        try {
            cursor = new DatabaseManager().a("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
        } catch (Exception e) {
            exc = e;
            accountData = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Exception e2) {
                    accountData = null;
                    cursor2 = cursor;
                    exc = e2;
                }
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
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                TiebaStatic.a(e3, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                            }
                        }
                    } catch (Exception e4) {
                        cursor2 = cursor;
                        exc = e4;
                        accountData = accountData2;
                        try {
                            com.baidu.adp.lib.util.f.b("DatabaseService", "getActiveAccountData", "error = " + exc.getMessage());
                            TiebaStatic.a(exc, "DatabaseService.getActiveAccountData", new Object[0]);
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e5) {
                                    TiebaStatic.a(e5, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                }
                            }
                            return accountData;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                    return accountData;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        TiebaStatic.a(e6, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        }
        accountData = null;
        if (cursor != null) {
        }
        return accountData;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData a(String str) {
        Cursor cursor;
        Throwable th;
        AccountData accountData = null;
        try {
            cursor = new DatabaseManager().a("select * from account_data where account=?", new String[]{str});
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
                                accountData = accountData2;
                                e = e;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getAccountData", "error = " + e.getMessage());
                                TiebaStatic.a(e, "DatabaseService.getAccountData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        TiebaStatic.a(e2, "DatabaseService.getAccountData close cursor", new Object[0]);
                                    }
                                }
                                return accountData;
                            }
                        }
                        cursor.close();
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            TiebaStatic.a(e4, "DatabaseService.getAccountData close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        return accountData;
    }

    public static void a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                new DatabaseManager().a("update account_data set portrait=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "updateAccountPortrait", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.updateAccountPortrait", new Object[0]);
            }
        }
    }

    public static ArrayList<AccountData> d() {
        Cursor cursor = null;
        DatabaseManager databaseManager = new DatabaseManager();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = databaseManager.a("select * from account_data order by time desc", (String[]) null);
                if (cursor != null) {
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
                        arrayList.add(accountData);
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseManager", "getAllAccountData", "error = " + e.getMessage());
                TiebaStatic.a(e, "DatabaseManager.getAllAccountData", new Object[0]);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        TiebaStatic.a(e2, "DatabaseManager.getAllAccountData close cursor", new Object[0]);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    TiebaStatic.a(e3, "DatabaseManager.getAllAccountData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }
}
