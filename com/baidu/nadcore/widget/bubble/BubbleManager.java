package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.rc1;
import com.baidu.tieba.rk0;
import com.baidu.tieba.sc1;
import com.baidu.tieba.uc1;
/* loaded from: classes2.dex */
public class BubbleManager extends uc1 implements View.OnClickListener {

    /* loaded from: classes2.dex */
    public enum BubbleStyle {
        TextOnly,
        TextWithJumpArrow
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b();

        void c();
    }

    public static <T> T t(Class<T> cls) {
        if (cls != sc1.class && cls != rc1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            rk0.b("BubbleManager", "", e);
            return null;
        }
    }
}
