package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> ahn = new ArrayList<>();
    private int aho;

    public ArrayList<String> uM() {
        return this.ahn;
    }

    public int uN() {
        return this.aho;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aho = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.ahn.add(str);
            }
        }
        if (this.ahn.size() <= 0) {
            return false;
        }
        this.aho = colorEgg.style_flag.intValue();
        return true;
    }
}
