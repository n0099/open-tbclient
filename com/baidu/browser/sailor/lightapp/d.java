package com.baidu.browser.sailor.lightapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class d implements Runnable {
    final /* synthetic */ Intent Ru;
    final /* synthetic */ BdLightappKernelClient adq;
    final /* synthetic */ int val$requestCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdLightappKernelClient bdLightappKernelClient, Intent intent, int i) {
        this.adq = bdLightappKernelClient;
        this.Ru = intent;
        this.val$requestCode = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        try {
            if (this.adq.mActivity != null) {
                this.adq.mActivity.startActivityForResult(this.Ru, this.val$requestCode);
                this.adq.regLappActivityResultListener();
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BdSailorPlatform.getInstance().getAppContext(), com.baidu.browser.core.g.N("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra = this.Ru.getIntExtra("jsaction_key", -1);
            sparseArray = this.adq.mJsCallbacks;
            BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(intExtra);
            if (bdLightappKernelJsCallback != null) {
                bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            }
        }
    }
}
