package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public class LayerEvent extends VideoEvent {
    public static final String ACTION_ADJUST_LIGHT = "layer_event_adjust_light";
    public static final String ACTION_ADJUST_VOLUME = "layer_event_adjust_volume";
    public static final String ACTION_ADJUST_VOLUME_COMPLETE = "action_adjust_volume_complete";
    public static final String ACTION_BARRAGE_CLICK = "layer_event_barrage_click";
    public static final String ACTION_BARRAGE_DISABLE = "layer_event_barrage_disable";
    public static final String ACTION_BARRAGE_EDIT_VIEW_VISIBLE_STATUS = "layer_event_barrage_editView_visible_status";
    public static final String ACTION_BARRAGE_VIEW = "layer_event_barrage_view";
    public static final String ACTION_CHANGE_CLARITY = "layer_event_change_clarity";
    public static final String ACTION_CLARITY_CLICK = "action_clarity_click";
    public static final String ACTION_CLARITY_UPDATE = "action_clarity_update";
    public static final String ACTION_CLICK_NET_TIP = "layer_event_click_net_tip";
    public static final String ACTION_CLICK_REPLAY_BUTTON = "layer_event_click_replay";
    public static final String ACTION_CLICK_RETRY = "layer_event_click_retry";
    public static final String ACTION_CLICK_SHARE = "layer_event_click_share";
    public static final String ACTION_DOUBLE_CLICK = "layer_event_double_click";
    public static final String ACTION_GOODS_CLICK = "action_goods_click";
    public static final String ACTION_HIDE_AIR_PLAY = "layer_event_hide_air_play";
    public static final String ACTION_HIDE_CACHE_LOADING = "layer_event_hide_cache_loading";
    public static final String ACTION_HIDE_END_LAYER = "layer_event_hide_end_layer";
    public static final String ACTION_HIDE_FACE_AI_HEAD_BOX = "action_hide_face_ai_head_box";
    public static final String ACTION_HIDE_MORE_BUTTON = "layer_event_hide_more_button";
    public static final String ACTION_HIDE_MORE_PANEL = "layer_event_hide_more_panel";
    public static final String ACTION_HIDE_PAYMENT_ALBUM = "control_event_hide_payment_album";
    public static final String ACTION_HIDE_POSTER = "layer_event_hide_poster";
    public static final String ACTION_HIDE_PREVIEW_TIPS = "control_hide_preview_tips";
    public static final String ACTION_HIDE_SHARE_PANEL = "layer_event_hide_share_panel";
    public static final String ACTION_HIDE_VOLUME_BAR = "action_hide_volume_bar";
    public static final String ACTION_LANDSCAPE_EXT_DATA = "action_landscape_ext_data";
    public static final String ACTION_LANDSCAPE_SCROLL = "layer_event_landscape_scroll";
    @Deprecated
    public static final String ACTION_LIVE_HIDE_PAYMENT_HAND_ALBUM = "action_event_live_hide_payment_hand_album";
    @Deprecated
    public static final String ACTION_LIVE_HIDE_PREVIEW_TIPS = "action_event_live_hide_preview_tips";
    @Deprecated
    public static final String ACTION_LIVE_SHOW_PAYMENT_HAND_ALBUM = "action_event_live_show_payment_hand_album";
    @Deprecated
    public static final String ACTION_LIVE_SHOW_PREVIEW_TIPS = "action_event_live_show_preview_tips";
    public static final String ACTION_LOCK_SCREEN = "layer_event_lock_screen";
    public static final String ACTION_LONG_PRESS = "layer_event_long_press";
    public static final String ACTION_MUTE_SYNC_TO_ALL_PLAYER = "action_mute_sync_to_all_player";
    public static final String ACTION_NET_ERROR_SHOW = "layer_event_net_error_show";
    public static final String ACTION_NIGHT_MODEL_CHANGED = "layer_event_night_model_changed";
    public static final String ACTION_OFFLINE_HIDE = "layer_event_offline_layer_hide";
    public static final String ACTION_OFFLINE_SHOW = "layer_event_offline_layer_show";
    public static final String ACTION_OPTIMIZE_CONTINUE_TIPS_SHOW = "control_event_optimize_continue_tips_show";
    public static final String ACTION_PANEL_VISIBLE_CHANGED = "layer_event_panel_visible_changed";
    public static final String ACTION_PAYMENT_SHOW_LOADING = "layer_event_show_loading";
    public static final String ACTION_PAYMENT_STATUS = "layer_event_payment_status";
    public static final String ACTION_PAYMENT_UPDATE_PAYMENT_LAYER = "layer_event_update_payment_layer";
    public static final String ACTION_POPUP_SHOW = "action_popup_show";
    public static final String ACTION_POSITION_SLIDE = "layer_event_position_slide";
    public static final String ACTION_POSITION_SLIDE_COMPLETE = "layer_event_position_slide_complete";
    public static final String ACTION_PRAISE_ANIM_START = "layer_event_praise_anim_start";
    public static final String ACTION_SEEK = "layer_event_seek";
    public static final String ACTION_SET_BARRAGE_HINT = "layer_event_set_barrage_hint";
    public static final String ACTION_SET_BARRAGE_HOT_LIST = "layer_event_set_barrage_hot_list";
    public static final String ACTION_SHOW_AIR_PLAY = "layer_event_show_air_play";
    public static final String ACTION_SHOW_FACE_AI_HEAD_BOX = "action_show_face_ai_head_box";
    public static final String ACTION_SHOW_LIMIT_FREE_TIPS = "control_show_limit_free_tips";
    public static final String ACTION_SHOW_PAYMENT_ALBUM = "control_event_show_payment_album";
    public static final String ACTION_SHOW_POSTER = "layer_event_show_poster";
    public static final String ACTION_SHOW_PREVIEW_TIPS = "control_show_preview_tips";
    public static final String ACTION_SHOW_URL_EXPIRE_ERROR = "layer_event_show_url_expire_error";
    public static final String ACTION_SHOW_VOLUME_BAR = "action_show_volume_bar";
    public static final String ACTION_SPEED_CHANGED = "action_speed_changed";
    public static final String ACTION_SPEED_CLICK = "action_speed_click";
    public static final String ACTION_SPEED_PANEL_HIDE = "action_speed_panel_hide";
    public static final String ACTION_SPEED_PANEL_SHOW = "action_speed_panel_show";
    public static final String ACTION_SPEED_TOAST_HIDE = "action_speed_toast_hide";
    public static final String ACTION_SPEED_TOAST_SHOW = "action_speed_toast_show";
    public static final String ACTION_SWITCH_CONTROL_LAYER_VISIBLE = "layer_event_switch_control_layer_visible";
    public static final String ACTION_SWITCH_FLOATING = "layer_event_switch_floating";
    public static final String ACTION_SWITCH_FULL = "layer_event_switch_full";
    public static final String ACTION_SWITCH_HALF = "layer_event_switch_half";
    public static final String ACTION_TOUCH_DOWN = "layer_event_touch_down";
    public static final String ACTION_UPDATE_DOWNLOAD = "layer_event_update_download";
    public static final String ACTION_VIDEO_VIEW_CHANGED = "action_video_view_changed";
    public static final String ACTION_VIDEO_VIEW_RECOVER = "action_video_view_recover";
    public static final String ACTION_WAKE_UP_END = "control_event_wake_up_end";
    public static final String ACTION_WAKE_UP_START = "control_event_wake_up_start";
    public static final int KEY_AUTO_HIDE_PANEL = 10;
    public static final int KEY_BARRAGE_CLICK = 11;
    public static final int KEY_BARRAGE_CONTROLLER = 13;
    public static final int KEY_BARRAGE_EDIT_VIEW_VISIBLE_STATUS = 16;
    public static final int KEY_BARRAGE_ENABLE = 12;
    public static final int KEY_BARRAGE_HOT_LIST = 5;
    public static final int KEY_BARRAGE_REFRESH_FORCE = 14;
    public static final int KEY_BARRAGE_TEXT = 4;
    public static final int KEY_BARRAGE_VIEW = 15;
    public static final int KEY_CHANGE_CLARITY = 7;
    public static final int KEY_CHANGE_CLARITY_PROGRESS = 19;
    public static final int KEY_CURRENT_POSITION = 2;
    public static final int KEY_DOUBLE_CLICK = 6;
    public static final int KEY_GESTURE_VOLUME_PERCENT = 20;
    public static final int KEY_IS_GAPLESS_TYPE = 25;
    public static final int KEY_LANDSCAPE_EXT_DATA = 36;
    public static final int KEY_LANDSCAPE_EXT_DATA_TYPE = 35;
    public static final int KEY_NIGHT_MODEL_CHANGED = 17;
    public static final int KEY_PANEL_SHOW = 9;
    public static final int KEY_PAYMENT_LIMIT_FREE = 23;
    public static final int KEY_PAYMENT_PREVIEW_TIME = 22;
    public static final int KEY_PAYMENT_STATUS = 32;
    public static final int KEY_POPUP_SHOWING = 28;
    public static final int KEY_PREFIX_TYPE = 24;
    public static final int KEY_SEEK = 1;
    public static final int KEY_SEEK_DELTA = 3;
    public static final int KEY_SHOW_PAYMENT_ALBUM_PRICE = 21;
    public static final int KEY_SPEED_CHANGED = 26;
    public static final int KEY_SWITCH_CONTROL_LAYER_VISIBLE = 18;
    public static final int KEY_TOUCH_EVENT_X = 33;
    public static final int KEY_TOUCH_EVENT_Y = 34;
    public static final int KEY_VIDEO_NID = 29;
    public static final int KEY_VIDEO_PREPARE_MODEL = 31;
    public static final int KEY_VIDEO_VIEW_RECOVER = 30;

    public LayerEvent(String str) {
        super(str);
    }

    @NonNull
    @PublicMethod
    public static VideoEvent obtainEvent(@NonNull String str) {
        return VideoEvent.obtain(str, 3);
    }
}
