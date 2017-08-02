package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahy;
    public String mErrorString;
    public int vR;
    public String ahz = null;
    public boolean sa = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ve() {
        return this.vR == 200;
    }

    public boolean isRequestSuccess() {
        return this.vR == 200 && this.ahy == 0;
    }

    public boolean fq() {
        return this.vR == 200 || this.vR == 206;
    }
}
