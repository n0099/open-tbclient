package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes2.dex */
public class s {
    private ArrayList<String> dXt = new ArrayList<>();
    private int dXu;

    public ArrayList<String> bcG() {
        return this.dXt;
    }

    public int bcH() {
        return this.dXu;
    }

    public boolean a(ColorEgg colorEgg) {
        this.dXu = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.dXt.add(str);
            }
        }
        if (this.dXt.size() <= 0) {
            return false;
        }
        this.dXu = colorEgg.style_flag.intValue();
        return true;
    }
}
