package com.baidu.sapi2.touchid;

import android.view.View;
/* loaded from: classes11.dex */
public interface FingerprintDialogInterface {
    FingerprintDialogInterface setBtnCount(int i2);

    FingerprintDialogInterface setIconInvisible();

    FingerprintDialogInterface setNegativeBtn(String str, View.OnClickListener onClickListener);

    FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener);

    FingerprintDialogInterface setTitle(String str, String str2);

    void showDialog();
}
