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
    public LinearLayout f10909a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f10910b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10911c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f10912d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f10913e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f10914f;

    /* renamed from: g  reason: collision with root package name */
    public Context f10915g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f10916a;

        public a(View.OnClickListener onClickListener) {
            this.f10916a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f10915g, FingerprintDialog.this);
                this.f10916a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f10918a;

        public b(View.OnClickListener onClickListener) {
            this.f10918a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ViewUtility.dismissDialog((Activity) FingerprintDialog.this.f10915g, FingerprintDialog.this);
                this.f10918a.onClick(view);
            } catch (Exception unused) {
            }
        }
    }

    public FingerprintDialog(Context context) {
        super(context, h.SapiSdkBeautyDialog);
        this.f10915g = context;
        setContentView(f.layout_sapi_sdk_fingerprint_dialog);
        this.f10909a = (LinearLayout) findViewById(e.bg_layout);
        this.f10910b = (TextView) findViewById(e.sapi_sdk_fingerprint_title);
        this.f10911c = (TextView) findViewById(e.sapi_sdk_fingerprint_sub_title);
        this.f10912d = (TextView) findViewById(e.sapi_sdk_fingerprint_negative_btn);
        this.f10913e = (TextView) findViewById(e.sapi_sdk_fingerprint_positive_btn);
        this.f10914f = (ImageView) findViewById(e.sapi_sdk_fingerprint_icon);
        a();
        ViewUtility.setViewClickAlpha(this.f10912d, 0.2f);
        ViewUtility.setViewClickAlpha(this.f10913e, 0.2f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setBtnCount(int i2) {
        if ((i2 <= 2 ? Math.max(i2, 1) : 2) == 1) {
            this.f10912d.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10913e.getLayoutParams();
            layoutParams.leftMargin = (int) this.f10915g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
            layoutParams.rightMargin = (int) this.f10915g.getResources().getDimension(c.sapi_sdk_finger_print_btn_margin);
        } else {
            this.f10912d.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10913e.getLayoutParams();
            layoutParams2.leftMargin = (int) this.f10915g.getResources().getDimension(c.sapi_sdk_finger_print_btn_left_margin);
            layoutParams2.rightMargin = (int) this.f10915g.getResources().getDimension(c.sapi_sdk_finger_print_btn_right_margin);
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
        this.f10912d.setText(str);
        this.f10912d.setOnClickListener(new a(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setPositiveBtn(String str, View.OnClickListener onClickListener) {
        this.f10913e.setText(str);
        this.f10913e.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public FingerprintDialogInterface setTitle(String str, String str2) {
        this.f10910b.setText(str);
        this.f10911c.setText(str2);
        return this;
    }

    @Override // com.baidu.sapi2.touchid.FingerprintDialogInterface
    public void showDialog() {
        show();
    }

    private void a() {
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f10909a.setBackgroundResource(d.sapi_sdk_fingerprint_dialog_dark_mode);
            this.f10914f.setImageResource(d.sapi_sdk_fingerprint_dark_mode);
            this.f10910b.setTextColor(this.f10915g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f10911c.setTextColor(this.f10915g.getResources().getColor(d.a.y.a.b.sapi_sdk_fingerprint_dialog_sub_tv_color));
            this.f10912d.setTextColor(this.f10915g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f10912d.setBackground(this.f10915g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_negative_btn_bg_daynight));
            this.f10913e.setTextColor(this.f10915g.getResources().getColor(d.a.y.a.b.sapi_sdk_dark_mode_edit_text_color));
            this.f10913e.setBackground(this.f10915g.getResources().getDrawable(d.sapi_sdk_fingerprint_dialog_positive_btn_bg_daynight));
        }
    }
}
