package com.baidu.sapi2.permissions;

import android.view.View;
/* loaded from: classes4.dex */
public interface AlertDialogInterface {
    void setCancel(boolean z);

    void setMessageText(String str);

    void setNegativeBtn(String str, View.OnClickListener onClickListener);

    void setPositiveBtn(String str, View.OnClickListener onClickListener);

    void setTitleText(String str);

    void showDialog();
}
