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
    private final String cjb;
    private g cjc;
    private TextView cjd;
    private TextView cje;
    private b cjf;
    private InterfaceC0385a cjg;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0385a {
        void onCancel();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void q(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cjb = str2;
        ahV();
    }

    private String getUsername() {
        return this.cjd.getText().toString();
    }

    private String getPassword() {
        return this.cje.getText().toString();
    }

    public void a(b bVar) {
        this.cjf = bVar;
    }

    public void a(InterfaceC0385a interfaceC0385a) {
        this.cjg = interfaceC0385a;
    }

    public void show() {
        this.cjc.show();
        this.cjd.requestFocus();
    }

    private void ahV() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cjd = (TextView) inflate.findViewById(a.f.username_edit);
        this.cje = (TextView) inflate.findViewById(a.f.password_edit);
        this.cje.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.ahW();
                    return true;
                }
                return false;
            }
        });
        this.cjc = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cjb)).iX(17301543).as(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.ahW();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cjg != null) {
                    a.this.cjg.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cjg != null) {
                    a.this.cjg.onCancel();
                }
            }
        }).ahZ();
        this.cjc.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahW() {
        if (this.cjf != null) {
            this.cjf.q(this.mHost, this.cjb, getUsername(), getPassword());
        }
    }
}
