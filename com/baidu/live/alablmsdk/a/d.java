package com.baidu.live.alablmsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes10.dex */
public class d {
    private static d awD;
    private static boolean isInited = false;
    private static Context mContext;

    private d() {
    }

    public static d xp() {
        if (awD == null) {
            synchronized (d.class) {
                if (awD == null) {
                    awD = new d();
                }
            }
        }
        return awD;
    }

    public void init(Context context) {
        if (!isInited && context != null) {
            mContext = context.getApplicationContext();
            isInited = true;
        }
    }

    private SharedPreferences getSp() {
        if (isInited) {
            return mContext.getSharedPreferences("bd_lm_sdk_sp", 0);
        }
        return null;
    }

    public void putString(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sp = getSp();
        if (sp != null && (edit = sp.edit()) != null) {
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public String getString(String str) {
        return getSp() == null ? "" : getSp().getString(str, "");
    }
}
