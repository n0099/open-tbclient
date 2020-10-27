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
    private ObjectAnimator aGA;
    protected boolean aGB;
    protected boolean aGC;
    private a aGD;
    protected boolean aGE;
    private int[] aGF;
    private ObjectAnimator aGz;
    protected boolean cancelableFlag;

    public abstract void DA();

    public abstract void DB();

    public abstract void Dy();

    public abstract void Dz();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aGB = false;
        this.aGC = false;
        this.aGE = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aGB = false;
        this.aGC = false;
        this.aGE = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aGB = false;
        this.aGC = false;
        this.aGE = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aGF = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aGD = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aGB = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aGC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dw() {
        if (this.aGB) {
            DC();
        } else {
            this.aGD.a(this);
        }
        Dy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dx() {
        if (this.aGC) {
            DD();
        } else {
            this.aGD.b(this);
        }
        Dz();
    }

    private void DC() {
        this.aGz = ObjectAnimator.ofFloat(this, "TranslationY", this.aGF[1], 0.0f);
        this.aGz.setDuration(300L);
        this.aGz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aGE = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aGE = false;
                if (LayerChildView.this.aGD != null) {
                    LayerChildView.this.aGD.a(LayerChildView.this);
                }
                LayerChildView.this.DA();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aGE = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aGE = true;
        this.aGz.start();
    }

    private void DD() {
        this.aGA = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aGF[1]);
        this.aGA.setDuration(300L);
        this.aGA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aGE = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aGE = false;
                if (LayerChildView.this.aGD != null) {
                    LayerChildView.this.aGD.b(LayerChildView.this);
                }
                LayerChildView.this.DB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aGE = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aGE = true;
        this.aGA.start();
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
