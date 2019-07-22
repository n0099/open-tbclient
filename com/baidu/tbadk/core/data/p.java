package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bGh = new ArrayList<>();
    private int bGi;

    public ArrayList<String> acJ() {
        return this.bGh;
    }

    public int acK() {
        return this.bGi;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bGi = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bGh.add(str);
            }
        }
        if (this.bGh.size() <= 0) {
            return false;
        }
        this.bGi = colorEgg.style_flag.intValue();
        return true;
    }
}
