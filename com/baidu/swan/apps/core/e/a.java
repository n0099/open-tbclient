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
    private final String cFQ;
    private g cFR;
    private TextView cFS;
    private TextView cFT;
    private b cFU;
    private InterfaceC0411a cFV;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0411a {
        void onCancel();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cFQ = str2;
        ank();
    }

    private String getUsername() {
        return this.cFS.getText().toString();
    }

    private String getPassword() {
        return this.cFT.getText().toString();
    }

    public void a(b bVar) {
        this.cFU = bVar;
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.cFV = interfaceC0411a;
    }

    public void show() {
        this.cFR.show();
        this.cFS.requestFocus();
    }

    private void ank() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cFS = (TextView) inflate.findViewById(a.f.username_edit);
        this.cFT = (TextView) inflate.findViewById(a.f.password_edit);
        this.cFT.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.anl();
                    return true;
                }
                return false;
            }
        });
        this.cFR = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cFQ)).jQ(17301543).aw(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.anl();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cFV != null) {
                    a.this.cFV.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cFV != null) {
                    a.this.cFV.onCancel();
                }
            }
        }).ano();
        this.cFR.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anl() {
        if (this.cFU != null) {
            this.cFU.r(this.mHost, this.cFQ, getUsername(), getPassword());
        }
    }
}
