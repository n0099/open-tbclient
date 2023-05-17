package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.bc1;
import com.baidu.tieba.bk0;
import com.baidu.tieba.cc1;
import com.baidu.tieba.ec1;
/* loaded from: classes3.dex */
public class BubbleManager extends ec1 implements View.OnClickListener {

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
        if (cls != cc1.class && cls != bc1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            bk0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
