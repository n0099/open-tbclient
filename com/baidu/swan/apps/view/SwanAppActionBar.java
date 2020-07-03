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
    private View cQB;
    private TextView cQC;
    private TextView cQD;
    private View cQE;
    private ProgressBar cQF;
    private TextView cQG;
    private int cQH;
    private float cQI;
    private float cQJ;
    private float cQK;
    private View cQL;
    private ImageView cQM;
    private ImageView cQN;
    private View cQO;
    private ImageView cQP;
    private b cQQ;
    private boolean cQR;
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
                this.cQH = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.cQI = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.cQJ = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.cQK = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.cQB = findViewById(a.f.titlebar_left_zone);
        this.cQC = (TextView) findViewById(a.f.left_first_view);
        this.cQC.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.cQC.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.cQD = (TextView) findViewById(a.f.left_second_view);
        this.cQE = findViewById(a.f.titlebar_center_zone);
        this.cQF = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.cQG = (TextView) findViewById(a.f.title_text_center);
        if (this.cQI != -1.0f && this.cQJ != -1.0f && this.cQK != -1.0f) {
            this.cQC.setShadowLayer(this.cQK, this.cQI, this.cQJ, this.cQH);
        }
        this.cQL = findViewById(a.f.titlebar_right_menu);
        this.cQM = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.cQN = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.cQO = findViewById(a.f.titlebar_right_menu_line);
        this.cQP = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.cQB.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.cQC != null) {
            this.cQC.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cQC.setCompoundDrawables(drawable, null, null, null);
        this.cQC.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.cQC.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.cQD.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cQD.setCompoundDrawables(drawable, null, null, null);
        this.cQD.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.cQE.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.cQG;
    }

    public View getRightMenu() {
        return this.cQL;
    }

    public void fG(boolean z) {
        if (this.cQF != null) {
            if (z && this.cQF.getVisibility() == 8) {
                this.cQF.setVisibility(0);
            } else if (!z && this.cQF.getVisibility() == 0) {
                this.cQF.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.cQG.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.cQG.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.cQL.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.cQP.setVisibility(0);
            this.cQO.setVisibility(0);
            return;
        }
        this.cQP.setVisibility(8);
        this.cQO.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.cQL.getLayoutParams()).setMargins(0, 0, ag.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.cQN.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.cQM.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.cQP.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.cQO.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.cQL.setBackgroundResource(i);
    }

    public boolean B(@ColorInt int i, boolean z) {
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
        this.cQR = z;
        int i = this.cQR ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.cQC.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.cQD.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.cQM.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.cQP.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.cQQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.cQR;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.cQQ != null) {
                SwanAppActionBar.this.cQQ.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.cQL.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.cQM.setEnabled(z);
        this.cQO.setEnabled(z);
        this.cQP.setEnabled(z);
    }
}
