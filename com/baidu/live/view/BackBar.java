package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class BackBar extends FrameLayout {
    private a bUd;
    private View bUe;
    private ImageView bUf;

    /* loaded from: classes11.dex */
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
        this.bUd = aVar;
    }

    public void setTheme(int i) {
        switch (i) {
            case 0:
                this.bUe.setBackgroundColor(1717986918);
                this.bUf.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
                return;
            case 1:
                setBackgroundColor(-1);
                this.bUe.setBackgroundColor(-1644826);
                this.bUf.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_ATOP);
                return;
            default:
                return;
        }
    }

    private void a(AttributeSet attributeSet, int i) {
        this.bUe = new View(getContext());
        addView(this.bUe, new FrameLayout.LayoutParams(-1, 1));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(0);
        frameLayout.setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds40), 0, 0, 0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.view.BackBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BackBar.this.bUd != null) {
                    BackBar.this.bUd.onBack();
                }
            }
        });
        addView(frameLayout, new FrameLayout.LayoutParams(-2, -1));
        this.bUf = new ImageView(getContext());
        this.bUf.setImageResource(a.e.sdk_icon_live_back);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        frameLayout.addView(this.bUf, layoutParams);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.BackBar, i, a.i.BackBarLight);
        setTheme(obtainStyledAttributes.getInt(a.j.BackBar_backbar_theme, 1));
        obtainStyledAttributes.recycle();
    }
}
