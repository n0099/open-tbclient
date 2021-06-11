package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5502a;

    public m(SafeScrollView safeScrollView) {
        this.f5502a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5502a.f5486g;
        context = this.f5502a.f5484e;
        safeKeyBoardEditText = this.f5502a.f5485f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5502a);
        safeKeyBoardUtil2 = this.f5502a.f5486g;
        safeKeyBoardEditText2 = this.f5502a.f5485f;
        safeKeyBoardEditText3 = this.f5502a.f5485f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
