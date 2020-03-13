package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class q {
    private ArrayList<String> cOj = new ArrayList<>();
    private int cOk;

    public ArrayList<String> aAv() {
        return this.cOj;
    }

    public int aAw() {
        return this.cOk;
    }

    public boolean a(ColorEgg colorEgg) {
        this.cOk = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.cOj.add(str);
            }
        }
        if (this.cOj.size() <= 0) {
            return false;
        }
        this.cOk = colorEgg.style_flag.intValue();
        return true;
    }
}
