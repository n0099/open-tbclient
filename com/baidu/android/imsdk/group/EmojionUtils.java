package com.baidu.android.imsdk.group;

import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class EmojionUtils {
    private static ArrayList<Integer> emojionlist = new ArrayList<>();

    static {
        emojionlist.add(128515);
        emojionlist.add(128522);
        emojionlist.add(9786);
        emojionlist.add(128521);
        emojionlist.add(128525);
        emojionlist.add(128536);
        emojionlist.add(128538);
        emojionlist.add(128540);
        emojionlist.add(128541);
        emojionlist.add(128563);
        emojionlist.add(128513);
        emojionlist.add(128532);
        emojionlist.add(128524);
        emojionlist.add(128530);
        emojionlist.add(128547);
        emojionlist.add(128546);
        emojionlist.add(128514);
        emojionlist.add(128557);
        emojionlist.add(128554);
        emojionlist.add(128549);
        emojionlist.add(128560);
        emojionlist.add(128517);
        emojionlist.add(128531);
        emojionlist.add(128555);
        emojionlist.add(128552);
        emojionlist.add(128561);
        emojionlist.add(128544);
        emojionlist.add(128545);
        emojionlist.add(128548);
        emojionlist.add(128534);
        emojionlist.add(128518);
        emojionlist.add(128523);
        emojionlist.add(128567);
        emojionlist.add(128526);
        emojionlist.add(128564);
        emojionlist.add(128565);
        emojionlist.add(128562);
        emojionlist.add(128543);
        emojionlist.add(128520);
        emojionlist.add(128556);
        emojionlist.add(128528);
        emojionlist.add(128533);
        emojionlist.add(128559);
        emojionlist.add(128519);
        emojionlist.add(128527);
        emojionlist.add(128124);
        emojionlist.add(128169);
        emojionlist.add(128293);
        emojionlist.add(10024);
        emojionlist.add(128165);
        emojionlist.add(128162);
        emojionlist.add(128166);
        emojionlist.add(128167);
        emojionlist.add(128164);
        emojionlist.add(128168);
        emojionlist.add(128064);
        emojionlist.add(128068);
        emojionlist.add(128077);
        emojionlist.add(128078);
        emojionlist.add(128076);
        emojionlist.add(128074);
        emojionlist.add(128075);
        emojionlist.add(128591);
        emojionlist.add(128079);
        emojionlist.add(128170);
        emojionlist.add(127939);
        emojionlist.add(128582);
        emojionlist.add(128581);
        emojionlist.add(128583);
        emojionlist.add(128081);
        emojionlist.add(128089);
        emojionlist.add(127872);
        emojionlist.add(127746);
        emojionlist.add(10084);
        emojionlist.add(128139);
        emojionlist.add(128141);
        emojionlist.add(128099);
        emojionlist.add(128054);
        emojionlist.add(128055);
        emojionlist.add(128053);
        emojionlist.add(128052);
        emojionlist.add(127800);
        emojionlist.add(127808);
        emojionlist.add(127801);
        emojionlist.add(127809);
        emojionlist.add(127810);
        emojionlist.add(127794);
        emojionlist.add(127769);
        emojionlist.add(9925);
        emojionlist.add(9889);
        emojionlist.add(9748);
        emojionlist.add(9924);
        emojionlist.add(127752);
        emojionlist.add(127878);
        emojionlist.add(127879);
        emojionlist.add(127875);
        emojionlist.add(127877);
        emojionlist.add(127876);
        emojionlist.add(127873);
        emojionlist.add(127881);
        emojionlist.add(128247);
        emojionlist.add(9742);
        emojionlist.add(128163);
        emojionlist.add(128298);
        emojionlist.add(128176);
        emojionlist.add(127936);
        emojionlist.add(127937);
        emojionlist.add(127938);
        emojionlist.add(9749);
        emojionlist.add(127863);
        emojionlist.add(127874);
        emojionlist.add(127853);
        emojionlist.add(127817);
        emojionlist.add(9888);
        emojionlist.add(128205);
        emojionlist.add(9940);
        emojionlist.add(10062);
        emojionlist.add(9989);
        emojionlist.add(10133);
    }

    public static boolean containsEmoji(String str) {
        LogUtils.d("FXF", "FXF EmojionUtils " + emojionlist.size());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmojiCharacter(char c) {
        return emojionlist.contains(Character.valueOf(c));
    }
}
