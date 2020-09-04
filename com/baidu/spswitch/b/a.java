package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes9.dex */
public class a {
    private static a bRi;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0327a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a XK() {
        if (bRi == null) {
            synchronized (a.class) {
                if (bRi == null) {
                    bRi = new a();
                }
            }
        }
        return bRi;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
