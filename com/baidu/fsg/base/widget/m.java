package com.baidu.fsg.base.widget;

import android.content.Context;
/* loaded from: classes2.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeScrollView f5556a;

    public m(SafeScrollView safeScrollView) {
        this.f5556a = safeScrollView;
    }

    @Override // java.lang.Runnable
    public void run() {
        SafeKeyBoardUtil safeKeyBoardUtil;
        Context context;
        SafeKeyBoardEditText safeKeyBoardEditText;
        SafeKeyBoardUtil safeKeyBoardUtil2;
        SafeKeyBoardEditText safeKeyBoardEditText2;
        SafeKeyBoardEditText safeKeyBoardEditText3;
        safeKeyBoardUtil = this.f5556a.f5541g;
        context = this.f5556a.f5539e;
        safeKeyBoardEditText = this.f5556a.f5540f;
        safeKeyBoardUtil.init(context, safeKeyBoardEditText.getViewGroup(), this.f5556a);
        safeKeyBoardUtil2 = this.f5556a.f5541g;
        safeKeyBoardEditText2 = this.f5556a.f5540f;
        safeKeyBoardEditText3 = this.f5556a.f5540f;
        safeKeyBoardUtil2.showSoftKeyBoard(safeKeyBoardEditText2, safeKeyBoardEditText3.getVisibleView());
    }
}
