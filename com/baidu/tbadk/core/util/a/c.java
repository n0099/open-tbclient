package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int arV;
    public String mErrorString;
    public int zV;
    public String arW = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean yP() {
        return this.zV == 200;
    }

    public boolean isRequestSuccess() {
        return this.zV == 200 && this.arV == 0;
    }

    public boolean hO() {
        return this.zV == 200 || this.zV == 206;
    }
}
