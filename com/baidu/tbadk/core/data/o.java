package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Vu = new ArrayList<>();
    private int Vv;

    public ArrayList<String> pC() {
        return this.Vu;
    }

    public int pD() {
        return this.Vv;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vv = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Vu.add(str);
            }
        }
        if (this.Vu.size() <= 0) {
            return false;
        }
        this.Vv = colorEgg.style_flag.intValue();
        return true;
    }
}
