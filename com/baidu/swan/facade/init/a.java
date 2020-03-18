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
    private static SharedPreferences cfP = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    /* renamed from: do  reason: not valid java name */
    public static a m27do(Context context) {
        return new a(context);
    }

    private static SharedPreferences dp(Context context) {
        if (cfP == null) {
            cfP = context.getSharedPreferences("downgradefile", 0);
        }
        return cfP;
    }

    private int dq(Context context) {
        int i = dp(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dr(Context context) {
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
        SharedPreferences.Editor edit = dp(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void ajt() {
        int dr = dr(this.mContext);
        int dq = dq(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dr + " /oldVersionCode=" + dq);
        }
        if (dq == 0) {
            hw(dr);
            s(this.mContext, dr);
            t(this.mContext, dq);
        } else if (dr > dq) {
            af(dr, dq);
            s(this.mContext, dr);
            t(this.mContext, dq);
        } else if (dr < dq) {
            ak(dr, dq);
            s(this.mContext, dr);
            t(this.mContext, dq);
        } else {
            aju();
        }
    }

    private void af(int i, int i2) {
        com.baidu.swan.apps.ar.a.af(i2, i);
        com.baidu.swan.e.b.awz();
    }

    private void ak(int i, int i2) {
    }

    private void hw(int i) {
        com.baidu.swan.apps.ar.a.af(0, i);
    }

    private void aju() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dq(this.mContext));
        }
    }

    public static void t(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dp(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
