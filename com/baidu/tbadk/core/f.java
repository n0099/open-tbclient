package com.baidu.tbadk.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BaseFragmentActivity yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.yG = baseFragmentActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.yG.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.yG.getWindow().getDecorView().getRootView().getHeight();
        int i = height - (rect.bottom - rect.top);
        Context applicationContext = this.yG.getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i -= applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        if (TbadkApplication.m251getInst().isKeyboardHeightCanSet(i) && i < (height * 2) / 3 && TbadkApplication.m251getInst().getKeyboardHeight() != i) {
            TbadkApplication.m251getInst().setKeyboardHeight(i);
            this.yG.onKeyboardHeightChanged(i);
        }
    }
}
