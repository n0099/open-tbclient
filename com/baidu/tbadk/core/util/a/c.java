package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ajG;
    public String mErrorString;
    public int tX;
    public String ajH = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vm() {
        return this.tX == 200;
    }

    public boolean isRequestSuccess() {
        return this.tX == 200 && this.ajG == 0;
    }

    public boolean eX() {
        return this.tX == 200 || this.tX == 206;
    }
}
