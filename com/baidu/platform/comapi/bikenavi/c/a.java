package com.baidu.platform.comapi.bikenavi.c;

import android.text.TextUtils;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4149a = {R.animator.design_appbar_state_list_animator, R.animator.design_fab_hide_motion_spec, R.animator.design_fab_show_motion_spec, R.animator.ksad_design_appbar_state_list_animator, R.animator.mtrl_btn_state_list_anim, R.animator.mtrl_btn_unelevated_state_list_anim, R.animator.mtrl_chip_state_list_anim, R.animator.mtrl_fab_hide_motion_spec, R.animator.mtrl_fab_show_motion_spec, R.animator.mtrl_fab_transformation_sheet_collapse_spec, 2130837519, 2130837520, 2130837521, 2130837522, 2130837523, 2130837530, 2130837529, 2130837531, 2130837533, 2130837532, 2130837534, 2130837535, 2130837536, 2130837537, 2130837538, 2130837539, 2130837540, 2130837541, 2130837542, 2130837549, 2130837548, 2130837550, 2130837551, 2130837552, 2130837554, 2130837553, 2130837555, 2130837556, 2130837557, 2130837558, 2130837559, 2130837560, 2130837561, 2130837562, 2130837526, 2130837527, 2130837528, 2130837524, 2130837525, 2130837545, 2130837546, 2130837547, 2130837543, 2130837544, 2130837517, 2130837516, 2130837518, R.animator.mtrl_fab_transformation_sheet_expand_spec, 2130837515};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f4150b = {"bn_dest.png", "bn_faraway_route", "bn_gps.png", "bn_ladder.png", "bn_overline_bridge.png", "bn_park.png", "bn_reroute.png", "bn_ring.png", "bn_square.png", "bn_start.png", "bn_turn_front.png", "bn_turn_goto_leftroad_front.png", "bn_turn_goto_leftroad_uturn.png", "bn_turn_goto_rightroad_front.png", "bn_turn_goto_rightroad_uturn.png", "bn_turn_left.png", "bn_turn_left_back.png", "bn_turn_left_diagonal_passroad_front.png", "bn_turn_left_diagonal_passroad_left.png", "bn_turn_left_diagonal_passroad_left_back.png", "bn_turn_left_diagonal_passroad_left_front.png", "bn_turn_left_diagonal_passroad_right.png", "bn_turn_left_diagonal_passroad_right_front.png", "bn_turn_left_front.png", "bn_turn_left_front_straight.png", "bn_turn_left_passroad_front.png", "bn_turn_left_passroad_uturn.png", "bn_turn_passroad_left.png", "bn_turn_passroad_right.png", "bn_turn_right.png", "bn_turn_right_back.png", "bn_turn_right_diagonal_passroad_front.png", "bn_turn_right_diagonal_passroad_left.png", "bn_turn_right_diagonal_passroad_left_front.png", "bn_turn_right_diagonal_passroad_right.png", "bn_turn_right_diagonal_passroad_right_back.png", "bn_turn_right_diagonal_passroad_right_front.png", "bn_turn_right_front.png", "bn_turn_right_front_straight.png", "bn_turn_right_passroad_front.png", "bn_turn_right_passroad_uturn.png", "bn_underground_passage.png", "bn_uturn.png", "wn_waypoint.png", "bn_turn_left_3branch_left.png", "bn_turn_left_3branch_mid.png", "bn_turn_left_3branch_right.png", "bn_turn_left_2branch_left.png", "bn_turn_left_2branch_right.png", "bn_turn_right_3branch_left.png", "bn_turn_right_3branch_mid.png", "bn_turn_right_3branch_right.png", "bn_turn_right_2branch_left.png", "bn_turn_right_2branch_right.png", "bn_turn_front_3branch_left.png", "bn_turn_front_3branch_center.png", "bn_turn_front_3branch_right.png", "bn_turn_front_2branch_left.png", "bn_turn_front_2branch_right.png"};

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = f4150b.length;
        for (int i = 0; i < length; i++) {
            if (f4150b[i].equalsIgnoreCase(str) && i < f4149a.length) {
                return f4149a[i];
            }
        }
        return 0;
    }
}
