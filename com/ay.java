package com;

import android.widget.PopupWindow;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareUIWidget;
/* loaded from: classes.dex */
public class ay implements PopupWindow.OnDismissListener {
    final /* synthetic */ ShareUIWidget a;

    public ay(ShareUIWidget shareUIWidget) {
        this.a = shareUIWidget;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.a.b = null;
    }
}
