package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class g {
    private ArrayList<String> Vw = new ArrayList<>();
    private int Vx;

    public ArrayList<String> rq() {
        return this.Vw;
    }

    public int rr() {
        return this.Vx;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vx = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Vw.add(str);
            }
        }
        if (this.Vw.size() <= 0) {
            return false;
        }
        this.Vx = colorEgg.style_flag.intValue();
        return true;
    }
}
