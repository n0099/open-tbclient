package com.baidu.live.view.web.a;

import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.data.ShareEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h extends com.baidu.live.view.web.a {
    private long userId;
    private String userName = "";

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "shareBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void dT(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl ShareBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imageUrl");
            String optString4 = jSONObject.optString("linkUrl");
            int optInt = jSONObject.optInt("type");
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.title = optString;
            shareEntity.content = optString2;
            shareEntity.imageUrl = optString3;
            shareEntity.linkUrl = optString4;
            shareEntity.shareType = optInt;
            shareEntity.userId = this.userId;
            shareEntity.userName = this.userName;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913077, shareEntity));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
