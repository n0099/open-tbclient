package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int De;
    public int aDW;
    public String mErrorString;
    public String aDX = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Dz() {
        return this.De == 200;
    }

    public boolean isRequestSuccess() {
        return this.De == 200 && this.aDW == 0;
    }

    public boolean jh() {
        return this.De == 200 || this.De == 206;
    }
}
