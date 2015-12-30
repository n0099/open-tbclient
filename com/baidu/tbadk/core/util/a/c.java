package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int adt;
    public int adu;
    public String mErrorString;
    public String adv = null;
    public boolean rJ = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uz() {
        return this.adt == 200;
    }

    public boolean qO() {
        return this.adt == 200 && this.adu == 0;
    }

    public boolean gM() {
        return this.adt == 200 || this.adt == 206;
    }
}
