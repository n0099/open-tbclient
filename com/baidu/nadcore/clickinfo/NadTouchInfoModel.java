package com.baidu.nadcore.clickinfo;
/* loaded from: classes2.dex */
public class NadTouchInfoModel {
    public int a;
    public boolean b;

    /* loaded from: classes2.dex */
    public enum CRCErrorCode {
        NO_IM_TIME_SIGN(-1),
        NO_OUT_PATTERN_MATCHER(-2);
        
        public int errorType;

        public int getErrorType() {
            return this.errorType;
        }

        CRCErrorCode(int i) {
            this.errorType = i;
        }
    }

    public NadTouchInfoModel(int i) {
    }
}
