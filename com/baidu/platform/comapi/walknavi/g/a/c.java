package com.baidu.platform.comapi.walknavi.g.a;

import android.text.TextUtils;
import com.baidu.mapapi.bikenavi.model.RouteGuideKind;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c {
    private static final int[] a = {R.drawable.abc_scrubber_track_mtrl_alpha, R.drawable.abc_switch_track_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_light, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_vector_test, R.drawable.account_bar_more, R.drawable.action_bar_black_menu_normal, R.drawable.action_bar_bookmark_trash, R.drawable.action_bar_menu_normal, R.drawable.action_bar_menu_white_normal, R.drawable.active_view_dot_selected, R.drawable.activity_join_num_bg_1, R.drawable.ad_banner_download_button_bg_open, R.drawable.ad_block_item_checkbox_selected, R.drawable.ad_debug_common_bg, R.drawable.ad_download_progress_button_bg, R.drawable.ad_list_item_bg, R.drawable.ad_list_item_bg_1, R.drawable.add_wish_tile_icon_arrow, R.drawable.ai_apps_home_fragment_button_pressed, R.drawable.ai_apps_home_fragment_button_selector, R.drawable.aiapp_alertdialog_button_day_bg_all_selector, R.drawable.aiapp_alertdialog_button_day_bg_right_selector, R.drawable.aiapp_menu_item_add_fav_click, R.drawable.aiapp_menu_item_ai_apps_about_click, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_selector, R.drawable.aiapp_menu_item_ai_apps_authority_management_selector, R.drawable.aiapp_menu_item_ai_apps_home_page_selector, R.drawable.aiapp_menu_item_apply_guarantee_selector, R.drawable.aiapp_menu_item_day_mode, R.drawable.aiapp_menu_item_feedback_selector, R.drawable.aiapp_menu_item_gamecenter_click, R.drawable.aiapp_menu_item_night_mode, R.drawable.aiapp_menu_item_night_mode_click, R.drawable.aiapp_menu_item_restart_selector, R.drawable.aiapp_menu_item_star, R.drawable.aiapp_menu_item_stared, R.drawable.aiapp_menu_item_swan_center_selector, R.drawable.aiapps_action_bar_add_2_selector, R.drawable.aiapps_action_bar_back_black_selector, R.drawable.aiapps_action_bar_back_selector, R.drawable.aiapps_action_bar_back_white_selector, R.drawable.action_bar_back_pressed};
    private static final int[] b = {R.drawable.abc_seekbar_thumb_material, R.drawable.abc_tab_indicator_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.account_active_account_check, R.drawable.account_bar_talk, R.drawable.action_bar_black_menu_normal_pressed, R.drawable.action_bar_editor_pressed, R.drawable.action_bar_menu_normal_pressed, R.drawable.action_bar_menu_white_selector, R.drawable.active_view_dot_unselected, R.drawable.activity_join_num_bg_2, R.drawable.ad_banner_download_pause, R.drawable.ad_divider_1, R.drawable.ad_debug_view_bg, R.drawable.ad_icon_sound_close, R.drawable.add_wish_return_icon_arrow, R.drawable.ad_list_item_bg_2, R.drawable.addresslist_item_bg, R.drawable.ai_apps_home_fragment_button_radius, R.drawable.ai_apps_open_app_buttion_selector, R.drawable.aiapp_alertdialog_button_day_bg_left_selector, R.drawable.aiapp_alertdialog_button_day_bg_selector, R.drawable.aiapp_menu_item_add_fav_selector, R.drawable.aiapp_menu_item_ai_apps_about_selector, R.drawable.aiapp_menu_item_ai_apps_authority_management, R.drawable.aiapp_menu_item_ai_apps_home_page, R.drawable.aiapp_menu_item_cancel_fav_selector, R.drawable.aiapp_menu_item_cancel_fav, R.drawable.aiapp_menu_item_day_mode_click, R.drawable.aiapp_menu_item_gamecenter, R.drawable.aiapp_menu_item_go_gamecenter_selector, R.drawable.aiapp_menu_item_restart_click, R.drawable.aiapp_menu_item_nightmode, R.drawable.aiapp_menu_item_share_arrow, R.drawable.aiapp_menu_item_star_click, R.drawable.aiapp_menu_item_stared_click, R.drawable.aiapp_menu_slide_indicator_normal, R.drawable.aiapps_action_bar_add_selector, R.drawable.aiapps_action_bar_back_normal, R.drawable.aiapps_action_bar_back_white_normal, R.drawable.aiapps_action_bar_close_black_normal, R.drawable.action_bar_back_selector};
    private static final int[] c = {R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_tab_indicator_mtrl_alpha, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_textfield_search_material, R.drawable.account_active_account_check_1, R.drawable.account_user_login_img, R.drawable.action_bar_black_menu_normal_selector, R.drawable.action_bar_eidtor_background, R.drawable.action_bar_menu_normal_selector, R.drawable.action_bar_white, R.drawable.activity_join_num_bg, R.drawable.ad_banner_download_button_bg_normal, R.drawable.ad_banner_download_resume, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_click, R.drawable.ad_divider, R.drawable.ad_icon_sound_open, R.drawable.addresslist_item_bg_2, R.drawable.ad_vr_video_loading, R.drawable.addresslist_item_bg_1, R.drawable.ai_apps_open_app_button_pressed, R.drawable.ai_apps_open_app_button_normal, R.drawable.aiapp_menu_item_add_fav, R.drawable.aiapp_loading_progress, R.drawable.aiapp_menu_item_ai_apps_about, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher, R.drawable.aiapp_menu_item_ai_apps_authority_management_click, R.drawable.aiapp_menu_item_ai_apps_home_page_click, R.drawable.aiapps_action_bar_back_black_pressed, R.drawable.aiapp_menu_item_cancel_fav_click, R.drawable.aiapp_menu_item_daymode, R.drawable.aiapp_menu_item_guarantee_pressed, R.drawable.aiapp_menu_item_guarantee_normal, R.drawable.aiapp_menu_item_share_arrow_selector, R.drawable.aiapp_menu_item_restart, R.drawable.aiapp_menu_item_share_arrow_click, R.drawable.aiapp_menu_item_swan_center_click, R.drawable.aiapp_menu_item_swan_center, R.drawable.aiapp_menu_slide_indicator_selected, R.drawable.aiapps_action_bar_back_black_normal, R.drawable.aiapps_action_bar_back_pressed, R.drawable.aiapps_action_bar_back_white_pressed, R.drawable.aiapps_action_bar_close_black_pressed, R.drawable.action_bar_back_white_selector, R.drawable.abc_switch_thumb_material};
    private static final String[] d = {"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_ship.png"};

    public static int[] a(RouteGuideKind routeGuideKind) {
        int[] iArr = new int[2];
        switch (routeGuideKind) {
            case NE_Maneuver_Kind_OverlineBridge:
                iArr[0] = R.drawable.aiapps_icon_route_st;
                iArr[1] = R.drawable.aiapps_icon_route_en;
                break;
            case NE_Maneuver_Kind_UndergroundPassage:
                iArr[0] = R.drawable.aiapps_keyboard_delete_normal;
                iArr[1] = R.drawable.aiapps_keyboard_arrow_down;
                break;
            case NE_Maneuver_Kind_Park:
                iArr[0] = R.drawable.aiapps_keyboard_delete_selector;
                iArr[1] = R.drawable.aiapps_keyboard_delete_pressed;
                break;
            case NE_Maneuver_Kind_Square:
                iArr[0] = R.drawable.aiapps_keyboard_number_item_selector;
                iArr[1] = R.drawable.aiapps_keyboard_non_number_item_selector;
                break;
            case NE_Maneuver_Kind_Ladder:
                iArr[0] = R.drawable.aiapps_loading_bg;
                iArr[1] = R.drawable.aiapps_loading;
                break;
            case NE_Maneuver_Kind_Ferry:
                iArr[0] = R.drawable.aiapps_loading_light_image_view;
                iArr[1] = R.drawable.aiapps_loading_dark_image_view;
                break;
        }
        return iArr;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str) && i < a.length) {
                return a[i];
            }
        }
        return 0;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str) && i < b.length) {
                return b[i];
            }
        }
        return 0;
    }
}
