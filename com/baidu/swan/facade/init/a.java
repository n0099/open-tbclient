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
    private static SharedPreferences dVC = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a et(Context context) {
        return new a(context);
    }

    private static SharedPreferences eu(Context context) {
        if (dVC == null) {
            dVC = context.getSharedPreferences("downgradefile", 0);
        }
        return dVC;
    }

    private int ev(Context context) {
        int i = eu(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int ew(Context context) {
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
        SharedPreferences.Editor edit = eu(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aQn() {
        int ew = ew(this.mContext);
        int ev = ev(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + ew + " /oldVersionCode=" + ev);
        }
        if (ev == 0) {
            kF(ew);
            x(this.mContext, ew);
            y(this.mContext, ev);
        } else if (ew > ev) {
            ao(ew, ev);
            x(this.mContext, ew);
            y(this.mContext, ev);
        } else if (ew < ev) {
            ar(ew, ev);
            x(this.mContext, ew);
            y(this.mContext, ev);
        } else {
            aQo();
        }
    }

    private void ao(int i, int i2) {
        com.baidu.swan.apps.an.a.ao(i2, i);
        com.baidu.swan.d.a.bgx();
    }

    private void ar(int i, int i2) {
    }

    private void kF(int i) {
        com.baidu.swan.apps.an.a.ao(0, i);
    }

    private void aQo() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + ev(this.mContext));
        }
    }

    public static void y(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = eu(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
