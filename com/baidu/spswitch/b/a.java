package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes6.dex */
public class a {
    private static a csh;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0363a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a aeR() {
        if (csh == null) {
            synchronized (a.class) {
                if (csh == null) {
                    csh = new a();
                }
            }
        }
        return csh;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
