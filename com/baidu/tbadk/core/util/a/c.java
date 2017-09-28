package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahO;
    public String mErrorString;
    public int vo;
    public String ahP = null;
    public boolean rx = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uQ() {
        return this.vo == 200;
    }

    public boolean isRequestSuccess() {
        return this.vo == 200 && this.ahO == 0;
    }

    public boolean fp() {
        return this.vo == 200 || this.vo == 206;
    }
}
