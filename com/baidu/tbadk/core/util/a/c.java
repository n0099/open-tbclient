package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abR;
    public int abS;
    public String mErrorString;
    public String abT = null;
    public boolean rG = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uk() {
        return this.abR == 200;
    }

    public boolean qV() {
        return this.abR == 200 && this.abS == 0;
    }

    public boolean gK() {
        return this.abR == 200 || this.abR == 206;
    }
}
