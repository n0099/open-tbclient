package com.baidu.mobads.container.download.activate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes2.dex */
public class XSharedPreferences {
    public Context mAppliContext;
    public String mName;

    public XSharedPreferences(Context context, String str) {
        this.mAppliContext = context.getApplicationContext();
        this.mName = str;
    }

    private SharedPreferences getSP() throws Exception {
        return this.mAppliContext.getSharedPreferences(this.mName, 0);
    }

    private SharedPreferences.Editor getSPEditor() throws Exception {
        return getSP().edit();
    }

    public void delete(String str) {
        try {
            SharedPreferences.Editor sPEditor = getSPEditor();
            sPEditor.remove(str);
            if (Build.VERSION.SDK_INT >= 9) {
                sPEditor.apply();
            } else {
                sPEditor.commit();
            }
        } catch (Exception unused) {
        }
    }

    public Long getLongValue(String str) {
        try {
            return Long.valueOf(getSP().getLong(str, 0L));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getValue(String str) {
        try {
            return getSP().getString(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    @TargetApi(9)
    public void putLong(String str, Long l) {
        try {
            SharedPreferences.Editor sPEditor = getSPEditor();
            sPEditor.putLong(str, l.longValue());
            if (Build.VERSION.SDK_INT >= 9) {
                sPEditor.apply();
            } else {
                sPEditor.commit();
            }
        } catch (Exception unused) {
        }
    }

    @TargetApi(9)
    public void putString(String str, String str2) {
        try {
            SharedPreferences.Editor sPEditor = getSPEditor();
            sPEditor.putString(str, str2);
            if (Build.VERSION.SDK_INT >= 9) {
                sPEditor.apply();
            } else {
                sPEditor.commit();
            }
        } catch (Exception unused) {
        }
    }
}
