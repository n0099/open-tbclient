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
    private static SharedPreferences cEN = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dc(Context context) {
        return new a(context);
    }

    private static SharedPreferences dd(Context context) {
        if (cEN == null) {
            cEN = context.getSharedPreferences("downgradefile", 0);
        }
        return cEN;
    }

    private int de(Context context) {
        int i = dd(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int df(Context context) {
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
        SharedPreferences.Editor edit = dd(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void arB() {
        int df = df(this.mContext);
        int de2 = de(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + df + " /oldVersionCode=" + de2);
        }
        if (de2 == 0) {
            hD(df);
            n(this.mContext, df);
            o(this.mContext, de2);
        } else if (df > de2) {
            ai(df, de2);
            n(this.mContext, df);
            o(this.mContext, de2);
        } else if (df < de2) {
            an(df, de2);
            n(this.mContext, df);
            o(this.mContext, de2);
        } else {
            arC();
        }
    }

    private void ai(int i, int i2) {
        com.baidu.swan.apps.ar.a.ai(i2, i);
        com.baidu.swan.e.b.aEK();
    }

    private void an(int i, int i2) {
    }

    private void hD(int i) {
        com.baidu.swan.apps.ar.a.ai(0, i);
    }

    private void arC() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + de(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dd(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
