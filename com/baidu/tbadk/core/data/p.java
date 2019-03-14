package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> bxQ = new ArrayList<>();
    private int bxR;

    public ArrayList<String> Xd() {
        return this.bxQ;
    }

    public int Xe() {
        return this.bxR;
    }

    public boolean a(ColorEgg colorEgg) {
        this.bxR = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.bxQ.add(str);
            }
        }
        if (this.bxQ.size() <= 0) {
            return false;
        }
        this.bxR = colorEgg.style_flag.intValue();
        return true;
    }
}
