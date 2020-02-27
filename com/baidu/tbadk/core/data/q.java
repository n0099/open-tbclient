package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cOh = new ArrayList<>();
    private int cOi;

    public ArrayList<String> aAt() {
        return this.cOh;
    }

    public int aAu() {
        return this.cOi;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cOi = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cOh.add(str);
            }
        }
        if (this.cOh.size() <= 0) {
            return false;
        }
        this.cOi = colorEgg.style_flag.intValue();
        return true;
    }
}
