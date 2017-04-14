package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ahk;
    public String mErrorString;
    public int vM;
    public String ahl = null;
    public boolean rV = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vz() {
        return this.vM == 200;
    }

    public boolean isRequestSuccess() {
        return this.vM == 200 && this.ahk == 0;
    }

    public boolean fs() {
        return this.vM == 200 || this.vM == 206;
    }
}
