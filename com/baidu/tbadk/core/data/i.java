package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class i {
    private ArrayList<String> DO = new ArrayList<>();
    private int DP;

    public ArrayList<String> mB() {
        return this.DO;
    }

    public int mC() {
        return this.DP;
    }

    public boolean a(ColorEgg colorEgg) {
        this.DP = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.DO.add(str);
            }
        }
        if (this.DO.size() <= 0) {
            return false;
        }
        this.DP = colorEgg.style_flag.intValue();
        return true;
    }
}
