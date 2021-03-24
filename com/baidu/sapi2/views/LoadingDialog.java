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
        public Context f11550a;

        /* renamed from: b  reason: collision with root package name */
        public String f11551b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11552c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11553d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11554e = false;

        public Builder(Context context) {
            this.f11550a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f11550a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f11550a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f11552c) {
                textView.setText(this.f11551b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f11553d);
            loadingDialog.setCanceledOnTouchOutside(this.f11554e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f11554e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f11553d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f11551b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f11552c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }
}
