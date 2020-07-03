package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes13.dex */
public class a {
    private static a bLm;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0284a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a RA() {
        if (bLm == null) {
            synchronized (a.class) {
                if (bLm == null) {
                    bLm = new a();
                }
            }
        }
        return bLm;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
