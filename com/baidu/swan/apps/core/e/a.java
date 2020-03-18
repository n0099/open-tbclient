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
    private final String bpp;
    private g bpq;
    private TextView bpr;
    private TextView bps;
    private b bpt;
    private InterfaceC0247a bpu;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0247a {
        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void p(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.bpp = str2;
        Pb();
    }

    private String getUsername() {
        return this.bpr.getText().toString();
    }

    private String getPassword() {
        return this.bps.getText().toString();
    }

    public void a(b bVar) {
        this.bpt = bVar;
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        this.bpu = interfaceC0247a;
    }

    public void show() {
        this.bpq.show();
        this.bpr.requestFocus();
    }

    private void Pb() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bpr = (TextView) inflate.findViewById(a.f.username_edit);
        this.bps = (TextView) inflate.findViewById(a.f.password_edit);
        this.bps.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.Pc();
                    return true;
                }
                return false;
            }
        });
        this.bpq = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bpp)).fV(17301543).an(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.Pc();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bpu != null) {
                    a.this.bpu.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bpu != null) {
                    a.this.bpu.onCancel();
                }
            }
        }).Pf();
        this.bpq.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() {
        if (this.bpt != null) {
            this.bpt.p(this.mHost, this.bpp, getUsername(), getPassword());
        }
    }
}
