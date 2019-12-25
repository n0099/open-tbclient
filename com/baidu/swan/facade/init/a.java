package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes9.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences cbk = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dl(Context context) {
        return new a(context);
    }

    private static SharedPreferences dm(Context context) {
        if (cbk == null) {
            cbk = context.getSharedPreferences("downgradefile", 0);
        }
        return cbk;
    }

    private int dn(Context context) {
        int i = dm(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m21do(Context context) {
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
        SharedPreferences.Editor edit = dm(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void agH() {
        int m21do = m21do(this.mContext);
        int dn = dn(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + m21do + " /oldVersionCode=" + dn);
        }
        if (dn == 0) {
            hf(m21do);
            s(this.mContext, m21do);
            t(this.mContext, dn);
        } else if (m21do > dn) {
            ab(m21do, dn);
            s(this.mContext, m21do);
            t(this.mContext, dn);
        } else if (m21do < dn) {
            ag(m21do, dn);
            s(this.mContext, m21do);
            t(this.mContext, dn);
        } else {
            agI();
        }
    }

    private void ab(int i, int i2) {
        com.baidu.swan.apps.ar.a.ab(i2, i);
        com.baidu.swan.e.b.atN();
    }

    private void ag(int i, int i2) {
    }

    private void hf(int i) {
        com.baidu.swan.apps.ar.a.ab(0, i);
    }

    private void agI() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dn(this.mContext));
        }
    }

    public static void t(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dm(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
