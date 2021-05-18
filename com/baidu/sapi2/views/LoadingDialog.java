package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import d.a.y.a.e;
import d.a.y.a.f;
import d.a.y.a.h;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public Context f9957a;

        /* renamed from: b  reason: collision with root package name */
        public String f9958b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9959c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9960d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9961e = false;

        public Builder(Context context) {
            this.f9957a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f9957a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f9957a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f9959c) {
                textView.setText(this.f9958b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f9960d);
            loadingDialog.setCanceledOnTouchOutside(this.f9961e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f9961e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f9960d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f9958b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f9959c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
