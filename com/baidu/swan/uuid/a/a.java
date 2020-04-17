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
        sy(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: aoS */
    public String get() {
        return aEy();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean aEx() {
        return (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE") && new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid").exists()) ? false : true;
    }

    private void sy(String str) {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.baidu.swan.uuid.b.a.saveFile(str, new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid"));
        }
    }

    private String aEy() {
        if (TextUtils.equals("mounted", Environment.getExternalStorageState()) && com.baidu.swan.uuid.b.c.hasPermission(this.mContext, "android.permission.READ_EXTERNAL_STORAGE")) {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig"), ".uuid");
            if (file.exists()) {
                return com.baidu.swan.uuid.b.a.l(file);
            }
            return null;
        }
        return null;
    }
}
