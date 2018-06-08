package com.baidu.tbadk.core.util.a;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int Ab;
    public int arO;
    public String mErrorString;
    public String arP = null;
    public boolean mIsGif = false;
    public Map<String, List<String>> mHeader = null;

    public boolean yM() {
        return this.Ab == 200;
    }

    public boolean isRequestSuccess() {
        return this.Ab == 200 && this.arO == 0;
    }

    public boolean hO() {
        return this.Ab == 200 || this.Ab == 206;
    }
}
