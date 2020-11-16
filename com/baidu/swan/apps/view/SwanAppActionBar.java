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
/* loaded from: classes7.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View dEa;
    private TextView dEb;
    private TextView dEc;
    private View dEd;
    private ProgressBar dEe;
    private TextView dEf;
    private int dEg;
    private float dEh;
    private float dEi;
    private float dEj;
    private View dEk;
    private ImageView dEl;
    private ImageView dEm;
    private View dEn;
    private ImageView dEo;
    private b dEp;
    private boolean dEq;
    private String mTitle;

    /* loaded from: classes7.dex */
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
                this.dEg = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.dEh = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.dEi = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.dEj = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.dEa = findViewById(a.f.titlebar_left_zone);
        this.dEb = (TextView) findViewById(a.f.left_first_view);
        this.dEb.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dEb.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.dEc = (TextView) findViewById(a.f.left_second_view);
        this.dEd = findViewById(a.f.titlebar_center_zone);
        this.dEe = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.dEf = (TextView) findViewById(a.f.title_text_center);
        if (this.dEh != -1.0f && this.dEi != -1.0f && this.dEj != -1.0f) {
            this.dEb.setShadowLayer(this.dEj, this.dEh, this.dEi, this.dEg);
        }
        this.dEk = findViewById(a.f.titlebar_right_menu);
        this.dEl = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.dEm = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.dEn = findViewById(a.f.titlebar_right_menu_line);
        this.dEo = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.dEa.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dEb != null) {
            this.dEb.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dEb.setCompoundDrawables(drawable, null, null, null);
        this.dEb.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dEb.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.dEc.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dEc.setCompoundDrawables(drawable, null, null, null);
        this.dEc.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.dEd.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.dEf;
    }

    public View getRightMenu() {
        return this.dEk;
    }

    public void hc(boolean z) {
        if (this.dEe != null) {
            if (z && this.dEe.getVisibility() == 8) {
                this.dEe.setVisibility(0);
            } else if (!z && this.dEe.getVisibility() == 0) {
                this.dEe.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.dEf.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.dEf.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.dEk.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dEo.setVisibility(0);
            this.dEn.setVisibility(0);
            return;
        }
        this.dEo.setVisibility(8);
        this.dEn.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dEk.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.dEm.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.dEl.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dEo.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.dEn.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.dEk.setBackgroundResource(i);
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
        this.dEq = z;
        int i = this.dEq ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dEb.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.dEc.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dEl.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dEo.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dEp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.dEq;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dEp != null) {
                SwanAppActionBar.this.dEp.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.dEk.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.dEl.setEnabled(z);
        this.dEn.setEnabled(z);
        this.dEo.setEnabled(z);
    }
}
