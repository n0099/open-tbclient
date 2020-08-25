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
    private ObjectAnimator aCB;
    private ObjectAnimator aCC;
    protected boolean aCD;
    protected boolean aCE;
    private a aCF;
    protected boolean aCG;
    private int[] aCH;
    protected boolean cancelableFlag;

    public abstract void Cf();

    public abstract void Cg();

    public abstract void Ch();

    public abstract void Ci();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aCD = false;
        this.aCE = false;
        this.aCG = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aCD = false;
        this.aCE = false;
        this.aCG = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aCD = false;
        this.aCE = false;
        this.aCG = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aCH = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aCF = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aCD = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aCE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cd() {
        if (this.aCD) {
            Cj();
        } else {
            this.aCF.a(this);
        }
        Cf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ce() {
        if (this.aCE) {
            Ck();
        } else {
            this.aCF.b(this);
        }
        Cg();
    }

    private void Cj() {
        this.aCB = ObjectAnimator.ofFloat(this, "TranslationY", this.aCH[1], 0.0f);
        this.aCB.setDuration(300L);
        this.aCB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aCG = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aCG = false;
                if (LayerChildView.this.aCF != null) {
                    LayerChildView.this.aCF.a(LayerChildView.this);
                }
                LayerChildView.this.Ch();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aCG = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aCG = true;
        this.aCB.start();
    }

    private void Ck() {
        this.aCC = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aCH[1]);
        this.aCC.setDuration(300L);
        this.aCC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aCG = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aCG = false;
                if (LayerChildView.this.aCF != null) {
                    LayerChildView.this.aCF.b(LayerChildView.this);
                }
                LayerChildView.this.Ci();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aCG = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aCG = true;
        this.aCC.start();
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
