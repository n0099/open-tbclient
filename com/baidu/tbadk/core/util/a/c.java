package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abW;
    public int abX;
    public String mErrorString;
    public String abY = null;
    public boolean rG = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uk() {
        return this.abW == 200;
    }

    public boolean qT() {
        return this.abW == 200 && this.abX == 0;
    }

    public boolean gK() {
        return this.abW == 200 || this.abW == 206;
    }
}
