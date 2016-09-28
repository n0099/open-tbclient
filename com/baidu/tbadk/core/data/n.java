package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> Qf = new ArrayList<>();
    private int Qg;

    public ArrayList<String> pu() {
        return this.Qf;
    }

    public int pv() {
        return this.Qg;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Qg = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Qf.add(str);
            }
        }
        if (this.Qf.size() <= 0) {
            return false;
        }
        this.Qg = colorEgg.style_flag.intValue();
        return true;
    }
}
