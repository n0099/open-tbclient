package com.baidu.browser.sailor.a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.webkit.sdk.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f implements Runnable {
    final /* synthetic */ Intent Kn;
    final /* synthetic */ c Wh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, Intent intent) {
        this.Wh = cVar;
        this.Kn = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        SparseArray sparseArray;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        try {
            if (this.Wh.mActivity != null) {
                this.Wh.mActivity.startActivity(this.Kn);
                int intExtra = this.Kn.getIntExtra("jsaction_key", -1);
                if (12 == intExtra) {
                    sparseArray3 = this.Wh.Wf;
                    n nVar = (n) sparseArray3.get(intExtra);
                    if (nVar != null) {
                        nVar.qO();
                        sparseArray4 = this.Wh.Wf;
                        sparseArray4.remove(intExtra);
                    }
                }
            } else {
                Log.w("BdLightappKernelClient", "mActivity is null.");
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(com.baidu.browser.sailor.b.a.qP().getAppContext(), com.baidu.browser.core.b.R("string", "sailor_msg_activity_not_found"), 0).show();
            int intExtra2 = this.Kn.getIntExtra("jsaction_key", -1);
            sparseArray = this.Wh.Wf;
            n nVar2 = (n) sparseArray.get(intExtra2);
            if (nVar2 != null) {
                nVar2.cA(e.getMessage());
                sparseArray2 = this.Wh.Wf;
                sparseArray2.remove(intExtra2);
            }
        }
    }
}
