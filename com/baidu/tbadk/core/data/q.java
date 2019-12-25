package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cJT = new ArrayList<>();
    private int cJU;

    public ArrayList<String> axM() {
        return this.cJT;
    }

    public int axN() {
        return this.cJU;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cJU = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cJT.add(str);
            }
        }
        if (this.cJT.size() <= 0) {
            return false;
        }
        this.cJU = colorEgg.style_flag.intValue();
        return true;
    }
}
