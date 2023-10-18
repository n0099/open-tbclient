package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.e71;
import com.baidu.tieba.f71;
import com.baidu.tieba.h71;
import com.baidu.tieba.pf0;
/* loaded from: classes3.dex */
public class BubbleManager extends h71 implements View.OnClickListener {

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
        if (cls != f71.class && cls != e71.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            pf0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
