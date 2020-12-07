package com.baidu.live.barrage.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.baidu.live.barrage.view.ImBarrageItemView;
import com.baidu.live.data.ci;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ImBarrageTrackView extends FrameLayout {
    private a aGF;
    private int aGG;
    private int aGH;
    private boolean aGI;

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);

        void onNext();
    }

    public ImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aGF = aVar;
    }

    public boolean Ee() {
        return this.aGI;
    }

    public void setCanAddNext() {
        this.aGI = true;
    }

    public void a(ci ciVar, com.baidu.live.data.a aVar, String str, String str2) {
        this.aGI = false;
        bq(false);
        View b = b(ciVar, aVar, str, str2);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        addView(b, new ViewGroup.LayoutParams(b.getMeasuredWidth(), -1));
        Animator K = K(b);
        b.setTag(a.f.ala_im_barrage_item_anim, K);
        K.start();
    }

    public void release() {
        bq(true);
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.aGG = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGH = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private void bq(boolean z) {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    if (childAt != null) {
                        Object tag = childAt.getTag(a.f.ala_im_barrage_item_anim);
                        if (tag instanceof ValueAnimator) {
                            ((ValueAnimator) tag).removeAllUpdateListeners();
                            ((ValueAnimator) tag).removeAllListeners();
                            if (z) {
                                ((ValueAnimator) tag).cancel();
                            }
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private View b(ci ciVar, com.baidu.live.data.a aVar, String str, String str2) {
        ImBarrageItemView imBarrageItemView = new ImBarrageItemView(getContext());
        imBarrageItemView.setDisplayInfo(aVar, str2, str);
        imBarrageItemView.setUIInfo(ciVar, false);
        imBarrageItemView.setCallback(new ImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.ImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (ImBarrageTrackView.this.aGF != null) {
                    ImBarrageTrackView.this.aGF.b(aVar2);
                }
            }
        });
        imBarrageItemView.setTranslationX(getWidth());
        return imBarrageItemView;
    }

    private Animator K(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getWidth(), -view.getMeasuredWidth());
        ofFloat.setDuration((((getWidth() + view.getMeasuredWidth()) * 1.0f) / this.aGG) * 1000.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1) {
                    ImBarrageTrackView.this.Ef();
                }
                ImBarrageTrackView.this.removeView(view);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1 && ImBarrageTrackView.this.getWidth() - view.getTranslationX() > view.getMeasuredWidth() + ImBarrageTrackView.this.aGH) {
                    ImBarrageTrackView.this.Ef();
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef() {
        if (!this.aGI) {
            this.aGI = true;
            if (this.aGF != null) {
                this.aGF.onNext();
            }
        }
    }
}
