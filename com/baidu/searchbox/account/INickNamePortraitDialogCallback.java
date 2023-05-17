package com.baidu.searchbox.account;
/* loaded from: classes3.dex */
public interface INickNamePortraitDialogCallback {
    void onDialogCreate(IAccountDialog iAccountDialog);

    void onDialogDismiss();

    void onDialogShow(boolean z, int i);

    void onNicknameModifyResult(boolean z);

    void onPortraitModifyResult(boolean z);
}
