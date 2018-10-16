package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes6.dex */
class m implements Runnable {
    final /* synthetic */ SafeScrollView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SafeScrollView safeScrollView) {
        this.a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.a.g;
        context = this.a.e;
        safeKeyBoardEditText = this.a.f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.a);
        safeKeyBoardUtil2 = this.a.g;
        safeKeyBoardEditText2 = this.a.f;
        safeKeyBoardEditText3 = this.a.f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
