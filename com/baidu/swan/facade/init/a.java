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
    private static SharedPreferences cPc = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a df(Context context) {
        return new a(context);
    }

    private static SharedPreferences dg(Context context) {
        if (cPc == null) {
            cPc = context.getSharedPreferences("downgradefile", 0);
        }
        return cPc;
    }

    private int dh(Context context) {
        int i = dg(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int di(Context context) {
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
        SharedPreferences.Editor edit = dg(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void avj() {
        int di = di(this.mContext);
        int dh = dh(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + di + " /oldVersionCode=" + dh);
        }
        if (dh == 0) {
            hU(di);
            n(this.mContext, di);
            o(this.mContext, dh);
        } else if (di > dh) {
            al(di, dh);
            n(this.mContext, di);
            o(this.mContext, dh);
        } else if (di < dh) {
            an(di, dh);
            n(this.mContext, di);
            o(this.mContext, dh);
        } else {
            avk();
        }
    }

    private void al(int i, int i2) {
        com.baidu.swan.apps.ap.a.al(i2, i);
        com.baidu.swan.f.b.aKf();
    }

    private void an(int i, int i2) {
    }

    private void hU(int i) {
        com.baidu.swan.apps.ap.a.al(0, i);
    }

    private void avk() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dh(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dg(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
