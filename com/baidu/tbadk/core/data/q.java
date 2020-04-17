package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> dnB = new ArrayList<>();
    private int dnC;

    public ArrayList<String> aIL() {
        return this.dnB;
    }

    public int aIM() {
        return this.dnC;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dnC = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dnB.add(str);
            }
        }
        if (this.dnB.size() <= 0) {
            return false;
        }
        this.dnC = colorEgg.style_flag.intValue();
        return true;
    }
}
