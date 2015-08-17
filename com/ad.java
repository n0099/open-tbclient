package com;

import com.baidu.cloudsdk.DefaultBaiduListener;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMenu;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad extends DefaultBaiduListener {
    final /* synthetic */ ShareMenu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(ShareMenu shareMenu, IBaiduListener iBaiduListener) {
        super(iBaiduListener);
        this.a = shareMenu;
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        super.onComplete();
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        super.onComplete(jSONArray);
    }

    @Override // com.baidu.cloudsdk.DefaultBaiduListener, com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        super.onComplete(jSONObject);
    }
}
