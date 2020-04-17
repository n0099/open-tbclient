package com.baidu.swan.apps.core.e;

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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.e.a;
import com.baidu.swan.apps.core.e.c;
import com.baidu.swan.apps.core.e.d;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.swan.apps.res.widget.dialog.b;
import com.baidu.swan.apps.res.widget.dialog.g;
import java.util.Date;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = b.class.getSimpleName();
    private com.baidu.swan.apps.core.e.a bND;
    private Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        void UQ();

        void aD(String str, String str2);
    }

    /* renamed from: com.baidu.swan.apps.core.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0278b {
        void UM();

        void ia(String str);

        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void UN();

        void UO();

        void UP();
    }

    public b(Context context) {
        this.mContext = context;
    }

    public void a(final a aVar, String str, String str2) {
        this.bND = new com.baidu.swan.apps.core.e.a(this.mContext, str, str2);
        this.bND.a(new a.b() { // from class: com.baidu.swan.apps.core.e.b.1
            @Override // com.baidu.swan.apps.core.e.a.b
            public void p(String str3, String str4, String str5, String str6) {
                if (aVar != null) {
                    aVar.aD(str5, str6);
                }
                b.this.bND = null;
            }
        });
        this.bND.a(new a.InterfaceC0277a() { // from class: com.baidu.swan.apps.core.e.b.10
            @Override // com.baidu.swan.apps.core.e.a.InterfaceC0277a
            public void onCancel() {
                if (aVar != null) {
                    aVar.UQ();
                }
                b.this.bND = null;
            }
        });
        this.bND.show();
    }

    public void a(final c cVar, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        if (!WS()) {
            sslErrorHandler.cancel();
        } else {
            new c.a(this.mContext).eI(a.h.aiapps_security_warning).a(a.h.aiapps_ssl_warnings_header, new b.c() { // from class: com.baidu.swan.apps.core.e.b.15
                private long[] bLF = null;

                @Override // com.baidu.swan.apps.res.widget.dialog.b.c
                public void onItemClick(View view) {
                    if (this.bLF == null) {
                        this.bLF = new long[5];
                    }
                    System.arraycopy(this.bLF, 1, this.bLF, 0, this.bLF.length - 1);
                    this.bLF[this.bLF.length - 1] = SystemClock.uptimeMillis();
                    if (this.bLF[0] >= SystemClock.uptimeMillis() - 3000) {
                        this.bLF = null;
                        b.this.it(sslError.toString());
                    }
                }
            }).a(new b.a(this.mContext.getText(a.h.aiapps_ssl_continue), a.c.aiapps_ssl_dialog_go_on_text_color, new b.c() { // from class: com.baidu.swan.apps.core.e.b.14
                @Override // com.baidu.swan.apps.res.widget.dialog.b.c
                public void onItemClick(View view) {
                    if (cVar != null) {
                        cVar.UN();
                    }
                }
            })).a(new b.a(this.mContext.getText(a.h.aiapps_view_certificate), a.c.aiapps_safe_dialog_btn_black, new b.c() { // from class: com.baidu.swan.apps.core.e.b.13
                @Override // com.baidu.swan.apps.res.widget.dialog.b.c
                public void onItemClick(View view) {
                    b.this.b(cVar, sslErrorHandler, sslError);
                }
            })).a(new b.a(this.mContext.getText(a.h.aiapps_ssl_go_back), a.c.aiapps_safe_dialog_btn_black, new b.c() { // from class: com.baidu.swan.apps.core.e.b.12
                @Override // com.baidu.swan.apps.res.widget.dialog.b.c
                public void onItemClick(View view) {
                    if (cVar != null) {
                        cVar.UO();
                    }
                }
            })).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.b.11
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    sslErrorHandler.cancel();
                }
            }).akx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final c cVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!WS()) {
            sslErrorHandler.cancel();
            return;
        }
        SslCertificate certificate = sslError.getCertificate();
        if (certificate != null) {
            a(certificate, sslError).a(new b.a(this.mContext.getText(a.h.aiapps_ssl_got_it), a.c.aiapps_safe_dialog_btn_black, new b.c() { // from class: com.baidu.swan.apps.core.e.b.17
                @Override // com.baidu.swan.apps.res.widget.dialog.b.c
                public void onItemClick(View view) {
                    if (cVar != null) {
                        cVar.UP();
                    }
                }
            })).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.b.16
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (cVar != null) {
                        cVar.UP();
                    }
                }
            }).akx();
        }
    }

    private d.a a(SslCertificate sslCertificate, SslError sslError) {
        View b = b(sslCertificate);
        LinearLayout linearLayout = (LinearLayout) b.findViewById(a.f.placeholder);
        b.findViewById(a.f.ssl_divider).setBackgroundColor(this.mContext.getResources().getColor(a.c.aiapps_dialog_gray));
        if (sslError == null) {
            a(linearLayout, a.h.aiapps_ssl_certificate_is_valid);
        } else {
            if (sslError.hasError(3)) {
                b(linearLayout, a.h.aiapps_ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                b(linearLayout, a.h.aiapps_ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                b(linearLayout, a.h.aiapps_ssl_expired);
            }
            if (sslError.hasError(0)) {
                b(linearLayout, a.h.aiapps_ssl_not_yet_valid);
            }
            if (sslError.hasError(4)) {
                b(linearLayout, a.h.aiapps_ssl_date_invalid);
            }
            if (sslError.hasError(5)) {
                b(linearLayout, a.h.aiapps_ssl_invalid);
            }
            if (linearLayout.getChildCount() == 0) {
                b(linearLayout, a.h.aiapps_ssl_unknown);
            }
        }
        return new d.a(this.mContext).eI(a.h.aiapps_ssl_certificate).ak(b);
    }

    public void it(String str) {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setText(str);
        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_ssl_copy_error).showToast();
    }

    private void a(LinearLayout linearLayout, int i) {
        a(linearLayout, i, a.e.aiapps_dialog_browser_security_good);
    }

    private void b(LinearLayout linearLayout, int i) {
        a(linearLayout, i, a.e.aiapps_dialog_browser_security_bad);
    }

    private void a(LinearLayout linearLayout, int i, int i2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_ssl_content_header, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) inflate.findViewById(a.f.ssl_header_text);
        textView.setTextColor(inflate.getContext().getResources().getColor(a.c.aiapps_safe_dialog_message));
        textView.setText(i);
        ((BdBaseImageView) inflate.findViewById(a.f.ssl_header_icon)).setImageResource(i2);
        linearLayout.addView(inflate);
    }

    private View b(SslCertificate sslCertificate) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_ssl_certificate, (ViewGroup) null);
        int color = this.mContext.getResources().getColor(a.c.aiapps_safe_dialog_message);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(a.f.body);
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
            ((TextView) inflate.findViewById(a.f.to_common)).setText(issuedTo.getCName());
            ((TextView) inflate.findViewById(a.f.to_org)).setText(issuedTo.getOName());
            ((TextView) inflate.findViewById(a.f.to_org_unit)).setText(issuedTo.getUName());
        }
        SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
        if (issuedBy != null) {
            ((TextView) inflate.findViewById(a.f.by_common)).setText(issuedBy.getCName());
            ((TextView) inflate.findViewById(a.f.by_org)).setText(issuedBy.getOName());
            ((TextView) inflate.findViewById(a.f.by_org_unit)).setText(issuedBy.getUName());
        }
        ((TextView) inflate.findViewById(a.f.issued_on)).setText(c(sslCertificate.getValidNotBeforeDate()));
        ((TextView) inflate.findViewById(a.f.expires_on)).setText(c(sslCertificate.getValidNotAfterDate()));
        return inflate;
    }

    private String c(Date date) {
        return date == null ? "" : DateFormat.getDateFormat(this.mContext).format(date);
    }

    public boolean a(String str, String str2, final InterfaceC0278b interfaceC0278b) {
        if (!WS()) {
            if (DEBUG) {
                Log.e(TAG, "can not showJsAlert");
            }
            if (interfaceC0278b != null) {
                interfaceC0278b.UM();
                return false;
            }
            return false;
        }
        g.a a2 = new g.a(this.mContext).eI(a.h.aiapps_dialog_webcall_common_title).lV(str2).c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.ia("");
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.b.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
            a2.eC(false);
        } else {
            a2.eC(true);
        }
        return true;
    }

    public boolean b(String str, String str2, final InterfaceC0278b interfaceC0278b) {
        if (!WS()) {
            if (DEBUG) {
                Log.e(TAG, "can not showJsConfirm");
            }
            if (interfaceC0278b != null) {
                interfaceC0278b.UM();
                return false;
            }
            return false;
        }
        g.a a2 = new g.a(this.mContext).eI(a.h.aiapps_dialog_webcall_common_title).lV(str2).c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.b.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.ia("");
                }
            }
        }).d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.b.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.b.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
            a2.eC(false);
        } else {
            a2.eC(true);
        }
        return true;
    }

    public boolean a(String str, String str2, String str3, final InterfaceC0278b interfaceC0278b) {
        if (!WS()) {
            if (interfaceC0278b != null) {
                interfaceC0278b.UM();
            }
            return false;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_js_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(a.f.value);
        editText.setText(str3);
        ((TextView) inflate.findViewById(a.f.message)).setText(str2);
        g.a a2 = new g.a(this.mContext).eI(a.h.aiapps_dialog_webcall_common_title).ao(inflate).c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.b.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.ia(editText.getText().toString());
                }
            }
        }).d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.b.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.b.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (interfaceC0278b != null) {
                    interfaceC0278b.onCancel();
                }
            }
        });
        if (com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState()) {
            a2.eC(false);
        } else {
            a2.eC(true);
        }
        return true;
    }

    private boolean WS() {
        return (this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing();
    }
}
