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
    private ObjectAnimator axA;
    protected boolean axB;
    protected boolean axC;
    private a axD;
    protected boolean axE;
    private int[] axF;
    private ObjectAnimator axz;
    protected boolean cancelableFlag;

    public abstract void wH();

    public abstract void wI();

    public abstract void wJ();

    public abstract void wK();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.axB = false;
        this.axC = false;
        this.axE = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.axB = false;
        this.axC = false;
        this.axE = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.axB = false;
        this.axC = false;
        this.axE = false;
        initData(context);
    }

    private void initData(Context context) {
        this.axF = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.axD = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.axB = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.axC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wF() {
        if (this.axB) {
            wL();
        } else {
            this.axD.a(this);
        }
        wH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void wG() {
        if (this.axC) {
            wM();
        } else {
            this.axD.b(this);
        }
        wI();
    }

    private void wL() {
        this.axz = ObjectAnimator.ofFloat(this, "TranslationY", this.axF[1], 0.0f);
        this.axz.setDuration(300L);
        this.axz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.axE = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.axE = false;
                if (LayerChildView.this.axD != null) {
                    LayerChildView.this.axD.a(LayerChildView.this);
                }
                LayerChildView.this.wJ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.axE = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.axE = true;
        this.axz.start();
    }

    private void wM() {
        this.axA = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.axF[1]);
        this.axA.setDuration(300L);
        this.axA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.axE = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.axE = false;
                if (LayerChildView.this.axD != null) {
                    LayerChildView.this.axD.b(LayerChildView.this);
                }
                LayerChildView.this.wK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.axE = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.axE = true;
        this.axA.start();
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
