package com.baidu.live.business.model.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006 "}, d2 = {"Lcom/baidu/live/business/model/data/LiveFeedFollowLivingData;", "Lorg/json/JSONObject;", "json", "", "parserJson", "(Lorg/json/JSONObject;)V", "", "errno", "I", "getErrno", "()I", "setErrno", "(I)V", "", "", "livingList", "Ljava/util/List;", "getLivingList", "()Ljava/util/List;", "setLivingList", "(Ljava/util/List;)V", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "msg", "getMsg", "setMsg", "<init>", "()V", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedFollowLivingData {
    public int errno;
    public List<String> livingList;
    public String logId;
    public String msg;

    public final int getErrno() {
        return this.errno;
    }

    public final List<String> getLivingList() {
        return this.livingList;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        this.errno = jSONObject.optInt("errno");
        this.msg = jSONObject.optString("msg");
        this.logId = jSONObject.optString("logid");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("room_list")) != null && optJSONArray.length() > 0) {
            this.livingList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i);
                Intrinsics.checkExpressionValueIsNotNull(optString, "roomArray.optString(i)");
                List<String> list = this.livingList;
                if (list != null) {
                    list.add(optString);
                }
            }
        }
    }

    public final void setErrno(int i) {
        this.errno = i;
    }

    public final void setLivingList(List<String> list) {
        this.livingList = list;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }
}
