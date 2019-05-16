package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bFf = new ArrayList<>();
    private int bFg;

    public ArrayList<String> abH() {
        return this.bFf;
    }

    public int abI() {
        return this.bFg;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bFg = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bFf.add(str);
            }
        }
        if (this.bFf.size() <= 0) {
            return false;
        }
        this.bFg = colorEgg.style_flag.intValue();
        return true;
    }
}
