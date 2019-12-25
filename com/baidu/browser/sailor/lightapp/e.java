package com.baidu.browser.sailor.lightapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class e implements Runnable {
    final /* synthetic */ BdLightappKernelClient IH;
    final /* synthetic */ Intent xf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BdLightappKernelClient bdLightappKernelClient, Intent intent) {
        this.IH = bdLightappKernelClient;
        this.xf = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        try {
            if (this.IH.mActivity != null) {
                this.IH.mActivity.startActivity(this.xf);
                int intExtra = this.xf.getIntExtra("jsaction_key", -1);
                if (12 == intExtra) {
                    sparseArray3 = this.IH.mJsCallbacks;
                    BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray3.get(intExtra);
                    if (bdLightappKernelJsCallback != null) {
                        bdLightappKernelJsCallback.sendSuccCallBack();
                        sparseArray4 = this.IH.mJsCallbacks;
                        sparseArray4.remove(intExtra);
                    }
                }
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BdSailorPlatform.getInstance().getAppContext(), com.baidu.browser.core.g.H("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra2 = this.xf.getIntExtra("jsaction_key", -1);
            sparseArray = this.IH.mJsCallbacks;
            BdLightappKernelJsCallback bdLightappKernelJsCallback2 = (BdLightappKernelJsCallback) sparseArray.get(intExtra2);
            if (bdLightappKernelJsCallback2 != null) {
                bdLightappKernelJsCallback2.sendFailCallBack(e.getMessage());
                sparseArray2 = this.IH.mJsCallbacks;
                sparseArray2.remove(intExtra2);
            }
        }
    }
}
