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
    private final String asC;
    private g asD;
    private TextView asE;
    private TextView asF;
    private b asG;
    private InterfaceC0146a asH;
    private final Context mContext;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0146a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void i(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.FI = str;
        this.asC = str2;
        AX();
    }

    private String getUsername() {
        return this.asE.getText().toString();
    }

    private String getPassword() {
        return this.asF.getText().toString();
    }

    public void a(b bVar) {
        this.asG = bVar;
    }

    public void a(InterfaceC0146a interfaceC0146a) {
        this.asH = interfaceC0146a;
    }

    public void show() {
        this.asD.show();
        this.asE.requestFocus();
    }

    private void AX() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.asE = (TextView) inflate.findViewById(a.f.username_edit);
        this.asF = (TextView) inflate.findViewById(a.f.password_edit);
        this.asF.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.AY();
                    return true;
                }
                return false;
            }
        });
        this.asD = new g.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.FI).replace("%s2", this.asC)).dv(17301543).af(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.AY();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.asH != null) {
                    a.this.asH.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.asH != null) {
                    a.this.asH.onCancel();
                }
            }
        }).Bb();
        this.asD.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        if (this.asG != null) {
            this.asG.i(this.FI, this.asC, getUsername(), getPassword());
        }
    }
}
