package com.baidu.tbadk.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class NavigationBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View barBgView;
    public int containerWidth;
    public boolean isAutoNight;
    public boolean isFixedHeight;
    public boolean isNeedAddStatusBarHeight;
    public LinearLayout mAbsoluteCenterBox;
    public ImageView mBackImageView;
    public int mBackImagedeepResId;
    public int mBackImagelightResId;
    public View mBottomLine;
    public int mBottomLineColor;
    public LinearLayout mCenterBox;
    public ImageView mCenterIcon;
    public LinearLayout mCenterImgBox;
    public TextView mCenterText;
    public boolean mClickIsVaild;
    public FrameLayout mContentLayout;
    public Activity mCurrentActivity;
    public int mFixedNavHeight;
    public boolean mIsClose;
    public boolean mIsCorner;
    public LinearLayout mLeftBox;
    public View.OnClickListener mLoginListener;
    public TextView mLoginView;
    public ValueAnimator.AnimatorUpdateListener mNavAnimatorUpdateListener;
    public int mNavHeight;
    public ValueAnimator mNavInAnimator;
    public boolean mNavIsShow;
    public ValueAnimator mNavOutAnimator;
    public final View.OnClickListener mOnClickListener;
    public View.OnClickListener mRegisterListener;
    public TextView mRegisterView;
    public LinearLayout mRightBox;
    public View mRootView;
    public int mSpecialBackgroundBackupColorId;
    public Drawable mSpecialBackgroundDrawable;
    public Paint mSpecialBackgroundPaint;
    public View mStatusBarView;
    public TextView mTextTitle;
    public int mTopPadding;
    public View mUnloginView;
    public View topCoverBgView;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ControlAlign {
        public static final /* synthetic */ ControlAlign[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ControlAlign HORIZONTAL_ABSOLUTE_CENTER;
        public static final ControlAlign HORIZONTAL_CENTER;
        public static final ControlAlign HORIZONTAL_LEFT;
        public static final ControlAlign HORIZONTAL_RIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(384341041, "Lcom/baidu/tbadk/core/view/NavigationBar$ControlAlign;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(384341041, "Lcom/baidu/tbadk/core/view/NavigationBar$ControlAlign;");
                    return;
                }
            }
            HORIZONTAL_LEFT = new ControlAlign("HORIZONTAL_LEFT", 0);
            HORIZONTAL_CENTER = new ControlAlign("HORIZONTAL_CENTER", 1);
            HORIZONTAL_RIGHT = new ControlAlign("HORIZONTAL_RIGHT", 2);
            ControlAlign controlAlign = new ControlAlign("HORIZONTAL_ABSOLUTE_CENTER", 3);
            HORIZONTAL_ABSOLUTE_CENTER = controlAlign;
            $VALUES = new ControlAlign[]{HORIZONTAL_LEFT, HORIZONTAL_CENTER, HORIZONTAL_RIGHT, controlAlign};
        }

        public ControlAlign(String str, int i2) {
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

        public static ControlAlign valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ControlAlign) Enum.valueOf(ControlAlign.class, str) : (ControlAlign) invokeL.objValue;
        }

        public static ControlAlign[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ControlAlign[]) $VALUES.clone() : (ControlAlign[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class ControlType {
        public static final /* synthetic */ ControlType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ControlType BACK_BUTTON;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1970001542, "Lcom/baidu/tbadk/core/view/NavigationBar$ControlType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1970001542, "Lcom/baidu/tbadk/core/view/NavigationBar$ControlType;");
                    return;
                }
            }
            ControlType controlType = new ControlType("BACK_BUTTON", 0);
            BACK_BUTTON = controlType;
            $VALUES = new ControlType[]{controlType};
        }

        public ControlType(String str, int i2) {
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

        public static ControlType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ControlType) Enum.valueOf(ControlType.class, str) : (ControlType) invokeL.objValue;
        }

        public static ControlType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ControlType[]) $VALUES.clone() : (ControlType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBar f41671e;

        public a(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41671e = navigationBar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f41671e.mContentLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                    this.f41671e.mContentLayout.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBar f41672e;

        public b(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41672e = navigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBar f41673e;

        public c(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41673e = navigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f41673e.mClickIsVaild) {
                int id = view.getId();
                if (id == R.id.navigationBarGoBack) {
                    this.f41673e.mCurrentActivity.finish();
                } else if (id == R.id.navigationBarHome) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, this.f41673e.mCurrentActivity));
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBar f41674e;

        public d(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41674e = navigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f41674e.mNavIsShow = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NavigationBar f41675e;

        public e(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41675e = navigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f41675e.mNavIsShow = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.f41675e.mNavIsShow = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = m.f(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, null);
    }

    private View createStateBarFillView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            View view = new View(getContext());
            view.setId(R.id.navigation_bar_status_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight());
            layoutParams.addRule(10, -1);
            view.setLayoutParams(layoutParams);
            return view;
        }
        return (View) invokeV.objValue;
    }

    private View getViewFromLayoutFile(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) ? LayoutInflater.from(this.mCurrentActivity).inflate(i2, (ViewGroup) this, false) : (View) invokeI.objValue;
    }

    private void init(Context context, AttributeSet attributeSet) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, context, attributeSet) == null) {
            this.mFixedNavHeight = this.mNavHeight;
            this.mCurrentActivity = (Activity) context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.widget_navigation_bar, (ViewGroup) this, true);
            this.mRootView = inflate;
            this.mContentLayout = (FrameLayout) inflate.findViewById(R.id.navigation_bar_content_layout);
            this.mLeftBox = (LinearLayout) this.mRootView.findViewById(R.id.leftBox);
            this.mCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.centerBox);
            this.mRightBox = (LinearLayout) this.mRootView.findViewById(R.id.rightBox);
            this.mAbsoluteCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.absoluteCenterBox);
            this.mCenterImgBox = (LinearLayout) this.mRootView.findViewById(R.id.center_img_box);
            this.mCenterIcon = (ImageView) this.mRootView.findViewById(R.id.center_img);
            this.mCenterText = (TextView) this.mRootView.findViewById(R.id.center_text);
            this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
            View findViewById = this.mRootView.findViewById(R.id.navigation_bar_view_cover_bg);
            this.topCoverBgView = findViewById;
            boolean z2 = false;
            findViewById.setBackgroundDrawable(SkinManager.getDrawable(0, R.drawable.navigation_cover_top_bg));
            this.barBgView = this.mRootView.findViewById(R.id.navigation_bar_view_bg);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavigationBar);
                z = obtainStyledAttributes.getBoolean(R$styleable.NavigationBar_canSpread, true);
                obtainStyledAttributes.recycle();
            } else {
                z = true;
            }
            if (z && UtilHelper.canUseStyleImmersiveSticky()) {
                z2 = true;
            }
            this.isNeedAddStatusBarHeight = z2;
            if (z2) {
                View createStateBarFillView = createStateBarFillView();
                this.mStatusBarView = createStateBarFillView;
                addView(createStateBarFillView);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
                layoutParams.addRule(3, this.mStatusBarView.getId());
                this.mContentLayout.setLayoutParams(layoutParams);
                this.mFixedNavHeight += UtilHelper.getStatusBarHeight();
            }
            setGravity(48);
            initPadding();
            switchNaviBarStatus(true);
            this.mRootView.setOnClickListener(new b(this));
            this.mNavIsShow = true;
        }
    }

    private void initUnloginView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.mUnloginView == null) {
            View inflate = ((ViewStub) this.mRootView.findViewById(R.id.unlogin_view_stub)).inflate();
            this.mUnloginView = inflate;
            this.mRegisterView = (TextView) inflate.findViewById(R.id.top_navi_register);
            TextView textView = (TextView) this.mUnloginView.findViewById(R.id.top_navi_login);
            this.mLoginView = textView;
            textView.setOnClickListener(this.mLoginListener);
            this.mRegisterView.setOnClickListener(this.mRegisterListener);
        }
    }

    public TextView addCreateGroupButton(ControlAlign controlAlign, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, controlAlign, onClickListener)) == null) {
            TextView textView = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_create_group);
            if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(0, dimension, dimension, dimension);
                textView.setLayoutParams(layoutParams);
            }
            getViewGroup(controlAlign).addView(textView);
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            return textView;
        }
        return (TextView) invokeLL.objValue;
    }

    public View addCustomView(ControlAlign controlAlign, View view, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, controlAlign, view, onClickListener)) == null) {
            getViewGroup(controlAlign).addView(view);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            if (controlAlign == ControlAlign.HORIZONTAL_CENTER) {
            }
            return view;
        }
        return (View) invokeLLL.objValue;
    }

    public Button addRightButton(ControlAlign controlAlign, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, controlAlign, str)) == null) {
            Button button = (Button) getViewFromLayoutFile(R.layout.widget_nb_item_stepbtn);
            button.setText(str);
            if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) getResources().getDimension(R.dimen.ds16);
                layoutParams.setMargins(0, dimension, dimension, dimension);
                button.setLayoutParams(layoutParams);
            }
            getViewGroup(controlAlign).addView(button);
            return button;
        }
        return (Button) invokeLL.objValue;
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, controlAlign, controlType)) == null) ? addSystemImageButton(controlAlign, controlType, this.mOnClickListener) : (View) invokeLL.objValue;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, controlAlign, str)) == null) ? addTextButton(controlAlign, str, null) : (TextView) invokeLL.objValue;
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, controlAlign, str)) == null) {
            TextView addTextButton = addTextButton(controlAlign, str, null);
            setDefTextButtonColor(addTextButton);
            return addTextButton;
        }
        return (TextView) invokeLL.objValue;
    }

    public ImageView getBackImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mBackImageView : (ImageView) invokeV.objValue;
    }

    public View getBarBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.barBgView : (View) invokeV.objValue;
    }

    public View getBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mBottomLine : (View) invokeV.objValue;
    }

    public View getCenterImgBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mCenterIcon : (View) invokeV.objValue;
    }

    public View getCenterImgBoxLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mCenterImgBox : (View) invokeV.objValue;
    }

    public TextView getCenterText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mCenterText : (TextView) invokeV.objValue;
    }

    public CharSequence getCenterTextTitleText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mCenterText.getText() : (CharSequence) invokeV.objValue;
    }

    public FrameLayout getContentLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mContentLayout : (FrameLayout) invokeV.objValue;
    }

    public int getFixedNavHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mFixedNavHeight : invokeV.intValue;
    }

    public boolean getNavBarIsShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mNavIsShow : invokeV.booleanValue;
    }

    public View getTopCoverBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.topCoverBgView : (View) invokeV.objValue;
    }

    public ViewGroup getViewGroup(ControlAlign controlAlign) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, controlAlign)) == null) {
            if (controlAlign == ControlAlign.HORIZONTAL_LEFT) {
                return this.mLeftBox;
            }
            if (controlAlign == ControlAlign.HORIZONTAL_RIGHT) {
                return this.mRightBox;
            }
            if (controlAlign == ControlAlign.HORIZONTAL_ABSOLUTE_CENTER) {
                return this.mAbsoluteCenterBox;
            }
            return this.mCenterBox;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public void hideBottomLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mBottomLine.setVisibility(8);
        }
    }

    public void hideNavigationBarWithAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ValueAnimator valueAnimator = this.mNavOutAnimator;
            if (valueAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 0 - this.mFixedNavHeight);
                this.mNavOutAnimator = ofInt;
                ofInt.addUpdateListener(this.mNavAnimatorUpdateListener);
                this.mNavOutAnimator.addListener(new d(this));
                this.mNavOutAnimator.setDuration(300L);
                this.mNavOutAnimator.setInterpolator(new LinearInterpolator());
            } else if (valueAnimator.isRunning()) {
                return;
            } else {
                if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin < 0) {
                    return;
                }
            }
            this.mNavOutAnimator.start();
        }
    }

    public void initPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            setPadding(m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), this.mTopPadding, m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)));
        }
    }

    public boolean isAutoNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.isAutoNight : invokeV.booleanValue;
    }

    public boolean isFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.isFixedHeight : invokeV.booleanValue;
    }

    public boolean isNavigationBarExcludeStatusbarVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mLeftBox.getVisibility() == 0 || this.mCenterBox.getVisibility() == 0 || this.mRightBox.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void isShowBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mBottomLine.setVisibility(z ? 0 : 8);
        }
    }

    public void onBackBtnOnChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            onBackBtnOnChangeSkin(-1);
        }
    }

    public void onCenterTextOnChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            if (i2 < 0) {
                i2 = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setViewTextColor(this.mCenterText, R.color.CAM_X0105, 1, i2);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(f<?> fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, fVar, i2) == null) {
            if (this.mIsCorner) {
                c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this);
                d2.m(1);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0208);
            } else {
                SkinManager.setBackgroundColor(this, R.color.CAM_X0208, i2);
            }
            SkinManager.setBackgroundColor(this.mBottomLine, this.mBottomLineColor, i2);
            onBackBtnOnChangeSkin(i2);
            SkinManager.setNavbarTitleColor(this.mTextTitle, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setNavbarTitleColor(this.mCenterText, R.color.CAM_X0105, R.color.s_navbar_title_color);
            TextView textView = this.mRegisterView;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106, 1);
            }
            TextView textView2 = this.mLoginView;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0106, 1);
            }
            initPadding();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(i2 == 1);
                tbPageContext.getLayoutMode().j(this);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, canvas) == null) {
            super.onDraw(canvas);
            Drawable drawable = this.mSpecialBackgroundDrawable;
            if (drawable != null) {
                int measuredHeight = getMeasuredHeight() - ((int) ((drawable.getIntrinsicHeight() / this.mSpecialBackgroundDrawable.getIntrinsicWidth()) * getWidth()));
                this.mSpecialBackgroundDrawable.setBounds(0, measuredHeight, getMeasuredWidth(), getMeasuredHeight());
                this.mSpecialBackgroundDrawable.draw(canvas);
                if (measuredHeight > 0) {
                    if (this.mSpecialBackgroundPaint == null) {
                        Paint paint = new Paint();
                        this.mSpecialBackgroundPaint = paint;
                        paint.setColor(SkinManager.getColor(this.mSpecialBackgroundBackupColorId));
                    }
                    canvas.drawRect(0.0f, 0.0f, getWidth(), measuredHeight, this.mSpecialBackgroundPaint);
                }
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
            int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
            LinearLayout linearLayout = this.mCenterBox;
            linearLayout.layout(measuredWidth, linearLayout.getTop(), this.containerWidth - measuredWidth2, this.mCenterBox.getBottom());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        View view;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i2, i3) == null) {
            if (this.isFixedHeight) {
                int mode = View.MeasureSpec.getMode(i3);
                int i6 = this.mNavHeight;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
                if (Math.abs(layoutParams.topMargin) > this.mContentLayout.getHeight()) {
                    if (layoutParams.topMargin >= 0) {
                        i4 = this.mContentLayout.getHeight();
                    } else {
                        i5 = i6 - this.mContentLayout.getHeight();
                        i3 = View.MeasureSpec.makeMeasureSpec(i5, mode);
                    }
                } else {
                    i4 = layoutParams.topMargin;
                }
                i5 = i6 + i4;
                i3 = View.MeasureSpec.makeMeasureSpec(i5, mode);
            }
            if (this.isNeedAddStatusBarHeight && (view = this.mStatusBarView) != null && view.getVisibility() == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) + UtilHelper.getStatusBarHeight(), View.MeasureSpec.getMode(i3));
            }
            super.onMeasure(i2, i3);
            this.containerWidth = View.MeasureSpec.getSize(i2);
            int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
            int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
            LinearLayout linearLayout = this.mCenterBox;
            linearLayout.measure(((this.containerWidth - measuredWidth) - measuredWidth2) + 1073741824, linearLayout.getMeasuredHeight() + 1073741824);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeAllViews();
        }
    }

    public void removeAllViews(ControlAlign controlAlign) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, controlAlign) == null) {
            getViewGroup(controlAlign).removeAllViews();
        }
    }

    public void setAutoNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.isAutoNight = z;
        }
    }

    public void setBottomLineColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.mBottomLineColor = i2;
        }
    }

    public void setBottomLineHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.mBottomLine.getLayoutParams().height = i2;
            requestLayout();
        }
    }

    public TextView setCenterTextTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            if (str != null) {
                this.mCenterText.setText(str);
                this.mCenterText.setVisibility(0);
                this.mCenterIcon.setVisibility(8);
            } else {
                this.mCenterText.setVisibility(8);
                this.mCenterIcon.setVisibility(0);
            }
            return this.mCenterText;
        }
        return (TextView) invokeL.objValue;
    }

    public void setContentPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.mContentLayout.setPadding(m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), i2, m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)), m.d(this.mCurrentActivity, getResources().getDimension(R.dimen.ds0)));
        }
    }

    public void setCustomContent(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view) == null) {
            this.mContentLayout.addView(view);
        }
    }

    public void setDefTextButtonColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, textView) == null) {
            SkinManager.setViewTextColor(textView, R.color.navi_op_text);
        }
    }

    public void setFixedHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.isFixedHeight = z;
        }
    }

    public void setIsClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.mIsClose = z;
        }
    }

    public void setIsCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mIsCorner = z;
        }
    }

    public void setLoginClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onClickListener) == null) {
            this.mLoginListener = onClickListener;
            TextView textView = this.mLoginView;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
        }
    }

    public void setNavHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            this.mNavHeight = i2;
        }
    }

    public void setRegisterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onClickListener) == null) {
            this.mRegisterListener = onClickListener;
            TextView textView = this.mRegisterView;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
        }
    }

    public void setSpecialBackground(Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048630, this, drawable, i2) == null) {
            this.mSpecialBackgroundDrawable = drawable;
            this.mSpecialBackgroundBackupColorId = i2;
        }
    }

    public void setStatusBarVisibility(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || (view = this.mStatusBarView) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void setSystemClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.mClickIsVaild = z;
        }
    }

    public TextView setTitleText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (this.mTextTitle == null) {
                this.mTextTitle = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
                getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
            }
            this.mTextTitle.setText(str);
            return this.mTextTitle;
        }
        return (TextView) invokeL.objValue;
    }

    public View setTitleView(View view, View.OnClickListener onClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, view, onClickListener)) == null) ? addCustomView(ControlAlign.HORIZONTAL_CENTER, view, onClickListener) : (View) invokeLL.objValue;
    }

    public void setmBackImageViewBg(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048638, this, i2, i3) == null) {
            this.mBackImagedeepResId = i2;
            this.mBackImagelightResId = i3;
            SkinManager.setNavbarIconSrc(this.mBackImageView, i2, i3);
        }
    }

    public void showBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.mBottomLine.setVisibility(8);
        }
    }

    public void showNavigationBarExcludeStatusbar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            if (z) {
                this.mLeftBox.setVisibility(0);
                this.mCenterBox.setVisibility(0);
                this.mRightBox.setVisibility(0);
                this.mAbsoluteCenterBox.setVisibility(0);
                return;
            }
            this.mLeftBox.setVisibility(8);
            this.mCenterBox.setVisibility(8);
            this.mRightBox.setVisibility(8);
            this.mAbsoluteCenterBox.setVisibility(8);
        }
    }

    public void showNavigationBarWithAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            ValueAnimator valueAnimator = this.mNavInAnimator;
            if (valueAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0 - this.mFixedNavHeight, 0);
                this.mNavInAnimator = ofInt;
                ofInt.addUpdateListener(this.mNavAnimatorUpdateListener);
                this.mNavInAnimator.addListener(new e(this));
                this.mNavInAnimator.setDuration(300L);
                this.mNavInAnimator.setInterpolator(new LinearInterpolator());
            } else if (valueAnimator.isRunning()) {
                return;
            } else {
                if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin >= 0) {
                    return;
                }
            }
            this.mNavInAnimator.start();
        }
    }

    public void switchNaviBarStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            if (z) {
                this.mLeftBox.setVisibility(0);
                this.mCenterBox.setVisibility(0);
                this.mRightBox.setVisibility(0);
                this.mAbsoluteCenterBox.setVisibility(0);
                View view = this.mUnloginView;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            initUnloginView();
            this.mLeftBox.setVisibility(8);
            this.mCenterBox.setVisibility(8);
            this.mRightBox.setVisibility(8);
            this.mAbsoluteCenterBox.setVisibility(8);
            this.mUnloginView.setVisibility(0);
        }
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, controlAlign, controlType, onClickListener)) == null) {
            if (controlType == ControlType.BACK_BUTTON) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.navigationBarGoBack);
                if (linearLayout == null) {
                    LinearLayout linearLayout2 = (LinearLayout) getViewFromLayoutFile(R.layout.widget_nb_item_back);
                    ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.widget_navi_back_button);
                    this.mBackImageView = imageView;
                    imageView.setContentDescription("返回");
                    onBackBtnOnChangeSkin();
                    if (linearLayout2 != null) {
                        getViewGroup(controlAlign).addView(linearLayout2);
                        if (onClickListener != null) {
                            linearLayout2.setOnClickListener(onClickListener);
                            return linearLayout2;
                        }
                        return linearLayout2;
                    }
                    return linearLayout2;
                }
                return linearLayout;
            }
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, controlAlign, str, onClickListener)) == null) ? addTextButton(controlAlign, str, onClickListener, false) : (TextView) invokeLLL.objValue;
    }

    public void onBackBtnOnChangeSkin(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            if (i2 < 0) {
                i2 = TbadkCoreApplication.getInst().getSkinType();
            }
            int i4 = this.mBackImagedeepResId;
            if (i4 > 0 && (i3 = this.mBackImagelightResId) > 0) {
                SkinManager.setNavbarIconSrc(this.mBackImageView, i4, i3, i2);
            } else if (this.mIsClose) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, null);
            }
        }
    }

    public View setTitleView(int i2, View.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048636, this, i2, onClickListener)) == null) ? addCustomView(ControlAlign.HORIZONTAL_CENTER, getViewFromLayoutFile(i2), onClickListener) : (View) invokeIL.objValue;
    }

    public void showBottomLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.mBottomLine.setVisibility(8);
        }
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{controlAlign, str, onClickListener, Boolean.valueOf(z)})) == null) {
            View viewFromLayoutFile = getViewFromLayoutFile(R.layout.navigation_right_button_layout);
            TextView textView = (TextView) viewFromLayoutFile.findViewById(R.id.right_textview);
            textView.setText(str);
            if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) getResources().getDimension(R.dimen.M_H_X003);
                if (z) {
                    layoutParams.setMargins(dimension, dimension, dimension, dimension);
                } else {
                    layoutParams.setMargins(dimension, dimension, 0, dimension);
                }
                textView.setLayoutParams(layoutParams);
            } else if (ControlAlign.HORIZONTAL_LEFT == controlAlign) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                int dimension2 = (int) getResources().getDimension(R.dimen.M_H_X003);
                if (z) {
                    layoutParams2.setMargins(dimension2, dimension2, dimension2, dimension2);
                } else {
                    layoutParams2.setMargins(dimension2, dimension2, 0, dimension2);
                }
                textView.setLayoutParams(layoutParams2);
            }
            getViewGroup(controlAlign).addView(viewFromLayoutFile);
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            return textView;
        }
        return (TextView) invokeCommon.objValue;
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, controlAlign, str, onClickListener)) == null) {
            TextView addTextButton = addTextButton(controlAlign, str, onClickListener, false);
            setDefTextButtonColor(addTextButton);
            return addTextButton;
        }
        return (TextView) invokeLLL.objValue;
    }

    public View addCustomView(ControlAlign controlAlign, int i2, View.OnClickListener onClickListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, controlAlign, i2, onClickListener)) == null) ? addCustomView(controlAlign, getViewFromLayoutFile(i2), onClickListener) : (View) invokeLIL.objValue;
    }

    public TextView addTextButtonByDefTextColor(ControlAlign controlAlign, String str, View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{controlAlign, str, onClickListener, Boolean.valueOf(z)})) == null) {
            TextView addTextButton = addTextButton(controlAlign, str, onClickListener, z);
            setDefTextButtonColor(addTextButton);
            return addTextButton;
        }
        return (TextView) invokeCommon.objValue;
    }

    public TextView setTitleText(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048635, this, str, f2)) == null) {
            if (this.mTextTitle == null) {
                TextView textView = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
                this.mTextTitle = textView;
                textView.setTextSize(0, f2);
                getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
            }
            this.mTextTitle.setText(str);
            return this.mTextTitle;
        }
        return (TextView) invokeLF.objValue;
    }

    public void onBackBtnOnChangeSkin(int i2, @ColorRes int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
            if (i2 < 0) {
                i2 = TbadkCoreApplication.getInst().getSkinType();
            }
            int i5 = this.mBackImagedeepResId;
            if (i5 > 0 && (i4 = this.mBackImagelightResId) > 0) {
                SkinManager.setNavbarIconSrc(this.mBackImageView, i5, i4, i2);
            } else if (this.mIsClose) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, i3, null);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, i3, null);
            }
        }
    }

    public TextView setTitleText(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) ? setTitleText(this.mCurrentActivity.getString(i2)) : (TextView) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = m.f(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mClickIsVaild = true;
        this.isAutoNight = true;
        this.isFixedHeight = true;
        this.isNeedAddStatusBarHeight = false;
        this.mTopPadding = 0;
        this.mNavHeight = m.f(getContext(), R.dimen.ds88);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, attributeSet);
    }
}
