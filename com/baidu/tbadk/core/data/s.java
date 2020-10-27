package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class s {
    private ArrayList<String> euj = new ArrayList<>();
    private int euk;

    public ArrayList<String> bic() {
        return this.euj;
    }

    public int bid() {
        return this.euk;
    }

    public boolean a(ColorEgg colorEgg) {
        this.euk = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.euj.add(str);
            }
        }
        if (this.euj.size() <= 0) {
            return false;
        }
        this.euk = colorEgg.style_flag.intValue();
        return true;
    }
}
