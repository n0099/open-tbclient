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
    private final String aLA;
    private g aLB;
    private TextView aLC;
    private TextView aLD;
    private b aLE;
    private InterfaceC0178a aLF;
    private final Context mContext;
    private final String su;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0178a {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void l(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.su = str;
        this.aLA = str2;
        FT();
    }

    private String getUsername() {
        return this.aLC.getText().toString();
    }

    private String getPassword() {
        return this.aLD.getText().toString();
    }

    public void a(b bVar) {
        this.aLE = bVar;
    }

    public void a(InterfaceC0178a interfaceC0178a) {
        this.aLF = interfaceC0178a;
    }

    public void show() {
        this.aLB.show();
        this.aLC.requestFocus();
    }

    private void FT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.aLC = (TextView) inflate.findViewById(a.f.username_edit);
        this.aLD = (TextView) inflate.findViewById(a.f.password_edit);
        this.aLD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.FU();
                    return true;
                }
                return false;
            }
        });
        this.aLB = new g.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.su).replace("%s2", this.aLA)).eq(17301543).al(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.FU();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.aLF != null) {
                    a.this.aLF.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.aLF != null) {
                    a.this.aLF.onCancel();
                }
            }
        }).FX();
        this.aLB.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU() {
        if (this.aLE != null) {
            this.aLE.l(this.su, this.aLA, getUsername(), getPassword());
        }
    }
}
