package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import d.b.a0.a.e;
import d.b.a0.a.f;
import d.b.a0.a.h;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public Context f11551a;

        /* renamed from: b  reason: collision with root package name */
        public String f11552b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11553c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11554d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11555e = false;

        public Builder(Context context) {
            this.f11551a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f11551a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f11551a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f11553c) {
                textView.setText(this.f11552b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f11554d);
            loadingDialog.setCanceledOnTouchOutside(this.f11555e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f11555e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f11554d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f11552b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f11553c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }
}
