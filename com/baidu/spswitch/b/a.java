package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes13.dex */
public class a {
    private static a bGy;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0278a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a Qu() {
        if (bGy == null) {
            synchronized (a.class) {
                if (bGy == null) {
                    bGy = new a();
                }
            }
        }
        return bGy;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
