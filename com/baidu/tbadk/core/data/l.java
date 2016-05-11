package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class l {
    private ArrayList<String> ND = new ArrayList<>();
    private int NE;

    public ArrayList<String> oQ() {
        return this.ND;
    }

    public int oR() {
        return this.NE;
    }

    public boolean a(ColorEgg colorEgg) {
        this.NE = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.ND.add(str);
            }
        }
        if (this.ND.size() <= 0) {
            return false;
        }
        this.NE = colorEgg.style_flag.intValue();
        return true;
    }
}
