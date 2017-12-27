package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aKv = new ArrayList<>();
    private int aKw;

    public ArrayList<String> xk() {
        return this.aKv;
    }

    public int xl() {
        return this.aKw;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aKw = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aKv.add(str);
            }
        }
        if (this.aKv.size() <= 0) {
            return false;
        }
        this.aKw = colorEgg.style_flag.intValue();
        return true;
    }
}
