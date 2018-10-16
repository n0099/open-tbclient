package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int Da;
    public int aze;
    public String mErrorString;
    public String azf = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Cb() {
        return this.Da == 200;
    }

    public boolean isRequestSuccess() {
        return this.Da == 200 && this.aze == 0;
    }

    public boolean jj() {
        return this.Da == 200 || this.Da == 206;
    }
}
