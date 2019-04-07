package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bxT = new ArrayList<>();
    private int bxU;

    public ArrayList<String> Xa() {
        return this.bxT;
    }

    public int Xb() {
        return this.bxU;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bxU = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bxT.add(str);
            }
        }
        if (this.bxT.size() <= 0) {
            return false;
        }
        this.bxU = colorEgg.style_flag.intValue();
        return true;
    }
}
