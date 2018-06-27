package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class o {
    private ArrayList<String> afs = new ArrayList<>();
    private int aft;

    public ArrayList<String> tY() {
        return this.afs;
    }

    public int tZ() {
        return this.aft;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aft = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.afs.add(str);
            }
        }
        if (this.afs.size() <= 0) {
            return false;
        }
        this.aft = colorEgg.style_flag.intValue();
        return true;
    }
}
