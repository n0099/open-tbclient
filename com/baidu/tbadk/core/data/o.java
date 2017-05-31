package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Ug = new ArrayList<>();
    private int Uh;

    public ArrayList<String> py() {
        return this.Ug;
    }

    public int pz() {
        return this.Uh;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Uh = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Ug.add(str);
            }
        }
        if (this.Ug.size() <= 0) {
            return false;
        }
        this.Uh = colorEgg.style_flag.intValue();
        return true;
    }
}
