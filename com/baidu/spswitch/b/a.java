package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes19.dex */
public class a {
    private static a cfw;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0339a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a abf() {
        if (cfw == null) {
            synchronized (a.class) {
                if (cfw == null) {
                    cfw = new a();
                }
            }
        }
        return cfw;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
