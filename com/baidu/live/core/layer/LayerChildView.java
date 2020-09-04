package com.baidu.live.core.layer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes7.dex */
public abstract class LayerChildView extends FrameLayout {
    private ObjectAnimator aCD;
    private ObjectAnimator aCE;
    protected boolean aCF;
    protected boolean aCG;
    private a aCH;
    protected boolean aCI;
    private int[] aCJ;
    protected boolean cancelableFlag;

    public abstract void Cf();

    public abstract void Cg();

    public abstract void Ch();

    public abstract void Ci();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aCF = false;
        this.aCG = false;
        this.aCI = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aCF = false;
        this.aCG = false;
        this.aCI = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aCF = false;
        this.aCG = false;
        this.aCI = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aCJ = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aCH = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aCF = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aCG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cd() {
        if (this.aCF) {
            Cj();
        } else {
            this.aCH.a(this);
        }
        Cf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ce() {
        if (this.aCG) {
            Ck();
        } else {
            this.aCH.b(this);
        }
        Cg();
    }

    private void Cj() {
        this.aCD = ObjectAnimator.ofFloat(this, "TranslationY", this.aCJ[1], 0.0f);
        this.aCD.setDuration(300L);
        this.aCD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aCI = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aCI = false;
                if (LayerChildView.this.aCH != null) {
                    LayerChildView.this.aCH.a(LayerChildView.this);
                }
                LayerChildView.this.Ch();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aCI = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aCI = true;
        this.aCD.start();
    }

    private void Ck() {
        this.aCE = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aCJ[1]);
        this.aCE.setDuration(300L);
        this.aCE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aCI = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aCI = false;
                if (LayerChildView.this.aCH != null) {
                    LayerChildView.this.aCH.b(LayerChildView.this);
                }
                LayerChildView.this.Ci();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aCI = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aCI = true;
        this.aCE.start();
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
