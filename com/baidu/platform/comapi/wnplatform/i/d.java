package com.baidu.platform.comapi.wnplatform.i;

import com.baidu.mapapi.walknavi.model.RouteGuideKind;
/* loaded from: classes7.dex */
/* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f3115a = new int[RouteGuideKind.values().length];

    static {
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Front.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right_Front.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right_Back.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left_Back.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left_Front.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left_Front_Straight.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right_Front_Straight.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Front.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left_PassRoad_Front.ordinal()] = 11;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Front.ordinal()] = 12;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right_PassRoad_Front.ordinal()] = 13;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Left_PassRoad_UTurn.ordinal()] = 14;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Right_PassRoad_UTurn.ordinal()] = 15;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Right_Front.ordinal()] = 16;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left_Front.ordinal()] = 17;
        } catch (NoSuchFieldError e17) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left_Back.ordinal()] = 18;
        } catch (NoSuchFieldError e18) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Left_Front.ordinal()] = 19;
        } catch (NoSuchFieldError e19) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right_Front.ordinal()] = 20;
        } catch (NoSuchFieldError e20) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right_Back.ordinal()] = 21;
        } catch (NoSuchFieldError e21) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Left.ordinal()] = 22;
        } catch (NoSuchFieldError e22) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Left.ordinal()] = 23;
        } catch (NoSuchFieldError e23) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_PassRoad_Left.ordinal()] = 24;
        } catch (NoSuchFieldError e24) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_PassRoad_Right.ordinal()] = 25;
        } catch (NoSuchFieldError e25) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_RightDiagonal_PassRoad_Right.ordinal()] = 26;
        } catch (NoSuchFieldError e26) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_LeftDiagonal_PassRoad_Right.ordinal()] = 27;
        } catch (NoSuchFieldError e27) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Goto_Left_Road.ordinal()] = 28;
        } catch (NoSuchFieldError e28) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Goto_Right_Road.ordinal()] = 29;
        } catch (NoSuchFieldError e29) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Goto_Left_Road_UTurn.ordinal()] = 30;
        } catch (NoSuchFieldError e30) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Goto_Right_Road_UTurn.ordinal()] = 31;
        } catch (NoSuchFieldError e31) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Start.ordinal()] = 32;
        } catch (NoSuchFieldError e32) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Dest.ordinal()] = 33;
        } catch (NoSuchFieldError e33) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_OverlineBridge.ordinal()] = 34;
        } catch (NoSuchFieldError e34) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_UndergroundPassage.ordinal()] = 35;
        } catch (NoSuchFieldError e35) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Ring.ordinal()] = 36;
        } catch (NoSuchFieldError e36) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Park.ordinal()] = 37;
        } catch (NoSuchFieldError e37) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Square.ordinal()] = 38;
        } catch (NoSuchFieldError e38) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Ladder.ordinal()] = 39;
        } catch (NoSuchFieldError e39) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Waypoint.ordinal()] = 40;
        } catch (NoSuchFieldError e40) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_LEFT_THREE_LEFT.ordinal()] = 41;
        } catch (NoSuchFieldError e41) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_LEFT_THREE_MID.ordinal()] = 42;
        } catch (NoSuchFieldError e42) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_LEFT_THREE_RIGHT.ordinal()] = 43;
        } catch (NoSuchFieldError e43) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_LEFT_TWO_LEFT.ordinal()] = 44;
        } catch (NoSuchFieldError e44) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_LEFT_TWO_RIGHT.ordinal()] = 45;
        } catch (NoSuchFieldError e45) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_RIGHT_THREE_LEFT.ordinal()] = 46;
        } catch (NoSuchFieldError e46) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_RIGHT_THREE_MID.ordinal()] = 47;
        } catch (NoSuchFieldError e47) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_RIGHT_THREE_RIGHT.ordinal()] = 48;
        } catch (NoSuchFieldError e48) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_RIGHT_TWO_LEFT.ordinal()] = 49;
        } catch (NoSuchFieldError e49) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_TURN_RIGHT_TWO_RIGHT.ordinal()] = 50;
        } catch (NoSuchFieldError e50) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_STRAIGHT_THREE_LEFT.ordinal()] = 51;
        } catch (NoSuchFieldError e51) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_STRAIGHT_THREE_MID.ordinal()] = 52;
        } catch (NoSuchFieldError e52) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_STRAIGHT_THREE_RIGHT.ordinal()] = 53;
        } catch (NoSuchFieldError e53) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_STRAIGHT_TWO_LEFT.ordinal()] = 54;
        } catch (NoSuchFieldError e54) {
        }
        try {
            f3115a[RouteGuideKind.NE_WTT_NAV_STRAIGHT_TWO_RIGHT.ordinal()] = 55;
        } catch (NoSuchFieldError e55) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Ferry.ordinal()] = 56;
        } catch (NoSuchFieldError e56) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_in_Door.ordinal()] = 57;
        } catch (NoSuchFieldError e57) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_out_Door.ordinal()] = 58;
        } catch (NoSuchFieldError e58) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Elevator.ordinal()] = 59;
        } catch (NoSuchFieldError e59) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Stair.ordinal()] = 60;
        } catch (NoSuchFieldError e60) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Escalator.ordinal()] = 61;
        } catch (NoSuchFieldError e61) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_Security_Check.ordinal()] = 62;
        } catch (NoSuchFieldError e62) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_IndoorStart.ordinal()] = 63;
        } catch (NoSuchFieldError e63) {
        }
        try {
            f3115a[RouteGuideKind.NE_Maneuver_Kind_IndoorDest.ordinal()] = 64;
        } catch (NoSuchFieldError e64) {
        }
    }
}
