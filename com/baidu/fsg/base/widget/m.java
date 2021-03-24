package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5520a;

    public m(SafeScrollView safeScrollView) {
        this.f5520a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5520a.f5505g;
        context = this.f5520a.f5503e;
        safeKeyBoardEditText = this.f5520a.f5504f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5520a);
        safeKeyBoardUtil2 = this.f5520a.f5505g;
        safeKeyBoardEditText2 = this.f5520a.f5504f;
        safeKeyBoardEditText3 = this.f5520a.f5504f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
