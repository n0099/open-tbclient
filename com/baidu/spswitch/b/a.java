package com.baidu.spswitch.b;

import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes19.dex */
public class a {
    private static a ctT;
    private boolean isNightMode;

    /* renamed from: com.baidu.spswitch.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0365a {
        void a(EmotionType emotionType, int i, String str, String str2);
    }

    private a() {
    }

    public static a afz() {
        if (ctT == null) {
            synchronized (a.class) {
                if (ctT == null) {
                    ctT = new a();
                }
            }
        }
        return ctT;
    }

    public boolean isNightMode() {
        return this.isNightMode;
    }
}
