package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aqx = new ArrayList<>();
    private int aqy;

    public ArrayList<String> yh() {
        return this.aqx;
    }

    public int yi() {
        return this.aqy;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aqy = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aqx.add(str);
            }
        }
        if (this.aqx.size() <= 0) {
            return false;
        }
        this.aqy = colorEgg.style_flag.intValue();
        return true;
    }
}
