package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class t {
    private ArrayList<String> eKx = new ArrayList<>();
    private int eKy;

    public ArrayList<String> blx() {
        return this.eKx;
    }

    public int bly() {
        return this.eKy;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eKy = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eKx.add(str);
            }
        }
        if (this.eKx.size() <= 0) {
            return false;
        }
        this.eKy = colorEgg.style_flag.intValue();
        return true;
    }
}
