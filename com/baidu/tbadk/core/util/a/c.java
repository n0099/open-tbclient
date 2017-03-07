package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int agW;
    public String mErrorString;
    public int wj;
    public String agX = null;
    public boolean sA = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vc() {
        return this.wj == 200;
    }

    public boolean isRequestSuccess() {
        return this.wj == 200 && this.agW == 0;
    }

    public boolean fn() {
        return this.wj == 200 || this.wj == 206;
    }
}
