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
import com.baidu.swan.apps.as.af;
/* loaded from: classes11.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View bZR;
    private TextView bZS;
    private TextView bZT;
    private View bZU;
    private ProgressBar bZV;
    private TextView bZW;
    private int bZX;
    private float bZY;
    private float bZZ;
    private float caa;
    private View cab;
    private ImageView cac;
    private ImageView cad;
    private View cae;
    private ImageView caf;
    private b cag;
    private boolean cah;
    private String mTitle;

    /* loaded from: classes11.dex */
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
                this.bZX = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.bZY = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.bZZ = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.caa = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.bZR = findViewById(a.f.titlebar_left_zone);
        this.bZS = (TextView) findViewById(a.f.left_first_view);
        this.bZS.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.bZS.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.bZT = (TextView) findViewById(a.f.left_second_view);
        this.bZU = findViewById(a.f.titlebar_center_zone);
        this.bZV = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.bZW = (TextView) findViewById(a.f.title_text_center);
        if (this.bZY != -1.0f && this.bZZ != -1.0f && this.caa != -1.0f) {
            this.bZS.setShadowLayer(this.caa, this.bZY, this.bZZ, this.bZX);
        }
        this.cab = findViewById(a.f.titlebar_right_menu);
        this.cac = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.cad = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.cae = findViewById(a.f.titlebar_right_menu_line);
        this.caf = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.bZR.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.bZS != null) {
            this.bZS.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bZS.setCompoundDrawables(drawable, null, null, null);
        this.bZS.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.bZS.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.bZT.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bZT.setCompoundDrawables(drawable, null, null, null);
        this.bZT.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.bZU.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.bZW;
    }

    public View getRightMenu() {
        return this.cab;
    }

    public void ej(boolean z) {
        if (this.bZV != null) {
            if (z && this.bZV.getVisibility() == 8) {
                this.bZV.setVisibility(0);
            } else if (!z && this.bZV.getVisibility() == 0) {
                this.bZV.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.bZW.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.bZW.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.cab.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.caf.setVisibility(0);
            this.cae.setVisibility(0);
            return;
        }
        this.caf.setVisibility(8);
        this.cae.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.cab.getLayoutParams()).setMargins(0, 0, af.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.cad.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.cac.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.caf.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.cae.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.cab.setBackgroundResource(i);
    }

    public boolean u(@ColorInt int i, boolean z) {
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
        this.cah = z;
        int i = this.cah ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.bZS.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.bZT.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.cac.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.caf.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.cag = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.cah;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.cag != null) {
                SwanAppActionBar.this.cag.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.cab.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.cac.setEnabled(z);
        this.cae.setEnabled(z);
        this.caf.setEnabled(z);
    }
}
