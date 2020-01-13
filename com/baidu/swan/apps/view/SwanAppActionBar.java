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
/* loaded from: classes10.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View bVA;
    private TextView bVB;
    private TextView bVC;
    private View bVD;
    private ProgressBar bVE;
    private TextView bVF;
    private int bVG;
    private float bVH;
    private float bVI;
    private float bVJ;
    private View bVK;
    private ImageView bVL;
    private ImageView bVM;
    private View bVN;
    private ImageView bVO;
    private b bVP;
    private boolean bVQ;
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
                this.bVG = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.bVH = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.bVI = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.bVJ = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.bVA = findViewById(a.f.titlebar_left_zone);
        this.bVB = (TextView) findViewById(a.f.left_first_view);
        this.bVB.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.bVB.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.bVC = (TextView) findViewById(a.f.left_second_view);
        this.bVD = findViewById(a.f.titlebar_center_zone);
        this.bVE = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.bVF = (TextView) findViewById(a.f.title_text_center);
        if (this.bVH != -1.0f && this.bVI != -1.0f && this.bVJ != -1.0f) {
            this.bVB.setShadowLayer(this.bVJ, this.bVH, this.bVI, this.bVG);
        }
        this.bVK = findViewById(a.f.titlebar_right_menu);
        this.bVL = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.bVM = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.bVN = findViewById(a.f.titlebar_right_menu_line);
        this.bVO = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.bVA.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.bVB != null) {
            this.bVB.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bVB.setCompoundDrawables(drawable, null, null, null);
        this.bVB.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.bVB.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.bVC.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bVC.setCompoundDrawables(drawable, null, null, null);
        this.bVC.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.bVD.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.bVF;
    }

    public View getRightMenu() {
        return this.bVK;
    }

    public void eb(boolean z) {
        if (this.bVE != null) {
            if (z && this.bVE.getVisibility() == 8) {
                this.bVE.setVisibility(0);
            } else if (!z && this.bVE.getVisibility() == 0) {
                this.bVE.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.bVF.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.bVF.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.bVK.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bVO.setVisibility(0);
            this.bVN.setVisibility(0);
            return;
        }
        this.bVO.setVisibility(8);
        this.bVN.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bVK.getLayoutParams()).setMargins(0, 0, af.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.bVM.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.bVL.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bVO.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.bVN.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.bVK.setBackgroundResource(i);
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
        this.bVQ = z;
        int i = this.bVQ ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.bVB.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.bVC.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bVL.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bVO.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.bVP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.bVQ;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.bVP != null) {
                SwanAppActionBar.this.bVP.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.bVK.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.bVL.setEnabled(z);
        this.bVN.setEnabled(z);
        this.bVO.setEnabled(z);
    }
}
