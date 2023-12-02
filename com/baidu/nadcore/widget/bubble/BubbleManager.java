package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.b81;
import com.baidu.tieba.hg0;
import com.baidu.tieba.y71;
import com.baidu.tieba.z71;
/* loaded from: classes3.dex */
public class BubbleManager extends b81 implements View.OnClickListener {

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

    public static <T> T u(Class<T> cls) {
        if (cls != z71.class && cls != y71.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            hg0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
