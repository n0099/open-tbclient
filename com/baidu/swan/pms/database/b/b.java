package com.baidu.swan.pms.database.b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class b implements a<PMSAppInfo> {
    private static final int bsW = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;

    public String atx() {
        return "swan_app";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aty());
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    q(sQLiteDatabase);
                    break;
                case 4:
                    n(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private String aty() {
        return "CREATE TABLE " + atx() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.APP_ID + " TEXT UNIQUE,app_key TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0," + SharedPrefConfig.VERSION_NAME + " TEXT,description TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT,bear_info TEXT,server_ext TEXT,pay_protected INTEGER,customer_service INTEGER,global_notice INTEGER,global_private INTEGER,pa_number TEXT);";
    }

    private void q(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + atx() + " ADD pay_protected INTEGER default " + bsW + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        } catch (SQLException e) {
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + atx() + " ADD customer_service INTEGER default " + PMSConstants.PayProtected.NO_PAY_PROTECTED.type + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + atx() + " ADD global_notice INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + atx() + " ADD global_private INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + atx() + " ADD pa_number TEXT;");
        } catch (SQLException e) {
        }
    }
}
