package com.baidu.platform.comapi.walknavi.g.a;

import android.text.TextUtils;
import com.baidu.mapapi.bikenavi.model.RouteGuideKind;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f9985a = {2130837565, 2130837572, 2130837575, 2130837578, 2130837581, 2130837584, 2130837587, 2130837590, 2130837599, 2130837602, 2130837605, 2130837608, 2130837611, 2130837614, 2130837617, 2130837620, 2130837621, 2130837625, 2130837628, 2130837629, 2130837633, 2130837637, 2130837639, 2130837643, 2130837645, 2130837649, 2130837652, 2130837656, 2130837659, 2130837662, 2130837663, 2130837667, 2130837670, 2130837672, 2130837676, 2130837677, 2130837681, 2130837685, 2130837687, 2130837691, 2130837694, 2130837698, 2130837701, 2130837704, 2130837596};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f9986b = {2130837566, 2130837573, 2130837576, 2130837579, 2130837582, 2130837585, 2130837588, 2130837591, 2130837600, 2130837603, 2130837606, 2130837609, 2130837612, 2130837615, 2130837618, 2130837624, 2130837622, 2130837626, 2130837632, 2130837630, 2130837634, 2130837638, 2130837640, 2130837644, 2130837646, 2130837650, 2130837653, 2130837657, 2130837660, 2130837666, 2130837664, 2130837668, 2130837671, 2130837673, 2130837680, 2130837678, 2130837682, 2130837686, 2130837688, 2130837692, 2130837695, 2130837699, 2130837702, 2130837705, 2130837597};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f9987c = {2130837567, 2130837574, 2130837577, 2130837580, 2130837583, 2130837586, 2130837589, 2130837592, 2130837601, 2130837604, 2130837607, 2130837610, 2130837613, 2130837616, 2130837619, 2130837655, 2130837623, 2130837627, 2130837636, 2130837631, 2130837635, 2130837642, 2130837641, 2130837648, 2130837647, 2130837651, 2130837654, 2130837658, 2130837661, 2130837697, 2130837665, 2130837669, 2130837675, 2130837674, 2130837684, 2130837679, 2130837683, 2130837690, 2130837689, 2130837693, 2130837696, 2130837700, 2130837703, 2130837706, 2130837598, 2130837571};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f9988d = {"wn_dest.png", "wn_faraway_route", "wn_gps.png", "wn_ladder.png", "wn_overline_bridge.png", "wn_park.png", "wn_reroute.png", "wn_ring.png", "wn_square.png", "wn_start.png", "wn_turn_front.png", "wn_turn_goto_leftroad_front.png", "wn_turn_goto_leftroad_uturn.png", "wn_turn_goto_rightroad_front.png", "wn_turn_goto_rightroad_uturn.png", "wn_turn_left.png", "wn_turn_left_back.png", "wn_turn_left_diagonal_passroad_front.png", "wn_turn_left_diagonal_passroad_left.png", "wn_turn_left_diagonal_passroad_left_back.png", "wn_turn_left_diagonal_passroad_left_front.png", "wn_turn_left_diagonal_passroad_right.png", "wn_turn_left_diagonal_passroad_right_front.png", "wn_turn_left_front.png", "wn_turn_left_front_straight.png", "wn_turn_left_passroad_front.png", "wn_turn_left_passroad_uturn.png", "wn_turn_passroad_left.png", "wn_turn_passroad_right.png", "wn_turn_right.png", "wn_turn_right_back.png", "wn_turn_right_diagonal_passroad_front.png", "wn_turn_right_diagonal_passroad_left.png", "wn_turn_right_diagonal_passroad_left_front.png", "wn_turn_right_diagonal_passroad_right.png", "wn_turn_right_diagonal_passroad_right_back.png", "wn_turn_right_diagonal_passroad_right_front.png", "wn_turn_right_front.png", "wn_turn_right_front_straight.png", "wn_turn_right_passroad_front.png", "wn_turn_right_passroad_uturn.png", "wn_underground_passage.png", "wn_uturn.png", "wn_waypoint.png", "wn_ship.png"};

    public static int[] a(RouteGuideKind routeGuideKind) {
        int[] iArr = new int[2];
        switch (d.f9989a[routeGuideKind.ordinal()]) {
            case 1:
                iArr[0] = 2130837810;
                iArr[1] = 2130837809;
                break;
            case 2:
                iArr[0] = 2130837812;
                iArr[1] = 2130837811;
                break;
            case 3:
                iArr[0] = 2130837814;
                iArr[1] = 2130837813;
                break;
            case 4:
                iArr[0] = 2130837816;
                iArr[1] = 2130837815;
                break;
            case 5:
                iArr[0] = 2130837818;
                iArr[1] = 2130837817;
                break;
            case 6:
                iArr[0] = 2130837820;
                iArr[1] = 2130837819;
                break;
        }
        return iArr;
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = f9988d.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (f9988d[i2].equalsIgnoreCase(str)) {
                    int[] iArr = f9986b;
                    if (i2 < iArr.length) {
                        return iArr[i2];
                    }
                }
            }
        }
        return 0;
    }

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = f9988d.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (f9988d[i2].equalsIgnoreCase(str)) {
                    int[] iArr = f9985a;
                    if (i2 < iArr.length) {
                        return iArr[i2];
                    }
                }
            }
        }
        return 0;
    }
}
