package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AlaLiveUserNotifyController {
    private AlaLiveUserNotifyDialog mBdAlertDialog;
    private TbPageContext mTbPageContext;

    public AlaLiveUserNotifyController(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void showNextNotifyDialog(int i, ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (i >= 0 && i < y.getCount(arrayList)) {
            showNotifyDialog(i, arrayList.get(i), arrayList);
        }
    }

    private void showNotifyDialog(final int i, AlaLiveUserNotifyData alaLiveUserNotifyData, final ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (this.mTbPageContext != null) {
            if (this.mBdAlertDialog == null) {
                this.mBdAlertDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
            }
            this.mBdAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyController.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaLiveUserNotifyController.this.showNextNotifyDialog(i + 1, arrayList);
                }
            });
            this.mBdAlertDialog.show(alaLiveUserNotifyData);
        }
    }

    public void onDestroy() {
        if (this.mBdAlertDialog != null && this.mBdAlertDialog.isShowing()) {
            this.mBdAlertDialog.dismiss();
        }
        this.mBdAlertDialog = null;
        this.mTbPageContext = null;
    }
}
