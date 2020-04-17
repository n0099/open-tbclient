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
    private b bNA;
    private InterfaceC0277a bNB;
    private final String bNw;
    private g bNx;
    private TextView bNy;
    private TextView bNz;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0277a {
        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void p(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.bNw = str2;
        WQ();
    }

    private String getUsername() {
        return this.bNy.getText().toString();
    }

    private String getPassword() {
        return this.bNz.getText().toString();
    }

    public void a(b bVar) {
        this.bNA = bVar;
    }

    public void a(InterfaceC0277a interfaceC0277a) {
        this.bNB = interfaceC0277a;
    }

    public void show() {
        this.bNx.show();
        this.bNy.requestFocus();
    }

    private void WQ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bNy = (TextView) inflate.findViewById(a.f.username_edit);
        this.bNz = (TextView) inflate.findViewById(a.f.password_edit);
        this.bNz.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.WR();
                    return true;
                }
                return false;
            }
        });
        this.bNx = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bNw)).gc(17301543).ao(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.WR();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bNB != null) {
                    a.this.bNB.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bNB != null) {
                    a.this.bNB.onCancel();
                }
            }
        }).WU();
        this.bNx.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WR() {
        if (this.bNA != null) {
            this.bNA.p(this.mHost, this.bNw, getUsername(), getPassword());
        }
    }
}
