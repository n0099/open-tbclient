package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> dZH = new ArrayList<>();
    private int dZI;

    public ArrayList<String> bdA() {
        return this.dZH;
    }

    public int bdB() {
        return this.dZI;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dZI = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dZH.add(str);
            }
        }
        if (this.dZH.size() <= 0) {
            return false;
        }
        this.dZI = colorEgg.style_flag.intValue();
        return true;
    }
}
