package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> amj = new ArrayList<>();
    private int amk;

    public ArrayList<String> wV() {
        return this.amj;
    }

    public int wW() {
        return this.amk;
    }

    public boolean a(ColorEgg colorEgg) {
        this.amk = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.amj.add(str);
            }
        }
        if (this.amj.size() <= 0) {
            return false;
        }
        this.amk = colorEgg.style_flag.intValue();
        return true;
    }
}
