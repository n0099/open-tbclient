package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class u {
    private ArrayList<String> eOk = new ArrayList<>();
    private int eOl;

    public ArrayList<String> blR() {
        return this.eOk;
    }

    public int blS() {
        return this.eOl;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eOl = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eOk.add(str);
            }
        }
        if (this.eOk.size() <= 0) {
            return false;
        }
        this.eOl = colorEgg.style_flag.intValue();
        return true;
    }
}
