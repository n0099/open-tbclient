package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
/* loaded from: classes7.dex */
public class c {
    final String cPj;
    final String cPk;
    final String cPl;
    final int mDataType;

    c(String str, int i, String str2, String str3) {
        this.cPj = str;
        this.mDataType = i;
        this.cPk = str2;
        this.cPl = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c W(Bundle bundle) {
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
        return "SpMethodInfo{mDataType=" + this.mDataType + ", mPrefName='" + this.cPk + "', mDataValue='" + this.cPl + "'}";
    }
}
