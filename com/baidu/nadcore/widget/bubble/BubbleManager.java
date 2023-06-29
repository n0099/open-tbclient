package com.baidu.nadcore.widget.bubble;

import android.view.View;
import com.baidu.tieba.od1;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pd1;
import com.baidu.tieba.rd1;
/* loaded from: classes3.dex */
public class BubbleManager extends rd1 implements View.OnClickListener {

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
        if (cls != pd1.class && cls != od1.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception e) {
            ol0.b(com.baidu.searchbox.ui.bubble.BubbleManager.TAG, "", e);
            return null;
        }
    }
}
