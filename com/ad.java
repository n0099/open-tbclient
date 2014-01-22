package com;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMenu;
/* loaded from: classes.dex */
public class ad implements View.OnKeyListener {
    final /* synthetic */ ShareMenu a;

    public ad(ShareMenu shareMenu) {
        this.a = shareMenu;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 4 && this.a.isShowing()) {
            this.a.dismiss();
            return true;
        }
        return false;
    }
}
