package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.ext.widget.dialog.LoadingDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0010\b\u0007\u0018\u0000 +2\u00020\u0001:\u0003+,-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001dH\u0016J\u001a\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010%\u001a\u00020\u0007J\u0016\u0010&\u001a\u00020\u001d2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010(J\u0010\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0017J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "loadingLayoutId", "", "showCloseBtn", "", "(Landroid/app/Activity;IZ)V", "mBottomText", "", "mBottomTv", "Landroid/widget/TextView;", "mCloseBtn", "Landroid/widget/ImageView;", "mDotAnimAction", "com/baidu/android/ext/widget/dialog/LoadingDialog$mDotAnimAction$1", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$mDotAnimAction$1;", "mDotAnimCounter", "mDotAnimTv", "mLoadingContainer", "Landroid/widget/FrameLayout;", "mOnCloseListener", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "mProgress", "mProgressBar", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "mUseLoadingAnim", "dismiss", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "setBottomText", "bottomText", "useLoadingAnim", "setOnCloseListener", "onCloseListener", "Lkotlin/Function0;", "setProgress", "progress", "Companion", "IProgressBar", "OnCloseListener", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LoadingDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final long DOT_ANIM_INTERVAL = 250;
    public static final int MAX_BOTTOM_TEXT_NUM_NO_LOADING = 7;
    public static final int MAX_BOTTOM_TEXT_NUM_USE_LOADING = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public final Activity activity;
    public final int loadingLayoutId;
    public String mBottomText;
    public TextView mBottomTv;
    public ImageView mCloseBtn;
    public LoadingDialog$mDotAnimAction$1 mDotAnimAction;
    public int mDotAnimCounter;
    public TextView mDotAnimTv;
    public FrameLayout mLoadingContainer;
    public OnCloseListener mOnCloseListener;
    public int mProgress;
    public IProgressBar mProgressBar;
    public boolean mUseLoadingAnim;
    public final boolean showCloseBtn;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "", "setProgress", "", "progress", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface IProgressBar {
        void setProgress(int i);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "", "onCloseByBtn", "", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnCloseListener {
        void onCloseByBtn();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(164884271, "Lcom/baidu/android/ext/widget/dialog/LoadingDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(164884271, "Lcom/baidu/android/ext/widget/dialog/LoadingDialog;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$Companion;", "", "()V", "DOT_ANIM_INTERVAL", "", "MAX_BOTTOM_TEXT_NUM_NO_LOADING", "", "MAX_BOTTOM_TEXT_NUM_USE_LOADING", "lib-dialog_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.baidu.android.ext.widget.dialog.LoadingDialog$mDotAnimAction$1] */
    public LoadingDialog(Activity activity, int i, boolean z) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i), Boolean.valueOf(z)};
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
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.loadingLayoutId = i;
        this.showCloseBtn = z;
        this.mDotAnimAction = new Runnable(this) { // from class: com.baidu.android.ext.widget.dialog.LoadingDialog$mDotAnimAction$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoadingDialog this$0;

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

            /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
                r0 = r5.this$0.mDotAnimTv;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                TextView textView;
                TextView textView2;
                boolean z2;
                int i4;
                TextView textView3;
                int i5;
                int i6;
                TextView textView4;
                TextView textView5;
                TextView textView6;
                TextView textView7;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                textView = this.this$0.mDotAnimTv;
                if (textView != null) {
                    textView.removeCallbacks(this);
                }
                textView2 = this.this$0.mDotAnimTv;
                if (textView2 != null && textView2.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 || !this.this$0.isShowing()) {
                    return;
                }
                i4 = this.this$0.mDotAnimCounter;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3 && textView7 != null) {
                                textView7.setText("...");
                            }
                        } else {
                            textView6 = this.this$0.mDotAnimTv;
                            if (textView6 != null) {
                                textView6.setText(IStringUtil.TOP_PATH);
                            }
                        }
                    } else {
                        textView5 = this.this$0.mDotAnimTv;
                        if (textView5 != null) {
                            textView5.setText(".");
                        }
                    }
                } else {
                    textView3 = this.this$0.mDotAnimTv;
                    if (textView3 != null) {
                        textView3.setText("");
                    }
                }
                LoadingDialog loadingDialog = this.this$0;
                i5 = loadingDialog.mDotAnimCounter;
                loadingDialog.mDotAnimCounter = i5 + 1;
                i6 = this.this$0.mDotAnimCounter;
                if (i6 > 3) {
                    this.this$0.mDotAnimCounter = 0;
                }
                textView4 = this.this$0.mDotAnimTv;
                Intrinsics.checkNotNull(textView4);
                textView4.postDelayed(this, 250L);
            }
        };
    }

    public /* synthetic */ LoadingDialog(Activity activity, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? true : z);
    }

    public static /* synthetic */ void setBottomText$default(LoadingDialog loadingDialog, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        loadingDialog.setBottomText(str, z);
    }

    /* renamed from: setBottomText$lambda-3$lambda-2  reason: not valid java name */
    public static final void m41setBottomText$lambda3$lambda2(LoadingDialog this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            LoadingDialog$mDotAnimAction$1 loadingDialog$mDotAnimAction$1 = this$0.mDotAnimAction;
        }
    }

    public final void setOnCloseListener(OnCloseListener onCloseListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onCloseListener) == null) {
            this.mOnCloseListener = onCloseListener;
        }
    }

    public final void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mProgress = i;
            IProgressBar iProgressBar = this.mProgressBar;
            if (iProgressBar != null) {
                iProgressBar.setProgress(i);
            }
        }
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m40initView$lambda1(LoadingDialog this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            OnCloseListener onCloseListener = this$0.mOnCloseListener;
            if (onCloseListener != null) {
                onCloseListener.onCloseByBtn();
            }
            this$0.dismiss();
        }
    }

    private final void initView() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mCloseBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f09071e);
            this.mBottomTv = (TextView) findViewById(R.id.obfuscated_res_0x7f090470);
            this.mDotAnimTv = (TextView) findViewById(R.id.obfuscated_res_0x7f090913);
            this.mLoadingContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0915fc);
            int i = this.loadingLayoutId;
            if (i == -1) {
                i = R.layout.obfuscated_res_0x7f0d01ff;
            }
            LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mLoadingContainer, true);
            FrameLayout frameLayout = this.mLoadingContainer;
            if (frameLayout != null) {
                view2 = frameLayout.findViewById(R.id.obfuscated_res_0x7f0915ff);
            } else {
                view2 = null;
            }
            if (view2 != null && (view2 instanceof IProgressBar)) {
                this.mProgressBar = (IProgressBar) view2;
            }
            IProgressBar iProgressBar = this.mProgressBar;
            if (iProgressBar != null) {
                iProgressBar.setProgress(this.mProgress);
            }
            Resources resources = getContext().getResources();
            if (this.showCloseBtn) {
                ImageView imageView = this.mCloseBtn;
                Intrinsics.checkNotNull(imageView);
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080f3f));
            } else {
                ImageView imageView2 = this.mCloseBtn;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(8);
            }
            TextView textView = this.mBottomTv;
            Intrinsics.checkNotNull(textView);
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            TextView textView2 = this.mDotAnimTv;
            Intrinsics.checkNotNull(textView2);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601db));
            if (this.mBottomText != null) {
                TextView textView3 = this.mBottomTv;
                Intrinsics.checkNotNull(textView3);
                textView3.setText(this.mBottomText);
            }
            ImageView imageView3 = this.mCloseBtn;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.so
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        LoadingDialog.m40initView$lambda1(LoadingDialog.this, view3);
                    }
                }
            });
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && isShowing() && !this.activity.isFinishing()) {
            if (Build.VERSION.SDK_INT >= 17 && this.activity.isDestroyed()) {
                return;
            }
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            TextView textView = this.mDotAnimTv;
            if (textView != null) {
                textView.removeCallbacks(this.mDotAnimAction);
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
            }
            setCanceledOnTouchOutside(false);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f3e));
            setContentView(R.layout.obfuscated_res_0x7f0d05d9);
            initView();
        }
    }

    public final void setBottomText(String str, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            if (z) {
                i = 6;
            } else {
                i = 7;
            }
            if (str != null) {
                i2 = str.length();
            } else {
                i2 = 0;
            }
            if (i2 > i) {
                Intrinsics.checkNotNull(str);
                str = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            this.mBottomText = str;
            TextView textView = this.mBottomTv;
            if (textView != null) {
                textView.setText(str);
            }
            this.mUseLoadingAnim = z;
            TextView textView2 = this.mDotAnimTv;
            if (textView2 != null) {
                if (z) {
                    textView2.setVisibility(0);
                    textView2.removeCallbacks(new Runnable() { // from class: com.baidu.tieba.vo
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                LoadingDialog.m41setBottomText$lambda3$lambda2(LoadingDialog.this);
                            }
                        }
                    });
                    this.mDotAnimCounter = 0;
                    textView2.post(this.mDotAnimAction);
                    return;
                }
                textView2.setVisibility(8);
                textView2.removeCallbacks(this.mDotAnimAction);
            }
        }
    }

    public final void setOnCloseListener(final Function0<Unit> function0) {
        OnCloseListener onCloseListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function0) == null) {
            if (function0 == null) {
                onCloseListener = null;
            } else {
                onCloseListener = new OnCloseListener(function0) { // from class: com.baidu.android.ext.widget.dialog.LoadingDialog$setOnCloseListener$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Function0<Unit> $onCloseListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {function0};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$onCloseListener = function0;
                    }

                    @Override // com.baidu.android.ext.widget.dialog.LoadingDialog.OnCloseListener
                    public void onCloseByBtn() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.$onCloseListener.invoke();
                        }
                    }
                };
            }
            this.mOnCloseListener = onCloseListener;
        }
    }
}
