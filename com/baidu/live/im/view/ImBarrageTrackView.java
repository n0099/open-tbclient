package com.baidu.live.im.view;

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
import com.baidu.live.data.az;
import com.baidu.live.im.view.ImBarrageItemView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class ImBarrageTrackView extends FrameLayout {
    private boolean arA;
    private a arx;
    private int ary;
    private int arz;

    /* loaded from: classes2.dex */
    public interface a {
        void d(com.baidu.live.data.a aVar);

        void onNext();
    }

    public ImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.arx = aVar;
    }

    public boolean wf() {
        return this.arA;
    }

    public void setCanAddNext() {
        this.arA = true;
    }

    public void a(az azVar, com.baidu.live.data.a aVar, String str, String str2) {
        this.arA = false;
        aW(false);
        View b = b(azVar, aVar, str, str2);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        addView(b, new ViewGroup.LayoutParams(b.getMeasuredWidth(), -1));
        Animator O = O(b);
        b.setTag(a.g.ala_im_barrage_item_anim, O);
        O.start();
    }

    public void release() {
        aW(true);
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.ary = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.arz = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private void aW(boolean z) {
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

    private View b(az azVar, com.baidu.live.data.a aVar, String str, String str2) {
        ImBarrageItemView imBarrageItemView = new ImBarrageItemView(getContext());
        imBarrageItemView.setDisplayInfo(aVar, str2, str);
        imBarrageItemView.setUIInfo(azVar, false);
        imBarrageItemView.setCallback(new ImBarrageItemView.a() { // from class: com.baidu.live.im.view.ImBarrageTrackView.1
            @Override // com.baidu.live.im.view.ImBarrageItemView.a
            public void d(com.baidu.live.data.a aVar2) {
                if (ImBarrageTrackView.this.arx != null) {
                    ImBarrageTrackView.this.arx.d(aVar2);
                }
            }
        });
        imBarrageItemView.setTranslationX(getWidth());
        return imBarrageItemView;
    }

    private Animator O(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getWidth(), -view.getMeasuredWidth());
        ofFloat.setDuration((((getWidth() + view.getMeasuredWidth()) * 1.0f) / this.ary) * 1000.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.ImBarrageTrackView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1) {
                    ImBarrageTrackView.this.wg();
                }
                ImBarrageTrackView.this.removeView(view);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.ImBarrageTrackView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1 && ImBarrageTrackView.this.getWidth() - view.getTranslationX() > view.getMeasuredWidth() + ImBarrageTrackView.this.arz) {
                    ImBarrageTrackView.this.wg();
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg() {
        if (!this.arA) {
            this.arA = true;
            if (this.arx != null) {
                this.arx.onNext();
            }
        }
    }
}
