package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Vo = new ArrayList<>();
    private int Vp;

    public ArrayList<String> pE() {
        return this.Vo;
    }

    public int pF() {
        return this.Vp;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Vp = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Vo.add(str);
            }
        }
        if (this.Vo.size() <= 0) {
            return false;
        }
        this.Vp = colorEgg.style_flag.intValue();
        return true;
    }
}
