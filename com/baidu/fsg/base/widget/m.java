package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5705a;

    public m(SafeScrollView safeScrollView) {
        this.f5705a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5705a.f5689g;
        context = this.f5705a.f5687e;
        safeKeyBoardEditText = this.f5705a.f5688f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5705a);
        safeKeyBoardUtil2 = this.f5705a.f5689g;
        safeKeyBoardEditText2 = this.f5705a.f5688f;
        safeKeyBoardEditText3 = this.f5705a.f5688f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
