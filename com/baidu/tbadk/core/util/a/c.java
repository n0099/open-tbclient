package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int aim;
    public String mErrorString;
    public int vm;
    public String ain = null;
    public boolean rw = false;
    public Map<String, List<String>> mHeader = null;

    public boolean vm() {
        return this.vm == 200;
    }

    public boolean isRequestSuccess() {
        return this.vm == 200 && this.aim == 0;
    }

    public boolean fq() {
        return this.vm == 200 || this.vm == 206;
    }
}
