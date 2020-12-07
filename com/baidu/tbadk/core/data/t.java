package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.FrsPage.ColorEgg;
/* loaded from: classes.dex */
public class t {
    private ArrayList<String> eFs = new ArrayList<>();
    private int eFt;

    public ArrayList<String> bmR() {
        return this.eFs;
    }

    public int bmS() {
        return this.eFt;
    }

    public boolean a(ColorEgg colorEgg) {
        this.eFt = 0;
        if (colorEgg == null || colorEgg.holiday_words == null || colorEgg.holiday_words.size() <= 0) {
            return false;
        }
        for (String str : colorEgg.holiday_words) {
            if (!StringUtils.isNull(str)) {
                this.eFs.add(str);
            }
        }
        if (this.eFs.size() <= 0) {
            return false;
        }
        this.eFt = colorEgg.style_flag.intValue();
        return true;
    }
}
