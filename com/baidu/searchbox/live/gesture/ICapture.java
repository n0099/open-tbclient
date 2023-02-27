package com.baidu.searchbox.live.gesture;
/* loaded from: classes2.dex */
public interface ICapture {
    public static final ICapture DEFAULT = new ICapture() { // from class: com.baidu.searchbox.live.gesture.ICapture.1
        @Override // com.baidu.searchbox.live.gesture.ICapture
        public boolean isEnable() {
            return true;
        }
    };

    boolean isEnable();
}
