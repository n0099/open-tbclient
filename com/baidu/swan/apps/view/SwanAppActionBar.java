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
    private View bZG;
    private TextView bZH;
    private TextView bZI;
    private View bZJ;
    private ProgressBar bZK;
    private TextView bZL;
    private int bZM;
    private float bZN;
    private float bZO;
    private float bZP;
    private View bZQ;
    private ImageView bZR;
    private ImageView bZS;
    private View bZT;
    private ImageView bZU;
    private b bZV;
    private boolean bZW;
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
                this.bZM = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.bZN = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.bZO = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.bZP = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.bZG = findViewById(a.f.titlebar_left_zone);
        this.bZH = (TextView) findViewById(a.f.left_first_view);
        this.bZH.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.bZH.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.bZI = (TextView) findViewById(a.f.left_second_view);
        this.bZJ = findViewById(a.f.titlebar_center_zone);
        this.bZK = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.bZL = (TextView) findViewById(a.f.title_text_center);
        if (this.bZN != -1.0f && this.bZO != -1.0f && this.bZP != -1.0f) {
            this.bZH.setShadowLayer(this.bZP, this.bZN, this.bZO, this.bZM);
        }
        this.bZQ = findViewById(a.f.titlebar_right_menu);
        this.bZR = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.bZS = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.bZT = findViewById(a.f.titlebar_right_menu_line);
        this.bZU = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.bZG.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.bZH != null) {
            this.bZH.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bZH.setCompoundDrawables(drawable, null, null, null);
        this.bZH.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.bZH.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.bZI.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bZI.setCompoundDrawables(drawable, null, null, null);
        this.bZI.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.bZJ.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.bZL;
    }

    public View getRightMenu() {
        return this.bZQ;
    }

    public void ei(boolean z) {
        if (this.bZK != null) {
            if (z && this.bZK.getVisibility() == 8) {
                this.bZK.setVisibility(0);
            } else if (!z && this.bZK.getVisibility() == 0) {
                this.bZK.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.bZL.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.bZL.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.bZQ.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bZU.setVisibility(0);
            this.bZT.setVisibility(0);
            return;
        }
        this.bZU.setVisibility(8);
        this.bZT.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bZQ.getLayoutParams()).setMargins(0, 0, af.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.bZS.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.bZR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bZU.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.bZT.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.bZQ.setBackgroundResource(i);
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
        this.bZW = z;
        int i = this.bZW ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.bZH.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.bZI.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bZR.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bZU.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.bZV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.bZW;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.bZV != null) {
                SwanAppActionBar.this.bZV.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.bZQ.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.bZR.setEnabled(z);
        this.bZT.setEnabled(z);
        this.bZU.setEnabled(z);
    }
}
