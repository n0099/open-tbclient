package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.ClipboardManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.a;
import com.baidu.swan.apps.core.d.c;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.widget.dialog.a;
import com.baidu.swan.apps.res.widget.dialog.e;
import java.util.Date;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.swan.apps.core.d.a arw;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void X(String str, String str2);

        void xA();
    }

    /* renamed from: com.baidu.swan.apps.core.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0104b {
        void dC(String str);

        void onCancel();

        void xx();
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onReject();

        void xy();

        void xz();
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void a(final a aVar, String str, String str2) {
        this.arw = new com.baidu.swan.apps.core.d.a(this.mContext, str, str2);
        this.arw.a(new a.b() { // from class: com.baidu.swan.apps.core.d.b.1
            @Override // com.baidu.swan.apps.core.d.a.b
            public void i(String str3, String str4, String str5, String str6) {
                if (aVar != null) {
                    aVar.X(str5, str6);
                }
                b.this.arw = null;
            }
        });
        this.arw.a(new a.InterfaceC0103a() { // from class: com.baidu.swan.apps.core.d.b.10
            @Override // com.baidu.swan.apps.core.d.a.InterfaceC0103a
            public void onCancel() {
                if (aVar != null) {
                    aVar.xA();
                }
                b.this.arw = null;
            }
        });
        this.arw.show();
    }

    public void a(final c cVar, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        if (!zp()) {
            sslErrorHandler.cancel();
        } else {
            new c.a(this.mContext).cn(b.h.aiapps_security_warning).a(b.h.aiapps_ssl_warnings_header, new a.c() { // from class: com.baidu.swan.apps.core.d.b.15
                private long[] apL = null;

                @Override // com.baidu.swan.apps.res.widget.dialog.a.c
                public void U(View view) {
                    if (this.apL == null) {
                        this.apL = new long[5];
                    }
                    System.arraycopy(this.apL, 1, this.apL, 0, this.apL.length - 1);
                    this.apL[this.apL.length - 1] = SystemClock.uptimeMillis();
                    if (this.apL[0] >= SystemClock.uptimeMillis() - 3000) {
                        this.apL = null;
                        b.this.dZ(sslError.toString());
                    }
                }
            }).a(new a.C0134a(this.mContext.getText(b.h.aiapps_ssl_continue), b.c.aiapps_ssl_dialog_go_on_text_color, new a.c() { // from class: com.baidu.swan.apps.core.d.b.14
                @Override // com.baidu.swan.apps.res.widget.dialog.a.c
                public void U(View view) {
                    if (cVar != null) {
                        cVar.xy();
                    }
                }
            })).a(new a.C0134a(this.mContext.getText(b.h.aiapps_view_certificate), b.c.aiapps_safe_dialog_btn_black, new a.c() { // from class: com.baidu.swan.apps.core.d.b.13
                @Override // com.baidu.swan.apps.res.widget.dialog.a.c
                public void U(View view) {
                    b.this.b(cVar, sslErrorHandler, sslError);
                }
            })).a(new a.C0134a(this.mContext.getText(b.h.aiapps_ssl_go_back), b.c.aiapps_safe_dialog_btn_black, new a.c() { // from class: com.baidu.swan.apps.core.d.b.12
                @Override // com.baidu.swan.apps.res.widget.dialog.a.c
                public void U(View view) {
                    if (cVar != null) {
                        cVar.onReject();
                    }
                }
            })).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.11
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    sslErrorHandler.cancel();
                }
            }).Iu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!zp()) {
            sslErrorHandler.cancel();
            return;
        }
        SslCertificate certificate = sslError.getCertificate();
        if (certificate != null) {
            a(certificate, sslError).a(new a.C0134a(this.mContext.getText(b.h.aiapps_ssl_got_it), b.c.aiapps_safe_dialog_btn_black, new a.c() { // from class: com.baidu.swan.apps.core.d.b.17
                @Override // com.baidu.swan.apps.res.widget.dialog.a.c
                public void U(View view) {
                    if (cVar != null) {
                        cVar.xz();
                    }
                }
            })).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (cVar != null) {
                        cVar.xz();
                    }
                }
            }).Iu();
        }
    }

    private d.a a(SslCertificate sslCertificate, SslError sslError) {
        View b = b(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) b.findViewById(b.f.placeholder);
        b.findViewById(b.f.ssl_divider).setBackgroundColor(this.mContext.getResources().getColor(b.c.aiapps_dialog_gray));
        if (sslError == null) {
            a(linearLayout, b.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                b(linearLayout, b.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                b(linearLayout, b.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                b(linearLayout, b.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                b(linearLayout, b.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                b(linearLayout, b.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                b(linearLayout, b.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                b(linearLayout, b.h.aiapps_ssl_unknown);
            }
        }
        return new d.a(this.mContext).cn(b.h.aiapps_ssl_certificate).V(b);
    }

    public void dZ(String str) {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setText(str);
        com.baidu.swan.apps.res.widget.b.d.l(this.mContext, b.h.aiapps_ssl_copy_error).IK();
    }

    private void a(LinearLayout linearLayout, int i) {
        a(linearLayout, i, b.e.aiapps_dialog_browser_security_good);
    }

    private void b(LinearLayout linearLayout, int i) {
        a(linearLayout, i, b.e.aiapps_dialog_browser_security_bad);
    }

    private void a(LinearLayout linearLayout, int i, int i2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(b.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(b.c.aiapps_safe_dialog_message));
        textView.setText(i);
        ((BdBaseImageView) inflate.findViewById(b.f.ssl_header_icon)).setImageResource(i2);
        linearLayout.addView(inflate);
    }

    private View b(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.mContext.getResources().getColor(b.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(b.f.body);
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
            ((TextView) inflate.findViewById(b.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(b.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(b.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(b.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(b.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(b.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(b.f.issued_on)).setText(f(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(b.f.expires_on)).setText(f(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    private String f(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.mContext).format(date);
    }

    public boolean a(String str, String str2, final InterfaceC0104b interfaceC0104b) {
        if (!zp()) {
            if (DEBUG) {
                Log.e(TAG, "can not showJsAlert");
            }
            if (interfaceC0104b != null) {
                interfaceC0104b.xx();
                return false;
            }
            return false;
        }
        e.a a2 = new e.a(this.mContext).cn(b.h.aiapps_dialog_webcall_common_title).gd(str2).b(b.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.dC("");
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            a2.bT(false);
        } else {
            a2.bT(true);
        }
        return true;
    }

    public boolean b(String str, String str2, final InterfaceC0104b interfaceC0104b) {
        if (!zp()) {
            if (DEBUG) {
                Log.e(TAG, "can not showJsConfirm");
            }
            if (interfaceC0104b != null) {
                interfaceC0104b.xx();
                return false;
            }
            return false;
        }
        e.a a2 = new e.a(this.mContext).cn(b.h.aiapps_dialog_webcall_common_title).gd(str2).b(b.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.dC("");
                }
            }
        }).c(b.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            a2.bT(false);
        } else {
            a2.bT(true);
        }
        return true;
    }

    public boolean a(String str, String str2, String str3, final InterfaceC0104b interfaceC0104b) {
        if (!zp()) {
            if (interfaceC0104b != null) {
                interfaceC0104b.xx();
            }
            return false;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_js_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(b.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(b.f.message)).setText(str2);
        e.a a2 = new e.a(this.mContext).cn(b.h.aiapps_dialog_webcall_common_title).ad(inflate).b(b.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.dC(editText.getText().toString());
                }
            }
        }).c(b.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.b.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.b.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0104b != null) {
                    interfaceC0104b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.u.a.CT().Ds()) {
            a2.bT(false);
        } else {
            a2.bT(true);
        }
        return true;
    }

    private boolean zp() {
        return (this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing();
    }
}
