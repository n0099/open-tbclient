package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aLQ = new ArrayList<>();
    private int aLR;

    public ArrayList<String> xQ() {
        return this.aLQ;
    }

    public int xR() {
        return this.aLR;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aLR = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aLQ.add(str);
            }
        }
        if (this.aLQ.size() <= 0) {
            return false;
        }
        this.aLR = colorEgg.style_flag.intValue();
        return true;
    }
}
