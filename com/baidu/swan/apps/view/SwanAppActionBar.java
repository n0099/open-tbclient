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
    private View btY;
    private TextView btZ;
    private TextView bua;
    private View bub;
    private ProgressBar buc;
    private TextView bud;
    private int bue;
    private float bug;
    private float buh;
    private float bui;
    private View buj;
    private ImageView buk;
    private View bul;
    private ImageView bum;
    private b bun;
    private boolean buo;
    private String mTitle;

    /* loaded from: classes2.dex */
    public interface b {
        void aa(View view);
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
                this.bue = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.bug = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.buh = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.bui = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.btY = findViewById(a.f.titlebar_left_zone);
        this.btZ = (TextView) findViewById(a.f.left_first_view);
        this.btZ.setCompoundDrawables(fD(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.btZ.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.bua = (TextView) findViewById(a.f.left_second_view);
        this.bub = findViewById(a.f.titlebar_center_zone);
        this.buc = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.bud = (TextView) findViewById(a.f.title_text_center);
        if (this.bug != -1.0f && this.buh != -1.0f && this.bui != -1.0f) {
            this.btZ.setShadowLayer(this.bui, this.bug, this.buh, this.bue);
        }
        this.buj = findViewById(a.f.titlebar_right_menu);
        this.buk = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.bul = findViewById(a.f.titlebar_right_menu_line);
        this.bum = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.btY.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.btZ != null) {
            this.btZ.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.btZ.setCompoundDrawables(drawable, null, null, null);
        this.btZ.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.btZ.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.bua.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.bua.setCompoundDrawables(drawable, null, null, null);
        this.bua.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.bub.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.bud;
    }

    public View getRightMenu() {
        return this.buj;
    }

    public void db(boolean z) {
        if (this.buc != null) {
            if (z && this.buc.getVisibility() == 8) {
                this.buc.setVisibility(0);
            } else if (!z && this.buc.getVisibility() == 0) {
                this.buc.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.bud.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.bud.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.buj.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.bum.setVisibility(0);
            this.bul.setVisibility(0);
            return;
        }
        this.bum.setVisibility(8);
        this.bul.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.buj.getLayoutParams()).setMargins(0, 0, z.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightMenuImageSrc(int i) {
        this.buk.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.bum.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.bul.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.buj.setBackgroundResource(i);
    }

    public boolean t(@ColorInt int i, boolean z) {
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

    private Drawable fD(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.buo = z;
        int i = this.buo ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.btZ.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.bua.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.buk.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.bum.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.bun = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.buo;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.bun != null) {
                SwanAppActionBar.this.bun.aa(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }
}
