package com.baidu.searchbox.playerserver.ab;
/* loaded from: classes4.dex */
public class PlayConfigABManager {
    public static final String KEY_PLAY_CONFIG_SAVE_SDCARD = "playconfig_save_sdcard_enable";

    public static boolean getBooleanSwitch(String str, boolean z) {
        IPlayConfigABTest aBContext = PlayConfigABContext.getABContext();
        if (aBContext == null) {
            return z;
        }
        return aBContext.getSwitch(str, z);
    }

    public static int getIntSwitch(String str, int i) {
        IPlayConfigABTest aBContext = PlayConfigABContext.getABContext();
        if (aBContext == null) {
            return i;
        }
        return aBContext.getSwitch(str, i);
    }

    public static String getStringSwitch(String str, String str2) {
        IPlayConfigABTest aBContext = PlayConfigABContext.getABContext();
        if (aBContext == null) {
            return str2;
        }
        return aBContext.getSwitch(str, str2);
    }
}
