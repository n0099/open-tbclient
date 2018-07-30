package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aeM = new ArrayList<>();
    private int aeN;

    public ArrayList<String> tK() {
        return this.aeM;
    }

    public int tL() {
        return this.aeN;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aeN = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aeM.add(str);
            }
        }
        if (this.aeM.size() <= 0) {
            return false;
        }
        this.aeN = colorEgg.style_flag.intValue();
        return true;
    }
}
