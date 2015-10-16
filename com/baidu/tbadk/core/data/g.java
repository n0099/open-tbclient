package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> UE = new ArrayList<>();
    private int UF;

    public ArrayList<String> rv() {
        return this.UE;
    }

    public int rw() {
        return this.UF;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UF = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UE.add(str);
            }
        }
        if (this.UE.size() <= 0) {
            return false;
        }
        this.UF = colorEgg.style_flag.intValue();
        return true;
    }
}
