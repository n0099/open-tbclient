package com.baidu.platform.comapi.walknavi.g.a;

import android.text.TextUtils;
import com.baidu.mapapi.bikenavi.model.RouteGuideKind;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c {
    private static final int[] a = {R.drawable.abc_seekbar_thumb_material, R.drawable.abc_tab_indicator_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.account_active_account_check, R.drawable.active_view_dot_unselected, R.drawable.ad_close_reason_check_bg_2, R.drawable.ad_divider, R.drawable.ad_icon_sound_open, R.drawable.ad_list_item_bg_2, R.drawable.addresslist_item_bg_1, R.drawable.aiapp_alertdialog_button_day_bg_left_selector, R.drawable.aiapp_loading_progress, R.drawable.aiapp_menu_item_add_fav_selector, R.drawable.aiapp_menu_item_ai_apps_about, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_click, R.drawable.aiapp_menu_item_ai_apps_authority_management_click, R.drawable.aiapp_menu_item_ai_apps_authority_management_selector, R.drawable.aiapp_menu_item_bg, R.drawable.aiapp_menu_item_cancel_fav_click, R.drawable.aiapp_menu_item_day_mode, R.drawable.aiapp_menu_item_night_mode, R.drawable.aiapp_menu_item_nightmode, R.drawable.aiapp_menu_item_share_arrow, R.drawable.aiapp_menu_item_text_color_selector, R.drawable.aiapps_action_bar_add_selector, R.drawable.aiapps_action_bar_back_black_selector, R.drawable.aiapps_action_bar_back_selector, R.drawable.aiapps_action_bar_back_white_normal, R.drawable.aiapps_action_bar_black_menu_normal_pressed, R.drawable.aiapps_action_bar_close_black_pressed, R.drawable.aiapps_action_bar_exit_black, R.drawable.aiapps_action_bar_exit_white_pressed, R.drawable.aiapps_action_bar_exit_white_selector, R.drawable.aiapps_action_bar_home_white_normal, R.drawable.aiapps_action_bar_menu_black_pressed, R.drawable.aiapps_action_bar_menu_normal, R.drawable.aiapps_action_bar_menu_white_pressed, R.drawable.aiapps_action_bar_right_menu_bg_solid, R.drawable.aiapps_action_bar_single_menu_white_normal, R.drawable.aiapps_action_sheet_bg, R.drawable.aiapps_bear_paw_enter_btn, R.drawable.ad_banner_download_pause};
    private static final int[] b = {R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_tab_indicator_mtrl_alpha, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_textfield_search_material, R.drawable.account_active_account_check_1, R.drawable.activity_join_num_bg, R.drawable.ad_debug_common_bg, R.drawable.ad_divider_1, R.drawable.ad_list_item_bg, R.drawable.ad_vr_video_loading, R.drawable.addresslist_item_bg_2, R.drawable.aiapp_alertdialog_button_day_bg_right_selector, R.drawable.aiapp_menu_item_add_fav, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher, R.drawable.aiapp_menu_item_ai_apps_about_click, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_selector, R.drawable.aiapp_menu_item_ai_apps_home_page_selector, R.drawable.aiapp_menu_item_ai_apps_home_page, R.drawable.aiapp_menu_item_bg_normal, R.drawable.aiapp_menu_item_cancel_fav_selector, R.drawable.aiapp_menu_item_day_mode_click, R.drawable.aiapp_menu_item_night_mode_click, R.drawable.aiapp_menu_item_restart, R.drawable.aiapp_menu_item_share_arrow_click, R.drawable.aiapp_menu_slide_indicator_normal, R.drawable.aiapps_action_bar_back_black_normal, R.drawable.aiapps_action_bar_back_normal, R.drawable.aiapps_action_bar_black_menu_normal, R.drawable.aiapps_action_bar_back_white_pressed, R.drawable.aiapps_action_bar_black_menu_normal_selector, R.drawable.aiapps_action_bar_close_black_selector, R.drawable.aiapps_action_bar_exit_black_pressed, R.drawable.aiapps_action_bar_home_black_selector, R.drawable.aiapps_action_bar_home_black_normal, R.drawable.aiapps_action_bar_home_white_pressed, R.drawable.aiapps_action_bar_menu_black_selector, R.drawable.aiapps_action_bar_menu_normal_pressed, R.drawable.aiapps_action_bar_menu_white_selector, R.drawable.aiapps_action_bar_single_menu_black_normal, R.drawable.aiapps_action_bar_single_menu_white_pressed, R.drawable.aiapps_action_sheet_scrollbar, R.drawable.aiapps_bear_paw_follow_btn, R.drawable.ad_banner_download_resume};
    private static final int[] c = {R.drawable.abc_seekbar_track_material, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_light, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_vector_test, R.drawable.active_view_dot_selected, R.drawable.activity_join_num_bg_1, R.drawable.ad_debug_view_bg, R.drawable.ad_icon_sound_close, R.drawable.ad_list_item_bg_1, R.drawable.addresslist_item_bg, R.drawable.aiapp_alertdialog_button_day_bg_all_selector, R.drawable.aiapp_alertdialog_button_day_bg_selector, R.drawable.aiapp_menu_item_add_fav_click, R.drawable.aiapps_action_bar_add_2_selector, R.drawable.aiapp_menu_item_ai_apps_about_selector, R.drawable.aiapp_menu_item_ai_apps_authority_management, R.drawable.aiapp_menu_item_cancel_fav, R.drawable.aiapp_menu_item_ai_apps_home_page_click, R.drawable.aiapp_menu_item_bg_press, R.drawable.aiapp_menu_item_feedback_selector, R.drawable.aiapp_menu_item_daymode, R.drawable.aiapp_menu_item_restart_selector, R.drawable.aiapp_menu_item_restart_click, R.drawable.aiapp_menu_item_share_arrow_selector, R.drawable.aiapp_menu_slide_indicator_selected, R.drawable.aiapps_action_bar_back_black_pressed, R.drawable.aiapps_action_bar_back_pressed, R.drawable.aiapps_action_bar_single_menu_black_selector, R.drawable.aiapps_action_bar_back_white_selector, R.drawable.aiapps_action_bar_close_black_normal, R.drawable.aiapps_action_bar_exit_white, R.drawable.aiapps_action_bar_exit_black_selector, R.drawable.aiapps_action_bar_menu_black_normal, R.drawable.aiapps_action_bar_home_black_pressed, R.drawable.aiapps_action_bar_home_white_selector, R.drawable.aiapps_action_bar_menu_white_normal, R.drawable.aiapps_action_bar_menu_normal_selector, R.drawable.aiapps_action_bar_right_menu_bg, R.drawable.aiapps_action_bar_single_menu_black_pressed, R.drawable.aiapps_action_bar_single_menu_white_selector, R.drawable.aiapps_ai_games_input_view_bg, R.drawable.aiapps_big_pic_toast_btn_bg, R.drawable.ad_close_reason_check_bg_1, R.drawable.abc_switch_track_mtrl_alpha};
    private static final String[] d = {"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_ship.png"};

    public static int[] a(RouteGuideKind routeGuideKind) {
        int[] iArr = new int[2];
        switch (routeGuideKind) {
            case NE_Maneuver_Kind_OverlineBridge:
                iArr[0] = R.drawable.aiapps_open_app_button_normal;
                iArr[1] = R.drawable.aiapps_open_app_buttion_selector;
                break;
            case NE_Maneuver_Kind_UndergroundPassage:
                iArr[0] = R.drawable.aiapps_openlocation_go_my_point_bg_shape;
                iArr[1] = R.drawable.aiapps_open_app_button_pressed;
                break;
            case NE_Maneuver_Kind_Park:
                iArr[0] = R.drawable.aiapps_permission_denied;
                iArr[1] = R.drawable.aiapps_openlocation_path_selector;
                break;
            case NE_Maneuver_Kind_Square:
                iArr[0] = R.drawable.aiapps_person_header_new_dot;
                iArr[1] = R.drawable.aiapps_person_center_dot;
                break;
            case NE_Maneuver_Kind_Ladder:
                iArr[0] = R.drawable.aiapps_progress_thumb;
                iArr[1] = R.drawable.aiapps_personal_swan_label_bg;
                break;
            case NE_Maneuver_Kind_Ferry:
                iArr[0] = R.drawable.aiapps_pull_refresh_arrow_down;
                iArr[1] = R.drawable.aiapps_property_window_bg;
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
