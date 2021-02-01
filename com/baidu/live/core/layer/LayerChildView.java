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
    private ObjectAnimator aFI;
    private ObjectAnimator aFJ;
    protected boolean aFK;
    protected boolean aFL;
    private a aFM;
    protected boolean aFN;
    private int[] aFO;
    protected boolean cancelableFlag;

    public abstract void AW();

    public abstract void AX();

    public abstract void AY();

    public abstract void AZ();

    public LayerChildView(@NonNull Context context) {
        super(context);
        this.cancelableFlag = false;
        this.aFK = false;
        this.aFL = false;
        this.aFN = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cancelableFlag = false;
        this.aFK = false;
        this.aFL = false;
        this.aFN = false;
        initData(context);
    }

    public LayerChildView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cancelableFlag = false;
        this.aFK = false;
        this.aFL = false;
        this.aFN = false;
        initData(context);
    }

    private void initData(Context context) {
        this.aFO = BdUtilHelper.getScreenDimensions(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerCallback(a aVar) {
        this.aFM = aVar;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.cancelableFlag = z;
    }

    public void setNeedShowAnim(boolean z) {
        this.aFK = z;
    }

    public void setNeedHideAnim(boolean z) {
        this.aFL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AU() {
        if (this.aFK) {
            Ba();
        } else {
            this.aFM.a(this);
        }
        AW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AV() {
        if (this.aFL) {
            Bb();
        } else {
            this.aFM.b(this);
        }
        AX();
    }

    private void Ba() {
        this.aFI = ObjectAnimator.ofFloat(this, "TranslationY", this.aFO[1], 0.0f);
        this.aFI.setDuration(300L);
        this.aFI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aFN = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aFN = false;
                if (LayerChildView.this.aFM != null) {
                    LayerChildView.this.aFM.a(LayerChildView.this);
                }
                LayerChildView.this.AY();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aFN = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFN = true;
        this.aFI.start();
    }

    private void Bb() {
        this.aFJ = ObjectAnimator.ofFloat(this, "TranslationY", 0.0f, this.aFO[1]);
        this.aFJ.setDuration(300L);
        this.aFJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.live.core.layer.LayerChildView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LayerChildView.this.aFN = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LayerChildView.this.aFN = false;
                if (LayerChildView.this.aFM != null) {
                    LayerChildView.this.aFM.b(LayerChildView.this);
                }
                LayerChildView.this.AZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                LayerChildView.this.aFN = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.aFN = true;
        this.aFJ.start();
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
