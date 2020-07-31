package com.baidu.browser.sailor.lightapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class d implements Runnable {
    final /* synthetic */ Intent Rr;
    final /* synthetic */ BdLightappKernelClient adk;
    final /* synthetic */ int val$requestCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdLightappKernelClient bdLightappKernelClient, Intent intent, int i) {
        this.adk = bdLightappKernelClient;
        this.Rr = intent;
        this.val$requestCode = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        try {
            if (this.adk.mActivity != null) {
                this.adk.mActivity.startActivityForResult(this.Rr, this.val$requestCode);
                this.adk.regLappActivityResultListener();
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BdSailorPlatform.getInstance().getAppContext(), com.baidu.browser.core.g.M("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra = this.Rr.getIntExtra("jsaction_key", -1);
            sparseArray = this.adk.mJsCallbacks;
            BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(intExtra);
            if (bdLightappKernelJsCallback != null) {
                bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            }
        }
    }
}
