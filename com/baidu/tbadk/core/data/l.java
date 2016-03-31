package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class l {
    private ArrayList<String> SR = new ArrayList<>();
    private int SS;

    public ArrayList<String> rw() {
        return this.SR;
    }

    public int rx() {
        return this.SS;
    }

    public boolean a(ColorEgg colorEgg) {
        this.SS = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.SR.add(str);
            }
        }
        if (this.SR.size() <= 0) {
            return false;
        }
        this.SS = colorEgg.style_flag.intValue();
        return true;
    }
}
