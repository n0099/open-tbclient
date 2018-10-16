package com.baidu.ar.ui.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ar.ui.view.adapter.ToolsCategoryPagerAdapter;
import com.baidu.ar.ui.view.adapter.a;
import com.baidu.ar.util.Utils;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CategoryView extends RelativeLayout implements ViewPager.OnPageChangeListener, com.baidu.ar.ui.view.adapter.a {
    private ViewPager a;
    private ToolsCategoryPagerAdapter b;
    private EdgeEffectCompat c;
    private EdgeEffectCompat d;
    private boolean e;
    private a.InterfaceC0054a f;
    private volatile int g;
    private volatile float h;
    private float i;
    private ArrayList<String> j;
    private a k;
    private Handler l;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(int i);
    }

    public CategoryView(Context context) {
        super(context);
        this.e = false;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0.0f;
        this.l = new Handler();
        a(context);
    }

    public CategoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0.0f;
        this.l = new Handler();
        a(context);
    }

    public CategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.g = 0;
        this.h = 0.0f;
        this.i = 0.0f;
        this.l = new Handler();
        a(context);
    }

    private void a(Context context) {
        this.j = new ArrayList<>();
        this.j.add("录制");
        this.j.add("拍摄");
        this.a = new ViewPager(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.dipToPx(context, 36.0f), Utils.dipToPx(context, 28.0f));
        layoutParams.addRule(13);
        this.a.setLayoutParams(layoutParams);
        addView(this.a);
        a();
    }

    private void b() {
        try {
            Field declaredField = this.a.getClass().getDeclaredField("mLeftEdge");
            Field declaredField2 = this.a.getClass().getDeclaredField("mRightEdge");
            if (declaredField == null || declaredField2 == null) {
                return;
            }
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            this.c = (EdgeEffectCompat) declaredField.get(this.a);
            this.d = (EdgeEffectCompat) declaredField2.get(this.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPagerState(int i) {
        int size = this.b.b().size();
        for (int i2 = 0; i2 < size; i2++) {
            TextView textView = (TextView) this.b.b().get(i2);
            if (((Integer) textView.getTag()).intValue() == i) {
                textView.setSelected(true);
            } else {
                textView.setSelected(false);
            }
        }
    }

    public void a() {
        if (this.b != null || this.j == null || this.j.size() <= 0) {
            return;
        }
        setLayerType(1, null);
        this.a.setOffscreenPageLimit(10);
        this.a.setPageMargin(Utils.dipToPx(getContext(), 26.0f));
        this.a.setOnPageChangeListener(this);
        this.b = new ToolsCategoryPagerAdapter(getContext(), this.j);
        this.a.setAdapter(this.b);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.ar.ui.view.CategoryView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int width;
                if (CategoryView.this.k != null) {
                    CategoryView.this.k.a();
                }
                final float rawX = motionEvent.getRawX();
                motionEvent.getRawY();
                if (motionEvent.getAction() == 1) {
                    int[] iArr = new int[2];
                    for (int i = 0; i < CategoryView.this.b.getCount(); i++) {
                        View view2 = CategoryView.this.b.b().get(i);
                        view2.getLocationOnScreen(iArr);
                        CategoryView.this.i = view2.getWidth();
                        if (rawX > iArr[0] && rawX < width + iArr[0]) {
                            CategoryView.this.g = ((Integer) view2.getTag()).intValue();
                            CategoryView.this.a.postDelayed(new Runnable() { // from class: com.baidu.ar.ui.view.CategoryView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (CategoryView.this.g == CategoryView.this.a.getCurrentItem() || Math.abs(CategoryView.this.h - rawX) >= CategoryView.this.i / 2.0f) {
                                        return;
                                    }
                                    CategoryView.this.e = true;
                                    CategoryView.this.a.setCurrentItem(CategoryView.this.g);
                                }
                            }, 300L);
                        }
                    }
                    CategoryView.this.l.removeCallbacksAndMessages(null);
                    CategoryView.this.l.postDelayed(new Runnable() { // from class: com.baidu.ar.ui.view.CategoryView.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CategoryView.this.k != null) {
                                CategoryView.this.k.a(CategoryView.this.a.getCurrentItem());
                            }
                        }
                    }, 500L);
                } else if (motionEvent.getAction() == 0) {
                    CategoryView.this.h = rawX;
                }
                return CategoryView.this.a.dispatchTouchEvent(motionEvent);
            }
        });
        setPagerState(0);
        b();
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (1 == i) {
            this.e = true;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (this.c != null && this.d != null) {
            this.c.finish();
            this.d.finish();
            this.c.setSize(0, 0);
            this.d.setSize(0, 0);
        }
        if (Build.VERSION.SDK_INT < 18) {
            invalidate();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.a == null) {
            return;
        }
        if (this.f != null && this.e) {
            this.f.a(this, this.b.a().get(i));
            this.e = false;
        }
        setPagerState(i);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setCategoryListener(a.InterfaceC0054a interfaceC0054a) {
        this.f = interfaceC0054a;
    }

    public void setCurrentItem(int i) {
        this.e = true;
        if (this.a != null) {
            this.a.setCurrentItem(i);
        }
    }

    public void setCurrentItem(String str) {
        this.e = true;
        if (this.a != null) {
            this.a.setCurrentItem(this.j.indexOf(str));
        }
    }

    public void setItemChangeListener(a aVar) {
        this.k = aVar;
    }
}
