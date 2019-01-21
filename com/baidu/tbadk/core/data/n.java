package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> ara = new ArrayList<>();
    private int arb;

    public ArrayList<String> yu() {
        return this.ara;
    }

    public int yv() {
        return this.arb;
    }

    public boolean a(ColorEgg colorEgg) {
        this.arb = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.ara.add(str);
            }
        }
        if (this.ara.size() <= 0) {
            return false;
        }
        this.arb = colorEgg.style_flag.intValue();
        return true;
    }
}
