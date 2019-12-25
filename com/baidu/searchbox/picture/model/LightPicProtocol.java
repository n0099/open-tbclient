package com.baidu.searchbox.picture.model;
/* loaded from: classes11.dex */
public class LightPicProtocol {
    public static final String CMD_FLOW = "165";
    public static final String DATA = "data";
    public static final String ERRNO = "errno";
    public static final String TIME_STAMP = "timestamp";
    public String error;
    public String timestamp;

    public String obtainCmdFlow() {
        return CMD_FLOW;
    }
}
