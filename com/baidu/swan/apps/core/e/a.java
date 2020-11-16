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
/* loaded from: classes7.dex */
public class a {
    private final String cJZ;
    private g cKa;
    private TextView cKb;
    private TextView cKc;
    private b cKd;
    private InterfaceC0421a cKe;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0421a {
        void onCancel();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cJZ = str2;
        apc();
    }

    private String getUsername() {
        return this.cKb.getText().toString();
    }

    private String getPassword() {
        return this.cKc.getText().toString();
    }

    public void a(b bVar) {
        this.cKd = bVar;
    }

    public void a(InterfaceC0421a interfaceC0421a) {
        this.cKe = interfaceC0421a;
    }

    public void show() {
        this.cKa.show();
        this.cKb.requestFocus();
    }

    private void apc() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cKb = (TextView) inflate.findViewById(a.f.username_edit);
        this.cKc = (TextView) inflate.findViewById(a.f.password_edit);
        this.cKc.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.apd();
                    return true;
                }
                return false;
            }
        });
        this.cKa = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cJZ)).jW(17301543).aA(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.apd();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cKe != null) {
                    a.this.cKe.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cKe != null) {
                    a.this.cKe.onCancel();
                }
            }
        }).apg();
        this.cKa.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apd() {
        if (this.cKd != null) {
            this.cKd.r(this.mHost, this.cJZ, getUsername(), getPassword());
        }
    }
}
