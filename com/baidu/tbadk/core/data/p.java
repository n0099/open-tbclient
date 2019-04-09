package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bxU = new ArrayList<>();
    private int bxV;

    public ArrayList<String> Xa() {
        return this.bxU;
    }

    public int Xb() {
        return this.bxV;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bxV = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bxU.add(str);
            }
        }
        if (this.bxU.size() <= 0) {
            return false;
        }
        this.bxV = colorEgg.style_flag.intValue();
        return true;
    }
}
