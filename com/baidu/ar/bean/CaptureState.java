package com.baidu.ar.bean;

import com.tencent.open.SocialConstants;
/* loaded from: classes3.dex */
public enum CaptureState {
    NONE("none"),
    PICTURE(SocialConstants.PARAM_AVATAR_URI),
    VIDEO_UNSTART("video_unstart"),
    VIDEO_CAPTUREING("video_captureing");
    
    private final String mValue;

    CaptureState(String str) {
        this.mValue = str;
    }
}
