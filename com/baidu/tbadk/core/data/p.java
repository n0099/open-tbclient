package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> Uf = new ArrayList<>();
    private int Ug;

    public ArrayList<String> pv() {
        return this.Uf;
    }

    public int pw() {
        return this.Ug;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Ug = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Uf.add(str);
            }
        }
        if (this.Uf.size() <= 0) {
            return false;
        }
        this.Ug = colorEgg.style_flag.intValue();
        return true;
    }
}
