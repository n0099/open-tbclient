package com.baidu.android.ext.widget.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.toast.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class UniversalToast implements PopItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BOTTOM_ICON_STYLE_RECT = 2;
    public static final int BOTTOM_ICON_STYLE_ROUND = 1;
    public static final int BOTTOM_SHOW_ANIMATION_FADE_IN = 1;
    public static final int BOTTOM_SHOW_ANIMATION_SHIFT_UP = 2;
    public static final int BOTTOM_SHOW_SHIFT_UP_DURATION = 200;
    public static final int BUTTON_STYLE_BG_TEXT = 2;
    public static final int BUTTON_STYLE_LINE_TEXT_ICON = 1;
    public static final String TAG = "UniversalToast";
    public static boolean mIsDebug;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBottomIconStyle;
    public int mBottomMargin;
    public int mBottomShowAnimationType;
    public CharSequence mBtnText;
    public int mBtnTextSize;
    public Drawable mButtonIcon;
    public int mButtonStyle;
    public ToastCallback mCancelCallback;
    public boolean mCancelVisible;
    public Context mContext;
    public View mCustomView;
    public int mDuration;
    public Drawable mHighlightIcon;
    public boolean mIsFullScreen;
    public TextColorHolder mJumpTextColor;
    public Drawable mLeftDrawable;
    public Uri mLeftGifUri;
    public Drawable mLeftIcon;
    public TextColorHolder mLeftTextColor;
    public int mMaxLines;
    public OnDismissListener mOnDismissListener;
    public ToastRightAreaStyle mRightClickStyle;
    public Drawable mRightDrawable;
    public CharSequence mRightText;
    public Uri mRigthGifUri;
    public boolean mShowMask;
    public CharSequence mSubTitleText;
    public int mTextSize;
    public CharSequence mTitleText;
    public TextColorHolder mTitleTextColor;
    public ToastCallback mToastCallback;
    public ToastLocation mToastLocation;
    public ToastTemplate mToastTemplate;
    public CharSequence mToastText;

    /* renamed from: com.baidu.android.ext.widget.toast.UniversalToast$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1024776026, "Lcom/baidu/android/ext/widget/toast/UniversalToast$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1024776026, "Lcom/baidu/android/ext/widget/toast/UniversalToast$2;");
                    return;
                }
            }
            int[] iArr = new int[ToastTemplate.values().length];
            $SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate = iArr;
            try {
                iArr[ToastTemplate.T1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate[ToastTemplate.T2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate[ToastTemplate.T3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate[ToastTemplate.T4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    /* loaded from: classes6.dex */
    public interface ToastCallback {
        void onToastClick();
    }

    /* loaded from: classes6.dex */
    public interface ToastCallbackWithAction extends ToastCallback {
        public static final int ACTION_CANCEL = -1;
        public static final int ACTION_CONFIRM = 0;
        public static final String PARAMS_RESULT_KEY = "allow";

        void onToastClick(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-7872152, "Lcom/baidu/android/ext/widget/toast/UniversalToast;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-7872152, "Lcom/baidu/android/ext/widget/toast/UniversalToast;");
        }
    }

    public UniversalToast(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mButtonStyle = 2;
        this.mBottomShowAnimationType = 1;
        this.mBottomIconStyle = 1;
        this.mRightClickStyle = ToastRightAreaStyle.JUMP;
        this.mCancelVisible = false;
        this.mToastLocation = ToastLocation.MIDDLE;
        this.mToastTemplate = ToastTemplate.T1;
        this.mIsFullScreen = false;
        this.mLeftTextColor = new TextColorHolder();
        this.mTitleTextColor = new TextColorHolder();
        this.mJumpTextColor = new TextColorHolder();
        this.mContext = context;
        this.mDuration = 3;
        this.mTextSize = 14;
    }

    public static void cancelToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            SingleToast.cancel();
            ViewToast.doCancelBeforeShow();
        }
    }

    @Deprecated
    private boolean checkToastParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mContext == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast mContext is null!!!");
                }
                return false;
            } else if (this.mToastText == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast toast text is null!!!");
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public static int getSwanAppStatusBarAndActionBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? DeviceUtil.ScreenInfo.getStatusBarHeight() + ((int) context.getResources().getDimension(R.dimen.normal_base_action_bar_height)) : invokeL.intValue;
    }

    public static UniversalToast makeText(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? new UniversalToast(context) : (UniversalToast) invokeL.objValue;
    }

    private void showDegradeToast(Context context, CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, context, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        SingleToast.showTemplate2(context, null, null, null, charSequence, this.mTitleTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, null, false);
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public void mutexDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOnDismissListener(null);
            cancelToast();
        }
    }

    @Override // com.baidu.android.ext.manage.PopItem
    public boolean mutexShow(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr)) == null) {
            setOnDismissListener(new OnDismissListener(this) { // from class: com.baidu.android.ext.widget.toast.UniversalToast.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ UniversalToast this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this};
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

                @Override // com.baidu.android.ext.widget.toast.UniversalToast.OnDismissListener
                public void onDismiss() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        boolean unused = UniversalToast.mIsDebug;
                        MutexPopManager.doNextTask();
                    }
                }
            });
            if (str == null) {
                str = "";
            }
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1913642710:
                    if (str.equals(PopItemMethodConstant.showToast)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1876363382:
                    if (str.equals("showIconTitleMsgBtnToast")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1396871306:
                    if (str.equals("showRightButtonToast")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 463967707:
                    if (str.equals("showClickablePopToast")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 764048578:
                    if (str.equals("showClickableToast")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 826030240:
                    if (str.equals("showBigPicToast")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1764503207:
                    if (str.equals("showRightButtonPopToast")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    showToast();
                    return true;
                case 1:
                    showClickableToast();
                    return true;
                case 2:
                    showIconTitleMsgBtnToast();
                    return true;
                case 3:
                    showRightButtonToast();
                    return true;
                case 4:
                    showBigPicToast();
                    return true;
                case 5:
                    showClickablePopToast();
                    return true;
                case 6:
                    showRightButtonPopToast();
                    return true;
                default:
                    return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public UniversalToast setBigPicLeftDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable)) == null) {
            this.mLeftDrawable = drawable;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setBigPicRightDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawable)) == null) {
            this.mRightDrawable = drawable;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    @Deprecated
    public UniversalToast setBottomIconStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.mBottomIconStyle = i2;
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setBottomMargin(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.mBottomMargin = i2;
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setBottomShowAnimationType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.mBottomShowAnimationType = i2;
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setButtonIcon(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, drawable)) == null) {
            this.mButtonIcon = drawable;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    @Deprecated
    public UniversalToast setButtonStyle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mButtonStyle = i2;
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setButtonText(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, charSequence)) == null) {
            this.mBtnText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    @Deprecated
    public UniversalToast setButtonTextSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 > 18) {
                this.mBtnTextSize = 18;
            } else if (i2 < 12) {
                this.mBtnTextSize = 12;
            } else {
                this.mBtnTextSize = i2;
            }
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setCancelVisible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            this.mCancelVisible = z;
            return this;
        }
        return (UniversalToast) invokeZ.objValue;
    }

    public UniversalToast setCustomView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view)) == null) {
            this.mCustomView = view;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setDuration(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            if (i2 < 3) {
                this.mDuration = 3;
            } else {
                this.mDuration = i2;
            }
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setFullScreen(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            this.mIsFullScreen = z;
            return this;
        }
        return (UniversalToast) invokeZ.objValue;
    }

    public UniversalToast setHighlightDrawable(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, drawable)) == null) {
            this.mHighlightIcon = drawable;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setJumpTextColor(TextColorHolder textColorHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, textColorHolder)) == null) {
            this.mJumpTextColor = textColorHolder;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setLeftGif(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, uri)) == null) {
            this.mLeftGifUri = uri;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setLeftIcon(@NonNull Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, drawable)) == null) {
            this.mLeftIcon = drawable;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setLeftTextColor(TextColorHolder textColorHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, textColorHolder)) == null) {
            this.mLeftTextColor = textColorHolder;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setLocation(ToastLocation toastLocation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, toastLocation)) == null) {
            this.mToastLocation = toastLocation;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setMaxLines(@NonNull int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.mMaxLines = i2;
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setMessageText(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, charSequence)) == null) {
            this.mToastText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onDismissListener) == null) {
            this.mOnDismissListener = onDismissListener;
        }
    }

    public UniversalToast setRightClickStyle(ToastRightAreaStyle toastRightAreaStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, toastRightAreaStyle)) == null) {
            this.mRightClickStyle = toastRightAreaStyle;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setRightText(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, charSequence)) == null) {
            this.mRightText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setRigthGifUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, uri)) == null) {
            this.mRigthGifUri = uri;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setShowMask(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            this.mShowMask = z;
            return this;
        }
        return (UniversalToast) invokeZ.objValue;
    }

    public UniversalToast setSubTitle(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, charSequence)) == null) {
            this.mSubTitleText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setTemplate(ToastTemplate toastTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, toastTemplate)) == null) {
            if (toastTemplate == null) {
                toastTemplate = ToastTemplate.T1;
            }
            this.mToastTemplate = toastTemplate;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setText(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, charSequence)) == null) {
            this.mToastText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    @Deprecated
    public UniversalToast setTextSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            if (i2 > 18) {
                this.mTextSize = 18;
            } else if (i2 < 12) {
                this.mTextSize = 12;
            } else {
                this.mTextSize = i2;
            }
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setTitleText(@NonNull CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, charSequence)) == null) {
            this.mTitleText = charSequence;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setTitleTextColor(TextColorHolder textColorHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, textColorHolder)) == null) {
            this.mTitleTextColor = textColorHolder;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setToastCallback(ToastCallback toastCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, toastCallback)) == null) {
            this.mToastCallback = toastCallback;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public UniversalToast setToastCancelCallback(ToastCallback toastCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, toastCallback)) == null) {
            this.mCancelCallback = toastCallback;
            return this;
        }
        return (UniversalToast) invokeL.objValue;
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.mContext != null && (!TextUtils.isEmpty(this.mToastText) || !TextUtils.isEmpty(this.mTitleText))) {
                cancelToast();
                if (this.mContext instanceof Activity) {
                    OnDismissListener onDismissListener = this.mOnDismissListener;
                    if (onDismissListener != null) {
                        ViewToast.setOnDismissListener(onDismissListener);
                    }
                    int i2 = AnonymousClass2.$SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate[this.mToastTemplate.ordinal()];
                    if (i2 == 2) {
                        if (TextUtils.isEmpty(this.mToastText)) {
                            return;
                        }
                        ViewToast.showTemplate2((Activity) this.mContext, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mToastText, this.mLeftTextColor, this.mRightText, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
                        return;
                    } else if (i2 == 3) {
                        if (TextUtils.isEmpty(this.mRightText) && !TextUtils.isEmpty(this.mToastText)) {
                            ViewToast.showTemplate2((Activity) this.mContext, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mToastText, this.mLeftTextColor, this.mRightText, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
                            return;
                        } else if (TextUtils.isEmpty(this.mTitleText)) {
                            return;
                        } else {
                            ViewToast.showTemplate3((Activity) this.mContext, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mTitleText, this.mTitleTextColor, this.mSubTitleText, this.mRightText, this.mJumpTextColor, this.mRightClickStyle, this.mCancelVisible, this.mDuration, this.mIsFullScreen, this.mToastCallback, this.mCancelCallback);
                            return;
                        }
                    } else if (i2 != 4) {
                        if (TextUtils.isEmpty(this.mToastText)) {
                            return;
                        }
                        ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, null);
                        return;
                    } else if (TextUtils.isEmpty(this.mToastText)) {
                        return;
                    } else {
                        ViewToast.showHighlight((Activity) this.mContext, this.mToastText, this.mHighlightIcon, this.mCustomView, this.mDuration, this.mShowMask);
                        return;
                    }
                } else if (AnonymousClass2.$SwitchMap$com$baidu$android$ext$widget$toast$ToastTemplate[this.mToastTemplate.ordinal()] != 4) {
                    showDegradeToast(this.mContext, TextUtils.isEmpty(this.mToastText) ? this.mTitleText : this.mToastText);
                    return;
                } else if (TextUtils.isEmpty(this.mToastText)) {
                    return;
                } else {
                    SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mCustomView, this.mDuration, this.mShowMask);
                    return;
                }
            }
            ToastUtils.printStackTraceString("has no mToastText or mTitleText");
        }
    }

    @Deprecated
    public void show2Icon2BtnToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            show2Icon2BtnToast(false);
        }
    }

    @Deprecated
    public void showBigPicToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            showBigPicToast(false);
        }
    }

    @Deprecated
    public void showClickablePopToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            showClickablePopToast(false, false);
        }
    }

    @Deprecated
    public void showClickableToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            showClickableToast(false, false);
        }
    }

    @Deprecated
    public void showClickableToastForFullScreen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            showClickableToast(false, true);
        }
    }

    @Deprecated
    public void showClickableToastWithLeftGif() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            showClickableToastWithLeftGif(false);
        }
    }

    @Deprecated
    public void showClickableToastWithLeftIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            showClickableToastWithLeftIcon(false);
        }
    }

    @Deprecated
    public void showClickableToastWithLeftIconNoBtn() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && checkToastParams()) {
            if (this.mLeftIcon == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left drawable is null!!!");
                }
                return;
            }
            cancelToast();
            ViewToast.showClickableToastWithLeftIconNoBtn((Activity) this.mContext, this.mToastText, this.mLeftIcon, this.mDuration, this.mToastCallback);
        }
    }

    @Deprecated
    public void showCustomToast(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048629, this, view, i2) == null) || this.mContext == null) {
            return;
        }
        cancelToast();
        SingleToast.showCustomToast(this.mContext, view, i2);
    }

    public void showD20Template2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mToastText);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showTemplate2((Activity) context, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mToastText, this.mLeftTextColor, this.mBtnText, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
            } else {
                showDegradeToast(context, this.mToastText);
            }
        }
    }

    public void showD20Template3(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z) == null) || this.mContext == null || TextUtils.isEmpty(this.mTitleText)) {
            return;
        }
        cancelToast();
        if (z) {
            showDegradeToast(this.mContext, this.mTitleText);
        } else if (this.mContext instanceof Activity) {
            OnDismissListener onDismissListener = this.mOnDismissListener;
            if (onDismissListener != null) {
                ViewToast.setOnDismissListener(onDismissListener);
                this.mOnDismissListener = null;
            }
            if (TextUtils.isEmpty(this.mRightText)) {
                ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
            } else {
                ViewToast.showTemplate3((Activity) this.mContext, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mTitleText, this.mTitleTextColor, this.mSubTitleText, this.mRightText, this.mJumpTextColor, this.mRightClickStyle, false, this.mDuration, false, this.mToastCallback, this.mCancelCallback);
            }
        } else {
            OnDismissListener onDismissListener2 = this.mOnDismissListener;
            if (onDismissListener2 != null) {
                SingleToast.setOnDismissListener(onDismissListener2);
                this.mOnDismissListener = null;
            }
            showDegradeToast(this.mContext, this.mTitleText);
        }
    }

    public void showHighLoadingToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            showHighLoadingToast(false);
        }
    }

    public void showHighlightToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            showHighlightToast(false);
        }
    }

    @Deprecated
    public void showIconTitleMsgBtnToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            showIconTitleMsgBtnToast(false);
        }
    }

    @Deprecated
    public void showRightButtonPopToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            showRightButtonPopToast(false);
        }
    }

    @Deprecated
    public void showRightButtonToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            showRightButtonToast(false);
        }
    }

    @Deprecated
    public void showToast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            showToast(false);
        }
    }

    @Deprecated
    public void showToastBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            showToastBottom(false);
        }
    }

    public static UniversalToast makeText(@NonNull Context context, @NonNull CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, charSequence)) == null) {
            UniversalToast universalToast = new UniversalToast(context);
            universalToast.mToastText = charSequence;
            return universalToast;
        }
        return (UniversalToast) invokeLL.objValue;
    }

    public UniversalToast setHighlightDrawable(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Context context = this.mContext;
            if (context != null && context.getResources() != null) {
                this.mHighlightIcon = this.mContext.getResources().getDrawable(i2);
            }
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    public UniversalToast setLeftIcon(@DrawableRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            Context context = this.mContext;
            if (context != null && context.getResources() != null) {
                this.mLeftIcon = this.mContext.getResources().getDrawable(i2);
            }
            return this;
        }
        return (UniversalToast) invokeI.objValue;
    }

    @Deprecated
    public void show2Icon2BtnToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && checkToastParams()) {
            cancelToast();
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.show2Icon2BtnToast((Activity) context, this.mLeftGifUri, this.mToastText, this.mRigthGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.show2Icon2BtnToast(context, this.mLeftGifUri, this.mToastText, this.mRigthGifUri, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    @Deprecated
    public void showBigPicToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showBigPicToast(this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            } else if (this.mContext instanceof Activity) {
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    ViewToast.setOnDismissListener(onDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showBigPicToast((Activity) this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            } else {
                OnDismissListener onDismissListener2 = this.mOnDismissListener;
                if (onDismissListener2 != null) {
                    SingleToast.setOnDismissListener(onDismissListener2);
                    this.mOnDismissListener = null;
                }
                SingleToast.showBigPicToast(this.mContext, this.mLeftDrawable, this.mRightDrawable, this.mTitleText, this.mBtnText, this.mDuration, this.mToastCallback);
            }
        }
    }

    @Deprecated
    public void showClickablePopToast(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    SingleToast.setOnDismissListener(onDismissListener);
                    this.mOnDismissListener = null;
                }
                SingleToast.showClickablePopToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mDuration, this.mToastCallback);
                return;
            }
            OnDismissListener onDismissListener2 = this.mOnDismissListener;
            if (onDismissListener2 != null) {
                SingleToast.setOnDismissListener(onDismissListener2);
                this.mOnDismissListener = null;
            }
            showDegradeToast(this.mContext, this.mToastText);
        }
    }

    @Deprecated
    public void showClickableToast(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    ViewToast.setOnDismissListener(onDismissListener);
                    this.mOnDismissListener = null;
                }
                if (TextUtils.isEmpty(this.mBtnText)) {
                    this.mBtnText = AppRuntime.getAppContext().getResources().getText(R.string.clickable_toast_check_text);
                }
                ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, this.mBtnText, this.mJumpTextColor, this.mDuration, ToastLocation.BOTTOM, z2, this.mToastCallback);
                return;
            }
            OnDismissListener onDismissListener2 = this.mOnDismissListener;
            if (onDismissListener2 != null) {
                SingleToast.setOnDismissListener(onDismissListener2);
                this.mOnDismissListener = null;
            }
            showDegradeToast(this.mContext, this.mToastText);
        }
    }

    @Deprecated
    public void showClickableToastWithLeftGif(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && checkToastParams()) {
            if (this.mLeftGifUri == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left gif uri is null!!!");
                }
                return;
            }
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mToastText);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showTemplate2((Activity) context, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mToastText, this.mLeftTextColor, this.mBtnText, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
            } else {
                showDegradeToast(context, this.mToastText);
            }
        }
    }

    @Deprecated
    public void showClickableToastWithLeftIcon(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z) == null) && checkToastParams()) {
            if (this.mLeftIcon == null) {
                if (mIsDebug) {
                    throw new IllegalArgumentException("UniversalToast left drawable is null!!!");
                }
                return;
            }
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mToastText);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showTemplate2((Activity) context, this.mLeftGifUri, this.mLeftIcon, this.mCustomView, this.mToastText, this.mLeftTextColor, this.mBtnText, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
            } else {
                showDegradeToast(context, this.mToastText);
            }
        }
    }

    public void showHighLoadingToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showHighLoadingToast(this.mContext, this.mToastText, this.mDuration, this.mShowMask);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showHighLoadingToast((Activity) context, this.mToastText, this.mDuration, this.mShowMask);
            } else {
                SingleToast.showHighLoadingToast(context, this.mToastText, this.mDuration, this.mShowMask);
            }
        }
    }

    public void showHighlightToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048635, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showHighlight(this.mContext, this.mToastText, this.mHighlightIcon, this.mCustomView, this.mDuration, this.mShowMask);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showHighlight((Activity) context, this.mToastText, this.mHighlightIcon, this.mCustomView, this.mDuration, this.mShowMask);
            } else {
                SingleToast.showHighlight(context, this.mToastText, this.mHighlightIcon, this.mCustomView, this.mDuration, this.mShowMask);
            }
        }
    }

    @Deprecated
    public void showIconTitleMsgBtnToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048637, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mTitleText);
            } else if (this.mContext instanceof Activity) {
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    ViewToast.setOnDismissListener(onDismissListener);
                    this.mOnDismissListener = null;
                }
                if (1 == this.mButtonStyle) {
                    this.mRightClickStyle = ToastRightAreaStyle.JUMP;
                } else {
                    this.mRightClickStyle = ToastRightAreaStyle.BUTTON;
                }
                if (TextUtils.isEmpty(this.mBtnText)) {
                    ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
                    return;
                }
                CharSequence charSequence = this.mTitleText;
                CharSequence charSequence2 = this.mToastText;
                if (TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(this.mToastText)) {
                    charSequence = this.mToastText;
                    charSequence2 = "";
                }
                ViewToast.showTemplate3((Activity) this.mContext, this.mLeftGifUri, null, null, charSequence, this.mTitleTextColor, charSequence2, this.mBtnText, this.mJumpTextColor, this.mRightClickStyle, false, this.mDuration, false, this.mToastCallback, null);
            } else {
                OnDismissListener onDismissListener2 = this.mOnDismissListener;
                if (onDismissListener2 != null) {
                    SingleToast.setOnDismissListener(onDismissListener2);
                    this.mOnDismissListener = null;
                }
                showDegradeToast(this.mContext, this.mTitleText);
            }
        }
    }

    @Deprecated
    public void showRightButtonPopToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048639, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                SingleToast.showRightButtonToast(this.mContext, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                SingleToast.showRightButtonPopToast(context, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
            } else {
                SingleToast.showRightButtonToast(context, this.mToastText, this.mTextSize, this.mBtnText, this.mBtnTextSize, this.mDuration, this.mToastCallback);
            }
        }
    }

    @Deprecated
    public void showRightButtonToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048641, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mToastText);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                if (TextUtils.isEmpty(this.mBtnText)) {
                    ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
                    return;
                } else {
                    ViewToast.showTemplate3((Activity) this.mContext, null, null, null, this.mToastText, this.mTitleTextColor, null, this.mBtnText, this.mJumpTextColor, ToastRightAreaStyle.BUTTON, false, this.mDuration, false, this.mToastCallback, null);
                    return;
                }
            }
            showDegradeToast(context, this.mToastText);
        }
    }

    @Deprecated
    public void showToast(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048643, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                if (mIsDebug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("给View set 的mOnDismissListener是不是空?");
                    sb.append(this.mOnDismissListener == null);
                    sb.toString();
                }
                OnDismissListener onDismissListener = this.mOnDismissListener;
                if (onDismissListener != null) {
                    ViewToast.setOnDismissListener(onDismissListener);
                    this.mOnDismissListener = null;
                }
                ViewToast.showTemplate2((Activity) this.mContext, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, this.mToastLocation, this.mIsFullScreen, this.mToastCallback);
                return;
            }
            OnDismissListener onDismissListener2 = this.mOnDismissListener;
            if (onDismissListener2 != null) {
                SingleToast.setOnDismissListener(onDismissListener2);
                this.mOnDismissListener = null;
            }
            showDegradeToast(this.mContext, this.mToastText);
        }
    }

    @Deprecated
    public void showToastBottom(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048645, this, z) == null) && checkToastParams()) {
            cancelToast();
            if (z) {
                showDegradeToast(this.mContext, this.mToastText);
                return;
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ViewToast.showTemplate2((Activity) context, null, null, null, this.mToastText, this.mLeftTextColor, null, this.mJumpTextColor, this.mDuration, ToastLocation.BOTTOM, this.mIsFullScreen, this.mToastCallback);
            } else {
                showDegradeToast(context, this.mToastText);
            }
        }
    }

    public static UniversalToast makeText(@NonNull Context context, @StringRes int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, context, i2)) == null) {
            UniversalToast universalToast = new UniversalToast(context);
            universalToast.mToastText = context.getText(i2);
            return universalToast;
        }
        return (UniversalToast) invokeLI.objValue;
    }
}
