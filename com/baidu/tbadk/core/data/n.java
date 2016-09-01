package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> Qh = new ArrayList<>();
    private int Qi;

    public ArrayList<String> pt() {
        return this.Qh;
    }

    public int pu() {
        return this.Qi;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Qi = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Qh.add(str);
            }
        }
        if (this.Qh.size() <= 0) {
            return false;
        }
        this.Qi = colorEgg.style_flag.intValue();
        return true;
    }
}
