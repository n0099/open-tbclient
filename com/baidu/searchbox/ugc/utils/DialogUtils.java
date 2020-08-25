package com.baidu.searchbox.ugc.utils;

import android.content.DialogInterface;
import com.baidu.searchbox.ugc.dialog.UGCBoxActivityDialog;
/* loaded from: classes20.dex */
public class DialogUtils {
    public static void showDialog(int i, int i2, int i3, int i4, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        UGCBoxActivityDialog.newBuilder().setTitle(i).setMessage(i2).setPositiveButton(i3, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.utils.DialogUtils.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i5);
                }
            }
        }).setNegativeButton(i4, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.utils.DialogUtils.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i5);
                }
            }
        }).show();
    }

    public static void showDialog(int i, String str, int i2, int i3, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        UGCBoxActivityDialog.newBuilder().setTitle(i).setMessage(str).setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.utils.DialogUtils.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i4);
                }
            }
        }).setNegativeButton(i3, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ugc.utils.DialogUtils.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, i4);
                }
            }
        }).show();
    }
}
