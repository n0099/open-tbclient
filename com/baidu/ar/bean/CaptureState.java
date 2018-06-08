package com.baidu.ar.bean;

import com.tencent.open.SocialConstants;
/* loaded from: classes3.dex */
public enum CaptureState {
    NONE("none"),
    PICTURE(SocialConstants.PARAM_AVATAR_URI),
    VIDEO_UNSTART("video_unstart"),
    VIDEO_CAPTURING("video_capturing");
    
    private final String mValue;

    CaptureState(String str) {
        this.mValue = str;
    }

    public static CaptureState getValueOf(String str) {
        CaptureState[] values;
        if (str == null) {
            return NONE;
        }
        for (CaptureState captureState : values()) {
            if (captureState.getValue().equalsIgnoreCase(str)) {
                return captureState;
            }
        }
        return NONE;
    }

    public String getValue() {
        return this.mValue;
    }
}
