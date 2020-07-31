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
import com.baidu.live.data.bp;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class ImBarrageTrackView extends FrameLayout {
    private a avX;
    private int avY;
    private int avZ;
    private boolean awa;

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
        this.avX = aVar;
    }

    public boolean vU() {
        return this.awa;
    }

    public void setCanAddNext() {
        this.awa = true;
    }

    public void a(bp bpVar, com.baidu.live.data.a aVar, String str, String str2) {
        this.awa = false;
        aV(false);
        View b = b(bpVar, aVar, str, str2);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        addView(b, new ViewGroup.LayoutParams(b.getMeasuredWidth(), -1));
        Animator K = K(b);
        b.setTag(a.g.ala_im_barrage_item_anim, K);
        K.start();
    }

    public void release() {
        aV(true);
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.avY = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avZ = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private void aV(boolean z) {
        if (getChildCount() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    if (childAt != null) {
                        Object tag = childAt.getTag(a.g.ala_im_barrage_item_anim);
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

    private View b(bp bpVar, com.baidu.live.data.a aVar, String str, String str2) {
        ImBarrageItemView imBarrageItemView = new ImBarrageItemView(getContext());
        imBarrageItemView.setDisplayInfo(aVar, str2, str);
        imBarrageItemView.setUIInfo(bpVar, false);
        imBarrageItemView.setCallback(new ImBarrageItemView.a() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.1
            @Override // com.baidu.live.barrage.view.ImBarrageItemView.a
            public void b(com.baidu.live.data.a aVar2) {
                if (ImBarrageTrackView.this.avX != null) {
                    ImBarrageTrackView.this.avX.b(aVar2);
                }
            }
        });
        imBarrageItemView.setTranslationX(getWidth());
        return imBarrageItemView;
    }

    private Animator K(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getWidth(), -view.getMeasuredWidth());
        ofFloat.setDuration((((getWidth() + view.getMeasuredWidth()) * 1.0f) / this.avY) * 1000.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1) {
                    ImBarrageTrackView.this.vV();
                }
                ImBarrageTrackView.this.removeView(view);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.barrage.view.ImBarrageTrackView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1 && ImBarrageTrackView.this.getWidth() - view.getTranslationX() > view.getMeasuredWidth() + ImBarrageTrackView.this.avZ) {
                    ImBarrageTrackView.this.vV();
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (!this.awa) {
            this.awa = true;
            if (this.avX != null) {
                this.avX.onNext();
            }
        }
    }
}
