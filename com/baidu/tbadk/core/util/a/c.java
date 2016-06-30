package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int YU;
    public int lE;
    public String mErrorString;
    public String YV = null;
    public boolean hN = false;
    public Map<String, List<String>> mHeader = null;

    public boolean tB() {
        return this.lE == 200;
    }

    public boolean nU() {
        return this.lE == 200 && this.YU == 0;
    }

    public boolean dn() {
        return this.lE == 200 || this.lE == 206;
    }
}
