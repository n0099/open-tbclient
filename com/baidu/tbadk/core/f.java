package com.baidu.tbadk.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
class f implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BaseFragmentActivity Oh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.Oh = baseFragmentActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.Oh.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.Oh.getWindow().getDecorView().getRootView().getHeight();
        int i = height - (rect.bottom - rect.top);
        Context applicationContext = this.Oh.getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i -= applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i) && i < (height * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i) {
            TbadkCoreApplication.m411getInst().setKeyboardHeight(i);
            this.Oh.onKeyboardHeightChanged(i);
        }
    }
}
