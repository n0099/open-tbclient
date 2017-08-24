package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> VX = new ArrayList<>();
    private int VY;

    public ArrayList<String> pJ() {
        return this.VX;
    }

    public int pK() {
        return this.VY;
    }

    public boolean a(ColorEgg colorEgg) {
        this.VY = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.VX.add(str);
            }
        }
        if (this.VX.size() <= 0) {
            return false;
        }
        this.VY = colorEgg.style_flag.intValue();
        return true;
    }
}
