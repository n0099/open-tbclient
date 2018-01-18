package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aWB;
    public int ajA;
    public String mErrorString;
    public String aWC = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Ci() {
        return this.ajA == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajA == 200 && this.aWB == 0;
    }

    public boolean mS() {
        return this.ajA == 200 || this.ajA == 206;
    }
}
