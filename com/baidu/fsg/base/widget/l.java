package com.baidu.fsg.base.widget;

import android.view.View;
/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardUtil f5704a;

    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5704a = safeKeyBoardUtil;
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
        view = this.f5704a.f5679f;
        view.getLocationOnScreen(iArr);
        SafeKeyBoardUtil safeKeyBoardUtil = this.f5704a;
        int i7 = iArr[1];
        view2 = safeKeyBoardUtil.f5679f;
        int height = i7 + view2.getHeight();
        i2 = this.f5704a.f5680g;
        i3 = this.f5704a.j;
        int i8 = height - (i2 - i3);
        safeKeyBoardEditText = this.f5704a.f5676c;
        safeKeyBoardUtil.f5682i = i8 + safeKeyBoardEditText.getGap();
        i4 = this.f5704a.f5682i;
        if (i4 > 0) {
            safeScrollView2 = this.f5704a.f5678e;
            i6 = this.f5704a.f5682i;
            safeScrollView2.smoothScrollBy(0, i6);
        }
        safeScrollView = this.f5704a.f5678e;
        i5 = this.f5704a.j;
        safeScrollView.notifyShowKeyBoard(i5);
    }
}
