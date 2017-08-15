package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> VW = new ArrayList<>();
    private int VX;

    public ArrayList<String> pI() {
        return this.VW;
    }

    public int pJ() {
        return this.VX;
    }

    public boolean a(ColorEgg colorEgg) {
        this.VX = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.VW.add(str);
            }
        }
        if (this.VW.size() <= 0) {
            return false;
        }
        this.VX = colorEgg.style_flag.intValue();
        return true;
    }
}
