package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bXA = new ArrayList<>();
    private int bXB;

    public ArrayList<String> agS() {
        return this.bXA;
    }

    public int agT() {
        return this.bXB;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bXB = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bXA.add(str);
            }
        }
        if (this.bXA.size() <= 0) {
            return false;
        }
        this.bXB = colorEgg.style_flag.intValue();
        return true;
    }
}
