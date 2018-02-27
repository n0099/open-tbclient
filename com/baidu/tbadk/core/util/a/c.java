package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aYb;
    public int ajw;
    public String mErrorString;
    public String aYc = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean CB() {
        return this.ajw == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajw == 200 && this.aYb == 0;
    }

    public boolean mT() {
        return this.ajw == 200 || this.ajw == 206;
    }
}
