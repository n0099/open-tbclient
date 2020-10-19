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
    private ObjectAnimator aGr;
    private ObjectAnimator aGs;
    protected boolean aGt;
    protected boolean aGu;
    private a aGv;
    protected boolean aGw;
    private int[] aGx;
    protected boolean cancelableFlag;

    public abstract void Dr();

    public abstract void Ds();

    public abstract void Dt();

    public abstract void Du();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aGt = false;
        this.aGu = false;
        this.aGw = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aGt = false;
        this.aGu = false;
        this.aGw = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aGt = false;
        this.aGu = false;
        this.aGw = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aGx = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aGv = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aGt = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aGu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dp() {
        if (this.aGt) {
            Dv();
        } else {
            this.aGv.a(this);
        }
        Dr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dq() {
        if (this.aGu) {
            Dw();
        } else {
            this.aGv.b(this);
        }
        Ds();
    }

    private void Dv() {
        this.aGr = ObjectAnimator.ofFloat(this, "TranslationY", this.aGx[1], 0.0f);
        this.aGr.setDuration(300L);
        this.aGr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aGw = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aGw = false;
                if (LayerChildView.this.aGv != null) {
                    LayerChildView.this.aGv.a(LayerChildView.this);
                }
                LayerChildView.this.Dt();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aGw = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aGw = true;
        this.aGr.start();
    }

    private void Dw() {
        this.aGs = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aGx[1]);
        this.aGs.setDuration(300L);
        this.aGs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aGw = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aGw = false;
                if (LayerChildView.this.aGv != null) {
                    LayerChildView.this.aGv.b(LayerChildView.this);
                }
                LayerChildView.this.Du();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aGw = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aGw = true;
        this.aGs.start();
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
