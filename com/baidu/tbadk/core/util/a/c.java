package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aWC;
    public int ajA;
    public String mErrorString;
    public String aWD = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Cq() {
        return this.ajA == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajA == 200 && this.aWC == 0;
    }

    public boolean mS() {
        return this.ajA == 200 || this.ajA == 206;
    }
}
