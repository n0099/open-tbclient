package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abO;
    public int abP;
    public String mErrorString;
    public String abQ = null;
    public boolean rG = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uk() {
        return this.abO == 200;
    }

    public boolean qV() {
        return this.abO == 200 && this.abP == 0;
    }

    public boolean gK() {
        return this.abO == 200 || this.abO == 206;
    }
}
