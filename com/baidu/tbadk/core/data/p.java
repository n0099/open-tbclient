package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bYr = new ArrayList<>();
    private int bYs;

    public ArrayList<String> agU() {
        return this.bYr;
    }

    public int agV() {
        return this.bYs;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bYs = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bYr.add(str);
            }
        }
        if (this.bYr.size() <= 0) {
            return false;
        }
        this.bYs = colorEgg.style_flag.intValue();
        return true;
    }
}
