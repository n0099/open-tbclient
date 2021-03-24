package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AlaLiveUserNotifyController {
    public AlaLiveUserNotifyDialog mBdAlertDialog;
    public TbPageContext mTbPageContext;

    public AlaLiveUserNotifyController(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private void showNotifyDialog(final int i, AlaLiveUserNotifyData alaLiveUserNotifyData, final ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (this.mTbPageContext == null) {
            return;
        }
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

    public void onDestroy() {
        AlaLiveUserNotifyDialog alaLiveUserNotifyDialog = this.mBdAlertDialog;
        if (alaLiveUserNotifyDialog != null && alaLiveUserNotifyDialog.isShowing()) {
            this.mBdAlertDialog.dismiss();
        }
        this.mBdAlertDialog = null;
        this.mTbPageContext = null;
    }

    public void showNextNotifyDialog(int i, ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (i < 0 || i >= ListUtils.getCount(arrayList)) {
            return;
        }
        showNotifyDialog(i, arrayList.get(i), arrayList);
    }
}
