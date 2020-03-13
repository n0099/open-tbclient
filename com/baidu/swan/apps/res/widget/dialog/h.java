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
    private a bOn;

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

    public a acq() {
        return this.bOn;
    }

    void a(a aVar) {
        this.bOn = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b bOo;
        protected final h bOp;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bOp = cr(context);
            this.bOp.a(this);
            this.bOo = new b((ViewGroup) this.bOp.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cr(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ao(View view) {
            this.bOo.mDialogContent.removeAllViews();
            this.bOo.mDialogContent.addView(view);
            return this;
        }

        public h aci() {
            this.bOp.setOnCancelListener(this.bOo.mOnCancelListener);
            this.bOp.setOnDismissListener(this.bOo.mOnDismissListener);
            this.bOp.setOnShowListener(this.bOo.mOnShowListener);
            this.bOp.a(this);
            return this.bOp;
        }

        public h acr() {
            h aci = aci();
            if (this.mSystemDialog) {
                aci.getWindow().setType(2003);
            }
            try {
                aci.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return aci;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOo.mPositiveButton.setText(charSequence);
            this.bOo.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOp.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOp, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOo.mNegativeButton.setText(charSequence);
            this.bOo.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOp.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOp, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.bOo.mOnCancelListener = onCancelListener;
            return this;
        }

        public a dJ(boolean z) {
            this.bOp.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout bOh;
        public FrameLayout bOi;
        public View bOj;
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
            this.bOi = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOh = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOj = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
