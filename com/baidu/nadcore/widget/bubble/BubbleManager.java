package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.ib1;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jb1;
import com.baidu.tieba.lb1;
/* loaded from: classes2.dex */
public class BubbleManager extends lb1 implements View.OnClickListener {

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
        if (cls != jb1.class && cls != ib1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            ij0.b("BubbleManager", "", e);
            return null;
        }
    }
}
