package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import org.json.JSONObject;
/* loaded from: classes.dex */
class aa extends DefaultBaiduListener {
    final /* synthetic */ x fV;
    final /* synthetic */ ShareMediaItem fW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, ShareMediaItem shareMediaItem) {
        this.fV = xVar;
        this.fW = shareMediaItem;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        this.fW.setUserName(jSONObject.optString("username"));
        this.fV.notifyDataSetChanged();
    }
}
