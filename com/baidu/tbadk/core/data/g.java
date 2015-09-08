package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> UN = new ArrayList<>();
    private int UO;

    public ArrayList<String> rA() {
        return this.UN;
    }

    public int rB() {
        return this.UO;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UO = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UN.add(str);
            }
        }
        if (this.UN.size() <= 0) {
            return false;
        }
        this.UO = colorEgg.style_flag.intValue();
        return true;
    }
}
