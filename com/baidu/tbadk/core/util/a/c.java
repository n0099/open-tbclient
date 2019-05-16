package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int AM;
    public int bTG;
    public String mErrorString;
    public String bTH = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ahF() {
        return this.AM == 200;
    }

    public boolean isRequestSuccess() {
        return this.AM == 200 && this.bTG == 0;
    }

    public boolean ib() {
        return this.AM == 200 || this.AM == 206;
    }
}
