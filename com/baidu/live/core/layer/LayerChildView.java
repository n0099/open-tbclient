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
    private ObjectAnimator aDn;
    private ObjectAnimator aDo;
    protected boolean aDp;
    protected boolean aDq;
    private a aDr;
    protected boolean aDs;
    private int[] aDt;
    protected boolean cancelableFlag;

    public abstract void Cu();

    public abstract void Cv();

    public abstract void Cw();

    public abstract void Cx();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aDp = false;
        this.aDq = false;
        this.aDs = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aDp = false;
        this.aDq = false;
        this.aDs = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aDp = false;
        this.aDq = false;
        this.aDs = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aDt = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aDr = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aDp = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aDq = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cs() {
        if (this.aDp) {
            Cy();
        } else {
            this.aDr.a(this);
        }
        Cu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ct() {
        if (this.aDq) {
            Cz();
        } else {
            this.aDr.b(this);
        }
        Cv();
    }

    private void Cy() {
        this.aDn = ObjectAnimator.ofFloat(this, "TranslationY", this.aDt[1], 0.0f);
        this.aDn.setDuration(300L);
        this.aDn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aDs = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aDs = false;
                if (LayerChildView.this.aDr != null) {
                    LayerChildView.this.aDr.a(LayerChildView.this);
                }
                LayerChildView.this.Cw();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aDs = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aDs = true;
        this.aDn.start();
    }

    private void Cz() {
        this.aDo = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aDt[1]);
        this.aDo.setDuration(300L);
        this.aDo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aDs = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aDs = false;
                if (LayerChildView.this.aDr != null) {
                    LayerChildView.this.aDr.b(LayerChildView.this);
                }
                LayerChildView.this.Cx();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aDs = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aDs = true;
        this.aDo.start();
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
