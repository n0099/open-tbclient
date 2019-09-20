package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bGG = new ArrayList<>();
    private int bGH;

    public ArrayList<String> acO() {
        return this.bGG;
    }

    public int acP() {
        return this.bGH;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bGH = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bGG.add(str);
            }
        }
        if (this.bGG.size() <= 0) {
            return false;
        }
        this.bGH = colorEgg.style_flag.intValue();
        return true;
    }
}
