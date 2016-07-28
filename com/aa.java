package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aa extends DefaultBaiduListener {
    final /* synthetic */ x dK;
    final /* synthetic */ ShareMediaItem dL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, ShareMediaItem shareMediaItem) {
        this.dK = xVar;
        this.dL = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.dL.setUserName(jSONObject.optString("username"));
        this.dK.notifyDataSetChanged();
    }
}
