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
    private final String FB;
    private final String arB;
    private g arC;
    private TextView arD;
    private TextView arE;
    private b arF;
    private InterfaceC0135a arG;
    private final Context mContext;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0135a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.FB = str;
        this.arB = str2;
        Am();
    }

    private String getUsername() {
        return this.arD.getText().toString();
    }

    private String getPassword() {
        return this.arE.getText().toString();
    }

    public void a(b bVar) {
        this.arF = bVar;
    }

    public void a(InterfaceC0135a interfaceC0135a) {
        this.arG = interfaceC0135a;
    }

    public void show() {
        this.arC.show();
        this.arD.requestFocus();
    }

    private void Am() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.arD = (TextView) inflate.findViewById(a.f.username_edit);
        this.arE = (TextView) inflate.findViewById(a.f.password_edit);
        this.arE.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.An();
                    return true;
                }
                return false;
            }
        });
        this.arC = new g.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.FB).replace("%s2", this.arB)).dr(17301543).ad(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.An();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.arG != null) {
                    a.this.arG.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.arG != null) {
                    a.this.arG.onCancel();
                }
            }
        }).Aq();
        this.arC.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An() {
        if (this.arF != null) {
            this.arF.i(this.FB, this.arB, getUsername(), getPassword());
        }
    }
}
