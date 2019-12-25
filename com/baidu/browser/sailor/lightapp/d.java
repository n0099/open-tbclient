package com.baidu.browser.sailor.lightapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ int val$requestCode;
    final /* synthetic */ Intent xf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BdLightappKernelClient bdLightappKernelClient, Intent intent, int i) {
        this.IH = bdLightappKernelClient;
        this.xf = intent;
        this.val$requestCode = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        try {
            if (this.IH.mActivity != null) {
                this.IH.mActivity.startActivityForResult(this.xf, this.val$requestCode);
                this.IH.regLappActivityResultListener();
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BdSailorPlatform.getInstance().getAppContext(), com.baidu.browser.core.g.H("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra = this.xf.getIntExtra("jsaction_key", -1);
            sparseArray = this.IH.mJsCallbacks;
            BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray.get(intExtra);
            if (bdLightappKernelJsCallback != null) {
                bdLightappKernelJsCallback.sendFailCallBack(e.getMessage());
            }
        }
    }
}
