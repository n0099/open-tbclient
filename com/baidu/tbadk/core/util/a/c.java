package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int AR;
    public int bUO;
    public String mErrorString;
    public String bUP = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean aiJ() {
        return this.AR == 200;
    }

    public boolean isRequestSuccess() {
        return this.AR == 200 && this.bUO == 0;
    }

    public boolean il() {
        return this.AR == 200 || this.AR == 206;
    }
}
