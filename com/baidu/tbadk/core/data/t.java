package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class t {
    private ArrayList<String> eyt = new ArrayList<>();
    private int eyu;

    public ArrayList<String> bjE() {
        return this.eyt;
    }

    public int bjF() {
        return this.eyu;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eyu = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eyt.add(str);
            }
        }
        if (this.eyt.size() <= 0) {
            return false;
        }
        this.eyu = colorEgg.style_flag.intValue();
        return true;
    }
}
