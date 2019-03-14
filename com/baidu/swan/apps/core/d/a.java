package com.baidu.swan.apps.core.d;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.e;
/* loaded from: classes2.dex */
public class a {
    private final String HR;
    private final String arq;
    private com.baidu.swan.apps.res.widget.dialog.e arr;
    private TextView ars;
    private TextView art;
    private b aru;
    private InterfaceC0132a arv;
    private final Context mContext;

    /* renamed from: com.baidu.swan.apps.core.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0132a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.HR = str;
        this.arq = str2;
        zn();
    }

    private String getUsername() {
        return this.ars.getText().toString();
    }

    private String getPassword() {
        return this.art.getText().toString();
    }

    public void a(b bVar) {
        this.aru = bVar;
    }

    public void a(InterfaceC0132a interfaceC0132a) {
        this.arv = interfaceC0132a;
    }

    public void show() {
        this.arr.show();
        this.ars.requestFocus();
    }

    private void zn() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.ars = (TextView) inflate.findViewById(a.f.username_edit);
        this.art = (TextView) inflate.findViewById(a.f.password_edit);
        this.art.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.d.a.1
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
        this.arr = new e.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.HR).replace("%s2", this.arq)).dl(17301543).ad(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.zo();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.d.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.arv != null) {
                    a.this.arv.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.d.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.arv != null) {
                    a.this.arv.onCancel();
                }
            }
        }).zr();
        this.arr.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        if (this.aru != null) {
            this.aru.i(this.HR, this.arq, getUsername(), getPassword());
        }
    }
}
