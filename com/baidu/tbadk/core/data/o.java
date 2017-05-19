package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Ut = new ArrayList<>();
    private int Uu;

    public ArrayList<String> pG() {
        return this.Ut;
    }

    public int pH() {
        return this.Uu;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Uu = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Ut.add(str);
            }
        }
        if (this.Ut.size() <= 0) {
            return false;
        }
        this.Uu = colorEgg.style_flag.intValue();
        return true;
    }
}
