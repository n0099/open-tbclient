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
import com.baidu.swan.apps.aq.ai;
/* loaded from: classes7.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View cUc;
    private TextView cUd;
    private TextView cUe;
    private View cUf;
    private ProgressBar cUg;
    private TextView cUh;
    private int cUi;
    private float cUj;
    private float cUk;
    private float cUl;
    private View cUm;
    private ImageView cUn;
    private ImageView cUo;
    private View cUp;
    private ImageView cUq;
    private b cUr;
    private boolean cUs;
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
                this.cUi = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.cUj = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.cUk = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.cUl = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.cUc = findViewById(a.f.titlebar_left_zone);
        this.cUd = (TextView) findViewById(a.f.left_first_view);
        this.cUd.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.cUd.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.cUe = (TextView) findViewById(a.f.left_second_view);
        this.cUf = findViewById(a.f.titlebar_center_zone);
        this.cUg = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.cUh = (TextView) findViewById(a.f.title_text_center);
        if (this.cUj != -1.0f && this.cUk != -1.0f && this.cUl != -1.0f) {
            this.cUd.setShadowLayer(this.cUl, this.cUj, this.cUk, this.cUi);
        }
        this.cUm = findViewById(a.f.titlebar_right_menu);
        this.cUn = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.cUo = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.cUp = findViewById(a.f.titlebar_right_menu_line);
        this.cUq = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.cUc.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.cUd != null) {
            this.cUd.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cUd.setCompoundDrawables(drawable, null, null, null);
        this.cUd.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.cUd.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.cUe.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.cUe.setCompoundDrawables(drawable, null, null, null);
        this.cUe.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.cUf.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.cUh;
    }

    public View getRightMenu() {
        return this.cUm;
    }

    public void fP(boolean z) {
        if (this.cUg != null) {
            if (z && this.cUg.getVisibility() == 8) {
                this.cUg.setVisibility(0);
            } else if (!z && this.cUg.getVisibility() == 0) {
                this.cUg.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.cUh.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.cUh.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.cUm.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.cUq.setVisibility(0);
            this.cUp.setVisibility(0);
            return;
        }
        this.cUq.setVisibility(8);
        this.cUp.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.cUm.getLayoutParams()).setMargins(0, 0, ai.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.cUo.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.cUn.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.cUq.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.cUp.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.cUm.setBackgroundResource(i);
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
        this.cUs = z;
        int i = this.cUs ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.cUd.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.cUe.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.cUn.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.cUq.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.cUr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.cUs;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.cUr != null) {
                SwanAppActionBar.this.cUr.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.cUm.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.cUn.setEnabled(z);
        this.cUp.setEnabled(z);
        this.cUq.setEnabled(z);
    }
}
