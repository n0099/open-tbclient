package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aa extends DefaultBaiduListener {
    final /* synthetic */ x dh;
    final /* synthetic */ ShareMediaItem di;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, ShareMediaItem shareMediaItem) {
        this.dh = xVar;
        this.di = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.di.setUserName(jSONObject.optString("username"));
        this.dh.notifyDataSetChanged();
    }
}
