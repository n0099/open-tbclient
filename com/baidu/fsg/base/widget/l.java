package com.baidu.fsg.base.widget;

import android.view.View;
/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SafeKeyBoardUtil f5520a;

    public l(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.f5520a = safeKeyBoardUtil;
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
        view = this.f5520a.f5497f;
        view.getLocationOnScreen(iArr);
        SafeKeyBoardUtil safeKeyBoardUtil = this.f5520a;
        int i6 = iArr[1];
        view2 = safeKeyBoardUtil.f5497f;
        int height = i6 + view2.getHeight();
        i = this.f5520a.f5498g;
        i2 = this.f5520a.j;
        int i7 = height - (i - i2);
        safeKeyBoardEditText = this.f5520a.f5494c;
        safeKeyBoardUtil.i = i7 + safeKeyBoardEditText.getGap();
        i3 = this.f5520a.i;
        if (i3 > 0) {
            safeScrollView2 = this.f5520a.f5496e;
            i5 = this.f5520a.i;
            safeScrollView2.smoothScrollBy(0, i5);
        }
        safeScrollView = this.f5520a.f5496e;
        i4 = this.f5520a.j;
        safeScrollView.notifyShowKeyBoard(i4);
    }
}
