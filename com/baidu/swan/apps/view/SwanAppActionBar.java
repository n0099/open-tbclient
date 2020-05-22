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
import com.baidu.swan.apps.aq.ag;
/* loaded from: classes11.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View cLR;
    private TextView cLS;
    private TextView cLT;
    private View cLU;
    private ProgressBar cLV;
    private TextView cLW;
    private int cLX;
    private float cLY;
    private float cLZ;
    private float cMa;
    private View cMb;
    private ImageView cMc;
    private ImageView cMd;
    private View cMe;
    private ImageView cMf;
    private b cMg;
    private boolean cMh;
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
                this.cLX = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.cLY = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.cLZ = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.cMa = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.cLR = findViewById(a.f.titlebar_left_zone);
        this.cLS = (TextView) findViewById(a.f.left_first_view);
        this.cLS.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.cLS.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.cLT = (TextView) findViewById(a.f.left_second_view);
        this.cLU = findViewById(a.f.titlebar_center_zone);
        this.cLV = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.cLW = (TextView) findViewById(a.f.title_text_center);
        if (this.cLY != -1.0f && this.cLZ != -1.0f && this.cMa != -1.0f) {
            this.cLS.setShadowLayer(this.cMa, this.cLY, this.cLZ, this.cLX);
        }
        this.cMb = findViewById(a.f.titlebar_right_menu);
        this.cMc = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.cMd = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.cMe = findViewById(a.f.titlebar_right_menu_line);
        this.cMf = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.cLR.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.cLS != null) {
            this.cLS.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cLS.setCompoundDrawables(drawable, null, null, null);
        this.cLS.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.cLS.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.cLT.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cLT.setCompoundDrawables(drawable, null, null, null);
        this.cLT.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.cLU.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.cLW;
    }

    public View getRightMenu() {
        return this.cMb;
    }

    public void fB(boolean z) {
        if (this.cLV != null) {
            if (z && this.cLV.getVisibility() == 8) {
                this.cLV.setVisibility(0);
            } else if (!z && this.cLV.getVisibility() == 0) {
                this.cLV.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.cLW.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.cLW.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.cMb.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.cMf.setVisibility(0);
            this.cMe.setVisibility(0);
            return;
        }
        this.cMf.setVisibility(8);
        this.cMe.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.cMb.getLayoutParams()).setMargins(0, 0, ag.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.cMd.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.cMc.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.cMf.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.cMe.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.cMb.setBackgroundResource(i);
    }

    public boolean A(@ColorInt int i, boolean z) {
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
        this.cMh = z;
        int i = this.cMh ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.cLS.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.cLT.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.cMc.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.cMf.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.cMg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.cMh;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.cMg != null) {
                SwanAppActionBar.this.cMg.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.cMb.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.cMc.setEnabled(z);
        this.cMe.setEnabled(z);
        this.cMf.setEnabled(z);
    }
}
