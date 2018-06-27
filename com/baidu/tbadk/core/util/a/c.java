package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int asr;
    public String mErrorString;
    public int zZ;
    public String ass = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean za() {
        return this.zZ == 200;
    }

    public boolean isRequestSuccess() {
        return this.zZ == 200 && this.asr == 0;
    }

    public boolean hO() {
        return this.zZ == 200 || this.zZ == 206;
    }
}
