package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aiT;
    public String mErrorString;
    public int xv;
    public String aiU = null;
    public boolean tK = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vo() {
        return this.xv == 200;
    }

    public boolean isRequestSuccess() {
        return this.xv == 200 && this.aiT == 0;
    }

    public boolean fB() {
        return this.xv == 200 || this.xv == 206;
    }
}
