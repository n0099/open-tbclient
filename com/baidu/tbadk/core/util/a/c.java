package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int AK;
    public int bTH;
    public String mErrorString;
    public String bTI = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ahF() {
        return this.AK == 200;
    }

    public boolean isRequestSuccess() {
        return this.AK == 200 && this.bTH == 0;
    }

    public boolean ib() {
        return this.AK == 200 || this.AK == 206;
    }
}
