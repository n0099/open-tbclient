package com.baidu.mobads.interfaces.utils;
/* loaded from: classes5.dex */
public interface IBase64 {

    /* loaded from: classes5.dex */
    public interface EventHandler {
        void onTimer(int i);

        void onTimerComplete();
    }

    String decodeStr(String str);

    String encode(String str);
}
