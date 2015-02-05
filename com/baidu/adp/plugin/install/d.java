package com.baidu.adp.plugin.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BroadcastReceiver {
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.this$0 = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("package_name");
            if (!TextUtils.isEmpty(stringExtra)) {
                String stringExtra2 = intent.getStringExtra("install_src_file");
                boolean z = stringExtra2 != null && stringExtra2.startsWith("assets://");
                String action = intent.getAction();
                if (!"com.baidu.adp.plugin.installed".equals(action)) {
                    if ("com.baidu.adp.plugin.installfail".equals(action)) {
                        if (z) {
                            this.this$0.so = false;
                        }
                        this.this$0.e(stringExtra, z);
                        return;
                    }
                    return;
                }
                this.this$0.e(stringExtra, z);
            }
        }
    }
}
