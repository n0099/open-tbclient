package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> Xc = new ArrayList<>();
    private int Xd;

    public ArrayList<String> qw() {
        return this.Xc;
    }

    public int qx() {
        return this.Xd;
    }

    public boolean a(ColorEgg colorEgg) {
        this.Xd = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.Xc.add(str);
            }
        }
        if (this.Xc.size() <= 0) {
            return false;
        }
        this.Xd = colorEgg.style_flag.intValue();
        return true;
    }
}
