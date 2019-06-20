package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bFg = new ArrayList<>();
    private int bFh;

    public ArrayList<String> abH() {
        return this.bFg;
    }

    public int abI() {
        return this.bFh;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bFh = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bFg.add(str);
            }
        }
        if (this.bFg.size() <= 0) {
            return false;
        }
        this.bFh = colorEgg.style_flag.intValue();
        return true;
    }
}
