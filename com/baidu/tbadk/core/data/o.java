package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Vc = new ArrayList<>();
    private int Vd;

    public ArrayList<String> px() {
        return this.Vc;
    }

    public int py() {
        return this.Vd;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vd = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Vc.add(str);
            }
        }
        if (this.Vc.size() <= 0) {
            return false;
        }
        this.Vd = colorEgg.style_flag.intValue();
        return true;
    }
}
