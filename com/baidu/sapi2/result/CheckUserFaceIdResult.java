package com.baidu.sapi2.result;
/* loaded from: classes5.dex */
public class CheckUserFaceIdResult extends SapiResult {
    public static final int STATUS_AVAILABLE = 1;
    public static final int STATUS_UNAVAILABLE = 3;
    public static final int STATUS_UNREGISTER = 2;
    public String authWidgetURL;
    public String authsid;
    public boolean faceLoginSwitch;
    public String livingUname;
    public int status;
}
