package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cOi = new ArrayList<>();
    private int cOj;

    public ArrayList<String> aAv() {
        return this.cOi;
    }

    public int aAw() {
        return this.cOj;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cOj = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cOi.add(str);
            }
        }
        if (this.cOi.size() <= 0) {
            return false;
        }
        this.cOj = colorEgg.style_flag.intValue();
        return true;
    }
}
