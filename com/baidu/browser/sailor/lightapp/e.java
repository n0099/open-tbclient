package com.baidu.browser.sailor.lightapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class e implements Runnable {
    final /* synthetic */ Intent QS;
    final /* synthetic */ BdLightappKernelClient acL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BdLightappKernelClient bdLightappKernelClient, Intent intent) {
        this.acL = bdLightappKernelClient;
        this.QS = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        try {
            if (this.acL.mActivity != null) {
                this.acL.mActivity.startActivity(this.QS);
                int intExtra = this.QS.getIntExtra("jsaction_key", -1);
                if (12 == intExtra) {
                    sparseArray3 = this.acL.mJsCallbacks;
                    BdLightappKernelJsCallback bdLightappKernelJsCallback = (BdLightappKernelJsCallback) sparseArray3.get(intExtra);
                    if (bdLightappKernelJsCallback != null) {
                        bdLightappKernelJsCallback.sendSuccCallBack();
                        sparseArray4 = this.acL.mJsCallbacks;
                        sparseArray4.remove(intExtra);
                    }
                }
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BdSailorPlatform.getInstance().getAppContext(), com.baidu.browser.core.g.N("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra2 = this.QS.getIntExtra("jsaction_key", -1);
            sparseArray = this.acL.mJsCallbacks;
            BdLightappKernelJsCallback bdLightappKernelJsCallback2 = (BdLightappKernelJsCallback) sparseArray.get(intExtra2);
            if (bdLightappKernelJsCallback2 != null) {
                bdLightappKernelJsCallback2.sendFailCallBack(e.getMessage());
                sparseArray2 = this.acL.mJsCallbacks;
                sparseArray2.remove(intExtra2);
            }
        }
    }
}
