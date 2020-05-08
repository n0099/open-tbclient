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
    private static SharedPreferences cET = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a cQ(Context context) {
        return new a(context);
    }

    private static SharedPreferences cR(Context context) {
        if (cET == null) {
            cET = context.getSharedPreferences("downgradefile", 0);
        }
        return cET;
    }

    private int cS(Context context) {
        int i = cR(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int cT(Context context) {
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
        SharedPreferences.Editor edit = cR(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void arA() {
        int cT = cT(this.mContext);
        int cS = cS(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + cT + " /oldVersionCode=" + cS);
        }
        if (cS == 0) {
            hD(cT);
            n(this.mContext, cT);
            o(this.mContext, cS);
        } else if (cT > cS) {
            ai(cT, cS);
            n(this.mContext, cT);
            o(this.mContext, cS);
        } else if (cT < cS) {
            an(cT, cS);
            n(this.mContext, cT);
            o(this.mContext, cS);
        } else {
            arB();
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

    private void arB() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + cS(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = cR(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
