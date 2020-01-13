package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
/* loaded from: classes10.dex */
public class c {
    final String bRO;
    final int bRP;
    final String bRQ;
    final String bRR;

    c(String str, int i, String str2, String str3) {
        this.bRO = str;
        this.bRP = i;
        this.bRQ = str2;
        this.bRR = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c P(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        return new c(bundle.getString("bundle_sp_name_key"), bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
    }

    public static Bundle b(String str, int i, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_sp_name_key", str);
        bundle.putString("bundle_prefs_key", str2);
        bundle.putInt("bundle_data_type_key", i);
        bundle.putString("bundle_data_value_key", str3);
        return bundle;
    }

    public String toString() {
        return "SpMethodInfo{mDataType=" + this.bRP + ", mPrefName='" + this.bRQ + "', mDataValue='" + this.bRR + "'}";
    }
}
