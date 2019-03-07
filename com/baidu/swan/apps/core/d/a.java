package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.e;
/* loaded from: classes2.dex */
public class a {
    private final String HR;
    private final String arp;
    private com.baidu.swan.apps.res.widget.dialog.e arq;
    private TextView arr;
    private TextView ars;
    private b art;
    private InterfaceC0103a aru;
    private final Context mContext;

    /* renamed from: com.baidu.swan.apps.core.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0103a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.HR = str;
        this.arp = str2;
        zn();
    }

    private String getUsername() {
        return this.arr.getText().toString();
    }

    private String getPassword() {
        return this.ars.getText().toString();
    }

    public void a(b bVar) {
        this.art = bVar;
    }

    public void a(InterfaceC0103a interfaceC0103a) {
        this.aru = interfaceC0103a;
    }

    public void show() {
        this.arq.show();
        this.arr.requestFocus();
    }

    private void zn() {
        View inflate = LayoutInflater.from(this.mContext).inflate(b.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.arr = (TextView) inflate.findViewById(b.f.username_edit);
        this.ars = (TextView) inflate.findViewById(b.f.password_edit);
        this.ars.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.d.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.zo();
                    return true;
                }
                return false;
            }
        });
        this.arq = new e.a(this.mContext).d(this.mContext.getText(b.h.aiapps_sign_in_to).toString().replace("%s1", this.HR).replace("%s2", this.arp)).dl(17301543).ad(inflate).b(b.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.zo();
            }
        }).c(b.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.aru != null) {
                    a.this.aru.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.aru != null) {
                    a.this.aru.onCancel();
                }
            }
        }).zr();
        this.arq.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        if (this.art != null) {
            this.art.i(this.HR, this.arp, getUsername(), getPassword());
        }
    }
}
