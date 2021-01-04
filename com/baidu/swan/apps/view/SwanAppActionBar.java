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
/* loaded from: classes9.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View dTP;
    private TextView dTQ;
    private TextView dTR;
    private View dTS;
    private ProgressBar dTT;
    private TextView dTU;
    private int dTV;
    private float dTW;
    private float dTX;
    private float dTY;
    private View dTZ;
    private ImageView dUa;
    private ImageView dUb;
    private View dUc;
    private ImageView dUd;
    private b dUe;
    private boolean dUf;
    private String mTitle;

    /* loaded from: classes9.dex */
    public interface b {
        void aB(View view);
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
                this.dTV = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.dTW = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.dTX = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.dTY = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.dTP = findViewById(a.f.titlebar_left_zone);
        this.dTQ = (TextView) findViewById(a.f.left_first_view);
        this.dTQ.setCompoundDrawables(lW(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dTQ.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.dTR = (TextView) findViewById(a.f.left_second_view);
        this.dTS = findViewById(a.f.titlebar_center_zone);
        this.dTT = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.dTU = (TextView) findViewById(a.f.title_text_center);
        if (this.dTW != -1.0f && this.dTX != -1.0f && this.dTY != -1.0f) {
            this.dTQ.setShadowLayer(this.dTY, this.dTW, this.dTX, this.dTV);
        }
        this.dTZ = findViewById(a.f.titlebar_right_menu);
        this.dUa = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.dUb = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.dUc = findViewById(a.f.titlebar_right_menu_line);
        this.dUd = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.dTP.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dTQ != null) {
            this.dTQ.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dTQ.setCompoundDrawables(drawable, null, null, null);
        this.dTQ.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dTQ.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.dTR.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dTR.setCompoundDrawables(drawable, null, null, null);
        this.dTR.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.dTS.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.dTU;
    }

    public View getRightMenu() {
        return this.dTZ;
    }

    public void hJ(boolean z) {
        if (this.dTT != null) {
            if (z && this.dTT.getVisibility() == 8) {
                this.dTT.setVisibility(0);
            } else if (!z && this.dTT.getVisibility() == 0) {
                this.dTT.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.dTU.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.dTU.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.dTZ.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dUd.setVisibility(0);
            this.dUc.setVisibility(0);
            return;
        }
        this.dUd.setVisibility(8);
        this.dUc.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dTZ.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.dUb.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.dUa.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dUd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.dUc.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.dTZ.setBackgroundResource(i);
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

    private Drawable lW(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.dUf = z;
        int i = this.dUf ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dTQ.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.dTR.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dUa.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dUd.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dUe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.dUf;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dUe != null) {
                SwanAppActionBar.this.dUe.aB(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.dTZ.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.dUa.setEnabled(z);
        this.dUc.setEnabled(z);
        this.dUd.setEnabled(z);
    }
}
