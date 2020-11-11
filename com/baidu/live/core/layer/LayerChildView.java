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
    private ObjectAnimator aHp;
    private ObjectAnimator aHq;
    protected boolean aHr;
    protected boolean aHs;
    private a aHt;
    protected boolean aHu;
    private int[] aHv;
    protected boolean cancelableFlag;

    public abstract void DR();

    public abstract void DS();

    public abstract void DT();

    public abstract void DU();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aHr = false;
        this.aHs = false;
        this.aHu = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aHr = false;
        this.aHs = false;
        this.aHu = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aHr = false;
        this.aHs = false;
        this.aHu = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aHv = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aHt = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aHr = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aHs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DP() {
        if (this.aHr) {
            DV();
        } else {
            this.aHt.a(this);
        }
        DR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DQ() {
        if (this.aHs) {
            DW();
        } else {
            this.aHt.b(this);
        }
        DS();
    }

    private void DV() {
        this.aHp = ObjectAnimator.ofFloat(this, "TranslationY", this.aHv[1], 0.0f);
        this.aHp.setDuration(300L);
        this.aHp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aHu = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aHu = false;
                if (LayerChildView.this.aHt != null) {
                    LayerChildView.this.aHt.a(LayerChildView.this);
                }
                LayerChildView.this.DT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aHu = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHu = true;
        this.aHp.start();
    }

    private void DW() {
        this.aHq = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aHv[1]);
        this.aHq.setDuration(300L);
        this.aHq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aHu = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aHu = false;
                if (LayerChildView.this.aHt != null) {
                    LayerChildView.this.aHt.b(LayerChildView.this);
                }
                LayerChildView.this.DU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aHu = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHu = true;
        this.aHq.start();
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
