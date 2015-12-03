package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> UW = new ArrayList<>();
    private int UX;

    public ArrayList<String> rH() {
        return this.UW;
    }

    public int rI() {
        return this.UX;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UX = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UW.add(str);
            }
        }
        if (this.UW.size() <= 0) {
            return false;
        }
        this.UX = colorEgg.style_flag.intValue();
        return true;
    }
}
