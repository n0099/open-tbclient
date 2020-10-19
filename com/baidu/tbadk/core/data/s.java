package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> elJ = new ArrayList<>();
    private int elK;

    public ArrayList<String> bgj() {
        return this.elJ;
    }

    public int bgk() {
        return this.elK;
    }

    public boolean a(ColorEgg colorEgg) {
        this.elK = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.elJ.add(str);
            }
        }
        if (this.elJ.size() <= 0) {
            return false;
        }
        this.elK = colorEgg.style_flag.intValue();
        return true;
    }
}
