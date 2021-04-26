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
import d.a.h0.a.e;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.h0;
import d.a.h0.a.j;
/* loaded from: classes3.dex */
public class SwanAppActionBar extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f12228e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12229f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12230g;

    /* renamed from: h  reason: collision with root package name */
    public View f12231h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f12232i;
    public TextView j;
    public String k;
    public int l;
    public float m;
    public float n;
    public float o;
    public View p;
    public ImageView q;
    public ImageView r;
    public View s;
    public ImageView t;
    public c u;
    public boolean v;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetector f12233e;

        public a(GestureDetector gestureDetector) {
            this.f12233e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f12233e.onTouchEvent(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.u != null) {
                SwanAppActionBar.this.u.a(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.v;
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
        setTitleColor(d.a.h0.a.c.aiapps_black_text);
        setLeftBackViewSrc(e.aiapps_action_bar_back_black_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_black_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_black_selector : e.aiapps_action_bar_menu_black_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_black_selector);
        setRightLineSrc(d.a.h0.a.c.aiapps_action_bar_menu_line_color);
        setRightZoneBgSrc(z ? d.a.h0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg);
    }

    private void setFrontColorWhite(boolean z) {
        setTitleColor(d.a.h0.a.c.aiapps_white_text);
        setLeftBackViewSrc(e.aiapps_action_bar_back_white_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_white_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_white_selector : e.aiapps_action_bar_menu_white_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_white_selector);
        setRightLineSrc(d.a.h0.a.c.aiapps_action_bar_menu_line_white);
        setRightZoneBgSrc(z ? d.a.h0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg_solid);
    }

    public final Drawable c(int i2) {
        Drawable drawable = getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(g.aiapps_action_bar, this);
        this.f12228e = findViewById(f.titlebar_left_zone);
        TextView textView = (TextView) findViewById(f.left_first_view);
        this.f12229f = textView;
        textView.setCompoundDrawables(c(e.aiapps_action_bar_back_selector), null, null, null);
        this.f12229f.setTextColor(getResources().getColorStateList(d.a.h0.a.c.swan_app_action_bar_operation_btn_selector));
        this.f12230g = (TextView) findViewById(f.left_second_view);
        this.f12231h = findViewById(f.titlebar_center_zone);
        this.f12232i = (ProgressBar) findViewById(f.aiapps_nav_loading_progressbar);
        this.j = (TextView) findViewById(f.title_text_center);
        float f2 = this.m;
        if (f2 != -1.0f) {
            float f3 = this.n;
            if (f3 != -1.0f) {
                float f4 = this.o;
                if (f4 != -1.0f) {
                    this.f12229f.setShadowLayer(f4, f2, f3, this.l);
                }
            }
        }
        this.p = findViewById(f.titlebar_right_menu);
        this.q = (ImageView) findViewById(f.titlebar_right_menu_img);
        this.r = (ImageView) findViewById(f.titlebar_right_menu_red_dot);
        this.s = findViewById(f.titlebar_right_menu_line);
        this.t = (ImageView) findViewById(f.titlebar_right_menu_exit);
        setTitle(this.k);
        setTitleColor(d.a.h0.a.c.aiapps_black_text);
        setRightMenuImageSrc(e.aiapps_action_bar_menu_normal_selector);
        setOnTouchListener(new a(new GestureDetector(getContext(), new b(this, null))));
    }

    public final void e(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j.SwanAppActionBar, 0, 0);
        try {
            this.k = obtainStyledAttributes.getString(j.SwanAppActionBar_titleText);
            this.l = obtainStyledAttributes.getColor(j.SwanAppActionBar_titleTxtShadowColor, -16777216);
            this.m = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
            this.n = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
            this.o = obtainStyledAttributes.getFloat(j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
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
        ProgressBar progressBar = this.f12232i;
        if (progressBar != null) {
            if (z && progressBar.getVisibility() == 8) {
                this.f12232i.setVisibility(0);
            } else if (z || this.f12232i.getVisibility() != 0) {
            } else {
                this.f12232i.setVisibility(8);
            }
        }
    }

    public TextView getCenterTitleView() {
        return this.j;
    }

    public View getRightMenu() {
        return this.p;
    }

    public void setActionBarCustom(boolean z) {
        this.v = z;
        int i2 = z ? 8 : 0;
        setLeftZoneVisibility(i2);
        setCenterZoneVisibility(i2);
    }

    public void setCenterZoneVisibility(int i2) {
        this.f12231h.setVisibility(i2);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.f12229f.setOnClickListener(onClickListener);
    }

    public void setLeftBackViewMinWidth(int i2) {
        this.f12229f.setMinimumWidth(i2);
    }

    public void setLeftBackViewSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f12229f.setCompoundDrawables(drawable, null, null, null);
        this.f12229f.setSelected(false);
    }

    public void setLeftBackViewVisibility(boolean z) {
        TextView textView = this.f12229f;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.f12230g.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f12230g.setCompoundDrawables(drawable, null, null, null);
        this.f12230g.setSelected(false);
    }

    public void setLeftHomeViewVisibility(int i2) {
        this.f12230g.setVisibility(i2);
    }

    public void setLeftZoneVisibility(int i2) {
        this.f12228e.setVisibility(i2);
    }

    public void setOnDoubleClickListener(c cVar) {
        this.u = cVar;
    }

    public void setRightExitImageSrc(int i2) {
        this.t.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.t.setOnClickListener(onClickListener);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.t.setVisibility(0);
            this.s.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
        this.s.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.p.getLayoutParams()).setMargins(0, 0, h0.e(getContext(), 4.6f), 0);
    }

    public void setRightLineSrc(int i2) {
        this.s.setBackgroundResource(i2);
    }

    public void setRightMenuAlpha(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.p.setAlpha(f2);
    }

    public void setRightMenuEnable(boolean z) {
        this.q.setEnabled(z);
        this.s.setEnabled(z);
        this.t.setEnabled(z);
    }

    public void setRightMenuImageSrc(int i2) {
        this.q.setImageDrawable(getResources().getDrawable(i2));
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.r.setVisibility(z ? 0 : 8);
    }

    public void setRightZoneBgSrc(int i2) {
        this.p.setBackgroundResource(i2);
    }

    public void setRightZoneVisibility(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }

    public void setTitle(String str) {
        this.k = str;
        this.j.setText(str);
    }

    public void setTitleColor(int i2) {
        this.j.setTextColor(getResources().getColor(i2));
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
