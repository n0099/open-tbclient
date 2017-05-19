package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int agD;
    public String mErrorString;
    public int vR;
    public String agE = null;
    public boolean sb = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uM() {
        return this.vR == 200;
    }

    public boolean isRequestSuccess() {
        return this.vR == 200 && this.agD == 0;
    }

    public boolean ft() {
        return this.vR == 200 || this.vR == 206;
    }
}
