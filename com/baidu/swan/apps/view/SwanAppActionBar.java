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
import d.a.l0.a.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.j;
import d.a.l0.a.v2.n0;
/* loaded from: classes3.dex */
public class SwanAppActionBar extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f11335e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11336f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11337g;

    /* renamed from: h  reason: collision with root package name */
    public View f11338h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f11339i;
    public View j;
    public ProgressBar k;
    public TextView l;
    public String m;
    public int n;
    public float o;
    public float p;
    public float q;
    public View r;
    public ImageView s;
    public ImageView t;
    public View u;
    public ImageView v;
    public c w;
    public boolean x;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetector f11340e;

        public a(GestureDetector gestureDetector) {
            this.f11340e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f11340e.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.w != null) {
                SwanAppActionBar.this.w.a(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.x;
        }

        public /* synthetic */ b(SwanAppActionBar swanAppActionBar, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view);
    }

    public SwanAppActionBar(Context context) {
        super(context);
        d();
    }

    private void setFrontColorBlack(boolean z) {
        setTitleColor(-16777216);
        setLeftBackViewSrc(e.aiapps_action_bar_back_black_selector);
        setLeftFloatBackViewSrc(e.aiapps_action_bar_back_black_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_black_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_black_selector : e.aiapps_action_bar_menu_black_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_black_selector);
        setRightLineSrc(d.a.l0.a.c.aiapps_action_bar_menu_line_color);
        setRightZoneBgSrc(z ? d.a.l0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg);
    }

    private void setFrontColorWhite(boolean z) {
        setTitleColor(-1);
        setLeftBackViewSrc(e.aiapps_action_bar_back_white_selector);
        setLeftFloatBackViewSrc(e.aiapps_action_bar_back_white_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_white_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_white_selector : e.aiapps_action_bar_menu_white_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_white_selector);
        setRightLineSrc(d.a.l0.a.c.aiapps_action_bar_menu_line_white);
        setRightZoneBgSrc(z ? d.a.l0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg_solid);
    }

    public final Drawable c(int i2) {
        Drawable drawable = getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(g.aiapps_action_bar, this);
        this.f11335e = findViewById(f.titlebar_left_zone);
        TextView textView = (TextView) findViewById(f.left_first_view);
        this.f11336f = textView;
        textView.setCompoundDrawables(c(e.aiapps_action_bar_back_black_selector), null, null, null);
        this.f11336f.setTextColor(getResources().getColorStateList(d.a.l0.a.c.swan_app_action_bar_operation_btn_selector));
        this.f11337g = (TextView) findViewById(f.left_second_view);
        this.f11338h = findViewById(f.titlebar_left_float_zone);
        this.f11339i = (ImageView) findViewById(f.left_float_back_view);
        this.j = findViewById(f.titlebar_center_zone);
        this.k = (ProgressBar) findViewById(f.aiapps_nav_loading_progressbar);
        this.l = (TextView) findViewById(f.title_text_center);
        float f2 = this.o;
        if (f2 != -1.0f) {
            float f3 = this.p;
            if (f3 != -1.0f) {
                float f4 = this.q;
                if (f4 != -1.0f) {
                    this.f11336f.setShadowLayer(f4, f2, f3, this.n);
                }
            }
        }
        this.r = findViewById(f.titlebar_right_menu);
        this.s = (ImageView) findViewById(f.titlebar_right_menu_img);
        this.t = (ImageView) findViewById(f.titlebar_right_menu_red_dot);
        this.u = findViewById(f.titlebar_right_menu_line);
        this.v = (ImageView) findViewById(f.titlebar_right_menu_exit);
        setTitle(this.m);
        setTitleColor(-16777216);
        setRightMenuImageSrc(e.aiapps_action_bar_menu_normal_selector);
        setOnTouchListener(new a(new GestureDetector(getContext(), new b(this, null))));
    }

    public final void e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j.SwanAppActionBar, 0, 0);
        try {
            this.m = obtainStyledAttributes.getString(j.SwanAppActionBar_titleText);
            this.n = obtainStyledAttributes.getColor(j.SwanAppActionBar_titleTxtShadowColor, -16777216);
            this.o = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
            this.p = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
            this.q = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean f(@ColorInt int i2, boolean z) {
        if (i2 == -1) {
            setFrontColorWhite(z);
            return true;
        } else if (i2 == -16777216) {
            setFrontColorBlack(z);
            return true;
        } else {
            setFrontColorWhite(z);
            return false;
        }
    }

    public void g(boolean z) {
        ProgressBar progressBar = this.k;
        if (progressBar != null) {
            if (z && progressBar.getVisibility() == 8) {
                this.k.setVisibility(0);
            } else if (z || this.k.getVisibility() != 0) {
            } else {
                this.k.setVisibility(8);
            }
        }
    }

    public TextView getCenterTitleView() {
        return this.l;
    }

    public View getRightMenu() {
        return this.r;
    }

    public void setActionBarCustom(boolean z, boolean z2) {
        this.x = z;
        int i2 = z ? 8 : 0;
        setLeftZoneVisibility(i2);
        setCenterZoneVisibility(i2);
        setLeftFloatZoneVisibility(z2 ? 0 : 8);
    }

    public void setCenterZoneVisibility(int i2) {
        this.j.setVisibility(i2);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.f11336f.setOnClickListener(onClickListener);
    }

    public void setLeftBackViewMinWidth(int i2) {
        this.f11336f.setMinimumWidth(i2);
    }

    public void setLeftBackViewSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f11336f.setCompoundDrawables(drawable, null, null, null);
        this.f11336f.setSelected(false);
    }

    public void setLeftBackViewVisibility(boolean z) {
        TextView textView = this.f11336f;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftFloatBackViewClickListener(View.OnClickListener onClickListener) {
        this.f11339i.setOnClickListener(onClickListener);
    }

    public void setLeftFloatBackViewSrc(int i2) {
        this.f11339i.setImageResource(i2);
    }

    public void setLeftFloatZoneVisibility(int i2) {
        this.f11338h.setVisibility(i2);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.f11337g.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f11337g.setCompoundDrawables(drawable, null, null, null);
        this.f11337g.setSelected(false);
    }

    public void setLeftHomeViewVisibility(int i2) {
        this.f11337g.setVisibility(i2);
    }

    public void setLeftZoneVisibility(int i2) {
        this.f11335e.setVisibility(i2);
    }

    public void setOnDoubleClickListener(c cVar) {
        this.w = cVar;
    }

    public void setRightExitImageSrc(int i2) {
        this.v.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.v.setOnClickListener(onClickListener);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.v.setVisibility(0);
            this.u.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.r.getLayoutParams()).setMargins(0, 0, n0.f(getContext(), 4.6f), 0);
    }

    public void setRightLineSrc(int i2) {
        this.u.setBackgroundResource(i2);
    }

    public void setRightMenuAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.r.setAlpha(f2);
    }

    public void setRightMenuEnable(boolean z) {
        this.s.setEnabled(z);
        this.u.setEnabled(z);
        this.v.setEnabled(z);
    }

    public void setRightMenuImageSrc(int i2) {
        this.s.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.s.setOnClickListener(onClickListener);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.t.setVisibility(z ? 0 : 8);
    }

    public void setRightZoneBgSrc(int i2) {
        this.r.setBackgroundResource(i2);
    }

    public void setRightZoneVisibility(boolean z) {
        this.r.setVisibility(z ? 0 : 8);
    }

    public void setTitle(String str) {
        this.m = str;
        this.l.setText(str);
    }

    public void setTitleColor(@ColorInt int i2) {
        this.l.setTextColor(i2);
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
        d();
    }

    public void setTitle(int i2) {
        setTitle(getResources().getString(i2));
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e(context, attributeSet);
        d();
    }
}
