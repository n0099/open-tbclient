package com.baidu.platform.comapi.walknavi.g.b;

import android.text.TextUtils;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4505a = {2130837565, 2130837578, 2130837581, 2130837587, 2130837600, 2130837603, 2130837606, 2130837619, 2130837631, 2130837637, 2130837646, 2130837649, 2130837652, 2130837655, 2130837658, 2130837661, 2130837662, 2130837666, 2130837669, 2130837670, 2130837674, 2130837678, 2130837680, 2130837684, 2130837686, 2130837690, 2130837693, 2130837697, 2130837700, 2130837703, 2130837704, 2130837708, 2130837711, 2130837713, 2130837717, 2130837718, 2130837722, 2130837726, 2130837728, 2130837732, 2130837735, 2130837743, 2130837746, 2130837749, 2130837590, 2130837592, 2130837594, 2130837596, 2130837598, 2130837609, 2130837611, 2130837613, 2130837615, 2130837617, 2130837640, 2130837642, 2130837644, 2130837739, 2130837741, 2130837628, 2130837569, 2130837572, 2130837634, 2130837575, 2130837625, 2130837584};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4506b = {2130837566, 2130837579, 2130837582, 2130837588, 2130837601, 2130837604, 2130837607, 2130837620, 2130837632, 2130837638, 2130837647, 2130837650, 2130837653, 2130837656, 2130837659, 2130837665, 2130837663, 2130837667, 2130837673, 2130837671, 2130837675, 2130837679, 2130837681, 2130837685, 2130837687, 2130837691, 2130837694, 2130837698, 2130837701, 2130837707, 2130837705, 2130837709, 2130837712, 2130837714, 2130837721, 2130837719, 2130837723, 2130837727, 2130837729, 2130837733, 2130837736, 2130837744, 2130837747, 2130837750, 2130837629, 2130837570, 2130837573, 2130837635, 2130837576, 2130837626};
    private static final int[] c = {2130837567, 2130837580, 2130837583, 2130837589, 2130837602, 2130837605, 2130837608, 2130837621, 2130837633, 2130837639, 2130837648, 2130837651, 2130837654, 2130837657, 2130837660, 2130837696, 2130837664, 2130837668, 2130837677, 2130837672, 2130837676, 2130837683, 2130837682, 2130837689, 2130837688, 2130837692, 2130837695, 2130837699, 2130837702, 2130837738, 2130837706, 2130837710, 2130837716, 2130837715, 2130837725, 2130837720, 2130837724, 2130837731, 2130837730, 2130837734, 2130837737, 2130837745, 2130837748, 2130837751, 2130837591, 2130837593, 2130837595, 2130837597, 2130837599, 2130837610, 2130837612, 2130837614, 2130837616, 2130837614, 2130837641, 2130837643, 2130837645, 2130837740, 2130837742, 2130837630, 2130837571, 2130837574, 2130837636, 2130837577, 2130837627, 2130837586};
    private static final String[] d = {"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_turn_left_3branch_left.png", "wn_turn_left_3branch_mid.png", "wn_turn_left_3branch_right.png", "wn_turn_left_2branch_left.png", "wn_turn_left_2branch_right.png", "wn_turn_right_3branch_left.png", "wn_turn_right_3branch_mid.png", "wn_turn_right_3branch_right.png", "wn_turn_right_2branch_left.png", "wn_turn_right_2branch_right.png", "wn_turn_front_3branch_left.png", "wn_turn_front_3branch_center.png", "wn_turn_front_3branch_right.png", "wn_turn_front_2branch_left.png", "wn_turn_front_2branch_right.png", "wn_ship.png", "wn_door.png", "wn_elevator.png", "wn_stair.png", "wn_escalator.png", "wn_security_check.png", "wn_indoor_bianjie.png"};

    public static int[] a(RouteGuideKind routeGuideKind) {
        int[] iArr = new int[2];
        switch (routeGuideKind) {
            case NE_Maneuver_Kind_OverlineBridge:
                iArr[0] = 2130837892;
                iArr[1] = 2130837891;
                break;
            case NE_Maneuver_Kind_UndergroundPassage:
                iArr[0] = 2130837894;
                iArr[1] = 2130837893;
                break;
            case NE_Maneuver_Kind_Park:
                iArr[0] = 2130837896;
                iArr[1] = 2130837895;
                break;
            case NE_Maneuver_Kind_Square:
                iArr[0] = 2130837898;
                iArr[1] = 2130837897;
                break;
            case NE_Maneuver_Kind_Ladder:
                iArr[0] = 2130837900;
                iArr[1] = 2130837899;
                break;
            case NE_Maneuver_Kind_Ferry:
                iArr[0] = 2130837902;
                iArr[1] = 2130837901;
                break;
            case NE_Maneuver_Kind_Bridge:
                iArr[0] = 2130837904;
                iArr[1] = 2130837903;
                break;
            case NE_Maneuver_Kind_Ring:
                iArr[0] = 2130837906;
                iArr[1] = 2130837905;
                break;
            case NE_Maneuver_Kind_SideWalk:
                iArr[0] = 2130837886;
                iArr[1] = 2130837885;
                break;
            case NE_Maneuver_Kind_Sightseeing_Bus:
                iArr[0] = 2130837888;
                iArr[1] = 2130837887;
                break;
            case NE_Maneuver_Kind_Telpher:
                iArr[0] = 2130837890;
                iArr[1] = 2130837889;
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
            if (d[i].equalsIgnoreCase(str) && i < f4505a.length) {
                return f4505a[i];
            }
        }
        return 0;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2130837638;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str) && i < f4506b.length) {
                return f4506b[i];
            }
        }
        return 2130837638;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 2130837639;
        }
        int length = d.length;
        for (int i = 0; i < length; i++) {
            if (d[i].equalsIgnoreCase(str)) {
                return c[i];
            }
        }
        return 2130837639;
    }
}
