package com.baidu.cloudsdk.social.share.ui;

import android.content.Context;
import android.view.View;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
/* loaded from: classes.dex */
public class ShareUIWidget {

    /* renamed from: a  reason: collision with root package name */
    private static ShareUIWidget f876a;
    private Context b;
    private av c;

    private ShareUIWidget(Context context) {
        a(context);
    }

    private void a(Context context) {
        this.b = context;
    }

    public static ShareUIWidget getInstance(Context context) {
        if (f876a == null) {
            f876a = new ShareUIWidget(context);
        } else {
            f876a.a(context);
        }
        return f876a;
    }

    public void show(View view, ShareContent shareContent, SocialShare.Theme theme, IBaiduListener iBaiduListener, boolean z) {
        Validator.notNull(view, "parent");
        Validator.notNull(shareContent, "content");
        Validator.notNull(theme, "theme");
        if (this.c == null || this.c.a() != theme || this.c.b() != z) {
            this.c = new av(this.b, theme, z);
        }
        this.c.a(view, shareContent, iBaiduListener);
    }
}
