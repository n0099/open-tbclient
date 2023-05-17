package com.baidu.searchbox.crius.ui.swiper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes3.dex */
public class CriusSwiperView extends ViewPager {
    public Handler handler;
    public int mCurrentIndex;
    public SwiperAttrs mSwiperAttrs;
    public Runnable runnable;

    public CriusSwiperView(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$004(CriusSwiperView criusSwiperView) {
        int i = criusSwiperView.mCurrentIndex + 1;
        criusSwiperView.mCurrentIndex = i;
        return i;
    }

    public void init(SwiperAttrs swiperAttrs) {
        this.mSwiperAttrs = swiperAttrs;
        setOffscreenPageLimit(50);
        setOverScrollMode(2);
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.searchbox.crius.ui.swiper.CriusSwiperView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (CriusSwiperView.this.getAdapter() == null) {
                    return;
                }
                if (i == 0) {
                    CriusSwiperView criusSwiperView = CriusSwiperView.this;
                    criusSwiperView.setCurrentItem(criusSwiperView.mCurrentIndex, false);
                    CriusSwiperView.this.play();
                } else if (i == 1) {
                    CriusSwiperView.this.cancel();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CriusSwiperView.this.getAdapter() == null) {
                    return;
                }
                if (i == 0) {
                    CriusSwiperView criusSwiperView = CriusSwiperView.this;
                    criusSwiperView.mCurrentIndex = criusSwiperView.getAdapter().getCount() - 2;
                } else if (i == CriusSwiperView.this.getAdapter().getCount() - 1) {
                    CriusSwiperView.this.mCurrentIndex = 1;
                } else {
                    CriusSwiperView.this.mCurrentIndex = i;
                }
            }
        });
    }

    public CriusSwiperView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = 1;
        this.handler = new Handler(Looper.getMainLooper());
        this.runnable = new Runnable() { // from class: com.baidu.searchbox.crius.ui.swiper.CriusSwiperView.1
            @Override // java.lang.Runnable
            public void run() {
                CriusSwiperView criusSwiperView = CriusSwiperView.this;
                criusSwiperView.setCurrentItem(CriusSwiperView.access$004(criusSwiperView));
            }
        };
    }

    public void cancel() {
        this.handler.removeCallbacks(this.runnable);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCurrentItem(this.mCurrentIndex, false);
        play();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancel();
        resetCurrentIndex();
    }

    public void play() {
        int i = this.mSwiperAttrs.autoPlay;
        if (i > 0) {
            this.handler.postDelayed(this.runnable, i);
        } else {
            this.handler.removeCallbacks(this.runnable);
        }
    }

    public void resetCurrentIndex() {
        this.mCurrentIndex = 1;
    }
}
