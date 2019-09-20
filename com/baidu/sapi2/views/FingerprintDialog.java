package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.d.a.a;
import com.baidu.sapi2.touchid.FingerprintDialogInterface;
/* loaded from: classes2.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface {
    private Context context;
    private TextView negativeBtn;
    private TextView positiveBtn;
    private TextView subTitle;
    private TextView title;

    public FingerprintDialog(Context context) {
        super(context, a.h.SapiSdkBeautyDialog);
        this.context = context;
        setContentView(a.f.layout_sapi_sdk_fingerprint_dialog);
        this.title = (TextView) findViewById(a.e.title);
        this.subTitle = (TextView) findViewById(a.e.sub_title);
        this.negativeBtn = (TextView) findViewById(a.e.negative_btn);
        this.positiveBtn = (TextView) findViewById(a.e.positive_btn);
        ViewUtility.setViewClickAlpha(this.negativeBtn, 0.2f);
        ViewUtility.setViewClickAlpha(this.positiveBtn, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i) {
        if (i > 2) {
            i = 2;
        } else if (i < 1) {
            i = 1;
        }
        if (i == 1) {
            this.positiveBtn.setVisibility(8);
            findViewById(a.e.divider_line).setVisibility(8);
        } else {
            this.positiveBtn.setVisibility(0);
            findViewById(a.e.divider_line).setVisibility(0);
        }
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.title.setText(str);
        this.subTitle.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setNegativeBtn(String str, final View.OnClickListener onClickListener) {
        this.negativeBtn.setText(str);
        this.negativeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.views.FingerprintDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ViewUtility.dismissDialog((Activity) FingerprintDialog.this.context, FingerprintDialog.this);
                    onClickListener.onClick(view);
                } catch (Exception e) {
                }
            }
        });
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, final View.OnClickListener onClickListener) {
        this.positiveBtn.setText(str);
        this.positiveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.views.FingerprintDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ViewUtility.dismissDialog((Activity) FingerprintDialog.this.context, FingerprintDialog.this);
                    onClickListener.onClick(view);
                } catch (Exception e) {
                }
            }
        });
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setIconInvisible() {
        findViewById(a.e.icon).setVisibility(8);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }
}
