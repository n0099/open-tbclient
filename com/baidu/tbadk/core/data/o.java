package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> VU = new ArrayList<>();
    private int VV;

    public ArrayList<String> pI() {
        return this.VU;
    }

    public int pJ() {
        return this.VV;
    }

    public boolean a(ColorEgg colorEgg) {
        this.VV = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.VU.add(str);
            }
        }
        if (this.VU.size() <= 0) {
            return false;
        }
        this.VV = colorEgg.style_flag.intValue();
        return true;
    }
}
