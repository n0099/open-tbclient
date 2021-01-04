package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes3.dex */
public class a {
    private static a cDW;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0368a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a aji() {
        if (cDW == null) {
            synchronized (a.class) {
                if (cDW == null) {
                    cDW = new a();
                }
            }
        }
        return cDW;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
