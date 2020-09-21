package com.baidu.swan.pms.database.b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes24.dex */
public class b implements a<PMSAppInfo> {
    private static final int cqs = PMSConstants.PayProtected.NO_PAY_PROTECTED.type;

    public String aUj() {
        return "swan_app";
    }

    @Override // com.baidu.swan.pms.database.b.a
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(aUk());
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
                case 6:
                    A(sQLiteDatabase);
                    break;
                case 7:
                    B(sQLiteDatabase);
                    break;
                case 8:
                    C(sQLiteDatabase);
                    break;
                case 9:
                    D(sQLiteDatabase);
                    break;
            }
            i++;
        }
    }

    private String aUk() {
        return "CREATE TABLE " + aUj() + "(" + IMConstants.MSG_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT UNIQUE,app_key TEXT NOT NULL,app_sign LONG DEFAULT 0,version_code INTEGER DEFAULT 0," + SharedPrefConfig.VERSION_NAME + " TEXT,description TEXT,app_status INTEGER,status_detail TEXT,status_desc TEXT,resume_date TEXT,icon_url TEXT,app_name TEXT NOT NULL,service_category TEXT,subject_info TEXT,type INTEGER,pkg_size LONG,pending_err_code INTEGER,app_category INTEGER,orientation INTEGER,max_age LONG,create_time LONG,webview_domains TEXT,web_action TEXT,domains TEXT,bear_info TEXT,server_ext TEXT,pay_protected INTEGER,customer_service INTEGER,global_notice INTEGER,global_private INTEGER,pa_number TEXT," + Constants.PHONE_BRAND + " TEXT,last_launch_time LONG DEFAULT 0,launch_count INTEGER DEFAULT 0,install_src INTEGER DEFAULT 0,web_url TEXT,quick_app_key TEXT,cs_protocol_version INTEGER DEFAULT 0);";
    }

    private void q(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD pay_protected INTEGER default " + cqs + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        } catch (SQLException e) {
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD customer_service INTEGER default " + PMSConstants.PayProtected.NO_PAY_PROTECTED.type + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD global_notice INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD global_private INTEGER default " + PMSConstants.CloudSwitch.NO_DISPLAY.value + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD pa_number TEXT;");
        } catch (SQLException e) {
        }
    }

    private void A(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD " + Constants.PHONE_BRAND + " TEXT;");
        } catch (SQLException e) {
        }
    }

    private void B(SQLiteDatabase sQLiteDatabase) {
        try {
            String aUj = aUj();
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj + " ADD last_launch_time LONG DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj + " ADD launch_count INTEGER DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj + " ADD install_src INTEGER DEFAULT 0;");
        } catch (SQLException e) {
        }
    }

    private void C(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD web_url TEXT;");
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD quick_app_key TEXT;");
        } catch (SQLException e) {
        }
    }

    private void D(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE " + aUj() + " ADD cs_protocol_version INTEGER DEFAULT 0;");
        } catch (SQLException e) {
        }
    }
}
