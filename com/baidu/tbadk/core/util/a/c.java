package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int ZD;
    public String mErrorString;
    public int mi;
    public String ZE = null;
    public boolean iu = false;
    public Map<String, List<String>> mHeader = null;

    public boolean tA() {
        return this.mi == 200;
    }

    public boolean nJ() {
        return this.mi == 200 && this.ZD == 0;
    }

    public boolean dm() {
        return this.mi == 200 || this.mi == 206;
    }
}
