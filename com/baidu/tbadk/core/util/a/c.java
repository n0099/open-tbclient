package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahc;
    public String mErrorString;
    public int vQ;
    public String ahd = null;
    public boolean sa = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uY() {
        return this.vQ == 200;
    }

    public boolean isRequestSuccess() {
        return this.vQ == 200 && this.ahc == 0;
    }

    public boolean fs() {
        return this.vQ == 200 || this.vQ == 206;
    }
}
