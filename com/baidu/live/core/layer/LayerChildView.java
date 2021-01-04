package com.baidu.live.core.layer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes11.dex */
public abstract class LayerChildView extends FrameLayout {
    private ObjectAnimator aII;
    private ObjectAnimator aIJ;
    protected boolean aIK;
    protected boolean aIL;
    private a aIM;
    protected boolean aIN;
    private int[] aIO;
    protected boolean cancelableFlag;

    public abstract void Eh();

    public abstract void Ei();

    public abstract void Ej();

    public abstract void Ek();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aIK = false;
        this.aIL = false;
        this.aIN = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aIK = false;
        this.aIL = false;
        this.aIN = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aIK = false;
        this.aIL = false;
        this.aIN = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aIO = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aIM = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aIK = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aIL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ef() {
        if (this.aIK) {
            El();
        } else {
            this.aIM.a(this);
        }
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Eg() {
        if (this.aIL) {
            Em();
        } else {
            this.aIM.b(this);
        }
        Ei();
    }

    private void El() {
        this.aII = ObjectAnimator.ofFloat(this, "TranslationY", this.aIO[1], 0.0f);
        this.aII.setDuration(300L);
        this.aII.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aIN = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aIN = false;
                if (LayerChildView.this.aIM != null) {
                    LayerChildView.this.aIM.a(LayerChildView.this);
                }
                LayerChildView.this.Ej();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aIN = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aIN = true;
        this.aII.start();
    }

    private void Em() {
        this.aIJ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aIO[1]);
        this.aIJ.setDuration(300L);
        this.aIJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aIN = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aIN = false;
                if (LayerChildView.this.aIM != null) {
                    LayerChildView.this.aIM.b(LayerChildView.this);
                }
                LayerChildView.this.Ek();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aIN = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aIN = true;
        this.aIJ.start();
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
