package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abP;
    public int abQ;
    public String mErrorString;
    public String abR = null;
    public boolean rG = false;
    public Map<String, List<String>> mHeader = null;

    public boolean um() {
        return this.abP == 200;
    }

    public boolean qZ() {
        return this.abP == 200 && this.abQ == 0;
    }

    public boolean gK() {
        return this.abP == 200 || this.abP == 206;
    }
}
