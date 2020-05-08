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
/* loaded from: classes11.dex */
public class h extends c {
    private a cnp;

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

    public a akx() {
        return this.cnp;
    }

    void a(a aVar) {
        this.cnp = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b cnq;
        protected final h cnr;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cnr = bS(context);
            this.cnr.a(this);
            this.cnq = new b((ViewGroup) this.cnr.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h bS(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ap(View view) {
            this.cnq.mDialogContent.removeAllViews();
            this.cnq.mDialogContent.addView(view);
            return this;
        }

        public h akp() {
            this.cnr.setOnCancelListener(this.cnq.mOnCancelListener);
            this.cnr.setOnDismissListener(this.cnq.mOnDismissListener);
            this.cnr.setOnShowListener(this.cnq.mOnShowListener);
            this.cnr.a(this);
            return this.cnr;
        }

        public h aky() {
            h akp = akp();
            if (this.mSystemDialog) {
                akp.getWindow().setType(2003);
            }
            try {
                akp.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return akp;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cnq.mPositiveButton.setText(charSequence);
            this.cnq.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cnr.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cnr, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cnq.mNegativeButton.setText(charSequence);
            this.cnq.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cnr.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cnr, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cnq.mOnCancelListener = onCancelListener;
            return this;
        }

        public a eG(boolean z) {
            this.cnr.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout cnj;
        public FrameLayout cnk;
        public View cnl;
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
            this.cnk = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cnj = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cnl = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
