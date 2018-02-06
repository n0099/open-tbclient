package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aYn;
    public int ajC;
    public String mErrorString;
    public String aYo = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean CC() {
        return this.ajC == 200;
    }

    public boolean isRequestSuccess() {
        return this.ajC == 200 && this.aYn == 0;
    }

    public boolean mT() {
        return this.ajC == 200 || this.ajC == 206;
    }
}
