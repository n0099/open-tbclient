package com.baidu.searchbox.live.data.constant;

import com.baidu.searchbox.live.impl.LiveNpsGetSwitchManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\f\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0002\u001a\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0002\u001a\r\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0002\"\u0016\u0010\b\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\t\"\u0016\u0010\u000b\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"", "getHostUrl", "()Ljava/lang/String;", "getLiveRoomStatusUrl", "getLiveTypeUrl", "getRoomEnterUrl", "getRoomExitUrl", "getSlideListUrl", "CMD_337", "Ljava/lang/String;", "HOST_URL", "SEARCH_BOX_HOST_URL", "lib-live-mini-shell_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MixUrlConfigKt {
    public static final String CMD_337 = "337";
    @JvmField
    public static String HOST_URL = getHostUrl();
    public static final String SEARCH_BOX_HOST_URL = "https://mbd.baidu.com";

    public static final String getHostUrl() {
        return LiveNpsGetSwitchManager.HOST_URL;
    }

    public static final String getLiveRoomStatusUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/searchbox?action=liveshow&cmd=337", Arrays.copyOf(new Object[]{"https://mbd.baidu.com"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getLiveTypeUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/bdlive/room/templateInfo?", Arrays.copyOf(new Object[]{HOST_URL}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getRoomEnterUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/bdlive/room/enter", Arrays.copyOf(new Object[]{HOST_URL}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getRoomExitUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/bdlive/room/exit", Arrays.copyOf(new Object[]{HOST_URL}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getSlideListUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/bdlive/room/slidelist?", Arrays.copyOf(new Object[]{HOST_URL}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
