package com.baidu.swan.uuid.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements b<String> {
    private Context mContext;

    public d(Context context) {
        if (context == null) {
            throw new RuntimeException("context can not be null");
        }
        this.mContext = context.getApplicationContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    public void put(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.uuid.a.b
    /* renamed from: aea */
    public String get() {
        return atC();
    }

    @Override // com.baidu.swan.uuid.a.b
    public boolean atA() {
        return false;
    }

    private String atC() {
        String str = null;
        List<ResolveInfo> queryBroadcastReceivers = this.mContext.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.UUID"), 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null && !this.mContext.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                File file = new File(new File(resolveInfo.activityInfo.applicationInfo.dataDir, com.baidu.fsg.face.base.b.c.g), "libuuid.so");
                String fileContent = file.exists() ? com.baidu.swan.uuid.b.a.getFileContent(file) : str;
                if (!TextUtils.isEmpty(fileContent)) {
                    return fileContent;
                }
                str = fileContent;
            }
        }
        return str;
    }
}
