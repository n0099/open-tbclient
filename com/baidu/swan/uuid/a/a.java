package com.baidu.swan.uuid.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes11.dex */
public class a implements b<String> {
    private Context mContext;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("context can no be null");
        }
        this.mContext = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
        uk(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: auy */
    public String get() {
        return aKm();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean aKl() {
        return (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE") && new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists()) ? false : true;
    }

    private void uk(String str) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.baidu.swan.uuid.b.a.saveFile(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }

    private String aKm() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE")) {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
            if (file.exists()) {
                return com.baidu.swan.uuid.b.a.p(file);
            }
            return null;
        }
        return null;
    }
}
