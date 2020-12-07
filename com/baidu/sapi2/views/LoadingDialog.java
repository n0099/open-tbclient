package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.l.a.a;
import com.baidu.sapi2.NoProguard;
/* loaded from: classes6.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes6.dex */
    public static class Builder implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        private Context f3568a;
        private String b;
        private boolean c = true;
        private boolean d = false;
        private boolean e = false;

        public Builder(Context context) {
            this.f3568a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f3568a).inflate(a.f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f3568a, a.h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(a.e.tipTextView);
            if (this.c) {
                textView.setText(this.b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.d);
            loadingDialog.setCanceledOnTouchOutside(this.e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.c = z;
            return this;
        }
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }
}
