package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ajG;
    public String mErrorString;
    public int tW;
    public String ajH = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vl() {
        return this.tW == 200;
    }

    public boolean isRequestSuccess() {
        return this.tW == 200 && this.ajG == 0;
    }

    public boolean eX() {
        return this.tW == 200 || this.tW == 206;
    }
}
