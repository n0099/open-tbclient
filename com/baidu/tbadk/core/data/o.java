package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Uv = new ArrayList<>();
    private int Uw;

    public ArrayList<String> py() {
        return this.Uv;
    }

    public int pz() {
        return this.Uw;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Uw = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Uv.add(str);
            }
        }
        if (this.Uv.size() <= 0) {
            return false;
        }
        this.Uw = colorEgg.style_flag.intValue();
        return true;
    }
}
