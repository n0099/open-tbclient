package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.gd1;
import com.baidu.tieba.hd1;
import com.baidu.tieba.jd1;
import com.baidu.tieba.rl0;
/* loaded from: classes3.dex */
public class BubbleManager extends jd1 implements View.OnClickListener {

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
        if (cls != hd1.class && cls != gd1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            rl0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
