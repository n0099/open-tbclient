package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bxO = new ArrayList<>();
    private int bxP;

    public ArrayList<String> Xd() {
        return this.bxO;
    }

    public int Xe() {
        return this.bxP;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bxP = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bxO.add(str);
            }
        }
        if (this.bxO.size() <= 0) {
            return false;
        }
        this.bxP = colorEgg.style_flag.intValue();
        return true;
    }
}
