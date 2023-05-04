package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {
        public Context a;
        public String b;
        public boolean c = true;
        public boolean d = false;
        public boolean e = false;

        public Builder(Context context) {
            this.a = context;
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

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.a, R.style.obfuscated_res_0x7f1003f7);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923e2);
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
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }
}
