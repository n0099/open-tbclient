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
/* loaded from: classes3.dex */
public class a {
    private final String clc;
    private g cld;
    private TextView cle;
    private TextView clf;
    private b clg;
    private InterfaceC0380a clh;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0380a {
        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void q(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.clc = str2;
        aiF();
    }

    private String getUsername() {
        return this.cle.getText().toString();
    }

    private String getPassword() {
        return this.clf.getText().toString();
    }

    public void a(b bVar) {
        this.clg = bVar;
    }

    public void a(InterfaceC0380a interfaceC0380a) {
        this.clh = interfaceC0380a;
    }

    public void show() {
        this.cld.show();
        this.cle.requestFocus();
    }

    private void aiF() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cle = (TextView) inflate.findViewById(a.f.username_edit);
        this.clf = (TextView) inflate.findViewById(a.f.password_edit);
        this.clf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.aiG();
                    return true;
                }
                return false;
            }
        });
        this.cld = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.clc)).ji(17301543).au(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.aiG();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.clh != null) {
                    a.this.clh.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.clh != null) {
                    a.this.clh.onCancel();
                }
            }
        }).aiJ();
        this.cld.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiG() {
        if (this.clg != null) {
            this.clg.q(this.mHost, this.clc, getUsername(), getPassword());
        }
    }
}
