package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class f {
    private ArrayList<String> UC = new ArrayList<>();
    private int UD;

    public ArrayList<String> rv() {
        return this.UC;
    }

    public int rw() {
        return this.UD;
    }

    public boolean a(ColorEgg colorEgg) {
        this.UD = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.UC.add(str);
            }
        }
        if (this.UC.size() <= 0) {
            return false;
        }
        this.UD = colorEgg.style_flag.intValue();
        return true;
    }
}
