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
import d.a.a0.a.c;
import d.a.a0.a.d;
import d.a.a0.a.e;
import d.a.a0.a.f;
import d.a.a0.a.h;
/* loaded from: classes2.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface, NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f9929a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9930b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9931c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9932d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9933e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f9934f;

    /* renamed from: g  reason: collision with root package name */
    public Context f9935g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9936a;

        public a(View.OnClickListener onClickListener) {
            this.f9936a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9935g, FingerprintDialog.this);
                this.f9936a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9938a;

        public b(View.OnClickListener onClickListener) {
            this.f9938a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9935g, FingerprintDialog.this);
                this.f9938a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f9935g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f9929a = (LinearLayout) findViewById(e.bg_layout);
        this.f9930b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f9931c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f9932d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f9933e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f9934f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f9932d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f9933e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i2) {
        if ((i2 <= 2 ? Math.max(i2, 1) : 2) == 1) {
            this.f9932d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9933e.getLayoutParams();
            layoutParams.leftMargin = (int) this.f9935g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.f9935g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
        } else {
            this.f9932d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f9933e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.f9935g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.f9935g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
        }
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setIconInvisible() {
        findViewById(e.icon).setVisibility(8);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f9932d.setText(str);
        this.f9932d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f9933e.setText(str);
        this.f9933e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.f9930b.setText(str);
        this.f9931c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f9929a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f9934f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f9930b.setTextColor(this.f9935g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9931c.setTextColor(this.f9935g.getResources().getColor(d.a.a0.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f9932d.setTextColor(this.f9935g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9932d.setBackground(this.f9935g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.f9933e.setTextColor(this.f9935g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9933e.setBackground(this.f9935g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }
}
