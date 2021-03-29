package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5521a;

    public m(SafeScrollView safeScrollView) {
        this.f5521a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5521a.f5506g;
        context = this.f5521a.f5504e;
        safeKeyBoardEditText = this.f5521a.f5505f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5521a);
        safeKeyBoardUtil2 = this.f5521a.f5506g;
        safeKeyBoardEditText2 = this.f5521a.f5505f;
        safeKeyBoardEditText3 = this.f5521a.f5505f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
