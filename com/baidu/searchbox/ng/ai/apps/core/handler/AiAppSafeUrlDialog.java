package com.baidu.searchbox.ng.ai.apps.core.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.SelectorTextView;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.searchbox.ng.ai.apps.util.AiAppPorterDuffModeHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class AiAppSafeUrlDialog extends AutoOrientationBtnDialog {
    private TextView mContentView;
    private Builder mSafeBuilder;
    private SelectorTextView mSubContentView;
    private View mView;

    protected AiAppSafeUrlDialog(Context context) {
        super(context);
    }

    public void setSafeBuilder(Builder builder) {
        this.mSafeBuilder = builder;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog
    protected View createContentView(ViewGroup viewGroup) {
        this.mView = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_safe_dialog, viewGroup, false);
        this.mContentView = (TextView) this.mView.findViewById(R.id.safe_dialog_content);
        this.mContentView.setTextColor(getContext().getResources().getColor(R.color.aiapps_safe_dialog_message));
        this.mSubContentView = (SelectorTextView) this.mView.findViewById(R.id.safe_dialog_sub_content);
        this.mSubContentView.setTextColor(getContext().getResources().getColor(R.color.aiapps_safe_dialog_btn_blue));
        bindView();
        return this.mView;
    }

    private void bindView() {
        if (this.mSafeBuilder == null) {
            return;
        }
        this.mContentView.setText(this.mContext.getText(this.mSafeBuilder.mMessageId));
        this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppSafeUrlDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AiAppSafeUrlDialog.this.mSafeBuilder.mMessageClickListener != null) {
                    AiAppSafeUrlDialog.this.mSafeBuilder.mMessageClickListener.onItemClick(view);
                }
            }
        });
        if (this.mSafeBuilder.mSubMessageId > 0) {
            this.mSubContentView.setVisibility(0);
            this.mSubContentView.setText(this.mContext.getText(this.mSafeBuilder.mSubMessageId));
            this.mSubContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.core.handler.AiAppSafeUrlDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AiAppSafeUrlDialog.this.mSafeBuilder.mSubMessageClickListener != null) {
                        AiAppSafeUrlDialog.this.mSafeBuilder.mSubMessageClickListener.onItemClick(view);
                    }
                }
            });
        } else {
            this.mSubContentView.setVisibility(8);
        }
        if (this.mSafeBuilder.mSubContentDrawLeft <= 0) {
            return;
        }
        Drawable drawable = this.mContext.getResources().getDrawable(this.mSafeBuilder.mSubContentDrawLeft);
        AiAppPorterDuffModeHelper.decorateSrcATopMode(getContext(), drawable);
        drawable.setBounds(0, 0, AiAppsUIUtils.dip2px(this.mContext, 12.0f), AiAppsUIUtils.dip2px(this.mContext, 12.0f));
        this.mSubContentView.setCompoundDrawables(drawable, null, null, null);
    }

    /* loaded from: classes2.dex */
    public static class Builder extends AutoOrientationBtnDialog.Builder {
        public AutoOrientationBtnDialog.OnItemClickListener mMessageClickListener;
        private int mMessageId;
        private int mSubContentDrawLeft;
        public AutoOrientationBtnDialog.OnItemClickListener mSubMessageClickListener;
        private int mSubMessageId;

        public Builder(Context context) {
            super(context);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.Builder, com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        protected AiAppAlertDialog onCreateDialog(Context context) {
            return new AiAppSafeUrlDialog(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public Builder setTitle(int i) {
            super.setTitle(i);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public Builder setMessage(int i) {
            this.mMessageId = i;
            return this;
        }

        public Builder setMessage(int i, AutoOrientationBtnDialog.OnItemClickListener onItemClickListener) {
            this.mMessageId = i;
            this.mMessageClickListener = onItemClickListener;
            return this;
        }

        public Builder setSubMessage(int i) {
            this.mSubMessageId = i;
            return this;
        }

        public Builder setSubMessage(int i, AutoOrientationBtnDialog.OnItemClickListener onItemClickListener) {
            this.mSubMessageId = i;
            this.mSubMessageClickListener = onItemClickListener;
            return this;
        }

        public Builder setSubMessageDrawLeft(int i) {
            this.mSubContentDrawLeft = i;
            return this;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AutoOrientationBtnDialog.Builder, com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog.Builder
        public AiAppAlertDialog create() {
            AiAppSafeUrlDialog aiAppSafeUrlDialog = (AiAppSafeUrlDialog) super.create();
            aiAppSafeUrlDialog.setSafeBuilder(this);
            return aiAppSafeUrlDialog;
        }
    }
}
