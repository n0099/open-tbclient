package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int adb;
    public String mErrorString;
    public int oF;
    public String adc = null;
    public boolean kL = false;
    public Map<String, List<String>> mHeader = null;

    public boolean uZ() {
        return this.oF == 200;
    }

    public boolean oH() {
        return this.oF == 200 && this.adb == 0;
    }

    public boolean eh() {
        return this.oF == 200 || this.oF == 206;
    }
}
