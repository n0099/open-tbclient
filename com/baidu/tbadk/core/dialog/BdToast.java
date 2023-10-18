package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.jd;
import com.baidu.tieba.vca;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class BdToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TEXTVIEW_DEFAULT_MIN_WIDTH = 80;
    public static SoftReference<Toast> mToastStatic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSvgIcon;
    public int mBackgroundColor;
    public final Context mContext;
    public int mDuration;
    public int mIconResId;
    public String mIconUrl;
    public String mIconUrlDark;
    public final TbImage mIconView;
    public final LinearLayout mLeftIconContainer;
    public String mLeftIconUrl;
    public final TbImage mLeftIconView;
    public final ViewGroup mRootView;
    public CharSequence mText;
    public final TextView mTextView;
    public Toast mToast;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ToastIcon {
        public static final /* synthetic */ ToastIcon[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ToastIcon FAILURE;
        public static final ToastIcon NOT;
        public static final ToastIcon SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;
        public int iconId;
        public boolean isSvg;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1621383372, "Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1621383372, "Lcom/baidu/tbadk/core/dialog/BdToast$ToastIcon;");
                    return;
                }
            }
            SUCCESS = new ToastIcon("SUCCESS", 0, R.drawable.icon_pure_toast_succeed40_svg, true);
            FAILURE = new ToastIcon("FAILURE", 1, R.drawable.icon_pure_toast_mistake40_svg, true);
            ToastIcon toastIcon = new ToastIcon("NOT", 2, 0, false);
            NOT = toastIcon;
            $VALUES = new ToastIcon[]{SUCCESS, FAILURE, toastIcon};
        }

        public ToastIcon(String str, int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.iconId = i2;
            this.isSvg = z;
        }

        public static ToastIcon valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (ToastIcon) Enum.valueOf(ToastIcon.class, str);
            }
            return (ToastIcon) invokeL.objValue;
        }

        public static ToastIcon[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (ToastIcon[]) $VALUES.clone();
            }
            return (ToastIcon[]) invokeV.objValue;
        }
    }

    public BdToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIconResId = -1;
        this.isSvgIcon = false;
        this.mDuration = 0;
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.mRootView = viewGroup;
        this.mIconView = (TbImage) viewGroup.findViewById(R.id.toast_icon);
        this.mLeftIconView = (TbImage) this.mRootView.findViewById(R.id.toast_left_icon);
        this.mLeftIconContainer = (LinearLayout) this.mRootView.findViewById(R.id.left_icon_toast_container);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.toast_message);
        GreyUtil.grey(this.mRootView);
    }

    private BdToast create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Toast toast = new Toast(this.mContext);
            this.mToast = toast;
            jd.a(toast);
            updateStaticToast();
            setToastIcon();
            if (this.mBackgroundColor != 0) {
                this.mRootView.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds32), this.mBackgroundColor));
            } else {
                this.mRootView.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.mContext, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            }
            setToastLeftIcon();
            SkinManager.setViewTextColor(this.mTextView, R.color.CAM_X0101, 1);
            this.mTextView.setText(this.mText);
            this.mToast.setView(this.mRootView);
            return this;
        }
        return (BdToast) invokeV.objValue;
    }

    private void setToastIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4 && StringUtils.isNotNull(this.mIconUrlDark)) {
                this.mIconView.l(this.mIconUrlDark);
                this.mIconView.setVisibility(0);
            } else if (StringUtils.isNotNull(this.mIconUrl)) {
                this.mIconView.l(this.mIconUrl);
                this.mIconView.setVisibility(0);
            } else {
                int i = this.mIconResId;
                if (i != -1) {
                    if (this.isSvgIcon) {
                        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mIconView, this.mIconResId, R.color.CAM_X0101, null);
                    } else {
                        WebPManager.setMaskDrawable(this.mIconView, i, null);
                    }
                    this.mIconView.setVisibility(0);
                    return;
                }
                this.mIconView.setVisibility(8);
            }
        }
    }

    public static BdToast makeText(Context context, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, charSequence)) == null) {
            return new BdToast(context).setText(charSequence);
        }
        return (BdToast) invokeLL.objValue;
    }

    public BdToast setIconSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return setIconSizeAndTopMargin(i, i2, UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0703dd));
        }
        return (BdToast) invokeII.objValue;
    }

    private void setToastLeftIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (TextUtils.isEmpty(this.mLeftIconUrl)) {
                this.mLeftIconView.setVisibility(8);
                return;
            }
            this.mLeftIconView.l(this.mLeftIconUrl);
            this.mLeftIconView.setVisibility(0);
            EMManager.from(this.mRootView).setCorner(R.string.J_X06).setBackGroundRealColor(vca.a(SkinManager.getColor(R.color.CAM_X0611), 0.8f));
            int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds6);
            int dimens2 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds23);
            int dimens3 = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            int dimens4 = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mLeftIconContainer.getLayoutParams();
            layoutParams.topMargin = dimens;
            layoutParams.bottomMargin = dimens2;
            layoutParams.leftMargin = dimens3;
            layoutParams.rightMargin = dimens4;
            this.mLeftIconContainer.requestLayout();
            EMManager.from(this.mTextView).setTextSize(R.dimen.T_X07);
            ((LinearLayout.LayoutParams) this.mTextView.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds7);
            this.mTextView.requestLayout();
        }
    }

    private void updateStaticToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            SoftReference<Toast> softReference = mToastStatic;
            if (softReference != null && softReference.get() != null) {
                mToastStatic.get().cancel();
            }
            mToastStatic = new SoftReference<>(this.mToast);
        }
    }

    public void cancel() {
        Toast toast;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (toast = this.mToast) != null) {
            toast.cancel();
        }
    }

    public void setBackgroundColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.mBackgroundColor = i;
        }
    }

    public BdToast setDuration(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.mDuration = i;
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public void setExtraTextLineSpacing(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.mTextView.setLineSpacing(0.0f, f);
        }
    }

    public BdToast setIcon(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i != 0) {
                this.isSvgIcon = false;
                this.mIconResId = i;
            }
            return this;
        }
        return (BdToast) invokeI.objValue;
    }

    public BdToast setIconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.mIconUrl = str;
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast setIconUrlDark(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.mIconUrlDark = str;
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast setLeftIconUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            this.mLeftIconUrl = str;
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast setText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, charSequence)) == null) {
            this.mText = charSequence;
            this.mTextView.setText(charSequence);
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public void setTextViewMinWidth(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (textView = this.mTextView) != null && i > 80) {
            textView.setMinWidth(i);
        }
    }

    public BdToast setIcon(ToastIcon toastIcon) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, toastIcon)) == null) {
            if (toastIcon != null) {
                this.isSvgIcon = toastIcon.isSvg;
                this.mIconResId = toastIcon.iconId;
            }
            return this;
        }
        return (BdToast) invokeL.objValue;
    }

    public BdToast setIconSizeAndTopMargin(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            TbImage tbImage = this.mIconView;
            if (tbImage != null && i > 0 && i2 > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImage.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(i, i2);
                    layoutParams.topMargin = i3;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.topMargin = i3;
                    layoutParams.width = i;
                    layoutParams.height = i2;
                }
                this.mIconView.setLayoutParams(layoutParams);
            }
            return this;
        }
        return (BdToast) invokeIII.objValue;
    }

    public BdToast show() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mToast == null) {
                create();
            }
            GreyUtil.grey(this.mToast);
            this.mTextView.setText(this.mText);
            this.mToast.setGravity(16, 0, 0);
            this.mToast.setDuration(this.mDuration);
            this.mToast.show();
            return this;
        }
        return (BdToast) invokeV.objValue;
    }
}
