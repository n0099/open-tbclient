package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> Wb = new ArrayList<>();
    private int Wc;

    public ArrayList<String> pJ() {
        return this.Wb;
    }

    public int pK() {
        return this.Wc;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Wc = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Wb.add(str);
            }
        }
        if (this.Wb.size() <= 0) {
            return false;
        }
        this.Wc = colorEgg.style_flag.intValue();
        return true;
    }
}
