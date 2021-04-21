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
import d.b.y.a.c;
import d.b.y.a.d;
import d.b.y.a.e;
import d.b.y.a.f;
import d.b.y.a.h;
/* loaded from: classes2.dex */
public class FingerprintDialog extends Dialog implements com.baidu.sapi2.g.b, NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f11124a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f11125b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11126c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f11127d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f11128e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f11129f;

    /* renamed from: g  reason: collision with root package name */
    public Context f11130g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f11131a;

        public a(View.OnClickListener onClickListener) {
            this.f11131a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f11130g, FingerprintDialog.this);
                this.f11131a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f11133a;

        public b(View.OnClickListener onClickListener) {
            this.f11133a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f11130g, FingerprintDialog.this);
                this.f11133a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f11130g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f11124a = (LinearLayout) findViewById(e.bg_layout);
        this.f11125b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f11126c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f11127d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f11128e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f11129f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f11127d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f11128e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b setBtnCount(int i) {
        if ((i <= 2 ? Math.max(i, 1) : 2) == 1) {
            this.f11127d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f11128e.getLayoutParams();
            layoutParams.leftMargin = (int) this.f11130g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.f11130g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
        } else {
            this.f11127d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f11128e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.f11130g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.f11130g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
        }
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b setIconInvisible() {
        findViewById(e.icon).setVisibility(8);
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b setNegativeBtn(String str, View.OnClickListener onClickListener) {
        this.f11127d.setText(str);
        this.f11127d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f11128e.setText(str);
        this.f11128e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public com.baidu.sapi2.g.b setTitle(String str, String str2) {
        this.f11125b.setText(str);
        this.f11126c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.g.b
    public void showDialog() {
        show();
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f11124a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f11129f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f11125b.setTextColor(this.f11130g.getResources().getColor(d.b.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f11126c.setTextColor(this.f11130g.getResources().getColor(d.b.y.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f11127d.setTextColor(this.f11130g.getResources().getColor(d.b.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f11127d.setBackground(this.f11130g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.f11128e.setTextColor(this.f11130g.getResources().getColor(d.b.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f11128e.setBackground(this.f11130g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }
}
