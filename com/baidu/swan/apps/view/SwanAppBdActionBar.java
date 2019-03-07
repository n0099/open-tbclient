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
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
/* loaded from: classes2.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] aXX = {8, 0, 4};
    private a.InterfaceC0130a aML;
    private ProgressBar aXA;
    private ImageView aXB;
    private int aXC;
    private ImageView aXD;
    private View aXE;
    private ImageView aXF;
    private int aXG;
    private View aXH;
    private View aXI;
    private View aXJ;
    private String aXK;
    private int aXL;
    private float aXM;
    private int aXN;
    private float aXO;
    private float aXP;
    private float aXQ;
    private int aXR;
    private int aXS;
    private int aXT;
    private int aXU;
    private Drawable aXV;
    private Drawable aXW;
    private com.baidu.swan.apps.res.ui.a aXY;
    private TextView aXZ;
    private View aXi;
    private ImageView aXj;
    private View aXk;
    private ImageView aXl;
    private int aXm;
    private String aXn;
    private String aXo;
    private int aXp;
    private float aXq;
    private float aXr;
    private float aXs;
    private int aXt;
    private TextView aXu;
    private TextView aXv;
    private TextView aXw;
    private int aXx;
    private View aXy;
    private TextView aXz;
    private b.a aYa;
    private boolean aYb;
    private View aYc;
    private View aYd;
    private b aYe;
    private int aYf;
    private View aYg;
    private TextView aYh;
    private String aYi;
    private int aYj;
    private ProgressBar aYk;
    private boolean aYl;
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
        this.aXL = -1;
        this.aXM = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYj = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXL = -1;
        this.aXM = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYj = -1;
        c(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXL = -1;
        this.aXM = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.MF();
            }
        };
        this.aYj = -1;
        c(context, attributeSet);
        init();
    }

    private void c(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.j.SwanAppBdActionBar, 0, 0);
            try {
                this.aXn = obtainStyledAttributes.getString(b.j.SwanAppBdActionBar_titleText);
                this.aXp = obtainStyledAttributes.getColor(b.j.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXq = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.aXr = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.aXs = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.aYf = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aYi = obtainStyledAttributes.getString(b.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXS = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.aXK = obtainStyledAttributes.getString(b.j.SwanAppBdActionBar_rightTxtZone1Text);
                this.aXV = obtainStyledAttributes.getDrawable(b.j.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.aXR = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.aXW = obtainStyledAttributes.getDrawable(b.j.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.aXT = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.aXU = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.aXL = obtainStyledAttributes.getColor(b.j.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(b.c.aiapps_action_bar_operation_btn_txt_color));
                this.aXM = obtainStyledAttributes.getDimension(b.j.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.aXN = obtainStyledAttributes.getColor(b.j.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.aXO = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.aXP = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.aXQ = obtainStyledAttributes.getFloat(b.j.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.aXx = obtainStyledAttributes.getInt(b.j.SwanAppBdActionBar_titleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.aXi.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.aYa = aVar;
        if (this.aXY != null) {
            this.aXY.a(this.aYa);
        }
    }

    public boolean MF() {
        if (this.aXY != null) {
            int[] iArr = new int[2];
            this.aXi.getLocationInWindow(iArr);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(b.d.aiapps_actionbar_menu_right_padding);
            int height = iArr[1] + this.aXi.getHeight() + getContext().getResources().getDimensionPixelSize(b.d.aiapps_actionbar_menu_top_padding);
            this.aXY.getView().getWidth();
            this.aXY.m(0, (x.getDisplayWidth(getContext()) - dimensionPixelSize) - this.aXY.getView().getWidth(), height);
            this.aXY.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.g.aiapps_action_bar, this);
        this.aYk = (ProgressBar) findViewById(b.f.aiapps_nav_loading_progressbar);
        this.aXu = (TextView) findViewById(b.f.left_first_view);
        this.aXu.setCompoundDrawables(eu(b.e.aiapps_action_bar_back_selector), null, null, null);
        this.aXu.setTextColor(getResources().getColorStateList(b.c.aiapps_action_bar_operation_btn_selector));
        this.aXv = (TextView) findViewById(b.f.title_text_center);
        this.aXw = (TextView) findViewById(b.f.subtitle_text_center);
        this.aXw.setTextColor(getResources().getColor(b.c.aiapps_white_text));
        this.aXZ = (TextView) findViewById(b.f.left_second_view);
        this.aXZ.setTextColor(getResources().getColorStateList(b.c.aiapps_action_bar_operation_btn_selector));
        if (this.aXq != -1.0f && this.aXr != -1.0f && this.aXs != -1.0f) {
            this.aXu.setShadowLayer(this.aXs, this.aXq, this.aXr, this.aXp);
        }
        this.aYg = findViewById(b.f.titlebar_right_txtzone2);
        this.aYg.setVisibility(aXX[this.aYf]);
        this.aYh = (TextView) findViewById(b.f.titlebar_right_txtzone2_txt);
        if (this.aYi != null) {
            this.aYh.setText(this.aYi);
        }
        if (this.aYj != -1) {
            this.aYh.setTextColor(this.aYj);
        } else {
            this.aYh.setTextColor(getResources().getColorStateList(b.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXy = findViewById(b.f.titlebar_right_txtzone1);
        this.aXy.setVisibility(aXX[this.aXS]);
        this.aXz = (TextView) findViewById(b.f.titlebar_right_txtzone1_txt);
        if (this.aXK != null) {
            this.aXz.setText(this.aXK);
        }
        if (this.aXL != -1) {
            this.aXz.setTextColor(this.aXL);
        } else {
            this.aXz.setTextColor(getResources().getColorStateList(b.c.aiapps_action_bar_operation_btn_selector));
        }
        this.aXA = (ProgressBar) findViewById(b.f.titlebar_right_txtzone1_progress);
        this.aXB = (ImageView) findViewById(b.f.titlebar_right_imgzone2_img);
        this.aXD = (ImageView) findViewById(b.f.new_tip_img);
        this.aXE = findViewById(b.f.titlebar_right_imgzone2);
        this.aXE.setVisibility(aXX[this.aXU]);
        this.aXF = (ImageView) findViewById(b.f.titlebar_right_imgzone1_img);
        this.aXH = findViewById(b.f.titlebar_right_imgzone1);
        this.aXH.setVisibility(aXX[this.aXT]);
        this.aXJ = findViewById(b.f.titlebar_right_zones);
        this.aXJ.setVisibility(aXX[this.aXR]);
        this.aYc = findViewById(b.f.titlebar_left_zones);
        this.aXI = findViewById(b.f.titlebar_right_imgzone2_notify);
        this.aYd = findViewById(b.f.titlebar_center_zones);
        this.aXi = findViewById(b.f.titlebar_right_menu);
        this.aXj = (ImageView) findViewById(b.f.titlebar_right_menu_img);
        this.aXk = findViewById(b.f.titlebar_right_menu_line);
        this.aXl = (ImageView) findViewById(b.f.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.aXn);
        setTitleColor(b.c.aiapps_black_text);
        setRightMenuImageSrc(b.e.aiapps_action_bar_menu_normal_selector);
        setRightImgZone2Src(b.e.aiapps_action_bar_add_2_selector);
        setRightImgZone1Src(b.e.aiapps_action_bar_add_selector);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new a());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.apps.view.SwanAppBdActionBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setTitleBarTitleSize(float f) {
        this.aXv.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.aXx = i;
        setTitle(this.aXn);
    }

    public void setSubTitle(String str) {
        this.aXo = str;
        if (TextUtils.isEmpty(this.aXo)) {
            this.aXw.setVisibility(8);
        } else {
            this.aXw.setVisibility(0);
        }
        if (1 == this.aXx) {
            this.aXw.setText(str);
        } else if (this.aXx == 0) {
            this.aXw.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.aXo;
    }

    public void setSubTitleColor(int i) {
        this.aXw.setTextColor(i);
    }

    public void setTitle(String str) {
        this.aXn = str;
        if (1 == this.aXx) {
            this.aXv.setText(str);
            if (this.aYb) {
                hQ(str);
            } else {
                this.aXu.setText((CharSequence) null);
            }
        } else if (this.aXx == 0) {
            this.aXu.setText(str);
            this.aXv.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.aXn;
    }

    public void setTitleColor(int i) {
        this.aXt = i;
        this.aXv.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.aXu.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.aXu.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.aXu.setShadowLayer(f, f2, f3, i);
        this.aXv.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.aXz.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.aXz.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.aXz != null) {
            this.aXz.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.aXz.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.aXz.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.aXz.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.aXy.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.aXJ.setVisibility(0);
        }
        this.aXy.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.aXy.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.aXu.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXy.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.aXy.setClickable(z);
        this.aXz.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aXE.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXE.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.aXE.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXB.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.aXB.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.aXH.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXH.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.aXH.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.aXH.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.aXH.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.aXG = i;
        this.aXF.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXF.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.aXB.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.aXB.setEnabled(z);
        this.aXE.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.aXC = i;
        this.aXB.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.aXV = drawable;
        this.aXB.setImageDrawable(this.aXV);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXB.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.aXB.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.aXE.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.aXH.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.aXI.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.aXA.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.aXI.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aXu.setCompoundDrawables(drawable, null, null, null);
        this.aXu.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aXu.setCompoundDrawables(drawable, null, null, null);
        this.aXu.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.aXu.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.aXu.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.aXu.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.aXy.setBackground(getResources().getDrawable(i));
        this.aYg.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.aXy.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.aXy.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.aXu.setBackground(getResources().getDrawable(i));
        this.aXH.setBackground(getResources().getDrawable(i));
        this.aXE.setBackground(getResources().getDrawable(i));
        this.aXZ.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.aXG = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.aXW = drawable;
        this.aXF.setImageDrawable(this.aXW);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.aXZ.getVisibility() != i) {
            this.aXZ.setVisibility(i);
            hQ(this.aXn);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.aXZ.getVisibility() == 0) {
            this.aXZ.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.aXu != null) {
            this.aXu.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.aXZ.getVisibility() == 0) {
            this.aXZ.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.aXZ.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.aXZ.setCompoundDrawables(drawable, null, null, null);
        this.aXZ.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.aXZ.setCompoundDrawables(drawable, null, null, null);
        this.aXZ.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.aXZ.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.aYb = z;
    }

    public void setLeftTitle(String str) {
        this.aXu.setText(str);
    }

    private void hQ(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.aXm = i;
        this.aXj.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.aXl.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.aXk.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.aXi.setBackgroundResource(i);
    }

    public boolean m(@ColorInt int i, boolean z) {
        if (i == -1) {
            setTitleColor(b.c.aiapps_white_text);
            setLeftZoneImageSrc(b.e.aiapps_action_bar_back_white_selector);
            setLeftSecondViewImageSrc(b.e.aiapps_action_bar_home_white_selector);
            setRightMenuImageSrc(z ? b.e.aiapps_action_bar_single_menu_white_selector : b.e.aiapps_action_bar_menu_white_selector);
            setRightExitImageSrc(b.e.aiapps_action_bar_exit_white_selector);
            setRightMenuLineSrc(b.c.aiapps_action_bar_menu_line_white);
            setRightMenuBgSrc(z ? b.c.aiapps_transparent : b.e.aiapps_action_bar_right_menu_bg_solid);
        } else if (i == -16777216) {
            setTitleColor(b.c.aiapps_black_text);
            setLeftZoneImageSrc(b.e.aiapps_action_bar_back_black_selector);
            setLeftSecondViewImageSrc(b.e.aiapps_action_bar_home_black_selector);
            setRightMenuImageSrc(z ? b.e.aiapps_action_bar_single_menu_black_selector : b.e.aiapps_action_bar_menu_black_selector);
            setRightExitImageSrc(b.e.aiapps_action_bar_exit_black_selector);
            setRightMenuLineSrc(b.c.aiapps_action_bar_menu_line_color);
            setRightMenuBgSrc(z ? b.c.aiapps_transparent : b.e.aiapps_action_bar_right_menu_bg);
        } else {
            setTitleColor(b.c.aiapps_white_text);
            setLeftZoneImageSrc(b.e.aiapps_action_bar_back_white_selector);
            setLeftSecondViewImageSrc(b.e.aiapps_action_bar_home_white_selector);
            setRightMenuImageSrc(z ? b.e.aiapps_action_bar_single_menu_white_selector : b.e.aiapps_action_bar_menu_white_selector);
            setRightExitImageSrc(b.e.aiapps_action_bar_exit_white_selector);
            setRightMenuLineSrc(b.c.aiapps_action_bar_menu_line_white);
            setRightMenuBgSrc(z ? b.c.aiapps_transparent : b.e.aiapps_action_bar_right_menu_bg_solid);
            return false;
        }
        return true;
    }

    public void setTemplate(ActionbarTemplate actionbarTemplate) {
        if (actionbarTemplate != null) {
            switch (actionbarTemplate) {
                case WHITE_TITLE_TEMPLATE:
                    setTitleColor(b.c.aiapps_white_text);
                    setRightMenuImageSrc(b.e.aiapps_action_bar_menu_normal_selector);
                    return;
                case BALCK_TITLE_TEMPLATE:
                    setTitleColor(b.c.aiapps_black_text);
                    setRightMenuImageSrc(b.e.aiapps_action_bar_black_menu_normal_selector);
                    return;
                default:
                    return;
            }
        }
    }

    public void setOnDoubleClickListener(b bVar) {
        this.aYe = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0130a interfaceC0130a) {
        this.aML = interfaceC0130a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.aYl;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.aYe != null) {
                SwanAppBdActionBar.this.aYe.S(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.aXu != null) {
            if (z) {
                this.aXu.setVisibility(0);
            } else {
                this.aXu.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.aXl.setVisibility(0);
            this.aXk.setVisibility(0);
            return;
        }
        this.aXl.setVisibility(8);
        this.aXk.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.aXi.getLayoutParams()).setMargins(0, 0, x.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.aXy.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.aXJ.setVisibility(0);
        }
        this.aYg.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.aYg.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.aYg.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.aYh.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.aXD.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.aYc.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.aXJ.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.aYd.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.aXi.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.aXj.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.aXl.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.aXt;
    }

    public int getRightMenuImageViewSrcId() {
        return this.aXm;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.aXG;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.aXC;
    }

    public TextView getTitleViewCenter() {
        return this.aXv;
    }

    private Drawable eu(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void cs(boolean z) {
        if (this.aYk != null) {
            if (z && this.aYk.getVisibility() == 8) {
                this.aYk.setVisibility(0);
            } else if (!z && this.aYk.getVisibility() == 0) {
                this.aYk.setVisibility(8);
            }
        }
    }

    public void setActionBarCustom(boolean z) {
        this.aYl = z;
        int i = this.aYl ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
