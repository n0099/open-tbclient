package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> NJ = new ArrayList<>();
    private int NK;

    public ArrayList<String> ox() {
        return this.NJ;
    }

    public int oy() {
        return this.NK;
    }

    public boolean a(ColorEgg colorEgg) {
        this.NK = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.NJ.add(str);
            }
        }
        if (this.NJ.size() <= 0) {
            return false;
        }
        this.NK = colorEgg.style_flag.intValue();
        return true;
    }
}
