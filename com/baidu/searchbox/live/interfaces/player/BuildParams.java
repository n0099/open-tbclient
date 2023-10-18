package com.baidu.searchbox.live.interfaces.player;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \":\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\u0010J!\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R5\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/BuildParams;", "", "key", "", "value", "getOption", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "v", "", "setOption", "(Ljava/lang/String;Ljava/lang/Object;)V", "cacheKey", "Ljava/lang/String;", "getCacheKey", "()Ljava/lang/String;", "setCacheKey", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "options", "Ljava/util/HashMap;", "getOptions", "()Ljava/util/HashMap;", "", "playerType", "I", "getPlayerType", "()I", "setPlayerType", "(I)V", "roomId", "getRoomId", "setRoomId", "<init>", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class BuildParams {
    public static final Companion Companion = new Companion(null);
    public static final String K_CUID = "cuid";
    public static final String K_DEBUG_LEVEL = "debug_level";
    public static final String K_RTC_ENCRYPT = "rtc_encrypt";
    public static final String K_RTC_STREAM_TIMEOUT_MS = "rtc_stream_timeout_ms";
    public static final String K_VR = "vr_params";
    public String cacheKey;
    public final HashMap<String, Object> options = new HashMap<>();
    public int playerType;
    public String roomId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/BuildParams$Companion;", "", "K_CUID", "Ljava/lang/String;", "K_DEBUG_LEVEL", "K_RTC_ENCRYPT", "K_RTC_STREAM_TIMEOUT_MS", "K_VR", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BuildParams(String str) {
        this.roomId = str;
    }

    public final void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public final void setPlayerType(int i) {
        this.playerType = i;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final HashMap<String, Object> getOptions() {
        return this.options;
    }

    public final int getPlayerType() {
        return this.playerType;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Object getOption(String str, Object obj) {
        boolean z;
        HashMap<String, Object> hashMap = this.options;
        if (hashMap != null && !hashMap.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return obj;
        }
        Object obj2 = hashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return obj;
    }

    public final void setOption(String str, Object obj) {
        this.options.put(str, obj);
    }
}
