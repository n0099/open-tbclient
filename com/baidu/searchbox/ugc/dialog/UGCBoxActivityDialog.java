package com.baidu.searchbox.ugc.dialog;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import com.baidu.android.ext.widget.dialog.BaseActivityDialog;
import com.baidu.searchbox.ugc.base.R;
/* loaded from: classes6.dex */
public class UGCBoxActivityDialog extends BaseActivityDialog {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.ext.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDialogLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.ugc_dialog_white_layout_bg));
        getWindow().setLayout(getResources().getConfiguration().orientation == 2 ? (int) (getResources().getDisplayMetrics().widthPixels * 0.6f) : -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.android.ext.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public static BaseActivityDialog.Builder newBuilder() {
        return new BaseActivityDialog.Builder(UGCBoxActivityDialog.class);
    }

    @Override // com.baidu.android.ext.widget.dialog.BaseActivityDialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        overridePendingTransition(0, R.anim.ugc_slide_bottom_out);
    }
}
