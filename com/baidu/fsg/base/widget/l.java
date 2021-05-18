package com.baidu.fsg.base.widget;

import android.view.View;
/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardUtil f5558a;

    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5558a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i2;
        int i3;
        SafeKeyBoardEditText safeKeyBoardEditText;
        int i4;
        SafeScrollView safeScrollView;
        int i5;
        SafeScrollView safeScrollView2;
        int i6;
        int[] iArr = new int[2];
        view = this.f5558a.f5533f;
        view.getLocationOnScreen(iArr);
        SafeKeyBoardUtil safeKeyBoardUtil = this.f5558a;
        int i7 = iArr[1];
        view2 = safeKeyBoardUtil.f5533f;
        int height = i7 + view2.getHeight();
        i2 = this.f5558a.f5534g;
        i3 = this.f5558a.j;
        int i8 = height - (i2 - i3);
        safeKeyBoardEditText = this.f5558a.f5530c;
        safeKeyBoardUtil.f5536i = i8 + safeKeyBoardEditText.getGap();
        i4 = this.f5558a.f5536i;
        if (i4 > 0) {
            safeScrollView2 = this.f5558a.f5532e;
            i6 = this.f5558a.f5536i;
            safeScrollView2.smoothScrollBy(0, i6);
        }
        safeScrollView = this.f5558a.f5532e;
        i5 = this.f5558a.j;
        safeScrollView.notifyShowKeyBoard(i5);
    }
}
