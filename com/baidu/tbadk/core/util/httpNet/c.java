package com.baidu.tbadk.core.util.httpNet;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abH;
    public int abI;
    public String mErrorString;
    public String abJ = null;
    public boolean rI = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uh() {
        return this.abH == 200;
    }

    public boolean rb() {
        return this.abH == 200 && this.abI == 0;
    }

    public boolean gN() {
        return this.abH == 200 || this.abH == 206;
    }
}
