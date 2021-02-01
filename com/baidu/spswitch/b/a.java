package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes3.dex */
public class a {
    private static a cBG;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0348a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a afO() {
        if (cBG == null) {
            synchronized (a.class) {
                if (cBG == null) {
                    cBG = new a();
                }
            }
        }
        return cBG;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
