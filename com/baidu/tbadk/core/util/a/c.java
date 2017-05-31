package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int agu;
    public String mErrorString;
    public int vR;
    public String agv = null;
    public boolean sb = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uI() {
        return this.vR == 200;
    }

    public boolean isRequestSuccess() {
        return this.vR == 200 && this.agu == 0;
    }

    public boolean ft() {
        return this.vR == 200 || this.vR == 206;
    }
}
