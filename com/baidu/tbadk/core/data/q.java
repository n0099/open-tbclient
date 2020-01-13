package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cKe = new ArrayList<>();
    private int cKf;

    public ArrayList<String> ayf() {
        return this.cKe;
    }

    public int ayg() {
        return this.cKf;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cKf = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cKe.add(str);
            }
        }
        if (this.cKe.size() <= 0) {
            return false;
        }
        this.cKf = colorEgg.style_flag.intValue();
        return true;
    }
}
