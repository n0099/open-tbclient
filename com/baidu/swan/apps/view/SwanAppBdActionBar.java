package com.baidu.swan.apps.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
/* loaded from: classes2.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] aXY = {8, 0, 4};
    private a.InterfaceC0159a aMM;
    private TextView aXA;
    private ProgressBar aXB;
    private ImageView aXC;
    private int aXD;
    private ImageView aXE;
    private View aXF;
    private ImageView aXG;
    private int aXH;
    private View aXI;
    private View aXJ;
    private View aXK;
    private String aXL;
    private int aXM;
    private float aXN;
    private int aXO;
    private float aXP;
    private float aXQ;
    private float aXR;
    private int aXS;
    private int aXT;
    private int aXU;
    private int aXV;
    private Drawable aXW;
    private Drawable aXX;
    private com.baidu.swan.apps.res.ui.a aXZ;
    private View aXj;
    private ImageView aXk;
    private View aXl;
    private ImageView aXm;
    private int aXn;
    private String aXo;
    private String aXp;
    private int aXq;
    private float aXr;
    private float aXs;
    private float aXt;
    private int aXu;
    private TextView aXv;
    private TextView aXw;
    private TextView aXx;
    private int aXy;
    private View aXz;
    private TextView aYa;
    private b.a aYb;
    private boolean aYc;
    private View aYd;
    private View aYe;
    private b aYf;
    private int aYg;
    private View aYh;
    private TextView aYi;
    private String aYj;
    private int aYk;
    private ProgressBar aYl;
    private boolean aYm;
    private View.OnClickListener mOnClickListener;

    /* loaded from: classes2.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes2.dex */
    public interface b {
        void S(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.aXM = -1;
        this.aXN = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYk = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXM = -1;
        this.aXN = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYk = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXM = -1;
        this.aXN = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYk = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.j.SwanAppBdActionBar, 0, 0);
            try {
                this.aXo = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_titleText);
                this.aXq = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXr = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.aXs = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.aXt = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.aYg = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aYj = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXT = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aXL = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXW = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.aXS = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.aXX = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.aXU = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.aXV = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.aXM = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(a.c.aiapps_action_bar_operation_btn_txt_color));
                this.aXN = obtainStyledAttributes.getDimension(a.j.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.aXO = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXP = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.aXQ = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.aXR = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.aXy = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.aXj.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.aYb = aVar;
        if (this.aXZ != null) {
            this.aXZ.a(this.aYb);
        }
    }

    public boolean MF() {
        if (this.aXZ != null) {
            int[] iArr = new int[2];
            this.aXj.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.aXj.getHeight() + getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_top_padding);
            this.aXZ.getView().getWidth();
            this.aXZ.m(0, (x.getDisplayWidth(getContext()) - dimensionPixelSize) - this.aXZ.getView().getWidth(), height);
            this.aXZ.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.aYl = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.aXv = (TextView) findViewById(a.f.left_first_view);
        this.aXv.setCompoundDrawables(eu(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.aXv.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.aXw = (TextView) findViewById(a.f.title_text_center);
        this.aXx = (TextView) findViewById(a.f.subtitle_text_center);
        this.aXx.setTextColor(getResources().getColor(a.c.aiapps_white_text));
        this.aYa = (TextView) findViewById(a.f.left_second_view);
        this.aYa.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        if (this.aXr != -1.0f && this.aXs != -1.0f && this.aXt != -1.0f) {
            this.aXv.setShadowLayer(this.aXt, this.aXr, this.aXs, this.aXq);
        }
        this.aYh = findViewById(a.f.titlebar_right_txtzone2);
        this.aYh.setVisibility(aXY[this.aYg]);
        this.aYi = (TextView) findViewById(a.f.titlebar_right_txtzone2_txt);
        if (this.aYj != null) {
            this.aYi.setText(this.aYj);
        }
        if (this.aYk != -1) {
            this.aYi.setTextColor(this.aYk);
        } else {
            this.aYi.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXz = findViewById(a.f.titlebar_right_txtzone1);
        this.aXz.setVisibility(aXY[this.aXT]);
        this.aXA = (TextView) findViewById(a.f.titlebar_right_txtzone1_txt);
        if (this.aXL != null) {
            this.aXA.setText(this.aXL);
        }
        if (this.aXM != -1) {
            this.aXA.setTextColor(this.aXM);
        } else {
            this.aXA.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXB = (ProgressBar) findViewById(a.f.titlebar_right_txtzone1_progress);
        this.aXC = (ImageView) findViewById(a.f.titlebar_right_imgzone2_img);
        this.aXE = (ImageView) findViewById(a.f.new_tip_img);
        this.aXF = findViewById(a.f.titlebar_right_imgzone2);
        this.aXF.setVisibility(aXY[this.aXV]);
        this.aXG = (ImageView) findViewById(a.f.titlebar_right_imgzone1_img);
        this.aXI = findViewById(a.f.titlebar_right_imgzone1);
        this.aXI.setVisibility(aXY[this.aXU]);
        this.aXK = findViewById(a.f.titlebar_right_zones);
        this.aXK.setVisibility(aXY[this.aXS]);
        this.aYd = findViewById(a.f.titlebar_left_zones);
        this.aXJ = findViewById(a.f.titlebar_right_imgzone2_notify);
        this.aYe = findViewById(a.f.titlebar_center_zones);
        this.aXj = findViewById(a.f.titlebar_right_menu);
        this.aXk = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.aXl = findViewById(a.f.titlebar_right_menu_line);
        this.aXm = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.aXo);
        setTitleColor(a.c.aiapps_black_text);
        setRightMenuImageSrc(a.e.aiapps_action_bar_menu_normal_selector);
        setRightImgZone2Src(a.e.aiapps_action_bar_add_2_selector);
        setRightImgZone1Src(a.e.aiapps_action_bar_add_selector);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new a());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setTitleBarTitleSize(float f) {
        this.aXw.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.aXy = i;
        setTitle(this.aXo);
    }

    public void setSubTitle(String str) {
        this.aXp = str;
        if (TextUtils.isEmpty(this.aXp)) {
            this.aXx.setVisibility(8);
        } else {
            this.aXx.setVisibility(0);
        }
        if (1 == this.aXy) {
            this.aXx.setText(str);
        } else if (this.aXy == 0) {
            this.aXx.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.aXp;
    }

    public void setSubTitleColor(int i) {
        this.aXx.setTextColor(i);
    }

    public void setTitle(String str) {
        this.aXo = str;
        if (1 == this.aXy) {
            this.aXw.setText(str);
            if (this.aYc) {
                hQ(str);
            } else {
                this.aXv.setText((CharSequence) null);
            }
        } else if (this.aXy == 0) {
            this.aXv.setText(str);
            this.aXw.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.aXo;
    }

    public void setTitleColor(int i) {
        this.aXu = i;
        this.aXw.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.aXv.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aXv.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.aXv.setShadowLayer(f, f2, f3, i);
        this.aXw.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.aXA.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.aXA.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.aXA != null) {
            this.aXA.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.aXA.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.aXA.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.aXA.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.aXz.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.aXK.setVisibility(0);
        }
        this.aXz.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.aXz.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.aXv.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXz.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.aXz.setClickable(z);
        this.aXA.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aXF.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXF.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.aXF.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXC.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.aXC.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXI.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXI.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.aXI.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.aXI.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.aXI.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.aXH = i;
        this.aXG.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXG.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXC.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.aXC.setEnabled(z);
        this.aXF.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.aXD = i;
        this.aXC.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.aXW = drawable;
        this.aXC.setImageDrawable(this.aXW);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXC.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.aXC.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.aXF.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.aXI.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.aXJ.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.aXB.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.aXJ.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aXv.setCompoundDrawables(drawable, null, null, null);
        this.aXv.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aXv.setCompoundDrawables(drawable, null, null, null);
        this.aXv.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.aXv.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.aXv.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.aXv.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.aXz.setBackground(getResources().getDrawable(i));
        this.aYh.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.aXz.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.aXz.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.aXv.setBackground(getResources().getDrawable(i));
        this.aXI.setBackground(getResources().getDrawable(i));
        this.aXF.setBackground(getResources().getDrawable(i));
        this.aYa.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.aXH = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.aXX = drawable;
        this.aXG.setImageDrawable(this.aXX);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.aYa.getVisibility() != i) {
            this.aYa.setVisibility(i);
            hQ(this.aXo);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.aYa.getVisibility() == 0) {
            this.aYa.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.aXv != null) {
            this.aXv.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.aYa.getVisibility() == 0) {
            this.aYa.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.aYa.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aYa.setCompoundDrawables(drawable, null, null, null);
        this.aYa.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aYa.setCompoundDrawables(drawable, null, null, null);
        this.aYa.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.aYa.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.aYc = z;
    }

    public void setLeftTitle(String str) {
        this.aXv.setText(str);
    }

    private void hQ(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.aXn = i;
        this.aXk.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.aXm.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.aXl.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.aXj.setBackgroundResource(i);
    }

    public boolean m(@ColorInt int i, boolean z) {
        if (i == -1) {
            setTitleColor(a.c.aiapps_white_text);
            setLeftZoneImageSrc(a.e.aiapps_action_bar_back_white_selector);
            setLeftSecondViewImageSrc(a.e.aiapps_action_bar_home_white_selector);
            setRightMenuImageSrc(z ? a.e.aiapps_action_bar_single_menu_white_selector : a.e.aiapps_action_bar_menu_white_selector);
            setRightExitImageSrc(a.e.aiapps_action_bar_exit_white_selector);
            setRightMenuLineSrc(a.c.aiapps_action_bar_menu_line_white);
            setRightMenuBgSrc(z ? a.c.aiapps_transparent : a.e.aiapps_action_bar_right_menu_bg_solid);
        } else if (i == -16777216) {
            setTitleColor(a.c.aiapps_black_text);
            setLeftZoneImageSrc(a.e.aiapps_action_bar_back_black_selector);
            setLeftSecondViewImageSrc(a.e.aiapps_action_bar_home_black_selector);
            setRightMenuImageSrc(z ? a.e.aiapps_action_bar_single_menu_black_selector : a.e.aiapps_action_bar_menu_black_selector);
            setRightExitImageSrc(a.e.aiapps_action_bar_exit_black_selector);
            setRightMenuLineSrc(a.c.aiapps_action_bar_menu_line_color);
            setRightMenuBgSrc(z ? a.c.aiapps_transparent : a.e.aiapps_action_bar_right_menu_bg);
        } else {
            setTitleColor(a.c.aiapps_white_text);
            setLeftZoneImageSrc(a.e.aiapps_action_bar_back_white_selector);
            setLeftSecondViewImageSrc(a.e.aiapps_action_bar_home_white_selector);
            setRightMenuImageSrc(z ? a.e.aiapps_action_bar_single_menu_white_selector : a.e.aiapps_action_bar_menu_white_selector);
            setRightExitImageSrc(a.e.aiapps_action_bar_exit_white_selector);
            setRightMenuLineSrc(a.c.aiapps_action_bar_menu_line_white);
            setRightMenuBgSrc(z ? a.c.aiapps_transparent : a.e.aiapps_action_bar_right_menu_bg_solid);
            return false;
        }
        return true;
    }

    public void setTemplate(ActionbarTemplate actionbarTemplate) {
        if (actionbarTemplate != null) {
            switch (actionbarTemplate) {
                case WHITE_TITLE_TEMPLATE:
                    setTitleColor(a.c.aiapps_white_text);
                    setRightMenuImageSrc(a.e.aiapps_action_bar_menu_normal_selector);
                    return;
                case BALCK_TITLE_TEMPLATE:
                    setTitleColor(a.c.aiapps_black_text);
                    setRightMenuImageSrc(a.e.aiapps_action_bar_black_menu_normal_selector);
                    return;
                default:
                    return;
            }
        }
    }

    public void setOnDoubleClickListener(b bVar) {
        this.aYf = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0159a interfaceC0159a) {
        this.aMM = interfaceC0159a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.aYm;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.aYf != null) {
                SwanAppBdActionBar.this.aYf.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.aXv != null) {
            if (z) {
                this.aXv.setVisibility(0);
            } else {
                this.aXv.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.aXm.setVisibility(0);
            this.aXl.setVisibility(0);
            return;
        }
        this.aXm.setVisibility(8);
        this.aXl.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.aXj.getLayoutParams()).setMargins(0, 0, x.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.aXz.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.aXK.setVisibility(0);
        }
        this.aYh.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.aYh.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aYh.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.aYi.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.aXE.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.aYd.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.aXK.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.aYe.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.aXj.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.aXk.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.aXm.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.aXu;
    }

    public int getRightMenuImageViewSrcId() {
        return this.aXn;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.aXH;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.aXD;
    }

    public TextView getTitleViewCenter() {
        return this.aXw;
    }

    private Drawable eu(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void cs(boolean z) {
        if (this.aYl != null) {
            if (z && this.aYl.getVisibility() == 8) {
                this.aYl.setVisibility(0);
            } else if (!z && this.aYl.getVisibility() == 0) {
                this.aYl.setVisibility(8);
            }
        }
    }

    public void setActionBarCustom(boolean z) {
        this.aYm = z;
        int i = this.aYm ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
