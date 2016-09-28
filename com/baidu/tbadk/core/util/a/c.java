package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int acD;
    public String mErrorString;
    public int oE;
    public String acE = null;
    public boolean kK = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uV() {
        return this.oE == 200;
    }

    public boolean oF() {
        return this.oE == 200 && this.acD == 0;
    }

    public boolean eh() {
        return this.oE == 200 || this.oE == 206;
    }
}
