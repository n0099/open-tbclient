package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class i {
    private ArrayList<String> DR = new ArrayList<>();
    private int DS;

    public ArrayList<String> mI() {
        return this.DR;
    }

    public int mJ() {
        return this.DS;
    }

    public boolean a(ColorEgg colorEgg) {
        this.DS = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.DR.add(str);
            }
        }
        if (this.DR.size() <= 0) {
            return false;
        }
        this.DS = colorEgg.style_flag.intValue();
        return true;
    }
}
