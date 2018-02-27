package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aLF = new ArrayList<>();
    private int aLG;

    public ArrayList<String> xQ() {
        return this.aLF;
    }

    public int xR() {
        return this.aLG;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aLG = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aLF.add(str);
            }
        }
        if (this.aLF.size() <= 0) {
            return false;
        }
        this.aLG = colorEgg.style_flag.intValue();
        return true;
    }
}
