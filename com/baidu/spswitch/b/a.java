package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes3.dex */
public class a {
    private static a czk;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0351a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a afp() {
        if (czk == null) {
            synchronized (a.class) {
                if (czk == null) {
                    czk = new a();
                }
            }
        }
        return czk;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
