package com.baidu.searchbox.vip.models;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0007J\u0016\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0013J\u000e\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001bj\b\u0012\u0004\u0012\u00020\u0007`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/baidu/searchbox/vip/models/VipUserInfo;", "", "()V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "currentUserId", "", "getCurrentUserId", "()Ljava/lang/String;", "setCurrentUserId", "(Ljava/lang/String;)V", "<set-?>", "", "endTime", "getEndTime", "()J", "equitiesFreeNewMap", "", "", "getEquitiesFreeNewMap", "()Ljava/util/Map;", "setEquitiesFreeNewMap", "(Ljava/util/Map;)V", "ext", "rawJsonObj", "unionVipTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vipMap", "Lcom/baidu/searchbox/vip/models/VipExtensionInfo;", "vipStatus", "getVipStatus", "()I", "compareTo", "other", "hasDuVip", "", "hasUnionVipType", "type", "isChangedVipStatus", "accountUid", "accountIsVipStatus", "isUnActivity", "unionVipType", "toJsonObject", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VipUserInfo implements Comparable<VipUserInfo> {
    public String currentUserId;
    public long endTime;
    public Map<String, Integer> equitiesFreeNewMap;
    public JSONObject ext;
    public JSONObject rawJsonObj;
    public final ArrayList<String> unionVipTypes;
    public Map<String, VipExtensionInfo> vipMap;
    public int vipStatus;

    public VipUserInfo() {
        this.currentUserId = "";
        this.vipStatus = 1;
        this.unionVipTypes = CollectionsKt__CollectionsKt.arrayListOf(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN, VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP, VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP);
        this.vipMap = new LinkedHashMap();
        this.equitiesFreeNewMap = new LinkedHashMap();
    }

    public final String getCurrentUserId() {
        return this.currentUserId;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final Map<String, Integer> getEquitiesFreeNewMap() {
        return this.equitiesFreeNewMap;
    }

    public final int getVipStatus() {
        return this.vipStatus;
    }

    public final boolean hasDuVip() {
        if (this.vipStatus == 2) {
            return true;
        }
        return false;
    }

    public VipUserInfo(JSONObject jsonObject) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.currentUserId = "";
        this.vipStatus = 1;
        this.unionVipTypes = CollectionsKt__CollectionsKt.arrayListOf(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN, VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP, VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP);
        this.vipMap = new LinkedHashMap();
        this.equitiesFreeNewMap = new LinkedHashMap();
        this.rawJsonObj = jsonObject;
        try {
            String optString = jsonObject.optString(VipUserInfoKt.KEY_VIP_UID);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_VIP_UID)");
            this.currentUserId = optString;
            this.vipStatus = jsonObject.optInt(VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, 1);
            this.endTime = jsonObject.optLong("end_time", 0L);
            this.ext = new JSONObject(jsonObject.optString("ext"));
            Iterator<String> it = this.unionVipTypes.iterator();
            while (it.hasNext()) {
                String vipType = it.next();
                JSONObject jSONObject = this.ext;
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(vipType)) != null) {
                    Map<String, VipExtensionInfo> map = this.vipMap;
                    Intrinsics.checkNotNullExpressionValue(vipType, "vipType");
                    map.put(vipType, new VipExtensionInfo(optJSONObject));
                }
            }
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
        if (r6 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
        if (r6 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b7, code lost:
        if (r6 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean hasUnionVipType(String type) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(type, "type");
        int hashCode = type.hashCode();
        boolean z5 = true;
        if (hashCode != -1183781741) {
            if (hashCode != -797598457) {
                if (hashCode != -796860669 || !type.equals(VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP) || this.vipStatus != 2) {
                    return false;
                }
                if (this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP) != null) {
                    VipExtensionInfo vipExtensionInfo = this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP);
                    if (vipExtensionInfo != null && vipExtensionInfo.getCate() == 5) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                }
                z5 = false;
            } else if (!type.equals(VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP) || this.vipStatus != 2) {
                return false;
            } else {
                if (this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP) != null) {
                    VipExtensionInfo vipExtensionInfo2 = this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP);
                    if (vipExtensionInfo2 != null && vipExtensionInfo2.getCate() == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                z5 = false;
            }
        } else if (!type.equals(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN)) {
            return false;
        } else {
            if (this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN) != null) {
                VipExtensionInfo vipExtensionInfo3 = this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN);
                if (vipExtensionInfo3 != null && vipExtensionInfo3.getCate() == 4) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    VipExtensionInfo vipExtensionInfo4 = this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN);
                    if (vipExtensionInfo4 != null && vipExtensionInfo4.getStatus() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            z5 = false;
        }
        return z5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(VipUserInfo other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.vipStatus == other.vipStatus && this.endTime == other.endTime && VipUserInfoKt.compare(this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN), other.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_SPOKES_MAN)) == 0 && VipUserInfoKt.compare(this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP), other.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_VIP)) == 0 && VipUserInfoKt.compare(this.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP), other.vipMap.get(VipUserInfoKt.UNION_VIP_TYPE_PAN_SVIP)) == 0) {
            return 0;
        }
        return 1;
    }

    public final boolean isUnActivity(String unionVipType) {
        Intrinsics.checkNotNullParameter(unionVipType, "unionVipType");
        VipExtensionInfo vipExtensionInfo = this.vipMap.get(unionVipType);
        if (vipExtensionInfo == null || vipExtensionInfo.getStatus() != 0) {
            return false;
        }
        return true;
    }

    public final void setCurrentUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentUserId = str;
    }

    public final void setEquitiesFreeNewMap(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.equitiesFreeNewMap = map;
    }

    public final boolean isChangedVipStatus(String accountUid, int i) {
        Boolean bool;
        boolean z;
        Intrinsics.checkNotNullParameter(accountUid, "accountUid");
        String str = this.currentUserId;
        if (str != null) {
            bool = Boolean.valueOf(str.equals(accountUid));
        } else {
            bool = null;
        }
        boolean booleanValue = bool.booleanValue();
        int i2 = this.vipStatus;
        if ((i2 != i && i2 == 3 && i == 1) || this.vipStatus == i) {
            z = true;
        } else {
            z = false;
        }
        if (booleanValue && z) {
            return false;
        }
        return true;
    }

    public final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VipUserInfoKt.KEY_VIP_UID, this.currentUserId);
            jSONObject.put(VipUserInfoKt.KEY_VIP_MAIN_VIP_STATUS, this.vipStatus);
            jSONObject.put("end_time", this.endTime);
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, VipExtensionInfo> entry : this.vipMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue().toJsonObject());
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("ext", jSONObject2);
        } catch (Exception e) {
            Log.d(VipUserInfoKt.VIP_USER_INFO_TAG, "parse vip user info to json error: ", e);
        }
        return jSONObject;
    }
}
