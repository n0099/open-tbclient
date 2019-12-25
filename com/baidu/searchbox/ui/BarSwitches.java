package com.baidu.searchbox.ui;
/* loaded from: classes11.dex */
public class BarSwitches {
    private static final int SWITCH_ACTIONBAR = 1;
    private static final int SWITCH_MENU = 2;
    private static final int SWITCH_TITLE = 3;

    private static boolean getSwitch(int i, int i2) {
        return ((1 << (i2 + (-1))) & i) != 0;
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
