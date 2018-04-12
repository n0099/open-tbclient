package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Xb = new ArrayList<>();
    private int Xc;

    public ArrayList<String> qx() {
        return this.Xb;
    }

    public int qy() {
        return this.Xc;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Xc = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Xb.add(str);
            }
        }
        if (this.Xb.size() <= 0) {
            return false;
        }
        this.Xc = colorEgg.style_flag.intValue();
        return true;
    }
}
