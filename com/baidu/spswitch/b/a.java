package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes13.dex */
public class a {
    private static a byV;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0245a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a Oh() {
        if (byV == null) {
            synchronized (a.class) {
                if (byV == null) {
                    byV = new a();
                }
            }
        }
        return byV;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
