package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.view.View;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.bh;
/* loaded from: classes.dex */
public class ShareUIWidget {
    private Context a;
    private ShareMenu b;

    public ShareUIWidget(Context context) {
        setContext(context);
    }

    public void hide() {
        if (this.b == null || !this.b.isShowing()) {
            return;
        }
        this.b.dismiss();
        this.b = null;
    }

    public void setContext(Context context) {
        this.a = context;
    }

    public void show(View view, ShareContent shareContent, SocialShare.Theme theme, IBaiduListener iBaiduListener, boolean z) {
        Validator.notNull(view, "parent");
        Validator.notNull(shareContent, PushConstants.EXTRA_CONTENT);
        Validator.notNull(theme, "theme");
        this.b = new ShareMenu(this.a, theme, z);
        this.b.show(view, shareContent, iBaiduListener);
        this.b.setOnDismissListener(new bh(this));
    }
}
