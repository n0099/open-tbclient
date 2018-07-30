package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int arU;
    public String mErrorString;
    public int zU;
    public String arV = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean yR() {
        return this.zU == 200;
    }

    public boolean isRequestSuccess() {
        return this.zU == 200 && this.arU == 0;
    }

    public boolean hO() {
        return this.zU == 200 || this.zU == 206;
    }
}
