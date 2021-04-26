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
        public Context f10920a;

        /* renamed from: b  reason: collision with root package name */
        public String f10921b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10922c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10923d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10924e = false;

        public Builder(Context context) {
            this.f10920a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f10920a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f10920a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f10922c) {
                textView.setText(this.f10921b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f10923d);
            loadingDialog.setCanceledOnTouchOutside(this.f10924e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f10924e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f10923d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f10921b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f10922c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
