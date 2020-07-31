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
    private final String ccY;
    private g ccZ;
    private TextView cda;
    private TextView cdb;
    private b cdc;
    private InterfaceC0345a cdd;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0345a {
        void onCancel();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void q(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.ccY = str2;
        abJ();
    }

    private String getUsername() {
        return this.cda.getText().toString();
    }

    private String getPassword() {
        return this.cdb.getText().toString();
    }

    public void a(b bVar) {
        this.cdc = bVar;
    }

    public void a(InterfaceC0345a interfaceC0345a) {
        this.cdd = interfaceC0345a;
    }

    public void show() {
        this.ccZ.show();
        this.cda.requestFocus();
    }

    private void abJ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cda = (TextView) inflate.findViewById(a.f.username_edit);
        this.cdb = (TextView) inflate.findViewById(a.f.password_edit);
        this.cdb.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.abK();
                    return true;
                }
                return false;
            }
        });
        this.ccZ = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.ccY)).gQ(17301543).ar(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.abK();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cdd != null) {
                    a.this.cdd.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cdd != null) {
                    a.this.cdd.onCancel();
                }
            }
        }).abN();
        this.ccZ.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abK() {
        if (this.cdc != null) {
            this.cdc.q(this.mHost, this.ccY, getUsername(), getPassword());
        }
    }
}
