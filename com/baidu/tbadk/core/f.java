package com.baidu.tbadk.core;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
class f implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ BaseFragmentActivity Ti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BaseFragmentActivity baseFragmentActivity) {
        this.Ti = baseFragmentActivity;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.Ti.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.Ti.getWindow().getDecorView().getRootView().getHeight();
        int i = height - (rect.bottom - rect.top);
        Context applicationContext = this.Ti.getApplicationContext();
        int identifier = applicationContext.getResources().getIdentifier("status_bar_height", "dimen", SocialConstants.ANDROID_CLIENT_TYPE);
        if (identifier > 0) {
            i -= applicationContext.getResources().getDimensionPixelSize(identifier);
        }
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i) && i < (height * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i) {
            TbadkCoreApplication.m411getInst().setKeyboardHeight(i);
            this.Ti.onKeyboardHeightChanged(i);
        }
    }
}
