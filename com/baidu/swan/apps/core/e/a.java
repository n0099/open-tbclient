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
    private InterfaceC0343a cbA;
    private final String cbv;
    private g cbw;
    private TextView cbx;
    private TextView cby;
    private b cbz;
    private final Context mContext;
    private final String mHost;

    /* renamed from: com.baidu.swan.apps.core.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0343a {
        void onCancel();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void q(String str, String str2, String str3, String str4);
    }

    public a(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.cbv = str2;
        aaH();
    }

    private String getUsername() {
        return this.cbx.getText().toString();
    }

    private String getPassword() {
        return this.cby.getText().toString();
    }

    public void a(b bVar) {
        this.cbz = bVar;
    }

    public void a(InterfaceC0343a interfaceC0343a) {
        this.cbA = interfaceC0343a;
    }

    public void show() {
        this.cbw.show();
        this.cbx.requestFocus();
    }

    private void aaH() {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.g.aiapps_browser_http_authentication, (ViewGroup) null);
        this.cbx = (TextView) inflate.findViewById(a.f.username_edit);
        this.cby = (TextView) inflate.findViewById(a.f.password_edit);
        this.cby.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.swan.apps.core.e.a.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    a.this.aaI();
                    return true;
                }
                return false;
            }
        });
        this.cbw = new g.a(this.mContext).e(this.mContext.getText(a.h.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.cbv)).gH(17301543).ao(inflate).c(a.h.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.aaI();
            }
        }).d(a.h.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.core.e.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (a.this.cbA != null) {
                    a.this.cbA.onCancel();
                }
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.core.e.a.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (a.this.cbA != null) {
                    a.this.cbA.onCancel();
                }
            }
        }).aaL();
        this.cbw.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaI() {
        if (this.cbz != null) {
            this.cbz.q(this.mHost, this.cbv, getUsername(), getPassword());
        }
    }
}
