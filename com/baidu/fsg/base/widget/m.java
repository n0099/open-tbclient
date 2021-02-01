package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes5.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeScrollView f2046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(SafeScrollView safeScrollView) {
        this.f2046a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f2046a.g;
        context = this.f2046a.e;
        safeKeyBoardEditText = this.f2046a.f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f2046a);
        safeKeyBoardUtil2 = this.f2046a.g;
        safeKeyBoardEditText2 = this.f2046a.f;
        safeKeyBoardEditText3 = this.f2046a.f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
