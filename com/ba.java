package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* loaded from: classes.dex */
class ba extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem a;
    final /* synthetic */ az b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, ShareMediaItem shareMediaItem) {
        this.b = azVar;
        this.a = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        this.b.b.a(this.a, false);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        this.b.b.a(this.a, true);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        this.b.b.a(this.a, false);
    }
}
