package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes6.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences dYi = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a ev(Context context) {
        return new a(context);
    }

    private static SharedPreferences ew(Context context) {
        if (dYi == null) {
            dYi = context.getSharedPreferences("downgradefile", 0);
        }
        return dYi;
    }

    private int ex(Context context) {
        int i = ew(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int ey(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e(TAG, "error:" + e.getMessage());
            }
            return -1;
        }
    }

    private void x(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set new versioncode:" + i);
        }
        SharedPreferences.Editor edit = ew(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aTN() {
        int ey = ey(this.mContext);
        int ex = ex(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + ey + " /oldVersionCode=" + ex);
        }
        if (ex == 0) {
            mi(ey);
            x(this.mContext, ey);
            y(this.mContext, ex);
        } else if (ey > ex) {
            ar(ey, ex);
            x(this.mContext, ey);
            y(this.mContext, ex);
        } else if (ey < ex) {
            au(ey, ex);
            x(this.mContext, ey);
            y(this.mContext, ex);
        } else {
            aTO();
        }
    }

    private void ar(int i, int i2) {
        com.baidu.swan.apps.an.a.ar(i2, i);
        com.baidu.swan.d.a.bkd();
    }

    private void au(int i, int i2) {
    }

    private void mi(int i) {
        com.baidu.swan.apps.an.a.ar(0, i);
    }

    private void aTO() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + ex(this.mContext));
        }
    }

    public static void y(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = ew(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
