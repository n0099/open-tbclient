package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Va = new ArrayList<>();
    private int Vb;

    public ArrayList<String> pD() {
        return this.Va;
    }

    public int pE() {
        return this.Vb;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vb = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Va.add(str);
            }
        }
        if (this.Va.size() <= 0) {
            return false;
        }
        this.Vb = colorEgg.style_flag.intValue();
        return true;
    }
}
