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
/* loaded from: classes8.dex */
public class a {
    private final String cRd;
    private g cRe;
    private TextView cRf;
    private TextView cRg;
    private b cRh;
    private InterfaceC0408a cRi;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0408a {
        void onCancel();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cRd = str2;
        apI();
    }

    private String getUsername() {
        return this.cRf.getText().toString();
    }

    private String getPassword() {
        return this.cRg.getText().toString();
    }

    public void a(b bVar) {
        this.cRh = bVar;
    }

    public void a(InterfaceC0408a interfaceC0408a) {
        this.cRi = interfaceC0408a;
    }

    public void show() {
        this.cRe.show();
        this.cRf.requestFocus();
    }

    private void apI() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cRf = (TextView) inflate.findViewById(a.f.username_edit);
        this.cRg = (TextView) inflate.findViewById(a.f.password_edit);
        this.cRg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.apJ();
                    return true;
                }
                return false;
            }
        });
        this.cRe = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cRd)).iR(17301543).aK(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.apJ();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cRi != null) {
                    a.this.cRi.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cRi != null) {
                    a.this.cRi.onCancel();
                }
            }
        }).apM();
        this.cRe.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apJ() {
        if (this.cRh != null) {
            this.cRh.r(this.mHost, this.cRd, getUsername(), getPassword());
        }
    }
}
