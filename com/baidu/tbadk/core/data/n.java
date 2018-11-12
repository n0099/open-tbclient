package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> amW = new ArrayList<>();
    private int amX;

    public ArrayList<String> xd() {
        return this.amW;
    }

    public int xe() {
        return this.amX;
    }

    public boolean a(ColorEgg colorEgg) {
        this.amX = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.amW.add(str);
            }
        }
        if (this.amW.size() <= 0) {
            return false;
        }
        this.amX = colorEgg.style_flag.intValue();
        return true;
    }
}
