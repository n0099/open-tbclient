package com.baidu.searchbox.ui;
/* loaded from: classes4.dex */
public class BarSwitches {
    public static final int SWITCH_ACTIONBAR = 1;
    public static final int SWITCH_MENU = 2;
    public static final int SWITCH_TITLE = 3;

    public static boolean getSwitch(int i, int i2) {
        return (i & (1 << (i2 - 1))) != 0;
    }

    public static boolean getActionBarSwitch(int i) {
        return getSwitch(i, 1);
    }

    public static boolean getMenuSwitch(int i) {
        return getSwitch(i, 2);
    }

    public static boolean getTitleSwitch(int i) {
        return getSwitch(i, 3);
    }
}
