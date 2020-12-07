package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
/* loaded from: classes25.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View dKY;
    private TextView dKZ;
    private TextView dLa;
    private View dLb;
    private ProgressBar dLc;
    private TextView dLd;
    private int dLe;
    private float dLf;
    private float dLg;
    private float dLh;
    private View dLi;
    private ImageView dLj;
    private ImageView dLk;
    private View dLl;
    private ImageView dLm;
    private b dLn;
    private boolean dLo;
    private String mTitle;

    /* loaded from: classes25.dex */
    public interface b {
        void onDoubleClick(View view);
    }

    public SwanAppActionBar(Context context) {
        super(context);
        init();
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttrs(context, attributeSet);
        init();
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.j.SwanAppActionBar, 0, 0);
            try {
                this.mTitle = obtainStyledAttributes.getString(a.j.SwanAppActionBar_titleText);
                this.dLe = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.dLf = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.dLg = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.dLh = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.dKY = findViewById(a.f.titlebar_left_zone);
        this.dKZ = (TextView) findViewById(a.f.left_first_view);
        this.dKZ.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dKZ.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.dLa = (TextView) findViewById(a.f.left_second_view);
        this.dLb = findViewById(a.f.titlebar_center_zone);
        this.dLc = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.dLd = (TextView) findViewById(a.f.title_text_center);
        if (this.dLf != -1.0f && this.dLg != -1.0f && this.dLh != -1.0f) {
            this.dKZ.setShadowLayer(this.dLh, this.dLf, this.dLg, this.dLe);
        }
        this.dLi = findViewById(a.f.titlebar_right_menu);
        this.dLj = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.dLk = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.dLl = findViewById(a.f.titlebar_right_menu_line);
        this.dLm = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
        setTitle(this.mTitle);
        setTitleColor(a.c.aiapps_black_text);
        setRightMenuImageSrc(a.e.aiapps_action_bar_menu_normal_selector);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new a());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.view.SwanAppActionBar.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setLeftZoneVisibility(int i) {
        this.dKY.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dKZ != null) {
            this.dKZ.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dKZ.setCompoundDrawables(drawable, null, null, null);
        this.dKZ.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dKZ.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.dLa.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dLa.setCompoundDrawables(drawable, null, null, null);
        this.dLa.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.dLb.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.dLd;
    }

    public View getRightMenu() {
        return this.dLi;
    }

    public void hr(boolean z) {
        if (this.dLc != null) {
            if (z && this.dLc.getVisibility() == 8) {
                this.dLc.setVisibility(0);
            } else if (!z && this.dLc.getVisibility() == 0) {
                this.dLc.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.dLd.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.dLd.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.dLi.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dLm.setVisibility(0);
            this.dLl.setVisibility(0);
            return;
        }
        this.dLm.setVisibility(8);
        this.dLl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dLi.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.dLk.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.dLj.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dLm.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.dLl.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.dLi.setBackgroundResource(i);
    }

    public boolean E(@ColorInt int i, boolean z) {
        if (i == -1) {
            setFrontColorWhite(z);
        } else if (i == -16777216) {
            setFrontColorBlack(z);
        } else {
            setFrontColorWhite(z);
            return false;
        }
        return true;
    }

    private void setFrontColorWhite(boolean z) {
        setTitleColor(a.c.aiapps_white_text);
        setLeftBackViewSrc(a.e.aiapps_action_bar_back_white_selector);
        setLeftHomeViewSrc(a.e.aiapps_action_bar_home_white_selector);
        setRightMenuImageSrc(z ? a.e.aiapps_action_bar_single_menu_white_selector : a.e.aiapps_action_bar_menu_white_selector);
        setRightExitImageSrc(a.e.aiapps_action_bar_exit_white_selector);
        setRightLineSrc(a.c.aiapps_action_bar_menu_line_white);
        setRightZoneBgSrc(z ? a.c.aiapps_transparent : a.e.aiapps_action_bar_right_menu_bg_solid);
    }

    private void setFrontColorBlack(boolean z) {
        setTitleColor(a.c.aiapps_black_text);
        setLeftBackViewSrc(a.e.aiapps_action_bar_back_black_selector);
        setLeftHomeViewSrc(a.e.aiapps_action_bar_home_black_selector);
        setRightMenuImageSrc(z ? a.e.aiapps_action_bar_single_menu_black_selector : a.e.aiapps_action_bar_menu_black_selector);
        setRightExitImageSrc(a.e.aiapps_action_bar_exit_black_selector);
        setRightLineSrc(a.c.aiapps_action_bar_menu_line_color);
        setRightZoneBgSrc(z ? a.c.aiapps_transparent : a.e.aiapps_action_bar_right_menu_bg);
    }

    private Drawable getDrawableFromId(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dLo = z;
        int i = this.dLo ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dKZ.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.dLa.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dLj.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dLm.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dLn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.dLo;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dLn != null) {
                SwanAppActionBar.this.dLn.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.dLi.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.dLj.setEnabled(z);
        this.dLl.setEnabled(z);
        this.dLm.setEnabled(z);
    }
}
