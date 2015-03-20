package com.baidu.tbadk.core.util.httpNet;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int VY;
    public int VZ;
    public String mErrorString;
    public String Wa = null;
    public boolean rC = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ss() {
        return this.VY == 200;
    }

    public boolean pv() {
        return this.VY == 200 && this.VZ == 0;
    }

    public boolean hi() {
        return this.VY == 200 || this.VY == 206;
    }
}
