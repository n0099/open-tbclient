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
    private final String bkR;
    private g bkS;
    private TextView bkT;
    private TextView bkU;
    private b bkV;
    private InterfaceC0237a bkW;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0237a {
        void onCancel();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void m(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.bkR = str2;
        MI();
    }

    private String getUsername() {
        return this.bkT.getText().toString();
    }

    private String getPassword() {
        return this.bkU.getText().toString();
    }

    public void a(b bVar) {
        this.bkV = bVar;
    }

    public void a(InterfaceC0237a interfaceC0237a) {
        this.bkW = interfaceC0237a;
    }

    public void show() {
        this.bkS.show();
        this.bkT.requestFocus();
    }

    private void MI() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bkT = (TextView) inflate.findViewById(a.f.username_edit);
        this.bkU = (TextView) inflate.findViewById(a.f.password_edit);
        this.bkU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.MJ();
                    return true;
                }
                return false;
            }
        });
        this.bkS = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bkR)).fF(17301543).an(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.MJ();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bkW != null) {
                    a.this.bkW.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bkW != null) {
                    a.this.bkW.onCancel();
                }
            }
        }).MM();
        this.bkS.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        if (this.bkV != null) {
            this.bkV.m(this.mHost, this.bkR, getUsername(), getPassword());
        }
    }
}
