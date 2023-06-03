package com.baidu.searchbox.player.model;

import com.baidu.searchbox.player.utils.BasicVideoParserKt;
import com.baidu.searchbox.player.utils.VideoSceneModelCreator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0007\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u0007\u001a\u001e\u0010\u000f\u001a\u00020\u0010*\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u001a\u0012\u0010\u0014\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\r\u001a\u0012\u0010\u0016\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0010*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000b\u001a\u0014\u0010\u001a\u001a\u00020\u0010*\u0004\u0018\u00010\u00072\u0006\u0010\u001b\u001a\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"KEY_COMPARE_URI_PATH", "", "KEY_PLAYER_RADIUS", "KEY_SURFACE_UPDATE_MODE", "KEY_WIFI_4G_DUAL_SWITCH", "getClarityStrategyModel", "Lcom/baidu/searchbox/player/model/ClarityStrategyModel;", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "getPlayerRadius", "", "getSurfaceUpdateMode", "", "isOnlyCompareUriPath", "", "isWifi4GDualEnable", "setClarityUrlList", "", BasicVideoParserKt.CLARITY, "Lorg/json/JSONArray;", "clarityStrategyModel", "setOnlyCompareUriPath", "onlyCompareUriPath", "setPlayerRadius", "radius", "setSurfaceUpdateMode", "mode", "setWifi4GDualEnable", "enable", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "BasicVideoSeriesExt")
/* loaded from: classes4.dex */
public final class BasicVideoSeriesExt {
    public static final String KEY_COMPARE_URI_PATH = "key_compare_uri_path";
    public static final String KEY_PLAYER_RADIUS = "key_player_radius";
    public static final String KEY_SURFACE_UPDATE_MODE = "key_surface_update_mode";
    public static final String KEY_WIFI_4G_DUAL_SWITCH = "key_wifi_4g_switch";

    public static final ClarityStrategyModel getClarityStrategyModel(BasicVideoSeries basicVideoSeries) {
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        return basicVideoSeries.getClarityList().getClarityStrategyModel();
    }

    public static final float getPlayerRadius(BasicVideoSeries basicVideoSeries) {
        Float f;
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        Object obj = basicVideoSeries.getExtMap().get(KEY_PLAYER_RADIUS);
        if (obj instanceof Float) {
            f = (Float) obj;
        } else {
            f = null;
        }
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public static final int getSurfaceUpdateMode(BasicVideoSeries basicVideoSeries) {
        Integer num;
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        Object obj = basicVideoSeries.getExtMap().get(KEY_SURFACE_UPDATE_MODE);
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static final boolean isOnlyCompareUriPath(BasicVideoSeries basicVideoSeries) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        Object obj = basicVideoSeries.getExtMap().get(KEY_COMPARE_URI_PATH);
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWifi4GDualEnable(BasicVideoSeries basicVideoSeries) {
        if (basicVideoSeries != null) {
            StringArrayBundle extMap = basicVideoSeries.getExtMap();
            Boolean bool = Boolean.FALSE;
            Object obj = extMap.get(KEY_WIFI_4G_DUAL_SWITCH);
            if (obj instanceof Boolean) {
                bool = obj;
            }
            return bool.booleanValue();
        }
        return false;
    }

    public static final void setClarityUrlList(BasicVideoSeries basicVideoSeries, JSONArray jSONArray, ClarityStrategyModel clarityStrategyModel) {
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        basicVideoSeries.setClarityList(new ClarityUrlList(jSONArray, basicVideoSeries.isFullScreenType(), VideoSceneModelCreator.toSceneModel(basicVideoSeries), clarityStrategyModel));
    }

    public static final void setOnlyCompareUriPath(BasicVideoSeries basicVideoSeries, boolean z) {
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        basicVideoSeries.getExtMap().put(KEY_COMPARE_URI_PATH, Boolean.valueOf(z));
    }

    public static final void setPlayerRadius(BasicVideoSeries basicVideoSeries, float f) {
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        basicVideoSeries.getExtMap().put(KEY_PLAYER_RADIUS, Float.valueOf(f));
    }

    public static final void setSurfaceUpdateMode(BasicVideoSeries basicVideoSeries, int i) {
        Intrinsics.checkNotNullParameter(basicVideoSeries, "<this>");
        basicVideoSeries.getExtMap().put(KEY_SURFACE_UPDATE_MODE, Integer.valueOf(i));
    }

    public static final void setWifi4GDualEnable(BasicVideoSeries basicVideoSeries, boolean z) {
        StringArrayBundle extMap;
        if (basicVideoSeries != null && (extMap = basicVideoSeries.getExtMap()) != null) {
            extMap.put(KEY_WIFI_4G_DUAL_SWITCH, Boolean.valueOf(z));
        }
    }
}
