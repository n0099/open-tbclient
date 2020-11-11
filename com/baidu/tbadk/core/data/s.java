package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> eAc = new ArrayList<>();
    private int eAd;

    public ArrayList<String> bkC() {
        return this.eAc;
    }

    public int bkD() {
        return this.eAd;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eAd = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eAc.add(str);
            }
        }
        if (this.eAc.size() <= 0) {
            return false;
        }
        this.eAd = colorEgg.style_flag.intValue();
        return true;
    }
}
