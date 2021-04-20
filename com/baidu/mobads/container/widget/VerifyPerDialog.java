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
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.RemoteXAdLogger;
/* loaded from: classes2.dex */
public class VerifyPerDialog {
    public static final int CUSTOMETITLE_VIEW_ID = 132043942;
    public static final String TAG = "VerifyPerDialog";
    public Dialog dialog;
    public boolean hideNavigation = false;
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public Context mContext;
    public OnDialogListener mListener;
    public String mPermission_link;
    public ProgressBar mProgressBar;
    public XMyWebView mXMyWebView;
    public double scaleHeight;

    public VerifyPerDialog(Context context, double d2, String str) {
        this.mContext = context;
        this.scaleHeight = d2;
        this.mPermission_link = str;
    }

    public static VerifyPerDialog createVerPerDialog(Context context, String str) {
        return new VerifyPerDialog(context, 0.9d, str);
    }

    private int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void dismissDialog() {
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

    public void setHideNavigation(boolean z) {
        this.hideNavigation = z;
    }

    public void setOnDialogListener(OnDialogListener onDialogListener) {
        this.mListener = onDialogListener;
    }

    public void setScaleHeight(double d2) {
        this.scaleHeight = d2;
    }

    public void show() {
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VerifyPerDialog.this.dialog.dismiss();
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
        this.mXMyWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (VerifyPerDialog.this.mProgressBar != null) {
                    VerifyPerDialog.this.mProgressBar.setVisibility(4);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (PluginLoader.getSslExemption(sslErrorHandler)) {
                    return;
                }
                sslErrorHandler.cancel();
            }
        });
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, relativeLayout2.getId());
        relativeLayout.addView(this.mXMyWebView, layoutParams4);
        this.dialog.setContentView(relativeLayout);
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.mobads.container.widget.VerifyPerDialog.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                VerifyPerDialog.this.dismissDialog();
            }
        });
        OnDialogListener onDialogListener = this.mListener;
        if (onDialogListener != null) {
            onDialogListener.onShow();
        }
        this.dialog.show();
    }
}
