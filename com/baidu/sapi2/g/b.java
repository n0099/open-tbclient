package com.baidu.sapi2.g;

import android.view.View;
/* loaded from: classes2.dex */
public interface b {
    b setBtnCount(int i);

    b setIconInvisible();

    b setNegativeBtn(String str, View.OnClickListener onClickListener);

    b setPositiveBtn(String str, View.OnClickListener onClickListener);

    b setTitle(String str, String str2);

    void showDialog();
}
