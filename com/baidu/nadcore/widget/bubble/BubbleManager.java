package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.kd1;
import com.baidu.tieba.kl0;
import com.baidu.tieba.ld1;
import com.baidu.tieba.nd1;
/* loaded from: classes3.dex */
public class BubbleManager extends nd1 implements View.OnClickListener {

    /* loaded from: classes3.dex */
    public enum BubbleStyle {
        TextOnly,
        TextWithJumpArrow
    }

    /* loaded from: classes3.dex */
    public interface a {
        void onAnchorClick();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onBubbleClick();

        void onBubbleDismiss();

        void onBubbleShow();
    }

    public static <T> T t(Class<T> cls) {
        if (cls != ld1.class && cls != kd1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            kl0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
