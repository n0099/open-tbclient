package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.d.a.a;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int i) {
        super(context, i);
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private Context context;
        private String message;
        private boolean isShowMessage = true;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.isShowMessage = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.isCancelable = z;
            return this;
        }

        public Builder setCancelOutside(boolean z) {
            this.isCancelOutside = z;
            return this;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.context).inflate(a.f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
            LoadingDialog loadingDialog = new LoadingDialog(this.context, a.h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(a.e.tipTextView);
            if (this.isShowMessage) {
                textView.setText(this.message);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.isCancelable);
            loadingDialog.setCanceledOnTouchOutside(this.isCancelOutside);
            return loadingDialog;
        }
    }
}
