package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.lb1;
import com.baidu.tieba.lj0;
import com.baidu.tieba.mb1;
import com.baidu.tieba.ob1;
/* loaded from: classes2.dex */
public class BubbleManager extends ob1 implements View.OnClickListener {

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
        if (cls != mb1.class && cls != lb1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            lj0.b("BubbleManager", "", e);
            return null;
        }
    }
}
