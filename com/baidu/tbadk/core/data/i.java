package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class i {
    private ArrayList<String> Vh = new ArrayList<>();
    private int Vi;

    public ArrayList<String> rU() {
        return this.Vh;
    }

    public int rV() {
        return this.Vi;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vi = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Vh.add(str);
            }
        }
        if (this.Vh.size() <= 0) {
            return false;
        }
        this.Vi = colorEgg.style_flag.intValue();
        return true;
    }
}
