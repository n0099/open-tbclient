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
    private ObjectAnimator aFE;
    private ObjectAnimator aFF;
    protected boolean aFG;
    protected boolean aFH;
    private a aFI;
    protected boolean aFJ;
    private int[] aFK;
    protected boolean cancelableFlag;

    public abstract void Di();

    public abstract void Dj();

    public abstract void Dk();

    public abstract void Dl();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aFG = false;
        this.aFH = false;
        this.aFJ = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aFG = false;
        this.aFH = false;
        this.aFJ = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aFG = false;
        this.aFH = false;
        this.aFJ = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aFK = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aFI = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aFG = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aFH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dg() {
        if (this.aFG) {
            Dm();
        } else {
            this.aFI.a(this);
        }
        Di();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Dh() {
        if (this.aFH) {
            Dn();
        } else {
            this.aFI.b(this);
        }
        Dj();
    }

    private void Dm() {
        this.aFE = ObjectAnimator.ofFloat(this, "TranslationY", this.aFK[1], 0.0f);
        this.aFE.setDuration(300L);
        this.aFE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aFJ = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aFJ = false;
                if (LayerChildView.this.aFI != null) {
                    LayerChildView.this.aFI.a(LayerChildView.this);
                }
                LayerChildView.this.Dk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aFJ = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFJ = true;
        this.aFE.start();
    }

    private void Dn() {
        this.aFF = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aFK[1]);
        this.aFF.setDuration(300L);
        this.aFF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aFJ = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aFJ = false;
                if (LayerChildView.this.aFI != null) {
                    LayerChildView.this.aFI.b(LayerChildView.this);
                }
                LayerChildView.this.Dl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aFJ = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFJ = true;
        this.aFF.start();
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
