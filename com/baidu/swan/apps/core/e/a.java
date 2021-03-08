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
    private final String cUQ;
    private g cUR;
    private TextView cUS;
    private TextView cUT;
    private b cUU;
    private InterfaceC0411a cUV;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0411a {
        void onCancel();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cUQ = str2;
        aqj();
    }

    private String getUsername() {
        return this.cUS.getText().toString();
    }

    private String getPassword() {
        return this.cUT.getText().toString();
    }

    public void a(b bVar) {
        this.cUU = bVar;
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.cUV = interfaceC0411a;
    }

    public void show() {
        this.cUR.show();
        this.cUS.requestFocus();
    }

    private void aqj() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cUS = (TextView) inflate.findViewById(a.f.username_edit);
        this.cUT = (TextView) inflate.findViewById(a.f.password_edit);
        this.cUT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.aqk();
                    return true;
                }
                return false;
            }
        });
        this.cUR = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cUQ)).iV(17301543).aG(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.aqk();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cUV != null) {
                    a.this.cUV.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cUV != null) {
                    a.this.cUV.onCancel();
                }
            }
        }).aqn();
        this.cUR.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqk() {
        if (this.cUU != null) {
            this.cUU.r(this.mHost, this.cUQ, getUsername(), getPassword());
        }
    }
}
