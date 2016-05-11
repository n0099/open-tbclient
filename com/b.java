package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.handler.FacebookShareHandler;
/* loaded from: classes.dex */
public class b extends DefaultBaiduListener {
    final /* synthetic */ ShareContent a;
    final /* synthetic */ boolean b;
    final /* synthetic */ FacebookShareHandler cJ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(FacebookShareHandler facebookShareHandler, IBaiduListener iBaiduListener, ShareContent shareContent, boolean z) {
        super(iBaiduListener);
        this.cJ = facebookShareHandler;
        this.a = shareContent;
        this.b = z;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.cJ.share(this.a, this.mListener, this.b);
    }
}
