package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FloatingStatPlugin extends AbsPlugin {
    public static final String KEY_FLOATING_POSITION = "playerPosition";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final UBCManager UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    public static final String VALUE_CLICK = "click";
    public static final String VALUE_LAST = "last";
    public static final String VALUE_NEXT = "next";
    public static final String VALUE_SHOW = "show";
    public Flow mFlow;
    public BDVideoPlayerUbcContent mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private void finishFlow() {
        String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(this.mUBCContent.getExtStatisticsLog(), this.mUBCContent, (JSONObject) null);
        Flow flow = this.mFlow;
        if (flow != null) {
            UBC_MANAGER.flowSetValueWithDuration(flow, ubcContent);
            UBC_MANAGER.flowEnd(this.mFlow);
            this.mFlow = null;
        }
    }

    private void startFlow() {
        this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING_DURATION);
    }

    private void onFloatingBack(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            jSONObject.put("value", "restore");
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
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

    private void reportFloatingDurationFlow(boolean z) {
        updateFloatingExtLog(z);
        finishFlow();
        startFlow();
    }

    public void updateFloatingExtLog(boolean z) {
        try {
            JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
            if (z) {
                extStatisticsLog.put(KEY_FLOATING_POSITION, "inapp");
            } else {
                extStatisticsLog.put(KEY_FLOATING_POSITION, "outapp");
            }
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingDragEnd(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "miniwindow_move");
            JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
            extStatisticsLog.put("pos", i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingGestureScale(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, boolean z) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            jSONObject.put("value", "zoom");
            JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
            if (z) {
                str = "in";
            } else {
                str = "out";
            }
            extStatisticsLog.put("state", str);
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingPlayClick(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, boolean z) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            if (z) {
                str = DownloadStatisticConstants.UBC_TYPE_PAUSE;
            } else {
                str = "play";
            }
            jSONObject.put("value", str);
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
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

    private void onFloatingVideoSwitchButtonClick(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, boolean z) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "click");
            if (z) {
                str = "next";
            } else {
                str = VALUE_LAST;
            }
            jSONObject.put("value", str);
            UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
        } catch (JSONException e) {
            if (BDPlayerConfig.isDebug()) {
                e.printStackTrace();
            }
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
            case -1738802822:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_PLAY_CLICK)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1561207561:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_GESTURE_SCALE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1542343859:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_DRAG_END)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1457948794:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_SHOW_IN_APP_FOREGROUND)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -479632527:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_SHOW_IN_APP_BACKGROUND)) {
                    c = 11;
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
            case 414913380:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_BACK)) {
                    c = 5;
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
            case 1601630453:
                if (action.equals(StatisticsEvent.ACTION_FLOATING_VIDEO_SWITCH)) {
                    c = '\t';
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
        switch (c) {
            case 0:
                this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
                return;
            case 1:
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingShow(this.mUBCContent);
                updateFloatingExtLog(true);
                startFlow();
                return;
            case 2:
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                updateFloatingExtLog(videoEvent.getBooleanExtra(18, true));
                onFloatingDismiss(this.mUBCContent);
                finishFlow();
                return;
            case 3:
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingScale(this.mUBCContent, Boolean.valueOf(videoEvent.getBooleanExtra(10)));
                return;
            case 4:
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingClick(this.mUBCContent);
                return;
            case 5:
                onFloatingBack(this.mUBCContent);
                return;
            case 6:
                onFloatingPlayClick(this.mUBCContent, videoEvent.getBooleanExtra(4));
                return;
            case 7:
                onFloatingGestureScale(this.mUBCContent, videoEvent.getBooleanExtra(10));
                return;
            case '\b':
                onFloatingDragEnd(this.mUBCContent, videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                return;
            case '\t':
                onFloatingVideoSwitchButtonClick(this.mUBCContent, videoEvent.getBooleanExtra(4));
                return;
            case '\n':
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                reportFloatingDurationFlow(false);
                return;
            case 11:
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                reportFloatingDurationFlow(true);
                return;
            default:
                return;
        }
    }
}
