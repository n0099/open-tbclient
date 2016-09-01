package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int acs;
    public String mErrorString;
    public int oE;
    public String act = null;
    public boolean kK = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uG() {
        return this.oE == 200;
    }

    public boolean oE() {
        return this.oE == 200 && this.acs == 0;
    }

    public boolean eh() {
        return this.oE == 200 || this.oE == 206;
    }
}
