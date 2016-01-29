package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int adP;
    public String mErrorString;
    public int vv;
    public String adQ = null;
    public boolean rR = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vE() {
        return this.vv == 200;
    }

    public boolean rl() {
        return this.vv == 200 && this.adP == 0;
    }

    public boolean gU() {
        return this.vv == 200 || this.vv == 206;
    }
}
