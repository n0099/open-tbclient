package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FloatingStatPlugin extends AbsPlugin {
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final UBCManager UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final String VALUE_CLICK = "click";
    public static final String VALUE_SHOW = "show";
    public Flow mFlow;
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private void onFloatingClick(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            jSONObject.put("value", "enter");
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onFloatingDismiss(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            jSONObject.put("value", "close");
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onFloatingShow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "show");
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onFloatingScale(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, Boolean bool) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            if (bool.booleanValue()) {
                str = "enlarge";
            } else {
                str = "reduce";
            }
            jSONObject.put("value", str);
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateScaleAndPosition(String str, int i, int i2) {
        try {
            JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
            extStatisticsLog.put("size", str);
            extStatisticsLog.put("pos", i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c;
        super.onVideoEventNotify(videoEvent);
        String action = videoEvent.getAction();
        switch (action.hashCode()) {
            case -2127352417:
                if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -21330261:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_CLICK)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -6829459:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_SCALE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 415426938:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_SHOW)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1787606765:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_DISMISS)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        if (c == 4) {
                            updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                            onFloatingClick(this.mUBCContent);
                            return;
                        }
                        return;
                    }
                    updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                    onFloatingScale(this.mUBCContent, Boolean.valueOf(videoEvent.getBooleanExtra(10)));
                    return;
                }
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingDismiss(this.mUBCContent);
                String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(this.mUBCContent.getExtStatisticsLog(), this.mUBCContent, (JSONObject) null);
                Flow flow = this.mFlow;
                if (flow != null) {
                    UBC_MANAGER.flowSetValueWithDuration(flow, ubcContent);
                    UBC_MANAGER.flowEnd(this.mFlow);
                    this.mFlow = null;
                    return;
                }
                return;
            }
            updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
            onFloatingShow(this.mUBCContent);
            this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING_DURATION);
            return;
        }
        this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
    }
}
