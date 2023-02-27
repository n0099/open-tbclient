package com.baidu.searchbox.live.mix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u0013:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "", "isValid", "()Z", "", "avatar", "Ljava/lang/String;", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "roomId", "getRoomId", "setRoomId", "scheme", "getScheme", "setScheme", "<init>", "()V", "Companion", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixRoomInfo {
    public static final Companion Companion = new Companion(null);
    public String avatar;
    public String roomId;
    public String scheme;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/mix/MixRoomInfo$Companion;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "parse", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/live/mix/MixRoomInfo;", "<init>", "()V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MixRoomInfo parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            MixRoomInfo mixRoomInfo = new MixRoomInfo();
            mixRoomInfo.setRoomId(jSONObject.optString("room_id"));
            mixRoomInfo.setScheme(jSONObject.optString("scheme"));
            mixRoomInfo.setAvatar(jSONObject.optString("avatar"));
            return mixRoomInfo;
        }
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final boolean isValid() {
        boolean z;
        String str = this.scheme;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }
}
