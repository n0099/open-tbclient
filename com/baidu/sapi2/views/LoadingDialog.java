package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import d.a.a0.a.e;
import d.a.a0.a.f;
import d.a.a0.a.h;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public Context f9919a;

        /* renamed from: b  reason: collision with root package name */
        public String f9920b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9921c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9922d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9923e = false;

        public Builder(Context context) {
            this.f9919a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f9919a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f9919a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f9921c) {
                textView.setText(this.f9920b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f9922d);
            loadingDialog.setCanceledOnTouchOutside(this.f9923e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f9923e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f9922d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f9920b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f9921c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
