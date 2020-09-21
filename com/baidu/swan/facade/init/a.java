package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes3.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences djB = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dq(Context context) {
        return new a(context);
    }

    private static SharedPreferences dr(Context context) {
        if (djB == null) {
            djB = context.getSharedPreferences("downgradefile", 0);
        }
        return djB;
    }

    private int ds(Context context) {
        int i = dr(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dt(Context context) {
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
        SharedPreferences.Editor edit = dr(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aHS() {
        int dt = dt(this.mContext);
        int ds = ds(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dt + " /oldVersionCode=" + ds);
        }
        if (ds == 0) {
            kO(dt);
            n(this.mContext, dt);
            o(this.mContext, ds);
        } else if (dt > ds) {
            at(dt, ds);
            n(this.mContext, dt);
            o(this.mContext, ds);
        } else if (dt < ds) {
            av(dt, ds);
            n(this.mContext, dt);
            o(this.mContext, ds);
        } else {
            aHT();
        }
    }

    private void at(int i, int i2) {
        com.baidu.swan.apps.ao.a.at(i2, i);
        com.baidu.swan.d.a.aYi();
    }

    private void av(int i, int i2) {
    }

    private void kO(int i) {
        com.baidu.swan.apps.ao.a.at(0, i);
    }

    private void aHT() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + ds(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dr(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
