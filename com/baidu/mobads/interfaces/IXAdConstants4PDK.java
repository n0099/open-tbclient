package com.baidu.mobads.interfaces;

import com.baidu.fsg.face.base.b.c;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes3.dex */
public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    /* loaded from: classes3.dex */
    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        
        private final String a;

        VideoAssetPlayMode(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static VideoAssetPlayMode parse(String str) {
            VideoAssetPlayMode[] values;
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        
        private final String a;

        ScreenSizeMode(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static ScreenSizeMode parse(String str) {
            ScreenSizeMode[] values;
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        
        private final String a;

        VideoState(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static VideoState parse(String str) {
            VideoState[] values;
            for (VideoState videoState : values()) {
                if (videoState.a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        
        private final String a;

        ActivityState(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static ActivityState parse(String str) {
            ActivityState[] values;
            for (ActivityState activityState : values()) {
                if (activityState.a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR(BdStatsConstant.StatsType.ERROR);
        
        private final String a;

        SlotState(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static SlotState parse(String str) {
            SlotState[] values;
            for (SlotState slotState : values()) {
                if (slotState.a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum SlotType {
        SLOT_TYPE_JSSDK("jssdk"),
        SLOT_TYPE_CPU(c.i),
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS("feed"),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll");
        
        private final String a;

        SlotType(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static SlotType parse(String str) {
            SlotType[] values;
            for (SlotType slotType : values()) {
                if (slotType.a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        
        private final String a;

        VisitorAction(String str) {
            this.a = str;
        }

        public String getValue() {
            return this.a;
        }

        public static VisitorAction parse(String str) {
            VisitorAction[] values;
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }
    }
}
