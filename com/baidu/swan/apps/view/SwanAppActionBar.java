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
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class SwanAppActionBar extends RelativeLayout {
    private float bbA;
    private float bbB;
    private View bbC;
    private ImageView bbD;
    private View bbE;
    private ImageView bbF;
    private b bbG;
    private boolean bbH;
    private View bbs;
    private TextView bbt;
    private TextView bbu;
    private View bbv;
    private ProgressBar bbw;
    private TextView bbx;
    private int bby;
    private float bbz;
    private String mTitle;

    /* loaded from: classes2.dex */
    public interface b {
        void U(View view);
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
                this.bby = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.bbz = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.bbA = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.bbB = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.bbs = findViewById(a.f.titlebar_left_zone);
        this.bbt = (TextView) findViewById(a.f.left_first_view);
        this.bbt.setCompoundDrawables(eI(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.bbt.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.bbu = (TextView) findViewById(a.f.left_second_view);
        this.bbv = findViewById(a.f.titlebar_center_zone);
        this.bbw = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.bbx = (TextView) findViewById(a.f.title_text_center);
        if (this.bbz != -1.0f && this.bbA != -1.0f && this.bbB != -1.0f) {
            this.bbt.setShadowLayer(this.bbB, this.bbz, this.bbA, this.bby);
        }
        this.bbC = findViewById(a.f.titlebar_right_menu);
        this.bbD = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.bbE = findViewById(a.f.titlebar_right_menu_line);
        this.bbF = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.bbs.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.bbt != null) {
            this.bbt.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bbt.setCompoundDrawables(drawable, null, null, null);
        this.bbt.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.bbt.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.bbu.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bbu.setCompoundDrawables(drawable, null, null, null);
        this.bbu.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.bbv.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.bbx;
    }

    public View getRightMenu() {
        return this.bbC;
    }

    public void cK(boolean z) {
        if (this.bbw != null) {
            if (z && this.bbw.getVisibility() == 8) {
                this.bbw.setVisibility(0);
            } else if (!z && this.bbw.getVisibility() == 0) {
                this.bbw.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.bbx.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.bbx.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.bbC.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bbF.setVisibility(0);
            this.bbE.setVisibility(0);
            return;
        }
        this.bbF.setVisibility(8);
        this.bbE.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.bbC.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightMenuImageSrc(int i) {
        this.bbD.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bbF.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.bbE.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.bbC.setBackgroundResource(i);
    }

    public boolean q(@ColorInt int i, boolean z) {
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

    private Drawable eI(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.bbH = z;
        int i = this.bbH ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.bbt.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.bbu.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.bbD.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bbF.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.bbG = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.bbH;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.bbG != null) {
                SwanAppActionBar.this.bbG.U(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }
}
