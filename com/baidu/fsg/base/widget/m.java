package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes16.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeScrollView f1557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SafeScrollView safeScrollView) {
        this.f1557a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f1557a.g;
        context = this.f1557a.e;
        safeKeyBoardEditText = this.f1557a.f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f1557a);
        safeKeyBoardUtil2 = this.f1557a.g;
        safeKeyBoardEditText2 = this.f1557a.f;
        safeKeyBoardEditText3 = this.f1557a.f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
