package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.gg0;
import com.baidu.tieba.v71;
import com.baidu.tieba.w71;
import com.baidu.tieba.y71;
/* loaded from: classes3.dex */
public class BubbleManager extends y71 implements View.OnClickListener {

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
        if (cls != w71.class && cls != v71.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            gg0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
