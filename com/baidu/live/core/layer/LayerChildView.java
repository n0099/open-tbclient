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
    private ObjectAnimator aHi;
    private ObjectAnimator aHj;
    protected boolean aHk;
    protected boolean aHl;
    private a aHm;
    protected boolean aHn;
    private int[] aHo;
    protected boolean cancelableFlag;

    public abstract void AZ();

    public abstract void Ba();

    public abstract void Bb();

    public abstract void Bc();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aHk = false;
        this.aHl = false;
        this.aHn = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aHk = false;
        this.aHl = false;
        this.aHn = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aHk = false;
        this.aHl = false;
        this.aHn = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aHo = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aHm = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aHk = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aHl = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AX() {
        if (this.aHk) {
            Bd();
        } else {
            this.aHm.a(this);
        }
        AZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AY() {
        if (this.aHl) {
            Be();
        } else {
            this.aHm.b(this);
        }
        Ba();
    }

    private void Bd() {
        this.aHi = ObjectAnimator.ofFloat(this, "TranslationY", this.aHo[1], 0.0f);
        this.aHi.setDuration(300L);
        this.aHi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aHn = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aHn = false;
                if (LayerChildView.this.aHm != null) {
                    LayerChildView.this.aHm.a(LayerChildView.this);
                }
                LayerChildView.this.Bb();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aHn = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHn = true;
        this.aHi.start();
    }

    private void Be() {
        this.aHj = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aHo[1]);
        this.aHj.setDuration(300L);
        this.aHj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aHn = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aHn = false;
                if (LayerChildView.this.aHm != null) {
                    LayerChildView.this.aHm.b(LayerChildView.this);
                }
                LayerChildView.this.Bc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aHn = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aHn = true;
        this.aHj.start();
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
