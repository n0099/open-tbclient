package com.baidu.browser.sailor.platform.nativeability;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class d extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        SparseArray sparseArray;
        sparseArray = a.b;
        BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(10);
        int intExtra = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        int intExtra3 = intent.getIntExtra("plugged", 0);
        bdLightappKernelJsCallback.addField(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, String.valueOf(intExtra2 != 0 ? intExtra / intExtra2 : 0.0f));
        bdLightappKernelJsCallback.addField("plugged", String.valueOf(intExtra3 != 0));
        bdLightappKernelJsCallback.sendSuccCallBack();
    }
}
