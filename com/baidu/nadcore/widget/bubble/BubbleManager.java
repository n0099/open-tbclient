package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.sc1;
import com.baidu.tieba.tc1;
import com.baidu.tieba.tk0;
import com.baidu.tieba.vc1;
/* loaded from: classes3.dex */
public class BubbleManager extends vc1 implements View.OnClickListener {

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
        if (cls != tc1.class && cls != sc1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            tk0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
