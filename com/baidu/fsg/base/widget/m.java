package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes5.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeScrollView f1599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SafeScrollView safeScrollView) {
        this.f1599a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f1599a.g;
        context = this.f1599a.e;
        safeKeyBoardEditText = this.f1599a.f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f1599a);
        safeKeyBoardUtil2 = this.f1599a.g;
        safeKeyBoardEditText2 = this.f1599a.f;
        safeKeyBoardEditText3 = this.f1599a.f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
