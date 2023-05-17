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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.g9;
import com.baidu.tieba.hx4;
import com.baidu.tieba.p45;
import com.baidu.tieba.ri;
import com.baidu.tieba.zt9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NavigationBar extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View barBgView;
    public int containerWidth;
    public boolean isAutoNight;
    public boolean isFixedHeight;
    public boolean isNeedAddStatusBarHeight;
    public LinearLayout mAbsoluteCenterBox;
    public int mBackGroundColor;
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
    /* loaded from: classes4.dex */
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

        public ControlAlign(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ControlAlign) Enum.valueOf(ControlAlign.class, str);
            }
            return (ControlAlign) invokeL.objValue;
        }

        public static ControlAlign[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ControlAlign[]) $VALUES.clone();
            }
            return (ControlAlign[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public static ControlType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ControlType[]) $VALUES.clone();
            }
            return (ControlType[]) invokeV.objValue;
        }

        public ControlType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ControlType) Enum.valueOf(ControlType.class, str);
            }
            return (ControlType) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBar a;

        public a(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a.mContentLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = intValue;
                    this.a.mContentLayout.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBar a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public b(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBar;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBar a;

        public c(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !this.a.mClickIsVaild) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.navigationBarGoBack) {
                this.a.mCurrentActivity.finish();
            } else if (id == R.id.navigationBarHome) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002004, this.a.mCurrentActivity));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBar a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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

        public d(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.mNavIsShow = false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NavigationBar a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        public e(NavigationBar navigationBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {navigationBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = navigationBar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.mNavIsShow = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048579, this, animator) != null) {
                return;
            }
            this.a.mNavIsShow = true;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mNavHeight = ri.g(getContext(), R.dimen.obfuscated_res_0x7f07040f);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mBackGroundColor = R.color.CAM_X0208;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mNavHeight = ri.g(getContext(), R.dimen.obfuscated_res_0x7f07040f);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mBackGroundColor = R.color.CAM_X0208;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, attributeSet);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(g9<?> g9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, g9Var, i) == null) {
            boolean z = true;
            if (this.mIsCorner) {
                p45 d2 = p45.d(this);
                d2.n(1);
                d2.o(R.string.J_X14);
                d2.f(this.mBackGroundColor);
            } else {
                SkinManager.setBackgroundColor(this, this.mBackGroundColor, i);
            }
            SkinManager.setBackgroundColor(this.mBottomLine, this.mBottomLineColor, i);
            onBackBtnOnChangeSkin(i);
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
            if (g9Var instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) g9Var;
                hx4 layoutMode = tbPageContext.getLayoutMode();
                if (i != 4) {
                    z = false;
                }
                layoutMode.l(z);
                tbPageContext.getLayoutMode().k(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.mNavHeight = ri.g(getContext(), R.dimen.obfuscated_res_0x7f07040f);
        this.mFixedNavHeight = 0;
        this.mBottomLineColor = R.color.CAM_X0204;
        this.mBackGroundColor = R.color.CAM_X0208;
        this.mNavIsShow = true;
        this.mNavAnimatorUpdateListener = new a(this);
        this.containerWidth = 0;
        this.mOnClickListener = new c(this);
        init(context, attributeSet);
    }

    private View getViewFromLayoutFile(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            return LayoutInflater.from(this.mCurrentActivity).inflate(i, (ViewGroup) this, false);
        }
        return (View) invokeI.objValue;
    }

    private void tryFixViewNoHeight(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, view2) == null) && view2.getHeight() <= 0 && getMeasuredHeight() > 0) {
            view2.getLayoutParams().height = getMeasuredHeight();
            view2.requestLayout();
        }
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

    public void isShowBottomLine(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            View view2 = this.mBottomLine;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void onCenterTextOnChangeSkin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            if (i < 0) {
                i = TbadkCoreApplication.getInst().getSkinType();
            }
            SkinManager.setViewTextColor(this.mCenterText, R.color.CAM_X0105, 1, i);
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

    public void setBarBackgourndColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.mBackGroundColor = i;
        }
    }

    public void setBottomLineColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.mBottomLineColor = i;
        }
    }

    public void setBottomLineHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.mBottomLine.getLayoutParams().height = i;
            requestLayout();
        }
    }

    public void setCustomContent(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view2) == null) {
            this.mContentLayout.addView(view2);
        }
    }

    public void setDefTextButtonColor(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, textView) == null) {
            SkinManager.setViewTextColor(textView, (int) R.color.navi_op_text);
        }
    }

    public void setFixedHeight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.isFixedHeight = z;
        }
    }

    public void setIsClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.mIsClose = z;
        }
    }

    public void setIsCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.mIsCorner = z;
        }
    }

    public void setLoginClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.mLoginListener = onClickListener;
            TextView textView = this.mLoginView;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
        }
    }

    public void setNavHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.mNavHeight = i;
        }
    }

    public void setRegisterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.mRegisterListener = onClickListener;
            TextView textView = this.mRegisterView;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
        }
    }

    public void setStatusBarVisibility(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048632, this, i) == null) && (view2 = this.mStatusBarView) != null) {
            view2.setVisibility(i);
        }
    }

    public void setSystemClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.mClickIsVaild = z;
        }
    }

    public TextView setTitleText(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i)) == null) {
            return setTitleText(this.mCurrentActivity.getString(i));
        }
        return (TextView) invokeI.objValue;
    }

    public void showBottomLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.mBottomLine.setVisibility(8);
        }
    }

    public View addSystemImageButton(ControlAlign controlAlign, ControlType controlType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, controlAlign, controlType)) == null) {
            return addSystemImageButton(controlAlign, controlType, this.mOnClickListener);
        }
        return (View) invokeLL.objValue;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, controlAlign, str)) == null) {
            return addTextButton(controlAlign, str, null);
        }
        return (TextView) invokeLL.objValue;
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

    public void setSpecialBackground(Drawable drawable, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048631, this, drawable, i) == null) {
            this.mSpecialBackgroundDrawable = drawable;
            this.mSpecialBackgroundBackupColorId = i;
        }
    }

    public View setTitleView(int i, View.OnClickListener onClickListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048637, this, i, onClickListener)) == null) {
            return addCustomView(ControlAlign.HORIZONTAL_CENTER, getViewFromLayoutFile(i), onClickListener);
        }
        return (View) invokeIL.objValue;
    }

    public void setmBackImageViewBg(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048639, this, i, i2) == null) {
            this.mBackImagedeepResId = i;
            this.mBackImagelightResId = i2;
            SkinManager.setNavbarIconSrc(this.mBackImageView, i, i2);
        }
    }

    private View createStateBarFillView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            View view2 = new View(getContext());
            view2.setId(R.id.navigation_bar_status_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight());
            layoutParams.addRule(10, -1);
            view2.setLayoutParams(layoutParams);
            return view2;
        }
        return (View) invokeV.objValue;
    }

    public void initPadding() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            setPadding(ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)), this.mTopPadding, ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)), ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)));
        }
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
            this.mLeftBox = (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091475);
            this.mCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f090670);
            this.mRightBox = (LinearLayout) this.mRootView.findViewById(R.id.obfuscated_res_0x7f091e29);
            this.mAbsoluteCenterBox = (LinearLayout) this.mRootView.findViewById(R.id.absoluteCenterBox);
            this.mCenterImgBox = (LinearLayout) this.mRootView.findViewById(R.id.center_img_box);
            this.mCenterIcon = (ImageView) this.mRootView.findViewById(R.id.center_img);
            this.mCenterText = (TextView) this.mRootView.findViewById(R.id.center_text);
            this.mBottomLine = this.mRootView.findViewById(R.id.bottom_line);
            View findViewById = this.mRootView.findViewById(R.id.navigation_bar_view_cover_bg);
            this.topCoverBgView = findViewById;
            boolean z2 = false;
            findViewById.setBackgroundDrawable(SkinManager.getDrawable(0, (int) R.drawable.navigation_cover_top_bg));
            this.barBgView = this.mRootView.findViewById(R.id.navigation_bar_view_bg);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zt9.NavigationBar);
                z = obtainStyledAttributes.getBoolean(0, true);
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
                int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be);
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

    public Button addRightButton(ControlAlign controlAlign, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, controlAlign, str)) == null) {
            Button button = (Button) getViewFromLayoutFile(R.layout.widget_nb_item_stepbtn);
            button.setText(str);
            if (ControlAlign.HORIZONTAL_RIGHT == controlAlign) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be);
                layoutParams.setMargins(0, dimension, dimension, dimension);
                button.setLayoutParams(layoutParams);
            }
            getViewGroup(controlAlign).addView(button);
            return button;
        }
        return (Button) invokeLL.objValue;
    }

    public void onBackBtnOnChangeSkin(int i, @ColorRes int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            if (i < 0) {
                i = TbadkCoreApplication.getInst().getSkinType();
            }
            int i4 = this.mBackImagedeepResId;
            if (i4 > 0 && (i3 = this.mBackImagelightResId) > 0) {
                SkinManager.setNavbarIconSrc(this.mBackImageView, i4, i3, i);
            } else if (this.mIsClose) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, i2, null);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, i2, null);
            }
        }
    }

    public TextView setTitleText(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048636, this, str, f)) == null) {
            if (this.mTextTitle == null) {
                TextView textView = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
                this.mTextTitle = textView;
                textView.setTextSize(0, f);
                getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
            }
            this.mTextTitle.setText(str);
            return this.mTextTitle;
        }
        return (TextView) invokeLF.objValue;
    }

    public View addCustomView(ControlAlign controlAlign, int i, View.OnClickListener onClickListener) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, controlAlign, i, onClickListener)) == null) {
            return addCustomView(controlAlign, getViewFromLayoutFile(i), onClickListener);
        }
        return (View) invokeLIL.objValue;
    }

    public TextView addTextButton(ControlAlign controlAlign, String str, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, controlAlign, str, onClickListener)) == null) {
            return addTextButton(controlAlign, str, onClickListener, false);
        }
        return (TextView) invokeLLL.objValue;
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

    public View setTitleView(View view2, View.OnClickListener onClickListener, ControlAlign controlAlign) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048638, this, view2, onClickListener, controlAlign)) == null) {
            return addCustomView(controlAlign, view2, onClickListener);
        }
        return (View) invokeLLL.objValue;
    }

    public View addCustomView(ControlAlign controlAlign, View view2, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, controlAlign, view2, onClickListener)) == null) {
            getViewGroup(controlAlign).addView(view2);
            if (onClickListener != null) {
                view2.setOnClickListener(onClickListener);
            }
            if (controlAlign == ControlAlign.HORIZONTAL_CENTER) {
            }
            return view2;
        }
        return (View) invokeLLL.objValue;
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

    public ImageView getBackImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mBackImageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public View getBarBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View view2 = this.barBgView;
            if (view2 != null) {
                tryFixViewNoHeight(view2);
            }
            return this.barBgView;
        }
        return (View) invokeV.objValue;
    }

    public View getBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mBottomLine;
        }
        return (View) invokeV.objValue;
    }

    public View getCenterImgBox() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mCenterIcon;
        }
        return (View) invokeV.objValue;
    }

    public View getCenterImgBoxLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mCenterImgBox;
        }
        return (View) invokeV.objValue;
    }

    public TextView getCenterText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mCenterText;
        }
        return (TextView) invokeV.objValue;
    }

    public CharSequence getCenterTextTitleText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mCenterText.getText();
        }
        return (CharSequence) invokeV.objValue;
    }

    public FrameLayout getContentLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mContentLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public int getFixedNavHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mFixedNavHeight;
        }
        return invokeV.intValue;
    }

    public boolean getNavBarIsShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mNavIsShow;
        }
        return invokeV.booleanValue;
    }

    public View getTopCoverBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            View view2 = this.topCoverBgView;
            if (view2 != null) {
                tryFixViewNoHeight(view2);
            }
            return this.topCoverBgView;
        }
        return (View) invokeV.objValue;
    }

    public void hideBottomLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.mBottomLine.setVisibility(8);
        }
    }

    public boolean isAutoNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.isAutoNight;
        }
        return invokeV.booleanValue;
    }

    public boolean isFixedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.isFixedHeight;
        }
        return invokeV.booleanValue;
    }

    public boolean isNavigationBarExcludeStatusbarVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mLeftBox.getVisibility() != 0 && this.mCenterBox.getVisibility() != 0 && this.mRightBox.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void onBackBtnOnChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            onBackBtnOnChangeSkin(-1);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            removeAllViews();
        }
    }

    public void showBottomLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
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
            } else if (!valueAnimator.isRunning()) {
                if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin < 0) {
                    return;
                }
            } else {
                return;
            }
            this.mNavOutAnimator.start();
        }
    }

    public void showNavigationBarWithAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            ValueAnimator valueAnimator = this.mNavInAnimator;
            if (valueAnimator == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0 - this.mFixedNavHeight, 0);
                this.mNavInAnimator = ofInt;
                ofInt.addUpdateListener(this.mNavAnimatorUpdateListener);
                this.mNavInAnimator.addListener(new e(this));
                this.mNavInAnimator.setDuration(300L);
                this.mNavInAnimator.setInterpolator(new LinearInterpolator());
            } else if (!valueAnimator.isRunning()) {
                if ((this.mContentLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) this.mContentLayout.getLayoutParams()).topMargin >= 0) {
                    return;
                }
            } else {
                return;
            }
            this.mNavInAnimator.start();
        }
    }

    public void onBackBtnOnChangeSkin(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i < 0) {
                i = TbadkCoreApplication.getInst().getSkinType();
            }
            int i3 = this.mBackImagedeepResId;
            if (i3 > 0 && (i2 = this.mBackImagelightResId) > 0) {
                SkinManager.setNavbarIconSrc(this.mBackImageView, i3, i2, i);
            } else if (this.mIsClose) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, null);
            }
        }
    }

    public void switchNaviBarStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            if (z) {
                this.mLeftBox.setVisibility(0);
                this.mCenterBox.setVisibility(0);
                this.mRightBox.setVisibility(0);
                this.mAbsoluteCenterBox.setVisibility(0);
                View view2 = this.mUnloginView;
                if (view2 != null) {
                    view2.setVisibility(8);
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

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
            int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
            int i5 = this.containerWidth;
            int i6 = i5 - measuredWidth2;
            if (i5 - measuredWidth2 > 0) {
                i5 = i6;
            }
            LinearLayout linearLayout = this.mCenterBox;
            linearLayout.layout(measuredWidth, linearLayout.getTop(), i5, this.mCenterBox.getBottom());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        View view2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
            if (this.isFixedHeight) {
                int mode = View.MeasureSpec.getMode(i2);
                int i5 = this.mNavHeight;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mContentLayout.getLayoutParams();
                if (Math.abs(layoutParams.topMargin) > this.mContentLayout.getHeight()) {
                    if (layoutParams.topMargin >= 0) {
                        i3 = this.mContentLayout.getHeight();
                    } else {
                        i4 = i5 - this.mContentLayout.getHeight();
                        i2 = View.MeasureSpec.makeMeasureSpec(i4, mode);
                    }
                } else {
                    i3 = layoutParams.topMargin;
                }
                i4 = i5 + i3;
                i2 = View.MeasureSpec.makeMeasureSpec(i4, mode);
            }
            if (this.isNeedAddStatusBarHeight && (view2 = this.mStatusBarView) != null && view2.getVisibility() == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2) + UtilHelper.getStatusBarHeight(), View.MeasureSpec.getMode(i2));
            }
            super.onMeasure(i, i2);
            this.containerWidth = View.MeasureSpec.getSize(i);
            int measuredWidth = this.mLeftBox.getMeasuredWidth() + getPaddingLeft();
            int measuredWidth2 = this.mRightBox.getMeasuredWidth() + getPaddingRight();
            LinearLayout linearLayout = this.mCenterBox;
            linearLayout.measure(((this.containerWidth - measuredWidth) - measuredWidth2) + 1073741824, linearLayout.getMeasuredHeight() + 1073741824);
        }
    }

    public TextView setCenterTextTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, str)) == null) {
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

    public void setContentPaddingTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.mContentLayout.setPadding(ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)), i, ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)), ri.d(this.mCurrentActivity, getResources().getDimension(R.dimen.obfuscated_res_0x7f070347)));
        }
    }

    public TextView setTitleText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            if (this.mTextTitle == null) {
                this.mTextTitle = (TextView) getViewFromLayoutFile(R.layout.widget_nb_item_title);
                getViewGroup(ControlAlign.HORIZONTAL_CENTER).addView(this.mTextTitle);
            }
            this.mTextTitle.setText(str);
            return this.mTextTitle;
        }
        return (TextView) invokeL.objValue;
    }

    public void showNavigationBarExcludeStatusbar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
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
}
