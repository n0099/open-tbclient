package com.baidu.live.im.view.barrage;

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
import com.baidu.live.data.bb;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ImBarrageTrackView extends FrameLayout {
    private a avJ;
    private int avl;
    private int avm;
    private boolean avn;

    /* loaded from: classes3.dex */
    public interface a {
        void c(com.baidu.live.data.a aVar);

        void onNext();
    }

    public ImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.avJ = aVar;
    }

    public boolean yj() {
        return this.avn;
    }

    public void setCanAddNext() {
        this.avn = true;
    }

    public void a(bb bbVar, com.baidu.live.data.a aVar, String str, String str2) {
        this.avn = false;
        aZ(false);
        View b = b(bbVar, aVar, str, str2);
        b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        addView(b, new ViewGroup.LayoutParams(b.getMeasuredWidth(), -1));
        Animator O = O(b);
        b.setTag(a.g.ala_im_barrage_item_anim, O);
        O.start();
    }

    public void release() {
        aZ(true);
        removeAllViews();
    }

    private void init() {
        setBackgroundColor(0);
        this.avl = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.avm = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }

    private void aZ(boolean z) {
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

    private View b(bb bbVar, com.baidu.live.data.a aVar, String str, String str2) {
        ImBarrageItemView imBarrageItemView = new ImBarrageItemView(getContext());
        imBarrageItemView.setDisplayInfo(aVar, str2, str);
        imBarrageItemView.setUIInfo(bbVar, false);
        imBarrageItemView.setCallback(new ImBarrageItemView.a() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackView.1
            @Override // com.baidu.live.im.view.barrage.ImBarrageItemView.a
            public void c(com.baidu.live.data.a aVar2) {
                if (ImBarrageTrackView.this.avJ != null) {
                    ImBarrageTrackView.this.avJ.c(aVar2);
                }
            }
        });
        imBarrageItemView.setTranslationX(getWidth());
        return imBarrageItemView;
    }

    private Animator O(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", getWidth(), -view.getMeasuredWidth());
        ofFloat.setDuration((((getWidth() + view.getMeasuredWidth()) * 1.0f) / this.avl) * 1000.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(0);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1) {
                    ImBarrageTrackView.this.yl();
                }
                ImBarrageTrackView.this.removeView(view);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.im.view.barrage.ImBarrageTrackView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ImBarrageTrackView.this.indexOfChild(view) == ImBarrageTrackView.this.getChildCount() - 1 && ImBarrageTrackView.this.getWidth() - view.getTranslationX() > view.getMeasuredWidth() + ImBarrageTrackView.this.avm) {
                    ImBarrageTrackView.this.yl();
                }
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl() {
        if (!this.avn) {
            this.avn = true;
            if (this.avJ != null) {
                this.avJ.onNext();
            }
        }
    }
}
