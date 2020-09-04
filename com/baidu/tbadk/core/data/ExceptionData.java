package com.baidu.tbadk.core.data;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ExceptionData {
    public Map<String, String> appendInfo = new HashMap();
    public String info;
    public Throwable mExcep;

    public void appendInfo(String str, String str2) {
        this.appendInfo.put(str, str2);
    }
}
