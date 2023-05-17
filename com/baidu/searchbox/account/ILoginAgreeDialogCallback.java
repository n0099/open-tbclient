package com.baidu.searchbox.account;

import android.content.DialogInterface;
import android.view.View;
/* loaded from: classes3.dex */
public interface ILoginAgreeDialogCallback {
    void onButtonClick(DialogInterface dialogInterface, View view2);

    void onDismiss(DialogInterface dialogInterface);

    void onShouldShowDialg(boolean z);

    void onShow(DialogInterface dialogInterface);
}
