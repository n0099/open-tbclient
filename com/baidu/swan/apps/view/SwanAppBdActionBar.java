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
    private static final int[] aYb = {8, 0, 4};
    private a.InterfaceC0159a aMP;
    private TextView aXA;
    private int aXB;
    private View aXC;
    private TextView aXD;
    private ProgressBar aXE;
    private ImageView aXF;
    private int aXG;
    private ImageView aXH;
    private View aXI;
    private ImageView aXJ;
    private int aXK;
    private View aXL;
    private View aXM;
    private View aXN;
    private String aXO;
    private int aXP;
    private float aXQ;
    private int aXR;
    private float aXS;
    private float aXT;
    private float aXU;
    private int aXV;
    private int aXW;
    private int aXX;
    private int aXY;
    private Drawable aXZ;
    private View aXm;
    private ImageView aXn;
    private View aXo;
    private ImageView aXp;
    private int aXq;
    private String aXr;
    private String aXs;
    private int aXt;
    private float aXu;
    private float aXv;
    private float aXw;
    private int aXx;
    private TextView aXy;
    private TextView aXz;
    private Drawable aYa;
    private com.baidu.swan.apps.res.ui.a aYc;
    private TextView aYd;
    private b.a aYe;
    private boolean aYf;
    private View aYg;
    private View aYh;
    private b aYi;
    private int aYj;
    private View aYk;
    private TextView aYl;
    private String aYm;
    private int aYn;
    private ProgressBar aYo;
    private boolean aYp;
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
        this.aXP = -1;
        this.aXQ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYn = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXP = -1;
        this.aXQ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYn = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXP = -1;
        this.aXQ = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYn = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.j.SwanAppBdActionBar, 0, 0);
            try {
                this.aXr = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_titleText);
                this.aXt = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXu = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.aXv = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.aXw = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.aYj = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aYm = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXW = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aXO = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXZ = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.aXV = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.aYa = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.aXX = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.aXY = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.aXP = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(a.c.aiapps_action_bar_operation_btn_txt_color));
                this.aXQ = obtainStyledAttributes.getDimension(a.j.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.aXR = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXS = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.aXT = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.aXU = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.aXB = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.aXm.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.aYe = aVar;
        if (this.aYc != null) {
            this.aYc.a(this.aYe);
        }
    }

    public boolean MD() {
        if (this.aYc != null) {
            int[] iArr = new int[2];
            this.aXm.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.aXm.getHeight() + getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_top_padding);
            this.aYc.getView().getWidth();
            this.aYc.m(0, (x.getDisplayWidth(getContext()) - dimensionPixelSize) - this.aYc.getView().getWidth(), height);
            this.aYc.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.aYo = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.aXy = (TextView) findViewById(a.f.left_first_view);
        this.aXy.setCompoundDrawables(et(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.aXy.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.aXz = (TextView) findViewById(a.f.title_text_center);
        this.aXA = (TextView) findViewById(a.f.subtitle_text_center);
        this.aXA.setTextColor(getResources().getColor(a.c.aiapps_white_text));
        this.aYd = (TextView) findViewById(a.f.left_second_view);
        this.aYd.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        if (this.aXu != -1.0f && this.aXv != -1.0f && this.aXw != -1.0f) {
            this.aXy.setShadowLayer(this.aXw, this.aXu, this.aXv, this.aXt);
        }
        this.aYk = findViewById(a.f.titlebar_right_txtzone2);
        this.aYk.setVisibility(aYb[this.aYj]);
        this.aYl = (TextView) findViewById(a.f.titlebar_right_txtzone2_txt);
        if (this.aYm != null) {
            this.aYl.setText(this.aYm);
        }
        if (this.aYn != -1) {
            this.aYl.setTextColor(this.aYn);
        } else {
            this.aYl.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXC = findViewById(a.f.titlebar_right_txtzone1);
        this.aXC.setVisibility(aYb[this.aXW]);
        this.aXD = (TextView) findViewById(a.f.titlebar_right_txtzone1_txt);
        if (this.aXO != null) {
            this.aXD.setText(this.aXO);
        }
        if (this.aXP != -1) {
            this.aXD.setTextColor(this.aXP);
        } else {
            this.aXD.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXE = (ProgressBar) findViewById(a.f.titlebar_right_txtzone1_progress);
        this.aXF = (ImageView) findViewById(a.f.titlebar_right_imgzone2_img);
        this.aXH = (ImageView) findViewById(a.f.new_tip_img);
        this.aXI = findViewById(a.f.titlebar_right_imgzone2);
        this.aXI.setVisibility(aYb[this.aXY]);
        this.aXJ = (ImageView) findViewById(a.f.titlebar_right_imgzone1_img);
        this.aXL = findViewById(a.f.titlebar_right_imgzone1);
        this.aXL.setVisibility(aYb[this.aXX]);
        this.aXN = findViewById(a.f.titlebar_right_zones);
        this.aXN.setVisibility(aYb[this.aXV]);
        this.aYg = findViewById(a.f.titlebar_left_zones);
        this.aXM = findViewById(a.f.titlebar_right_imgzone2_notify);
        this.aYh = findViewById(a.f.titlebar_center_zones);
        this.aXm = findViewById(a.f.titlebar_right_menu);
        this.aXn = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.aXo = findViewById(a.f.titlebar_right_menu_line);
        this.aXp = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.aXr);
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
        this.aXz.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.aXB = i;
        setTitle(this.aXr);
    }

    public void setSubTitle(String str) {
        this.aXs = str;
        if (TextUtils.isEmpty(this.aXs)) {
            this.aXA.setVisibility(8);
        } else {
            this.aXA.setVisibility(0);
        }
        if (1 == this.aXB) {
            this.aXA.setText(str);
        } else if (this.aXB == 0) {
            this.aXA.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.aXs;
    }

    public void setSubTitleColor(int i) {
        this.aXA.setTextColor(i);
    }

    public void setTitle(String str) {
        this.aXr = str;
        if (1 == this.aXB) {
            this.aXz.setText(str);
            if (this.aYf) {
                hR(str);
            } else {
                this.aXy.setText((CharSequence) null);
            }
        } else if (this.aXB == 0) {
            this.aXy.setText(str);
            this.aXz.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.aXr;
    }

    public void setTitleColor(int i) {
        this.aXx = i;
        this.aXz.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.aXy.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aXy.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.aXy.setShadowLayer(f, f2, f3, i);
        this.aXz.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.aXD.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.aXD.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.aXD != null) {
            this.aXD.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.aXD.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.aXD.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.aXD.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.aXC.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.aXN.setVisibility(0);
        }
        this.aXC.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.aXC.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.aXy.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXC.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.aXC.setClickable(z);
        this.aXD.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aXI.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXI.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.aXI.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXF.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.aXF.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXL.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXL.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.aXL.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.aXL.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.aXL.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.aXK = i;
        this.aXJ.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXJ.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXF.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.aXF.setEnabled(z);
        this.aXI.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.aXG = i;
        this.aXF.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.aXZ = drawable;
        this.aXF.setImageDrawable(this.aXZ);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXF.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.aXF.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.aXI.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.aXL.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.aXM.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.aXE.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.aXM.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aXy.setCompoundDrawables(drawable, null, null, null);
        this.aXy.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aXy.setCompoundDrawables(drawable, null, null, null);
        this.aXy.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.aXy.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.aXy.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.aXy.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.aXC.setBackground(getResources().getDrawable(i));
        this.aYk.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.aXC.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.aXC.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.aXy.setBackground(getResources().getDrawable(i));
        this.aXL.setBackground(getResources().getDrawable(i));
        this.aXI.setBackground(getResources().getDrawable(i));
        this.aYd.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.aXK = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.aYa = drawable;
        this.aXJ.setImageDrawable(this.aYa);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.aYd.getVisibility() != i) {
            this.aYd.setVisibility(i);
            hR(this.aXr);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.aYd.getVisibility() == 0) {
            this.aYd.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.aXy != null) {
            this.aXy.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.aYd.getVisibility() == 0) {
            this.aYd.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.aYd.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aYd.setCompoundDrawables(drawable, null, null, null);
        this.aYd.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aYd.setCompoundDrawables(drawable, null, null, null);
        this.aYd.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.aYd.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.aYf = z;
    }

    public void setLeftTitle(String str) {
        this.aXy.setText(str);
    }

    private void hR(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.aXq = i;
        this.aXn.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.aXp.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.aXo.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.aXm.setBackgroundResource(i);
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
        this.aYi = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0159a interfaceC0159a) {
        this.aMP = interfaceC0159a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.aYp;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.aYi != null) {
                SwanAppBdActionBar.this.aYi.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.aXy != null) {
            if (z) {
                this.aXy.setVisibility(0);
            } else {
                this.aXy.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.aXp.setVisibility(0);
            this.aXo.setVisibility(0);
            return;
        }
        this.aXp.setVisibility(8);
        this.aXo.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.aXm.getLayoutParams()).setMargins(0, 0, x.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.aXC.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.aXN.setVisibility(0);
        }
        this.aYk.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.aYk.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aYk.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.aYl.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.aXH.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.aYg.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.aXN.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.aYh.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.aXm.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.aXn.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.aXp.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.aXx;
    }

    public int getRightMenuImageViewSrcId() {
        return this.aXq;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.aXK;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.aXG;
    }

    public TextView getTitleViewCenter() {
        return this.aXz;
    }

    private Drawable et(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void cs(boolean z) {
        if (this.aYo != null) {
            if (z && this.aYo.getVisibility() == 8) {
                this.aYo.setVisibility(0);
            } else if (!z && this.aYo.getVisibility() == 0) {
                this.aYo.setVisibility(8);
            }
        }
    }

    public void setActionBarCustom(boolean z) {
        this.aYp = z;
        int i = this.aYp ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
