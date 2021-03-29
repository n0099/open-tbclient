package com.baidu.mobads.interfaces;
/* loaded from: classes2.dex */
public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    /* loaded from: classes2.dex */
    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8336a;

        ActivityState(String str) {
            this.f8336a = str;
        }

        public static ActivityState parse(String str) {
            ActivityState[] values;
            for (ActivityState activityState : values()) {
                if (activityState.f8336a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8336a;
        }
    }

    /* loaded from: classes2.dex */
    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8338a;

        ScreenSizeMode(String str) {
            this.f8338a = str;
        }

        public static ScreenSizeMode parse(String str) {
            ScreenSizeMode[] values;
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.f8338a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8338a;
        }
    }

    /* loaded from: classes2.dex */
    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR("error");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8340a;

        SlotState(String str) {
            this.f8340a = str;
        }

        public static SlotState parse(String str) {
            SlotState[] values;
            for (SlotState slotState : values()) {
                if (slotState.f8340a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8340a;
        }
    }

    /* loaded from: classes2.dex */
    public enum SlotType {
        SLOT_TYPE_JSSDK("jssdk"),
        SLOT_TYPE_CPU("cpu"),
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS("feed"),
        SLOT_TYPE_INSITE("insite"),
        SLOT_TYPE_SUG("sug"),
        SLOT_TYPE_FULLSCREEN_VIDEO("fvideo"),
        SLOT_TYPE_REWARD_VIDEO("rvideo"),
        SLOT_TYPE_PORTRAIT_VIDEO("pvideo"),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll"),
        SLOT_TYPE_CONTENT("content");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8342a;

        SlotType(String str) {
            this.f8342a = str;
        }

        public static SlotType parse(String str) {
            SlotType[] values;
            for (SlotType slotType : values()) {
                if (slotType.f8342a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8342a;
        }
    }

    /* loaded from: classes2.dex */
    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8344a;

        VideoAssetPlayMode(String str) {
            this.f8344a = str;
        }

        public static VideoAssetPlayMode parse(String str) {
            VideoAssetPlayMode[] values;
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.f8344a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8344a;
        }
    }

    /* loaded from: classes2.dex */
    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8346a;

        VideoState(String str) {
            this.f8346a = str;
        }

        public static VideoState parse(String str) {
            VideoState[] values;
            for (VideoState videoState : values()) {
                if (videoState.f8346a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8346a;
        }
    }

    /* loaded from: classes2.dex */
    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f8348a;

        VisitorAction(String str) {
            this.f8348a = str;
        }

        public static VisitorAction parse(String str) {
            VisitorAction[] values;
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.f8348a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }

        public String getValue() {
            return this.f8348a;
        }
    }
}
