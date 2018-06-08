package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> afd = new ArrayList<>();
    private int afe;

    public ArrayList<String> tS() {
        return this.afd;
    }

    public int tT() {
        return this.afe;
    }

    public boolean a(ColorEgg colorEgg) {
        this.afe = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.afd.add(str);
            }
        }
        if (this.afd.size() <= 0) {
            return false;
        }
        this.afe = colorEgg.style_flag.intValue();
        return true;
    }
}
