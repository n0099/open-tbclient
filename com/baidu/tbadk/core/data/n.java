package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> VY = new ArrayList<>();
    private int VZ;

    public ArrayList<String> pH() {
        return this.VY;
    }

    public int pI() {
        return this.VZ;
    }

    public boolean a(ColorEgg colorEgg) {
        this.VZ = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.VY.add(str);
            }
        }
        if (this.VY.size() <= 0) {
            return false;
        }
        this.VZ = colorEgg.style_flag.intValue();
        return true;
    }
}
