package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Qu = new ArrayList<>();
    private int Qv;

    public ArrayList<String> px() {
        return this.Qu;
    }

    public int py() {
        return this.Qv;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Qv = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Qu.add(str);
            }
        }
        if (this.Qu.size() <= 0) {
            return false;
        }
        this.Qv = colorEgg.style_flag.intValue();
        return true;
    }
}
