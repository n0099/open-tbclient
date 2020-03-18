package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cOw = new ArrayList<>();
    private int cOx;

    public ArrayList<String> aAy() {
        return this.cOw;
    }

    public int aAz() {
        return this.cOx;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cOx = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cOw.add(str);
            }
        }
        if (this.cOw.size() <= 0) {
            return false;
        }
        this.cOx = colorEgg.style_flag.intValue();
        return true;
    }
}
