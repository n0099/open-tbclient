package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class i {
    private ArrayList<String> Qb = new ArrayList<>();
    private int Qc;

    public ArrayList<String> qC() {
        return this.Qb;
    }

    public int qD() {
        return this.Qc;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Qc = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Qb.add(str);
            }
        }
        if (this.Qb.size() <= 0) {
            return false;
        }
        this.Qc = colorEgg.style_flag.intValue();
        return true;
    }
}
