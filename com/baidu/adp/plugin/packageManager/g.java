package com.baidu.adp.plugin.packageManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        boolean z;
        boolean z2 = true;
        if (intent != null && "com.baidu.adp.plugin.currentpath".equals(intent.getAction())) {
            Bundle resultExtras = getResultExtras(true);
            String str3 = "";
            if (resultExtras != null) {
                str3 = resultExtras.getString("package_name");
            }
            if (!TextUtils.isEmpty(str3) && resultExtras != null) {
                str = str3;
                str2 = resultExtras.getString("current_path");
            } else if (intent.getExtras() == null) {
                str = str3;
                str2 = "";
            } else {
                str = intent.getExtras().getString("package_name");
                str2 = intent.getExtras().getString("current_path");
            }
            String str4 = "";
            if (PluginCenter.getInstance().getPlugin(str) != null) {
                str4 = PluginCenter.getInstance().getPlugin(str).getPluginApkFilePath();
            }
            if (!TextUtils.isEmpty(str4)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = str4;
                } else {
                    String[] split = str2.split(",");
                    int length = split.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            if (split[i].equals(str4)) {
                                break;
                            }
                            i++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2) {
                        str2 = String.valueOf(str2) + "," + str4;
                    }
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("package_name", str);
            bundle.putString("current_path", str2);
            setResultExtras(bundle);
            z = this.this$0.vo;
            if (!z) {
                return;
            }
            this.this$0.G(str, str2);
        }
    }
}
