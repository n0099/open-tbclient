package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences cfD = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dp(Context context) {
        return new a(context);
    }

    private static SharedPreferences dq(Context context) {
        if (cfD == null) {
            cfD = context.getSharedPreferences("downgradefile", 0);
        }
        return cfD;
    }

    private int dr(Context context) {
        int i = dq(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int ds(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void s(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = dq(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void ajq() {
        int ds = ds(this.mContext);
        int dr = dr(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + ds + " /oldVersionCode=" + dr);
        }
        if (dr == 0) {
            hw(ds);
            s(this.mContext, ds);
            t(this.mContext, dr);
        } else if (ds > dr) {
            af(ds, dr);
            s(this.mContext, ds);
            t(this.mContext, dr);
        } else if (ds < dr) {
            ak(ds, dr);
            s(this.mContext, ds);
            t(this.mContext, dr);
        } else {
            ajr();
        }
    }

    private void af(int i, int i2) {
        com.baidu.swan.apps.ar.a.af(i2, i);
        com.baidu.swan.e.b.aww();
    }

    private void ak(int i, int i2) {
    }

    private void hw(int i) {
        com.baidu.swan.apps.ar.a.af(0, i);
    }

    private void ajr() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dr(this.mContext));
        }
    }

    public static void t(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dq(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
