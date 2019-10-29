package com.baidu.live.tbadk.core.data;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ExceptionData {
    public Map<String, String> appendInfoMap = new HashMap();
    public String info;
    public Throwable mExcep;

    public void appendInfo(String str, String str2) {
        this.appendInfoMap.put(str, str2);
    }
}
