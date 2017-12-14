package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> VV = new ArrayList<>();
    private int VW;

    public ArrayList<String> pH() {
        return this.VV;
    }

    public int pI() {
        return this.VW;
    }

    public boolean a(ColorEgg colorEgg) {
        this.VW = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.VV.add(str);
            }
        }
        if (this.VV.size() <= 0) {
            return false;
        }
        this.VW = colorEgg.style_flag.intValue();
        return true;
    }
}
