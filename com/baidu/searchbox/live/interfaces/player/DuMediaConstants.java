package com.baidu.searchbox.live.interfaces.player;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0003:\u0002\u0003\u0004B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaConstants;", "<init>", "()V", "Companion", "Key", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class DuMediaConstants {
    public static final Companion Companion = new Companion(null);
    public static final int DLNA_PLAY_STATUS = 0;
    public static final int DLNA_PLAY_SUB_STATUS_COMPLETE = 4;
    public static final int DLNA_PLAY_SUB_STATUS_CONNECTED = 5;
    public static final int DLNA_PLAY_SUB_STATUS_IDLE = 0;
    public static final int DLNA_PLAY_SUB_STATUS_PAUSED = 2;
    public static final int DLNA_PLAY_SUB_STATUS_PLAYING = 1;
    public static final int DLNA_PLAY_SUB_STATUS_PREPARED = 3;
    public static final int DLNA_PLAY_SUB_STATUS_UNKNOW = -1;
    public static final int INSTALL_TYPE_CYBER_MEDIA = 1;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_FIRST_DISP_INTERVAL = 904;
    public static final int MEDIA_INFO_RESTART_PLAYED = 956;
    public static final int SEEK_CLOSEST = 3;
    public static final int SEEK_PREVIOUS_SYNC = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaConstants$Key;", "Ljava/lang/Enum;", "<init>", "(Ljava/lang/String;I)V", "INSTALL_TYPE_CYBER_MEDIA", "SEEK_PREVIOUS_SYNC", "SEEK_CLOSEST", "VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING", "VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING", "MEDIA_INFO_RESTART_PLAYED", "MEDIA_INFO_FIRST_DISP_INTERVAL", "MEDIA_INFO_BUFFERING_START", "MEDIA_INFO_BUFFERING_END", "DLNA_PLAY_STATUS", "DLNA_PLAY_SUB_STATUS_UNKNOW", "DLNA_PLAY_SUB_STATUS_IDLE", "DLNA_PLAY_SUB_STATUS_PLAYING", "DLNA_PLAY_SUB_STATUS_PAUSED", "DLNA_PLAY_SUB_STATUS_PREPARED", "DLNA_PLAY_SUB_STATUS_COMPLETE", "DLNA_PLAY_SUB_STATUS_CONNECTED", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public enum Key {
        INSTALL_TYPE_CYBER_MEDIA,
        SEEK_PREVIOUS_SYNC,
        SEEK_CLOSEST,
        VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING,
        VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING,
        MEDIA_INFO_RESTART_PLAYED,
        MEDIA_INFO_FIRST_DISP_INTERVAL,
        MEDIA_INFO_BUFFERING_START,
        MEDIA_INFO_BUFFERING_END,
        DLNA_PLAY_STATUS,
        DLNA_PLAY_SUB_STATUS_UNKNOW,
        DLNA_PLAY_SUB_STATUS_IDLE,
        DLNA_PLAY_SUB_STATUS_PLAYING,
        DLNA_PLAY_SUB_STATUS_PAUSED,
        DLNA_PLAY_SUB_STATUS_PREPARED,
        DLNA_PLAY_SUB_STATUS_COMPLETE,
        DLNA_PLAY_SUB_STATUS_CONNECTED
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003R\u0016\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0003R\u0016\u0010\u0014\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0003¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/player/DuMediaConstants$Companion;", "", "DLNA_PLAY_STATUS", "I", "DLNA_PLAY_SUB_STATUS_COMPLETE", "DLNA_PLAY_SUB_STATUS_CONNECTED", "DLNA_PLAY_SUB_STATUS_IDLE", "DLNA_PLAY_SUB_STATUS_PAUSED", "DLNA_PLAY_SUB_STATUS_PLAYING", "DLNA_PLAY_SUB_STATUS_PREPARED", "DLNA_PLAY_SUB_STATUS_UNKNOW", "INSTALL_TYPE_CYBER_MEDIA", "MEDIA_INFO_BUFFERING_END", "MEDIA_INFO_BUFFERING_START", "MEDIA_INFO_FIRST_DISP_INTERVAL", "MEDIA_INFO_RESTART_PLAYED", "SEEK_CLOSEST", "SEEK_PREVIOUS_SYNC", "VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING", "VIDEO_SCALING_MODE_SCALE_TO_FIT", "VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
