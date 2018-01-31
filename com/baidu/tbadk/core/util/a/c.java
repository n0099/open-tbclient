package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aWE;
    public int ajD;
    public String mErrorString;
    public String aWF = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean Cj() {
        return this.ajD == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajD == 200 && this.aWE == 0;
    }

    public boolean mT() {
        return this.ajD == 200 || this.ajD == 206;
    }
}
