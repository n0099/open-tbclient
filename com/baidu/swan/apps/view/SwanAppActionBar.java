package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.tieba.R;
import com.baidu.tieba.mr1;
import com.baidu.tieba.uo3;
/* loaded from: classes4.dex */
public class SwanAppActionBar extends RelativeLayout {
    public View a;
    public TextView b;
    public TextView c;
    public View d;
    public ImageView e;
    public View f;
    public ProgressBar g;
    public TextView h;
    public String i;
    public int j;
    public float k;
    public float l;
    public float m;
    public View n;
    public ImageView o;
    public ImageView p;
    public View q;
    public ImageView r;
    public c s;
    public boolean t;

    /* loaded from: classes4.dex */
    public interface c {
        void onDoubleClick(View view2);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public final /* synthetic */ GestureDetector a;

        public a(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.s != null) {
                SwanAppActionBar.this.s.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.t;
        }

        public /* synthetic */ b(SwanAppActionBar swanAppActionBar, a aVar) {
            this();
        }
    }

    public SwanAppActionBar(Context context) {
        super(context);
        d();
    }

    public final Drawable c(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void g(boolean z) {
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            if (z && progressBar.getVisibility() == 8) {
                this.g.setVisibility(0);
            } else if (!z && this.g.getVisibility() == 0) {
                this.g.setVisibility(8);
            }
        }
    }

    public void setCenterZoneVisibility(int i) {
        this.f.setVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.b.setMinimumWidth(i);
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.b.setCompoundDrawables(drawable, null, null, null);
        this.b.setSelected(false);
    }

