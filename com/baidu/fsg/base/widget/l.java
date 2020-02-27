package com.baidu.fsg.base.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class l implements Runnable {
    final /* synthetic */ SafeKeyBoardUtil a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.a = safeKeyBoardUtil;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        int i;
        int i2;
        SafeKeyBoardEditText safeKeyBoardEditText;
        int i3;
        SafeScrollView safeScrollView;
        int i4;
        SafeScrollView safeScrollView2;
        int i5;
        int[] iArr = new int[2];
        view = this.a.f;
        view.getLocationOnScreen(iArr);
        SafeKeyBoardUtil safeKeyBoardUtil = this.a;
        int i6 = iArr[1];
        view2 = this.a.f;
        int height = i6 + view2.getHeight();
        i = this.a.g;
        i2 = this.a.j;
        int i7 = height - (i - i2);
        safeKeyBoardEditText = this.a.c;
        safeKeyBoardUtil.i = i7 + safeKeyBoardEditText.getGap();
        i3 = this.a.i;
        if (i3 > 0) {
            safeScrollView2 = this.a.e;
            i5 = this.a.i;
            safeScrollView2.smoothScrollBy(0, i5);
        }
        safeScrollView = this.a.e;
        i4 = this.a.j;
        safeScrollView.notifyShowKeyBoard(i4);
    }
}
