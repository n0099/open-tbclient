package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int Dd;
    public int bLS;
    public String mErrorString;
    public String bLT = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean acK() {
        return this.Dd == 200;
    }

    public boolean isRequestSuccess() {
        return this.Dd == 200 && this.bLS == 0;
    }

    public boolean jj() {
        return this.Dd == 200 || this.Dd == 206;
    }
}
