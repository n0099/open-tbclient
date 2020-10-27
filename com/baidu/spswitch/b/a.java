package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes19.dex */
public class a {
    private static a cnV;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0353a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a acZ() {
        if (cnV == null) {
            synchronized (a.class) {
                if (cnV == null) {
                    cnV = new a();
                }
            }
        }
        return cnV;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
