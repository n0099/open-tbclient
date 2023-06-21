package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.ld1;
import com.baidu.tieba.ll0;
import com.baidu.tieba.md1;
import com.baidu.tieba.od1;
/* loaded from: classes3.dex */
public class BubbleManager extends od1 implements View.OnClickListener {

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
        if (cls != md1.class && cls != ld1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            ll0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
