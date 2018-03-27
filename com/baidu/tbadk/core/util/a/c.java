package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aYd;
    public int ajw;
    public String mErrorString;
    public String aYe = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean CC() {
        return this.ajw == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajw == 200 && this.aYd == 0;
    }

    public boolean mT() {
        return this.ajw == 200 || this.ajw == 206;
    }
}
