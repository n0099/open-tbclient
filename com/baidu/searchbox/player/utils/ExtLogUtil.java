package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\f\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\t\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DEFAULT_CTR_VALUE", "", "DNN_Q", "", ExtLogUtil.EXTRA_KEY_CTR_VALUE, "GR_EXT", "parseCtrValue", "extLog", "getCtr", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "logW", "", "Lcom/baidu/searchbox/player/plugin/AbsPlugin;", LocalFilesFilterKt.FILTER_NAME_LOG, "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "ExtLogUtil")
/* loaded from: classes4.dex */
public final class ExtLogUtil {
    public static final float DEFAULT_CTR_VALUE = -1.0f;
    public static final String DNN_Q = "dnn_q";
    public static final String EXTRA_KEY_CTR_VALUE = "EXTRA_KEY_CTR_VALUE";
    public static final String GR_EXT = "gr_ext";

    public static final float getCtr(BasicVideoSeries basicVideoSeries) {
        boolean z;
        if (basicVideoSeries == null) {
            return -1.0f;
        }
        StringArrayBundle extMap = basicVideoSeries.getExtMap();
        Number valueOf = Float.valueOf(-1.0f);
        Object obj = extMap.get(EXTRA_KEY_CTR_VALUE);
        if (obj instanceof Float) {
            valueOf = obj;
        }
        float floatValue = valueOf.floatValue();
        if (floatValue == -1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            float parseCtrValue = parseCtrValue(basicVideoSeries.getExtLog());
            basicVideoSeries.getExtMap().put(EXTRA_KEY_CTR_VALUE, Float.valueOf(parseCtrValue));
            return parseCtrValue;
        }
        return floatValue;
    }

    public static final float parseCtrValue(String str) {
        boolean z;
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            Double d = null;
            if (!(!z)) {
                str = null;
            }
            if (str != null) {
                try {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject(GR_EXT);
                    if (optJSONObject != null) {
                        d = Double.valueOf(optJSONObject.optDouble(DNN_Q, -1.0d));
                    }
                    if (d == null) {
                        return -1.0f;
                    }
                    return (float) d.doubleValue();
                } catch (JSONException e) {
                    BdVideoLog.d(e.getMessage());
                }
            }
        }
        return -1.0f;
    }

    public static final void logW(AbsPlugin absPlugin, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(absPlugin, "<this>");
        if (str != null) {
            BDVideoPlayer bindPlayer = absPlugin.getBindPlayer();
            if (bindPlayer != null) {
                str2 = bindPlayer.wrapMessage(str);
            } else {
                str2 = null;
            }
            BdVideoLog.w(str2);
        }
    }
}
