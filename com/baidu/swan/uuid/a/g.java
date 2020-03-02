package com.baidu.swan.uuid.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
/* loaded from: classes11.dex */
public class g implements b<String> {
    private Context mContext;

    public g(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        this.mContext = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
        rn(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: agJ */
    public String get() {
        return awp();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean awj() {
        return TextUtils.isEmpty(get());
    }

    private void rn(String str) {
        if (com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.WRITE_SETTINGS")) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "com.baidu.uuid", str);
            } catch (Exception e) {
            }
        }
    }

    private String awp() {
        if (com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.WRITE_SETTINGS")) {
            try {
                return Settings.System.getString(this.mContext.getContentResolver(), "com.baidu.uuid");
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
