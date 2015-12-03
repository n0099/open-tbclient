package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int acO;
    public int acP;
    public String mErrorString;
    public String acQ = null;
    public boolean rI = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uP() {
        return this.acO == 200;
    }

    public boolean rf() {
        return this.acO == 200 && this.acP == 0;
    }

    public boolean gM() {
        return this.acO == 200 || this.acO == 206;
    }
}
