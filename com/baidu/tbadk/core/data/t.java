package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class t {
    private ArrayList<String> ePi = new ArrayList<>();
    private int ePj;

    public ArrayList<String> bpr() {
        return this.ePi;
    }

    public int bps() {
        return this.ePj;
    }

    public boolean a(ColorEgg colorEgg) {
        this.ePj = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.ePi.add(str);
            }
        }
        if (this.ePi.size() <= 0) {
            return false;
        }
        this.ePj = colorEgg.style_flag.intValue();
        return true;
    }
}
