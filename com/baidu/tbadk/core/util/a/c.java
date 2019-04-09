package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int Dd;
    public int bLV;
    public String mErrorString;
    public String bLW = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean acH() {
        return this.Dd == 200;
    }

    public boolean isRequestSuccess() {
        return this.Dd == 200 && this.bLV == 0;
    }

    public boolean jj() {
        return this.Dd == 200 || this.Dd == 206;
    }
}
