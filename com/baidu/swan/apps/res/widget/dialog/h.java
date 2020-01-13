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
/* loaded from: classes10.dex */
public class h extends c {
    private a bKg;

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

    public a aaa() {
        return this.bKg;
    }

    void a(a aVar) {
        this.bKg = aVar;
    }

    /* loaded from: classes10.dex */
    public static class a {
        protected final b bKh;
        protected final h bKi;
        private Context mContext;
        private boolean mSystemDialog = false;

        public a(Context context) {
            this.bKi = cn(context);
            this.bKi.a(this);
            this.bKh = new b((ViewGroup) this.bKi.getWindow().getDecorView());
            this.mContext = context;
        }

        protected h cn(Context context) {
            return new h(context, a.i.NoTitleDialog);
        }

        public a ao(View view) {
            this.bKh.mDialogContent.removeAllViews();
            this.bKh.mDialogContent.addView(view);
            return this;
        }

        public h ZS() {
            this.bKi.setOnCancelListener(this.bKh.mOnCancelListener);
            this.bKi.setOnDismissListener(this.bKh.mOnDismissListener);
            this.bKi.setOnShowListener(this.bKh.mOnShowListener);
            this.bKi.a(this);
            return this.bKi;
        }

        public h aab() {
            h ZS = ZS();
            if (this.mSystemDialog) {
                ZS.getWindow().setType(2003);
            }
            try {
                ZS.show();
            } catch (WindowManager.BadTokenException e) {
            }
            return ZS;
        }

        public a f(int i, DialogInterface.OnClickListener onClickListener) {
            return d(this.mContext.getText(i), onClickListener);
        }

        public a d(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bKh.mPositiveButton.setText(charSequence);
            this.bKh.mPositiveButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bKi.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bKi, -1);
                    }
                }
            });
            return this;
        }

        public a g(int i, DialogInterface.OnClickListener onClickListener) {
            return e(this.mContext.getText(i), onClickListener);
        }

        public a e(CharSequence charSequence, final DialogInterface.OnClickListener onClickListener) {
            this.bKh.mNegativeButton.setText(charSequence);
            this.bKh.mNegativeButton.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.res.widget.dialog.h.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bKi.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(a.this.bKi, -2);
                    }
                }
            });
            return this;
        }

        public a c(DialogInterface.OnCancelListener onCancelListener) {
            this.bKh.mOnCancelListener = onCancelListener;
            return this;
        }

        public a dC(boolean z) {
            this.bKi.setCanceledOnTouchOutside(z);
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public FrameLayout bKa;
        public FrameLayout bKb;
        public View bKc;
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
            this.bKb = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.mPositiveButton = (TextView) viewGroup.findViewById(a.f.positive_button);
            this.mNegativeButton = (TextView) viewGroup.findViewById(a.f.negative_button);
            this.mDialogContentPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.mDialogContent = (FrameLayout) viewGroup.findViewById(a.f.dialog_custom_content);
            this.mDialogLayout = (RelativeLayout) viewGroup.findViewById(a.f.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) viewGroup.findViewById(a.f.btn_panel);
            this.mCustomPanel = viewGroup.findViewById(a.f.dialog_customPanel);
            this.bKa = (FrameLayout) viewGroup.findViewById(a.f.dialog_root);
            this.bKc = viewGroup.findViewById(a.f.nightmode_mask);
        }
    }
}
