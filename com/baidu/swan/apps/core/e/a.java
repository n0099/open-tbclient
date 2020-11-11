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
/* loaded from: classes10.dex */
public class a {
    private final String cLJ;
    private g cLK;
    private TextView cLL;
    private TextView cLM;
    private b cLN;
    private InterfaceC0423a cLO;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0423a {
        void onCancel();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void r(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cLJ = str2;
        apL();
    }

    private String getUsername() {
        return this.cLL.getText().toString();
    }

    private String getPassword() {
        return this.cLM.getText().toString();
    }

    public void a(b bVar) {
        this.cLN = bVar;
    }

    public void a(InterfaceC0423a interfaceC0423a) {
        this.cLO = interfaceC0423a;
    }

    public void show() {
        this.cLK.show();
        this.cLL.requestFocus();
    }

    private void apL() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cLL = (TextView) inflate.findViewById(a.f.username_edit);
        this.cLM = (TextView) inflate.findViewById(a.f.password_edit);
        this.cLM.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.apM();
                    return true;
                }
                return false;
            }
        });
        this.cLK = new g.a(this.mContext).f(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cLJ)).ka(17301543).aA(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.apM();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cLO != null) {
                    a.this.cLO.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cLO != null) {
                    a.this.cLO.onCancel();
                }
            }
        }).apP();
        this.cLK.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apM() {
        if (this.cLN != null) {
            this.cLN.r(this.mHost, this.cLJ, getUsername(), getPassword());
        }
    }
}
