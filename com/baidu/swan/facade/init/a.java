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
    private static SharedPreferences cTM = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dg(Context context) {
        return new a(context);
    }

    private static SharedPreferences dh(Context context) {
        if (cTM == null) {
            cTM = context.getSharedPreferences("downgradefile", 0);
        }
        return cTM;
    }

    private int di(Context context) {
        int i = dh(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dj(Context context) {
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
        SharedPreferences.Editor edit = dh(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void awp() {
        int dj = dj(this.mContext);
        int di = di(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dj + " /oldVersionCode=" + di);
        }
        if (di == 0) {
            ih(dj);
            n(this.mContext, dj);
            o(this.mContext, di);
        } else if (dj > di) {
            an(dj, di);
            n(this.mContext, dj);
            o(this.mContext, di);
        } else if (dj < di) {
            ap(dj, di);
            n(this.mContext, dj);
            o(this.mContext, di);
        } else {
            awq();
        }
    }

    private void an(int i, int i2) {
        com.baidu.swan.apps.ap.a.an(i2, i);
        com.baidu.swan.f.b.aLl();
    }

    private void ap(int i, int i2) {
    }

    private void ih(int i) {
        com.baidu.swan.apps.ap.a.an(0, i);
    }

    private void awq() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + di(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dh(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
