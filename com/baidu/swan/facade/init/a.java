package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes8.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences dPm = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a ec(Context context) {
        return new a(context);
    }

    private static SharedPreferences ed(Context context) {
        if (dPm == null) {
            dPm = context.getSharedPreferences("downgradefile", 0);
        }
        return dPm;
    }

    private int ee(Context context) {
        int i = ed(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int ef(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void w(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = ed(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aRs() {
        int ef = ef(this.mContext);
        int ee = ee(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + ef + " /oldVersionCode=" + ee);
        }
        if (ee == 0) {
            ma(ef);
            w(this.mContext, ef);
            x(this.mContext, ee);
        } else if (ef > ee) {
            av(ef, ee);
            w(this.mContext, ef);
            x(this.mContext, ee);
        } else if (ef < ee) {
            ax(ef, ee);
            w(this.mContext, ef);
            x(this.mContext, ee);
        } else {
            aRt();
        }
    }

    private void av(int i, int i2) {
        com.baidu.swan.apps.ao.a.av(i2, i);
        com.baidu.swan.d.a.bhH();
    }

    private void ax(int i, int i2) {
    }

    private void ma(int i) {
        com.baidu.swan.apps.ao.a.av(0, i);
    }

    private void aRt() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + ee(this.mContext));
        }
    }

    public static void x(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = ed(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
