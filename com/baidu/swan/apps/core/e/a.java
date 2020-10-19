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
/* loaded from: classes10.dex */
public class a {
    private final String cxu;
    private g cxv;
    private TextView cxw;
    private TextView cxx;
    private b cxy;
    private InterfaceC0397a cxz;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0397a {
        void onCancel();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void q(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cxu = str2;
        alq();
    }

    private String getUsername() {
        return this.cxw.getText().toString();
    }

    private String getPassword() {
        return this.cxx.getText().toString();
    }

    public void a(b bVar) {
        this.cxy = bVar;
    }

    public void a(InterfaceC0397a interfaceC0397a) {
        this.cxz = interfaceC0397a;
    }

    public void show() {
        this.cxv.show();
        this.cxw.requestFocus();
    }

    private void alq() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cxw = (TextView) inflate.findViewById(a.f.username_edit);
        this.cxx = (TextView) inflate.findViewById(a.f.password_edit);
        this.cxx.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.alr();
                    return true;
                }
                return false;
            }
        });
        this.cxv = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cxu)).jF(17301543).av(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.alr();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cxz != null) {
                    a.this.cxz.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cxz != null) {
                    a.this.cxz.onCancel();
                }
            }
        }).alu();
        this.cxv.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alr() {
        if (this.cxy != null) {
            this.cxy.q(this.mHost, this.cxu, getUsername(), getPassword());
        }
    }
}
