package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5459a;

    public m(SafeScrollView safeScrollView) {
        this.f5459a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5459a.f5443g;
        context = this.f5459a.f5441e;
        safeKeyBoardEditText = this.f5459a.f5442f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5459a);
        safeKeyBoardUtil2 = this.f5459a.f5443g;
        safeKeyBoardEditText2 = this.f5459a.f5442f;
        safeKeyBoardEditText3 = this.f5459a.f5442f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
