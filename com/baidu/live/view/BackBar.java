package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class BackBar extends FrameLayout {
    private a aEC;
    private View aED;
    private ImageView aEE;

    /* loaded from: classes3.dex */
    public interface a {
        void onBack();
    }

    public BackBar(@NonNull Context context) {
        this(context, null);
    }

    public BackBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }

    public void setCallback(a aVar) {
        this.aEC = aVar;
    }

    public void setTheme(int i) {
        switch (i) {
            case 0:
                this.aED.setBackgroundColor(1717986918);
                this.aEE.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                return;
            case 1:
                setBackgroundColor(-1);
                this.aED.setBackgroundColor(-1644826);
                this.aEE.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_ATOP);
                return;
            default:
                return;
        }
    }

    private void a(AttributeSet attributeSet, int i) {
        this.aED = new View(getContext());
        addView(this.aED, new FrameLayout.LayoutParams(-1, 1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(0);
        frameLayout.setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds40), 0, 0, 0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.BackBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BackBar.this.aEC != null) {
                    BackBar.this.aEC.onBack();
                }
            }
        });
        addView(frameLayout, new FrameLayout.LayoutParams(-2, -1));
        this.aEE = new ImageView(getContext());
        this.aEE.setImageResource(a.f.sdk_icon_live_back);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        frameLayout.addView(this.aEE, layoutParams);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.BackBar, i, a.j.BackBarLight);
        setTheme(obtainStyledAttributes.getInt(a.k.BackBar_backbar_theme, 1));
        obtainStyledAttributes.recycle();
    }
}
