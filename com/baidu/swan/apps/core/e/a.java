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
    private final String aLS;
    private g aLT;
    private TextView aLU;
    private TextView aLV;
    private b aLW;
    private InterfaceC0178a aLX;
    private final Context mContext;
    private final String sT;

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
        this.sT = str;
        this.aLS = str2;
        FS();
    }

    private String getUsername() {
        return this.aLU.getText().toString();
    }

    private String getPassword() {
        return this.aLV.getText().toString();
    }

    public void a(b bVar) {
        this.aLW = bVar;
    }

    public void a(InterfaceC0178a interfaceC0178a) {
        this.aLX = interfaceC0178a;
    }

    public void show() {
        this.aLT.show();
        this.aLU.requestFocus();
    }

    private void FS() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.aLU = (TextView) inflate.findViewById(a.f.username_edit);
        this.aLV = (TextView) inflate.findViewById(a.f.password_edit);
        this.aLV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.FT();
                    return true;
                }
                return false;
            }
        });
        this.aLT = new g.a(this.mContext).d(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.sT).replace("%s2", this.aLS)).eq(17301543).al(inflate).b(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.FT();
            }
        }).c(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.aLX != null) {
                    a.this.aLX.onCancel();
                }
            }
        }).b(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.aLX != null) {
                    a.this.aLX.onCancel();
                }
            }
        }).FW();
        this.aLT.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        if (this.aLW != null) {
            this.aLW.l(this.sT, this.aLS, getUsername(), getPassword());
        }
    }
}
