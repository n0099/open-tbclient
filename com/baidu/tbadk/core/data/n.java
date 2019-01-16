package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aqZ = new ArrayList<>();
    private int ara;

    public ArrayList<String> yu() {
        return this.aqZ;
    }

    public int yv() {
        return this.ara;
    }

    public boolean a(ColorEgg colorEgg) {
        this.ara = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aqZ.add(str);
            }
        }
        if (this.aqZ.size() <= 0) {
            return false;
        }
        this.ara = colorEgg.style_flag.intValue();
        return true;
    }
}
