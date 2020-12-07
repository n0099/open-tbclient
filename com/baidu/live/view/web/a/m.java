package com.baidu.live.view.web.a;

import android.app.Activity;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m extends com.baidu.live.view.web.a {
    private Activity activity;
    private long liveId;
    private long userId;
    private String userName = "";

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "shareBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl ShareBridgeJsInterface params = " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("content");
            String optString3 = jSONObject.optString("imageUrl");
            String optString4 = jSONObject.optString("linkUrl");
            int optInt = jSONObject.optInt("type");
            String optString5 = jSONObject.optString("shareType");
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.title = optString;
            shareEntity.content = optString2;
            shareEntity.imageUrl = optString3;
            shareEntity.linkUrl = optString4;
            shareEntity.sharePicType = optString5;
            if (shareEntity.sharePicType.equals("image")) {
                shareEntity.type = "2";
            }
            shareEntity.shareType = optInt;
            shareEntity.userId = this.userId;
            shareEntity.userName = this.userName;
            shareEntity.liveId = this.liveId;
            ShareEntityWrapperData shareEntityWrapperData = new ShareEntityWrapperData();
            shareEntityWrapperData.activity = this.activity;
            shareEntityWrapperData.shareEntity = shareEntity;
            MessageManager.getInstance().sendMessage(new CustomMessage(2913077, shareEntityWrapperData));
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

    public void setActivityContext(Activity activity) {
        this.activity = activity;
    }

    public void setLiveId(long j) {
        this.liveId = j;
    }
}
