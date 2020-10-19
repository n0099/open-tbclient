package com.baidu.swan.facade.init;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes16.dex */
public class a {
    private Context mContext;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = b.DEBUG;
    private static SharedPreferences dvH = null;

    private a(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public static a dw(Context context) {
        return new a(context);
    }

    private static SharedPreferences dx(Context context) {
        if (dvH == null) {
            dvH = context.getSharedPreferences("downgradefile", 0);
        }
        return dvH;
    }

    private int dy(Context context) {
        int i = dx(context).getInt("old_versioncode_key", 0);
        if (DEBUG) {
            Log.d(TAG, "get old versioncode:" + i);
        }
        return i;
    }

    public static int dz(Context context) {
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
        SharedPreferences.Editor edit = dx(context).edit();
        edit.putInt("old_versioncode_key", i);
        edit.apply();
    }

    public void aKB() {
        int dz = dz(this.mContext);
        int dy = dy(this.mContext);
        if (DEBUG) {
            Log.d(TAG, "处理升级逻辑：newVersionCode=" + dz + " /oldVersionCode=" + dy);
        }
        if (dy == 0) {
            ll(dz);
            n(this.mContext, dz);
            o(this.mContext, dy);
        } else if (dz > dy) {
            as(dz, dy);
            n(this.mContext, dz);
            o(this.mContext, dy);
        } else if (dz < dy) {
            au(dz, dy);
            n(this.mContext, dz);
            o(this.mContext, dy);
        } else {
            aKC();
        }
    }

    private void as(int i, int i2) {
        com.baidu.swan.apps.ao.a.as(i2, i);
        com.baidu.swan.d.a.baQ();
    }

    private void au(int i, int i2) {
    }

    private void ll(int i) {
        com.baidu.swan.apps.ao.a.as(0, i);
    }

    private void aKC() {
        if (DEBUG) {
            Log.d(TAG, "新旧版本一样:" + dy(this.mContext));
        }
    }

    public static void o(Context context, int i) {
        if (DEBUG) {
            Log.d(TAG, "set last version code:" + i);
        }
        SharedPreferences.Editor edit = dx(context).edit();
        edit.putInt("last_versioncode_key", i);
        edit.apply();
    }
}
