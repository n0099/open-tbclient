package com.baidu.live.core.layer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes4.dex */
public abstract class LayerChildView extends FrameLayout {
    private ObjectAnimator aIm;
    private ObjectAnimator aIn;
    protected boolean aIo;
    protected boolean aIp;
    private a aIq;
    protected boolean aIr;
    private int[] aIs;
    protected boolean cancelableFlag;

    public abstract void ES();

    public abstract void ET();

    public abstract void EU();

    public abstract void EV();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aIo = false;
        this.aIp = false;
        this.aIr = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aIo = false;
        this.aIp = false;
        this.aIr = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aIo = false;
        this.aIp = false;
        this.aIr = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aIs = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aIq = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aIo = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aIp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EQ() {
        if (this.aIo) {
            EW();
        } else {
            this.aIq.a(this);
        }
        ES();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ER() {
        if (this.aIp) {
            EX();
        } else {
            this.aIq.b(this);
        }
        ET();
    }

    private void EW() {
        this.aIm = ObjectAnimator.ofFloat(this, "TranslationY", this.aIs[1], 0.0f);
        this.aIm.setDuration(300L);
        this.aIm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aIr = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aIr = false;
                if (LayerChildView.this.aIq != null) {
                    LayerChildView.this.aIq.a(LayerChildView.this);
                }
                LayerChildView.this.EU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aIr = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aIr = true;
        this.aIm.start();
    }

    private void EX() {
        this.aIn = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aIs[1]);
        this.aIn.setDuration(300L);
        this.aIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aIr = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aIr = false;
                if (LayerChildView.this.aIq != null) {
                    LayerChildView.this.aIq.b(LayerChildView.this);
                }
                LayerChildView.this.EV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aIr = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aIr = true;
        this.aIn.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void release() {
        clearAnimation();
    }
}
