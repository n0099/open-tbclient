package com.baidu.searchbox.live.data.pojo;

import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0005R$\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0005R$\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "", "response", "", "loadFromJson", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "templateJson", "(Lorg/json/JSONObject;)V", "liveType", "Ljava/lang/String;", "getLiveType", "()Ljava/lang/String;", "setLiveType", "roomId", "getRoomId", "setRoomId", "templateId", "getTemplateId", "setTemplateId", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveTypeData {
    public String liveType;
    public String roomId;
    public String templateId;

    public final String getLiveType() {
        return this.liveType;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void loadFromJson(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject optJSONObject2 = new JSONObject(str).optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("room_template_info")) != null) {
                this.roomId = optJSONObject.optString("room_id");
                this.liveType = optJSONObject.optString("live_type");
                this.templateId = optJSONObject.optString("template_id");
            }
        } catch (Exception unused) {
        }
    }

    public final void setLiveType(String str) {
        this.liveType = str;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }

    public final void loadFromJson(JSONObject jSONObject) {
        try {
            this.roomId = jSONObject.optString("room_id");
            this.liveType = jSONObject.optString("live_type");
            this.templateId = jSONObject.optString("template_id");
        } catch (Exception unused) {
        }
    }
}
