package com.baidu.browser.sailor.a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements Runnable {
    final /* synthetic */ Intent Kn;
    final /* synthetic */ c Wh;
    final /* synthetic */ int val$requestCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, Intent intent, int i) {
        this.Wh = cVar;
        this.Kn = intent;
        this.val$requestCode = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        try {
            if (this.Wh.mActivity != null) {
                this.Wh.mActivity.startActivityForResult(this.Kn, this.val$requestCode);
                this.Wh.qI();
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.browser.sailor.b.a.qO().getAppContext(), com.baidu.browser.core.b.R("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra = this.Kn.getIntExtra("jsaction_key", -1);
            sparseArray = this.Wh.Wf;
            n nVar = (n) sparseArray.get(intExtra);
            if (nVar != null) {
                nVar.cA(e.getMessage());
            }
        }
    }
}
