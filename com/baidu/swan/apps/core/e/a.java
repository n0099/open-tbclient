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
    private final String bpc;
    private g bpd;
    private TextView bpe;
    private TextView bpf;
    private b bpg;
    private InterfaceC0247a bph;
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
        this.bpc = str2;
        OY();
    }

    private String getUsername() {
        return this.bpe.getText().toString();
    }

    private String getPassword() {
        return this.bpf.getText().toString();
    }

    public void a(b bVar) {
        this.bpg = bVar;
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        this.bph = interfaceC0247a;
    }

    public void show() {
        this.bpd.show();
        this.bpe.requestFocus();
    }

    private void OY() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.bpe = (TextView) inflate.findViewById(a.f.username_edit);
        this.bpf = (TextView) inflate.findViewById(a.f.password_edit);
        this.bpf.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.OZ();
                    return true;
                }
                return false;
            }
        });
        this.bpd = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.bpc)).fV(17301543).an(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.OZ();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.bph != null) {
                    a.this.bph.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.bph != null) {
                    a.this.bph.onCancel();
                }
            }
        }).Pc();
        this.bpd.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OZ() {
        if (this.bpg != null) {
            this.bpg.p(this.mHost, this.bpc, getUsername(), getPassword());
        }
    }
}
