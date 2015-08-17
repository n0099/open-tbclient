package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> UM = new ArrayList<>();
    private int UN;

    public ArrayList<String> rB() {
        return this.UM;
    }

    public int rC() {
        return this.UN;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UN = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UM.add(str);
            }
        }
        if (this.UM.size() <= 0) {
            return false;
        }
        this.UN = colorEgg.style_flag.intValue();
        return true;
    }
}
