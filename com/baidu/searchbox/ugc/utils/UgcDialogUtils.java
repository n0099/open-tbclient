package com.baidu.searchbox.ugc.utils;

import android.content.DialogInterface;
import com.baidu.searchbox.ugc.R;
/* loaded from: classes13.dex */
public class UgcDialogUtils {
    public static void showSaveDraftDialog(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        DialogUtils.showDialog(R.string.save_draft_dialog_title, R.string.save_draft_dialog_message, R.string.save_draft_dialog_btn_positive, R.string.save_draft_dialog_btn_negative, onClickListener, onClickListener2);
    }
}
