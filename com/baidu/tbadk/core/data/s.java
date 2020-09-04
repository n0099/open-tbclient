package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> dXx = new ArrayList<>();
    private int dXy;

    public ArrayList<String> bcG() {
        return this.dXx;
    }

    public int bcH() {
        return this.dXy;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dXy = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dXx.add(str);
            }
        }
        if (this.dXx.size() <= 0) {
            return false;
        }
        this.dXy = colorEgg.style_flag.intValue();
        return true;
    }
}
