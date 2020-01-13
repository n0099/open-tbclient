package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes10.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences cbx = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dl(Context context) {
        return new a(context);
    }

    private static SharedPreferences dm(Context context) {
        if (cbx == null) {
            cbx = context.getSharedPreferences("downgradefile", 0);
        }
        return cbx;
    }

    private int dn(Context context) {
        int i = dm(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m24do(Context context) {
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

    public void aha() {
        int m24do = m24do(this.mContext);
        int dn = dn(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + m24do + " /oldVersionCode=" + dn);
        }
        if (dn == 0) {
            hf(m24do);
            s(this.mContext, m24do);
            t(this.mContext, dn);
        } else if (m24do > dn) {
            af(m24do, dn);
            s(this.mContext, m24do);
            t(this.mContext, dn);
        } else if (m24do < dn) {
            ak(m24do, dn);
            s(this.mContext, m24do);
            t(this.mContext, dn);
        } else {
            ahb();
        }
    }

    private void af(int i, int i2) {
        com.baidu.swan.apps.ar.a.af(i2, i);
        com.baidu.swan.e.b.aug();
    }

    private void ak(int i, int i2) {
    }

    private void hf(int i) {
        com.baidu.swan.apps.ar.a.af(0, i);
    }

    private void ahb() {
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
