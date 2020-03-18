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
    private a bOy;

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

    public a act() {
        return this.bOy;
    }

    void a(a aVar) {
        this.bOy = aVar;
    }

    /* loaded from: classes11.dex */
    public static class a {
        protected final h bOA;
        protected final b bOz;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bOA = cq(context);
            this.bOA.a(this);
            this.bOz = new b((ViewGroup) this.bOA.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cq(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ao(View view) {
            this.bOz.mDialogContent.removeAllViews();
            this.bOz.mDialogContent.addView(view);
            return this;
        }

        public h acl() {
            this.bOA.setOnCancelListener(this.bOz.mOnCancelListener);
            this.bOA.setOnDismissListener(this.bOz.mOnDismissListener);
            this.bOA.setOnShowListener(this.bOz.mOnShowListener);
            this.bOA.a(this);
            return this.bOA;
        }

        public h acu() {
            h acl = acl();
            if (this.mSystemDialog) {
                acl.getWindow().setType(2003);
            }
            try {
                acl.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return acl;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOz.mPositiveButton.setText(charSequence);
            this.bOz.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOA.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOA, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bOz.mNegativeButton.setText(charSequence);
            this.bOz.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOA.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bOA, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.bOz.mOnCancelListener = onCancelListener;
            return this;
        }

        public a dK(boolean z) {
            this.bOA.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public FrameLayout bOs;
        public FrameLayout bOt;
        public View bOu;
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
            this.bOt = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bOs = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bOu = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
