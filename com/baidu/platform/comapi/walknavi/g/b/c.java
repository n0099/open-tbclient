package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3018a = {R.drawable.abc_scrubber_track_mtrl_alpha, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_light, R.drawable.abc_vector_test, R.drawable.action_bar_back_pressed, R.drawable.action_bar_black_menu_normal, R.drawable.action_bar_bookmark_trash, R.drawable.activity_join_num_bg_2, R.drawable.ad_icon_sound_open, R.drawable.add_wish_tile_icon_arrow, R.drawable.ai_apps_open_app_button_pressed, R.drawable.aiapp_alertdialog_button_day_bg_right_selector, R.drawable.aiapp_login_and_phonenum_autho_selector, R.drawable.aiapp_menu_item_add_fav_click, R.drawable.aiapp_menu_item_ai_apps_authority_management, R.drawable.aiapp_menu_item_apply_guarantee_selector, R.drawable.aiapp_menu_item_cancel_fav, R.drawable.aiapp_menu_item_day_mode_click, R.drawable.aiapp_menu_item_gamecenter, R.drawable.aiapp_menu_item_gamecenter_click, R.drawable.aiapp_menu_item_night_mode, R.drawable.aiapp_menu_item_restart_click, R.drawable.aiapp_menu_item_share_arrow, R.drawable.aiapp_menu_item_star_click, R.drawable.aiapp_menu_item_stared_click, R.drawable.aiapps_action_bar_add_selector, R.drawable.aiapps_action_bar_back_black_selector, R.drawable.aiapps_action_bar_back_white_normal, R.drawable.aiapps_action_bar_close_black_normal, R.drawable.aiapps_action_bar_exit_black, R.drawable.aiapps_action_bar_exit_black_pressed, R.drawable.aiapps_action_bar_exit_white_selector, R.drawable.aiapps_action_bar_home_black_selector, R.drawable.aiapps_action_bar_home_white_pressed, R.drawable.aiapps_action_bar_menu_black_selector, R.drawable.aiapps_action_bar_menu_normal, R.drawable.aiapps_action_bar_menu_white_pressed, R.drawable.aiapps_action_bar_single_menu_black_normal, R.drawable.aiapps_action_bar_single_menu_black_selector, R.drawable.aiapps_action_sheet_bg, R.drawable.aiapps_auth_dialog_detail_bg, R.drawable.aiapps_checkbox_checked, R.drawable.aiapps_checkbox_normal_disable, R.drawable.aiapps_clickable_toast_view_bg, R.drawable.account_bar_more, R.drawable.account_launch_login_button_shadow, R.drawable.account_launch_login_top_background, R.drawable.account_user_login_img, R.drawable.action_bar_add_bookmarkdir_selector, R.drawable.action_bar_menu_normal, R.drawable.action_bar_menu_normal_selector, R.drawable.action_bar_menu_white_selector, R.drawable.active_view_dot_selected, R.drawable.activity_join_num_bg, R.drawable.addresslist_item_bg_2, R.drawable.ai_apps_home_fragment_button_radius, R.drawable.ai_apps_open_app_buttion_selector, R.drawable.aiapps_big_pic_toast_close, R.drawable.aiapps_big_pic_toast_close_selector, R.drawable.ad_divider_1, R.drawable.abc_spinner_mtrl_am_alpha, R.drawable.abc_switch_track_mtrl_alpha, R.drawable.ad_list_item_bg_2, R.drawable.abc_text_cursor_material, R.drawable.ad_debug_common_bg, R.drawable.abc_textfield_search_activated_mtrl_alpha};
    private static final int[] b = {R.drawable.abc_seekbar_thumb_material, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.account_active_account_check, R.drawable.action_bar_back_selector, R.drawable.action_bar_black_menu_normal_pressed, R.drawable.action_bar_editor_pressed, R.drawable.ad_banner_download_button_bg_normal, R.drawable.ad_list_item_bg, R.drawable.addresslist_item_bg, R.drawable.aiapp_alertdialog_button_day_bg_all_selector, R.drawable.aiapp_alertdialog_button_day_bg_selector, R.drawable.aiapp_login_and_phonenum_autho_selector_dark, R.drawable.aiapp_menu_item_add_fav_selector, R.drawable.aiapp_menu_item_ai_apps_authority_management_click, R.drawable.aiapp_menu_item_day_mode, R.drawable.aiapp_menu_item_cancel_fav_click, R.drawable.aiapp_menu_item_daymode, R.drawable.aiapp_menu_item_guarantee_pressed, R.drawable.aiapp_menu_item_go_gamecenter_selector, R.drawable.aiapp_menu_item_night_mode_click, R.drawable.aiapp_menu_item_restart_selector, R.drawable.aiapp_menu_item_share_arrow_click, R.drawable.aiapp_menu_item_stared, R.drawable.aiapp_menu_slide_indicator_normal, R.drawable.aiapps_action_bar_back_black_normal, R.drawable.aiapps_action_bar_back_normal, R.drawable.aiapps_action_bar_back_white_pressed, R.drawable.aiapps_action_bar_close_black_pressed, R.drawable.aiapps_action_bar_exit_white_pressed, R.drawable.aiapps_action_bar_exit_black_selector, R.drawable.aiapps_action_bar_home_black_normal, R.drawable.aiapps_action_bar_home_white_normal, R.drawable.aiapps_action_bar_home_white_selector, R.drawable.aiapps_action_bar_menu_white_normal, R.drawable.aiapps_action_bar_menu_normal_pressed, R.drawable.aiapps_action_bar_menu_white_selector, R.drawable.aiapps_action_bar_single_menu_black_pressed, R.drawable.aiapps_action_bar_single_menu_white_normal, R.drawable.aiapps_action_sheet_scrollbar, R.drawable.aiapps_bear_paw_enter_btn, R.drawable.aiapps_checkbox_checked_disable, R.drawable.aiapps_checkbox_private, R.drawable.aiapps_context_menu_bg, R.drawable.ad_download_progress_button_bg, R.drawable.abc_spinner_textfield_background_material, R.drawable.abc_tab_indicator_material, R.drawable.ad_vr_video_loading, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.ad_debug_view_bg};
    private static final int[] c = {R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.account_active_account_check_1, R.drawable.action_bar_back_white_selector, R.drawable.action_bar_black_menu_normal_selector, R.drawable.action_bar_eidtor_background, R.drawable.ad_banner_download_button_bg_open, R.drawable.ad_list_item_bg_1, R.drawable.addresslist_item_bg_1, R.drawable.aiapp_alertdialog_button_day_bg_left_selector, R.drawable.aiapp_loading_progress, R.drawable.aiapp_menu_item_add_fav, R.drawable.aiapp_menu_item_ai_apps_add_to_launcher_selector, R.drawable.aiapp_menu_item_ai_apps_authority_management_selector, R.drawable.aiapps_action_bar_back_selector, R.drawable.aiapp_menu_item_cancel_fav_selector, R.drawable.aiapp_menu_item_feedback_selector, R.drawable.aiapp_menu_item_restart, R.drawable.aiapp_menu_item_guarantee_normal, R.drawable.aiapp_menu_item_nightmode, R.drawable.aiapp_menu_item_star, R.drawable.aiapp_menu_item_share_arrow_selector, R.drawable.aiapps_action_bar_add_2_selector, R.drawable.aiapp_menu_slide_indicator_selected, R.drawable.aiapps_action_bar_back_black_pressed, R.drawable.aiapps_action_bar_back_pressed, R.drawable.aiapps_action_bar_back_white_selector, R.drawable.aiapps_action_bar_close_black_selector, R.drawable.aiapps_big_pic_toast_btn_bg, R.drawable.aiapps_action_bar_exit_white, R.drawable.aiapps_action_bar_home_black_pressed, R.drawable.aiapps_action_bar_menu_black_pressed, R.drawable.aiapps_action_bar_menu_black_normal, R.drawable.aiapps_action_bar_right_menu_bg_solid, R.drawable.aiapps_action_bar_menu_normal_selector, R.drawable.aiapps_action_bar_right_menu_bg, R.drawable.aiapps_action_bar_single_menu_white_selector, R.drawable.aiapps_action_bar_single_menu_white_pressed, R.drawable.aiapps_ai_games_input_view_bg, R.drawable.aiapps_bear_paw_follow_btn, R.drawable.aiapps_checkbox_normal, R.drawable.aiapps_clickable_toast_icon, R.drawable.aiapps_context_menu_bottom_corner_selector, R.drawable.account_bar_talk, R.drawable.account_launch_login_logo, R.drawable.account_third_login_background_shape, R.drawable.action_bar_add_bookmark_selector, R.drawable.action_bar_back_normal, R.drawable.action_bar_menu_normal_pressed, R.drawable.action_bar_menu_white_normal, R.drawable.action_bar_white, R.drawable.active_view_dot_unselected, R.drawable.action_bar_white, R.drawable.ai_apps_home_fragment_button_pressed, R.drawable.ai_apps_home_fragment_button_selector, R.drawable.ai_apps_open_app_button_normal, R.drawable.aiapps_big_pic_toast_close_clicked, R.drawable.aiapps_black_shimmer_loading, R.drawable.ad_icon_sound_close, R.drawable.abc_switch_thumb_material, R.drawable.abc_tab_indicator_mtrl_alpha, R.drawable.add_wish_return_icon_arrow, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.ad_divider, R.drawable.abc_textfield_search_material};
    private static final String[] d = {"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_turn_left_3branch_left.png", "wn_turn_left_3branch_mid.png", "wn_turn_left_3branch_right.png", "wn_turn_left_2branch_left.png", "wn_turn_left_2branch_right.png", "wn_turn_right_3branch_left.png", "wn_turn_right_3branch_mid.png", "wn_turn_right_3branch_right.png", "wn_turn_right_2branch_left.png", "wn_turn_right_2branch_right.png", "wn_turn_front_3branch_left.png", "wn_turn_front_3branch_center.png", "wn_turn_front_3branch_right.png", "wn_turn_front_2branch_left.png", "wn_turn_front_2branch_right.png", "wn_ship.png", "wn_door.png", "wn_elevator.png", "wn_stair.png", "wn_escalator.png", "wn_security_check.png", "wn_indoor_bianjie.png"};

    public static int[] a(RouteGuideKind routeGuideKind) {
        int[] iArr = new int[2];
        switch (routeGuideKind) {
            case NE_Maneuver_Kind_OverlineBridge:
                iArr[0] = R.drawable.ala_bg_guard_club_qm;
                iArr[1] = R.drawable.ala_bg_guard_club_bd;
                break;
            case NE_Maneuver_Kind_UndergroundPassage:
                iArr[0] = R.drawable.ala_bg_rectangle_stroke_blue;
                iArr[1] = R.drawable.ala_bg_guide_follow_float;
                break;
            case NE_Maneuver_Kind_Park:
                iArr[0] = R.drawable.ala_bg_round_rectangle_alpha80_hk;
                iArr[1] = R.drawable.ala_bg_round_rectangle_alpha20;
                break;
            case NE_Maneuver_Kind_Square:
                iArr[0] = R.drawable.ala_bg_round_rectangle_blue;
                iArr[1] = R.drawable.ala_bg_round_rectangle_alpha80_qm;
                break;
            case NE_Maneuver_Kind_Ladder:
                iArr[0] = R.drawable.ala_bg_round_rectangle_blue_qm;
                iArr[1] = R.drawable.ala_bg_round_rectangle_blue_hk;
                break;
            case NE_Maneuver_Kind_Ferry:
                iArr[0] = R.drawable.ala_bg_round_rectangle_white_up;
                iArr[1] = R.drawable.ala_bg_round_rectangle_white;
                break;
            case NE_Maneuver_Kind_Bridge:
                iArr[0] = R.drawable.ala_bg_ver_guide_follow_float;
                iArr[1] = R.drawable.ala_bg_ver_guide_follow_button;
                break;
            case NE_Maneuver_Kind_Ring:
                iArr[0] = R.drawable.ala_bitmap_default_color_bg_1;
                iArr[1] = R.drawable.ala_bitmap_default_color_bg;
                break;
            case NE_Maneuver_Kind_SideWalk:
                iArr[0] = R.drawable.ala_banner_view_dot_unselected;
                iArr[1] = R.drawable.ala_banner_view_dot_selected_2;
                break;
            case NE_Maneuver_Kind_Sightseeing_Bus:
                iArr[0] = R.drawable.ala_banner_view_dot_unselected_2;
                iArr[1] = R.drawable.ala_banner_view_dot_unselected_1;
                break;
            case NE_Maneuver_Kind_Telpher:
                iArr[0] = R.drawable.ala_bg_guard_club;
                iArr[1] = R.drawable.ala_beauty_item_red_dot;
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
            if (d[i].equalsIgnoreCase(str) && i < f3018a.length) {
                return f3018a[i];
            }
        }
        return 0;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return R.drawable.addresslist_item_bg;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str) && i < b.length) {
                return b[i];
            }
        }
        return R.drawable.addresslist_item_bg;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return R.drawable.addresslist_item_bg_1;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str)) {
                return c[i];
            }
        }
        return R.drawable.addresslist_item_bg_1;
    }
}
