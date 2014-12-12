package com.baidu.tbadk.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
class e implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BaseFragmentActivity CA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BaseFragmentActivity baseFragmentActivity) {
        this.CA = baseFragmentActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.CA.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.CA.getWindow().getDecorView().getRootView().getHeight();
        int i = height - (rect.bottom - rect.top);
        Context applicationContext = this.CA.getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i -= applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanSet(i) && i < (height * 2) / 3 && TbadkCoreApplication.m255getInst().getKeyboardHeight() != i) {
            TbadkCoreApplication.m255getInst().setKeyboardHeight(i);
            this.CA.onKeyboardHeightChanged(i);
        }
    }
}
