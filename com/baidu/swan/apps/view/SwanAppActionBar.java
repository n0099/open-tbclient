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
/* loaded from: classes8.dex */
public class SwanAppActionBar extends RelativeLayout {
    private View ddd;
    private TextView dde;
    private TextView ddf;
    private View ddg;
    private ProgressBar ddh;
    private TextView ddi;
    private int ddj;
    private float ddk;
    private float ddl;
    private float ddm;
    private View ddn;
    private ImageView ddo;
    private ImageView ddp;
    private View ddq;
    private ImageView ddr;
    private b dds;
    private boolean ddt;
    private String mTitle;

    /* loaded from: classes8.dex */
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
                this.ddj = obtainStyledAttributes.getColor(a.j.SwanAppActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.ddk = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDx, -1.0f);
                this.ddl = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowDy, -1.0f);
                this.ddm = obtainStyledAttributes.getFloat(a.j.SwanAppActionBar_titleTxtShadowRadius, -1.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.ddd = findViewById(a.f.titlebar_left_zone);
        this.dde = (TextView) findViewById(a.f.left_first_view);
        this.dde.setCompoundDrawables(getDrawableFromId(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.dde.setTextColor(getResources().getColorStateList(a.c.swan_app_action_bar_operation_btn_selector));
        this.ddf = (TextView) findViewById(a.f.left_second_view);
        this.ddg = findViewById(a.f.titlebar_center_zone);
        this.ddh = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.ddi = (TextView) findViewById(a.f.title_text_center);
        if (this.ddk != -1.0f && this.ddl != -1.0f && this.ddm != -1.0f) {
            this.dde.setShadowLayer(this.ddm, this.ddk, this.ddl, this.ddj);
        }
        this.ddn = findViewById(a.f.titlebar_right_menu);
        this.ddo = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.ddp = (ImageView) findViewById(a.f.titlebar_right_menu_red_dot);
        this.ddq = findViewById(a.f.titlebar_right_menu_line);
        this.ddr = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
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
        this.ddd.setVisibility(i);
    }

    public void setLeftBackViewVisibility(boolean z) {
        if (this.dde != null) {
            this.dde.setVisibility(z ? 0 : 8);
        }
    }

    public void setLeftBackViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.dde.setCompoundDrawables(drawable, null, null, null);
        this.dde.setSelected(false);
    }

    public void setLeftBackViewMinWidth(int i) {
        this.dde.setMinimumWidth(i);
    }

    public void setLeftHomeViewVisibility(int i) {
        this.ddf.setVisibility(i);
    }

    public void setLeftHomeViewSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.ddf.setCompoundDrawables(drawable, null, null, null);
        this.ddf.setSelected(false);
    }

    public void setCenterZoneVisibility(int i) {
        this.ddg.setVisibility(i);
    }

    public TextView getCenterTitleView() {
        return this.ddi;
    }

    public View getRightMenu() {
        return this.ddn;
    }

    public void gi(boolean z) {
        if (this.ddh != null) {
            if (z && this.ddh.getVisibility() == 8) {
                this.ddh.setVisibility(0);
            } else if (!z && this.ddh.getVisibility() == 0) {
                this.ddh.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
        this.ddi.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleColor(int i) {
        this.ddi.setTextColor(getResources().getColor(i));
    }

    public void setRightZoneVisibility(boolean z) {
        this.ddn.setVisibility(z ? 0 : 8);
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.ddr.setVisibility(0);
            this.ddq.setVisibility(0);
            return;
        }
        this.ddr.setVisibility(8);
        this.ddq.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.ddn.getLayoutParams()).setMargins(0, 0, ah.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightRedDotVisibility(boolean z) {
        this.ddp.setVisibility(z ? 0 : 8);
    }

    public void setRightMenuImageSrc(int i) {
        this.ddo.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.ddr.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightLineSrc(int i) {
        this.ddq.setBackgroundResource(i);
    }

    public void setRightZoneBgSrc(int i) {
        this.ddn.setBackgroundResource(i);
    }

    public boolean C(@ColorInt int i, boolean z) {
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
        this.ddt = z;
        int i = this.ddt ? 8 : 0;
        setLeftZoneVisibility(i);
        setCenterZoneVisibility(i);
    }

    public void setLeftBackViewClickListener(View.OnClickListener onClickListener) {
        this.dde.setOnClickListener(onClickListener);
    }

    public void setLeftHomeViewClickListener(View.OnClickListener onClickListener) {
        this.ddf.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.ddo.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.ddr.setOnClickListener(onClickListener);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.dds = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppActionBar.this.ddt;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppActionBar.this.dds != null) {
                SwanAppActionBar.this.dds.onDoubleClick(SwanAppActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setRightMenuAlpha(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.ddn.setAlpha(f);
        }
    }

    public void setRightMenuEnable(boolean z) {
        this.ddo.setEnabled(z);
        this.ddq.setEnabled(z);
        this.ddr.setEnabled(z);
    }
}
