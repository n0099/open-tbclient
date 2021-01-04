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
    private final String cVP;
    private g cVQ;
    private TextView cVR;
    private TextView cVS;
    private b cVT;
    private InterfaceC0425a cVU;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0425a {
        void onCancel();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cVP = str2;
        atC();
    }

    private String getUsername() {
        return this.cVR.getText().toString();
    }

    private String getPassword() {
        return this.cVS.getText().toString();
    }

    public void a(b bVar) {
        this.cVT = bVar;
    }

    public void a(InterfaceC0425a interfaceC0425a) {
        this.cVU = interfaceC0425a;
    }

    public void show() {
        this.cVQ.show();
        this.cVR.requestFocus();
    }

    private void atC() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cVR = (TextView) inflate.findViewById(a.f.username_edit);
        this.cVS = (TextView) inflate.findViewById(a.f.password_edit);
        this.cVS.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.atD();
                    return true;
                }
                return false;
            }
        });
        this.cVQ = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cVP)).kx(17301543).aK(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.atD();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cVU != null) {
                    a.this.cVU.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cVU != null) {
                    a.this.cVU.onCancel();
                }
            }
        }).atG();
        this.cVQ.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        if (this.cVT != null) {
            this.cVT.r(this.mHost, this.cVP, getUsername(), getPassword());
        }
    }
}
