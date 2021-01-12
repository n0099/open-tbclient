package com.baidu.live.core.layer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes10.dex */
public abstract class LayerChildView extends FrameLayout {
    private ObjectAnimator aDV;
    private ObjectAnimator aDW;
    protected boolean aDX;
    protected boolean aDY;
    private a aDZ;
    protected boolean aEa;
    private int[] aEb;
    protected boolean cancelableFlag;

    public abstract void Am();

    public abstract void An();

    public abstract void Ao();

    public abstract void Ap();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aDX = false;
        this.aDY = false;
        this.aEa = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aDX = false;
        this.aDY = false;
        this.aEa = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aDX = false;
        this.aDY = false;
        this.aEa = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aEb = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aDZ = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aDX = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aDY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ak() {
        if (this.aDX) {
            Aq();
        } else {
            this.aDZ.a(this);
        }
        Am();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Al() {
        if (this.aDY) {
            Ar();
        } else {
            this.aDZ.b(this);
        }
        An();
    }

    private void Aq() {
        this.aDV = ObjectAnimator.ofFloat(this, "TranslationY", this.aEb[1], 0.0f);
        this.aDV.setDuration(300L);
        this.aDV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aEa = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aEa = false;
                if (LayerChildView.this.aDZ != null) {
                    LayerChildView.this.aDZ.a(LayerChildView.this);
                }
                LayerChildView.this.Ao();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aEa = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aEa = true;
        this.aDV.start();
    }

    private void Ar() {
        this.aDW = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aEb[1]);
        this.aDW.setDuration(300L);
        this.aDW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aEa = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aEa = false;
                if (LayerChildView.this.aDZ != null) {
                    LayerChildView.this.aDZ.b(LayerChildView.this);
                }
                LayerChildView.this.Ap();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aEa = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aEa = true;
        this.aDW.start();
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
