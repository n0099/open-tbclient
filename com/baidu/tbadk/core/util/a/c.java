package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahC;
    public String mErrorString;
    public int vp;
    public String ahD = null;
    public boolean ry = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uJ() {
        return this.vp == 200;
    }

    public boolean isRequestSuccess() {
        return this.vp == 200 && this.ahC == 0;
    }

    public boolean fp() {
        return this.vp == 200 || this.vp == 206;
    }
}
