package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {
    final int aVQ;
    final String aVR;
    final String aVS;

    a(int i, String str, String str2) {
        this.aVQ = i;
        this.aVR = str;
        this.aVS = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a y(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        return new a(bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
    }

    public static Bundle e(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_prefs_key", str);
        bundle.putInt("bundle_data_type_key", i);
        bundle.putString("bundle_data_value_key", str2);
        return bundle;
    }

    public String toString() {
        return "SpMethodInfo{mDataType=" + this.aVQ + ", mPrefName='" + this.aVR + "', mDataValue='" + this.aVS + "'}";
    }
}
