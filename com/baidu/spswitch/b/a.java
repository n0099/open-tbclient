package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes24.dex */
public class a {
    private static a bTi;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC0322a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a Yt() {
        if (bTi == null) {
            synchronized (a.class) {
                if (bTi == null) {
                    bTi = new a();
                }
            }
        }
        return bTi;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
