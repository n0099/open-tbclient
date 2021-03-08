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
import androidx.core.view.ViewCompat;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes8.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View dSK;
    private TextView dSL;
    private TextView dSM;
    private View dSN;
    private ProgressBar dSO;
    private TextView dSP;
    private int dSQ;
    private float dSR;
    private float dSS;
    private float dST;
    private View dSU;
    private ImageView dSV;
    private ImageView dSW;
    private View dSX;
    private ImageView dSY;
    private b dSZ;
    private boolean dTa;
    private String mTitle;

    /* loaded from: classes8.dex */
    public interface b {
        void ax(View view);
    }

    public SwanAppActionBar(Context context) {
        super(context);
        init();
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
        init();
    }

    public SwanAppActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.j.SwanAppActionBar, 0, 0);
            try {
                this.mTitle = obtainStyledAttributes.getString(a.j.SwanAppActionBar_titleText);
                this.dSQ = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.dSR = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.dSS = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.dST = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.dSK = findViewById(a.f.titlebar_left_zone);
        this.dSL = (TextView) findViewById(a.f.left_first_view);
        this.dSL.setCompoundDrawables(ku(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dSL.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.dSM = (TextView) findViewById(a.f.left_second_view);
        this.dSN = findViewById(a.f.titlebar_center_zone);
        this.dSO = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.dSP = (TextView) findViewById(a.f.title_text_center);
        if (this.dSR != -1.0f && this.dSS != -1.0f && this.dST != -1.0f) {
            this.dSL.setShadowLayer(this.dST, this.dSR, this.dSS, this.dSQ);
        }
        this.dSU = findViewById(a.f.titlebar_right_menu);
        this.dSV = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.dSW = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.dSX = findViewById(a.f.titlebar_right_menu_line);
        this.dSY = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.dSK.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dSL != null) {
            this.dSL.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dSL.setCompoundDrawables(drawable, null, null, null);
        this.dSL.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dSL.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.dSM.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dSM.setCompoundDrawables(drawable, null, null, null);
        this.dSM.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.dSN.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.dSP;
    }

    public View getRightMenu() {
        return this.dSU;
    }

    public void hH(boolean z) {
        if (this.dSO != null) {
            if (z && this.dSO.getVisibility() == 8) {
                this.dSO.setVisibility(0);
            } else if (!z && this.dSO.getVisibility() == 0) {
                this.dSO.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.dSP.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.dSP.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.dSU.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dSY.setVisibility(0);
            this.dSX.setVisibility(0);
            return;
        }
        this.dSY.setVisibility(8);
        this.dSX.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dSU.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.dSW.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.dSV.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dSY.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.dSX.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.dSU.setBackgroundResource(i);
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

    private Drawable ku(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dTa = z;
        int i = this.dTa ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dSL.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.dSM.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dSV.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dSY.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dSZ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.dTa;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dSZ != null) {
                SwanAppActionBar.this.dSZ.ax(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.dSU.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.dSV.setEnabled(z);
        this.dSX.setEnabled(z);
        this.dSY.setEnabled(z);
    }
}
