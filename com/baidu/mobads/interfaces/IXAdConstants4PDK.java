package com.baidu.mobads.interfaces;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes14.dex */
public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    /* loaded from: classes14.dex */
    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3368a;

        VideoAssetPlayMode(String str) {
            this.f3368a = str;
        }

        public String getValue() {
            return this.f3368a;
        }

        public static VideoAssetPlayMode parse(String str) {
            VideoAssetPlayMode[] values;
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.f3368a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3362a;

        ScreenSizeMode(String str) {
            this.f3362a = str;
        }

        public String getValue() {
            return this.f3362a;
        }

        public static ScreenSizeMode parse(String str) {
            ScreenSizeMode[] values;
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.f3362a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3370a;

        VideoState(String str) {
            this.f3370a = str;
        }

        public String getValue() {
            return this.f3370a;
        }

        public static VideoState parse(String str) {
            VideoState[] values;
            for (VideoState videoState : values()) {
                if (videoState.f3370a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3360a;

        ActivityState(String str) {
            this.f3360a = str;
        }

        public String getValue() {
            return this.f3360a;
        }

        public static ActivityState parse(String str) {
            ActivityState[] values;
            for (ActivityState activityState : values()) {
                if (activityState.f3360a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR(BdStatsConstant.StatsType.ERROR);
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3364a;

        SlotState(String str) {
            this.f3364a = str;
        }

        public String getValue() {
            return this.f3364a;
        }

        public static SlotState parse(String str) {
            SlotState[] values;
            for (SlotState slotState : values()) {
                if (slotState.f3364a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum SlotType {
        SLOT_TYPE_JSSDK("jssdk"),
        SLOT_TYPE_CPU("cpu"),
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS(LogConfig.KEY_FEED),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3366a;

        SlotType(String str) {
            this.f3366a = str;
        }

        public String getValue() {
            return this.f3366a;
        }

        public static SlotType parse(String str) {
            SlotType[] values;
            for (SlotType slotType : values()) {
                if (slotType.f3366a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }
    }

    /* loaded from: classes14.dex */
    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f3372a;

        VisitorAction(String str) {
            this.f3372a = str;
        }

        public String getValue() {
            return this.f3372a;
        }

        public static VisitorAction parse(String str) {
            VisitorAction[] values;
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.f3372a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }
    }
}
