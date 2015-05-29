package com.baidu.tbadk.core.util.httpNet;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int WH;
    public int WI;
    public String mErrorString;
    public String WJ = null;
    public boolean rM = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ta() {
        return this.WH == 200;
    }

    public boolean qa() {
        return this.WH == 200 && this.WI == 0;
    }

    public boolean gT() {
        return this.WH == 200 || this.WH == 206;
    }
}
