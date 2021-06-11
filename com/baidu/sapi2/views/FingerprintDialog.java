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
    public LinearLayout f9908a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9909b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9910c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9911d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9912e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f9913f;

    /* renamed from: g  reason: collision with root package name */
    public Context f9914g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9915a;

        public a(View.OnClickListener onClickListener) {
            this.f9915a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9914g, FingerprintDialog.this);
                this.f9915a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9917a;

        public b(View.OnClickListener onClickListener) {
            this.f9917a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9914g, FingerprintDialog.this);
                this.f9917a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f9914g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f9908a = (LinearLayout) findViewById(e.bg_layout);
        this.f9909b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f9910c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f9911d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f9912e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f9913f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f9911d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f9912e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i2) {
        if ((i2 <= 2 ? Math.max(i2, 1) : 2) == 1) {
            this.f9911d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9912e.getLayoutParams();
            layoutParams.leftMargin = (int) this.f9914g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.f9914g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
        } else {
            this.f9911d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f9912e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.f9914g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.f9914g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
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
        this.f9911d.setText(str);
        this.f9911d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f9912e.setText(str);
        this.f9912e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.f9909b.setText(str);
        this.f9910c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f9908a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f9913f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f9909b.setTextColor(this.f9914g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9910c.setTextColor(this.f9914g.getResources().getColor(d.a.a0.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f9911d.setTextColor(this.f9914g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9911d.setBackground(this.f9914g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.f9912e.setTextColor(this.f9914g.getResources().getColor(d.a.a0.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9912e.setBackground(this.f9914g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }
}
