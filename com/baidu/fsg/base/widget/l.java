package com.baidu.fsg.base.widget;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SafeKeyBoardUtil f1598a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f1598a = safeKeyBoardUtil;
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
        view = this.f1598a.f;
        view.getLocationOnScreen(iArr);
        SafeKeyBoardUtil safeKeyBoardUtil = this.f1598a;
        int i6 = iArr[1];
        view2 = this.f1598a.f;
        int height = i6 + view2.getHeight();
        i = this.f1598a.g;
        i2 = this.f1598a.j;
        int i7 = height - (i - i2);
        safeKeyBoardEditText = this.f1598a.c;
        safeKeyBoardUtil.i = i7 + safeKeyBoardEditText.getGap();
        i3 = this.f1598a.i;
        if (i3 > 0) {
            safeScrollView2 = this.f1598a.e;
            i5 = this.f1598a.i;
            safeScrollView2.smoothScrollBy(0, i5);
        }
        safeScrollView = this.f1598a.e;
        i4 = this.f1598a.j;
        safeScrollView.notifyShowKeyBoard(i4);
    }
}
