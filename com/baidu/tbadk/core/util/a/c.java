package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahl;
    public String mErrorString;
    public int vQ;
    public String ahm = null;
    public boolean sa = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vz() {
        return this.vQ == 200;
    }

    public boolean isRequestSuccess() {
        return this.vQ == 200 && this.ahl == 0;
    }

    public boolean ft() {
        return this.vQ == 200 || this.vQ == 206;
    }
}
