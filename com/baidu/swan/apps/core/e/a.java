package com.baidu.swan.apps.core.e;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes9.dex */
public class a {
    private final String bkc;
    private g bkd;
    private TextView bke;
    private TextView bkf;
    private b bkg;
    private InterfaceC0235a bkh;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0235a {
        void onCancel();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void m(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.bkc = str2;
        Mm();
    }

    private String getUsername() {
        return this.bke.getText().toString();
    }

    private String getPassword() {
        return this.bkf.getText().toString();
    }

    public void a(b bVar) {
        this.bkg = bVar;
    }

    public void a(InterfaceC0235a interfaceC0235a) {
        this.bkh = interfaceC0235a;
    }

    public void show() {
        this.bkd.show();
        this.bke.requestFocus();
    }

    private void Mm() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bke = (TextView) inflate.findViewById(a.f.username_edit);
        this.bkf = (TextView) inflate.findViewById(a.f.password_edit);
        this.bkf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.Mn();
                    return true;
                }
                return false;
            }
        });
        this.bkd = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bkc)).fE(17301543).aj(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.Mn();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bkh != null) {
                    a.this.bkh.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bkh != null) {
                    a.this.bkh.onCancel();
                }
            }
        }).Mq();
        this.bkd.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        if (this.bkg != null) {
            this.bkg.m(this.mHost, this.bkc, getUsername(), getPassword());
        }
    }
}
