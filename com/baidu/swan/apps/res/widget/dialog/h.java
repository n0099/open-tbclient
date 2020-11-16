package com.baidu.swan.apps.res.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
/* loaded from: classes7.dex */
public class h extends c {
    private a dqp;

    public h(Context context, int i) {
        super(context, i);
        init();
    }

    protected void init() {
        setContentView(a.g.swanapp_picker_dialog);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        setEnableImmersion(false);
    }

    public a aGu() {
        return this.dqp;
    }

    void a(a aVar) {
        this.dqp = aVar;
    }

    /* loaded from: classes7.dex */
    public static class a {
        protected final b dqq;
        protected final h dqr;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.dqr = cs(context);
            this.dqr.a(this);
            this.dqq = new b((ViewGroup) this.dqr.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cs(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a aB(View view) {
            this.dqq.mDialogContent.removeAllViews();
            this.dqq.mDialogContent.addView(view);
            return this;
        }

        public h aGm() {
            this.dqr.setOnCancelListener(this.dqq.mOnCancelListener);
            this.dqr.setOnDismissListener(this.dqq.mOnDismissListener);
            this.dqr.setOnShowListener(this.dqq.mOnShowListener);
            this.dqr.a(this);
            return this.dqr;
        }

        public h aGv() {
            h aGm = aGm();
            if (this.mSystemDialog) {
                aGm.getWindow().setType(2003);
            }
            try {
                aGm.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aGm;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dqq.mPositiveButton.setText(charSequence);
            this.dqq.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dqr.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dqr, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.dqq.mNegativeButton.setText(charSequence);
            this.dqq.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dqr.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.dqr, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.dqq.mOnCancelListener = onCancelListener;
            return this;
        }

        public a gA(boolean z) {
            this.dqr.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public FrameLayout dqj;
        public FrameLayout dqk;
        public View dql;
        public LinearLayout mBtnPanelLayout;
        public View mCustomPanel;
        public FrameLayout mDialogContent;
        public View mDialogContentPanel;
        public RelativeLayout mDialogLayout;
        public TextView mNegativeButton;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnShowListener mOnShowListener;
        public TextView mPositiveButton;
        public ViewGroup mRoot;

        @SuppressLint({"CutPasteId"})
        public b(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
            this.dqk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.dqj = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.dql = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
