package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class n {
    private ArrayList<String> aKt = new ArrayList<>();
    private int aKu;

    public ArrayList<String> xj() {
        return this.aKt;
    }

    public int xk() {
        return this.aKu;
    }

    public boolean a(ColorEgg colorEgg) {
        this.aKu = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.aKt.add(str);
            }
        }
        if (this.aKt.size() <= 0) {
            return false;
        }
        this.aKu = colorEgg.style_flag.intValue();
        return true;
    }
}
