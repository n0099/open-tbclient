package com;

import android.widget.PopupWindow;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareUIWidget;
/* loaded from: classes.dex */
public class ah implements PopupWindow.OnDismissListener {
    final /* synthetic */ ShareUIWidget eOI;

    public ah(ShareUIWidget shareUIWidget) {
        this.eOI = shareUIWidget;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.eOI.b = null;
    }
}
