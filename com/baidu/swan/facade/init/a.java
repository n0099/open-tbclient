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
    private static SharedPreferences dXd = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a es(Context context) {
        return new a(context);
    }

    private static SharedPreferences et(Context context) {
        if (dXd == null) {
            dXd = context.getSharedPreferences("downgradefile", 0);
        }
        return dXd;
    }

    private int eu(Context context) {
        int i = et(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int ev(Context context) {
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
        SharedPreferences.Editor edit = et(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aQq() {
        int ev = ev(this.mContext);
        int eu = eu(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + ev + " /oldVersionCode=" + eu);
        }
        if (eu == 0) {
            kG(ev);
            x(this.mContext, ev);
            y(this.mContext, eu);
        } else if (ev > eu) {
            ao(ev, eu);
            x(this.mContext, ev);
            y(this.mContext, eu);
        } else if (ev < eu) {
            ar(ev, eu);
            x(this.mContext, ev);
            y(this.mContext, eu);
        } else {
            aQr();
        }
    }

    private void ao(int i, int i2) {
        com.baidu.swan.apps.an.a.ao(i2, i);
        com.baidu.swan.d.a.bgz();
    }

    private void ar(int i, int i2) {
    }

    private void kG(int i) {
        com.baidu.swan.apps.an.a.ao(0, i);
    }

    private void aQr() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + eu(this.mContext));
        }
    }

    public static void y(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = et(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
