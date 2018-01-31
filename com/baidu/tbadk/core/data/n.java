package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aKw = new ArrayList<>();
    private int aKx;

    public ArrayList<String> xk() {
        return this.aKw;
    }

    public int xl() {
        return this.aKx;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aKx = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aKw.add(str);
            }
        }
        if (this.aKw.size() <= 0) {
            return false;
        }
        this.aKx = colorEgg.style_flag.intValue();
        return true;
    }
}
