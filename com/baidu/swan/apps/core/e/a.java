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
/* loaded from: classes2.dex */
public class a {
    private final String FI;
    private final String ase;
    private g asf;
    private TextView asg;
    private TextView ash;
    private b asi;
    private InterfaceC0137a asj;
    private final Context mContext;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0137a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.FI = str;
        this.ase = str2;
        AT();
    }

    private String getUsername() {
        return this.asg.getText().toString();
    }

    private String getPassword() {
        return this.ash.getText().toString();
    }

    public void a(b bVar) {
        this.asi = bVar;
    }

    public void a(InterfaceC0137a interfaceC0137a) {
        this.asj = interfaceC0137a;
    }

    public void show() {
        this.asf.show();
        this.asg.requestFocus();
    }

    private void AT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.asg = (TextView) inflate.findViewById(a.f.username_edit);
        this.ash = (TextView) inflate.findViewById(a.f.password_edit);
        this.ash.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.AU();
                    return true;
                }
                return false;
            }
        });
        this.asf = new g.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.FI).replace("%s2", this.ase)).du(17301543).af(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.AU();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.asj != null) {
                    a.this.asj.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.asj != null) {
                    a.this.asj.onCancel();
                }
            }
        }).AX();
        this.asf.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        if (this.asi != null) {
            this.asi.i(this.FI, this.ase, getUsername(), getPassword());
        }
    }
}
