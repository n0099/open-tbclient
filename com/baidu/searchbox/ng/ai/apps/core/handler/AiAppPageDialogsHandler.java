package com.baidu.searchbox.ng.ai.apps.core.handler;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog;
import com.baidu.searchbox.ng.ai.apps.core.handler.AiAppSafeUrlDialog;
import com.baidu.searchbox.ng.ai.apps.core.handler.AiAppSslCertificateDialog;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdBaseImageView;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class AiAppPageDialogsHandler {
    private static final boolean DEBUG = false;
    private static final String TAG = AiAppPageDialogsHandler.class.getSimpleName();
    private static Set<String> sBaiduOriginSet = new HashSet();
    private Context mContext;
    private AiAppGeolocationDialog mGeolocationDialog;
    private AiAppHttpAuthenticationDialog mHttpAuthenticationDialog;

    static {
        sBaiduOriginSet.add(".baidu.com");
        sBaiduOriginSet.add(".nuomi.com");
        sBaiduOriginSet.add(".nuomi.bdimg.com");
        sBaiduOriginSet.add(".hao123.com");
        sBaiduOriginSet.add(".qunaer.com");
    }

    public AiAppPageDialogsHandler(Context context) {
        this.mContext = context;
    }

    public void showHttpAuthentication(final BdSailorWebView bdSailorWebView, final HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mHttpAuthenticationDialog = new AiAppHttpAuthenticationDialog(this.mContext, str, str2);
        this.mHttpAuthenticationDialog.setOkListener(new AiAppHttpAuthenticationDialog.OkListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.1
            @Override // com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.OkListener
            public void onOk(String str3, String str4, String str5, String str6) {
                AiAppPageDialogsHandler.this.setHttpAuthUsernamePassword(bdSailorWebView, str3, str4, str5, str6);
                httpAuthHandler.proceed(str5, str6);
                AiAppPageDialogsHandler.this.mHttpAuthenticationDialog = null;
            }
        });
        this.mHttpAuthenticationDialog.setCancelListener(new AiAppHttpAuthenticationDialog.CancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.2
            @Override // com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.CancelListener
            public void onCancel() {
                httpAuthHandler.cancel();
                AiAppPageDialogsHandler.this.mHttpAuthenticationDialog = null;
            }
        });
        this.mHttpAuthenticationDialog.show();
    }

    public void setHttpAuthUsernamePassword(BdSailorWebView bdSailorWebView, String str, String str2, String str3, String str4) {
        if (bdSailorWebView != null) {
            bdSailorWebView.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void showSslErrorDialog(final BdSailorWebView bdSailorWebView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        if (!canShowAlertDialog()) {
            sslErrorHandler.cancel();
        } else {
            new AiAppSafeUrlDialog.Builder(this.mContext).setTitle(R.string.aiapps_security_warning).setMessage(R.string.aiapps_ssl_warnings_header, new AutoOrientationBtnDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.7
                private static final int COUNTS = 5;
                private static final long DURATION = 3000;
                private long[] mHits = null;

                @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.OnItemClickListener
                public void onItemClick(View view) {
                    if (this.mHits == null) {
                        this.mHits = new long[5];
                    }
                    System.arraycopy(this.mHits, 1, this.mHits, 0, this.mHits.length - 1);
                    this.mHits[this.mHits.length - 1] = SystemClock.uptimeMillis();
                    if (this.mHits[0] >= SystemClock.uptimeMillis() - DURATION) {
                        this.mHits = null;
                        AiAppPageDialogsHandler.this.copyToCb(sslError.toString());
                    }
                }
            }).setButton(new AutoOrientationBtnDialog.BtnItem(this.mContext.getText(R.string.aiapps_ssl_continue), R.color.aiapps_ssl_dialog_go_on_text_color, new AutoOrientationBtnDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.6
                @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.OnItemClickListener
                public void onItemClick(View view) {
                    sslErrorHandler.proceed();
                }
            })).setButton(new AutoOrientationBtnDialog.BtnItem(this.mContext.getText(R.string.aiapps_view_certificate), R.color.aiapps_safe_dialog_btn_black, new AutoOrientationBtnDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.5
                @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.OnItemClickListener
                public void onItemClick(View view) {
                    AiAppPageDialogsHandler.this.showSslCertificateOnError(bdSailorWebView, sslErrorHandler, sslError);
                }
            })).setButton(new AutoOrientationBtnDialog.BtnItem(this.mContext.getText(R.string.aiapps_ssl_go_back), R.color.aiapps_safe_dialog_btn_black, new AutoOrientationBtnDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.4
                @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.OnItemClickListener
                public void onItemClick(View view) {
                    sslErrorHandler.cancel();
                }
            })).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    sslErrorHandler.cancel();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSslCertificateOnError(final BdSailorWebView bdSailorWebView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        if (!canShowAlertDialog()) {
            sslErrorHandler.cancel();
            return;
        }
        SslCertificate certificate = sslError.getCertificate();
        if (certificate != null) {
            createSslCertificateDialog(certificate, sslError).setButton(new AutoOrientationBtnDialog.BtnItem(this.mContext.getText(R.string.aiapps_ssl_got_it), R.color.aiapps_safe_dialog_btn_black, new AutoOrientationBtnDialog.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.9
                @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.OnItemClickListener
                public void onItemClick(View view) {
                    bdSailorWebView.getWebViewClient().onReceivedSslError(bdSailorWebView, sslErrorHandler, sslError);
                }
            })).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.8
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    bdSailorWebView.getWebViewClient().onReceivedSslError(bdSailorWebView, sslErrorHandler, sslError);
                }
            }).show();
        }
    }

    private AiAppSslCertificateDialog.Builder createSslCertificateDialog(SslCertificate sslCertificate, SslError sslError) {
        View inflateCertificateView = inflateCertificateView(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) inflateCertificateView.findViewById(R.id.placeholder);
        inflateCertificateView.findViewById(R.id.ssl_divider).setBackgroundColor(this.mContext.getResources().getColor(R.color.aiapps_dialog_gray));
        if (sslError == null) {
            addAvailable(linearLayout, R.string.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                addError(linearLayout, R.string.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                addError(linearLayout, R.string.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                addError(linearLayout, R.string.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                addError(linearLayout, R.string.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                addError(linearLayout, R.string.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                addError(linearLayout, R.string.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                addError(linearLayout, R.string.aiapps_ssl_unknown);
            }
        }
        return new AiAppSslCertificateDialog.Builder(this.mContext).setTitle(R.string.aiapps_ssl_certificate).setContentView(inflateCertificateView);
    }

    public void copyToCb(String str) {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setText(str);
        UniversalToast.makeText(this.mContext, R.string.aiapps_ssl_copy_error).showToast();
    }

    private void addAvailable(LinearLayout linearLayout, int i) {
        addContentHeader(linearLayout, i, R.drawable.aiapps_dialog_browser_security_good);
    }

    private void addError(LinearLayout linearLayout, int i) {
        addContentHeader(linearLayout, i, R.drawable.aiapps_dialog_browser_security_bad);
    }

    private void addContentHeader(LinearLayout linearLayout, int i, int i2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(R.color.aiapps_safe_dialog_message));
        textView.setText(i);
        ((BdBaseImageView) inflate.findViewById(R.id.ssl_header_icon)).setImageResource(i2);
        linearLayout.addView(inflate);
    }

    private View inflateCertificateView(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.mContext.getResources().getColor(R.color.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.body);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(color);
                ((TextView) childAt).setTextSize(14.0f);
            }
            i = i2 + 1;
        }
        SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
        if (issuedTo != null) {
            ((TextView) inflate.findViewById(R.id.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(R.id.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(R.id.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(R.id.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(R.id.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(R.id.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(R.id.issued_on)).setText(formatCertificateDate(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(R.id.expires_on)).setText(formatCertificateDate(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    private String formatCertificateDate(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.mContext).format(date);
    }

    public boolean showJsAlert(String str, String str2, final JsResult jsResult) {
        if (!canShowAlertDialog()) {
            jsResult.cancel();
            return false;
        }
        AiAppAlertDialog.Builder onCancelListener = new AiAppAlertDialog.Builder(this.mContext).setTitle(R.string.aiapps_dialog_webcall_common_title).setMessage(str2).setPositiveButton(R.string.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.confirm();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.10
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            onCancelListener.show(false);
        } else {
            onCancelListener.show(true);
        }
        return true;
    }

    public boolean showJsConfirm(String str, String str2, final JsResult jsResult) {
        if (!canShowAlertDialog()) {
            jsResult.cancel();
            return false;
        }
        AiAppAlertDialog.Builder onCancelListener = new AiAppAlertDialog.Builder(this.mContext).setTitle(R.string.aiapps_dialog_webcall_common_title).setMessage(str2).setPositiveButton(R.string.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.confirm();
            }
        }).setNegativeButton(R.string.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.12
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            onCancelListener.show(false);
        } else {
            onCancelListener.show(true);
        }
        return true;
    }

    public boolean showJsPrompt(String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if (!canShowAlertDialog()) {
            jsPromptResult.cancel();
            return false;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_js_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(R.id.message)).setText(str2);
        AiAppAlertDialog.Builder onCancelListener = new AiAppAlertDialog.Builder(this.mContext).setTitle(R.string.aiapps_dialog_webcall_common_title).setView(inflate).setPositiveButton(R.string.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.17
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsPromptResult.confirm(editText.getText().toString());
            }
        }).setNegativeButton(R.string.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                jsPromptResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppPageDialogsHandler.15
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                jsPromptResult.cancel();
            }
        });
        if (AiAppNightModeHelper.getNightModeSwitcherState()) {
            onCancelListener.show(false);
        } else {
            onCancelListener.show(true);
        }
        return true;
    }

    public void showGeolocationDialog(String str, GeolocationPermissions.Callback callback) {
        if (canShowAlertDialog()) {
            if (checkBaiduOrigin(str)) {
                if (callback != null) {
                    callback.invoke(str, true, true);
                    return;
                }
                return;
            }
            this.mGeolocationDialog = new AiAppGeolocationDialog(this.mContext, str, callback);
            this.mGeolocationDialog.show();
        }
    }

    private boolean checkBaiduOrigin(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            for (String str2 : sBaiduOriginSet) {
                if (host.endsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void hideGeolocationDialog() {
        if (this.mGeolocationDialog != null) {
            this.mGeolocationDialog.hide();
            this.mGeolocationDialog = null;
        }
    }

    private boolean canShowAlertDialog() {
        return (this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing();
    }
}
