package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int abG;
    public String mErrorString;
    public int oy;
    public String abH = null;
    public boolean kE = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uF() {
        return this.oy == 200;
    }

    public boolean isRequestSuccess() {
        return this.oy == 200 && this.abG == 0;
    }

    public boolean ef() {
        return this.oy == 200 || this.oy == 206;
    }
}
