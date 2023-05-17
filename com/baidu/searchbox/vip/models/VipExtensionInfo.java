package com.baidu.searchbox.vip.models;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u0017\u001a\u00020\u0004R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/vip/models/VipExtensionInfo;", "", "()V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "<set-?>", "", VipUserInfoKt.KEY_VIP_SUB_CATE, "getCate", "()I", "sellStatus", "getSellStatus", "status", "getStatus", "", "unionEndTime", "getUnionEndTime", "()J", "unionStartTime", "getUnionStartTime", "compareTo", "other", "toJsonObject", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VipExtensionInfo implements Comparable<VipExtensionInfo> {
    public int cate;
    public int sellStatus;
    public int status;
    public long unionEndTime;
    public long unionStartTime;

    public VipExtensionInfo() {
    }

    public final int getCate() {
        return this.cate;
    }

    public final int getSellStatus() {
        return this.sellStatus;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getUnionEndTime() {
        return this.unionEndTime;
    }

    public final long getUnionStartTime() {
        return this.unionStartTime;
    }

    public VipExtensionInfo(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        try {
            this.cate = jsonObject.optInt(VipUserInfoKt.KEY_VIP_SUB_CATE);
            this.status = jsonObject.optInt("status", 0);
            this.sellStatus = jsonObject.optInt(VipUserInfoKt.KEY_VIP_SUB_SELL_STATE, 0);
            this.unionStartTime = jsonObject.optLong(VipUserInfoKt.KEY_VIP_SUB_UNION_START, 0L);
            this.unionEndTime = jsonObject.optLong(VipUserInfoKt.KEY_VIP_SUB_UNION_END, 0L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(VipExtensionInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.cate == other.cate && this.status == other.status && this.sellStatus == other.sellStatus && this.unionStartTime == other.unionStartTime && this.unionEndTime == other.unionEndTime) {
            return 0;
        }
        return 1;
    }

    public final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VipUserInfoKt.KEY_VIP_SUB_CATE, this.cate);
            jSONObject.put("status", this.status);
            jSONObject.put(VipUserInfoKt.KEY_VIP_SUB_SELL_STATE, this.sellStatus);
            jSONObject.put(VipUserInfoKt.KEY_VIP_SUB_UNION_START, this.unionStartTime);
            jSONObject.put(VipUserInfoKt.KEY_VIP_SUB_UNION_END, this.unionEndTime);
        } catch (Exception e) {
            Log.d(VipUserInfoKt.VIP_USER_INFO_TAG, "parse vip user info to json error: ", e);
        }
        return jSONObject;
    }
}
