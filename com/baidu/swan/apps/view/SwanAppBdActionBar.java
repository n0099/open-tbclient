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
    private static final int[] aYc = {8, 0, 4};
    private a.InterfaceC0159a aMQ;
    private TextView aXA;
    private TextView aXB;
    private int aXC;
    private View aXD;
    private TextView aXE;
    private ProgressBar aXF;
    private ImageView aXG;
    private int aXH;
    private ImageView aXI;
    private View aXJ;
    private ImageView aXK;
    private int aXL;
    private View aXM;
    private View aXN;
    private View aXO;
    private String aXP;
    private int aXQ;
    private float aXR;
    private int aXS;
    private float aXT;
    private float aXU;
    private float aXV;
    private int aXW;
    private int aXX;
    private int aXY;
    private int aXZ;
    private View aXn;
    private ImageView aXo;
    private View aXp;
    private ImageView aXq;
    private int aXr;
    private String aXs;
    private String aXt;
    private int aXu;
    private float aXv;
    private float aXw;
    private float aXx;
    private int aXy;
    private TextView aXz;
    private Drawable aYa;
    private Drawable aYb;
    private com.baidu.swan.apps.res.ui.a aYd;
    private TextView aYe;
    private b.a aYf;
    private boolean aYg;
    private View aYh;
    private View aYi;
    private b aYj;
    private int aYk;
    private View aYl;
    private TextView aYm;
    private String aYn;
    private int aYo;
    private ProgressBar aYp;
    private boolean aYq;
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
        this.aXQ = -1;
        this.aXR = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYo = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXQ = -1;
        this.aXR = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYo = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXQ = -1;
        this.aXR = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MD();
            }
        };
        this.aYo = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.j.SwanAppBdActionBar, 0, 0);
            try {
                this.aXs = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_titleText);
                this.aXu = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXv = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.aXw = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.aXx = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.aYk = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aYn = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXX = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aXP = obtainStyledAttributes.getString(a.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aYa = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.aXW = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.aYb = obtainStyledAttributes.getDrawable(a.j.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.aXY = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.aXZ = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.aXQ = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(a.c.aiapps_action_bar_operation_btn_txt_color));
                this.aXR = obtainStyledAttributes.getDimension(a.j.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.aXS = obtainStyledAttributes.getColor(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXT = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.aXU = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.aXV = obtainStyledAttributes.getFloat(a.j.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.aXC = obtainStyledAttributes.getInt(a.j.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.aXn.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.aYf = aVar;
        if (this.aYd != null) {
            this.aYd.a(this.aYf);
        }
    }

    public boolean MD() {
        if (this.aYd != null) {
            int[] iArr = new int[2];
            this.aXn.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.aXn.getHeight() + getContext().getResources().getDimensionPixelSize(a.d.aiapps_actionbar_menu_top_padding);
            this.aYd.getView().getWidth();
            this.aYd.m(0, (x.getDisplayWidth(getContext()) - dimensionPixelSize) - this.aYd.getView().getWidth(), height);
            this.aYd.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.aiapps_action_bar, this);
        this.aYp = (ProgressBar) findViewById(a.f.aiapps_nav_loading_progressbar);
        this.aXz = (TextView) findViewById(a.f.left_first_view);
        this.aXz.setCompoundDrawables(et(a.e.aiapps_action_bar_back_selector), null, null, null);
        this.aXz.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        this.aXA = (TextView) findViewById(a.f.title_text_center);
        this.aXB = (TextView) findViewById(a.f.subtitle_text_center);
        this.aXB.setTextColor(getResources().getColor(a.c.aiapps_white_text));
        this.aYe = (TextView) findViewById(a.f.left_second_view);
        this.aYe.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        if (this.aXv != -1.0f && this.aXw != -1.0f && this.aXx != -1.0f) {
            this.aXz.setShadowLayer(this.aXx, this.aXv, this.aXw, this.aXu);
        }
        this.aYl = findViewById(a.f.titlebar_right_txtzone2);
        this.aYl.setVisibility(aYc[this.aYk]);
        this.aYm = (TextView) findViewById(a.f.titlebar_right_txtzone2_txt);
        if (this.aYn != null) {
            this.aYm.setText(this.aYn);
        }
        if (this.aYo != -1) {
            this.aYm.setTextColor(this.aYo);
        } else {
            this.aYm.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXD = findViewById(a.f.titlebar_right_txtzone1);
        this.aXD.setVisibility(aYc[this.aXX]);
        this.aXE = (TextView) findViewById(a.f.titlebar_right_txtzone1_txt);
        if (this.aXP != null) {
            this.aXE.setText(this.aXP);
        }
        if (this.aXQ != -1) {
            this.aXE.setTextColor(this.aXQ);
        } else {
            this.aXE.setTextColor(getResources().getColorStateList(a.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXF = (ProgressBar) findViewById(a.f.titlebar_right_txtzone1_progress);
        this.aXG = (ImageView) findViewById(a.f.titlebar_right_imgzone2_img);
        this.aXI = (ImageView) findViewById(a.f.new_tip_img);
        this.aXJ = findViewById(a.f.titlebar_right_imgzone2);
        this.aXJ.setVisibility(aYc[this.aXZ]);
        this.aXK = (ImageView) findViewById(a.f.titlebar_right_imgzone1_img);
        this.aXM = findViewById(a.f.titlebar_right_imgzone1);
        this.aXM.setVisibility(aYc[this.aXY]);
        this.aXO = findViewById(a.f.titlebar_right_zones);
        this.aXO.setVisibility(aYc[this.aXW]);
        this.aYh = findViewById(a.f.titlebar_left_zones);
        this.aXN = findViewById(a.f.titlebar_right_imgzone2_notify);
        this.aYi = findViewById(a.f.titlebar_center_zones);
        this.aXn = findViewById(a.f.titlebar_right_menu);
        this.aXo = (ImageView) findViewById(a.f.titlebar_right_menu_img);
        this.aXp = findViewById(a.f.titlebar_right_menu_line);
        this.aXq = (ImageView) findViewById(a.f.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.aXs);
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
        this.aXA.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.aXC = i;
        setTitle(this.aXs);
    }

    public void setSubTitle(String str) {
        this.aXt = str;
        if (TextUtils.isEmpty(this.aXt)) {
            this.aXB.setVisibility(8);
        } else {
            this.aXB.setVisibility(0);
        }
        if (1 == this.aXC) {
            this.aXB.setText(str);
        } else if (this.aXC == 0) {
            this.aXB.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.aXt;
    }

    public void setSubTitleColor(int i) {
        this.aXB.setTextColor(i);
    }

    public void setTitle(String str) {
        this.aXs = str;
        if (1 == this.aXC) {
            this.aXA.setText(str);
            if (this.aYg) {
                hR(str);
            } else {
                this.aXz.setText((CharSequence) null);
            }
        } else if (this.aXC == 0) {
            this.aXz.setText(str);
            this.aXA.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.aXs;
    }

    public void setTitleColor(int i) {
        this.aXy = i;
        this.aXA.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.aXz.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aXz.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.aXz.setShadowLayer(f, f2, f3, i);
        this.aXA.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.aXE.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.aXE.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.aXE != null) {
            this.aXE.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.aXE.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.aXE.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.aXE.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.aXD.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.aXO.setVisibility(0);
        }
        this.aXD.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.aXD.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.aXz.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXD.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.aXD.setClickable(z);
        this.aXE.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aXJ.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXJ.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.aXJ.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXG.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.aXG.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXM.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.aXM.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.aXM.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.aXM.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.aXL = i;
        this.aXK.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXK.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXG.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.aXG.setEnabled(z);
        this.aXJ.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.aXH = i;
        this.aXG.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.aYa = drawable;
        this.aXG.setImageDrawable(this.aYa);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXG.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.aXG.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.aXJ.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.aXM.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.aXN.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.aXF.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.aXN.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aXz.setCompoundDrawables(drawable, null, null, null);
        this.aXz.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aXz.setCompoundDrawables(drawable, null, null, null);
        this.aXz.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.aXz.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.aXz.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.aXz.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.aXD.setBackground(getResources().getDrawable(i));
        this.aYl.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.aXD.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.aXD.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.aXz.setBackground(getResources().getDrawable(i));
        this.aXM.setBackground(getResources().getDrawable(i));
        this.aXJ.setBackground(getResources().getDrawable(i));
        this.aYe.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.aXL = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.aYb = drawable;
        this.aXK.setImageDrawable(this.aYb);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.aYe.getVisibility() != i) {
            this.aYe.setVisibility(i);
            hR(this.aXs);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.aYe.getVisibility() == 0) {
            this.aYe.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.aXz != null) {
            this.aXz.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.aYe.getVisibility() == 0) {
            this.aYe.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.aYe.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aYe.setCompoundDrawables(drawable, null, null, null);
        this.aYe.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aYe.setCompoundDrawables(drawable, null, null, null);
        this.aYe.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.aYe.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.aYg = z;
    }

    public void setLeftTitle(String str) {
        this.aXz.setText(str);
    }

    private void hR(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.aXr = i;
        this.aXo.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.aXq.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.aXp.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.aXn.setBackgroundResource(i);
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
        this.aYj = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0159a interfaceC0159a) {
        this.aMQ = interfaceC0159a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.aYq;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.aYj != null) {
                SwanAppBdActionBar.this.aYj.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.aXz != null) {
            if (z) {
                this.aXz.setVisibility(0);
            } else {
                this.aXz.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.aXq.setVisibility(0);
            this.aXp.setVisibility(0);
            return;
        }
        this.aXq.setVisibility(8);
        this.aXp.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.aXn.getLayoutParams()).setMargins(0, 0, x.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.aXD.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.aXO.setVisibility(0);
        }
        this.aYl.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.aYl.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aYl.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.aYm.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.aXI.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.aYh.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.aXO.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.aYi.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.aXn.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.aXo.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.aXq.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.aXy;
    }

    public int getRightMenuImageViewSrcId() {
        return this.aXr;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.aXL;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.aXH;
    }

    public TextView getTitleViewCenter() {
        return this.aXA;
    }

    private Drawable et(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void cs(boolean z) {
        if (this.aYp != null) {
            if (z && this.aYp.getVisibility() == 8) {
                this.aYp.setVisibility(0);
            } else if (!z && this.aYp.getVisibility() == 0) {
                this.aYp.setVisibility(8);
            }
        }
    }

    public void setActionBarCustom(boolean z) {
        this.aYq = z;
        int i = this.aYq ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
