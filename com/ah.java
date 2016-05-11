package com;

import android.widget.PopupWindow;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareUIWidget;
/* loaded from: classes.dex */
public class ah implements PopupWindow.OnDismissListener {
    final /* synthetic */ ShareUIWidget ffG;

    public ah(ShareUIWidget shareUIWidget) {
        this.ffG = shareUIWidget;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.ffG.b = null;
    }
}
