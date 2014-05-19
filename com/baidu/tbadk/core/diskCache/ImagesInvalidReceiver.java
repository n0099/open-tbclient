package com.baidu.tbadk.core.diskCache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class ImagesInvalidReceiver extends BroadcastReceiver {
    public static void a(boolean z) {
        Intent intent = new Intent(com.baidu.adp.base.a.getInst(), ImagesInvalidReceiver.class);
        intent.putExtra("success", z);
        com.baidu.adp.lib.f.c.c(com.baidu.adp.base.a.getInst(), intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            ImagesInvalidService.a(intent.getBooleanExtra("success", false));
        }
    }
}
