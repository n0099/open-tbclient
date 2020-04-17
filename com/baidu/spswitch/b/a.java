package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes13.dex */
public class a {
    private static a byQ;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0224a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a Oi() {
        if (byQ == null) {
            synchronized (a.class) {
                if (byQ == null) {
                    byQ = new a();
                }
            }
        }
        return byQ;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
