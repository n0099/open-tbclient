package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int AR;
    public int bUI;
    public String mErrorString;
    public String bUJ = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean aiH() {
        return this.AR == 200;
    }

    public boolean isRequestSuccess() {
        return this.AR == 200 && this.bUI == 0;
    }

    public boolean il() {
        return this.AR == 200 || this.AR == 206;
    }
}
