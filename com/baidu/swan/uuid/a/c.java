package com.baidu.swan.uuid.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public class c implements b<String> {
    private Context mContext;

    public c(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.mContext).edit();
        edit.putString("uuid_identity", str);
        edit.apply();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: aNu */
    public String get() {
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString("uuid_identity", null);
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean bfp() {
        return TextUtils.isEmpty(get());
    }
}
