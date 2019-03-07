package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
/* loaded from: classes2.dex */
public class a {
    final int aSW;
    final String aSX;
    final String aSY;

    a(int i, String str, String str2) {
        this.aSW = i;
        this.aSX = str;
        this.aSY = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a x(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        return new a(bundle.getInt("bundle_data_type_key"), bundle.getString("bundle_prefs_key"), bundle.getString("bundle_data_value_key"));
    }

    public static Bundle d(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("bundle_prefs_key", str);
        bundle.putInt("bundle_data_type_key", i);
        bundle.putString("bundle_data_value_key", str2);
        return bundle;
    }

    public String toString() {
        return "SpMethodInfo{mDataType=" + this.aSW + ", mPrefName='" + this.aSX + "', mDataValue='" + this.aSY + "'}";
    }
}
