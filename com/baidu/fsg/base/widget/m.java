package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5559a;

    public m(SafeScrollView safeScrollView) {
        this.f5559a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5559a.f5543g;
        context = this.f5559a.f5541e;
        safeKeyBoardEditText = this.f5559a.f5542f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5559a);
        safeKeyBoardUtil2 = this.f5559a.f5543g;
        safeKeyBoardEditText2 = this.f5559a.f5542f;
        safeKeyBoardEditText3 = this.f5559a.f5542f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
