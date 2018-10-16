package com.baidu.searchbox.ng.ai.apps.core.handler;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
/* loaded from: classes2.dex */
public class AiAppHttpAuthenticationDialog {
    private CancelListener mCancelListener;
    private final Context mContext;
    private AiAppAlertDialog mDialog;
    private final String mHost;
    private OkListener mOkListener;
    private TextView mPasswordView;
    private final String mRealm;
    private TextView mUsernameView;

    /* loaded from: classes2.dex */
    public interface CancelListener {
        void onCancel();
    }

    /* loaded from: classes2.dex */
    public interface OkListener {
        void onOk(String str, String str2, String str3, String str4);
    }

    public AiAppHttpAuthenticationDialog(Context context, String str, String str2) {
        this.mContext = context;
        this.mHost = str;
        this.mRealm = str2;
        createDialog();
    }

    private String getUsername() {
        return this.mUsernameView.getText().toString();
    }

    private String getPassword() {
        return this.mPasswordView.getText().toString();
    }

    public void setOkListener(OkListener okListener) {
        this.mOkListener = okListener;
    }

    public void setCancelListener(CancelListener cancelListener) {
        this.mCancelListener = cancelListener;
    }

    public void show() {
        this.mDialog.show();
        this.mUsernameView.requestFocus();
    }

    private void createDialog() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_browser_http_authentication, (ViewGroup) null);
        this.mUsernameView = (TextView) inflate.findViewById(R.id.username_edit);
        this.mPasswordView = (TextView) inflate.findViewById(R.id.password_edit);
        this.mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6 || i == 0) {
                    if (i == 0 && keyEvent != null && keyEvent.getAction() == 1) {
                        return true;
                    }
                    AiAppHttpAuthenticationDialog.this.performPositiveClick();
                    return true;
                }
                return false;
            }
        });
        this.mDialog = new AiAppAlertDialog.Builder(this.mContext).setTitle(this.mContext.getText(R.string.aiapps_sign_in_to).toString().replace("%s1", this.mHost).replace("%s2", this.mRealm)).setIcon(17301543).setView(inflate).setPositiveButton(R.string.aiapps_http_authentication_login, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AiAppHttpAuthenticationDialog.this.performPositiveClick();
            }
        }).setNegativeButton(R.string.aiapps_http_authentication_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (AiAppHttpAuthenticationDialog.this.mCancelListener != null) {
                    AiAppHttpAuthenticationDialog.this.mCancelListener.onCancel();
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppHttpAuthenticationDialog.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (AiAppHttpAuthenticationDialog.this.mCancelListener != null) {
                    AiAppHttpAuthenticationDialog.this.mCancelListener.onCancel();
                }
            }
        }).create();
        this.mDialog.getWindow().setSoftInputMode(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performPositiveClick() {
        if (this.mOkListener != null) {
            this.mOkListener.onOk(this.mHost, this.mRealm, getUsername(), getPassword());
        }
    }
}
