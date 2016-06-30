package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class m {
    private ArrayList<String> NC = new ArrayList<>();
    private int ND;

    public ArrayList<String> oI() {
        return this.NC;
    }

    public int oJ() {
        return this.ND;
    }

    public boolean a(ColorEgg colorEgg) {
        this.ND = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.NC.add(str);
            }
        }
        if (this.NC.size() <= 0) {
            return false;
        }
        this.ND = colorEgg.style_flag.intValue();
        return true;
    }
}
