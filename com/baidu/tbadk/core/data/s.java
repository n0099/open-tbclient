package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> dHZ = new ArrayList<>();
    private int dIa;

    public ArrayList<String> aQr() {
        return this.dHZ;
    }

    public int aQs() {
        return this.dIa;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dIa = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dHZ.add(str);
            }
        }
        if (this.dHZ.size() <= 0) {
            return false;
        }
        this.dIa = colorEgg.style_flag.intValue();
        return true;
    }
}
