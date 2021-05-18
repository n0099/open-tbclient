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
import d.a.y.a.c;
import d.a.y.a.d;
import d.a.y.a.e;
import d.a.y.a.f;
import d.a.y.a.h;
/* loaded from: classes2.dex */
public class FingerprintDialog extends Dialog implements FingerprintDialogInterface, NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f9946a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f9947b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f9948c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f9949d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f9950e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f9951f;

    /* renamed from: g  reason: collision with root package name */
    public Context f9952g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9953a;

        public a(View.OnClickListener onClickListener) {
            this.f9953a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9952g, FingerprintDialog.this);
                this.f9953a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f9955a;

        public b(View.OnClickListener onClickListener) {
            this.f9955a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f9952g, FingerprintDialog.this);
                this.f9955a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f9952g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f9946a = (LinearLayout) findViewById(e.bg_layout);
        this.f9947b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f9948c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f9949d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f9950e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f9951f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f9949d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f9950e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i2) {
        if ((i2 <= 2 ? Math.max(i2, 1) : 2) == 1) {
            this.f9949d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f9950e.getLayoutParams();
            layoutParams.leftMargin = (int) this.f9952g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.f9952g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
        } else {
            this.f9949d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f9950e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.f9952g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.f9952g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
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
        this.f9949d.setText(str);
        this.f9949d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f9950e.setText(str);
        this.f9950e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.f9947b.setText(str);
        this.f9948c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f9946a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f9951f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f9947b.setTextColor(this.f9952g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9948c.setTextColor(this.f9952g.getResources().getColor(d.a.y.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f9949d.setTextColor(this.f9952g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9949d.setBackground(this.f9952g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.f9950e.setTextColor(this.f9952g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f9950e.setBackground(this.f9952g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }
}
