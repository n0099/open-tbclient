package com.baidu.swan.apps.database.subpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.subpackage.SubPackageTable;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a ava;
    private Context mContext = AppRuntime.getAppContext();

    private a() {
    }

    public static a Cb() {
        if (ava == null) {
            synchronized (a.class) {
                if (ava == null) {
                    ava = new a();
                }
            }
        }
        return ava;
    }

    public void ac(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                int delete = this.mContext.getContentResolver().delete(b.avb, SubPackageTable.Table.app_id + "=? AND " + SubPackageTable.Table.version + "=?", new String[]{str, str2});
                if (DEBUG) {
                    Log.e("SubPackageInfoHelper", "clearSubPackageInfo:" + delete);
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e("SubPackageInfoHelper", "clearSubPackageInfo:Error:" + e.getMessage());
                }
            }
        }
    }

    public void ek(String str) {
        if (!TextUtils.isEmpty(str)) {
            int delete = this.mContext.getContentResolver().delete(b.avb, SubPackageTable.Table.app_id + "=?", new String[]{str});
            if (DEBUG) {
                Log.e("SubPackageInfoHelper", "clearAllVersionSubPackageInfo:" + delete);
            }
        }
    }

    public void j(String str, String str2, String str3, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SubPackageTable.Table.app_id.toString(), str);
        contentValues.put(SubPackageTable.Table.version.toString(), str2);
        contentValues.put(SubPackageTable.Table.package_name.toString(), str3);
        contentValues.put(SubPackageTable.Table.is_exist.toString(), (Integer) 1);
        contentValues.put(SubPackageTable.Table.aps_package_name.toString(), str4);
        try {
            this.mContext.getContentResolver().insert(b.avb, contentValues);
        } catch (IllegalArgumentException e) {
            if (DEBUG) {
                Log.e("SubPackageInfoHelper", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m(String str, String str2, String str3) {
        Cursor cursor;
        boolean z = false;
        try {
            cursor = this.mContext.getContentResolver().query(b.avb, new String[]{SubPackageTable.Table.is_exist.toString()}, SubPackageTable.Table.app_id + "=? AND " + SubPackageTable.Table.package_name + "=? AND " + SubPackageTable.Table.version + "=?", new String[]{str, str3, str2}, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToNext()) {
                            z = cursor.getInt(cursor.getColumnIndex(SubPackageTable.Table.is_exist.toString())) == 1;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e("SubPackageInfoHelper", "isSubPackageExist:" + e.getMessage());
                        com.baidu.swan.c.a.c(cursor);
                        if (DEBUG) {
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(cursor);
                    throw th;
                }
            }
            com.baidu.swan.c.a.c(cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.a.c(cursor);
            throw th;
        }
        if (DEBUG) {
            Log.e("SubPackageInfoHelper", str + ":" + str3 + " -> " + z);
        }
        return z;
    }
}
