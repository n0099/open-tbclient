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
/* loaded from: classes11.dex */
public class a {
    private final String bNB;
    private g bNC;
    private TextView bND;
    private TextView bNE;
    private b bNF;
    private InterfaceC0298a bNG;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0298a {
        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void p(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.bNB = str2;
        WP();
    }

    private String getUsername() {
        return this.bND.getText().toString();
    }

    private String getPassword() {
        return this.bNE.getText().toString();
    }

    public void a(b bVar) {
        this.bNF = bVar;
    }

    public void a(InterfaceC0298a interfaceC0298a) {
        this.bNG = interfaceC0298a;
    }

    public void show() {
        this.bNC.show();
        this.bND.requestFocus();
    }

    private void WP() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bND = (TextView) inflate.findViewById(a.f.username_edit);
        this.bNE = (TextView) inflate.findViewById(a.f.password_edit);
        this.bNE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.WQ();
                    return true;
                }
                return false;
            }
        });
        this.bNC = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bNB)).gc(17301543).ao(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.WQ();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bNG != null) {
                    a.this.bNG.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bNG != null) {
                    a.this.bNG.onCancel();
                }
            }
        }).WT();
        this.bNC.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WQ() {
        if (this.bNF != null) {
            this.bNF.p(this.mHost, this.bNB, getUsername(), getPassword());
        }
    }
}