    public void setLeftBackViewVisibility(boolean z) {
        int i;
        TextView textView = this.b;
        if (textView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void setLeftFloatBackViewClickListener(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setLeftFloatBackViewSrc(int i) {
        this.e.setImageResource(i);
    }

    public void setLeftFloatZoneVisibility(int i) {
        this.d.setVisibility(i);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.c.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.c.setCompoundDrawables(drawable, null, null, null);
        this.c.setSelected(false);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.c.setVisibility(i);
    }

    public void setLeftZoneVisibility(int i) {
        this.a.setVisibility(i);
    }

    public void setOnDoubleClickListener(c cVar) {
        this.s = cVar;
    }

    public void setRightExitImageSrc(int i) {
        this.r.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.r.setOnClickListener(onClickListener);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.r.setVisibility(0);
            this.q.setVisibility(0);
            return;
        }
        this.r.setVisibility(8);
        this.q.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.n.getLayoutParams()).setMargins(0, 0, uo3.f(getContext(), 4.6f), 0);
    }

    public void setRightFloatZoneVisibility(int i) {
        this.n.setVisibility(i);
    }

    public void setRightLineSrc(int i) {
        this.q.setBackgroundResource(i);
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.n.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.o.setEnabled(z);
        this.q.setEnabled(z);
        this.r.setEnabled(z);
    }

    public void setRightMenuImageSrc(int i) {
        this.o.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.o.setOnClickListener(onClickListener);
    }

    public void setRightRedDotVisibility(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        this.p.setVisibility(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.n.setBackgroundResource(i);
    }

    public void setRightZoneVisibility(boolean z) {
        int i;
        View view2 = this.n;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(@ColorInt int i) {
        this.h.setTextColor(i);
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
        d();
    }

    public boolean f(@ColorInt int i, boolean z) {
        if (i == -1) {
            setFrontColorWhite(z);
            return true;
        } else if (i == -16777216) {
            setFrontColorBlack(z);
            return true;
        } else {
            setFrontColorWhite(z);
            return false;
        }
    }

    public void setActionBarCustom(boolean z, boolean z2) {
        int i;
        this.t = z;
        int i2 = 8;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
        if (z2) {
            i2 = 0;
        }
        setLeftFloatZoneVisibility(i2);
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
        d();
    }

    private void setFrontColorBlack(boolean z) {
        int i;
        int i2;
        setTitleColor(-16777216);
        setLeftBackViewSrc(R.drawable.obfuscated_res_0x7f08011c);
        setLeftFloatBackViewSrc(R.drawable.obfuscated_res_0x7f08011c);
        setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f08012c);
        if (z) {
            i = R.drawable.obfuscated_res_0x7f08013b;
        } else {
            i = R.drawable.obfuscated_res_0x7f080132;
        }
        setRightMenuImageSrc(i);
        setRightExitImageSrc(R.drawable.obfuscated_res_0x7f080126);
        setRightLineSrc(R.color.obfuscated_res_0x7f0603ff);
        if (z) {
            i2 = R.color.obfuscated_res_0x7f06046d;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f080139;
        }
        setRightZoneBgSrc(i2);
    }

    private void setFrontColorWhite(boolean z) {
        int i;
        int i2;
        setTitleColor(-1);
        setLeftBackViewSrc(R.drawable.obfuscated_res_0x7f080120);
        setLeftFloatBackViewSrc(R.drawable.obfuscated_res_0x7f080120);
        setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f08012f);
        if (z) {
            i = R.drawable.obfuscated_res_0x7f08013e;
        } else {
            i = R.drawable.obfuscated_res_0x7f080138;
        }
        setRightMenuImageSrc(i);
        setRightExitImageSrc(R.drawable.obfuscated_res_0x7f080129);
        setRightLineSrc(R.color.obfuscated_res_0x7f060400);
        if (z) {
            i2 = R.color.obfuscated_res_0x7f06046d;
        } else {
            i2 = R.drawable.obfuscated_res_0x7f08013a;
        }
        setRightZoneBgSrc(i2);
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0096, this);
        this.a = findViewById(R.id.obfuscated_res_0x7f0925ce);
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0914ef);
        this.b = textView;
        textView.setCompoundDrawables(c(R.drawable.obfuscated_res_0x7f08011c), null, null, null);
        this.b.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.obfuscated_res_0x7f060aaf));
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f0914f9);
        this.d = findViewById(R.id.obfuscated_res_0x7f0925cc);
        this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0914f0);
        this.f = findViewById(R.id.obfuscated_res_0x7f0925c9);
        this.g = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f0901b6);
        this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0925bd);
        float f = this.k;
        if (f != -1.0f) {
            float f2 = this.l;
            if (f2 != -1.0f) {
                float f3 = this.m;
                if (f3 != -1.0f) {
                    this.b.setShadowLayer(f3, f, f2, this.j);
                }
            }
        }
        this.n = findViewById(R.id.obfuscated_res_0x7f0925d6);
        this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925d8);
        this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925da);
        this.q = findViewById(R.id.obfuscated_res_0x7f0925d9);
        this.r = (ImageView) findViewById(R.id.obfuscated_res_0x7f0925d7);
        setTitle(this.i);
        setTitleColor(-16777216);
        setRightMenuImageSrc(R.drawable.obfuscated_res_0x7f080135);
        setOnTouchListener(new a(new GestureDetector(getContext(), new b(this, null))));
    }

    public final void e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, mr1.SwanAppActionBar, 0, 0);
        try {
            this.i = obtainStyledAttributes.getString(0);
            this.j = obtainStyledAttributes.getColor(1, -16777216);
            this.k = obtainStyledAttributes.getFloat(2, -1.0f);
            this.l = obtainStyledAttributes.getFloat(3, -1.0f);
            this.m = obtainStyledAttributes.getFloat(4, -1.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public TextView getCenterTitleView() {
        return this.h;
    }

    public View getRightMenu() {
        return this.n;
    }

    public void setRightMenuStyle() {
        int i;
        this.t = true;
        if (1 != 0) {
            i = 8;
        } else {
            i = 0;
        }
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
        setRightFloatZoneVisibility(0);
    }

    public void setRightZoneImmersiveStyle() {
        setRightMenuImageSrc(R.drawable.obfuscated_res_0x7f080138);
        setRightExitImageSrc(R.drawable.obfuscated_res_0x7f080129);
        setRightLineSrc(R.color.obfuscated_res_0x7f060400);
        setRightZoneBgSrc(R.drawable.obfuscated_res_0x7f08013a);
    }

    public void setTitle(String str) {
        this.i = str;
        this.h.setText(str);
    }
}
