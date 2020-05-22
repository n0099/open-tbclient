package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class SwanAppBdActionBar extends RelativeLayout {
    private static final int[] VISIBILITY_FLAGS = {8, 0, 4};
    private boolean cMh;
    private ImageView cMp;
    private View cOK;
    private ImageView cOL;
    private ImageView cOM;
    private ImageView cON;
    private com.baidu.swan.apps.res.ui.a cOO;
    private b.a cOP;
    private View cOQ;
    private b cOR;
    private ProgressBar cOS;
    private a.InterfaceC0372a czh;
    private boolean mIsLeftTitleInvalidate;
    private TextView mLeftFirstView;
    private TextView mLeftSecondView;
    private View mLeftZones;
    private View.OnClickListener mOnClickListener;
    private View mRightImgZone1;
    private Drawable mRightImgZone1ImageSrc;
    private int mRightImgZone1ImageSrcId;
    private int mRightImgZone1Visibility;
    private View mRightImgZone2;
    private Drawable mRightImgZone2ImageSrc;
    private int mRightImgZone2ImageSrcId;
    private View mRightImgZone2Notify;
    private int mRightImgZone2Visibility;
    private View mRightMenu;
    private ImageView mRightMenuImageView;
    private int mRightMenuImageViewSrcId;
    private View mRightTxtZone1;
    private ProgressBar mRightTxtZone1Progress;
    private TextView mRightTxtZone1Text;
    private String mRightTxtZone1TextString;
    private int mRightTxtZone1TxtColor;
    private int mRightTxtZone1TxtShadowColor;
    private float mRightTxtZone1TxtShadowDx;
    private float mRightTxtZone1TxtShadowDy;
    private float mRightTxtZone1TxtShadowRadius;
    private float mRightTxtZone1TxtSize;
    private int mRightTxtZone1Visibility;
    private View mRightTxtZone2;
    private TextView mRightTxtZone2Text;
    private String mRightTxtZone2TextString;
    private int mRightTxtZone2TxtColor;
    private int mRightTxtZone2Visibility;
    private View mRightZones;
    private int mRightZonesVisibility;
    private String mSubTitleText;
    private TextView mSubTitleViewCenter;
    private int mTitleAlignment;
    private int mTitleColorId;
    private String mTitleText;
    private int mTitleTxtShadowColor;
    private float mTitleTxtShadowDx;
    private float mTitleTxtShadowDy;
    private float mTitleTxtShadowRadius;
    private TextView mTitleViewCenter;

    /* loaded from: classes11.dex */
    public enum ActionbarTemplate {
        WHITE_TITLE_TEMPLATE,
        BALCK_TITLE_TEMPLATE
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onDoubleClick(View view);
    }

    public SwanAppBdActionBar(Context context) {
        super(context);
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        initAttrs(context, attributeSet);
        init();
    }

    public SwanAppBdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.widget.SwanAppBdActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppBdActionBar.this.toggleMenu();
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        initAttrs(context, attributeSet);
        init();
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.h.SwanAppBdActionBar, 0, 0);
            try {
                this.mTitleText = obtainStyledAttributes.getString(b.h.SwanAppBdActionBar_swanTitleText);
                this.mTitleTxtShadowColor = obtainStyledAttributes.getColor(b.h.SwanAppBdActionBar_titleTxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.mTitleTxtShadowDx = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_titleTxtShadowDx, -1.0f);
                this.mTitleTxtShadowDy = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_titleTxtShadowDy, -1.0f);
                this.mTitleTxtShadowRadius = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_titleTxtShadowRadius, -1.0f);
                this.mRightTxtZone2Visibility = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.mRightTxtZone2TextString = obtainStyledAttributes.getString(b.h.SwanAppBdActionBar_rightTxtZone1Text);
                this.mRightTxtZone1Visibility = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_rightTxtZone1Visibility, 0);
                this.mRightTxtZone1TextString = obtainStyledAttributes.getString(b.h.SwanAppBdActionBar_rightTxtZone1Text);
                this.mRightImgZone2ImageSrc = obtainStyledAttributes.getDrawable(b.h.SwanAppBdActionBar_rightImgZone2ImageSrc);
                this.mRightZonesVisibility = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_rightZonesVisibility, 0);
                this.mRightImgZone1ImageSrc = obtainStyledAttributes.getDrawable(b.h.SwanAppBdActionBar_rightImgZone1ImageSrc);
                this.mRightImgZone1Visibility = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_rightImgZone1Visibility, 0);
                this.mRightImgZone2Visibility = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_rightImgZone2Visibility, 0);
                this.mRightTxtZone1TxtColor = obtainStyledAttributes.getColor(b.h.SwanAppBdActionBar_rightTxtZone1TxtColor, getResources().getColor(b.C0409b.aiapps_action_bar_operation_btn_txt_color));
                this.mRightTxtZone1TxtSize = obtainStyledAttributes.getDimension(b.h.SwanAppBdActionBar_rightTxtZone1TxtSize, -1.0f);
                this.mRightTxtZone1TxtShadowColor = obtainStyledAttributes.getColor(b.h.SwanAppBdActionBar_rightTxtZone1TxtShadowColor, ViewCompat.MEASURED_STATE_MASK);
                this.mRightTxtZone1TxtShadowDx = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
                this.mRightTxtZone1TxtShadowDy = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
                this.mRightTxtZone1TxtShadowRadius = obtainStyledAttributes.getFloat(b.h.SwanAppBdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
                this.mTitleAlignment = obtainStyledAttributes.getInt(b.h.SwanAppBdActionBar_swanTitleAlignment, 1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setRightMenuVisibility(boolean z) {
        this.mRightMenu.setVisibility(z ? 0 : 8);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.cOP = aVar;
        if (this.cOO != null) {
            this.cOO.a(this.cOP);
        }
    }

    public boolean toggleMenu() {
        if (this.cOO != null) {
            int[] iArr = new int[2];
            this.mRightMenu.getLocationInWindow(iArr);
            int B = ag.B(6.0f);
            int height = iArr[1] + this.mRightMenu.getHeight() + ag.B(4.0f);
            this.cOO.getView().getWidth();
            this.cOO.setShowAtLocation(0, (ag.getDisplayWidth(getContext()) - B) - this.cOO.getView().getWidth(), height);
            this.cOO.toggle();
            return true;
        }
        return false;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(b.f.ai_apps_action_bar, this);
        this.cOS = (ProgressBar) findViewById(b.e.aiapps_nav_loading_progressbar);
        this.mLeftFirstView = (TextView) findViewById(b.e.left_first_view);
        this.mLeftFirstView.setCompoundDrawables(getDrawableFromId(b.d.aiapps_action_bar_back_selector), null, null, null);
        this.mLeftFirstView.setTextColor(getResources().getColorStateList(b.C0409b.aiapps_action_bar_operation_btn_selector));
        this.mTitleViewCenter = (TextView) findViewById(b.e.title_text_center);
        this.mSubTitleViewCenter = (TextView) findViewById(b.e.subtitle_text_center);
        this.mSubTitleViewCenter.setTextColor(getResources().getColor(b.C0409b.aiapps_white_text));
        this.mLeftSecondView = (TextView) findViewById(b.e.left_second_view);
        this.mLeftSecondView.setTextColor(getResources().getColorStateList(b.C0409b.aiapps_action_bar_operation_btn_selector));
        if (this.mTitleTxtShadowDx != -1.0f && this.mTitleTxtShadowDy != -1.0f && this.mTitleTxtShadowRadius != -1.0f) {
            this.mLeftFirstView.setShadowLayer(this.mTitleTxtShadowRadius, this.mTitleTxtShadowDx, this.mTitleTxtShadowDy, this.mTitleTxtShadowColor);
        }
        this.mRightTxtZone2 = findViewById(b.e.titlebar_right_txtzone2);
        this.mRightTxtZone2.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone2Visibility]);
        this.mRightTxtZone2Text = (TextView) findViewById(b.e.titlebar_right_txtzone2_txt);
        if (this.mRightTxtZone2TextString != null) {
            this.mRightTxtZone2Text.setText(this.mRightTxtZone2TextString);
        }
        if (this.mRightTxtZone2TxtColor != -1) {
            this.mRightTxtZone2Text.setTextColor(this.mRightTxtZone2TxtColor);
        } else {
            this.mRightTxtZone2Text.setTextColor(getResources().getColorStateList(b.C0409b.aiapps_action_bar_operation_btn_selector));
        }
        this.mRightTxtZone1 = findViewById(b.e.titlebar_right_txtzone1);
        this.mRightTxtZone1.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone1Visibility]);
        this.mRightTxtZone1Text = (TextView) findViewById(b.e.titlebar_right_txtzone1_txt);
        if (this.mRightTxtZone1TextString != null) {
            this.mRightTxtZone1Text.setText(this.mRightTxtZone1TextString);
        }
        if (this.mRightTxtZone1TxtColor != -1) {
            this.mRightTxtZone1Text.setTextColor(this.mRightTxtZone1TxtColor);
        } else {
            this.mRightTxtZone1Text.setTextColor(getResources().getColorStateList(b.C0409b.aiapps_action_bar_operation_btn_selector));
        }
        this.mRightTxtZone1Progress = (ProgressBar) findViewById(b.e.titlebar_right_txtzone1_progress);
        this.cOL = (ImageView) findViewById(b.e.titlebar_right_imgzone2_img);
        this.cOM = (ImageView) findViewById(b.e.new_tip_img);
        this.mRightImgZone2 = findViewById(b.e.titlebar_right_imgzone2);
        this.mRightImgZone2.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone2Visibility]);
        this.cON = (ImageView) findViewById(b.e.titlebar_right_imgzone1_img);
        this.mRightImgZone1 = findViewById(b.e.titlebar_right_imgzone1);
        this.mRightImgZone1.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone1Visibility]);
        this.mRightZones = findViewById(b.e.titlebar_right_zones);
        this.mRightZones.setVisibility(VISIBILITY_FLAGS[this.mRightZonesVisibility]);
        this.mLeftZones = findViewById(b.e.titlebar_left_zones);
        this.mRightImgZone2Notify = findViewById(b.e.titlebar_right_imgzone2_notify);
        this.cOQ = findViewById(b.e.titlebar_center_zones);
        this.mRightMenu = findViewById(b.e.titlebar_right_menu);
        this.mRightMenuImageView = (ImageView) findViewById(b.e.titlebar_right_menu_img);
        this.cOK = findViewById(b.e.titlebar_right_menu_line);
        this.cMp = (ImageView) findViewById(b.e.titlebar_right_menu_exit);
        setTitleAlignment(1);
        setTitle(this.mTitleText);
        setTitleColor(b.C0409b.aiapps_black_text);
        setRightMenuImageSrc(b.d.aiapps_action_bar_menu_normal_selector);
        setRightImgZone2Src(b.d.aiapps_action_bar_add_2_selector);
        setRightImgZone1Src(b.d.aiapps_action_bar_add_selector);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new a());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.swan.bdprivate.widget.SwanAppBdActionBar.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    public void setTitleBarTitleSize(float f) {
        this.mTitleViewCenter.setTextSize(0, f);
    }

    private void setActionBarHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    public void setTitleAlignment(int i) {
        this.mTitleAlignment = i;
        setTitle(this.mTitleText);
    }

    public void setSubTitle(String str) {
        this.mSubTitleText = str;
        if (TextUtils.isEmpty(this.mSubTitleText)) {
            this.mSubTitleViewCenter.setVisibility(8);
        } else {
            this.mSubTitleViewCenter.setVisibility(0);
        }
        if (1 == this.mTitleAlignment) {
            this.mSubTitleViewCenter.setText(str);
        } else if (this.mTitleAlignment == 0) {
            this.mSubTitleViewCenter.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setSubTitle(int i) {
        setSubTitle(getResources().getString(i));
    }

    public String getSubTitle() {
        return this.mSubTitleText;
    }

    public void setSubTitleColor(int i) {
        this.mSubTitleViewCenter.setTextColor(i);
    }

    public void setTitle(String str) {
        this.mTitleText = str;
        if (1 == this.mTitleAlignment) {
            this.mTitleViewCenter.setText(str);
            if (this.mIsLeftTitleInvalidate) {
                resetCenterTextViewPadding(str);
            } else {
                this.mLeftFirstView.setText((CharSequence) null);
            }
        } else if (this.mTitleAlignment == 0) {
            this.mLeftFirstView.setText(str);
            this.mTitleViewCenter.setText((CharSequence) null);
        }
        invalidate();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public String getTitle() {
        return this.mTitleText;
    }

    public void setTitleColor(int i) {
        this.mTitleColorId = i;
        this.mTitleViewCenter.setTextColor(getResources().getColor(i));
    }

    public void setTitleSize(int i) {
        this.mLeftFirstView.setTextSize(0, i);
    }

    public void setTitlePadding(int i, int i2, int i3, int i4) {
        this.mLeftFirstView.setPadding(i, i2, i3, i4);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.mLeftFirstView.setShadowLayer(f, f2, f3, i);
        this.mTitleViewCenter.setShadowLayer(f, f2, f3, i);
    }

    public void setRightTxtZone1Text(int i) {
        this.mRightTxtZone1Text.setText(i);
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        this.mRightTxtZone1Text.setText(charSequence);
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        if (this.mRightTxtZone1Text != null) {
            this.mRightTxtZone1Text.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextColor(int i) {
        this.mRightTxtZone1Text.setTextColor(i);
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        this.mRightTxtZone1Text.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i) {
        this.mRightTxtZone1Text.setTextSize(0, i);
    }

    public void setRightTxtZone1Enable(boolean z) {
        this.mRightTxtZone1.setEnabled(z);
    }

    public void setRightTxtZone1Visibility(int i) {
        if (i == 0) {
            this.mRightZones.setVisibility(0);
        }
        this.mRightTxtZone1.setVisibility(i);
    }

    public int getRightTxtZone1Visibility() {
        return this.mRightTxtZone1.getVisibility();
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.mLeftFirstView.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        this.mRightTxtZone1.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone1Clickable(boolean z) {
        this.mRightTxtZone1.setClickable(z);
        this.mRightTxtZone1Text.setEnabled(z);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        this.mRightImgZone2.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Width(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.gravity = 16;
        this.mRightImgZone2.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2ImgWidth(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOL.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = i;
        this.cOL.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.mRightImgZone1.setOnClickListener(onClickListener);
    }

    public void setRightImageZone1Params(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone1.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.mRightImgZone1.setLayoutParams(layoutParams);
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        this.mRightImgZone1.setLayoutParams(layoutParams);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.mRightImgZone1.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.mRightImgZone1ImageSrcId = i;
        this.cON.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        this.cON.setScaleType(scaleType);
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        this.cOL.setScaleType(scaleType);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.cOL.setEnabled(z);
        this.mRightImgZone2.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.mRightImgZone2ImageSrcId = i;
        this.cOL.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        this.mRightImgZone2ImageSrc = drawable;
        this.cOL.setImageDrawable(this.mRightImgZone2ImageSrc);
    }

    public void setRightImgZone2Params(int i, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cOL.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = i3;
        layoutParams.topMargin = i3;
        this.cOL.setLayoutParams(layoutParams);
    }

    public void setRightImgZone2Visibility(int i) {
        this.mRightImgZone2.setVisibility(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.mRightImgZone1.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.mRightImgZone2Notify.setVisibility(i);
    }

    public int getRightTxtZone1ProgressVisibility() {
        return this.mRightTxtZone1Progress.getVisibility();
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.mRightImgZone2Notify.getVisibility();
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.mLeftFirstView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftFirstView.setSelected(false);
    }

    public void setLeftZoneImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.mLeftFirstView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftFirstView.setSelected(false);
    }

    public void setLeftZoneImageSrcPadding(int i) {
        this.mLeftFirstView.setCompoundDrawablePadding(i);
    }

    public void setLeftZoneImageSrcMinWidth(int i) {
        this.mLeftFirstView.setMinimumWidth(i);
    }

    public void setLeftZoneImageSelected(boolean z) {
        this.mLeftFirstView.setSelected(z);
    }

    public void setTxtZoneBackgroundResource(int i) {
        this.mRightTxtZone1.setBackground(getResources().getDrawable(i));
        this.mRightTxtZone2.setBackground(getResources().getDrawable(i));
    }

    public void setTxtZoneBackgroundMinimumWidth(int i) {
        this.mRightTxtZone1.setMinimumWidth(i);
    }

    public void setTxtZoneBackgroundMinimumHeight(int i) {
        this.mRightTxtZone1.setMinimumHeight(i);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.mLeftFirstView.setBackground(getResources().getDrawable(i));
        this.mRightImgZone1.setBackground(getResources().getDrawable(i));
        this.mRightImgZone2.setBackground(getResources().getDrawable(i));
        this.mLeftSecondView.setBackground(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(int i) {
        this.mRightImgZone1ImageSrcId = i;
        setRightImgZone1ImageSrc(getResources().getDrawable(i));
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        this.mRightImgZone1ImageSrc = drawable;
        this.cON.setImageDrawable(this.mRightImgZone1ImageSrc);
    }

    public void setLeftSecondViewVisibility(int i) {
        if (this.mLeftSecondView.getVisibility() != i) {
            this.mLeftSecondView.setVisibility(i);
            resetCenterTextViewPadding(this.mTitleText);
        }
    }

    public void setLeftSecondViewText(String str) {
        if (this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setText(str);
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        if (this.mLeftFirstView != null) {
            this.mLeftFirstView.setTextColor(colorStateList);
        }
    }

    public void setLeftSecondViewTextSize(int i) {
        if (this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setTextSize(i);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        this.mLeftSecondView.setOnClickListener(onClickListener);
    }

    public void setLeftSecondViewImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftSecondView.setSelected(false);
    }

    public void setLeftSecondViewImageSrc(int i, int i2, int i3) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
        this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftSecondView.setSelected(false);
    }

    public void setLeftSecondViewImageSrcPadding(int i) {
        this.mLeftSecondView.setCompoundDrawablePadding(i);
    }

    public void setLeftTitleInvalidate(boolean z) {
        this.mIsLeftTitleInvalidate = z;
    }

    public void setLeftTitle(String str) {
        this.mLeftFirstView.setText(str);
    }

    private void resetCenterTextViewPadding(String str) {
    }

    public void setRightMenuImageSrc(int i) {
        this.mRightMenuImageViewSrcId = i;
        this.mRightMenuImageView.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightExitImageSrc(int i) {
        this.cMp.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRightMenuLineSrc(int i) {
        this.cOK.setBackgroundResource(i);
    }

    public void setRightMenuBgSrc(int i) {
        this.mRightMenu.setBackgroundResource(i);
    }

    public void setOnDoubleClickListener(b bVar) {
        this.cOR = bVar;
    }

    public void setOnMenuItemsUpdateListener(a.InterfaceC0372a interfaceC0372a) {
        this.czh = interfaceC0372a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return !SwanAppBdActionBar.this.cMh;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwanAppBdActionBar.this.cOR != null) {
                SwanAppBdActionBar.this.cOR.onDoubleClick(SwanAppBdActionBar.this);
            }
            return super.onDoubleTap(motionEvent);
        }
    }

    public void setLeftFirstViewVisibility(boolean z) {
        if (this.mLeftFirstView != null) {
            if (z) {
                this.mLeftFirstView.setVisibility(0);
            } else {
                this.mLeftFirstView.setVisibility(8);
            }
        }
    }

    public void setRightExitViewVisibility(boolean z) {
        if (z) {
            this.cMp.setVisibility(0);
            this.cOK.setVisibility(0);
            return;
        }
        this.cMp.setVisibility(8);
        this.cOK.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.mRightMenu.getLayoutParams()).setMargins(0, 0, ag.dip2px(getContext(), 4.6f), 0);
    }

    public void setRightTxtZone1Background(int i) {
        this.mRightTxtZone1.setBackgroundResource(i);
    }

    public void setRightTxtZone2Visibility(int i) {
        if (i == 0) {
            this.mRightZones.setVisibility(0);
        }
        this.mRightTxtZone2.setVisibility(i);
    }

    public int getRightTxtZone2Visibility() {
        return this.mRightTxtZone2.getVisibility();
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        this.mRightTxtZone2.setOnClickListener(onClickListener);
    }

    public void setRightTxtZone2Text(int i) {
        this.mRightTxtZone2Text.setText(i);
    }

    public void setRightTipsStatus(boolean z) {
        this.cOM.setVisibility(z ? 0 : 8);
    }

    public void setLeftZonesVisibility(int i) {
        this.mLeftZones.setVisibility(i);
    }

    public void setRightZonesVisibility(int i) {
        this.mRightZones.setVisibility(i);
    }

    public void setCenterZonesVisibility(int i) {
        this.cOQ.setVisibility(i);
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        this.mRightMenu.setOnClickListener(onClickListener);
    }

    public void setRightMenuOnClickListener(View.OnClickListener onClickListener) {
        this.mRightMenuImageView.setOnClickListener(onClickListener);
    }

    public void setRightExitOnClickListener(View.OnClickListener onClickListener) {
        this.cMp.setOnClickListener(onClickListener);
    }

    public int getTitleColorId() {
        return this.mTitleColorId;
    }

    public int getRightMenuImageViewSrcId() {
        return this.mRightMenuImageViewSrcId;
    }

    public int getRightImgZone1ImageSrcId() {
        return this.mRightImgZone1ImageSrcId;
    }

    public int getRightImgZone2ImageSrcId() {
        return this.mRightImgZone2ImageSrcId;
    }

    public TextView getTitleViewCenter() {
        return this.mTitleViewCenter;
    }

    public View getRightMenu() {
        return this.mRightMenu;
    }

    private Drawable getDrawableFromId(int i) {
        Drawable drawable = getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public void setActionBarCustom(boolean z) {
        this.cMh = z;
        int i = this.cMh ? 8 : 0;
        setLeftZonesVisibility(i);
        setCenterZonesVisibility(i);
        setRightZonesVisibility(i);
    }
}
