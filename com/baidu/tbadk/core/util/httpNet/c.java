package com.baidu.tbadk.core.util.httpNet;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public int Wa;
    public int Wb;
    public String mErrorString;
    public String Wc = null;
    public boolean rC = false;
    public Map<String, List<String>> mHeader = null;

    public boolean ss() {
        return this.Wa == 200;
    }

    public boolean pv() {
        return this.Wa == 200 && this.Wb == 0;
    }

    public boolean hi() {
        return this.Wa == 200 || this.Wa == 206;
    }
}
