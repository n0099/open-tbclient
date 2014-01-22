package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class ac extends DefaultBaiduListener {
    final /* synthetic */ ShareMediaItem a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(s sVar, ShareMediaItem shareMediaItem) {
        this.b = sVar;
        this.a = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.a.setUserName(jSONObject.optString("username"));
        this.b.notifyDataSetChanged();
    }
}
