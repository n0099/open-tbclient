package com.baidu.tbadk.core.diskCache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class ImagesInvalidReceiver extends BroadcastReceiver {
    public static final String SUCCESS = "success";

    public static void broadcast(boolean z) {
        Intent intent = new Intent(BdBaseApplication.getInst(), ImagesInvalidReceiver.class);
        intent.putExtra(SUCCESS, z);
        com.baidu.adp.lib.e.c.c(BdBaseApplication.getInst(), intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            ImagesInvalidService.setSuccess(intent.getBooleanExtra(SUCCESS, false));
        }
    }
}
