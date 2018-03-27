package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aLG = new ArrayList<>();
    private int aLH;

    public ArrayList<String> xQ() {
        return this.aLG;
    }

    public int xR() {
        return this.aLH;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aLH = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aLG.add(str);
            }
        }
        if (this.aLG.size() <= 0) {
            return false;
        }
        this.aLH = colorEgg.style_flag.intValue();
        return true;
    }
}
