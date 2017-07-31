package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aiR;
    public String mErrorString;
    public int xt;
    public String aiS = null;
    public boolean tI = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vo() {
        return this.xt == 200;
    }

    public boolean isRequestSuccess() {
        return this.xt == 200 && this.aiR == 0;
    }

    public boolean fB() {
        return this.xt == 200 || this.xt == 206;
    }
}
