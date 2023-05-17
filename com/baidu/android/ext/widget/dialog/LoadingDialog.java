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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001(\u0018\u0000 ;2\u00020\u0001:\u0003;<=B#\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017\u0012\b\b\u0002\u00108\u001a\u00020\r¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J!\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00022\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0013\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0018\u0010,\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001fR\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107¨\u0006>"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog;", "Landroid/app/Dialog;", "", "dismiss", "()V", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDetachedFromWindow", "", "bottomText", "", "useLoadingAnim", "setBottomText", "(Ljava/lang/String;Z)V", "Lkotlin/Function0;", "onCloseListener", "setOnCloseListener", "(Lkotlin/Function0;)V", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "(Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;)V", "", "progress", "setProgress", "(I)V", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "loadingLayoutId", "I", "mBottomText", "Ljava/lang/String;", "Landroid/widget/TextView;", "mBottomTv", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "mCloseBtn", "Landroid/widget/ImageView;", "com/baidu/android/ext/widget/dialog/LoadingDialog$mDotAnimAction$1", "mDotAnimAction", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$mDotAnimAction$1;", "mDotAnimCounter", "mDotAnimTv", "Landroid/widget/FrameLayout;", "mLoadingContainer", "Landroid/widget/FrameLayout;", "mOnCloseListener", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "mProgress", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "mProgressBar", "Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "mUseLoadingAnim", "Z", Constants.KEYS.BannerShowCloseBtn, "<init>", "(Landroid/app/Activity;IZ)V", "Companion", "IProgressBar", "OnCloseListener", "lib-dialog_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$IProgressBar;", "Lkotlin/Any;", "", "progress", "", "setProgress", "(I)V", "lib-dialog_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public interface IProgressBar {
        void setProgress(int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$OnCloseListener;", "Lkotlin/Any;", "", "onCloseByBtn", "()V", "lib-dialog_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/android/ext/widget/dialog/LoadingDialog$Companion;", "", "DOT_ANIM_INTERVAL", "J", "", "MAX_BOTTOM_TEXT_NUM_NO_LOADING", "I", "MAX_BOTTOM_TEXT_NUM_USE_LOADING", "<init>", "()V", "lib-dialog_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

            /* JADX DEBUG: Incorrect args count in method signature: ()V */
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

            /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
                r0 = r4.this$0.mDotAnimTv;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                TextView textView;
                TextView textView2;
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
                if (textView2 == null || textView2.getVisibility() != 0 || !this.this$0.isShowing()) {
                    return;
                }
                i4 = this.this$0.mDotAnimCounter;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3 && textView7 != null) {
                                textView7.setText(StringHelper.STRING_MORE);
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

    private final void initView() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mCloseBtn = (ImageView) findViewById(R.id.obfuscated_res_0x7f090717);
            this.mBottomTv = (TextView) findViewById(R.id.obfuscated_res_0x7f09046e);
            this.mDotAnimTv = (TextView) findViewById(R.id.obfuscated_res_0x7f090904);
            this.mLoadingContainer = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0915d4);
            int i = this.loadingLayoutId;
            if (i == -1) {
                i = R.layout.obfuscated_res_0x7f0d01f9;
            }
            LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.mLoadingContainer, true);
            FrameLayout frameLayout = this.mLoadingContainer;
            if (frameLayout != null) {
                view2 = frameLayout.findViewById(R.id.obfuscated_res_0x7f0915d7);
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
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Resources resources = context.getResources();
            if (this.showCloseBtn) {
                ImageView imageView = this.mCloseBtn;
                Intrinsics.checkNotNull(imageView);
                imageView.setImageDrawable(resources.getDrawable(R.drawable.obfuscated_res_0x7f080f16));
            } else {
                ImageView imageView2 = this.mCloseBtn;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setVisibility(8);
            }
            TextView textView = this.mBottomTv;
            Intrinsics.checkNotNull(textView);
            textView.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601d7));
            TextView textView2 = this.mDotAnimTv;
            Intrinsics.checkNotNull(textView2);
            textView2.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0601d7));
            if (this.mBottomText != null) {
                TextView textView3 = this.mBottomTv;
                Intrinsics.checkNotNull(textView3);
                textView3.setText(this.mBottomText);
            }
            ImageView imageView3 = this.mCloseBtn;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.android.ext.widget.dialog.LoadingDialog$initView$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoadingDialog this$0;

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

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LoadingDialog.OnCloseListener onCloseListener;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view3) != null) {
                        return;
                    }
                    onCloseListener = this.this$0.mOnCloseListener;
                    if (onCloseListener != null) {
                        onCloseListener.onCloseByBtn();
                    }
                    this.this$0.dismiss();
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
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                window.setDimAmount(0.0f);
            }
            setCanceledOnTouchOutside(false);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            window2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f15));
            setContentView(R.layout.obfuscated_res_0x7f0d05cd);
            initView();
        }
    }

    public final void setBottomText(String str, final boolean z) {
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
                if (str != null) {
                    str = str.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
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
                    textView2.removeCallbacks(new Runnable(this, z) { // from class: com.baidu.android.ext.widget.dialog.LoadingDialog$setBottomText$$inlined$apply$lambda$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ boolean $useLoadingAnim$inlined;
                        public final /* synthetic */ LoadingDialog this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Boolean.valueOf(z)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.$useLoadingAnim$inlined = z;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            LoadingDialog$mDotAnimAction$1 unused;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            unused = this.this$0.mDotAnimAction;
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
                    public final /* synthetic */ Function0 $onCloseListener;

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
