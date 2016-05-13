package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int YD;
    public int lE;
    public String mErrorString;
    public String YE = null;
    public boolean hO = false;
    public Map<String, List<String>> mHeader = null;

    public boolean tE() {
        return this.lE == 200;
    }

    public boolean nZ() {
        return this.lE == 200 && this.YD == 0;
    }

    public boolean dm() {
        return this.lE == 200 || this.lE == 206;
    }
}
