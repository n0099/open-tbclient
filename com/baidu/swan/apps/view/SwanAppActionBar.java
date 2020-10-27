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
/* loaded from: classes10.dex */
public class SwanAppActionBar extends RelativeLayout {
    private ImageView dAa;
    private ImageView dAb;
    private View dAc;
    private ImageView dAd;
    private b dAe;
    private boolean dAf;
    private View dzP;
    private TextView dzQ;
    private TextView dzR;
    private View dzS;
    private ProgressBar dzT;
    private TextView dzU;
    private int dzV;
    private float dzW;
    private float dzX;
    private float dzY;
    private View dzZ;
    private String mTitle;

    /* loaded from: classes10.dex */
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
                this.dzV = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.dzW = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.dzX = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.dzY = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.dzP = findViewById(a.f.titlebar_left_zone);
        this.dzQ = (TextView) findViewById(a.f.left_first_view);
        this.dzQ.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dzQ.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.dzR = (TextView) findViewById(a.f.left_second_view);
        this.dzS = findViewById(a.f.titlebar_center_zone);
        this.dzT = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.dzU = (TextView) findViewById(a.f.title_text_center);
        if (this.dzW != -1.0f && this.dzX != -1.0f && this.dzY != -1.0f) {
            this.dzQ.setShadowLayer(this.dzY, this.dzW, this.dzX, this.dzV);
        }
        this.dzZ = findViewById(a.f.titlebar_right_menu);
        this.dAa = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.dAb = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.dAc = findViewById(a.f.titlebar_right_menu_line);
        this.dAd = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.dzP.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dzQ != null) {
            this.dzQ.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dzQ.setCompoundDrawables(drawable, null, null, null);
        this.dzQ.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dzQ.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.dzR.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dzR.setCompoundDrawables(drawable, null, null, null);
        this.dzR.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.dzS.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.dzU;
    }

    public View getRightMenu() {
        return this.dzZ;
    }

    public void gQ(boolean z) {
        if (this.dzT != null) {
            if (z && this.dzT.getVisibility() == 8) {
                this.dzT.setVisibility(0);
            } else if (!z && this.dzT.getVisibility() == 0) {
                this.dzT.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.dzU.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.dzU.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.dzZ.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.dAd.setVisibility(0);
            this.dAc.setVisibility(0);
            return;
        }
        this.dAd.setVisibility(8);
        this.dAc.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.dzZ.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.dAb.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.dAa.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.dAd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.dAc.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.dzZ.setBackgroundResource(i);
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
        this.dAf = z;
        int i = this.dAf ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dzQ.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.dzR.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.dAa.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.dAd.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dAe = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.dAf;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dAe != null) {
                SwanAppActionBar.this.dAe.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.dzZ.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.dAa.setEnabled(z);
        this.dAc.setEnabled(z);
        this.dAd.setEnabled(z);
    }
}
