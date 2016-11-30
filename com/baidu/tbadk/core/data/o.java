package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Qx = new ArrayList<>();
    private int Qy;

    public ArrayList<String> px() {
        return this.Qx;
    }

    public int py() {
        return this.Qy;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Qy = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Qx.add(str);
            }
        }
        if (this.Qx.size() <= 0) {
            return false;
        }
        this.Qy = colorEgg.style_flag.intValue();
        return true;
    }
}
