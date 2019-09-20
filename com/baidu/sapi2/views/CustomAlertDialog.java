package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.TextView;
import com.baidu.d.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.permissions.AlertDialogInterface;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog implements AlertDialogInterface {
    private Context context;
    private TextView msgText;
    private TextView negativeBtn;
    private TextView positiveBtn;
    private TextView titleText;

    public CustomAlertDialog(Context context) {
        super(context, a.h.SapiSdkBeautyDialog);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        setContentView(a.f.layout_sapi_sdk_dialog_alert);
        setCanceledOnTouchOutside(false);
        this.titleText = (TextView) findViewById(a.e.title_text);
        this.msgText = (TextView) findViewById(a.e.msg_text);
        this.positiveBtn = (TextView) findViewById(a.e.positive_btn);
        this.negativeBtn = (TextView) findViewById(a.e.negative_btn);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            ((ViewGroup) this.titleText.getRootView()).addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setTitleText(String str) {
        this.titleText.setText(str);
    }

    public void setTitleVisible(int i) {
        this.titleText.setVisibility(i);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setMessageText(String str) {
        this.msgText.setText(str);
    }

    public void setMessageVisible(int i) {
        this.msgText.setVisibility(i);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setPositiveBtn(String str, final View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.views.CustomAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ViewUtility.dismissDialog((Activity) CustomAlertDialog.this.context, CustomAlertDialog.this);
                } catch (Exception e) {
                }
                onClickListener.onClick(view);
            }
        });
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setNegativeBtn(String str, final View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.views.CustomAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ViewUtility.dismissDialog((Activity) CustomAlertDialog.this.context, CustomAlertDialog.this);
                } catch (Exception e) {
                }
                onClickListener.onClick(view);
            }
        });
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void setCancel(boolean z) {
        setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    @Override // com.baidu.sapi2.permissions.AlertDialogInterface
    public void showDialog() {
        show();
    }
}
