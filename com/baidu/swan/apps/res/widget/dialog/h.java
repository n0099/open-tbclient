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
    private a cnj;

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

    public a aky() {
        return this.cnj;
    }

    void a(a aVar) {
        this.cnj = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final b cnk;
        protected final h cnl;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.cnl = ce(context);
            this.cnl.a(this);
            this.cnk = new b((ViewGroup) this.cnl.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h ce(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ap(View view) {
            this.cnk.mDialogContent.removeAllViews();
            this.cnk.mDialogContent.addView(view);
            return this;
        }

        public h akq() {
            this.cnl.setOnCancelListener(this.cnk.mOnCancelListener);
            this.cnl.setOnDismissListener(this.cnk.mOnDismissListener);
            this.cnl.setOnShowListener(this.cnk.mOnShowListener);
            this.cnl.a(this);
            return this.cnl;
        }

        public h akz() {
            h akq = akq();
            if (this.mSystemDialog) {
                akq.getWindow().setType(2003);
            }
            try {
                akq.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return akq;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cnk.mPositiveButton.setText(charSequence);
            this.cnk.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cnl.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cnl, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.cnk.mNegativeButton.setText(charSequence);
            this.cnk.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cnl.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.cnl, -2);
                    }
                }
            });
            return this;
        }

        public a b(DialogInterface.OnCancelListener onCancelListener) {
            this.cnk.mOnCancelListener = onCancelListener;
            return this;
        }

        public a eG(boolean z) {
            this.cnl.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout cnd;
        public FrameLayout cne;
        public View cnf;
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
            this.cne = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.cnd = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.cnf = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
