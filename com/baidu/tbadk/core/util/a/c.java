package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahZ;
    public String mErrorString;
    public int vp;
    public String aia = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uQ() {
        return this.vp == 200;
    }

    public boolean isRequestSuccess() {
        return this.vp == 200 && this.ahZ == 0;
    }

    public boolean fp() {
        return this.vp == 200 || this.vp == 206;
    }
}
