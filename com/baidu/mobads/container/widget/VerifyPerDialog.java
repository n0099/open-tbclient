package com.baidu.mobads.container.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.net.http.SslError;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class VerifyPerDialog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CUSTOMETITLE_VIEW_ID = 132043942;
    public static final String TAG = "VerifyPerDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public Dialog dialog;
    public boolean hideNavigation;
    public RemoteXAdLogger mAdLogger;
    public Context mContext;
    public OnDialogListener mListener;
    public String mPermission_link;
    public ProgressBar mProgressBar;
    public XMyWebView mXMyWebView;
    public double scaleHeight;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(951721691, "Lcom/baidu/mobads/container/widget/VerifyPerDialog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(951721691, "Lcom/baidu/mobads/container/widget/VerifyPerDialog;");
        }
    }

    public VerifyPerDialog(Context context, double d2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Double.valueOf(d2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hideNavigation = false;
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mContext = context;
        this.scaleHeight = d2;
        this.mPermission_link = str;
    }

    public static VerifyPerDialog createVerPerDialog(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, context, str)) == null) ? new VerifyPerDialog(context, 0.9d, str) : (VerifyPerDialog) invokeLL.objValue;
    }

    private int dp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.AD_TEXT_ID, this, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public void dismissDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Dialog dialog = this.dialog;
            if (dialog != null && dialog.isShowing()) {
                try {
                    if (this.mXMyWebView != null) {
                        this.mXMyWebView.removeAllViews();
                        ((ViewGroup) this.mXMyWebView.getParent()).removeView(this.mXMyWebView);
                        this.mXMyWebView.stopLoading();
                        this.mXMyWebView.destroy();
                        this.mXMyWebView = null;
                    }
                } catch (Exception e2) {
                    this.mAdLogger.d(TAG, e2.getMessage());
                }
                if (this.mProgressBar != null) {
                    this.mProgressBar = null;
                }
            }
            OnDialogListener onDialogListener = this.mListener;
            if (onDialogListener != null) {
                onDialogListener.onDismiss();
            }
        }
    }

    public void setHideNavigation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.hideNavigation = z;
        }
    }

    public void setOnDialogListener(OnDialogListener onDialogListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onDialogListener) == null) {
            this.mListener = onDialogListener;
        }
    }

    public void setScaleHeight(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.scaleHeight = d2;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Dialog dialog = new Dialog(this.mContext);
            this.dialog = dialog;
            dialog.requestWindowFeature(1);
            Window window = this.dialog.getWindow();
            if (window != null) {
                if (this.hideNavigation) {
                    window.getDecorView().setSystemUiVisibility(4098);
                }
                window.getDecorView().setPadding(0, 0, 0, 0);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(-1);
                gradientDrawable.setCornerRadii(new float[]{40.0f, 40.0f, 40.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                window.getDecorView().setBackground(gradientDrawable);
                WindowManager.LayoutParams attributes = window.getAttributes();
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                attributes.width = displayMetrics.widthPixels;
                attributes.gravity = 80;
                attributes.height = (int) (displayMetrics.heightPixels * this.scaleHeight);
                window.setAttributes(attributes);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout2 = new RelativeLayout(this.mContext);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, dp2px(this.mContext, 50.0f)));
            relativeLayout2.setId(CUSTOMETITLE_VIEW_ID);
            TextView textView = new TextView(this.mContext);
            textView.setText("应用权限");
            textView.setTextSize(2, 18.0f);
            textView.setTextColor(-16777216);
            textView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout2.addView(textView, layoutParams);
            ImageView imageView = new ImageView(this.mContext);
            imageView.setClickable(true);
            byte[] decode = Base64.decode(StaticPicUtils.DELETE_BTN, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VerifyPerDialog this$0;

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
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.dialog.dismiss();
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dp2px(this.mContext, 26.0f), dp2px(this.mContext, 26.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.setMargins(0, 0, dp2px(this.mContext, 10.0f), 0);
            relativeLayout2.addView(imageView, layoutParams2);
            relativeLayout.addView(relativeLayout2);
            ProgressBar progressBar = new ProgressBar(this.mContext);
            this.mProgressBar = progressBar;
            progressBar.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            relativeLayout.addView(this.mProgressBar, layoutParams3);
            XMyWebView.ParameterInfo parameterInfo = new XMyWebView.ParameterInfo();
            parameterInfo.mCloseHardwareAccelerated = false;
            XMyWebView create = XMyWebView.create(this.mContext, RemoteXAdLogger.getInstance(), true, true, parameterInfo);
            this.mXMyWebView = create;
            create.curUrl = this.mPermission_link;
            create.getSettings().setUseWideViewPort(true);
            this.mXMyWebView.getSettings().setBuiltInZoomControls(true);
            try {
                this.mXMyWebView.loadUrl(this.mPermission_link);
                WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.mXMyWebView.getSettings(), Boolean.FALSE);
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            this.mXMyWebView.setWebViewClient(new WebViewClient(this) { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VerifyPerDialog this$0;

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

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                        super.onPageFinished(webView, str);
                        if (this.this$0.mProgressBar != null) {
                            this.this$0.mProgressBar.setVisibility(4);
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                        super.onPageStarted(webView, str, bitmap);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, sslErrorHandler, sslError) == null) || PluginLoader.getSslExemption(sslErrorHandler)) {
                        return;
                    }
                    sslErrorHandler.cancel();
                }
            });
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams4.addRule(3, relativeLayout2.getId());
            relativeLayout.addView(this.mXMyWebView, layoutParams4);
            this.dialog.setContentView(relativeLayout);
            this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VerifyPerDialog this$0;

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

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        this.this$0.dismissDialog();
                    }
                }
            });
            OnDialogListener onDialogListener = this.mListener;
            if (onDialogListener != null) {
                onDialogListener.onShow();
            }
            this.dialog.show();
        }
    }
}
