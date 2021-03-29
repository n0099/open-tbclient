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
import d.b.g0.a.e;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.h0;
import d.b.g0.a.j;
/* loaded from: classes3.dex */
public class SwanAppActionBar extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f12684e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12685f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12686g;

    /* renamed from: h  reason: collision with root package name */
    public View f12687h;
    public ProgressBar i;
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
        public final /* synthetic */ GestureDetector f12688e;

        public a(GestureDetector gestureDetector) {
            this.f12688e = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f12688e.onTouchEvent(motionEvent);
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
        setTitleColor(d.b.g0.a.c.aiapps_black_text);
        setLeftBackViewSrc(e.aiapps_action_bar_back_black_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_black_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_black_selector : e.aiapps_action_bar_menu_black_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_black_selector);
        setRightLineSrc(d.b.g0.a.c.aiapps_action_bar_menu_line_color);
        setRightZoneBgSrc(z ? d.b.g0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg);
    }

    private void setFrontColorWhite(boolean z) {
        setTitleColor(d.b.g0.a.c.aiapps_white_text);
        setLeftBackViewSrc(e.aiapps_action_bar_back_white_selector);
        setLeftHomeViewSrc(e.aiapps_action_bar_home_white_selector);
        setRightMenuImageSrc(z ? e.aiapps_action_bar_single_menu_white_selector : e.aiapps_action_bar_menu_white_selector);
        setRightExitImageSrc(e.aiapps_action_bar_exit_white_selector);
        setRightLineSrc(d.b.g0.a.c.aiapps_action_bar_menu_line_white);
        setRightZoneBgSrc(z ? d.b.g0.a.c.aiapps_transparent : e.aiapps_action_bar_right_menu_bg_solid);
    }

    public final Drawable c(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(g.aiapps_action_bar, this);
        this.f12684e = findViewById(f.titlebar_left_zone);
        TextView textView = (TextView) findViewById(f.left_first_view);
        this.f12685f = textView;
        textView.setCompoundDrawables(c(e.aiapps_action_bar_back_selector), null, null, null);
        this.f12685f.setTextColor(getResources().getColorStateList(d.b.g0.a.c.swan_app_action_bar_operation_btn_selector));
        this.f12686g = (TextView) findViewById(f.left_second_view);
        this.f12687h = findViewById(f.titlebar_center_zone);
        this.i = (ProgressBar) findViewById(f.aiapps_nav_loading_progressbar);
        this.j = (TextView) findViewById(f.title_text_center);
        float f2 = this.m;
        if (f2 != -1.0f) {
            float f3 = this.n;
            if (f3 != -1.0f) {
                float f4 = this.o;
                if (f4 != -1.0f) {
                    this.f12685f.setShadowLayer(f4, f2, f3, this.l);
                }
            }
        }
        this.p = findViewById(f.titlebar_right_menu);
        this.q = (ImageView) findViewById(f.titlebar_right_menu_img);
        this.r = (ImageView) findViewById(f.titlebar_right_menu_red_dot);
        this.s = findViewById(f.titlebar_right_menu_line);
        this.t = (ImageView) findViewById(f.titlebar_right_menu_exit);
        setTitle(this.k);
        setTitleColor(d.b.g0.a.c.aiapps_black_text);
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

    public void g(boolean z) {
        ProgressBar progressBar = this.i;
        if (progressBar != null) {
            if (z && progressBar.getVisibility() == 8) {
                this.i.setVisibility(0);
            } else if (z || this.i.getVisibility() != 0) {
            } else {
                this.i.setVisibility(8);
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
        int i = z ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setCenterZoneVisibility(int i) {
        this.f12687h.setVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.f12685f.setOnClickListener(onClickListener);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.f12685f.setMinimumWidth(i);
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f12685f.setCompoundDrawables(drawable, null, null, null);
        this.f12685f.setSelected(false);
    }

    public void setLeftBackViewVisibility(boolean z) {
        TextView textView = this.f12685f;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.f12686g.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.f12686g.setCompoundDrawables(drawable, null, null, null);
        this.f12686g.setSelected(false);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.f12686g.setVisibility(i);
    }

    public void setLeftZoneVisibility(int i) {
        this.f12684e.setVisibility(i);
    }

    public void setOnDoubleClickListener(c cVar) {
        this.u = cVar;
    }

    public void setRightExitImageSrc(int i) {
        this.t.setImageDrawable(getResources().getDrawable(i));
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

    public void setRightLineSrc(int i) {
        this.s.setBackgroundResource(i);
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

    public void setRightMenuImageSrc(int i) {
        this.q.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.q.setOnClickListener(onClickListener);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.r.setVisibility(z ? 0 : 8);
    }

    public void setRightZoneBgSrc(int i) {
        this.p.setBackgroundResource(i);
    }

    public void setRightZoneVisibility(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }

    public void setTitle(String str) {
        this.k = str;
        this.j.setText(str);
    }

    public void setTitleColor(int i) {
        this.j.setTextColor(getResources().getColor(i));
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
        d();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context, attributeSet);
        d();
    }
}
