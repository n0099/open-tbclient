package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int adf;
    public String mErrorString;
    public int vL;
    public String adg = null;
    public boolean sb = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vX() {
        return this.vL == 200;
    }

    public boolean qC() {
        return this.vL == 200 && this.adf == 0;
    }

    public boolean gY() {
        return this.vL == 200 || this.vL == 206;
    }
}
