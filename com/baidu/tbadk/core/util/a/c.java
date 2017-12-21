package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ait;
    public String mErrorString;
    public int vn;
    public String aiu = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uQ() {
        return this.vn == 200;
    }

    public boolean isRequestSuccess() {
        return this.vn == 200 && this.ait == 0;
    }

    public boolean fp() {
        return this.vn == 200 || this.vn == 206;
    }
}
