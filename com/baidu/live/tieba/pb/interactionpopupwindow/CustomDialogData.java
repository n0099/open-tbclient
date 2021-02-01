package com.baidu.live.tieba.pb.interactionpopupwindow;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class CustomDialogData implements IBaseDialogData {
    public static final String POS_LEFT = "left";
    public static final int TYPE_ADD_THREAD = 2;
    public static final int TYPE_AGREE = 0;
    public static final int TYPE_REPLY = 1;
    public String body;
    public Head head;
    public Button leftButton;
    public Button rightButton;
    public int type = -1;

    /* loaded from: classes11.dex */
    public static class Button implements Serializable {
        public String action;
        public String image;
        public String text;
    }

    /* loaded from: classes11.dex */
    public static class Head implements Serializable {
        public String imageUrl;
        public String text;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 1;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return this.type;
    }

    public static CustomDialogData praseJSON(JSONObject jSONObject) {
        CustomDialogData customDialogData = new CustomDialogData();
        JSONObject optJSONObject = jSONObject.optJSONObject("head");
        if (optJSONObject != null) {
            Head head = new Head();
            head.imageUrl = optJSONObject.optString("image");
            head.text = optJSONObject.optString("text");
            customDialogData.head = head;
        }
        customDialogData.body = jSONObject.optString("body");
        JSONArray optJSONArray = jSONObject.optJSONArray("button");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                Button button = new Button();
                button.text = optJSONObject2.optString("text");
                button.action = optJSONObject2.optString("action");
                button.image = optJSONObject2.optString("image");
                if (optJSONObject2.optString("position").equals("left")) {
                    customDialogData.leftButton = button;
                } else {
                    customDialogData.rightButton = button;
                }
            }
        }
        return customDialogData;
    }
}
