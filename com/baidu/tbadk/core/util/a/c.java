package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int De;
    public int aDX;
    public String mErrorString;
    public String aDY = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Dz() {
        return this.De == 200;
    }

    public boolean isRequestSuccess() {
        return this.De == 200 && this.aDX == 0;
    }

    public boolean jh() {
        return this.De == 200 || this.De == 206;
    }
}
