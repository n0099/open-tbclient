package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aa extends DefaultBaiduListener {
    final /* synthetic */ x nl;
    final /* synthetic */ ShareMediaItem nm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, ShareMediaItem shareMediaItem) {
        this.nl = xVar;
        this.nm = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.nm.setUserName(jSONObject.optString("username"));
        this.nl.notifyDataSetChanged();
    }
}
