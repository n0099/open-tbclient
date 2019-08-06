package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bGi = new ArrayList<>();
    private int bGj;

    public ArrayList<String> acK() {
        return this.bGi;
    }

    public int acL() {
        return this.bGj;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bGj = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bGi.add(str);
            }
        }
        if (this.bGi.size() <= 0) {
            return false;
        }
        this.bGj = colorEgg.style_flag.intValue();
        return true;
    }
}
