package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> UG = new ArrayList<>();
    private int UH;

    public ArrayList<String> pE() {
        return this.UG;
    }

    public int pF() {
        return this.UH;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UH = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UG.add(str);
            }
        }
        if (this.UG.size() <= 0) {
            return false;
        }
        this.UH = colorEgg.style_flag.intValue();
        return true;
    }
}
