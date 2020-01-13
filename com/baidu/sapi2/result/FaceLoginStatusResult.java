package com.baidu.sapi2.result;
/* loaded from: classes5.dex */
public class FaceLoginStatusResult extends SapiResult {
    public static final int STATUS_AVAILABLE = 1;
    public static final int STATUS_UNREGISTER = 2;
    public static final int STATUS_UNREGISTER_NO_MOBILE = 3;
    public String authWidgetURL;
    public String authsid;
    public boolean faceLoginSwitch;
    public String livingUname;
    public int status;
}
