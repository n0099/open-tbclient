package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> dnF = new ArrayList<>();
    private int dnG;

    public ArrayList<String> aIJ() {
        return this.dnF;
    }

    public int aIK() {
        return this.dnG;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dnG = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dnF.add(str);
            }
        }
        if (this.dnF.size() <= 0) {
            return false;
        }
        this.dnG = colorEgg.style_flag.intValue();
        return true;
    }
}
