package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> dBG = new ArrayList<>();
    private int dBH;

    public ArrayList<String> aOE() {
        return this.dBG;
    }

    public int aOF() {
        return this.dBH;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dBH = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dBG.add(str);
            }
        }
        if (this.dBG.size() <= 0) {
            return false;
        }
        this.dBH = colorEgg.style_flag.intValue();
        return true;
    }
}
