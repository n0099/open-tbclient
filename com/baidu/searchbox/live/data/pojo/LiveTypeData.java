package com.baidu.searchbox.live.data.pojo;

import android.text.TextUtils;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u0000B\u0007¢\u0006\u0004\b$\u0010%J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\bR$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/live/data/pojo/LiveTypeData;", "", "isValid", "()Z", "", "response", "", "loadFromJson", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "templateJson", "(Lorg/json/JSONObject;)V", "", "errno", "I", "getErrno", "()I", "setErrno", "(I)V", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "liveType", "getLiveType", "setLiveType", "logId", "getLogId", "setLogId", "roomId", "getRoomId", "setRoomId", "templateId", "getTemplateId", "setTemplateId", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveTypeData {
    public int errno;
    public String errorMessage;
    public String liveType;
    public String logId;
    public String roomId;
    public String templateId;

    public final int getErrno() {
        return this.errno;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final boolean isValid() {
        if (!TextUtils.isEmpty(this.roomId) && !TextUtils.isEmpty(this.liveType) && !TextUtils.isEmpty(this.templateId)) {
            return true;
        }
        return false;
    }

    public final void loadFromJson(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.errorMessage = jSONObject.optString("errmsg");
            this.errno = jSONObject.optInt("errno");
            this.logId = jSONObject.optString("logid");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("room_template_info")) != null) {
                this.roomId = optJSONObject.optString("room_id");
                this.liveType = optJSONObject.optString("live_type");
                this.templateId = optJSONObject.optString("template_id");
            }
        } catch (Exception unused) {
        }
    }

    public final void loadFromJson(JSONObject jSONObject) {
        try {
            this.roomId = jSONObject.optString("room_id");
            this.liveType = jSONObject.optString("live_type");
            this.templateId = jSONObject.optString("template_id");
        } catch (Exception unused) {
        }
    }

    public final void setErrno(int i) {
        this.errno = i;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setLiveType(String str) {
        this.liveType = str;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final void setTemplateId(String str) {
        this.templateId = str;
    }
}
