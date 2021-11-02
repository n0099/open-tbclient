package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class BdActionBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;
    public static final int[] VISIBILITY_FLAGS;
    public transient /* synthetic */ FieldHolder $fh;
    public OnDoubleClickListener mDoubleClickListener;
    public boolean mIsLeftTitleInvalidate;
    public TextView mLeftFirstView;
    public TextView mLeftSecondView;
    public View mLeftZones;
    public CommonOverflowMenu mMenu;
    public BdMenu.OnMenuItemsUpdateListener mMenuItemsUpdateListener;
    public View.OnClickListener mOnClickListener;
    public BdMenuItem.OnItemClickListener mOnItemClickListener;
    public View mRightImgZone1;
    public BdBaseImageView mRightImgZone1Image;
    public Drawable mRightImgZone1ImageSrc;
    public int mRightImgZone1ImageSrcId;
    public int mRightImgZone1Visibility;
    public View mRightImgZone2;
    public BdBaseImageView mRightImgZone2Image;
    public Drawable mRightImgZone2ImageSrc;
    public int mRightImgZone2ImageSrcId;
    public View mRightImgZone2Notify;
    public BdBaseImageView mRightImgZone2Tips;
    public int mRightImgZone2Visibility;
    public View mRightMenu;
    public ImageView mRightMenuImageView;
    public int mRightMenuImageViewSrcId;
    public View mRightTxtZone1;
    public ProgressBar mRightTxtZone1Progress;
    public TextView mRightTxtZone1Text;
    public String mRightTxtZone1TextString;
    public int mRightTxtZone1TxtColor;
    public int mRightTxtZone1TxtShadowColor;
    public float mRightTxtZone1TxtShadowDx;
    public float mRightTxtZone1TxtShadowDy;
    public float mRightTxtZone1TxtShadowRadius;
    public float mRightTxtZone1TxtSize;
    public int mRightTxtZone1Visibility;
    public View mRightTxtZone2;
    public TextView mRightTxtZone2Text;
    public String mRightTxtZone2TextString;
    public int mRightTxtZone2TxtColor;
    public int mRightTxtZone2Visibility;
    public View mRightZones;
    public int mRightZonesVisibility;
    public String mSubTitleText;
    public TextView mSubTitleViewCenter;
    public int mTitleAlignment;
    public int mTitleColorId;
    public String mTitleText;
    public int mTitleTxtShadowColor;
    public float mTitleTxtShadowDx;
    public float mTitleTxtShadowDy;
    public float mTitleTxtShadowRadius;
    public TextView mTitleViewCenter;

    /* renamed from: com.baidu.searchbox.ui.BdActionBar$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(225013041, "Lcom/baidu/searchbox/ui/BdActionBar$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(225013041, "Lcom/baidu/searchbox/ui/BdActionBar$4;");
                    return;
                }
            }
            int[] iArr = new int[ActionbarTemplate.values().length];
            $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate = iArr;
            try {
                iArr[ActionbarTemplate.WHITE_TITLE_TEMPLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate[ActionbarTemplate.BALCK_TITLE_TEMPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class ActionbarTemplate {
        public static final /* synthetic */ ActionbarTemplate[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ActionbarTemplate BALCK_TITLE_TEMPLATE;
        public static final ActionbarTemplate WHITE_TITLE_TEMPLATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(81967150, "Lcom/baidu/searchbox/ui/BdActionBar$ActionbarTemplate;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(81967150, "Lcom/baidu/searchbox/ui/BdActionBar$ActionbarTemplate;");
                    return;
                }
            }
            WHITE_TITLE_TEMPLATE = new ActionbarTemplate("WHITE_TITLE_TEMPLATE", 0);
            ActionbarTemplate actionbarTemplate = new ActionbarTemplate("BALCK_TITLE_TEMPLATE", 1);
            BALCK_TITLE_TEMPLATE = actionbarTemplate;
            $VALUES = new ActionbarTemplate[]{WHITE_TITLE_TEMPLATE, actionbarTemplate};
        }

        public ActionbarTemplate(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ActionbarTemplate valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ActionbarTemplate) Enum.valueOf(ActionbarTemplate.class, str) : (ActionbarTemplate) invokeL.objValue;
        }

        public static ActionbarTemplate[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ActionbarTemplate[]) $VALUES.clone() : (ActionbarTemplate[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdActionBar this$0;

        public GestureListener(BdActionBar bdActionBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdActionBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdActionBar;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.this$0.mDoubleClickListener != null) {
                    this.this$0.mDoubleClickListener.onDoubleClick(this.this$0);
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface OnDoubleClickListener {
        void onDoubleClick(View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1291384511, "Lcom/baidu/searchbox/ui/BdActionBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1291384511, "Lcom/baidu/searchbox/ui/BdActionBar;");
                return;
            }
        }
        VISIBILITY_FLAGS = new int[]{8, 0, 4};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.BdActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.this$0.toggleMenu();
                }
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        init();
    }

    private Drawable getDrawableFromId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2)) == null) {
            Drawable drawable = getResources().getDrawable(i2);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            return drawable;
        }
        return (Drawable) invokeI.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            LayoutInflater.from(getContext()).inflate(com.baidu.android.common.ui.R.layout.action_bar, this);
            TextView textView = (TextView) findViewById(com.baidu.android.common.ui.R.id.left_first_view);
            this.mLeftFirstView = textView;
            textView.setCompoundDrawables(getDrawableFromId(com.baidu.android.common.ui.R.drawable.action_bar_back_selector), null, null, null);
            this.mLeftFirstView.setTextColor(getResources().getColorStateList(com.baidu.android.common.ui.R.color.action_bar_operation_btn_selector));
            this.mTitleViewCenter = (TextView) findViewById(com.baidu.android.common.ui.R.id.title_text_center);
            TextView textView2 = (TextView) findViewById(com.baidu.android.common.ui.R.id.subtitle_text_center);
            this.mSubTitleViewCenter = textView2;
            textView2.setTextColor(getResources().getColor(com.baidu.android.common.ui.R.color.white_text));
            TextView textView3 = (TextView) findViewById(com.baidu.android.common.ui.R.id.left_second_view);
            this.mLeftSecondView = textView3;
            textView3.setTextColor(getResources().getColorStateList(com.baidu.android.common.ui.R.color.action_bar_operation_btn_selector));
            float f2 = this.mTitleTxtShadowDx;
            if (f2 != -1.0f) {
                float f3 = this.mTitleTxtShadowDy;
                if (f3 != -1.0f) {
                    float f4 = this.mTitleTxtShadowRadius;
                    if (f4 != -1.0f) {
                        this.mLeftFirstView.setShadowLayer(f4, f2, f3, this.mTitleTxtShadowColor);
                    }
                }
            }
            View findViewById = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_txtzone2);
            this.mRightTxtZone2 = findViewById;
            findViewById.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone2Visibility]);
            TextView textView4 = (TextView) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_txtzone2_txt);
            this.mRightTxtZone2Text = textView4;
            String str = this.mRightTxtZone2TextString;
            if (str != null) {
                textView4.setText(str);
            }
            int i2 = this.mRightTxtZone2TxtColor;
            if (i2 != -1) {
                this.mRightTxtZone2Text.setTextColor(i2);
            } else {
                this.mRightTxtZone2Text.setTextColor(getResources().getColorStateList(com.baidu.android.common.ui.R.color.action_bar_operation_btn_selector));
            }
            View findViewById2 = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_txtzone1);
            this.mRightTxtZone1 = findViewById2;
            findViewById2.setVisibility(VISIBILITY_FLAGS[this.mRightTxtZone1Visibility]);
            TextView textView5 = (TextView) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_txtzone1_txt);
            this.mRightTxtZone1Text = textView5;
            String str2 = this.mRightTxtZone1TextString;
            if (str2 != null) {
                textView5.setText(str2);
            }
            int i3 = this.mRightTxtZone1TxtColor;
            if (i3 != -1) {
                this.mRightTxtZone1Text.setTextColor(i3);
            } else {
                this.mRightTxtZone1Text.setTextColor(getResources().getColorStateList(com.baidu.android.common.ui.R.color.action_bar_operation_btn_selector));
            }
            this.mRightTxtZone1Progress = (ProgressBar) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_txtzone1_progress);
            this.mRightImgZone2Image = (BdBaseImageView) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_imgzone2_img);
            this.mRightImgZone2Tips = (BdBaseImageView) findViewById(com.baidu.android.common.ui.R.id.new_tip_img);
            View findViewById3 = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_imgzone2);
            this.mRightImgZone2 = findViewById3;
            findViewById3.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone2Visibility]);
            this.mRightImgZone1Image = (BdBaseImageView) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_imgzone1_img);
            View findViewById4 = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_imgzone1);
            this.mRightImgZone1 = findViewById4;
            findViewById4.setVisibility(VISIBILITY_FLAGS[this.mRightImgZone1Visibility]);
            View findViewById5 = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_zones);
            this.mRightZones = findViewById5;
            findViewById5.setVisibility(VISIBILITY_FLAGS[this.mRightZonesVisibility]);
            this.mLeftZones = findViewById(com.baidu.android.common.ui.R.id.titlebar_left_zones);
            this.mRightImgZone2Notify = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_imgzone2_notify);
            this.mRightMenu = findViewById(com.baidu.android.common.ui.R.id.titlebar_right_menu);
            this.mRightMenuImageView = (ImageView) findViewById(com.baidu.android.common.ui.R.id.titlebar_right_menu_img);
            this.mRightMenu.setOnClickListener(this.mOnClickListener);
            setTitleAlignment(1);
            setTitle(this.mTitleText);
            setTitleColor(com.baidu.android.common.ui.R.color.GC1);
            setRightMenuImageSrc(com.baidu.android.common.ui.R.drawable.action_bar_menu_normal_selector);
            setRightImgZone2Src(com.baidu.android.common.ui.R.drawable.action_bar_add_bookmark_selector);
            setRightImgZone1Src(com.baidu.android.common.ui.R.drawable.action_bar_add_bookmarkdir_selector);
            setOnTouchListener(new View.OnTouchListener(this, new GestureDetector(getContext(), new GestureListener())) { // from class: com.baidu.searchbox.ui.BdActionBar.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdActionBar this$0;
                public final /* synthetic */ GestureDetector val$gestureDetector;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$gestureDetector = r7;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? this.val$gestureDetector.onTouchEvent(motionEvent) : invokeLL.booleanValue;
                }
            });
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, context, attributeSet) == null) || attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.BdActionBar, 0, 0);
        try {
            this.mTitleText = obtainStyledAttributes.getString(com.baidu.android.common.ui.R.styleable.BdActionBar_titleText);
            this.mTitleTxtShadowColor = obtainStyledAttributes.getColor(com.baidu.android.common.ui.R.styleable.BdActionBar_titleTxtShadowColor, -16777216);
            this.mTitleTxtShadowDx = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_titleTxtShadowDx, -1.0f);
            this.mTitleTxtShadowDy = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_titleTxtShadowDy, -1.0f);
            this.mTitleTxtShadowRadius = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_titleTxtShadowRadius, -1.0f);
            this.mRightTxtZone2Visibility = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1Visibility, 0);
            this.mRightTxtZone2TextString = obtainStyledAttributes.getString(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1Text);
            this.mRightTxtZone1Visibility = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1Visibility, 0);
            this.mRightTxtZone1TextString = obtainStyledAttributes.getString(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1Text);
            this.mRightImgZone2ImageSrc = obtainStyledAttributes.getDrawable(com.baidu.android.common.ui.R.styleable.BdActionBar_rightImgZone2ImageSrc);
            this.mRightZonesVisibility = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_rightZonesVisibility, 0);
            this.mRightImgZone1ImageSrc = obtainStyledAttributes.getDrawable(com.baidu.android.common.ui.R.styleable.BdActionBar_rightImgZone1ImageSrc);
            this.mRightImgZone1Visibility = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_rightImgZone1Visibility, 0);
            this.mRightImgZone2Visibility = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_rightImgZone2Visibility, 0);
            this.mRightTxtZone1TxtColor = obtainStyledAttributes.getColor(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtColor, getResources().getColor(com.baidu.android.common.ui.R.color.action_bar_operation_btn_txt_color));
            this.mRightTxtZone1TxtSize = obtainStyledAttributes.getDimension(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtSize, -1.0f);
            this.mRightTxtZone1TxtShadowColor = obtainStyledAttributes.getColor(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtShadowColor, -16777216);
            this.mRightTxtZone1TxtShadowDx = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtShadowDx, -1.0f);
            this.mRightTxtZone1TxtShadowDy = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtShadowDy, -1.0f);
            this.mRightTxtZone1TxtShadowRadius = obtainStyledAttributes.getFloat(com.baidu.android.common.ui.R.styleable.BdActionBar_rightTxtZone1TxtShadowRadius, -1.0f);
            this.mTitleAlignment = obtainStyledAttributes.getInt(com.baidu.android.common.ui.R.styleable.BdActionBar_titleAlignment, 1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            if (this.mMenu == null) {
                CommonOverflowMenu commonOverflowMenu = new CommonOverflowMenu(this);
                this.mMenu = commonOverflowMenu;
                commonOverflowMenu.setMenuItemClickListener(this.mOnItemClickListener);
                this.mMenu.setMenuItemsUpdateListener(new BdMenu.OnMenuItemsUpdateListener(this) { // from class: com.baidu.searchbox.ui.BdActionBar.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdActionBar this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuItemsUpdateListener
                    public void onMenuItemUpdated(List<BdMenuItem> list) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) || this.this$0.mMenuItemsUpdateListener == null) {
                            return;
                        }
                        this.this$0.mMenuItemsUpdateListener.onMenuItemUpdated(list);
                    }
                });
            }
            this.mRightZones.setVisibility(8);
            this.mRightMenu.setVisibility(0);
        }
    }

    private void resetCenterTextViewPadding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
        }
    }

    private void setActionBarHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = i2;
            setLayoutParams(layoutParams);
        }
    }

    public BdActionBar add(int i2, CharSequence charSequence) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, charSequence)) == null) {
            initMenu();
            this.mMenu.add(i2, charSequence);
            return this;
        }
        return (BdActionBar) invokeIL.objValue;
    }

    public BdActionBar addMenuItem(BdMenuItem bdMenuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdMenuItem)) == null) {
            initMenu();
            this.mMenu.addMenuItem(bdMenuItem);
            return this;
        }
        return (BdActionBar) invokeL.objValue;
    }

    public void applyServerConfig(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 == Integer.MAX_VALUE) {
            return;
        }
        if (BarSwitches.getActionBarSwitch(i2)) {
            setVisibility(0);
            if (BarSwitches.getMenuSwitch(i2)) {
                this.mRightMenu.setVisibility(0);
            } else {
                this.mRightMenu.setVisibility(8);
            }
            if (BarSwitches.getTitleSwitch(i2)) {
                this.mTitleViewCenter.setVisibility(0);
                return;
            } else {
                this.mTitleViewCenter.setVisibility(4);
                return;
            }
        }
        setVisibility(8);
    }

    public void dismissMenu() {
        CommonOverflowMenu commonOverflowMenu;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (commonOverflowMenu = this.mMenu) == null) {
            return;
        }
        commonOverflowMenu.dismiss();
    }

    public BdMenuItem findItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            CommonOverflowMenu commonOverflowMenu = this.mMenu;
            if (commonOverflowMenu == null) {
                return null;
            }
            return commonOverflowMenu.findItem(i2);
        }
        return (BdMenuItem) invokeI.objValue;
    }

    public int findItemIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            CommonOverflowMenu commonOverflowMenu = this.mMenu;
            if (commonOverflowMenu == null) {
                return -1;
            }
            return commonOverflowMenu.findItemIndex(i2);
        }
        return invokeI.intValue;
    }

    public View getLeftFirstView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mLeftFirstView : (View) invokeV.objValue;
    }

    public View getRightImgZone1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRightImgZone1 : (View) invokeV.objValue;
    }

    public int getRightImgZone1ImageSrcId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mRightImgZone1ImageSrcId : invokeV.intValue;
    }

    public View getRightImgZone2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRightImgZone2 : (View) invokeV.objValue;
    }

    public View getRightImgZone2Image() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRightImgZone2Image : (View) invokeV.objValue;
    }

    public int getRightImgZone2ImageSrcId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mRightImgZone2ImageSrcId : invokeV.intValue;
    }

    public int getRightImgZone2NotifyVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mRightImgZone2Notify.getVisibility() : invokeV.intValue;
    }

    public View getRightMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mRightMenu : (View) invokeV.objValue;
    }

    public int getRightMenuImageViewSrcId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mRightMenuImageViewSrcId : invokeV.intValue;
    }

    public View getRightTxtView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRightTxtZone1Text : (View) invokeV.objValue;
    }

    public int getRightTxtZone1ProgressVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mRightTxtZone1Progress.getVisibility() : invokeV.intValue;
    }

    public int getRightTxtZone1Visibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mRightTxtZone1.getVisibility() : invokeV.intValue;
    }

    public int getRightTxtZone2Visibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mRightTxtZone2.getVisibility() : invokeV.intValue;
    }

    public String getSubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mSubTitleText : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mTitleText : (String) invokeV.objValue;
    }

    public int getTitleColorId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mTitleColorId : invokeV.intValue;
    }

    public void hideRightTxtZone1Progress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mRightTxtZone1Text.setVisibility(0);
            this.mRightTxtZone1Progress.setVisibility(4);
            this.mRightTxtZone1.setClickable(true);
            invalidate();
        }
    }

    public boolean isLeftZoneImageSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mLeftFirstView.isSelected() : invokeV.booleanValue;
    }

    public boolean isRightImgZone1Visible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mRightImgZone1.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isRightMeuVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mRightMenu.getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isRightZone2Visible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mRightImgZone2.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void notifyMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdMenuItem) == null) {
            this.mMenu.notifyMenuItemUpdated(bdMenuItem);
        }
    }

    public void notifyMenuSetChanged() {
        CommonOverflowMenu commonOverflowMenu;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (commonOverflowMenu = this.mMenu) == null) {
            return;
        }
        commonOverflowMenu.notifyMenuSetChanged();
    }

    public BdActionBar removeItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            CommonOverflowMenu commonOverflowMenu = this.mMenu;
            if (commonOverflowMenu != null) {
                commonOverflowMenu.removeItem(i2);
            }
            return this;
        }
        return (BdActionBar) invokeI.objValue;
    }

    public void setImgZoneBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.mLeftFirstView.setBackground(getResources().getDrawable(i2));
            this.mRightImgZone1.setBackground(getResources().getDrawable(i2));
            this.mRightImgZone2.setBackground(getResources().getDrawable(i2));
            this.mLeftSecondView.setBackground(getResources().getDrawable(i2));
        }
    }

    public void setLeftFirstViewSelector(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, colorStateList) == null) || (textView = this.mLeftFirstView) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setLeftFirstViewVisibility(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (textView = this.mLeftFirstView) == null) {
            return;
        }
        if (z) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
        }
    }

    public void setLeftSecondViewClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onClickListener) == null) {
            this.mLeftSecondView.setOnClickListener(onClickListener);
        }
    }

    public void setLeftSecondViewImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
            this.mLeftSecondView.setSelected(false);
        }
    }

    public void setLeftSecondViewImageSrcPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.mLeftSecondView.setCompoundDrawablePadding(i2);
        }
    }

    public void setLeftSecondViewText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setText(str);
        }
    }

    public void setLeftSecondViewTextSize(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048618, this, i2) == null) && this.mLeftSecondView.getVisibility() == 0) {
            this.mLeftSecondView.setTextSize(i2);
        }
    }

    public void setLeftSecondViewVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i2) == null) || this.mLeftSecondView.getVisibility() == i2) {
            return;
        }
        this.mLeftSecondView.setVisibility(i2);
        resetCenterTextViewPadding(this.mTitleText);
    }

    public void setLeftTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.mLeftFirstView.setText(str);
        }
    }

    public void setLeftTitleInvalidate(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.mIsLeftTitleInvalidate = z;
        }
    }

    public void setLeftZoneImageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.mLeftFirstView.setSelected(z);
        }
    }

    public void setLeftZoneImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            this.mLeftFirstView.setCompoundDrawables(drawable, null, null, null);
            this.mLeftFirstView.setSelected(false);
        }
    }

    public void setLeftZoneImageSrcMinWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.mLeftFirstView.setMinimumWidth(i2);
        }
    }

    public void setLeftZoneImageSrcPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.mLeftFirstView.setCompoundDrawablePadding(i2);
        }
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onClickListener) == null) {
            this.mLeftFirstView.setOnClickListener(onClickListener);
        }
    }

    public void setLeftZonesVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.mLeftZones.setVisibility(i2);
        }
    }

    public void setOnDoubleClickListener(OnDoubleClickListener onDoubleClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onDoubleClickListener) == null) {
            this.mDoubleClickListener = onDoubleClickListener;
        }
    }

    public void setOnMenuItemClickListener(BdMenuItem.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onItemClickListener) == null) {
            this.mOnItemClickListener = onItemClickListener;
            CommonOverflowMenu commonOverflowMenu = this.mMenu;
            if (commonOverflowMenu != null) {
                commonOverflowMenu.setMenuItemClickListener(onItemClickListener);
            }
        }
    }

    public void setOnMenuItemsUpdateListener(BdMenu.OnMenuItemsUpdateListener onMenuItemsUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onMenuItemsUpdateListener) == null) {
            this.mMenuItemsUpdateListener = onMenuItemsUpdateListener;
        }
    }

    public void setRightImageZone1Params(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048632, this, i2, i3) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone1.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.mRightImgZone1.setLayoutParams(layoutParams);
        }
    }

    public void setRightImgZone1ContentDes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.mRightImgZone1.setContentDescription(str);
        }
    }

    public void setRightImgZone1Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.mRightImgZone1.setEnabled(z);
        }
    }

    public void setRightImgZone1ImageScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, scaleType) == null) {
            this.mRightImgZone1Image.setScaleType(scaleType);
        }
    }

    public void setRightImgZone1ImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.mRightImgZone1ImageSrcId = i2;
            setRightImgZone1ImageSrc(getResources().getDrawable(i2));
        }
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.mRightImgZone1.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone1Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.mRightImgZone1ImageSrcId = i2;
            this.mRightImgZone1Image.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRightImgZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            this.mRightImgZone1.setVisibility(i2);
        }
    }

    public void setRightImgZone2ContentDes(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.mRightImgZone2.setContentDescription(str);
        }
    }

    public void setRightImgZone2Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.mRightImgZone2Image.setEnabled(z);
            this.mRightImgZone2.setEnabled(z);
        }
    }

    public void setRightImgZone2ImageScaleType(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, scaleType) == null) {
            this.mRightImgZone2Image.setScaleType(scaleType);
        }
    }

    public void setRightImgZone2ImageSrc(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, drawable) == null) {
            this.mRightImgZone2ImageSrc = drawable;
            this.mRightImgZone2Image.setImageDrawable(drawable);
        }
    }

    public void setRightImgZone2ImgWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRightImgZone2Image.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i2;
            this.mRightImgZone2Image.setLayoutParams(layoutParams);
        }
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.mRightImgZone2Notify.setVisibility(i2);
        }
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, onClickListener) == null) {
            this.mRightImgZone2.setOnClickListener(onClickListener);
        }
    }

    public void setRightImgZone2Params(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048649, this, i2, i3, i4) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRightImgZone2Image.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i3;
            layoutParams.bottomMargin = i4;
            layoutParams.topMargin = i4;
            this.mRightImgZone2Image.setLayoutParams(layoutParams);
        }
    }

    public void setRightImgZone2Src(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.mRightImgZone2ImageSrcId = i2;
            this.mRightImgZone2Image.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRightImgZone2Url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, str) == null) {
            this.mRightImgZone2Image.setImageURI(Uri.parse(str));
        }
    }

    public void setRightImgZone2Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            this.mRightImgZone2.setVisibility(i2);
        }
    }

    public void setRightImgZone2Width(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRightImgZone2.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.gravity = 16;
            this.mRightImgZone2.setLayoutParams(layoutParams);
        }
    }

    public void setRightMenuClickListner(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onClickListener) == null) {
            this.mRightMenu.setOnClickListener(onClickListener);
        }
    }

    public void setRightMenuImageSrc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.mRightMenuImageViewSrcId = i2;
            this.mRightMenuImageView.setImageDrawable(getResources().getDrawable(i2));
        }
    }

    public void setRightMenuVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            this.mRightMenu.setVisibility(i2);
        }
    }

    public void setRightTipsStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z) == null) {
            this.mRightImgZone2Tips.setVisibility(z ? 0 : 8);
        }
    }

    public void setRightTxt1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, onClickListener) == null) {
            this.mRightTxtZone1Text.setOnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone1Background(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.mRightTxtZone1.setBackgroundResource(i2);
        }
    }

    public void setRightTxtZone1Clickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.mRightTxtZone1.setClickable(z);
            this.mRightTxtZone1Text.setEnabled(z);
        }
    }

    public void setRightTxtZone1Enable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
            this.mRightTxtZone1.setEnabled(z);
        }
    }

    public void setRightTxtZone1OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, onClickListener) == null) {
            this.mRightTxtZone1.setOnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone1Text(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i2) == null) {
            this.mRightTxtZone1Text.setText(i2);
        }
    }

    public void setRightTxtZone1TextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.mRightTxtZone1Text.setTextColor(i2);
        }
    }

    public void setRightTxtZone1TextColorList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, colorStateList) == null) {
            this.mRightTxtZone1Text.setTextColor(colorStateList);
        }
    }

    public void setRightTxtZone1TextSelector(ColorStateList colorStateList) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048667, this, colorStateList) == null) || (textView = this.mRightTxtZone1Text) == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setRightTxtZone1TextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
            this.mRightTxtZone1Text.setTextSize(0, i2);
        }
    }

    public void setRightTxtZone1Typeface(Typeface typeface, int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048669, this, typeface, i2) == null) || (textView = this.mRightTxtZone1Text) == null) {
            return;
        }
        textView.setTypeface(typeface, i2);
    }

    public void setRightTxtZone1Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i2) == null) {
            if (i2 == 0) {
                this.mRightZones.setVisibility(0);
            }
            this.mRightTxtZone1.setVisibility(i2);
        }
    }

    public void setRightTxtZone2OnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, onClickListener) == null) {
            this.mRightTxtZone2.setOnClickListener(onClickListener);
        }
    }

    public void setRightTxtZone2Text(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i2) == null) {
            this.mRightTxtZone2Text.setText(i2);
        }
    }

    public void setRightTxtZone2TextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048673, this, i2) == null) {
            this.mRightTxtZone2Text.setTextColor(i2);
        }
    }

    public void setRightTxtZone2TextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048674, this, i2) == null) {
            this.mRightTxtZone2Text.setTextSize(0, i2);
        }
    }

    public void setRightTxtZone2Visibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            if (i2 == 0) {
                this.mRightZones.setVisibility(0);
            }
            this.mRightTxtZone2.setVisibility(i2);
        }
    }

    public void setRightZone2ImageVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048676, this, i2) == null) {
            this.mRightImgZone2Image.setVisibility(i2);
        }
    }

    public void setRightZonesVisibility(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048677, this, i2) == null) || (view = this.mRightZones) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            this.mSubTitleText = str;
            if (TextUtils.isEmpty(str)) {
                this.mSubTitleViewCenter.setVisibility(8);
            } else {
                this.mSubTitleViewCenter.setVisibility(0);
            }
            int i2 = this.mTitleAlignment;
            if (1 == i2) {
                this.mSubTitleViewCenter.setText(str);
            } else if (i2 == 0) {
                this.mSubTitleViewCenter.setText((CharSequence) null);
            }
            invalidate();
        }
    }

    public void setSubTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i2) == null) {
            this.mSubTitleViewCenter.setTextColor(i2);
        }
    }

    public void setTemplate(ActionbarTemplate actionbarTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, actionbarTemplate) == null) || actionbarTemplate == null) {
            return;
        }
        int i2 = AnonymousClass4.$SwitchMap$com$baidu$searchbox$ui$BdActionBar$ActionbarTemplate[actionbarTemplate.ordinal()];
        if (i2 == 1) {
            setTitleColor(com.baidu.android.common.ui.R.color.white_text);
            setRightMenuImageSrc(com.baidu.android.common.ui.R.drawable.action_bar_menu_normal_selector);
        } else if (i2 != 2) {
        } else {
            setTitleColor(com.baidu.android.common.ui.R.color.GC1);
            setRightMenuImageSrc(com.baidu.android.common.ui.R.drawable.action_bar_black_menu_normal_selector);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            this.mTitleText = str;
            int i2 = this.mTitleAlignment;
            if (1 == i2) {
                this.mTitleViewCenter.setText(str);
                if (this.mIsLeftTitleInvalidate) {
                    resetCenterTextViewPadding(str);
                } else {
                    this.mLeftFirstView.setText((CharSequence) null);
                }
            } else if (i2 == 0) {
                this.mLeftFirstView.setText(str);
                this.mTitleViewCenter.setText((CharSequence) null);
            }
            invalidate();
        }
    }

    public void setTitleAlignment(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            this.mTitleAlignment = i2;
            setTitle(this.mTitleText);
        }
    }

    public void setTitleBarTitleSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048685, this, f2) == null) {
            this.mTitleViewCenter.setTextSize(0, f2);
        }
    }

    public void setTitleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048686, this, i2) == null) {
            this.mTitleColorId = i2;
            this.mTitleViewCenter.setTextColor(getResources().getColor(i2));
        }
    }

    public void setTitlePadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048687, this, i2, i3, i4, i5) == null) {
            this.mLeftFirstView.setPadding(i2, i3, i4, i5);
        }
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2)}) == null) {
            this.mLeftFirstView.setShadowLayer(f2, f3, f4, i2);
            this.mTitleViewCenter.setShadowLayer(f2, f3, f4, i2);
        }
    }

    public void setTitleSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048689, this, i2) == null) {
            this.mLeftFirstView.setTextSize(0, i2);
        }
    }

    public void setTitleTypeface(Typeface typeface, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048690, this, typeface, i2) == null) {
            this.mTitleViewCenter.setTypeface(typeface, i2);
        }
    }

    public void setTxtZoneBackgroundMinimumHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i2) == null) {
            this.mRightTxtZone1.setMinimumHeight(i2);
        }
    }

    public void setTxtZoneBackgroundMinimumWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i2) == null) {
            this.mRightTxtZone1.setMinimumWidth(i2);
        }
    }

    public void setTxtZoneBackgroundResource(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            this.mRightTxtZone1.setBackground(getResources().getDrawable(i2));
            this.mRightTxtZone2.setBackground(getResources().getDrawable(i2));
        }
    }

    public void showRightTxtZone1Progress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            this.mRightTxtZone1Text.setVisibility(4);
            this.mRightTxtZone1Progress.setVisibility(0);
            this.mRightTxtZone1.setClickable(false);
            invalidate();
        }
    }

    public boolean toggleMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (this.mMenu != null) {
                int[] iArr = new int[2];
                this.mRightMenu.getLocationInWindow(iArr);
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.actionbar_menu_right_padding);
                int height = iArr[1] + this.mRightMenu.getHeight() + getContext().getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.actionbar_menu_top_padding);
                this.mMenu.getView().getWidth();
                this.mMenu.setShowAtLocation(0, (DeviceUtil.ScreenInfo.getDisplayWidth(getContext()) - dimensionPixelSize) - this.mMenu.getView().getWidth(), height);
                this.mMenu.toggle();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setRightTxtZone1Text(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, charSequence) == null) {
            this.mRightTxtZone1Text.setText(charSequence);
        }
    }

    public BdActionBar add(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            initMenu();
            this.mMenu.add(i2, i3);
            return this;
        }
        return (BdActionBar) invokeII.objValue;
    }

    public void setRightImgZone1ImageSrc(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, drawable) == null) {
            this.mRightImgZone1ImageSrc = drawable;
            this.mRightImgZone1Image.setImageDrawable(drawable);
        }
    }

    public void setLeftFirstViewVisibility(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (textView = this.mLeftFirstView) == null) {
            return;
        }
        textView.setVisibility(i2);
    }

    public BdActionBar add(int i2, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, charSequence, drawable)) == null) {
            initMenu();
            this.mMenu.add(i2, charSequence, drawable);
            return this;
        }
        return (BdActionBar) invokeILL.objValue;
    }

    public void setLeftSecondViewImageSrc(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048615, this, i2, i3, i4) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, i3, i4);
            }
            this.mLeftSecondView.setCompoundDrawables(drawable, null, null, null);
            this.mLeftSecondView.setSelected(false);
        }
    }

    public void setLeftZoneImageSrc(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048624, this, i2, i3, i4) == null) {
            Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, i3, i4);
            }
            this.mLeftFirstView.setCompoundDrawables(drawable, null, null, null);
            this.mLeftFirstView.setSelected(false);
        }
    }

    public void setRightImageZone1Params(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, layoutParams) == null) {
            this.mRightImgZone1.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.BdActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.this$0.toggleMenu();
                }
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        initAttrs(context, attributeSet);
        init();
    }

    public BdActionBar add(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4)) == null) {
            initMenu();
            this.mMenu.add(i2, i3, i4);
            return this;
        }
        return (BdActionBar) invokeIII.objValue;
    }

    public void setSubTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            setSubTitle(getResources().getString(i2));
        }
    }

    public void setTitle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i2) == null) {
            setTitle(getResources().getString(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mRightTxtZone1TxtColor = -1;
        this.mRightTxtZone1TxtSize = -1.0f;
        this.mOnClickListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.ui.BdActionBar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdActionBar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.this$0.toggleMenu();
                }
            }
        };
        this.mRightTxtZone2TxtColor = -1;
        initAttrs(context, attributeSet);
        init();
    }
}
