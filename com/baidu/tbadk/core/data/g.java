package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> UF = new ArrayList<>();
    private int UG;

    public ArrayList<String> rt() {
        return this.UF;
    }

    public int ru() {
        return this.UG;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UG = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UF.add(str);
            }
        }
        if (this.UF.size() <= 0) {
            return false;
        }
        this.UG = colorEgg.style_flag.intValue();
        return true;
    }
}
