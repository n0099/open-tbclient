package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class u {
    private ArrayList<String> eMJ = new ArrayList<>();
    private int eMK;

    public ArrayList<String> blP() {
        return this.eMJ;
    }

    public int blQ() {
        return this.eMK;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eMK = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eMJ.add(str);
            }
        }
        if (this.eMJ.size() <= 0) {
            return false;
        }
        this.eMK = colorEgg.style_flag.intValue();
        return true;
    }
}
