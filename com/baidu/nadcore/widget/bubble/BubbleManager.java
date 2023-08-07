package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.jc1;
import com.baidu.tieba.kc1;
import com.baidu.tieba.mc1;
import com.baidu.tieba.pk0;
/* loaded from: classes3.dex */
public class BubbleManager extends mc1 implements View.OnClickListener {

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
        if (cls != kc1.class && cls != jc1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            pk0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
