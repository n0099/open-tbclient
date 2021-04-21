package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import d.b.y.a.e;
import d.b.y.a.f;
import d.b.y.a.h;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public Context f11135a;

        /* renamed from: b  reason: collision with root package name */
        public String f11136b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11137c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11138d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11139e = false;

        public Builder(Context context) {
            this.f11135a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f11135a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f11135a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f11137c) {
                textView.setText(this.f11136b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f11138d);
            loadingDialog.setCanceledOnTouchOutside(this.f11139e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f11139e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f11138d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f11136b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f11137c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }
}
