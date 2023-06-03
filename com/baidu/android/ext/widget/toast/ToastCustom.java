package com.baidu.android.ext.widget.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ToastCustom {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICKABLE_TOAST_SHOW_TIME = 3;
    public static final int NORMAL_TOAST_SHOW_TIME = 2;
    public static final String TAG = "ToastCustom";
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable mCancelRunnable;
    public Context mContext;
    public volatile int mDuration;
    public Handler mHandler;
    public boolean mIsDebug;
    public boolean mMask;
    public View mMaskView;
    public View mNextMaskView;
    public View mNextView;
    public Runnable mShowRunnable;
    public View mView;
    public WindowManager mWM;
    public WindowManager.LayoutParams mWinParams;
    public UniversalToast.OnDismissListener onDismissListener;

    public ToastCustom(Context context) {
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
        this.mContext = context;
        this.mWM = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCancelRunnable = new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ToastCustom.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ToastCustom this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.this$0.mView != null) {
                        if (this.this$0.mView.getParent() != null) {
                            this.this$0.mWM.removeView(this.this$0.mView);
                            if (this.this$0.onDismissListener != null) {
                                this.this$0.onDismissListener.onDismiss();
                                this.this$0.onDismissListener = null;
                            }
                        }
                        this.this$0.mView = null;
                    }
                    if (this.this$0.mMaskView != null) {
                        if (this.this$0.mMaskView.getParent() != null) {
                            this.this$0.mWM.removeView(this.this$0.mMaskView);
                        }
                        this.this$0.mMaskView = null;
                    }
                }
            }
        };
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mWinParams = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.obfuscated_res_0x7f10043c;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.mWinParams;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.mDuration = 2;
        this.mIsDebug = false;
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i <= 0) {
                i = 2;
            }
            this.mDuration = i;
        }
    }

    public void setMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mMask = z;
        }
    }

    public void setOnDissmissListener(UniversalToast.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onDismissListener) == null) {
            this.onDismissListener = onDismissListener;
        }
    }

    public void setText(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            View view2 = this.mNextView;
            if (view2 instanceof TextView) {
                ((TextView) view2).setText(i);
            }
        }
    }

    public void setView(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.mNextView = view2;
            view2.setClickable(true);
        }
    }

    public void setWindowAnimation(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (layoutParams = this.mWinParams) != null) {
            layoutParams.windowAnimations = i;
        }
    }

    public void setWindowParams(@NonNull WindowManager.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, layoutParams) == null) {
            this.mWinParams = layoutParams;
        }
    }

    public void setWindowType(int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (layoutParams = this.mWinParams) != null) {
            layoutParams.type = i;
        }
    }

    public void setMargin(float f, float f2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && (layoutParams = this.mWinParams) != null) {
            layoutParams.verticalMargin = f2;
            layoutParams.horizontalMargin = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager.LayoutParams createMaskParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = UniversalToast.getSwanAppStatusBarAndActionBarHeight(this.mContext);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public void cancel() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (handler = this.mHandler) != null) {
            handler.post(new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ToastCustom.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ToastCustom this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.this$0.mView != null) {
                                if (this.this$0.mView.getParent() != null) {
                                    this.this$0.mWM.removeViewImmediate(this.this$0.mView);
                                }
                                if (this.this$0.onDismissListener != null) {
                                    this.this$0.onDismissListener.onDismiss();
                                    this.this$0.onDismissListener = null;
                                }
                                if (this.this$0.mIsDebug) {
                                    Log.d(ToastCustom.TAG, "remove mView");
                                }
                                this.this$0.mView = null;
                            }
                            if (this.this$0.mMaskView != null) {
                                if (this.this$0.mMaskView.getParent() != null) {
                                    this.this$0.mWM.removeViewImmediate(this.this$0.mMaskView);
                                }
                                if (this.this$0.mIsDebug) {
                                    Log.d(ToastCustom.TAG, "remove mMaskView");
                                }
                                this.this$0.mMaskView = null;
                            }
                        } finally {
                            if (!z) {
                            }
                        }
                    }
                }
            });
            this.mHandler.removeCallbacks(this.mCancelRunnable);
            if (this.mIsDebug) {
                Log.d(TAG, "cancel");
            }
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Runnable runnable = this.mShowRunnable;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable(this) { // from class: com.baidu.android.ext.widget.toast.ToastCustom.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ToastCustom this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            if (this.this$0.mMask) {
                                if (this.this$0.mMaskView != null && (this.this$0.mMaskView.getParent() instanceof ViewGroup)) {
                                    ((ViewGroup) this.this$0.mMaskView.getParent()).removeView(this.this$0.mMaskView);
                                }
                                WindowManager.LayoutParams createMaskParams = this.this$0.createMaskParams();
                                this.this$0.mNextMaskView = new FrameLayout(this.this$0.mContext);
                                this.this$0.mNextMaskView.setClickable(true);
                                this.this$0.mWM.addView(this.this$0.mNextMaskView, createMaskParams);
                                this.this$0.mMaskView = this.this$0.mNextMaskView;
                            }
                            if (this.this$0.mNextView != null && (this.this$0.mNextView.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) this.this$0.mNextView.getParent()).removeView(this.this$0.mNextView);
                            }
                            this.this$0.mWM.addView(this.this$0.mNextView, this.this$0.mWinParams);
                            this.this$0.mView = this.this$0.mNextView;
                            this.this$0.mHandler.postDelayed(this.this$0.mCancelRunnable, this.this$0.mDuration * 1000);
                            if (this.this$0.mIsDebug) {
                                Log.d(ToastCustom.TAG, "add mView");
                            }
                        } finally {
                            if (!z) {
                            }
                        }
                    }
                }
            };
            this.mShowRunnable = runnable2;
            this.mHandler.post(runnable2);
        }
    }

    public static ToastCustom makeText(@NonNull Context context, CharSequence charSequence, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65556, null, context, charSequence, i)) == null) {
            ToastCustom toastCustom = new ToastCustom(context);
            TextView textView = new TextView(context);
            toastCustom.mNextView = textView;
            textView.setText(charSequence);
            toastCustom.mDuration = i;
            return toastCustom;
        }
        return (ToastCustom) invokeLLI.objValue;
    }

    public void setGravity(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) && (layoutParams = this.mWinParams) != null) {
            layoutParams.gravity = i;
            layoutParams.x = i2;
            layoutParams.y = i3;
        }
    }

    public void setOnClick(@Nullable UniversalToast.ToastCallback toastCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, toastCallback) == null) && this.mNextView != null) {
            View.OnClickListener onClickListener = new View.OnClickListener(this, toastCallback) { // from class: com.baidu.android.ext.widget.toast.ToastCustom.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ToastCustom this$0;
                public final /* synthetic */ UniversalToast.ToastCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, toastCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = toastCallback;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        UniversalToast.ToastCallback toastCallback2 = this.val$callback;
                        if (toastCallback2 != null) {
                            toastCallback2.onToastClick();
                        }
                        this.this$0.cancel();
                    }
                }
            };
            this.mNextView.setClickable(true);
            View findViewById = this.mNextView.findViewById(R.id.obfuscated_res_0x7f090713);
            if (findViewById != null) {
                findViewById.setOnClickListener(onClickListener);
            } else {
                this.mNextView.setOnClickListener(onClickListener);
            }
        }
    }

    public void setText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) {
            View view2 = this.mNextView;
            if (view2 instanceof TextView) {
                ((TextView) view2).setText(charSequence);
            }
        }
    }
}
