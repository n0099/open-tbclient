package com.baidu.searchbox.ui.bubble.views;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.CustomLinkByEllipsize;
import com.baidu.searchbox.ui.CustomLinkMovementMethod;
import com.baidu.searchbox.ui.bubble.ArrowView;
import com.baidu.searchbox.ui.bubble.BubbleHistory;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.shadow.MaskViewGroup;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleBaseView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleViews";
    public transient /* synthetic */ FieldHolder $fh;
    public View mAnchorLayer;
    public View mAnchorView;
    public ArrowView mArrowDown;
    public ArrowView mArrowLeft;
    public ArrowView mArrowRight;
    public ArrowView mArrowUp;
    @ColorInt
    public int mBgColorDay;
    @ColorInt
    public int mBgColorNight;
    public View mBgView;
    public ArrowView mBubbleArrow;
    public ViewGroup mBubbleContent;
    public TextView mBubbleText;
    public View mBubbleView;
    public ViewGroup mRootView;
    public MaskViewGroup mShadow;
    public CustomLinkByEllipsize mTvEllipse;

    /* renamed from: com.baidu.searchbox.ui.bubble.views.BubbleBaseView$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1735879048, "Lcom/baidu/searchbox/ui/bubble/views/BubbleBaseView$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1735879048, "Lcom/baidu/searchbox/ui/bubble/views/BubbleBaseView$2;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition = iArr;
            try {
                iArr[BubblePosition.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public BubbleBaseView() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBgColorDay = -1;
        this.mBgColorNight = -1;
    }

    public void checkSafe(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
        BubbleHistory.getInstance().trackBubbleOpHistory("——>checkSafe remove view end");
    }

    public void dismissAllArrowView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mArrowUp.setVisibility(8);
            this.mArrowDown.setVisibility(8);
            this.mArrowLeft.setVisibility(8);
            this.mArrowRight.setVisibility(8);
        }
    }

    public String getAnchorViewName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View view = this.mAnchorView;
            return view != null ? view.getClass().getSimpleName() : "NULL";
        }
        return (String) invokeV.objValue;
    }

    public int getBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (NightModeHelper.getNightModeSwitcherState()) {
                int i2 = this.mBgColorNight;
                if (i2 != -1) {
                    return i2;
                }
            } else {
                int i3 = this.mBgColorDay;
                if (i3 != -1) {
                    return i3;
                }
            }
            return AppRuntime.getAppContext().getResources().getColor(R.color.UC29);
        }
        return invokeV.intValue;
    }

    public int getBgColorDay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBgColorDay : invokeV.intValue;
    }

    public int getBgColorNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBgColorNight : invokeV.intValue;
    }

    public int getBubbleViewResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? R.layout.bubble_tip : invokeV.intValue;
    }

    public void initLinkBubble() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            this.mBubbleText.setLinkTextColor(resources.getColorStateList(R.color.home_tab_bubble_tips_text_color));
            this.mBubbleText.setHighlightColor(0);
            CustomLinkMovementMethod customLinkMovementMethod = new CustomLinkMovementMethod();
            customLinkMovementMethod.setLinkMovementListener(new CustomLinkMovementMethod.OnLinkMovementListener(this, resources) { // from class: com.baidu.searchbox.ui.bubble.views.BubbleBaseView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BubbleBaseView this$0;
                public final /* synthetic */ Resources val$res;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, resources};
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
                    this.val$res = resources;
                }

                @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
                public void onLinkTouch(TextView textView, MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, textView, motionEvent) == null) {
                    }
                }

                @Override // com.baidu.searchbox.ui.CustomLinkMovementMethod.OnLinkMovementListener
                public void onNoLinkTouch(TextView textView, MotionEvent motionEvent) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, motionEvent) == null) {
                        if (motionEvent.getAction() == 0) {
                            this.this$0.mBubbleText.setLinkTextColor(this.val$res.getColor(R.color.bubble_link_text_color));
                        } else {
                            this.this$0.mBubbleText.setLinkTextColor(this.val$res.getColorStateList(R.color.home_tab_bubble_tips_text_color));
                        }
                    }
                }
            });
            this.mBubbleText.setMovementMethod(customLinkMovementMethod);
            if (this.mTvEllipse == null) {
                this.mTvEllipse = new CustomLinkByEllipsize(this.mBubbleText);
            }
            this.mBubbleText.getViewTreeObserver().addOnGlobalLayoutListener(this.mTvEllipse);
        }
    }

    public boolean initViewIfNeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mBubbleView == null) {
                View inflate = LayoutInflater.from(this.mAnchorView.getContext()).inflate(getBubbleViewResId(), this.mRootView, false);
                this.mBubbleView = inflate;
                inflate.setVisibility(4);
                this.mBubbleContent = (ViewGroup) this.mBubbleView.findViewById(R.id.bubble_content);
                this.mShadow = (MaskViewGroup) this.mBubbleView.findViewById(R.id.shadowLayout);
                this.mArrowUp = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_up);
                this.mArrowDown = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_down);
                this.mArrowLeft = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_left);
                this.mArrowRight = (ArrowView) this.mBubbleView.findViewById(R.id.bubble_arrow_right);
                int bgColor = getBgColor();
                if (this.mShadow != null) {
                    if (NightModeHelper.getNightModeSwitcherState()) {
                        this.mShadow.setDrawShadow(false);
                    } else {
                        this.mShadow.setShadowColor(bgColor);
                    }
                }
                if (this.mBubbleContent.getBackground() instanceof GradientDrawable) {
                    ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(bgColor);
                }
                this.mBubbleContent.setVisibility(4);
                this.mArrowUp.setArrowViewColor(bgColor);
                this.mArrowDown.setArrowViewColor(bgColor);
                this.mArrowLeft.setArrowViewColor(bgColor);
                this.mArrowRight.setArrowViewColor(bgColor);
                View view = new View(this.mAnchorView.getContext());
                this.mBgView = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.mBgView.setVisibility(4);
                this.mAnchorLayer = new View(this.mAnchorView.getContext());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isValidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.mAnchorView == null || this.mRootView == null) ? false : true : invokeV.booleanValue;
    }

    public boolean isViewsValidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.mAnchorView == null || this.mRootView == null || this.mBubbleView == null) ? false : true : invokeV.booleanValue;
    }

    public void postAnchorView(Runnable runnable) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, runnable) == null) || (view = this.mAnchorView) == null) {
            return;
        }
        view.post(runnable);
    }

    public void removeAnchorView() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (viewGroup = this.mRootView) == null || this.mBubbleView == null || this.mBgView == null) {
            return;
        }
        viewGroup.removeView(this.mAnchorLayer);
    }

    public void removeBGView() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (viewGroup = this.mRootView) == null || this.mBubbleView == null || (view = this.mBgView) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void removemBubbleView() {
        ViewGroup viewGroup;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (viewGroup = this.mRootView) == null || (view = this.mBubbleView) == null || this.mBgView == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void resetAll() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.mTvEllipse != null && (textView = this.mBubbleText) != null) {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mTvEllipse);
                this.mTvEllipse = null;
            }
            this.mRootView = null;
            this.mBubbleView = null;
            this.mBubbleContent = null;
            this.mBubbleArrow = null;
            this.mBubbleText = null;
            this.mAnchorView = null;
            this.mArrowUp = null;
            this.mArrowDown = null;
            this.mBgView = null;
            this.mAnchorLayer = null;
            this.mShadow = null;
        }
    }

    public void resetAnchorParams() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (view = this.mAnchorLayer) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        this.mAnchorLayer.setLayoutParams(layoutParams);
    }

    public void safeAddAnchorView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.mAnchorLayer == null) {
            return;
        }
        BubbleHistory.getInstance().trackBubbleOpHistory("——>checksafe anchor layer begin");
        checkSafe(this.mAnchorLayer);
        BubbleHistory.getInstance().trackBubbleOpHistory("——>checksafe anchor layer end");
        this.mRootView.addView(this.mAnchorLayer);
    }

    public void safeAddBGView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.mBgView == null) {
            return;
        }
        BubbleHistory.getInstance().trackBubbleOpHistory("——>check bg view begin");
        checkSafe(this.mBgView);
        BubbleHistory.getInstance().trackBubbleOpHistory("——>check bg view end");
        this.mRootView.addView(this.mBgView);
    }

    public void safeAddBubbleView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.mBubbleView == null) {
            return;
        }
        BubbleHistory.getInstance().trackBubbleOpHistory("——>check bubble view begin");
        checkSafe(this.mBubbleView);
        BubbleHistory.getInstance().trackBubbleOpHistory("——>check bubble view end");
        this.mBubbleView.setVisibility(4);
        this.mRootView.addView(this.mBubbleView);
    }

    public void setAnchor(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            if (view != null) {
                this.mAnchorView = view;
                if (view != null) {
                    this.mRootView = (ViewGroup) view.getRootView().findViewById(16908290);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("anchor view must not be null !!!");
        }
    }

    public void setAnchorAndRootView(View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, view, viewGroup) == null) {
            if (view != null) {
                this.mAnchorView = view;
                this.mRootView = viewGroup;
                if (viewGroup != null || view == null) {
                    return;
                }
                ViewGroup viewGroup2 = (ViewGroup) view.getRootView().findViewById(16908290);
                this.mRootView = viewGroup2;
                if (viewGroup2 == null) {
                    throw new IllegalArgumentException("root view must be a child of android.R.id.content");
                }
                return;
            }
            throw new IllegalArgumentException("anchor view must not be null !!!");
        }
    }

    public void setAnchorClick(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) || (view = this.mAnchorLayer) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setBGClick(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) || (view = this.mBgView) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setBubbleClick(View.OnClickListener onClickListener) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) || (view = this.mBubbleView) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public void setDayModeBackground(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mBgColorDay = i2;
        }
    }

    public void setNightModeBackground(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mBgColorNight = i2;
        }
    }

    public void showAnchorLayer() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (view = this.mAnchorLayer) == null || this.mAnchorView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = this.mAnchorView.getMeasuredWidth();
        layoutParams.height = this.mAnchorView.getMeasuredHeight();
        this.mAnchorLayer.setLayoutParams(layoutParams);
        int[] iArr = new int[2];
        this.mAnchorView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.mRootView.getLocationOnScreen(iArr2);
        this.mAnchorLayer.setX(iArr[0] - iArr2[0]);
        this.mAnchorLayer.setY(iArr[1] - iArr2[1]);
    }

    public void showArrowView(BubblePosition bubblePosition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bubblePosition) == null) {
            dismissAllArrowView();
            int i2 = AnonymousClass2.$SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[bubblePosition.ordinal()];
            if (i2 == 1) {
                this.mArrowUp.setDirection(2);
                ArrowView arrowView = this.mArrowUp;
                this.mBubbleArrow = arrowView;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin - ((int) arrowView.dpToPixel(1.0f)));
                    this.mBubbleArrow.setLayoutParams(marginLayoutParams);
                }
            } else if (i2 == 2) {
                this.mArrowDown.setDirection(4);
                this.mBubbleArrow = this.mArrowDown;
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.mArrowRight.setDirection(3);
                this.mBubbleArrow = this.mArrowRight;
            } else {
                this.mArrowLeft.setDirection(1);
                ArrowView arrowView2 = this.mArrowLeft;
                this.mBubbleArrow = arrowView2;
                if (Build.VERSION.SDK_INT <= 25) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mBubbleArrow.getLayoutParams();
                    marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin - ((int) arrowView2.dpToPixel(1.0f)), marginLayoutParams2.bottomMargin);
                    this.mBubbleArrow.setLayoutParams(marginLayoutParams2);
                }
            }
        }
    }

    public void showBubbleOnLocation(int[] iArr) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, iArr) == null) || (view = this.mBubbleView) == null) {
            return;
        }
        view.setX(iArr[0]);
        this.mBubbleView.setY(iArr[1]);
        this.mBubbleContent.setVisibility(0);
        this.mBubbleView.setVisibility(0);
        this.mBubbleArrow.setVisibility(0);
        this.mBgView.setVisibility(0);
        MaskViewGroup maskViewGroup = this.mShadow;
        if (maskViewGroup != null) {
            maskViewGroup.setVisibility(0);
        }
    }

    public void updateBubble(int i2, int i3) {
        ViewGroup viewGroup;
        ArrowView arrowView;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) || (viewGroup = this.mBubbleContent) == null || !(viewGroup.getBackground() instanceof GradientDrawable) || (arrowView = this.mBubbleArrow) == null || !(arrowView instanceof ArrowView) || (textView = this.mBubbleText) == null || textView.getVisibility() != 0 || TextUtils.isEmpty(this.mBubbleText.getText())) {
            return;
        }
        ((GradientDrawable) this.mBubbleContent.getBackground()).setColor(i2);
        this.mBubbleArrow.setArrowViewColor(i2);
        this.mBubbleText.setTextColor(i3);
    }
}
