package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.touchid.FingerprintDialogInterface;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface, NoProguard {
    public LinearLayout a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public Context g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.g, FingerprintDialog.this);
                this.a.onClick(view2);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public b(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.g, FingerprintDialog.this);
                this.a.onClick(view2);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, R.style.obfuscated_res_0x7f10019a);
        this.g = context;
        setContentView(R.layout.layout_sapi_sdk_fingerprint_dialog);
        this.a = (LinearLayout) findViewById(R.id.bg_layout);
        this.b = (TextView) findViewById(R.id.sapi_sdk_fingerprint_title);
        this.c = (TextView) findViewById(R.id.sapi_sdk_fingerprint_sub_title);
        this.d = (TextView) findViewById(R.id.sapi_sdk_fingerprint_negative_btn);
        this.e = (TextView) findViewById(R.id.sapi_sdk_fingerprint_positive_btn);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.d, 0.2f);
        ViewUtility.setViewClickAlpha(this.e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i) {
        int i2 = 2;
        if (i <= 2) {
            i2 = Math.max(i, 1);
        }
        if (i2 == 1) {
            this.d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.leftMargin = (int) this.g.getResources().getDimension(R.dimen.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.g.getResources().getDimension(R.dimen.sapi_sdk_finger_print_btn_margin);
        } else {
            this.d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.g.getResources().getDimension(R.dimen.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.g.getResources().getDimension(R.dimen.sapi_sdk_finger_print_btn_right_margin);
        }
        return this;
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.a.setBackgroundResource(R.drawable.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f.setImageResource(R.drawable.sapi_sdk_fingerprint_dark_mode);
            this.b.setTextColor(this.g.getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            this.c.setTextColor(this.g.getResources().getColor(R.color.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.d.setTextColor(this.g.getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            this.d.setBackground(this.g.getResources().getDrawable(R.drawable.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.e.setTextColor(this.g.getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            this.e.setBackground(this.g.getResources().getDrawable(R.drawable.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setIconInvisible() {
        findViewById(R.id.obfuscated_res_0x7f09106a).setVisibility(8);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.d.setText(str);
        this.d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.e.setText(str);
        this.e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.b.setText(str);
        this.c.setText(str2);
        return this;
    }
}
