package com.baidu.pass.ecommerce.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CustomAlertDialog extends Dialog {
    public TextView contentTv;
    public TextView negativeBtn;
    public TextView positiveBtn;
    public TextView titleTv;

    public CustomAlertDialog(Context context) {
        super(context, R.style.obfuscated_res_0x7f1001a1);
        init();
    }

    public void setContent(String str) {
        this.contentTv.setText(str);
    }

    public void setPositiveTvColor(int i) {
        this.positiveBtn.setTextColor(i);
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public CustomAlertDialog(Context context, int i) {
        super(context, i);
        init();
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(onClickListener);
    }

    public CustomAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    private void init() {
        setContentView(R.layout.obfuscated_res_0x7f0d0586);
        setCanceledOnTouchOutside(true);
        this.titleTv = (TextView) findViewById(R.id.obfuscated_res_0x7f09208f);
        this.contentTv = (TextView) findViewById(R.id.obfuscated_res_0x7f09208c);
        this.positiveBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f09208e);
        this.negativeBtn = (TextView) findViewById(R.id.obfuscated_res_0x7f09208d);
    }
}
