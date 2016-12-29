package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int acu;
    public String mErrorString;
    public int oF;
    public String acv = null;
    public boolean kK = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uL() {
        return this.oF == 200;
    }

    public boolean oH() {
        return this.oF == 200 && this.acu == 0;
    }

    public boolean eh() {
        return this.oF == 200 || this.oF == 206;
    }
}
