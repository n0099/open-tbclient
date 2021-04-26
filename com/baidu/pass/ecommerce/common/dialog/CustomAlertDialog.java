package com.baidu.pass.ecommerce.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.ecommerce.R;
/* loaded from: classes2.dex */
public class CustomAlertDialog extends Dialog {
    public TextView contentTv;
    public TextView negativeBtn;
    public TextView positiveBtn;
    public TextView titleTv;

    public CustomAlertDialog(Context context) {
        super(context, R.style.SapiSdkBeautyDialog);
        init();
    }

    private void init() {
        setContentView(R.layout.layout_sapi_sdk_dialog_alert);
        setCanceledOnTouchOutside(true);
        this.titleTv = (TextView) findViewById(R.id.sapi_sdk_common_dialog_title);
        this.contentTv = (TextView) findViewById(R.id.sapi_sdk_common_dialog_content);
        this.positiveBtn = (TextView) findViewById(R.id.sapi_sdk_common_dialog_positive_btn);
        this.negativeBtn = (TextView) findViewById(R.id.sapi_sdk_common_dialog_negative_btn);
    }

    public void setContent(String str) {
        this.contentTv.setText(str);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(onClickListener);
    }

    public void setPositiveTvColor(int i2) {
        this.positiveBtn.setTextColor(i2);
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public CustomAlertDialog(Context context, int i2) {
        super(context, i2);
        init();
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }
}
