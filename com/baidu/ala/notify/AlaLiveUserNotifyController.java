package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AlaLiveUserNotifyController {
    public AlaLiveUserNotifyDialog mBdAlertDialog;
    public TbPageContext mTbPageContext;

    public AlaLiveUserNotifyController(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private void showNotifyDialog(final int i2, AlaLiveUserNotifyData alaLiveUserNotifyData, final ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (this.mTbPageContext == null) {
            return;
        }
        if (this.mBdAlertDialog == null) {
            this.mBdAlertDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
        }
        this.mBdAlertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyController.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AlaLiveUserNotifyController.this.showNextNotifyDialog(i2 + 1, arrayList);
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

    public void showNextNotifyDialog(int i2, ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (i2 < 0 || i2 >= ListUtils.getCount(arrayList)) {
            return;
        }
        showNotifyDialog(i2, arrayList.get(i2), arrayList);
    }
}
