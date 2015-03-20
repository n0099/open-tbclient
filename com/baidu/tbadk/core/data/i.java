package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class i {
    private ArrayList<String> PC = new ArrayList<>();
    private int PD;

    public ArrayList<String> pW() {
        return this.PC;
    }

    public int pX() {
        return this.PD;
    }

    public boolean a(ColorEgg colorEgg) {
        this.PD = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.PC.add(str);
            }
        }
        if (this.PC.size() <= 0) {
            return false;
        }
        this.PD = colorEgg.style_flag.intValue();
        return true;
    }
}
