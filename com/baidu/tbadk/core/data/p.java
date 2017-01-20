package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class p {
    private ArrayList<String> PE = new ArrayList<>();
    private int PF;

    public ArrayList<String> pq() {
        return this.PE;
    }

    public int pr() {
        return this.PF;
    }

    public boolean a(ColorEgg colorEgg) {
        this.PF = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.PE.add(str);
            }
        }
        if (this.PE.size() <= 0) {
            return false;
        }
        this.PF = colorEgg.style_flag.intValue();
        return true;
    }
}
