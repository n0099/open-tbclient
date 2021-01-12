package com.baidu.live.barrage.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.barrage.view.ImBarrageItemView;
import com.baidu.live.data.ck;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class ImBarrageTrackView extends FrameLayout {
    private a aCj;
    private int aCk;
    private int aCl;
    private boolean aCm;

    /* loaded from: classes10.dex */
    public interface a {
        void b(com.baidu.live.data.a aVar);

        void onNext();
    }

    public ImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.aCj = aVar;
    }

    public boolean zy() {
        return this.aCm;
    }

    public void setCanAddNext() {
        this.aCm = true;
    }

    public void a(ck ckVar, com.baidu.live.data.a aVar, String str, String str2) {
        this.aCm = false;
        bj(false);
        View b2 = b(ckVar, aVar, str, str2);
        b2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        addView(b2, new ViewGroup.LayoutParams(b2.getMeasuredWidth(), -1));
        Animator K = K(b2);
        b2.setTag(a.f.ala_im_barrage_item_anim, K);
        K.start();
    }

    public void release() {
        bj(true);
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.aCk = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aCl = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }

    private void bj(boolean z) {
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

    private View b(ck ckVar, com.baidu.live.data.a aVar, String str, String str2) {
        ImBarrageItemView imBarrageItemView = new ImBarrageItemView(getContext());
        imBarrageItemView.setDisplayInfo(aVar, str2, str);
        imBarrageItemView.setUIInfo(ckVar, false);
        imBarrageItemView.setCallback(new ImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.ImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (ImBarrageTrackView.this.aCj != null) {
                    ImBarrageTrackView.this.aCj.b(aVar2);
                }
            }
        });
        imBarrageItemView.setTranslationX(getWidth());
        return imBarrageItemView;
    }

    private Animator K(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getWidth(), -view.getMeasuredWidth());
        ofFloat.setDuration((((getWidth() + view.getMeasuredWidth()) * 1.0f) / this.aCk) * 1000.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1) {
                    ImBarrageTrackView.this.zz();
                }
                ImBarrageTrackView.this.removeView(view);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1 && ImBarrageTrackView.this.getWidth() - view.getTranslationX() > view.getMeasuredWidth() + ImBarrageTrackView.this.aCl) {
                    ImBarrageTrackView.this.zz();
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz() {
        if (!this.aCm) {
            this.aCm = true;
            if (this.aCj != null) {
                this.aCj.onNext();
            }
        }
    }
}
