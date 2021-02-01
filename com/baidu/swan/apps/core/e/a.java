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
    private final String cTq;
    private g cTr;
    private TextView cTs;
    private TextView cTt;
    private b cTu;
    private InterfaceC0405a cTv;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0405a {
        void onCancel();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cTq = str2;
        aqg();
    }

    private String getUsername() {
        return this.cTs.getText().toString();
    }

    private String getPassword() {
        return this.cTt.getText().toString();
    }

    public void a(b bVar) {
        this.cTu = bVar;
    }

    public void a(InterfaceC0405a interfaceC0405a) {
        this.cTv = interfaceC0405a;
    }

    public void show() {
        this.cTr.show();
        this.cTs.requestFocus();
    }

    private void aqg() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cTs = (TextView) inflate.findViewById(a.f.username_edit);
        this.cTt = (TextView) inflate.findViewById(a.f.password_edit);
        this.cTt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.aqh();
                    return true;
                }
                return false;
            }
        });
        this.cTr = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cTq)).iU(17301543).aG(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.aqh();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cTv != null) {
                    a.this.cTv.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cTv != null) {
                    a.this.cTv.onCancel();
                }
            }
        }).aqk();
        this.cTr.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        if (this.cTu != null) {
            this.cTu.r(this.mHost, this.cTq, getUsername(), getPassword());
        }
    }
}
