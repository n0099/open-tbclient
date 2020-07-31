package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes4.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences cYp = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dl(Context context) {
        return new a(context);
    }

    private static SharedPreferences dm(Context context) {
        if (cYp == null) {
            cYp = context.getSharedPreferences("downgradefile", 0);
        }
        return cYp;
    }

    private int dn(Context context) {
        int i = dm(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    /* renamed from: do  reason: not valid java name */
    public static int m29do(Context context) {
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
        SharedPreferences.Editor edit = dm(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void azd() {
        int m29do = m29do(this.mContext);
        int dn = dn(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + m29do + " /oldVersionCode=" + dn);
        }
        if (dn == 0) {
            iv(m29do);
            n(this.mContext, m29do);
            o(this.mContext, dn);
        } else if (m29do > dn) {
            an(m29do, dn);
            n(this.mContext, m29do);
            o(this.mContext, dn);
        } else if (m29do < dn) {
            ap(m29do, dn);
            n(this.mContext, m29do);
            o(this.mContext, dn);
        } else {
            aze();
        }
    }

    private void an(int i, int i2) {
        com.baidu.swan.apps.ap.a.an(i2, i);
        com.baidu.swan.e.b.aOZ();
    }

    private void ap(int i, int i2) {
    }

    private void iv(int i) {
        com.baidu.swan.apps.ap.a.an(0, i);
    }

    private void aze() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dn(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dm(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
