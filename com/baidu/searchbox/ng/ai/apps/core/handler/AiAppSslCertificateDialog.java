package com.baidu.searchbox.ng.ai.apps.core.handler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog;
/* loaded from: classes2.dex */
public class AiAppSslCertificateDialog extends AutoOrientationBtnDialog {
    private Builder mBuilder;
    private FrameLayout mContainer;

    protected AiAppSslCertificateDialog(Context context) {
        super(context);
    }

    public void setSafeBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog
    protected View createContentView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_view_ssl_certificate_dialog, viewGroup, false);
        this.mContainer = (FrameLayout) inflate.findViewById(R.id.ssl_certificate_container);
        bindView();
        return inflate;
    }

    private void bindView() {
        if (this.mBuilder == null) {
            return;
        }
        this.mContainer.addView(this.mBuilder.contentView);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends AutoOrientationBtnDialog.Builder {
        private View contentView;

        public Builder(Context context) {
            super(context);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.Builder, com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new AiAppSslCertificateDialog(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public Builder setTitle(int i) {
            super.setTitle(i);
            return this;
        }

        public Builder setContentView(View view) {
            this.contentView = view;
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.Builder, com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            AiAppSslCertificateDialog aiAppSslCertificateDialog = (AiAppSslCertificateDialog) super.create();
            aiAppSslCertificateDialog.setSafeBuilder(this);
            return aiAppSslCertificateDialog;
        }
    }
}
