package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes20.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences dhy = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dr(Context context) {
        return new a(context);
    }

    private static SharedPreferences ds(Context context) {
        if (dhy == null) {
            dhy = context.getSharedPreferences("downgradefile", 0);
        }
        return dhy;
    }

    private int dt(Context context) {
        int i = ds(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int du(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void n(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = ds(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aHi() {
        int du = du(this.mContext);
        int dt = dt(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + du + " /oldVersionCode=" + dt);
        }
        if (dt == 0) {
            kD(du);
            n(this.mContext, du);
            o(this.mContext, dt);
        } else if (du > dt) {
            at(du, dt);
            n(this.mContext, du);
            o(this.mContext, dt);
        } else if (du < dt) {
            av(du, dt);
            n(this.mContext, du);
            o(this.mContext, dt);
        } else {
            aHj();
        }
    }

    private void at(int i, int i2) {
        com.baidu.swan.apps.ao.a.at(i2, i);
        com.baidu.swan.d.a.aXw();
    }

    private void av(int i, int i2) {
    }

    private void kD(int i) {
        com.baidu.swan.apps.ao.a.at(0, i);
    }

    private void aHj() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dt(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = ds(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
